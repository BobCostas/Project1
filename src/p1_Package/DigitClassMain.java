package p1_Package;

import java.util.Arrays;

public class DigitClassMain {
    public static void main(String[] args) {
        DigitClass firstDigit = new DigitClass(29, 06, 2);

        int decimalAsDigit[] = firstDigit.decToBase(40);

        String digitAsBase = Arrays.toString( decimalAsDigit );

        System.out.println(firstDigit.getValueAsDecimal());

        System.out.println(firstDigit.getValueAsBase());

        DigitClass secondDigit = new DigitClass(0, 7, 2);
        System.out.println(secondDigit.getValueAsBase());
        System.out.println(secondDigit.getValueAsDecimal());
    }
}