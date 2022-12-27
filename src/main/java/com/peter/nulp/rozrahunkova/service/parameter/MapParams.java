package com.peter.nulp.rozrahunkova.service.parameter;


import java.util.HashMap;

public class MapParams extends HashMap<String, Object> implements IMapParams{

    @Override
    public String getString(String key) {
        return String.valueOf(get(key));
    }

    @Override
    public int getInt(String key) {
        Object obj = get(key);
        return obj instanceof String
                ? Integer.parseInt((String) obj)
                : (Integer) obj;
    }

    @Override
    public long getLong(String key) {
        Object obj = get(key);
        return obj instanceof String
                ? Long.parseLong((String) obj)
                : (Long) obj;
    }


}
