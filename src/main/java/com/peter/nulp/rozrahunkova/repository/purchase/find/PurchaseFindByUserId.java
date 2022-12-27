package com.peter.nulp.rozrahunkova.repository.purchase.find;

import com.peter.nulp.rozrahunkova.model.purchase.Purchase;
import com.peter.nulp.rozrahunkova.repository.BaseFinder;

import java.util.function.Predicate;

public class PurchaseFindByUserId extends BaseFinder<Purchase> {
    @Override
    public Predicate<Purchase> getPredicate() {
        return purchase -> (purchase.getUser_id() == mapParams.getLong("user_id"));
    }
}
