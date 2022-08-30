package br.com.itbeta.newlife.model;

import br.com.itbeta.newlife.controller.dto.ApartamentoDto;
import br.com.itbeta.newlife.controller.form.ApartamentoForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Apartamento")
@NoArgsConstructor
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

    public void update(ApartamentoDto dto){
        this.numeroApto=dto.getNumeroApto();
    }

    public Apartamento(ApartamentoDto dto){
        this.numeroApto = dto.getNumeroApto();
    }

}
