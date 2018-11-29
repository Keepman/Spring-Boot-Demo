package com.example.utils;



import com.example.demo.domain.Role;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

//获取我的role上下文对象
public class RoleContext {

    private static final String CONTEXT_ROLE = "contextrole";

    //获取我的session
    public static HttpSession getsession() {
        return ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }

    //获取上下文Role对象
    public static Role getContextRole() {
        return (Role) getsession().getAttribute(CONTEXT_ROLE);
    }
    //设置上下文Role对象

    public static void setContextRole(Role role) {
        getsession().setAttribute(CONTEXT_ROLE, role);
    }
}
