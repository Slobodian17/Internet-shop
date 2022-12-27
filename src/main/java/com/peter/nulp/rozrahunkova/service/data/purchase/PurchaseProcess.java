package com.peter.nulp.rozrahunkova.service.data.purchase;

import com.peter.nulp.rozrahunkova.model.product.Product;
import com.peter.nulp.rozrahunkova.model.purchase.Purchase;
import com.peter.nulp.rozrahunkova.model.user.User;
import com.peter.nulp.rozrahunkova.repository.interfaces.IPurchaseRepository;
import com.peter.nulp.rozrahunkova.repository.purchase.PurchaseRepository;

public class PurchaseProcess {

    public static String purchase(User user, Product product){

        IPurchaseRepository purchaseRepository = PurchaseRepository.getInstance();
        long money = product.getCost();

        String value = "";
        if(user.getBalance() < money){
            value = "You don't have enough money to buy this!";
        }else{
            value = "You successfully bought the product!";
            Purchase purchase = new Purchase(user.getId(), product.getId(), money);
            purchaseRepository.add(purchase);

            user.setBalance(user.getBalance() - money);

        }

        return value;
    }

}
