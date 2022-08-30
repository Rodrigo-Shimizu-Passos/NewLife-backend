package br.com.itbeta.newlife.repository.specification;

import br.com.itbeta.newlife.model.Funcionario;
import br.com.itbeta.newlife.model.Funcionario_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioSpecifications {
    public static Specification<Funcionario> nomeLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Funcionario_.nome), "%" + info + "%");
    }

    public static Specification<Funcionario> cpfLike(String info) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Funcionario_.cpf), "%" + info + "%");
    }

    public static Specification<Funcionario> likeGenericQuery(String queryString){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(3);
            predicates.add(nomeLike(queryString).toPredicate(root, query, criteriaBuilder));
            predicates.add(cpfLike(queryString).toPredicate(root, query, criteriaBuilder));
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
}

