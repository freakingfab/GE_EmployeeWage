import java.util.Random;
import java.util.Scanner;

public class employeeWage {
    private int wageRate;
    private int fullTimeHour;
    private int partTimeHour;

    private int totalEmpWage;

    /*
        @desc: constructor for class employeeWage
        @params: wageRate, fullTimeHour, partTimeHour
        @return: void
     */
    public employeeWage(int wageRate, int fullTimeHour, int partTimeHour){
        this.wageRate= wageRate;
        this.fullTimeHour = fullTimeHour;
        this.partTimeHour = partTimeHour;
    }

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
        System.out.println("Company A");
        employeeWage companyA= new employeeWage(8,20,10);
        System.out.println("Calculating Monthly Wages .....");
        int daysWorked=0, hoursWorked = 0;
        while(daysWorked<20 && hoursWorked<100){
            int attendance = presentOrAbsent();
            if(attendance==1){
                daysWorked+=1;
                hoursWorked+= companyA.fullTimeHour;
            }
            else if(attendance==2){
                daysWorked+=1;
                hoursWorked+= companyA.partTimeHour;
            }
        }
        int totalWage = totalWage(companyA.wageRate, hoursWorked);
        companyA.totalEmpWage=totalWage;
        System.out.println("Total Working Hours in a month: " + hoursWorked);
        System.out.println("Total Days Worked in a month: " + daysWorked);
        System.out.println("Total Wage for this month: " + totalWage);

        System.out.println("Company B");
        employeeWage companyB= new employeeWage(12,20,10);
        System.out.println("Calculating Monthly Wages .....");
        daysWorked=0; hoursWorked = 0;
        while(daysWorked<20 && hoursWorked<100){
            int attendance = presentOrAbsent();
            if(attendance==1){
                daysWorked+=1;
                hoursWorked+= companyB.fullTimeHour;
            }
            else if(attendance==2){
                daysWorked+=1;
                hoursWorked+= companyB.partTimeHour;
            }
        }
        totalWage = totalWage(companyB.wageRate, hoursWorked);
        companyB.totalEmpWage= totalWage;
        System.out.println("Total Working Hours in a month: " + hoursWorked);
        System.out.println("Total Days Worked in a month: " + daysWorked);
        System.out.println("Total Wage for this month: " + totalWage);
    }
}
