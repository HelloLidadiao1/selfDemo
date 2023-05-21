package com.generate.controller;

import com.generate.model.GenerateCodeModel;
import com.generate.service.GenerateCodeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@RestController("/generateCode")
public class GenerateCodeController {

    @Resource
    private GenerateCodeService generateCodeService;

    @RequestMapping(value = "/postGenerateCode", method = RequestMethod.POST)
    @ResponseBody
    public String postGenerateCode(@RequestBody GenerateCodeModel generateCodeModel){
        try {
            generateCodeService.generateCodeByTemplate(generateCodeModel);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Fail";
    }

    @RequestMapping(value = "/getGenerateCode", method = RequestMethod.POST)
    @ResponseBody
    public String getGenerateCode(@RequestParam String fileKeyWords,
                                  @RequestParam String packageKeyWords,
                                  @RequestParam String tableName,
                                  @RequestParam String systemType){
        try {
            GenerateCodeModel generateCodeModel = new GenerateCodeModel(fileKeyWords, packageKeyWords, tableName, systemType);
            generateCodeService.generateCodeByTemplate(generateCodeModel);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Fail";
    }

}
