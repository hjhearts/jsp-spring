package SpringWeb4;
/*
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class UserController extends MultiActionController {
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String userID = "";
        String password = "";
        String viewName = getViewName(request);
        ModelAndView mav = new ModelAndView();
        request.setCharacterEncoding("utf-8");
        userID = request.getParameter("userID");
        password = request.getParameter("password");
        mav.addObject("userID", userID);
        mav.addObject("password", password);
        mav.setViewName(viewName);
        return mav;
    }
    public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String viewName = getViewName(request);
        ModelAndView mav = new ModelAndView();
        mav.addObject("id", id);
        mav.addObject("pwd", pwd);
        mav.addObject("name", name);
        mav.addObject("email", email);
        mav.setViewName(viewName);
        return mav;
    }
    private String getViewName(HttpServletRequest request){
        String contextPath = request.getContextPath();
        String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
        System.out.println(uri);
        if(uri == null || uri.trim().equals("")){
            uri = request.getRequestURI();
        }
        int begin = 0;
        if(!((contextPath == null) || ("".equals(contextPath)))){
            begin = contextPath.length();
        }
        int end;
        if(uri.contains(";")){
            end = uri.indexOf(";");
        }else if(uri.contains("?")){
            end = uri.indexOf("?");
        }else{
            end = uri.length();
        }
        String fileName = uri.substring(begin, end);
        if(fileName.contains(".")){
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }
        if(fileName.lastIndexOf("/") != -1){
            fileName = fileName.substring(fileName.lastIndexOf("/")+1);
        }
        System.out.println(fileName);
        return fileName;
    }
}
*/