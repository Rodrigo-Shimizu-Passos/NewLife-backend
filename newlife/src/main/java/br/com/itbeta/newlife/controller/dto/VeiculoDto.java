package br.com.itbeta.newlife.controller.dto;

import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@AllArgsConstructor
public class VeiculoDto {
    private Long idVeiculo;
    private Apartamento idApto;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;

    public VeiculoDto(Veiculo veiculo){
        this.idVeiculo=veiculo.getIdVeiculo();
        this.idApto=veiculo.getIdApto();
        this.placa=veiculo.getPlaca();
        this.marca=veiculo.getMarca();
        this.modelo=veiculo.getModelo();
        this.cor=veiculo.getCor();
    }
}
