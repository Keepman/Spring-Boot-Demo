package com.example.demo.domain;

import lombok.Data;

@Data
public class Mes {
    private Integer id;
    private String name;
    private String address;
    private String business;
    private String level;
    //员工数量
    private String total;
    //营业状态
    private String do_business;

    private Role r_id;
}
