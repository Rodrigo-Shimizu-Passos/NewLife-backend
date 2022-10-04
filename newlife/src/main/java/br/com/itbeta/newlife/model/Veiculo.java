package br.com.itbeta.newlife.model;

import br.com.itbeta.newlife.controller.dto.VeiculoDto;
import br.com.itbeta.newlife.controller.form.VeiculoForm;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
@Builder
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
    //@OnDelete(action = OnDeleteAction.CASCADE)
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

    public Veiculo(VeiculoForm form) {
        //this.idApto = form.getIdApto();
        this.placa = form.getPlaca();
        this.marca = form.getMarca();
        this.modelo = form.getModelo();
        this.cor = form.getCor();
    }

    public void update(VeiculoForm form){
       //this.idApto = form.getIdApto();
        this.placa = form.getPlaca();
        this.marca = form.getMarca();
        this.modelo = form.getModelo();
        this.cor = form.getCor();
    }

    public void addApartamentos(Apartamento idApto){
        this.idApto = idApto;
    }
}
