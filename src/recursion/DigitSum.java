package recursion;

public class DigitSum {

    static int digitSum(int number){
        if(number < 10){
            return number;
        }
        int newNum = number / 10;
        return digitSum(newNum)+number % 10;
    }

    public static void main(String[] args){
        int t = digitSum(1122);
        System.out.print(t);
    }

}
