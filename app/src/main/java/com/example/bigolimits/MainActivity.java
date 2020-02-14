package com.example.bigolimits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Arrays;

//1. Write a method that takes an int array and a int target value as parameters.
//The int Array will be a guaranteed to be a sorted array of unique  positive values.
//Have the method find the index in the target value if it exist in the array.
//If not, return -1.  Time complexity allowed:  O ( log n )

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int intArr[] = {1,2,3,4,5,6,10,20,50};
        BinarySearch bSearch = new BinarySearch();
        int n = intArr.length;
        int intTarget = 20;
        int intTargetIndex = bSearch.binarySearch(intArr, 0, n - 1, intTarget);

        if (intTargetIndex == -1) {
            System.out.println("Target not found");
        } else {
            System.out.println("Target found at index: " + intTargetIndex);
        }

        //2.  Write a method to calculate the value of n^m.
        //The method MUST have a time complexity of less than O( n ) ;
        //m can be any int value (negative and positive)

        PowerOfPow newPowerOf = new PowerOfPow();
        int intN = 5;
        int intM = -2;
        int intPrintM = intM;
        double dblResult = 0.0;
        //double dblResult = newPowerOf.powerOfPow(intN, intM);   Used for preliminary testing
        //System.out.println(intN + "^" + intPrintM + " is equal to: " + dblResult);

        if (intM >= 0) {
            dblResult = powerOfRecur(intN, intM);
        }
        if (intM < 0) {
            intM = intM * -1;
            dblResult = powerOfRecur(intN, intM);
            dblResult = (1/dblResult);
        }

        System.out.println(intN + "^" + intPrintM + " is equal to: " + dblResult);

        //3. Write a program to remove duplicates from an array in Java without using the Java Collection API.
        RemoveDupes newRemove = new RemoveDupes();
        Integer[] arrayWDuplicates = new Integer[] {1, 2, 3, 3, 4, 4, 4, 5, 6, 6, 7, 7, 7};

        System.out.println(Arrays.toString(arrayWDuplicates));
        Integer[] arrayNoDupes = newRemove.removeDupes(arrayWDuplicates);
        System.out.println(Arrays.toString(arrayNoDupes));
    }

    class BinarySearch{
        int binarySearch(int intArr[], int a, int b, int c) {
            int intMiddle = 0;

            if (b >= a) {
                // set intMiddle to the middle of the array
                intMiddle = a + (b - 1) / 2;

                if (intArr[intMiddle] == c) {
                    // if middle of the array is equal to target, return index
                    return intMiddle;
                }

                if (intArr[intMiddle] > c){
                    // return the search for the bottom half of the array
                    return binarySearch(intArr, a, intMiddle - 1, c);
                }
                return binarySearch(intArr, intMiddle + 1, b, c);
            }
            return -1;
        }
    }

    class PowerOfPow {
        double powerOfPow(int n, int m) {
            double dblResult = 0;
            double dblN = n;
            double dblM = m;

            dblResult = Math.pow(dblN, dblM);

            return dblResult;
        }
    }

    public static double powerOfRecur(int n, int m) {
        if (m != 0){
            return (n * powerOfRecur(n, m - 1));
        } else {
            return 1;
        }
    }

    class RemoveDupes {
        Integer[] removeDupes(Integer[] intArray) {
            Integer[] newArray = new Integer[intArray.length];
            int j = 0;

            for(int i = 0; i < intArray.length - 1; i++){
                Integer curInt = intArray[i];

                if (curInt != intArray[i + 1]){
                    newArray[j++] = curInt;
                }
            }

            newArray[j++] = intArray[intArray.length - 1];
            return newArray;
        }
    }

}
