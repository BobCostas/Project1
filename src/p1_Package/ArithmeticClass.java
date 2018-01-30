package p1_Package;

public class ArithmeticClass {

    /**
     * Adds two digits in their base, returns sum
     * @param firstDigit
     * @param secondDigit
     * @return null if the bases are not the same, A new digitclass, whose value is the sum of firstDigit and secondDigit
     */
    public DigitClass addRegisters( DigitClass firstDigit, DigitClass secondDigit )
       {
           int currentDigit = 0;
           int maxDigits = getMax( firstDigit.maxDigits, secondDigit.maxDigits );
           int carry = 0;
           int base = 0;

           DigitClass firstDigitCopy = new DigitClass( firstDigit );
           DigitClass secondDigitCopy = new DigitClass( secondDigit );
           DigitClass sumDigit = new DigitClass( firstDigitCopy.base, firstDigitCopy.maxDigits, 0 );


          base = firstDigitCopy.base;

           if( !checkSameBases( firstDigit, secondDigit ) )
              {
                return null;
              }


          for( currentDigit = 0; currentDigit < maxDigits; currentDigit++)
             {
                 int sum = carry + firstDigitCopy.digitArray[ currentDigit ] +
                     secondDigitCopy.digitArray[ currentDigit ];


                 sumDigit.digitArray[ currentDigit ] = sum % base;

                 carry = sum / base;

             }
           sumDigit.numDigits = currentDigit;
           return sumDigit;

       }

       DigitClass subtractRegisters( DigitClass firstDigit, DigitClass secondDigit )

    /**
     * Helper method for operations done on two different registers.
     * @param digitOne The first digit we are performing an operation on.
     * @param digitTwo The second digit we are performing an operation on.
     * @return True if both digits have the same base
     */
    private boolean checkSameBases( DigitClass digitOne, DigitClass digitTwo )
          {
            return ( digitOne.base == digitTwo.base );
          }


    /**
     * Finds biggest of two integers.
     * @param valOne The value to be compared to valTwo.
     * @param valTwo The value to be compared to valOne.
     * @return The bigger of the two values.
     */
    int getMax(int valOne, int valTwo)
       {
            return valOne > valTwo ? valOne : valTwo;
       }
}
