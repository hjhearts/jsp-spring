package SpringWeb2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MemberTest1 {
    public static void main(String[] args) {
        BeanFactory context = new XmlBeanFactory(new FileSystemResource("member.xml"));
        MemberService service = (MemberService)context.getBean("memberService");
        service.lisMembers();
    }
}
