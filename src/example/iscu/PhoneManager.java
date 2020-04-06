package example.iscu;
import java.util.*;
class Phone{
    private String name;
    private String tel;
    public Phone(String name,String tel) { this.name=name; this.tel=tel; }
    public String getName() { return name; }
    public String getTel() { return tel; }
}
public class PhoneManager {
    private Phone[] p;
    Scanner sc=new Scanner(System.in);
    int num;
    private void read()
    {
        System.out.print("인원수>>");
        num=sc.nextInt();
        p = new Phone[num];
        for(int i=0;i<num;i++)
        {
            System.out.print("이름과 전화번호(번호는 연속적으로 입력)>>");
            p[i]=new Phone(sc.next(),sc.next());
        }
        System.out.println("저장되었습니다...");
    }

        private String search(String name)
        {
            for(int i=0;i<num;i++)
            {
                if(name.equals(p[i].getName()))
                {
                    return "이름:" + p[i].getName() + " 전화번호:" +p[i].getTel();
                }
            }
            return "name wrong";
        }
    public void run()
    {
        read();
        while(true) {
            System.out.print("검색할 이름>>");
            String name= sc.next();
            if(name.equals("exit")) {
                System.out.println("프로그램을 종료합니다...");
                break;
            }
            else {
                String tel=search(name);
                System.out.println(name +"의 번호는 " + tel + "입니다.");
            }
        }
    }
    public static void main(String[] args) {
        new PhoneManager().run();
    }
}
