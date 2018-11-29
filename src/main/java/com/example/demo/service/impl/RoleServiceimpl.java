package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Dao.RoleDao;
import com.example.demo.domain.Mes;
import com.example.demo.domain.Role;
import com.example.demo.service.RoleService;
import com.example.utils.CacheManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceimpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Autowired
    private CacheManage cacheManage;



    @Override
    public JSONObject login(String username, String password) {


        JSONObject jsonObject = new JSONObject();
        boolean iskeyu = cacheManage.exist("username");
        boolean iskeyp = cacheManage.exist("password");
        if (iskeyp && iskeyu) {
            boolean isu = cacheManage.get("username").equals(username);
            boolean isp = cacheManage.get("password").equals(password);
            if (isp && isu) {
                String u = cacheManage.get("username");
                String p = cacheManage.get("password");
                Role role = roleDao.login(u, p);
                if (role != null) {
                    jsonObject.put("data", "ss");
                }
            } else {
                Role r1 = roleDao.login(username, password);
                if (r1 != null) {
                    cacheManage.set("username", username);
                    cacheManage.set("password", password);
                    jsonObject.put("data", "ss");
                } else {
                    return null;
                }
            }
        }else {
            Role r1 = roleDao.login(username, password);
            if (r1 != null) {
                cacheManage.set("username", username);
                cacheManage.set("password", password);
                jsonObject.put("data", "ss");
            } else {
                return null;
            }
        }


        return jsonObject;
    }

    @Override
    public void delarray(Integer[] id) {
         roleDao.delarray(id);
    }

    @Override
    public List<Mes> Show() {
        return roleDao.Show();
    }

    @Override
    public void save(Mes mes) {
        roleDao.save(mes);
    }

    @Override
    public Mes selectby(Integer id) {
        return roleDao.selectby(id);
    }

    @Override
    public void update(Mes mes) {
        roleDao.update(mes);
    }

    @Override
    public void del(Integer id) {
        roleDao.del(id);
    }
}
