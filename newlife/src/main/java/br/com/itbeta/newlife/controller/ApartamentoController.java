package br.com.itbeta.newlife.controller;

import br.com.itbeta.newlife.controller.dto.ApartamentoDto;
import br.com.itbeta.newlife.controller.dto.FuncionarioDto;
import br.com.itbeta.newlife.controller.form.ApartamentoForm;
import br.com.itbeta.newlife.conversor.EntityToDto;
import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.repository.ApartamentoRepository;
import br.com.itbeta.newlife.repository.projections.AptoDetails;
import br.com.itbeta.newlife.services.ApartamentoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apartamentos")
@AllArgsConstructor
public class ApartamentoController {

    private final ApartamentoService service;
    private final ConversionService conversionService;

    @GetMapping("/allPaginated")
    public @ResponseBody Page<ApartamentoDto> findAllPaginated(@RequestParam(required = false) String query, Pageable pageable){
        //if (query==null){
            return this.service.findAllPaginated(pageable).map(entity-> this.conversionService.convert(entity, ApartamentoDto.class));
        }
        //return this.service.findAll(pageable, query).map(entity->this.conversionService.convert(entity, ApartamentoDto.class));
    //}

    @GetMapping("/all")
    public @ResponseBody List<AptoDetails> findAll(){
        return this.service.findAll();
    }

    @GetMapping("/{idApto}")
    public ResponseEntity<ApartamentoDto> getById(@PathVariable Long idApto){
        ApartamentoDto dto = this.service.findById(idApto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> createApartamento (@RequestBody ApartamentoForm form){
        this.service.createApartamento(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{idApto}")
    @Transactional
    public ResponseEntity<?> updateApartamento(@PathVariable Long idApto, @RequestBody ApartamentoForm form){
        this.service.updateApartamento(idApto, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{idApto}")
    public ResponseEntity<?> deleteApartamento(@PathVariable Long idApto){
        this.service.deleteApartamento(idApto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
