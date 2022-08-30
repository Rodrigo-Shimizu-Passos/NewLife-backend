package br.com.itbeta.newlife.services;

import br.com.itbeta.newlife.controller.dto.ApartamentoDto;
import br.com.itbeta.newlife.controller.form.ApartamentoForm;
import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.repository.ApartamentoRepository;
import br.com.itbeta.newlife.repository.specification.ApartamentoSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApartamentoService {
    private final ApartamentoRepository repository;
    public ApartamentoDto findById(Long idApto){
        Apartamento a = this.repository.findById(idApto).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ApartamentoDto(a);
    }

    public void createApartamento (ApartamentoDto dto){
        Apartamento a=new Apartamento(dto);
        this.repository.save(a);
    }

    public void updateApartamento(Long idApto, ApartamentoDto dto){
        Apartamento a = this.repository.findById(idApto).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        a.update(dto);
        repository.save(a);
    }

    public void deleteApartamento(Long idApto){
        Apartamento a = this.repository.findById(idApto).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(a);
    }

    public Page<Apartamento> findAll(Pageable pageable){
        return this.repository.findAll(pageable);
    }

    public Page<Apartamento> findAll(Pageable pageable, String query){
        return this.repository.findAll(ApartamentoSpecifications.likeGenericQuery(query), pageable);
    }

}
