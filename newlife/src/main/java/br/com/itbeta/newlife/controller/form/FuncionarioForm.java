package br.com.itbeta.newlife.controller.form;

import br.com.itbeta.newlife.conversor.EntityToDto;
import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FuncionarioForm {
    private Long idApto;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone1;
    private String telefone2;
    private String obs;

    public FuncionarioForm(Funcionario funcionario){
        this.idApto= funcionario.getIdApto().getIdApto();
        this.rg= funcionario.getRg();
        this.cpf=funcionario.getCpf();
        this.nome= funcionario.getNome();
        this.telefone1= funcionario.getTelefone1();
        this.telefone2= funcionario.getTelefone2();
        this.obs=funcionario.getObs();
    }
}
