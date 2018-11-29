package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Mes;
import com.example.demo.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Api(tags = "show")
public class Show {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/delarray")
    public void delarray(@RequestParam(value = "id") Integer[] id){

        roleService.delarray(id);

    }

    @RequestMapping("/allmessage")
    public JSONObject showsomething() {
        JSONObject js = new JSONObject();
        List<Mes> allmsg = roleService.Show();
        js.put("rows", allmsg);
        js.put("total", allmsg.size());
        return js;
    }

    @RequestMapping(value = "/selectby", produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject selectby(@RequestBody(required = false) Integer id) {
        JSONObject js = new JSONObject();
        Mes mes = roleService.selectby(id);
        js.put("rows", mes);
        return js;

    }

    @RequestMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject save(@RequestBody(required = false) Mes mes) {
        JSONObject js = new JSONObject();
        roleService.save(mes);
        js.put("sss", "ss");
        return js;
    }

//    @RequestMapping(value = "/del",produces = MediaType.APPLICATION_JSON_VALUE)
//    public JSONObject del(@RequestBody(required = false) Integer id){
//        JSONObject js = new JSONObject();
//        roleService.del(id);
//        js.put("sss","ss");
//        return js;
//    }

    @RequestMapping(value = "/del", produces = MediaType.APPLICATION_JSON_VALUE)
    public void del(@RequestBody(required = false) Integer id) {

        roleService.del(id);

    }

    @RequestMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject update(@RequestBody(required = false) Mes mes) {
        JSONObject js = new JSONObject();
        roleService.update(mes);
        js.put("ss", "ss");
        return js;
    }

}
