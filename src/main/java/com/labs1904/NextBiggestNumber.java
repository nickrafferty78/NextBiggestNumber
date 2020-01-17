package com.labs1904;

import java.util.Arrays;

public class NextBiggestNumber {

    public static void main(String[] args) {
        //Integer input = Integer.parseInt(args[0]);
        Integer input =80263;
        Integer nextBiggestNumber = getNextBiggestNumber(input);
        System.out.println("Input: " + input);
        System.out.println("Next biggest number: " + nextBiggestNumber);
    }

    public static int getNextBiggestNumber(Integer i) {
        String temp = Integer.toString(i);
        int [] numArray = new int[temp.length()];
        //I need to get temp into a number array of digits
        for(int j=0; j<temp.length(); ++j){
            numArray[j] = temp.charAt(j) - '0';
        }

        //now with numArray I need to do the meat of the problem. Find the next largest int
        int stoppingPoint=0;
        for(int j=numArray.length-1; j>0; j--){
            if(numArray[j] > numArray[j-1]){
                stoppingPoint=j;
                break;
            }
        }
        //now I need to find the minimum number that is greater than numArray[j-1]
        if(stoppingPoint==0){
            return -1;
        }else{
            int min=numArray[stoppingPoint];
            int index = stoppingPoint;
            for(int l=stoppingPoint+1; l<=numArray.length-1; l++){
                //need to have a value that is larger than numArray[j-1] and smaller than numArray[j]
                if(numArray[l]<min && numArray[l]>numArray[stoppingPoint-1]){
                    min = numArray[l];
                    index= l;
                }
            }
            int tempVar = numArray[index];
            numArray[index]= numArray[stoppingPoint-1];
            numArray[stoppingPoint-1] = tempVar;
            //need to follow up with sorting the rest of the array smallest to largest
            Arrays.sort(numArray, stoppingPoint, numArray.length);
        }

        //last step, convert this array of digits, numArray, into one integer
        StringBuilder stringBuilderAns=new StringBuilder();
        for(int j=0;j<numArray.length; j++){
            stringBuilderAns.append(numArray[j]);
        }
        String stringAns = stringBuilderAns.toString();
        System.out.println(stringAns);
        int finalAns= Integer.parseInt(stringAns);
        return finalAns;
    }
}
