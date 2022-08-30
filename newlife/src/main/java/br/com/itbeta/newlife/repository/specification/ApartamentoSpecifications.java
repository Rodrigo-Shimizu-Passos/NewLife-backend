package br.com.itbeta.newlife.repository.specification;

import br.com.itbeta.newlife.model.Apartamento;
import br.com.itbeta.newlife.model.Apartamento_;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

public class ApartamentoSpecifications {
    public static Specification<Apartamento> numeroAptoEquals(Long info){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Apartamento_.numeroApto), info));
    }

    public static Specification<Apartamento> likeGenericQuery(String queryString){
        return ((root, query, criteriaBuilder) -> {
           List<Predicate> predicates = new ArrayList<>(2);
           return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        });
    }
}
