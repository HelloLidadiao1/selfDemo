package com.generate.common.util;

import com.generate.common.constant.Constant;
import com.generate.common.constant.ErrorCode;
import com.generate.common.exception.GcsException;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * 代码生成器，工具类
 * @Author: hongjie.li
 * @Date: 2023/5/21
 */
public final class GenerateCodeUtils {

    /**
     * java包名转路径
     * @param pckName
     * @return
     */
    public static String packageToFilePath(String pckName){
        if(StringUtils.isBlank(pckName)){
            throw new GcsException(ErrorCode.PARAM_IS_NOT_EMPTY, "pckName");
        }
        String[] packageArr = pckName.split("\\.");
        if(packageArr == null || packageArr.length == 0){
            throw new GcsException(ErrorCode.PARAM_IS_NOT_EMPTY, "packageArr");
        }
        StringBuffer filePathSb = new StringBuffer();
        for (int i = 0, len = packageArr.length; i < len; i++) {
            filePathSb.append(packageArr[i]);
        }
        return filePathSb.toString();
    }

    /**
     * 以特定字符串分隔，拼接多段字符串，
     * @param strArr
     * @param splitStr
     * @return
     */
    public static String unionManyStrBySplit(String splitStr, String ...strArr){
        if(StringUtils.isBlank(splitStr) || strArr == null || strArr.length == 0){
            throw new GcsException(ErrorCode.PARAM_IS_NOT_EMPTY, "strArr");
        }
        StringBuffer filePathSb = new StringBuffer();
        for (int i = 0, len = strArr.length; i < len; i++) {
            String pckName = strArr[i];
            if(pckName == null){
                continue;
            }
            filePathSb.append(pckName);
            if(i != len - 1){
                filePathSb.append(splitStr);
            }
        }
        return filePathSb.toString();
    }

    /**
     * 拼接多段java包名对应的文件路径
     * @param pckNames
     * @return
     */
    public static String unionManyPckNamFilePath(String ...pckNames){
        String unionManyPckName = unionManyStrBySplit(Constant.Charator.dot, pckNames);
        String packageToFilePath = packageToFilePath(unionManyPckName);
        return packageToFilePath;
    }

    /**
     * 创建父级目录
     * @param file
     */
    public static void createParentDir(File file){
        if(file == null){
            throw new GcsException(ErrorCode.PARAM_IS_NOT_EMPTY, "file");
        }
        File parentFile = file.getParentFile();
        if(parentFile != null && !parentFile.exists()){
            parentFile.mkdirs();
        }
    }
}
