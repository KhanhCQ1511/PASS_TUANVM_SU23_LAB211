/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _11_changebase;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author khanh
 */
public class Convert {

    public String convertValue(int inputBase, int outputBase, String inputValue) {
        String result = null;
        switch (inputBase) {
            //Option 2: convert Binary to Other
            case 1: {
                result = convertBinToOther(outputBase, inputValue);
                break;
            }
            //Option 10: Convert Decimal to Other
            case 2: {
                result = convertDecToOther(outputBase, inputValue);
                break;
            }
            //Option 16: Convert Hexadecimal to Other
            case 3: {
                result = convertHexaToOther(outputBase, inputValue);
                break;
            }
        }
        return result;
    }

    public String convertBinToOther(int outputBase, String inputValue) {
        BigInteger valueInput = new BigInteger(inputValue);
        switch (outputBase) {
            //Option 2: Convert Bin to Decimal
            case 2: {
                BigInteger decimal = BigInteger.ZERO;
                BigInteger inputBase = BigInteger.valueOf(2);
                int p = 0;
                //Loop until true
                while (true) {
                    //Check valueInput equals 0
                    if (valueInput.equals(BigInteger.ZERO)) {
                        break;
                    } else {
                        BigInteger digit = valueInput.mod(BigInteger.TEN);
                        decimal = decimal.add(digit.multiply(inputBase.pow(p)));
                        valueInput = valueInput.divide(BigInteger.TEN);
                        p++;
                    }
                }
                return decimal.toString();
            }
            //Option 3: Convert Bin to Hexadecimal
            case 3: {
                String hexa = "";
                int p = 0;
                //Loop until true
                while (true) {
                    //Check valueInput equals 0
                    if (valueInput.equals(BigInteger.ZERO)) {
                        break;
                    } else {
                        int group = 0;
                        //Loop use to access the first to last-4 element of String
                        for (int i = inputValue.length(); i >= 4; i -= 4) {
                            int digit1 = Character.digit(inputValue.charAt(i - 1), 2);
                            int digit2 = Character.digit(inputValue.charAt(i - 2), 2);
                            int digit3 = Character.digit(inputValue.charAt(i - 3), 2);
                            int digit4 = Character.digit(inputValue.charAt(i - 4), 2);
                            group = digit1 + digit2 * 2 + digit3 * 4 + digit4 * 8;
                            hexa = getHexDigit(group) + hexa;
                        }
                        //Check input value divide 4 # 0
                        if (inputValue.length() % 4 != 0) {
                            String remainingDigits = inputValue.substring(0, inputValue.length() % 4);
                            int remainingGroup = Integer.parseInt(remainingDigits, 2);
                            hexa = getHexDigit(remainingGroup) + hexa;
                        }
                    }
                    return hexa;
                }
            }
            default:
                return "";
        }
    }

    public String convertDecToOther(int outputBase, String inputValue) {
        BigInteger valueInput = new BigInteger(inputValue);
        switch (outputBase) {
            //Option 1: Convert Decimal to Binary
            case 1: {
                String binary = "";
                BigInteger inputBase = BigInteger.valueOf(2);
                ArrayList<BigInteger> binaryList = new ArrayList<>();
                //Loop until true
                while (true) {
                    //Check valueInput equals 0
                    if (valueInput.equals(BigInteger.ZERO)) {
                        break;
                    } else {
                        BigInteger digit = valueInput.mod(inputBase);
                        binaryList.add(digit);
                        valueInput = valueInput.divide(inputBase);
                    }
                }
                //loop use to access the last to the first element of list
                for (int i = binaryList.size() - 1; i >= 0; i--) {
                    binary += binaryList.get(i);
                }

                return binary;
            }
            //Option 3: Convert Decimal to Hexa
            case 3: {
                String hexa = "";
                BigInteger inputBase = BigInteger.valueOf(16);
                ArrayList<BigInteger> hexaList = new ArrayList<>();
                //Loop until true
                while (true) {
                    //Check valueInput equals 0
                    if (valueInput.equals(BigInteger.ZERO)) {
                        break;
                    } else {
                        BigInteger digit = valueInput.mod(inputBase);
                        hexaList.add(digit);
                        valueInput = valueInput.divide(inputBase);
                    }
                }
                //Loop use to access the last element to the first element of list
                for (int i = hexaList.size() - 1; i >= 0; i--) {
                    BigInteger hexDigit = hexaList.get(i);
                    int digit = hexDigit.intValue();
                    hexa += getHexDigit(digit);
                }
                return hexa;
            }
            default:
                return "";
        }
    }

    public String convertHexaToOther(int outputBase, String inputValue) {
        BigInteger valueInput = new BigInteger(inputValue, 16);
        switch (outputBase) {
            //Option 1: Convert Hexa to Binary
            case 1: {
                String binary = "";
                BigInteger decimal = BigInteger.ZERO;
                BigInteger inputBase = BigInteger.valueOf(16);
                ArrayList<BigInteger> hexaList = new ArrayList<>();
                ArrayList<BigInteger> binaryList = new ArrayList<>();
                int p = 0;
                // Loop to access the last to the first element of String
                for (int i = inputValue.length() - 1; i >= 0; i--) {
                    int hexa = getDecDigit(inputValue.charAt(i));
                    BigInteger digit = BigInteger.valueOf(hexa);
                    hexaList.add(digit);
                }
                // Loop to access the first element to the last element of list
                for (int i = 0; i < hexaList.size(); i++) {
                    decimal = decimal.add(hexaList.get(i).multiply(inputBase.pow(p)));
                    p++;
                }
                //Loop until decimal equals 0
                while (!decimal.equals(BigInteger.ZERO)) {
                    BigInteger digit = decimal.mod(BigInteger.valueOf(2));
                    binaryList.add(digit);
                    decimal = decimal.divide(BigInteger.valueOf(2));
                }
                // Loop to access the last to the first element of list
                for (int i = binaryList.size() - 1; i >= 0; i--) {
                    binary += binaryList.get(i);
                }

                return binary;
            }
            //Option 2: Convert Hexa to Decimal
            case 2: {
                BigInteger decimal = BigInteger.ZERO;
                BigInteger inputBase = BigInteger.valueOf(16);
                ArrayList<BigInteger> hexaList = new ArrayList<>();
                int p = 0;
                // Loop to access the last to the first element of String
                for (int i = inputValue.length() - 1; i >= 0; i--) {
                    int hexa = getDecDigit(inputValue.charAt(i));
                    BigInteger digit = BigInteger.valueOf(hexa);
                    hexaList.add(digit);
                }
                // Loop to access the first element to the last element of hexalist
                for (int i = 0; i < hexaList.size(); i++) {
                    decimal = decimal.add(hexaList.get(i).multiply(inputBase.pow(p)));
                    p++;
                }
                return decimal.toString();
            }
            default:
                return "";
        }

    }

    private String getHexDigit(int digit) {
        switch (digit) {
            case 0:
                return "0";
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return "";
        }
    }

    private static int getDecDigit(char digit) {
        switch (digit) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A' | 'a':
                return 10;
            case 'B' | 'b':
                return 11;
            case 'C' | 'c':
                return 12;
            case 'D' | 'd':
                return 13;
            case 'E' | 'e':
                return 14;
            case 'F' | 'f':
                return 15;
            default:
                return -1;
        }
    }
}
