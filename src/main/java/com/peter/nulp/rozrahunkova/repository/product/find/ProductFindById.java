package com.peter.nulp.rozrahunkova.repository.product.find;

import com.peter.nulp.rozrahunkova.model.product.Product;
import com.peter.nulp.rozrahunkova.repository.BaseFinder;

import java.util.function.Predicate;

public class ProductFindById extends BaseFinder<Product> {

    @Override
    public Predicate<Product> getPredicate() {
        return product -> (product.getId() == mapParams.getInt("id"));
    }
}
