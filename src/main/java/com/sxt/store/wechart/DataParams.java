package com.sxt.store.wechart;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.TreeMap;

public class DataParams {

    @Getter
    @Setter
    private Map<String,Map<String,String>> map = new TreeMap<>();

    public Map<String,Map<String,String>> interData(String key,String value,String color){
        Map<String,String> innerData = new TreeMap<>();
        innerData.put("value",value);
        innerData.put("color",color);
        this.map.put(key,innerData);
        return this.map;
    }



}
