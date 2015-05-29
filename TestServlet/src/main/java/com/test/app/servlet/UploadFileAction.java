package com.test.app.servlet;

import com.test.app.utils.FilenameUtils;
import com.test.app.utils.UploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by zc on 2015/5/28.
 */
@MultipartConfig
@WebServlet("/upload")
public class UploadFileAction extends HttpServlet {
    private static final long serialVersionUID = 92166165626L;
    private static final Logger log = LoggerFactory.getLogger(UploadFileAction.class);

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // 为避免获取文件名称时出现乱码
        request.setCharacterEncoding("UTF-8");

        Part part = null;
        try {
            // <input name="file" size="50" type="file" />
            part = request.getPart("file");
        } catch (Exception e) {
            log.error(e.toString());
            e.printStackTrace();
        }


        // 得到文件的原始名称，eg ：测试文档.pdf
        String fileName = UploadUtils.getFileName(part);
        log.info("fileName : " + fileName);
        log.info("fileSize : " + part.getSize());
        log.info("header names : ");
        for (String headerName : part.getHeaderNames()) {
            log.info(headerName + " : " + part.getHeader(headerName));
        }

        // 因在注解中指定了路径，这里可以指定要写入的文件名
        // 在未执行write方法之前，将会在注解指定location路径下生成一临时文件
        part.write(fileName);

    }


}