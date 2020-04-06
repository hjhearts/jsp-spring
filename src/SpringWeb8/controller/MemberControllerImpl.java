package SpringWeb8.controller;

import SpringWeb8.service.MemberService;
import SpringWeb8.service.MemberServiceImpl;
import SpringWeb8.vo.MemberVO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
public class MemberControllerImpl extends MultiActionController implements MemberController {
    private MemberService memberService;
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String viewName = getViewName(request);
        List<MemberVO> membersList = memberService.listMembers();
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("membersList", membersList);
        return mav;
    }

    @Override
    public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        MemberVO memberVO = new MemberVO();
        bind(request, memberVO);
        int status = memberService.addMember(memberVO);
        return new ModelAndView("redirect:/member/listMembers.do");
    }

    @Override
    public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        int status = memberService.removeMember(id);
        return new ModelAndView("redirect:/member/listMembers.do");
    }

    @Override
    public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView(getViewName(request));
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
