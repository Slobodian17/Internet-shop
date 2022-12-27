package com.peter.nulp.rozrahunkova.repository.user;

import com.peter.nulp.rozrahunkova.model.user.User;
import com.peter.nulp.rozrahunkova.repository.BaseFinder;
import com.peter.nulp.rozrahunkova.repository.interfaces.IUserRepository;
import com.peter.nulp.rozrahunkova.service.parameter.IMapParams;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class UserRepository extends IUserRepository{


    @Override
    public void add(User model) {
        list.add(model);
        model.setId(idCounter++);
    }

    @Override
    public void remove(User model) {
        list.remove(model);
    }

    @Override
    public User findOne(Class<? extends BaseFinder<User>> tClass, IMapParams params) {
        return findAll(tClass, params)
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll(Class<? extends BaseFinder<User>> tClass, IMapParams params) {
        List<User> users = List.of();
        try {
            BaseFinder<User> finder = tClass.getDeclaredConstructor().newInstance(); // створюємо новий об'єкт за допомогою рефлексії
            finder.setList(list);
            finder.setMapParams(params);
            users = finder.find();
        }catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        return users;
    }
}
