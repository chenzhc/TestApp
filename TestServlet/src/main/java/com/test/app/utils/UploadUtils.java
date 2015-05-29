package com.test.app.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Part;

/**
 * Created by zc on 2015/5/28.
 */
public class UploadUtils {
    /**
     * 如何得到上传的文件名, API没有提供直接的方法，只能从content-disposition属性中获取
     *
     * @param part
     * @return
     */
    public static String getFileName(Part part) {
        if (part == null)
            return null;

        String fileName = part.getHeader("content-disposition");
        if (StringUtils.isBlank(fileName)) {
            return null;
        }

        return StringUtils.substringBetween(fileName, "filename=\"", "\"");
    }
}
