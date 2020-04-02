package myweb2;

public class Test {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
