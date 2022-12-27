package com.peter.nulp.rozrahunkova.repository.purchase;

import com.peter.nulp.rozrahunkova.model.purchase.Purchase;
import com.peter.nulp.rozrahunkova.repository.BaseFinder;
import com.peter.nulp.rozrahunkova.repository.interfaces.IPurchaseRepository;
import com.peter.nulp.rozrahunkova.service.parameter.IMapParams;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PurchaseRepository extends IPurchaseRepository {


    private static IPurchaseRepository instance;
    public static IPurchaseRepository getInstance(){
        if(instance == null){
            instance = new PurchaseRepository();
        }
        return instance;
    }

    @Override
    public void add(Purchase model) {
        list.add(model);
        model.setId(idCounter++);
    }

    @Override
    public void remove(Purchase model) {
        list.remove(model);
    }

    @Override
    public Purchase findOne(Class<? extends BaseFinder<Purchase>> tClass, IMapParams params) {
        return findAll(tClass, params)
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Purchase> findAll(Class<? extends BaseFinder<Purchase>> tClass, IMapParams params) {
        List<Purchase> purchases = List.of();
        try {
            BaseFinder<Purchase> finder = tClass.getDeclaredConstructor().newInstance();
            finder.setList(list);
            finder.setMapParams(params);
            purchases = finder.find();
        }catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        return purchases;
    }
}
