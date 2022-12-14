package br.com.itbeta.newlife.controller.dto;

import br.com.itbeta.newlife.model.Apartamento;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApartamentoDto {

    private Long idApto;
    private Long numeroApto;

    public ApartamentoDto(Apartamento apartamento){
        this.idApto=apartamento.getIdApto();
        this.numeroApto= apartamento.getNumeroApto();
    }

}
