package example.iscu;
import java.util.*;
public class Ranking{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int sub1 = 0, sub2 = 0, sub3 = 0, sub4 = 0, sub5 = 0;
        int count;
        double mean;

        System.out.print("How many subjects do you have?");
        count = input.nextInt();
        System.out.println();


        if (count>=1){
            System.out.print("Input your first subject score: ");
            sub1 = input.nextInt();
            System.out.println();

            if(sub1>=0&&100>=sub1){
            }
            else{
                System.out.println("You've input inappropriate number. shutting down the program");
                System.exit(0);}
        }

        if (count>=2){
            System.out.print("Input your second subject score: ");
            sub2 = input.nextInt();
            System.out.println();

            if(sub2>=0&&100>=sub2){
            }
            else{
                System.out.println("You've input inappropriate number. shutting down the program");
                System.exit(0);}
        }

        if (count>=3){
            System.out.print("Input your third subject score: ");
            sub3 = input.nextInt();
            System.out.println();

            if(sub3>=0&&100>=sub3){
            }
            else{
                System.out.println("You've input inappropriate number. shutting down the program");
                System.exit(0);}
        }

        if (count>=4){
            System.out.print("Input your fourth subject score: ");
            sub4 = input.nextInt();
            System.out.println();

            if(sub4>=0&&100>=sub4){
            }
            else{
                System.out.println("You've input inappropriate number. shutting down the program");
                System.exit(0);}
        }

        if (count>=5){
            System.out.print("Input your fifth subject score: ");
            sub5 = input.nextInt();
            System.out.println();

            if(sub5>=0&&100>=sub5){
            }
            else{
                System.out.println("You've input inappropriate number. shutting down the program");
                System.exit(0);}
        }
        if(count>=6 || 0>=count){
            System.out.println("You've input inappropriate number. shutting down the program");
            System.exit(0);}

        switch(count){
            case 1:
                mean = (sub1)/1.0;
                break;

            case 2:
                mean = (sub1 + sub2)/2.0;
                break;

            case 3:
                mean = (sub1 + sub2 + sub3)/3.0;
                break;
            case 4:
                mean = (sub1 + sub2 + sub3 + sub4)/4.0;
                break;

            case 5:
                mean = (sub1 + sub2 + sub3 + sub4 + sub5)/5.0;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + count);
        }



        if(mean >=90){
            System.out.println(mean + "A");}
        else if(mean >= 70){
            System.out.println(mean + "B");}
        else if(mean >= 60){
            System.out.println(mean + "C");}
        else if(mean >= 40){
            System.out.println(mean + "D");}
        else{
            System.out.println(mean + "Fail");}
    }
}
