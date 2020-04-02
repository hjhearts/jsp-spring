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
//@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
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
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "손흥민");
        jsonObject.put("age", "25");
        jsonObject.put("gender", "남자");
        jsonObject.put("nickname", "sonic");
        jsonArray.add(jsonObject);
        jsonObject = new JSONObject();
        jsonObject.put("name", "김연아");
        jsonObject.put("age", "21");
        jsonObject.put("gender", "여자");
        jsonObject.put("nickname", "queen");
        jsonArray.add(jsonObject);
        totalObject.put("member", jsonArray);
        String jsonInfo = totalObject.toJSONString();
        System.out.println(jsonInfo);
        out.print(jsonInfo);
    }
}
