package com.example.poc.securityPoc.demo.babyspring;

import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class xml {
    public xml() {
    }

    public static boolean existBlacklist(String xmlString) {
        String[] blackList = new String[]{"url", "conf", "etc", "proc", "history", "flag", "file", "ftp", "http", "data", "bash", "log", "dtd"};
        String[] var2 = blackList;
        int var3 = blackList.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String each = var2[var4];
            if (xmlString.toLowerCase().contains(each)) {
                return true;
            }
        }

        return false;
    }

    public static boolean validate(String xmlString) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = schemaFactory.newSchema(new File("/home/ctf/service.xsd"));
        Validator validator = schema.newValidator();
        schemaFactory.setProperty("http://javax.xml.XMLConstants/property/accessExternalSchema", "");
        validator.validate(new StreamSource(new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8))));
        return true;
    }
}
