package br.com.itbeta.newlife.model;

import br.com.itbeta.newlife.controller.dto.VisitanteDto;
import br.com.itbeta.newlife.controller.form.VisitanteForm;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Builder
@Entity
@Table(name = "Visitante")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Visitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVisitante")
    private Long idVisitante;
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

    public Visitante(VisitanteForm form) {
        //this.idApto = form.getIdApto();
        this.nome = form.getNome();
        this.rg = form.getRg();
        this.cpf = form.getCpf();
        this.telefone1 = form.getTelefone1();
        this.telefone2 = form.getTelefone2();
        this.obs = form.getObs();
    }

    public void update(VisitanteForm form){
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
