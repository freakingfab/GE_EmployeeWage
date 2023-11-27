import java.util.Random;
import java.util.Scanner;

public class employeeWage {
    private static final int fullTime = 1;
    private static final int partTime = 2;
    private static final int monthly = 3;
    private static final int wageRate = 20;
    private static final int fullTimeHour = 8;
    private static final int partTimeHour = 8;
    /*
        @desc: function gives random value for employee present or absent
        @params: none
        @return: 0 for absent and 1 for present and 2 for part-time
     */
    public static int presentOrAbsent(){
        Random random = new Random();
        return random.nextInt(3);
    }

    /*
        desc: provides total wage with employee wage rate and hours worked (full+part-time)
        @params: wage rate and hours worked(both full time, partTime)
        @return: total wage(int)
     */
    public static int totalWage(int wageRate, int hoursWorked){
        return wageRate*hoursWorked;
    }

    public static void main(String[] arg){
        System.out.println("Employee Wage System");
        System.out.println("Calculating Monthly Wages .....");
        int daysWorked=0, hoursWorked = 0;
        while(daysWorked<20 && hoursWorked<100){
            int attendance = presentOrAbsent();
            if(attendance==1){
                daysWorked+=1;
                hoursWorked+=partTimeHour;
            }
            else if(attendance==2){
                daysWorked+=1;
                hoursWorked+=fullTimeHour;
            }
        }
        int totalWage = totalWage(wageRate, hoursWorked);
        System.out.println("Total Working Hours in a month: " + hoursWorked);
        System.out.println("Total Days Worked in a month: " + daysWorked);
        System.out.print("Total Wage for this month: " + totalWage);
    }
}
