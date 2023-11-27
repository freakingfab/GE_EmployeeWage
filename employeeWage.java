import java.util.Random;
import java.util.Scanner;

public class employeeWage {
    private static final int fullTime = 1;
    private static final int partTime = 2;
    private static final int monthly = 3;
    private static final int wageRate = 8;
    /*
        @desc: function gives random value for employee present or absent
        @params: none
        @return: 0 for absent and 1 for present
     */
    public static int presentOrAbsent(){
        Random random = new Random();
        return random.nextInt(2);
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
        System.out.print("Enter your choice(1. for full time, 2. for part time, 3. for monthly): ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice){
            case fullTime:
                int attendance = presentOrAbsent();
                int fullTimeHours = 0;
                if(attendance==1){
                    fullTimeHours = 20;
                    System.out.println("Employee is present");
                }
                System.out.println("Total Wage: " + totalWage(wageRate,fullTimeHours));
                break;
            case partTime:
                int attendence = presentOrAbsent();
                int partTimeHours = 0;
                if(attendence==1){
                    partTimeHours = 4;
                    System.out.println("Employee is present");
                }
                System.out.println("Total Wage: " + totalWage(wageRate,partTimeHours));
                break;
            case monthly:
                int monthlyHours = 100;
                System.out.println("Total Wage: " + totalWage(wageRate,monthlyHours));
                break;
            default:
                System.out.print("Invalid input");
                break;
        }
    }
}
