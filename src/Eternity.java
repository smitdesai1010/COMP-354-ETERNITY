import java.util.InputMismatchException;
import java.util.Scanner;

public class Eternity {

	//ToDO : handle invalid inputs
	//example: double x = Scanner.nextDouble()
	//what if the user enters a character
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {

		try
		{				
				System.out.println("Welcome to the Eternity");
				System.out.println("Team-D");
				
				
				System.out.println("----------MENU----------");
				System.out.println("1) arcos(x) ");
				System.out.println("2) ab^x ");
				System.out.println("3) log(x) ");
				System.out.println("4) Gamma function ");
				System.out.println("5) Mean Absolute Deviation ");
				System.out.println("6) Standard Deviation ");
				System.out.println("7) x^y ");
		
				System.out.print("\n\nEnter your choice: ");
				int choice = keyboard.nextInt();
				System.out.println("\n\n\n");
		
				performFunction(choice);
		}
		
		catch (InputMismatchException e)
		{
			System.out.println("Invalid Input "+e);
		}
		
		
		catch(Exception e)
		{
			System.out.println("Error in the main function "+e);
		}
		
		
		finally
		{
			keyboard.close();
		}
	}
	
	
	public static void performFunction(int index)
	{
		
		switch(index) 
		{
			case 1 : {
				System.out.println("arcos(x) \n");
				System.out.print("Enter x (Double value): ");
				double x = keyboard.nextDouble();
				
				//call arcos function(x)
				break;
			}
			
			
			case 2 : {				
				System.out.println("ab^x \n");

				System.out.print("Enter a (Double value): ");
				double a = keyboard.nextDouble();
				
				System.out.print("\nEnter b (Double value): ");
				double b = keyboard.nextDouble();
				
				System.out.print("\nEnter x (Double value): ");
				double x = keyboard.nextDouble();
				
				//call abx function
				break;
			}
			
			
			case 3 : {
				System.out.println("log(x) \n");

				System.out.print("Enter x (Double value): ");
				double x = keyboard.nextDouble();
				
				//call logx function
				break;
			}
			
			
			case 4 : {
				System.out.println("Gamma function \n");

				System.out.print("Enter x (Double value): ");
				double x = keyboard.nextDouble();
				
				//call gamma function
				break;
			}
			
			
			case 5 : {
				System.out.println("Mean Absolute Deviation \n");

				System.out.print("Enter comma seperated values (No spaces): ");
				String str = keyboard.next();
				
				//call the parser to convert x to array
				//call MAD function
				break;
			}
			
			
			case 6 : {
				System.out.println("Standard Deviation \n");

				System.out.print("Enter comma seperated values (No spaces): ");
				String str = keyboard.next();
				
				//call the parser to convert x to array
				//call SD function
				break;
			}
			
			
			case 7 : {				
				System.out.println("x^y \n");

				System.out.print("\nEnter x (Double value): ");
				double x = keyboard.nextDouble();
				
				System.out.print("\nEnter y (Double value): ");
				double y = keyboard.nextDouble();
				
				//call x^y function
				break;
			}
				
		
			default : {
				System.out.println("Invalid choice");
				break;
			}
		}

	}

}
