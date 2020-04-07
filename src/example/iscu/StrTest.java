package example.iscu;

public class StrTest {
    public static void main(String[] args) {
        Sample s = new Sample();
        s.sp1 = 1;
        s.sp2 = 2;
        s.sp4 = 4;
    }
}
class Sample{
    int sp1;
    public int sp2;
    private int sp3;
    protected int sp4;
}
