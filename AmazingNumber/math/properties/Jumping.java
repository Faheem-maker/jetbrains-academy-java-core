package numbers.math.properties;

import numbers.math.IProperty;

public class Jumping implements IProperty {
    @Override
    public boolean isTrue(long number) {
        int difference = 0;
        boolean flag = true;
        //assigning num to n
        long clone = number;
        //execute until the condition becomes false
        while (number != 0) {
            //determines the last digit from the given number
            int digit1 = (int) number % 10;
            //removes the last digit
            number /= 10;
            //checks if the number is equal to 0 or not
            if (number != 0) {
                //if the above condition returns true
                //determines the second last digit from the number
                int digit2 = (int) (number % 10);
                //subtract the digits and finds the absolute value
                //after that checks if the difference of two adjacent digit is equal to 1 or not
                if (Math.abs(digit1 - digit2) != 1) {
                    //if the difference is not equal to 1, set flag to false
                    flag = false;
                    //breaks the execution
                    break;
                }//end of if 2nd statement
            }//end of if 1st statement
        }//end of while
        return flag;
    }
}
