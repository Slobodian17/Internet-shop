package com.peter.nulp.rozrahunkova.service.menu;

import com.peter.nulp.rozrahunkova.Application;
import com.peter.nulp.rozrahunkova.model.product.Product;
import com.peter.nulp.rozrahunkova.model.purchase.Purchase;
import com.peter.nulp.rozrahunkova.model.user.User;
import com.peter.nulp.rozrahunkova.repository.interfaces.IProductRepository;
import com.peter.nulp.rozrahunkova.repository.interfaces.IPurchaseRepository;
import com.peter.nulp.rozrahunkova.repository.product.find.ProductFindById;
import com.peter.nulp.rozrahunkova.repository.product.find.ProductFindByTitle;
import com.peter.nulp.rozrahunkova.repository.purchase.PurchaseRepository;
import com.peter.nulp.rozrahunkova.repository.purchase.find.PurchaseFindByUserId;
import com.peter.nulp.rozrahunkova.service.data.purchase.PurchaseProcess;
import com.peter.nulp.rozrahunkova.service.parameter.IMapParams;
import com.peter.nulp.rozrahunkova.service.parameter.MapParams;
import com.peter.nulp.rozrahunkova.service.utils.Utils;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static String menu =
                    "Hello, %s! Here are few commands you may use: \n" +
                    "1) products - watch products catalogue \n" +
                    "2) buy [id] - buy product\n" +
                    "3) search [product_name] - search product by name\n" +
                    "4) purchases - check your cart\n" +
                    "5) balance - check your balance\n" +
                    "6) topup [money] - top up your balance\n" +
                    "6) exit - exit";

    public static void open(User currentUser){

        IProductRepository productRepo = (IProductRepository) Application.getContext()
                                                                        .getBean("products");
        IPurchaseRepository purchaseRepo = PurchaseRepository.getInstance();

        System.out.println(String.format(menu, currentUser.getName()));

        String command = "";
        Scanner scanner = new Scanner(System.in);

        IMapParams mapParams = new MapParams();

        do{

            command = scanner.nextLine();
            String[] subcommands = command.split(" ");

            //buy
            //[buy, 1] -> subcommands[0] = buy, subcommands[1] = 1

            switch(subcommands[0].toLowerCase()){

                default:
                    System.out.println("Undefined command!");
                    break;

                case "products":
                    System.out.println("ID\tProduct name\tDescription\tCost");
                    productRepo
                            .getAll()
                            .forEach(product -> System.out.println(product.getId() + "\t"
                                    + product.getTitle() + "\t"
                                    + product.getDescription() + "\t"
                                    + product.getCost()));
                    break;

                case "buy":
                    if(subcommands.length != 2){
                        System.out.println("Usage: buy [product_id]");
                        break;
                    }

                    if(!Utils.isNumber(subcommands[1])){
                        System.out.println("The id must be number!");
                        break;
                    }

                    mapParams.clear();
                    mapParams.put("id", Integer.parseInt(subcommands[1]));
                    Product productById = productRepo.findOne(ProductFindById.class, mapParams);
                    if(productById == null){
                        System.out.println("Undefined id!");
                        break;
                    }

                    System.out.println(PurchaseProcess.purchase(currentUser, productById));
                    break;

                case "search":
                    if(subcommands.length < 2){
                        System.out.println("Usage: buy [product_id]");
                        break;
                    }
                    subcommands[0]="";

                    mapParams.clear();
                    mapParams.put("title", String.join(" ",subcommands));
                    Product productByTitle = productRepo.findOne(ProductFindByTitle.class, mapParams);
                    if(productByTitle == null){
                        System.out.println("Undefined title!");
                        break;
                    }

                    System.out.println("ID\tTitle\tDescription\tCost");
                    System.out.println(productByTitle.getId() + "\t" + productByTitle.getTitle() + "\t"
                            + productByTitle.getDescription() + "\t" + productByTitle.getCost());
                    break;

                case "purchases":
                    mapParams.clear();
                    mapParams.put("user_id", currentUser.getId());
                    List<Purchase> purchases = purchaseRepo.findAll(PurchaseFindByUserId.class, mapParams);

                    if(purchases.isEmpty()){
                        System.out.println("You have not bought any products yet");
                    }else{
                        System.out.println("Your purchases:");
                        System.out.println("ID\tProduct id\tCost");
                        purchases
                                .forEach(purchase -> System.out.println(purchase.getId() + "\t"
                                        + purchase.getProduct_id() + "\t"
                                        + purchase.getMoney()));
                    }
                    break;

                case "balance":
                    System.out.println("Your balance: " + currentUser.getBalance());
                    break;

                case "topup":
                    if(subcommands.length != 2){
                        System.out.println("Usage: topup [money]");
                        break;
                    }
                    if(!Utils.isNumber(subcommands[1])){
                        System.out.println("The id must be number!");
                        break;
                    }

                    long money = Long.parseLong(subcommands[1]);

                    if(money <= 0){
                        System.out.println("The value must be > 0!!!");
                        break;
                    }

                    currentUser.setBalance(currentUser.getBalance() + money);
                    System.out.println("You've successfully topped up your balance");
                    break;

                case "exit":
                    System.out.println("Goodbye!");
                    currentUser = null;
                    break;

            }

        }while (!command.equalsIgnoreCase("exit"));

    }
}
