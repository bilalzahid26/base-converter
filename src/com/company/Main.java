package com.company;

public class Main {

    public static void convertBinary(int num){
        int binary[] = new int[40];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
    }

    public void main(String a[]){
        System.out.println("Binary representation of 124: ");
        convertBinary(124);
        System.out.println("\nBinary representation of 45: ");
        convertBinary(45);
        System.out.println("\nBinary representation of 999: ");
        convertBinary(999);

}
}
