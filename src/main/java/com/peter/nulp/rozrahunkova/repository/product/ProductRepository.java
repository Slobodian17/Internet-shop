package com.peter.nulp.rozrahunkova.repository.product;

import com.peter.nulp.rozrahunkova.model.product.Product;
import com.peter.nulp.rozrahunkova.repository.BaseFinder;
import com.peter.nulp.rozrahunkova.repository.interfaces.IProductRepository;
import com.peter.nulp.rozrahunkova.service.parameter.IMapParams;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ProductRepository extends IProductRepository {


    @Override
    public void add(Product model) {
        list.add(model);
        model.setId(idCounter++);
    }

    @Override
    public void remove(Product model) {
        list.remove(model);
    }

    public Product findOne(Class<? extends BaseFinder<Product>> tClass, IMapParams params){
        return findAll(tClass, params)
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> findAll(Class<? extends BaseFinder<Product>> tClass, IMapParams params) {
        List<Product> products = List.of();
        try {
            BaseFinder<Product> finder = tClass.getDeclaredConstructor().newInstance();
            finder.setList(list);
            finder.setMapParams(params);
            products = finder.find();
        }catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        return products;
    }

}
