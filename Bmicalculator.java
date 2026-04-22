package bmicalculator;

import java.util.Scanner;
import java.util.Locale;

public class Bmicalculator{

public static void main(String [] args){
Scanner scan = new Scanner(System.in);

scan.useLocale(Locale.US);

char repeat;

do{
	int unitChoice = getUnitChoice(scan);
	double weight = (unitChoice == 1)? getValidInput(scan, "Enter your weight in kilograms: ", 10, 600)
		:getValidInput(scan, "Enter your weight in pounds", 22, 1300);
		
		double height = (unitChoice == 1)? getValidInput(scan, "Enter your heigth in metres: ", 0.5, 2.5)
			:getValidInput (scan, "Enter your height in inches: ", 20, 100);
			
		double bmi = calculateBMI(unitChoice, weight, height);
		System.out.println("Your BMI is " + bmi);
	
	repeat = askToRepeat(scan);
	System.out.println();
	
}while (repeat == 'Y' || repeat == 'y');
}
public static char askToRepeat(Scanner scan){
	System.out.println("Do you want to repeat please type Y or y");
	char choice = scan.next().charAt(0);
	return choice;
}

public static int getUnitChoice(Scanner scan){
	int choice;
	
	while(true){
		System.out.println("Select a preferred unit:\n"
						+ "1. Metric (kg, m)\n"
						+ "2. Imperial (ibs, in)\n"
						+ "Please select either option 1 or option 2");
						
		if(scan.hasNextInt()){
			choice = scan.nextInt();
			if(choice == 1 || choice == 2){
				break;
			}else {
				System.out.println("Invalid choice. Please enter either 1 or 2");
			}
		}else {
		System.out.println("Invalid input. Please enter a number (1 or 2.)");
		scan.next();
	}
	}
	
	return choice;
}
	public static double getValidInput(Scanner scan, String prompt, double min, double max){
		double value;
		
		while(true) {
			System.out.println(prompt);
			
			if(scan.hasNextDouble()){
				value = scan.nextDouble();
				if(value >= min && value <= max){
					break;
				}else{
				System.out.printf("Please enter a value between %.1f and %.1f.\n", min, max);	
				}
			}else{
			System.out.println("Invalid input. Please enter a value");	
			scan.next();
			}	
				}
		return value;	
		
	}
public static double calculateBMI (int unitChoice, double weight, double height){
		double	totalBMI;
		
		if (unitChoice == 1){
			totalBMI = weight /(height * height);
		}else {
			totalBMI = (703 * weight) / (height/height);
		}
		return totalBMI;
	
}
}