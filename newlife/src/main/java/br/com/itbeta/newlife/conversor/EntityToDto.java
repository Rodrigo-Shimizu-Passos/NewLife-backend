package br.com.itbeta.newlife.conversor;

import br.com.itbeta.newlife.controller.dto.ApartamentoDto;
import br.com.itbeta.newlife.controller.dto.AptoLessDetailDto;
import br.com.itbeta.newlife.model.Apartamento;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;


@Component
public class EntityToDto {
    public ApartamentoDto conversor(Apartamento a){
        return new ApartamentoDto(a);
    }
}
