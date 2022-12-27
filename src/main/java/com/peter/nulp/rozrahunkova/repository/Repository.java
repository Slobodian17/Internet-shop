package com.peter.nulp.rozrahunkova.repository;

import com.peter.nulp.rozrahunkova.model.Model;
import com.peter.nulp.rozrahunkova.service.parameter.IMapParams;

import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T extends Model> {

    protected List<T> list = new ArrayList<>();
    protected long idCounter = 0;

    public abstract void add(T model);
    public abstract void remove(T model);

    public abstract T findOne(Class<? extends BaseFinder<T>> tClass, IMapParams params);
    public abstract List<T> findAll(Class<? extends BaseFinder<T>> tClass, IMapParams params);

    public List<T> getAll(){
        return list;
    }
    public void setList(List<T> list){ this.list = list; idCounter += list.size(); };

}
