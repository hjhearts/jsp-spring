package myweb1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
//@WebServlet("/login1")
public class GetPostServlet extends HttpServlet {
    public void init(){
        System.out.println("init()");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        doHandle(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        doHandle(request, response);
    }
    public void destroy(){
        System.out.println("destroy()");
    }
    private void doHandle(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        String user_id = request.getParameter("id");
        String user_password = request.getParameter("password");
        String[] user_subject = request.getParameterValues("subject");
        System.out.println(user_id);
        System.out.println(user_password);
        System.out.println(Arrays.toString(user_subject));
    }
}
