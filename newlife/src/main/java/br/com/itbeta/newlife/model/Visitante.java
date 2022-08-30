package br.com.itbeta.newlife.model;

import br.com.itbeta.newlife.controller.dto.VisitanteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    public Visitante(VisitanteDto dto) {
        this.idApto = dto.getIdApto();
        this.nome = dto.getNome();
        this.rg = dto.getRg();
        this.cpf = dto.getCpf();
        this.telefone1 = dto.getTelefone1();
        this.telefone2 = dto.getTelefone2();
        this.obs = dto.getObs();
    }

    public void update(VisitanteDto dto){
        this.idApto = dto.getIdApto();
        this.nome = dto.getNome();
        this.rg = dto.getRg();
        this.cpf = dto.getCpf();
        this.telefone1 = dto.getTelefone1();
        this.telefone2 = dto.getTelefone2();
        this.obs = dto.getObs();
    }
}
