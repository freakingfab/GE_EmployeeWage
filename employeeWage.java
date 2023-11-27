import java.util.Random;
public class employeeWage {
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
        desc: provides total wage with employee wage rate and hours worked
        @params: wage rate and hours worked
        @return: total wage(int)
     */
    public static int totalWage(int wageRate, int hoursWorked){
        return wageRate*hoursWorked;
    }
}
