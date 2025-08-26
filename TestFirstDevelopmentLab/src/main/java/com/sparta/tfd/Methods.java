package com.sparta.tfd;

public class Methods {

    // implement this method so that it returns true if x is greater than or equal to y
    public static boolean greaterEqual(int x, int y)
    {
        if (x >= y)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // implement this method so that it takes an int as an input,
    // squares it, adds 101, divides the result by 7, then subtracts 4.
    // return a double.
    public static double BODMAS(int inputNumber)
    {
        double inputNumber1 = inputNumber;
        inputNumber1 = (inputNumber1 * inputNumber1) + 101;
        inputNumber1 = inputNumber1 / 7;
        inputNumber1 = inputNumber1 - 4;
        return inputNumber1;
    }


    // implement this method so that it returns true if input is "password"
    // regardless of case
    public static boolean checkInput(String input)
    {
//        if(input.equals("password"))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
        input = input.toLowerCase();
        return input.equals("password");
    }

    // implement this method so that it returns the sum of all the numbers from start to end
    public static int sumNums(int start, int end )
    {
        int total = 0;
        for(int i = start; i <= end; i++)
        {
            total += i;
        }
        return total;
    }

    // implement this method so that it returns the sum
    // of all the numbers in the array nums
    public static int sumArray(int[] nums)
    {
        int total = 0;
        for ( int i = 0; i < nums.length; i++)
        {
            total+= nums[i];
        }
        return total;
    }
}
