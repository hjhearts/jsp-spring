package SpringWeb5.controller;

import SpringWeb5.vo.MemberVO;
import SpringWeb5.service.MemberService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class MemberControllerImpl extends MultiActionController implements MemberController {
    private MemberService memberService;
    public void setMemberService(MemberService memberService){
        this.memberService = memberService;
    }
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        String viewName = getViewName(request);
        List membersList = memberService.listMembers();
        ModelAndView mav = new ModelAndView();
        mav.addObject("membersList", membersList);
        mav.setViewName(viewName);
        return mav;
    }
    public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        String viewName = getViewName(request);
        ModelAndView mav = new ModelAndView();
        mav.setViewName(viewName);
        return mav;
    }
    public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        MemberVO memberVO = new MemberVO();
        memberVO.setId(id);
        memberVO.setPwd(pwd);
        memberVO.setName(name);
        memberVO.setEmail(email);
        memberService.addMember(memberVO);
        ModelAndView mav = listMembers(request, response);
        mav.setViewName("listMembers");
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
