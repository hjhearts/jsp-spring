package example;

public class ForClass {
    public static void main(String[] args) {
        HelloWorld[] hello = new HelloWorld[4];
        for (int i = 0; i < 4; i++) {
            hello[i] = new HelloWorld();
        }
        hello[0].sayHelloWorldFrom();
        hello[1].sayHelloWorldFrom();
        hello[2].sayHelloWorldFrom();
        hello[3].sayHelloWorldFrom();

    }
}
