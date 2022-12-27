package com.peter.nulp.rozrahunkova.repository.user.find;

import com.peter.nulp.rozrahunkova.model.user.User;
import com.peter.nulp.rozrahunkova.repository.BaseFinder;

import java.util.function.Predicate;

public class UserFindByFullName extends BaseFinder<User> {


    @Override
    public Predicate<User> getPredicate() {
        return user -> (

                String.join(" ",
                            user.getName(),
                            user.getSurname())

                .equalsIgnoreCase(
                        String.join(" ",
                                mapParams.getString("name"),
                                mapParams.getString("surname"))
                )
        );
    }
}
