import java.util.ArrayList;
import java.util.Random;
import java.util.List;

/*
 desc: interface for adding companies in the system
 */
interface empWageInterface{
    void monthlyWage();
}

class employeeWage {
    private String companyName;
    private int wageRate;
    private int fullTimeHour;
    private int partTimeHour;

    private int monthlyWorkingHours;
    private int monthlyWorkingDays;

    /*
        @desc: constructor for class employeeWage
        @params: company name, wageRate, fullTimeHour, partTimeHour, monthlyWorkingHours, monthlyWorkingDays
        @return: void
     */
    public employeeWage(String companyName, int wageRate, int fullTimeHour, int partTimeHour, int monthlyWorkingHours, int monthlyWorkingDays){
        this.companyName =companyName;
        this.wageRate = wageRate;
        this.fullTimeHour = fullTimeHour;
        this.partTimeHour = partTimeHour;
        this.monthlyWorkingHours=monthlyWorkingHours;
        this.monthlyWorkingDays=monthlyWorkingDays;
    }

    /*
    @desc: getter for all the variable
     */

    public String getCompanyName(){
        return companyName;
    }

    public int getWageRate(){
        return wageRate;
    }

    public int getFullTimeHour(){
        return fullTimeHour;
    }

    public int getPartTimeHour(){
        return partTimeHour;
    }

    public int getMonthlyWorkingHours(){
        return monthlyWorkingHours;
    }

    public int getMonthlyWorkingDays(){
        return monthlyWorkingDays;
    }
}

class EmpWageBuilder{
    private static List<employeeWage> employers;

    /*
     desc: constructor for initialising the array;
     @param: array of employee wage objects
     @return: none
     */
    public EmpWageBuilder(){
        employers = new ArrayList<employeeWage>();
    }

    /*
     desc: function for adding objects
     params: object of employeeWage
     return: void
     */
    public static void addEmployer(employeeWage emp){
        employers.add(emp);
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

    /*
        desc: function for calculating monthly wage for an employee
        @params: employeeWage object
        @return: void
     */
    public static void monthlyWage() {
//        List<employeeWage> employers = employers;
        for (employeeWage emp: employers){
            System.out.println(emp.getCompanyName());
            System.out.println("Calculating Monthly Wages .....");
            int daysWorked = 0, hoursWorked = 0;
            while (daysWorked < emp.getMonthlyWorkingDays() && hoursWorked < emp.getMonthlyWorkingHours()) {
                int attendance = presentOrAbsent();
                if (attendance == 1) {
                    daysWorked += 1;
                    hoursWorked += emp.getFullTimeHour();
                } else if (attendance == 2) {
                    daysWorked += 1;
                    hoursWorked += emp.getPartTimeHour();
                }
            }
            int totalWage = totalWage(emp.getWageRate(), hoursWorked);
            System.out.println("Total Working Hours in a month: " + hoursWorked);
            System.out.println("Total Days Worked in a month: " + daysWorked);
            System.out.println("Total Wage for this month: " + totalWage);
        }
    }
}

public class EmpWageComp{
    public static void main(String[] args){
        System.out.println("Employee Wage System");
        employeeWage emp1 = new employeeWage("Company A", 20, 8, 8, 100, 20);
        employeeWage emp2 =new employeeWage("Company B", 25,8,8,100,20);

        EmpWageBuilder fab = new EmpWageBuilder();
        fab.addEmployer(emp1);
        fab.addEmployer(emp2);
        fab.monthlyWage();
    }
}