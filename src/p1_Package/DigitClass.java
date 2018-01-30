package p1_Package;

//////////// Class Header Information ////////////////

import java.util.Arrays;

/**
 * Class used to represent a digit in a base 2-9.
 * This class handles utility methods needed to
 * convert from decimal to base n and back again.
 *
 * @author Zane Fink
 */

public class DigitClass {
    /**
     * Description: Constructor for DigitClass.
     *
     * @param decNumber Decimal number that is going to be converted.
     * @param maxDigitSet Sets the maximum number of digits digitArray can hold.
     * @param setBase Base decNumber is going to be converted to.
     */
    public DigitClass( int setBase, int maxDigitSet, int decNumber )
        {
          //
          base = setBase;
          maxDigits = maxDigitSet;

          digitArray = new int[ maxDigits ]; // initialize our array, size of maxDigits
          digitArray = decToBase( decNumber ); // convert our base to decimal, store it in our digitArray

        }

    /**
     * Copy constructor for DigitClass
     * @param digitToCopy the DigitClass who we want a copy of
     */
    public DigitClass( DigitClass digitToCopy )
           {
               this.base = digitToCopy.base;
               this.numDigits = digitToCopy.numDigits;
               this.overFlow = digitToCopy.overFlow;
               this.numDigits = digitToCopy.numDigits;
               this.maxDigits = digitToCopy.maxDigits;

               initializeDigits(); // zero out our array

               int index;
               for( index = 0; index < digitToCopy.numDigits; index++) // copy the array from digitToCopy to this
                  {
                    digitArray[ index ] = digitToCopy.digitArray[ index ];
                  }

           }

    /**
     * The base our number is going to be stored in.
     */
    protected int base;

    /**
     * The array that is going to hold the digits of our number.
     */
    protected int[] digitArray;

    /**
     * The max digits digitArray can hold
     */
    protected int maxDigits;

    /**
     * The number of digits currently in our array
     */
    protected int numDigits;

    /**
     * overFlow flag, set if the current operation causes an overflow.
     */
    protected boolean overFlow = false;

    /**
     * Zeroes out all of the digits of an array
     * @return A new array, of all zeroes
     */
    public int[] initializeDigits()
       {
         int[] returnArray = new int[ maxDigits ]; // all elements are automatically zero, as per Java
         digitArray = returnArray;
         numDigits = 0;
         return returnArray;
       }

     public boolean isZero()
        {
            return ( ( numDigits <=1 )
                    && ( digitArray[ 0 ] == 0 ) );
        }


    /**
     * Converts positive integer to base specified within the object.
     * @param decValue The decimal number to be converted
     * @return Integer array holding the converted value, or null if base is outside of range
     *         (less than 2 or greather than 9)
     */
    public int[] decToBase( int decValue )
       {
        int decValueToConvert = decValue;
        int currentDigit = 0;
        numDigits = 0; // reset our number of digits counter
        int digitCounter;
        int[] convertedDigitArray = new int[ maxDigits ];

        if( ( base < 2 ) || ( base > 9 ) )
           {
            return null;
           }

        for( digitCounter = 0; digitCounter < maxDigits; digitCounter++ )
           {
            if( decValueToConvert == 0 ) // We only want to do this if we are not dividing by zero
               {
               return convertedDigitArray; // Return the uninitialized array
               }
            currentDigit = decValueToConvert % base;
            decValueToConvert /= base;

            convertedDigitArray[ digitCounter ] = currentDigit;
            numDigits++;
           }

           if( decValueToConvert > 0 ) // if, after our conversion, we still have digits, the operation overflowed
              {
                overFlow = true;
                return null;
              }
        digitArray = convertedDigitArray;
        return convertedDigitArray;
       }

    /**
     *  Raises an integer to a power.
     * @param intToRaise The int we waint to raise to power.
     * @param power the power we are raising the int to
     * @return The integer raised to power
     */
       public int intToPow( int intToRaise, int power )
          {
            if( power == 0 )
               {
                   return 1;
               }
               return intToRaise * intToPow( intToRaise, power - 1 );
          }
    /**
     * Helper function for getValueAsDecimal
     * <p>
     * Converts digit stored in digitArray to a decimal value.
     * @param digitArray the digitArray to have its value turned into a decimal.
     * @return The decimal value of the contents of the digitArray
     */
       private Integer baseToDec( int[] digitArray )
          {
            int convertedInt = 0;
            int currentDigit = 0;

            if( overFlow ) // An overflowed value will mess with our conversion, so we want to stop it
               {
                return null;
               }

            for( currentDigit = 0; currentDigit < numDigits; currentDigit++)
               {
                 int conversionInt = intToPow( base, currentDigit ); // base^currentDigit
                 int convertedDigit = digitArray[ currentDigit ] * conversionInt;
                 convertedInt += convertedDigit;
               }
            return convertedInt;

          }

    /**
     * Converts the objects inner digitArray to a decimal number
     * @return The decimal value of the digit
     */
    public int getValueAsDecimal()
          {
              int baseValAsDecimal = baseToDec( digitArray );
              return baseValAsDecimal;
          }
    public String getValueAsBase()
       {
        if( overFlow )
           {
            return "The value has been overflowed and cannot be printed.";
           }
        return Arrays.toString( digitArray );
       }
}
