package br.com.itbeta.newlife.repository;

import br.com.itbeta.newlife.controller.dto.ApartamentoDto;
import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.repository.projections.AptoDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> , JpaSpecificationExecutor<Apartamento> {
    @Query(value = "select numeroApto from Apartamento", nativeQuery = true)
    public Page<AptoDetails> findAllApto(Pageable pageable);

    @Query(value = "select * from Apartamento", nativeQuery = true)
    List<AptoDetails> findAllAptos();
}
