package com.generate.vo;

import com.generate.model.BaseModel;
import com.generate.model.FieldModel;
import com.generate.model.GenerateFileNameModel;
import lombok.Data;

import java.util.List;

/**
 * @Author: hongjie.li
 * @Date: 2023/5/7
 */
@Data
public class GenerateCodeVo extends BaseVo {

    /**
     * 类名称
     */
    private String className;

    /**
     * 生成文件全路径
     */
    private String generateFileAllPath;

    /**
     * 模板文件路径
     */
    private String templatePath;

    /**
     * 表字段名称集合
     */
    private List<FieldModel> fieldList;
}