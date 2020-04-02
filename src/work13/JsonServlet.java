package work13;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet("/jsons")
public class JsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("GET 요청 받음");
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("POST 요청 받음");
        doHandle(req, resp);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        System.out.println("Handle 실행");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String jsonInfo = request.getParameter("jsonInfo");
        try{
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonInfo);
            System.out.println("회원 정보");
            System.out.println(jsonObject.get("name"));
            System.out.println(jsonObject.get("age"));
            System.out.println(jsonObject.get("gender"));
            System.out.println(jsonObject.get("nickname"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
