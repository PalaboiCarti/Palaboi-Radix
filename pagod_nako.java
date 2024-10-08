package radix_converter;
import java.util.Scanner;
public class radixTest {

	
		// TODO Auto-generated method stub
		
		
			public static int toDecimal(String inputNumber, int base) {
			return Integer.parseInt(inputNumber, base);
			}
			
			public static String fromDecimal(int inputNumber, int base) {
				return Integer.toString(inputNumber, base).toUpperCase();
				}
			
			public static void main(String[] args) {
				Scanner scan = new Scanner(System.in);
				String input;
				
				while (true) {
					System.out.println("Enter the base of the number system from (2-16) integers or 'stop' to EXIT: ");
					input = scan.nextLine();
					
					if (input.equalsIgnoreCase("stop")) {
						System.out.println("PROGRAM STOPPED. THANK YOU");
						System.out.println("");
						break;
			        }
					
					// for the base
					int base;
					try {
						base = Integer.parseInt(input);
						if (base < 2 || base > 16) {
							throw new NumberFormatException();
		                }
		            } catch (NumberFormatException Ashley) {
		            	System.out.println("ERROR! Base should be from 2 to 16 only. Please retry...");
		                continue;
		            }
					System.out.print("Please enter a NUMBER in BASE " + base + ": ");
					String inputNumber = scan.nextLine();
					
					//for the number input
					int decimalNumber;
					try {
						decimalNumber = toDecimal(inputNumber, base);
							}
					catch (NumberFormatException Nicole) {
						System.out.println("ERROR! Invalid NUMBER for the BASE " + base + ". PLease retry...");
						continue;
					}
					 System.out.println("SUCCESS! Here's the RADIX Conversion: ");
			            for (int radix = 2; radix <= 16; radix++) {
			                String convertedNumber = fromDecimal(decimalNumber, radix);
			                System.out.println("Base " + radix + ": " + convertedNumber);
			            }
						}
					}
				
	}


