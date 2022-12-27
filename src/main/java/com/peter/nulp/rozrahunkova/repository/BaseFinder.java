package com.peter.nulp.rozrahunkova.repository;

import com.peter.nulp.rozrahunkova.service.parameter.IMapParams;

import java.util.List;
import java.util.function.Predicate;

public abstract class BaseFinder<T> {

    protected List<T> list;
    protected IMapParams mapParams;


    public void setMapParams(IMapParams mapParams) {
        this.mapParams = mapParams;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> find(){ // пошук за критерієм
        return list
                .stream()
                .filter(getPredicate())
                .toList();
    }

    public abstract Predicate<T> getPredicate(); // функціональний інтерфейс

}
