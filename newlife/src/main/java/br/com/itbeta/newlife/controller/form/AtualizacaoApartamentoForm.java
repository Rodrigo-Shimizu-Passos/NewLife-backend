package br.com.itbeta.newlife.controller.form;

import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.repository.ApartamentoRepository;

public class AtualizacaoApartamentoForm {

    private Long numeroApto;

    public Long getNumeroApto() {
        return numeroApto;
    }

    public void setNumeroApto(Long numeroApto) {
        this.numeroApto = numeroApto;
    }

    public Apartamento atualizar(Long idApto, ApartamentoRepository apartamentoRepository){
        Apartamento apartamento = apartamentoRepository.getById(idApto);
        apartamento.setNumeroApto(this.numeroApto);
        return apartamento;
    }
}
