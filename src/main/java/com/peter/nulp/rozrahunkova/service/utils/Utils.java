package com.peter.nulp.rozrahunkova.service.utils;

import java.util.Random;

public class Utils {

    private static Random random = new Random();

    public static boolean isNumber(Object obj){
        return (obj instanceof Number);
    } //перевірка чи об'єкт - число


    public static boolean isNumber(String str){     // перевірка чи рядок - число
        try{
            Integer.parseInt(str);
        }catch (NumberFormatException exception){
            return false;
        }
        return true;
    }

    public static int randomInt(int max){
        return random.nextInt(max) + 1;
    } // рандомне число > 0

}
