package br.com.itbeta.newlife.services;

import br.com.itbeta.newlife.controller.dto.FuncionarioDto;
import br.com.itbeta.newlife.model.Funcionario;
import br.com.itbeta.newlife.repository.FuncionarioRepository;
import br.com.itbeta.newlife.repository.specification.FuncionarioSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class FuncionarioService {
    private final FuncionarioRepository repository;

    public FuncionarioDto findById(Long idFuncionario){
        Funcionario f = this.repository.findById(idFuncionario).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new FuncionarioDto(f);
    }

    public void createFuncionario(FuncionarioDto dto){
        Funcionario f = new Funcionario(dto);
        this.repository.save(f);
    }

    public void updateFuncionario(Long idFuncionario, FuncionarioDto dto){
        Funcionario f = this.repository.findById(idFuncionario).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        f.update(dto);
        repository.save(f);
    }

    public void deleteFuncionario(Long idFuncionario){
        Funcionario f = this.repository.findById(idFuncionario).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(f);
    }

    public Page<Funcionario> findAll(Pageable pageable){
        return this.repository.findAll(pageable);
    }

    public Page<Funcionario> findAll(Pageable pageable, String query){
        return this.repository.findAll(FuncionarioSpecifications.likeGenericQuery(query), pageable);
    }

}
