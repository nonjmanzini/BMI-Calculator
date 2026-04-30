//package bmicalculator;

import java.util.Scanner;
import java.util.Locale;

public class Bmicalculator{

public static void main(String [] args){
Scanner scan = new Scanner(System.in);

scan.useLocale(Locale.US);

char repeat;

System.out.println("\n -------------------");
System.out.println("\n   BMI CALCULATOR   ");
System.out.println("\n -------------------");

do{
	int unitChoice = getUnitChoice(scan);
	double weight = (unitChoice == 1)? getValidInput(scan, "Enter your weight in kilograms: ", 10, 600)
		:getValidInput(scan, "Enter your weight in pounds", 22, 1300);
		
		double height = (unitChoice == 1)? getValidInput(scan, "Enter your heigth in metres: ", 0.5, 2.5)
			:getValidInput (scan, "Enter your height in inches: ", 20, 100);
			
		double bmi = calculateBMI(unitChoice, weight, height);
		System.out.println("Your BMI is " + bmi);
		
	getBMICategory(bmi);
	giveAdvice(bmi);
	
	repeat = askToRepeat(scan);
	System.out.println();
	
	
	
}while (repeat == 'Y' || repeat == 'y');
scan.close();
}

public static char askToRepeat(Scanner scan){
	System.out.println("Do you want to repeat please type Y or N");
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


public static void getBMICategory(double bmi) {
    if (bmi < 18.5) {
        System.out.println("You are underweight. \n");
    } else if (bmi < 25) {
        System.out.println("You are normal weight. \n");
    } else if (bmi < 30) {
        System.out.println("You are overweight. \n");
    } else if (bmi < 35) {
        System.out.println("You are obese. \n");
	} else if (bmi >= 35) {
	System.out.println("You are severly Obese. \n");
		} 
}

		public static void giveAdvice(double bmi) {
    if (bmi < 18.5) {
        System.out.println("Being underweight can cause serious health risks. Consider seeing a healthcare provider. \n");
    } else if (bmi < 25) {
        System.out.println("Continue with a healthy lifestyle to maintain a healthy weight.\n");
    } else if (bmi < 30) {
        System.out.println("Consider reviewing your portion sizes, calorie intake and starting physical activity. \n");
    } else if (bmi < 35) {
        System.out.println("To avoid health issues review your portion sizes, calorie intake and start exercising. \n");
	} else if (bmi >= 35) {
	System.out.println("It is advisable to see a healthcare practioner for a weight management plan to avoid health complications. \n");
		} 
		
}
}
