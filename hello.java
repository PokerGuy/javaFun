/**
 * Created by ezlotnick on 4/3/15.
 */
public class hello {

    public static void main(String args[]) {
        String errors = "";
        int x = 0;
        //Basic validations
        //Only one parameter
        if (args.length > 1) {
            errors += "Only one value can be passed in to the class. ";
        }
        //Must be an integer
        try {
            x = Integer.parseInt(args[0]);
        } catch (Exception e) {
            errors += "Only a value that can be parsed to an integer between -2,147,483,648 and 2,147,483,647 (the max value of an int in Java) can be accepted. ";
        }
        if (!errors.equals("")) {
            //There were errors in the input, display them...
            System.out.println(errors);
        } else {
            String message = "";
            //No errors, proceed with the parsing
            if (x == 0) {
                message = "Zero";
            } else {
                if (x < 0) {
                    message = "Negative ";
                    x = x * -1;
                }
                message += calc(x);
            }
            System.out.println(message);
        }
    }

    private static String calc(int num) {
        String msg = "";
        String numString = String.valueOf(num);
        int leadingzeroes = 3 - (numString.length() % 3);
        if (leadingzeroes == 2) {
            numString = "00" + numString;
        } else if (leadingzeroes == 1) {
            numString = "0" + numString;
        }
        int loops = numString.length() / 3;
        for (int i=1; i <= loops; i++){
            int offset = (i -1) * 3;
            String block = numString.substring(offset, offset + 3);
            String append = "";
            if (i ==1 && loops == 4) {
                append = "Billion ";
            } else if ((i == 2 && loops == 4) || (i == 1 && loops == 3)){
                append = "Million ";
            } else if ((i == 3 && loops == 4) || (i == 2 && loops == 3) || (i == 1 & loops == 2)) {
                append = "Thousand ";
            }
            msg += hundreds(block, append);
        }
        return msg;
    }

    private static String hundreds(String hundreds, String append) {
        String returnHundreds = "";
        String strHundreds = String.valueOf(hundreds);
        String firstDigit = strHundreds.substring(0, 1);
        String secondDigit = strHundreds.substring(1, 2);
        String thirdDigit = strHundreds.substring(2, 3);
        int intSecondDigit = Integer.parseInt(secondDigit);
        int intThirdDigit = Integer.parseInt(thirdDigit);
        if (!firstDigit.equals("0")) {
            returnHundreds += singleDigit(Integer.parseInt(firstDigit));
            returnHundreds += "Hundred ";
        }
        if (intSecondDigit == 0 && intThirdDigit >= 1) {
            returnHundreds += singleDigit(intThirdDigit);
        } else if (intSecondDigit == 1) {
            int teens = Integer.parseInt(secondDigit + thirdDigit);
            returnHundreds += teens(teens);
        } else if (intSecondDigit >= 2) {
            returnHundreds += tens(intSecondDigit);
            if (intThirdDigit >= 1) {
                returnHundreds += singleDigit(intThirdDigit);
            }
        }
        return returnHundreds + append;
    }

    private static String singleDigit(int digit) {
        String stringDigit = "";
        switch (digit) {
            case 0:
                stringDigit = "Zero ";
                break;
            case 1:
                stringDigit = "One ";
                break;
            case 2:
                stringDigit = "Two ";
                break;
            case 3:
                stringDigit = "Three ";
                break;
            case 4:
                stringDigit = "Four ";
                break;
            case 5:
                stringDigit = "Five ";
                break;
            case 6:
                stringDigit = "Six ";
                break;
            case 7:
                stringDigit = "Seven ";
                break;
            case 8:
                stringDigit = "Eight ";
                break;
            case 9:
                stringDigit = "Nine ";
                break;
        }
        return stringDigit;
    }

    private static String teens(int teen) {
        String stringTeen = "";
        switch (teen) {
            case 10:
                stringTeen = "Ten ";
                break;
            case 11:
                stringTeen = "Eleven ";
                break;
            case 12:
                stringTeen = "Twelve ";
                break;
            case 13:
                stringTeen = "Thirteen ";
                break;
            case 14:
                stringTeen = "Fourteen ";
                break;
            case 15:
                stringTeen = "Fifteen ";
                break;
            case 16:
                stringTeen = "Sixteen ";
                break;
            case 17:
                stringTeen = "Seventeen ";
                break;
            case 18:
                stringTeen = "Eighteen ";
                break;
            case 19:
                stringTeen = "Nineteen";
                break;
        }
        return stringTeen;
    }

    private static String tens(int tens) {
        String stringTens = "";
        switch (tens) {
            case 2:
                stringTens = "Twenty ";
                break;
            case 3:
                stringTens = "Thirty ";
                break;
            case 4:
                stringTens = "Forty ";
                break;
            case 5:
                stringTens = "Fifty ";
                break;
            case 6:
                stringTens = "Sixty ";
                break;
            case 7:
                stringTens = "Seventy ";
                break;
            case 8:
                stringTens = "Eighty ";
                break;
            case 9:
                stringTens = "Ninety ";
                break;
        }
        return stringTens;
    }
}
