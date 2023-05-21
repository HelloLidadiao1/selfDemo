package com.generate.manager;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lihongjie
 * @date 2023/5/4
 */
@Component
public class CodeGenerator {

    /*public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(CodeGenerator.class, "/codeTemplates");
        Template template = cfg.getTemplate("entityTemplate.ftl");
        Map<String, Object> data = new HashMap<>();
        String className = "Person";
        data.put("packageName", "com.lihongjie");
        data.put("className", className);
        *//*data.put("fields", new Object[]{
                new Field("name", "String"),
                new Field("age", "int")
        });*//*
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        String generateCodeFilePath = "E:\\GenerateCode" + File.separator + simpleDateFormat.format(new Date());
        File generateFile = new File(generateCodeFilePath);
        if(!generateFile.exists()){
            generateFile.mkdirs();
        }
        BufferedWriter bfWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(generateCodeFilePath
                + File.separator + className + ".java")));
        template.process(data, bfWriter);
        System.out.println("生成文件成功！");
    }*/
}
