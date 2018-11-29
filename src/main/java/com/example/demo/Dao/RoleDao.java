package com.example.demo.Dao;

import com.example.demo.domain.Mes;

import com.example.demo.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    Role login(@Param("username") String username, @Param("password") String password);

    List<Mes> Show();

    void save(Mes mes);

    //void fenye(Page page);

    void del(Integer id);

    void update(Mes mes);

    Mes selectby(Integer id);

    void delarray(@Param("id") Integer[] id);
}

