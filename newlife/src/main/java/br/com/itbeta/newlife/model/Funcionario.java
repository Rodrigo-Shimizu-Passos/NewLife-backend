package br.com.itbeta.newlife.model;

import br.com.itbeta.newlife.controller.dto.FuncionarioDto;
import br.com.itbeta.newlife.controller.form.FuncionarioForm;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.core.convert.ConversionService;

import javax.persistence.*;
@Builder
@Entity
@Table(name = "Funcionario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFuncionario")
    private Long idFuncionario;
    @ManyToOne
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idApto")
    private Apartamento idApto;
    @Column(name = "nome")
    private String nome;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "telefone1")
    private String telefone1;
    @Column(name = "telefone2")
    private String telefone2;
    @Column(name = "obs")
    private String obs;

    public Funcionario(FuncionarioForm form) {
        //this.idApto = form.getIdApto();
        this.nome = form.getNome();
        this.rg = form.getRg();
        this.cpf = form.getCpf();
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.obs = form.getObs();
    }

    public void update(FuncionarioForm form){
        //this.idApto = form.getIdApto();
        this.nome = form.getNome();
        this.rg = form.getRg();
        this.cpf = form.getCpf();
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.obs = form.getObs();
    }

    public void addApartamentos(Apartamento idApto){
        this.idApto = idApto;
    }

}
