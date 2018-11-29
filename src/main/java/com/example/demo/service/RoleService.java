package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Mes;

import java.util.List;

public interface RoleService {
    JSONObject login(String username, String password);

    List<Mes> Show();

    void save(Mes mes);

    void del(Integer id);

    void update(Mes mes);

    Mes selectby(Integer id);

    void delarray(Integer[] id);
}
