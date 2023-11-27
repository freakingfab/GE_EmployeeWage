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

}
