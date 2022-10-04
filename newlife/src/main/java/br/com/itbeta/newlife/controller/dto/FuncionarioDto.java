package br.com.itbeta.newlife.controller.dto;

import br.com.itbeta.newlife.conversor.EntityToDto;
import br.com.itbeta.newlife.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.convert.ConversionService;

@Getter
@AllArgsConstructor
public class FuncionarioDto {
    private Long idFuncionario;
    private ApartamentoDto idApto;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone1;
    private String telefone2;
    private String obs;


    public FuncionarioDto(Funcionario funcionario){
        EntityToDto entityToDto = new EntityToDto();
        this.idFuncionario=funcionario.getIdFuncionario();
        this.idApto= entityToDto.conversor(funcionario.getIdApto());
        this.rg= funcionario.getRg();
        this.cpf=funcionario.getCpf();
        this.nome= funcionario.getNome();
        this.telefone1= funcionario.getTelefone1();
        this.telefone2= funcionario.getTelefone2();
        this.obs=funcionario.getObs();
    }
}
