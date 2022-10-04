package br.com.itbeta.newlife.controller.dto;

import br.com.itbeta.newlife.model.Apartamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AptoLessDetailDto {
    private Long numeroApto;

    public AptoLessDetailDto(Apartamento apartamento){
        this.numeroApto= apartamento.getNumeroApto();
    }
}
