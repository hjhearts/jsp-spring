package SpringWeb9.account;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.PropertiesMethodNameResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountController extends MultiActionController {
    private AccountService accService;
    public void setAccService(AccountService accService) {
        this.accService = accService;
    }
    public ModelAndView sendMoney(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        ModelAndView mav = new ModelAndView();
        accService.sendMoney();
        mav.setViewName("result");
        return mav;
    }
}
