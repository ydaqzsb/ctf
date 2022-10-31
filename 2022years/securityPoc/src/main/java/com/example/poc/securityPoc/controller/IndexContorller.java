package com.example.poc.securityPoc.controller;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;

import com.alibaba.com.caucho.hessian.io.Hessian2Input;
import com.example.poc.securityPoc.beans.Beans;
import com.example.poc.securityPoc.utils.base64;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexContorller {

    @RequestMapping({"/dubbo"})
    public String starterDubbo(@RequestParam(name = "data",required = false) final String data) throws Exception {
        if (data != null) {
//            boolean base64String = base64.isBase64String(data);
//            if (!base64String) {
            if (true) {
                byte[] b = base64.base64Decode(data);
                InputStream inputStream = new ByteArrayInputStream(b);
                Hessian2Input hessian2Input = new Hessian2Input(inputStream);

                try {
                    Beans beans = (Beans)hessian2Input.readObject();
                    Object obj = beans.getObj();
                    return (String)obj;
                } catch (IOException var8) {
                    return "<h1>error.................</h1>";
                }
            } else {
                return "<h1>No base64</h1>";
            }
        } else {
            return "<h1>dubbo is running and use hessian2</h1>";
        }
    }


}
