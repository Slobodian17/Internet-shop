package com.peter.nulp.rozrahunkova.service.parameter;

import java.util.Map;

public interface IMapParams extends Map<String, Object> {

    String getString(String key);
    int getInt(String key);
    long getLong(String key);


}
