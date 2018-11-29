package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Role;
import com.example.demo.service.RoleService;
import com.example.utils.CacheManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登陆")
@RestController
public class Login {
    @Autowired
    private RoleService roleService;

    @Autowired
    CacheManage cacheManage;

    @ApiOperation(value = "登陆账号",notes = "传入账号密码，若数据库匹配则登陆成功，如果不匹配则跳转到登陆失败页面")
    @RequestMapping(value = "/login",method = {RequestMethod.POST},produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject login(@RequestBody(required = false) Role role) {
        JSONObject js = roleService.login(role.getUsername(),role.getPassword());
        return js;

    }
}
