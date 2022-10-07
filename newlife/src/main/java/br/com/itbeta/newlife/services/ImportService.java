package br.com.itbeta.newlife.services;

import br.com.itbeta.newlife.controller.dto.MoradorRow;
import br.com.itbeta.newlife.exception.SheetImportException;
import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.model.Morador;
import br.com.itbeta.newlife.repository.ApartamentoRepository;
import br.com.itbeta.newlife.repository.MoradorRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;
import org.xml.sax.SAXException;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImportService {

    private List<Apartamento> apartamentoList = new ArrayList<>();

    private final ApartamentoRepository apartamentoRepository;

    private final MoradorRepository moradorRepository;

    public void importSheet(
            InputStream inputStream
    ) throws IOException,
            SAXException,
            OpenXML4JException{
            List<MoradorRow> moradorRows = this.parseSheet(inputStream);
            this.registerMoradores(moradorRows);
    }

    public List<MoradorRow> parseSheet(InputStream inputStream)
            throws IOException,SAXException, OpenXML4JException {
        this.apartamentoList = this.apartamentoRepository.findAll();
        OPCPackage pkg = OPCPackage.open(inputStream);
        SheetParser<List<MoradorRow>> sheetParser = new SheetParser<>(pkg,10,rowInfo->{
            String[] row = rowInfo.row;
            ArrayList<MoradorRow> rows = new ArrayList<>();
                MoradorRow moradorRow = MoradorRow
                        .builder()
                        .rowNumber(rowInfo.rowNumber)
                        .apartamento(this.getApto(row[0],rowInfo.rowNumber))
                        .nome(row[1])
                        .rg(row[2])
                        .cpf(row[3])
                        .telefone1(row[4])
                        .telefone2(row[5])
                        .email(row[6])
                        .contatoEmerg(row[7])
                        .telefoneEmerg(row[8])
                        .obs(row[9])
                        .build();
                rows.add(moradorRow);
                return rows;
        });
//
//        Map<Boolean, List<MoradorRow>> rows = sheetParser
//                .process()
//                .flatMap(Collection::stream)
//                .collect(Collectors.groupingBy(row -> row.hasError));
//        List<MoradorRow> wrongRows = rows.get(true);
//        List<MoradorRow> rightRows = rows.get(false);
//        if(wrongRows!= null && wrongRows.size() > 0){
//            for(MoradorRow mr : wrongRows){
//                if(StringUtils.hasText(mr.errorText)){
//                   throw new SheetImportException(mr.errorText);
//                }
//            }
//            throw new SheetImportException("Importação Falhou: Erro desconhecido");
//        }else {
//            return rightRows;
//        }
        List<MoradorRow> rows = sheetParser.process().flatMap(Collection::stream).collect(Collectors.toList());
        return rows;
    }

    public void registerMoradores(List<MoradorRow> moradorRows){
        int moradorSize = moradorRows.size();

        ArrayList<Morador> allMoradores = new ArrayList<>(moradorSize);

        for(MoradorRow moradorRow: moradorRows){
            Morador morador = Morador.builder()
                    .idApto(moradorRow.apartamento)
                    .nome(moradorRow.nome)
                    .rg(moradorRow.rg)
                    .cpf(moradorRow.cpf)
                    .telefone1(moradorRow.telefone1)
                    .telefone2(moradorRow.telefone2)
                    .email(moradorRow.email)
                    .contatoEmerg(moradorRow.contatoEmerg)
                    .telefoneEmerg(moradorRow.telefoneEmerg)
                    .obs(moradorRow.obs)
                    .build();
            allMoradores.add(morador);
        }
        List<Morador> moradores = this.moradorRepository.saveAll(allMoradores);
    }

    public Apartamento getApto(String numeroApto, int rowNumber){
        for(Apartamento apartamento : this.apartamentoList){
            if(numeroApto!=null) {
                if (apartamento.getNumeroApto() == Long.parseLong(numeroApto)) {
                    return apartamento;
                }
            }else{
                throw new SheetImportException("O campo Apartamento deve ser preenchido! Falha na linha: "+(rowNumber+1));
            }
        }

        throw new SheetImportException("O apartamento não existe! Falha na linha: "+(rowNumber+1));
    }
}
