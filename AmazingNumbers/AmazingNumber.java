package numbers;

public class AmazingNumber {
    /**
     * The number to display properties of
     */
    private long number;

    /**
     * Set the number
     * @param number the new number
     */
    public void setNumber(long number) {
        this.number = number;
    }

    public AmazingNumber() {
        number = 0;
    }

    /**
     * Check if the number is a buzz number.
     *
     * A buzz number is one that is divisible by 7 or ends with 7.
     * @return true if number is buzz, false otherwise.
     */
    public boolean isBuzz() {
        return number % 10 == 7 || number % 7 == 0;
    }

    /**
     * Check if the number is even.
     * @return true if the number is even, false otherwise.
     */
    public boolean isEven() {
        return number % 2 == 0;
    }

    /**
     * Check if the number is odd.
     *
     * @return true if number is odd, false otherwise.
     */
    public boolean isOdd() {
        return number % 2 != 0;
    }

    /**
     * Check if number is duck, (i.e. contains some zeros).
     *
     * @return true if number is duck, false otherwise.
     */
    public boolean isDuck() {
        return hasDigit(0);
    }

    /**
     * Check if number is palindromic
     * @return true if number is palindromic, false otherwise.
     */
    public boolean isPalindromic() {
        String numberStr = String.valueOf(number);
        String reversed = new StringBuilder(numberStr).reverse().toString();

        return numberStr.equals(reversed);
    }

    /**
     * Check if number is gapful
     * @return true if number is gapful, false otherwise.
     */
    public boolean isGapful() {
        if (number < 100) {
            return false;
        }
        long firstDigit = firstDigit();
        long lastDigit = number % 10;

        int divisor = Integer.parseInt(String.valueOf(firstDigit) + lastDigit);
        return number % divisor == 0;
    }

    /**
     * Display the properties in a single line.
     * @return a string representing the properties of current number.
     */
    public String getPropertiesString() {
        StringBuilder result = new StringBuilder();
        result.append(number);
        result.append(" is ");

        if (isEven()) {
            result.append("even, ");
        } else {
            result.append("odd, ");
        }
        if (isPalindromic()) {
            result.append("palindromic, ");
        }
        if (isBuzz()) {
            result.append("buzz, ");
        }
        if (isDuck()) {
            result.append("duck, ");
        }
        if (isGapful()) {
            result.append("gapful, ");
        }

        // Remove trailing commas
        result.setLength(result.length() - 2);

        return result.toString();
    }

    /**
     * Check if number contains a digit
     * @param digit Digit to check for
     * @return true if number contains digit, false otherwise
     */
    public boolean hasDigit(int digit) {
        long clone = number;
        while (clone > 0) {
            if (clone % 10 == digit)
                return true;

            clone = clone / 10;
        }
        return false;
    }

    /**
     * Get the first digit of current number.
     * @return The first digit of current number.
     */
    public long firstDigit() {
        long x = number;
        while (x > 9) {
            x /= 10;
        }
        return x;
    }
}
