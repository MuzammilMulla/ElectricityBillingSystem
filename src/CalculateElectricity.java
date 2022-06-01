import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Random;

class CalculateElectricity extends Greetings {
    public int unitsConsumed;
    public double amount;

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // take input of consumed electricity units & calculate amount based on the units entered
    public void calculateAmount()
    {

        try {
                dateTime();

                // generate bill number
                Random random = new Random();
                billNo = String.valueOf(random.nextInt(0,999999));
                System.out.println("Bill No: " + billNo);

                System.out.print("Enter units consumed: ");
                setUnitsConsumed(scanner.nextInt());

        } catch (InputMismatchException e) {
            System.out.println("Input given is wrong !! \nPlease try again");
          System.exit(0);
        }
            //if units consumed less than or equal to 60
            if (getUnitsConsumed() <= 60) {
                setAmount((getUnitsConsumed() * 3.75) + 200); // 200 Fixed price
                String strDouble1 = String.format("%.2f", getAmount());
                System.out.println("Your payable amount is " + strDouble1);

            //if units consumed greater than 60
            } else if (getUnitsConsumed() > 60) {

                double UnitsTotal = getUnitsConsumed(); //user input
                double remainingUnits = (UnitsTotal - 60); // if user enters 80 then remainingUnits = 80 -60 --> 20
                double Amount = ((remainingUnits * 5.2f) + 425); //remainingUnits amount is calculated first then added to first 60 Units amount. --> (20*5.2f)+425

                // if units amount is above 500 then 10% discount is given on the total amount
                if (Amount > 500) {
                    System.out.println("Payable amount exceed 500 \nDiscounted 10% ");
                    double discountedPrice = Amount * 0.10;
                    String strDouble2 = String.format("%.2f", discountedPrice);
                    System.out.println("Discounted price " + strDouble2);

                    double totalAmount = Amount - discountedPrice;
                    String strDouble3 = String.format("%.2f", totalAmount);
                    System.out.println("Your Total Payable amount is " + strDouble3);
                } else {
                    String strDouble4 = String.format("%.2f", Amount);
                    System.out.println("Your Total Payable amount is " + strDouble4);
                }
            }
        // printing due date ( 30 days from the bill generated date)
        // add 30 days to current date using Calendar.add method
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, 30);
        System.out.println("Due Date : "  + now.get(Calendar.DATE) + "-"+ (now.get(Calendar.MONTH) + 1) + "-"+  + now.get(Calendar.YEAR));
    }
}