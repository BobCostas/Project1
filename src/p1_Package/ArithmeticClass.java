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

           if( !checkSameBases( firstDigit, secondDigit ) )
              {
                return null;
              }


          for( currentDigit = 0; currentDigit < maxDigits; currentDigit++)
             {
                 int firstDigitArrayDigit = firstDigitCopyArray[ currentDigit ];
                 int secondDigitArrayDigit = secondDigitCopyArray[ currentDigit ];
                 int sum = firstDigitArrayDigit +
                            secondDigitArrayDigit;
                 firstDigitCopyArray[ currentDigit ] += carry;
                 if( secondDigitArrayDigit > 0 )
                    {
                     firstDigitCopyArray[ currentDigit ] =  sum %
                                                     base;
                    }
                 if( ( carry > 0 ) &&
                     ( currentDigit >= firstDigitCopy.numDigits ) )
                    {
                     firstDigitCopy.numDigits++; // increment number of digits in the array
                    }

                 carry = sum / base;
             }
           return firstDigitCopy;

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
