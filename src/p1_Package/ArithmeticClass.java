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

    /**
     * Subtracts register two from register one, returns the difference
     * <p>
     *  Note: Registers are not modified within this method
     *  <p>
     * @param firstDigit Value to be subtracted from secondDigit
     * @param secondDigit The second value, which is having firstDigit subtracted from it
     * @return The positive difference between values, null if any failure occurred, including: 1) the bases
     * are not the same or, 2. Register 2 is numerically greater than register one
     */
       DigitClass subtractRegisters( DigitClass firstDigit, DigitClass secondDigit )
          {
            boolean carry = false;
            int currentDigit = 0;
            int base = firstDigit.base;
            int difference = 0;
            DigitClass firstDigitCopy = new DigitClass( firstDigit );
            DigitClass secondDigitCopy = new DigitClass( secondDigit );
            DigitClass differenceDigit = new DigitClass( firstDigit.base, firstDigit.maxDigits, 0 );

            if( getMax( firstDigitCopy.getValueAsDecimal(), secondDigitCopy.getValueAsDecimal() ) ==
                    secondDigitCopy.getValueAsDecimal()  ||
                 !checkSameBases( firstDigit, secondDigit ))
               {
                 return null;
               }

           for( currentDigit = 0; currentDigit < firstDigit.numDigits; currentDigit++ )
              {
                 if( carry )
                    {
                        firstDigitCopy.digitArray[ currentDigit ] -= base - 1;
                        carry = false;
                    }

                 if( secondDigitCopy.digitArray[ currentDigit ] >
                       firstDigitCopy.digitArray[ currentDigit ])
                    {
                      carry = true;
                      firstDigitCopy.digitArray[ currentDigit ] += base;
                    }
                  difference = firstDigitCopy.digitArray[ currentDigit ] - secondDigitCopy.digitArray[ currentDigit ];
                  firstDigitCopy.digitArray[ currentDigit ] -= difference;
                  differenceDigit.digitArray[ currentDigit ] = difference;
              }

           differenceDigit.numDigits = currentDigit;
           return differenceDigit;
          }

    /**
     * Multiplies register one by register two, returns product.
     * @param firstDigit The first digit to be multiplied
     * @param secondDigit The second digit do be multiplied
     * @return Product of two registers or null if the two registers are not the same base
     */
    public DigitClass multiplyRegisters( DigitClass firstDigit, DigitClass secondDigit )
          {
              int timesAdded = 0;

              DigitClass firstDigitCopy = new DigitClass( firstDigit );
              DigitClass secondDigitCopy = new DigitClass( secondDigit );
              DigitClass product = new DigitClass(firstDigitCopy.base, firstDigitCopy.maxDigits, 0);

              if( !checkSameBases( firstDigit, secondDigit ) )
                 {
                  return null;
                 }

              for( timesAdded = 0; timesAdded < secondDigitCopy.getValueAsDecimal(); timesAdded++ )
                 {
                   product = addRegisters( product, firstDigitCopy );
                 }

              return product;
          }

          DigitClass divideRegistersToRemainder( DigitClass firstDigit, DigitClass secondDigit )
             {

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
