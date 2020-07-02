package com.company.upload;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/upload/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUpload extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";
    private static Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String applicationDir = request.getServletContext().getRealPath("");
        String uploadFileDir = applicationDir + File.separator + UPLOAD_DIR + File.separator;
        File fileSaveDir = new File(uploadFileDir);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        String msg = "Upload File Directory" + fileSaveDir.getAbsolutePath();
        logger.debug(msg);
        request.getParts().stream().forEach(part -> {
            try {
                String path = part.getSubmittedFileName();
                String randFilename = UUID.randomUUID() + path.substring(path.lastIndexOf("."));
                part.write(uploadFileDir + randFilename);
                request.setAttribute("upload_result", " upload successfully ");
            } catch (IOException e) {
                request.setAttribute("upload_result", " upload failed ");
            }
        });
    }
}
