package myweb1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/calc")
public class CalcServlet01 extends HttpServlet {
    public void init(){
        System.out.println("init()");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String command = request.getParameter("command");
        String operator = request.getParameter("operator");
        String won = request.getParameter("won");
        if(command != null && command.equals("calculate")){
            String result = calculate(Float.parseFloat(won), operator);
            out.print("<html><font size=10>변환 결과</font><br>");
            out.print("<font size=10>" + result + "</font><br>");
            out.print("<a href='/calc'>환율 계산기</calc");
            return;
        }
        out.print("<html><title>환율 계산기</title>");
        out.print("<font size=5>환율 계산기</font><br>");
        out.print("<form method='get' action='/calc'/>");
        out.print("원화 : <input type='text' name='won' size=10/>");
        out.print("<select name='operator'>");
        out.print("<option value='dollar'>달러</option>");
        out.print("<option value='en'>엔화</option>");
        out.print("<option value='wian'>위안</option>");
        out.print("<option value='pound'>파운드</option>");
        out.print("<option value='euro'>유로</option>");
        out.print("<option value='dong'>동</option>");
        out.print("</select>");
        out.print("<input type='hidden' name='command' value='calculate'/>");
        out.print("<input type='submit' value='변환'/>");
        out.print("</form>");
        out.print("</html>");
        out.close();
    }
    private static String calculate(float won, String operator){
        String result = null;
        float USD_RATE = (float) 0.5;
        float JPY_RATE = (float) 0.5;
        float CNY_RATE = (float) 0.5;
        float GBP_RATE = (float) 0.5;
        float EUR_RATE = (float) 0.5;
        float VND_RATE = (float) 0.5;
        if(operator.equals("dollar")){
            result = String.format("%.6f", won / USD_RATE);
        }else if(operator.equals("en")){
            result = String.format("%.6f", won / JPY_RATE);
        }else if(operator.equals("wian")){
            result = String.format("%.6f", won / CNY_RATE);
        } else if(operator.equals("pound")){
            result = String.format("%.6f", won / GBP_RATE);
        } else if(operator.equals("euro")){
            result = String.format("%.6f", won / EUR_RATE);
        }else if(operator.equals("dong")){
            result = String.format("%.6f", won / VND_RATE);
        }
        return result;
    }
}
