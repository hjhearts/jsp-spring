package myweb2;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
//@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doHandle(req, resp);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String encoding = "utf-8";
        File currentDirPath = new File("C:\\file_repository");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(currentDirPath);
        factory.setSizeThreshold(1024 * 1024);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try{
            List item = upload.parseRequest(request);
            for (int i = 0; i < item.size(); i++) {
                FileItem fileItem = (FileItem)item.get(i);
                if(fileItem.isFormField()){
                    System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
                }else{
                    System.out.println("매개변수 이름 : " + fileItem.getFieldName());
                    System.out.println("파일 이름 : " + fileItem.getName());
                    System.out.println("파일 크기 : " + fileItem.getSize() + "bytes");
                    if(fileItem.getSize() > 0){
                        int idx = fileItem.getName().lastIndexOf("\\");
                        if(idx == -1){
                            idx = fileItem.getName().lastIndexOf("/");
                        }
                        String fileName = fileItem.getName().substring(idx+1);
                        File uploadFile = new File(currentDirPath + "\\" + fileName);
                        fileItem.write(uploadFile);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
