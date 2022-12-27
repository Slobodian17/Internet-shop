package com.peter.nulp.rozrahunkova.repository.user.find;

import com.peter.nulp.rozrahunkova.model.user.User;
import com.peter.nulp.rozrahunkova.repository.BaseFinder;

import java.util.function.Predicate;

public class UserFindById extends BaseFinder<User> {

    @Override
    public Predicate<User> getPredicate() {
        return user -> (user.getId() == mapParams.getInt("id"));
    }
}
