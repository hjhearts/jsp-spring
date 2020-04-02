package work05;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class LoginImplServlet implements HttpSessionListener {
    String user_id;
    String user_pwd;
    static int total_user = 0;
    public LoginImplServlet(){}
    public LoginImplServlet(String user_id, String user_pwd){
        this.user_id = user_id;
        this.user_pwd = user_pwd;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("세션 생성");
        ++total_user;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("세션 소멸");
        --total_user;
    }
}
