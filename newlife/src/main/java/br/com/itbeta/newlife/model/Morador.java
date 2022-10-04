package br.com.itbeta.newlife.model;

import br.com.itbeta.newlife.controller.dto.MoradorDto;
import br.com.itbeta.newlife.controller.form.MoradorForm;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Builder
@Entity
@Table(name = "Morador")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Morador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMorador")
    private Long idMorador;
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
    @Column(name = "email")
    private String email;
    @Column(name = "contatoEmerg")
    private String contatoEmerg;
    @Column(name = "telefoneEmerg")
    private String telefoneEmerg;
    @Column(name = "obs")
    private String obs;

    public Morador(MoradorForm form) {
        //this.idApto = form.getIdApto();
        this.nome = form.getNome();
        this.rg = form.getRg();
        this.cpf = form.getCpf();
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.email = form.getEmail();
        this.contatoEmerg = form.getContatoEmerg();
        this.telefoneEmerg = form.getTelefoneEmerg();
        this.obs = form.getObs();
    }

    public void update(MoradorForm form){
        //this.idApto.setIdApto(form.getIdApto());
        this.nome = form.getNome();
        this.rg = form.getRg();
        this.cpf = form.getCpf();
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.email = form.getEmail();
        this.contatoEmerg = form.getContatoEmerg();
        this.telefoneEmerg = form.getTelefoneEmerg();
        this.obs = form.getObs();
    }

    public void addApartamentos(Apartamento idApto){
        this.idApto = idApto;
    }
}

