package com.company;

import java.util.Arrays;


public class Main {


    public static String hexToBinary(String hex) {

        return decToBinary(hexToDec(hex));
    }

    public static String hexToOctal(String hex) {

        return decToOctal(hexToDec(hex));

    }

    public static int hexToDec(String num) {
        int sign = 1;
        if (num.contains("-")) {
num = num.replaceAll("-", "");
            sign = sign * -1;
        }
        int dec = 0;
        int place = 1;
        String num1 = num;
        String newHex = "";
        for (int i = num1.length() - 1; i >= 0; i--)
            newHex = newHex + num1.charAt(i);

        String hexSplit[] = newHex.split("");

        for (int i = 0; i < hexSplit.length; i++) {
            int hexAct = 0;
            switch (hexSplit[i]) {
                case "1":
                    hexSplit[i] = "1";
                    break;
                case "2":
                    hexSplit[i] = "2";
                    break;
                case "3":
                    hexSplit[i] = "3";
                    break;
                case "4":
                    hexSplit[i] = "4";
                    break;
                case "5":
                    hexSplit[i] = "5";
                    break;
                case "6":
                    hexSplit[i] = "6";
                    break;
                case "7":
                    hexSplit[i] = "7";
                    break;
                case "8":
                    hexSplit[i] = "8";
                    break;
                case "9":
                    hexSplit[i] = "9";
                    break;
                case "A":
                    hexSplit[i] = "10";
                    break;
                case "B":
                    hexSplit[i] = "11";
                    break;
                case "C":
                    hexSplit[i] = "12";
                    break;
                case "D":
                    hexSplit[i] = "13";
                    break;
                case "E":
                    hexSplit[i] = "14";
                    break;
                case "F":
                    hexSplit[i] = "15";
                    break;
                default:
                    hexAct = 0;
                    break;
            }
            dec = dec + (Integer.parseInt(hexSplit[i]) * place);
            place = place * 16;
        }
        return dec * sign;
    }

    public static String decToHex(int num) {
        String sign = "";
        if (num < 0) {

            sign = sign + "-";
            num = num *-1;
        }
        String hexVal = "";


        String binaryEqv = decToBinary(num);
        int newPlace = binaryEqv.length() % 4;
        for (int i = 0; i < newPlace; i++) {
            binaryEqv = "0" + binaryEqv;
        }
        String newBin = "";
        for (int i = binaryEqv.length() - 1; i >= 0; i--)
            newBin = newBin + binaryEqv.charAt(i);
        String hex[] = binaryEqv.split("(?<=\\G.{" + 4 + "})");


        for (int i = 0; i < hex.length; i++) {
            String hexAct = "";
            switch (binaryToDec(hex[i])) {
                case 1:
                    hexAct = "1";
                    break;
                case 2:
                    hexAct = "2";
                    break;
                case 3:
                    hexAct = "3";
                    break;
                case 4:
                    hexAct = "4";
                    break;
                case 5:
                    hexAct = "5";
                    break;
                case 6:
                    hexAct = "6";
                    break;
                case 7:
                    hexAct = "7";
                    break;
                case 8:
                    hexAct = "8";
                    break;
                case 9:
                    hexAct = "9";
                    break;
                case 10:
                    hexAct = "A";
                    break;
                case 11:
                    hexAct = "B";
                    break;
                case 12:
                    hexAct = "C";
                    break;
                case 13:
                    hexAct = "D";
                    break;
                case 14:
                    hexAct = "E";
                    break;
                case 15:
                    hexAct = "F";
                    break;
                default:
                    hexAct = "0";
                    break;
            }
            hexVal = hexVal + hexAct;
        }


        return sign + hexVal.replaceFirst ("^0*", "");
    }

    public static String octalToBinary(String oct) {

        return decToBinary(octalToDec(oct));
    }

    public static String octToHex(String oct) {

        return decToHex(octalToDec(oct));

    }

    public static int octalToDec(String num){
    int sign = 1;
        if (num.contains("-")) {
        num = num.replaceAll("-", "");
        sign = sign * -1;
    }


        int dec = 0;
        int place = 1;
        String num1 = num;
        String newOctal = "";
        for (int i = num1.length() - 1; i >= 0; i--)
            newOctal = newOctal + num1.charAt(i);

        String octSplit[] = newOctal.split("");
        for (int i = 0; i < octSplit.length; i++) {
            dec = dec + (Integer.parseInt(octSplit[i]) * place);
            place = place * 8;
        }
        return dec*sign;
    }

    public static String decToOctal(int num) {

        String sign = "";
        if (num < 0) {

            sign = sign + "-";
            num = num *-1;
        }
        String binaryEqv = decToBinary(num);

        int newPlace = binaryEqv.length() % 3;
        for (int i = 0; i < newPlace+1; i++) {
            binaryEqv = "0" + binaryEqv;
        }
        String newBin = "";
//        for (int i = binaryEqv.length() - 1; i >= 0; i--)
//            newBin = newBin + binaryEqv.charAt(i);
        String octal[] = binaryEqv.split("(?<=\\G.{" + 3 + "})");
        String octalVal = "";
        for (int i = 0; i < octal.length; i++) {
            octalVal = octalVal + Integer.toString(binaryToDec(octal[i]));
        }
        return sign + octalVal.replaceFirst ("^0*", "");
    }

    public static String binaryToOct(String bin) {

        return decToOctal(binaryToDec(bin));
    }

    public static String binaryToHex(String bin) {

        return decToHex(binaryToDec(bin));

    }

    public static int binaryToDec(String num) {
        int sign = 1;
        if (num.contains("-")) {
            num = num.replaceAll("-", "");
            sign = sign * -1;
        }
        int dec = 0;
        int place = 1;
        String newBin = "";


        String binaryRep[] = num.split("");


        for (int i = binaryRep.length - 1; i >= 0; i--)
            newBin = newBin + binaryRep[i];

        String binSplit[] = newBin.split("");
        for (int i = 0; i < binSplit.length; i++) {
            dec = dec + (Integer.parseInt(binSplit[i]) * place);
            place = place * 2;
        }


        return dec * sign;
    }

    public static String decToBinary(int num) {
        String sign = "";
        if (num < 0) {

            sign = sign + "-";
            num = num *-1;
        }

        String binaryRep[] = new String[10];
        String bin = "";

        Arrays.fill(binaryRep, "0");
        int index = 0;

            while (num > 0) {
                binaryRep[index++] = Integer.toString(num % 2);
                num = num / 2;
            }
            for (int i = binaryRep.length - 1; i >= 0; i--) {
                bin = bin + binaryRep[i];
            }

        return sign + bin.replaceFirst ("^0*", "");
    }

    public static void main(String a[]) {
        System.out.println(decToHex(-87));
        System.out.println(decToOctal(-87));
        System.out.println(decToBinary(-87));

        System.out.println(binaryToDec("-0001010111"));
        System.out.println(binaryToHex("-0001010111"));
        System.out.println(binaryToOct("-0001010111"));

       System.out.println(hexToDec("-057"));
        System.out.println(hexToOctal("-057"));
        System.out.println(hexToBinary("-057"));

        System.out.println(octalToDec("-0127"));
        System.out.println(octalToBinary("-0127"));
        System.out.println(octToHex("-0127"));
    }


}
