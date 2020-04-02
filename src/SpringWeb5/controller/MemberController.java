package SpringWeb5.controller;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberController {
    ModelAndView addMember(HttpServletRequest req, HttpServletResponse res) throws Exception;
    ModelAndView listMembers(HttpServletRequest req, HttpServletResponse res) throws Exception;
    ModelAndView memberForm(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
