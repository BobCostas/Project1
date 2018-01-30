package p1_Package;

public class ArithmeticClassMain {
    public static void main(String[] args ) {
        DigitClass firstDigit = new DigitClass(2, 10, 19);
        DigitClass secondDigit = new DigitClass(2, 10, 10);
        ArithmeticClass arithmeticClass = new ArithmeticClass();
        DigitClass sum = arithmeticClass.addRegisters(firstDigit, secondDigit);
        DigitClass difference = arithmeticClass.subtractRegisters(firstDigit, secondDigit);

//        System.out.println(sum.getValueAsBase());
//        System.out.println(sum.getValueAsDecimal());
//        System.out.println(sum.numDigits);


        System.out.println(difference);
        System.out.println(difference.getValueAsBase());
        System.out.println(difference.getValueAsDecimal());
    }
}
