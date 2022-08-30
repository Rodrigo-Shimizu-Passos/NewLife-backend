package br.com.itbeta.newlife.model;

import br.com.itbeta.newlife.controller.dto.VeiculoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Veiculo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVeiculo")
    private Long idVeiculo;
    @ManyToOne
    @JoinColumn(name = "idApto")
    private Apartamento idApto;
    @Column(name = "placa")
    private String placa;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "cor")
    private String cor;

    public Veiculo(VeiculoDto dto) {
        this.idApto = dto.getIdApto();
        this.placa = dto.getPlaca();
        this.marca = dto.getMarca();
        this.modelo = dto.getModelo();
        this.cor = dto.getCor();
    }

    public void update(VeiculoDto dto){
        this.idApto = dto.getIdApto();
        this.placa = dto.getPlaca();
        this.marca = dto.getMarca();
        this.modelo = dto.getModelo();
        this.cor = dto.getCor();
    }
}
