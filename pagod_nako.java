import java.util.Scanner;

public class RadixTest {
    public static String radixConverter(double inputNumber, int base) {
        int integerPart = (int) inputNumber; 
        double fractionalPart = inputNumber - integerPart; 
        StringBuilder result = new StringBuilder();

        result.append(Integer.toString(integerPart, base).toUpperCase());

        if (fractionalPart > 0) {
            result.append(".");
            int precision = 5; 
            while (fractionalPart > 0 && precision > 0) {
                fractionalPart *= base;
                int fractionalInt = (int) fractionalPart; 
                result.append(Integer.toString(fractionalInt, base).toUpperCase());
                fractionalPart -= fractionalInt; 
                precision--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Enter the base of the number system (2-16) or 'stop' to EXIT: ");
            input = scan.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                System.out.println("PROGRAM STOPPED. THANK YOU");
                System.out.println("");
                break;
            }

            int base;
            try {
                base = Integer.parseInt(input);
                if (base < 2 || base > 16) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR! Base should be from 2 to 16 only. Please retry...");
                continue;
            }

            System.out.print("Please enter a NUMBER in BASE " + base + ": ");
            String inputNumber = scan.nextLine();   
            double number = Double.parseDouble(inputNumber);  

            System.out.println("SUCCESS! Here's the RADIX Conversion: ");
            for (int radix = 2; radix <= 16; radix++) {
                String convertedNumber = radixConverter(number, radix);
                System.out.println("Base " + radix + ": " + convertedNumber);
            }
        }
        scan.close();
    }
}
