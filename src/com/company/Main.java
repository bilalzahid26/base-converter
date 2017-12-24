package com.company;

import java.util.Arrays;


public class Main {

    public static int binaryToDecStand(String bin) {
        int dec = 0;
        int place = 1;
        String newBin = "";

        String binaryRep[] = bin.split("");


        for (int i = binaryRep.length - 1; i >= 0; i--)
            newBin = newBin + binaryRep[i];

        String binSplit[] = newBin.split("");
        for (int i = 0; i < binSplit.length; i++) {
            dec = dec + (Integer.parseInt(binSplit[i]) * place);
            place = place * 2;
        }


        return dec;
    }
    public static String hexToBinary(String hex) {

        return decToBinary(hexToDec(hex));
    }

    public static String hexToOctal(String hex) {

        return decToOctal(hexToDec(hex));

    }

    public static int hexToDec(String num) {
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
        return dec;
    }

    public static String decToHex(int num) {
        boolean twos = false;
        if (num < 0) {
            num = num * -1;
            twos = true;

        }
        String binaryEqv = decToBinary(num);
        int newPlace = binaryEqv.length() % 4;
        for (int i = 0; i < newPlace; i++) {
            binaryEqv = "0" + binaryEqv;
        }
        String newBin = "";
        for (int i = binaryEqv.length() - 1; i >= 0; i--)
            newBin = newBin + binaryEqv.charAt(i);
        String hex[] = binaryEqv.split("(?<=\\G.{" + 4 + "})");
        String hexVal = "";



        for (int i = 0; i < hex.length; i++) {
            String hexAct = "";
            switch (binaryToDecStand(hex[i])) {
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



        return hexVal;
    }

    public static String octalToBinary(String oct) {

        return decToBinary(octalToDec(oct));
    }

    public static String octToHex(String oct) {

        return decToHex(octalToDec(oct));

    }

    public static int octalToDec(String num) {
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
        return dec;
    }

    public static String decToOctal(int num) {
        String binaryEqv = decToBinary(num);
        int newPlace = binaryEqv.length() % 3;
        for (int i = 0; i < newPlace - 1; i++) {
            binaryEqv = "0" + binaryEqv;
        }
        String newBin = "";
        for (int i = binaryEqv.length() - 1; i >= 0; i--)
            newBin = newBin + binaryEqv.charAt(i);
        String octal[] = binaryEqv.split("(?<=\\G.{" + 3 + "})");
        String octalVal = "";
        for (int i = 0; i < octal.length; i++) {
            octalVal = octalVal + Integer.toString(binaryToDec(octal[i]));
        }
        return octalVal;
    }

    public static String binaryToOct(String bin) {

        return decToOctal(binaryToDec(bin));
    }

    public static String binaryToHex(String bin) {

        return decToHex(binaryToDec(bin));

    }

    public static int binaryToDec(String bin) {
        int dec = 0;
        int place = 1;
        String newBin = "";
        boolean twos = false;
        char first = bin.charAt(0); // just like array, string index is zero based

        if (first == '1') {
            twos = true;
        }
        String binaryRep[] = bin.split("");

        if (twos == true) {
            for (int i = 0; i < binaryRep.length; i++) {
                if (binaryRep[i].equals("1")) {
                    binaryRep[i] = "0";

                } else if (binaryRep[i].equals("0")) {
                    binaryRep[i] = "1";
                }
            }
            if (binaryRep[binaryRep.length-1].equals("1")) {
                binaryRep[binaryRep.length-1] = "0";

            } else {
                binaryRep[binaryRep.length-1] = "1";
            }

        }
        for (int i = binaryRep.length - 1; i >= 0; i--)
            newBin = newBin + binaryRep[i];

        String binSplit[] = newBin.split("");
        for (int i = 0; i < binSplit.length; i++) {
            dec = dec + (Integer.parseInt(binSplit[i]) * place);
            place = place * 2;
        }

if (twos == true){
            dec = dec*-1;
}
        return dec;
    }

    public static String decToBinary(int num) {
        String binaryRep[] = new String[10];

        Arrays.fill(binaryRep, "0");
        int index = 0;
        boolean twos = false;
        if (num < 0) {
            num = num * -1;
            twos = true;

        }
        while (num > 0) {
            binaryRep[index++] = Integer.toString(num % 2);
            num = num / 2;
        }
        if (twos == true) {
            for (int i = 0; i < binaryRep.length; i++) {
                if (binaryRep[i].equals("1")) {
                    binaryRep[i] = "0";

                } else if (binaryRep[i].equals("0")) {
                    binaryRep[i] = "1";
                }
            }
            if (binaryRep[0].equals("1")) {
                binaryRep[0] = "0";

            } else {
                binaryRep[0] = "1";
            }

        }
        String bin = "";
        for (int i = binaryRep.length - 1; i >= 0; i--) {
            bin = bin + binaryRep[i];
        }


        return bin;
    }

    public static void main(String a[]) {
        System.out.println(decToHex(88));

    }
}
