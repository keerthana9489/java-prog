import java.util.Scanner;

public class calculator {
	public static void main (String []args){
		Scanner scanner=new Scanner(System.in);

		System.out.print("enter first number:");
                double num1=scanner.nextDouble();

		System.out.print("enter second number:");
                double num2=scanner.nextDouble();

		System.out.print("Choose Operation(+,-,*,/):");
		char operator=scanner.next().charAt(0);

		double result=0;

		switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				if (num2!=0) {
					result=num1/num2;
				} else {
					System.out.println("Divisible by zero is no allowed.");
					return;
				}
				break;
				default:	
				System.out.println("Invalid Operator.");
				return;
			}
			
			System.out.println("The Result is:"+result);
	}
}
           




















