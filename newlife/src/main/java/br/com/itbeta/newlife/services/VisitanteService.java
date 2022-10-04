package br.com.itbeta.newlife.services;

import br.com.itbeta.newlife.controller.dto.VisitanteDto;
import br.com.itbeta.newlife.controller.form.VisitanteForm;
import br.com.itbeta.newlife.model.Funcionario;
import br.com.itbeta.newlife.model.Visitante;
import br.com.itbeta.newlife.repository.ApartamentoRepository;
import br.com.itbeta.newlife.repository.VisitanteRepository;
import br.com.itbeta.newlife.repository.specification.VisitanteSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class VisitanteService {
    private final VisitanteRepository repository;

    private final ApartamentoRepository apartamentoRepository;

    public VisitanteForm findById(Long id){
        Visitante v =this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new VisitanteForm(v);
    }

    public void createVisitante(VisitanteForm form){
        Visitante v = Visitante
                .builder()
                .nome(form.getNome())
                .rg(form.getRg())
                .cpf(form.getCpf())
                .telefone1(form.getTelefone1())
                .telefone2(form.getTelefone2())
                .obs(form.getObs())
                .build();
        v.addApartamentos(this.apartamentoRepository.findById(form.getIdApto()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        this.repository.save(v);
    }

    public void updateVisitante(Long id, VisitanteForm form){
        Visitante v =this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        v.addApartamentos(this.apartamentoRepository.findById(form.getIdApto()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        v.update(form);
        repository.save(v);
    }

    public void deleteVisitante(Long id){
        Visitante v=this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(v);
    }

    public Page<Visitante> findAll(Pageable pageable){
        return this.repository.findAll(pageable);
    }

    public Page<Visitante> findAll(Pageable pageable, String query){
        return this.repository.findAll(VisitanteSpecifications.likeGenericQuery(query), pageable);
    }
}
