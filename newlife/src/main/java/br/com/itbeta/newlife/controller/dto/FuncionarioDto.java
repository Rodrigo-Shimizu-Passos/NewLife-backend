package br.com.itbeta.newlife.controller.dto;

import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;

@Getter
@AllArgsConstructor
public class FuncionarioDto {
    private Long idFuncionario;
    private Apartamento idApto;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone1;
    private String telefone2;
    private String obs;

    public FuncionarioDto(Funcionario funcionario){
        this.idFuncionario=funcionario.getIdFuncionario();
        this.idApto=funcionario.getIdApto();
        this.rg= funcionario.getRg();
        this.cpf=funcionario.getCpf();
        this.nome= funcionario.getNome();
        this.telefone1= funcionario.getTelefone1();
        this.telefone2= funcionario.getTelefone2();
    }
}
