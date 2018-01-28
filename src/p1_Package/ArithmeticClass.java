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
           int maxDigits = firstDigit.maxDigits;
           int carry = 0;
           boolean overflow = false;
           int base = 0;
           int[] sumDigitArray;
           int[] firstDigitCopyArray;
           int[] secondDigitCopyArray;
           int firstDigitCopyDecValue = 0;

           DigitClass firstDigitCopy = new DigitClass( firstDigit );
           DigitClass secondDigitCopy = new DigitClass( secondDigit );

          firstDigitCopyArray = firstDigitCopy.digitArray;
          secondDigitCopyArray = secondDigitCopy.digitArray;
          base = firstDigitCopy.base;

           firstDigitCopyDecValue = firstDigitCopy.getValueAsDecimal();
           // initialize the DigitClass whose value we will return
           DigitClass sumDigit = new DigitClass( firstDigitCopy.base, firstDigitCopy.maxDigits, firstDigitCopyDecValue);
           if( !checkSameBases( firstDigit, secondDigit ) )
              {
                return null;
              }

          sumDigit.initializeDigits();
          sumDigitArray = sumDigit.digitArray;

          for( currentDigit = 0; currentDigit < maxDigits; currentDigit++)
             {
                 int sum = firstDigitCopyArray[ currentDigit ] +
                            secondDigitCopyArray[ currentDigit ];
                 sumDigitArray[ currentDigit ] += carry;
                 carry = firstDigitCopyArray[ currentDigit ] /
                         secondDigitCopyArray[ currentDigit ];
                 sumDigitArray[ currentDigit ] = carry + ( sum % base);
                 carry = sum / base;
             }
           return sumDigit;

       }

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


}
