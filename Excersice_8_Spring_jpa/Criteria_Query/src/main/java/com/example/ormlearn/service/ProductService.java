package com.example.ormlearn.service;

import com.example.ormlearn.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> searchProducts(String os, Double ram, Double cpuSpeed,
                                        String cpu, Double weight, Integer rating) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (os != null) predicates.add(cb.equal(root.get("os"), os));
        if (ram != null) predicates.add(cb.equal(root.get("ram"), ram));
        if (cpuSpeed != null) predicates.add(cb.greaterThanOrEqualTo(root.get("cpuSpeed"), cpuSpeed));
        if (cpu != null) predicates.add(cb.equal(root.get("cpu"), cpu));
        if (weight != null) predicates.add(cb.lessThan(root.get("weight"), weight));
        if (rating != null) predicates.add(cb.greaterThanOrEqualTo(root.get("rating"), rating));

        cq.select(root).where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(cq).getResultList();
    }
}