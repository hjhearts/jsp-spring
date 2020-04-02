package work13;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {
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
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        JSONObject totalObject = new JSONObject();
        JSONArray memberArray = new JSONArray();
        JSONObject memberObject = new JSONObject();
        memberObject.put("name", "손흥민");
        memberObject.put("age", "25");
        memberObject.put("gender", "남자");
        memberObject.put("nickname", "sonic");
        memberArray.add(memberObject);
        memberObject = new JSONObject();
        memberObject.put("name", "김연아");
        memberObject.put("age", "21");
        memberObject.put("gender", "여자");
        memberObject.put("nickname", "queen");
        memberArray.add(memberObject);
        totalObject.put("member", memberArray);
        JSONObject bookObject = new JSONObject();
        JSONArray bookArray = new JSONArray();
        bookObject.put("title", "자바 웹을 다루는 기술");
        bookObject.put("writer", "이병승");
        bookObject.put("price", "40000");
        bookObject.put("genre", "java");
        bookObject.put("image", "http://localhost:8080/work13/image/image1.jpg");
        bookArray.add(bookObject);
        bookObject = new JSONObject();
        bookObject.put("title", "Jump to Python");
        bookObject.put("writer", "easyspublising");
        bookObject.put("price", "18000");
        bookObject.put("genre", "python");
        bookObject.put("image", "http://localhost:8080/work13/image/image2.PNG");
        bookArray.add(bookObject);
        totalObject.put("books", bookArray);
        String jsonInfo = totalObject.toJSONString();
        System.out.println(jsonInfo);
        out.print(jsonInfo);
    }
}
