package br.com.itbeta.newlife.model;

import br.com.itbeta.newlife.controller.dto.ApartamentoDto;
import br.com.itbeta.newlife.controller.dto.AptoLessDetailDto;
import br.com.itbeta.newlife.controller.form.ApartamentoForm;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Apartamento")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Apartamento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "idApto")
    private Long idApto;
    @Column(name= "numeroApto")
    private Long numeroApto;

    //@Builder.Default
    //@OneToMany(mappedBy = "idApto", cascade = CascadeType.ALL,orphanRemoval = true)// especifica as ligações dentro do java
    //Set<Morador> moradores = new HashSet<>();

//    @Builder.Default
//    @OneToMany(mappedBy = "idApto", cascade = CascadeType.ALL,orphanRemoval = true)// especifica as ligações dentro do java
//    Set<Funcionario> funcionarios = new HashSet<>();
//
//    @Builder.Default
//    @OneToMany(mappedBy = "idApto", cascade = CascadeType.ALL,orphanRemoval = true)// especifica as ligações dentro do java
//    Set<Veiculo> veiculos = new HashSet<>();
//
//    @Builder.Default
//    @OneToMany(mappedBy = "idApto", cascade = CascadeType.ALL,orphanRemoval = true)// especifica as ligações dentro do java
//    Set<Visitante> visitantes = new HashSet<>();

    public void update(ApartamentoForm form){
        this.numeroApto=form.getNumeroApto();
    }

    public Apartamento(ApartamentoForm form){
        this.numeroApto = form.getNumeroApto();
    }

}
