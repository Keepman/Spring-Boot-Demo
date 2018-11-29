package com.example.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonUtil {

    public static JSONObject response(int code, Object object){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result_code", code);
        jsonObject.put("data", object);
        return jsonObject;
    }
    public static JSONObject response(int code, List<Object> objects,List<String> keys){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("result_code", code);
        if(null!=objects&&objects.size()>0&&keys.size()>0&&keys.size()==objects.size()){
            for(int i=0;i<objects.size();i++){
                jsonObject.put(keys.get(i), objects.get(i));
            }
        }
        return jsonObject;
    }
//    public static void main(String[] args) {
//        Map m = new HashMap<Object,Object>();
//        m.put("name","test");
//        m.put("pwd","123456");
//        System.out.println(JsonUtil.response(0,m));
//    }
}
