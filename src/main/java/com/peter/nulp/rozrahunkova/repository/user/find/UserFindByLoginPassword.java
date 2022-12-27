package com.peter.nulp.rozrahunkova.repository.user.find;

import com.peter.nulp.rozrahunkova.model.user.User;
import com.peter.nulp.rozrahunkova.repository.BaseFinder;

import java.util.function.Predicate;

public class UserFindByLoginPassword extends BaseFinder<User> {


    @Override
    public Predicate<User> getPredicate() {
        return user -> (
                String.join(" ", user.getLogin(), user.getPassword()).equals(
                        String.join(" ", mapParams.getString("login"), mapParams.getString("password"))
                )
        );
    }
}
