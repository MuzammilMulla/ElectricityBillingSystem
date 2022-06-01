import java.util.Calendar;
import java.util.Scanner;
import  java.text.SimpleDateFormat;

class Greetings{
    public String billNo;
    public String name;
    public String phone;

    public void getName(String next) {}
    public void getPhone(String next) {}

    Scanner scanner = new Scanner(System.in);

    // take user details
    public void userDetails()
    {
        try {
            System.out.print("Enter consumer name / consumer ID: ");
            getName(scanner.next());
            System.out.print("Enter Phone Number: ");
            getPhone(scanner.next());

        }catch (Exception e){
            System.out.println("Input Invalid"+"\n"+"Please try again ! ");
        }
    }
    //  print current date and time
    public  void dateTime()
    {
        userDetails();
        System.out.println("Date                   Time");
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy            HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
    }
}


public class Main {
    public static void main(String[] args) {
        CalculateElectricity c1= new CalculateElectricity();
        c1.calculateAmount();

    }
}
