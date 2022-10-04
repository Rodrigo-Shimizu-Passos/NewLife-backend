package br.com.itbeta.newlife.repository.specification;

import br.com.itbeta.newlife.model.Visitante;
import br.com.itbeta.newlife.model.Visitante_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class VisitanteSpecifications {
    public static Specification<Visitante> nomeLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Visitante_.nome), "%" + info + "%");
    }

    public static Specification<Visitante> cpfLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Visitante_.cpf), "%" + info + "%");
    }

    public static Specification<Visitante> likeGenericQuery(String queryString){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(3);
            predicates.add(nomeLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(cpfLike(queryString).toPredicate(root, query, criteriaBuilder));
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
}
