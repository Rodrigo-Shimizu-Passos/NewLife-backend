package br.com.itbeta.newlife.repository;

import br.com.itbeta.newlife.controller.dto.MoradorDto;
import br.com.itbeta.newlife.controller.form.MoradorForm;
import br.com.itbeta.newlife.model.Morador;
import br.com.itbeta.newlife.repository.projections.AptoDetails;
import br.com.itbeta.newlife.repository.projections.MoradorDetails;
import br.com.itbeta.newlife.repository.specification.MoradorSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> , JpaSpecificationExecutor<Morador> {
    @Query(value = "select Apartamento.numeroApto as idApto, Morador.nome, Morador.rg, Morador.cpf, Morador.telefone1, \n" +
            "Morador.telefone2, Morador.email, Morador.contatoEmerg, Morador.telefoneEmerg, Morador.obs\n" +
            "FROM Morador\n" +
            "JOIN Apartamento ON Morador.idApto = Apartamento.idApto ORDER BY Apartamento.numeroApto ASC", nativeQuery = true)
    List<MoradorDetails> findAllList();

    @Query(value = "select Apartamento.numeroApto as idApto, Morador.nome, Morador.rg, Morador.cpf, Morador.telefone1, \n" +
            "Morador.telefone2, Morador.email, Morador.contatoEmerg, Morador.TelefoneEmerg, Morador.obs\n" +
            "FROM Morador\n" +
            "JOIN Apartamento ON Morador.idApto = Apartamento.idApto WHERE (Morador.nome like %:query%) or (Morador.cpf like %:query%) ORDER BY Apartamento.numeroApto ASC", nativeQuery = true)
    List<MoradorDetails> findAllList(@Nullable String query);
}
