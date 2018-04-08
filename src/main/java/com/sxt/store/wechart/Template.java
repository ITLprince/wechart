package com.sxt.store.wechart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.TreeMap;

public class Template {
    @Setter
    @Getter
    private String touser;
    @Setter
    @Getter
    @JsonProperty("template_id")
    private String templateId;
    @Setter
    @Getter
    private String url;
    @Setter
    @Getter
    private Map<String,Map<String,String>> data = new TreeMap<>();

    public Template interData(String value,String color,String key){
        Map<String,String> innerData = new TreeMap<>();
        innerData.put("value",value);
        innerData.put("color",color);
        this.data.put(key,innerData);
        return this;

    }

}
