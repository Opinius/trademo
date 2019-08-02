package com.alexeus.trademo.dao;

import com.alexeus.trademo.domain.FactoryObject;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public class FactoryObjectsSearchRepositoryImpl implements FactoryObjectsSearchRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<FactoryObject> findObjects(Map<String, String[]> params) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FactoryObject> query = cb.createQuery(FactoryObject.class);
        Root<FactoryObject> user = query.from(FactoryObject.class);

        List<Predicate> predicates = new ArrayList<>();
        for (Map.Entry<String, String[]> entry: params.entrySet()) {
            //if (entry.getValue() instanceof String) {
                predicates.add(cb.like(user.get(entry.getKey()), "%" + entry.getValue()[0] + "%"));
            //} else {
            //    predicates.add(cb.equal(user.get(entry.getKey()), entry.getValue()));
            //}
        }
        query.select(user)
                .where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query)
                .getResultList();
    }
}
