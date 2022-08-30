package br.com.itbeta.newlife.model;

import br.com.itbeta.newlife.controller.dto.MoradorDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    public Morador(MoradorDto dto) {
        this.idApto = dto.getIdApto();
        this.nome = dto.getNome();
        this.rg = dto.getRg();
        this.cpf = dto.getCpf();
        this.telefone1 = dto.getTelefone1();
        this.telefone2 = dto.getTelefone2();
        this.email = dto.getEmail();
        this.contatoEmerg = dto.getContatoEmerg();
        this.telefoneEmerg = dto.getTelefoneEmerg();
        this.obs = dto.getObs();
    }

    public void update(MoradorDto dto){
        this.idApto = dto.getIdApto();
        this.nome = dto.getNome();
        this.rg = dto.getRg();
        this.cpf = dto.getCpf();
        this.telefone1 = dto.getTelefone1();
        this.telefone2 = dto.getTelefone2();
        this.email = dto.getEmail();
        this.contatoEmerg = dto.getContatoEmerg();
        this.telefoneEmerg = dto.getTelefoneEmerg();
        this.obs = dto.getObs();
    }
}

