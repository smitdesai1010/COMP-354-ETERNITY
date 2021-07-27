package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Eternity {
	
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
		
		catch (NumberFormatException e)
		{
			System.out.println("Invalid character "+e);
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
				keyboard.nextLine();	//skip the new line delimiter
				String str = keyboard.nextLine();
				
				double[] input = parseCSV(str);
				MeanAbsoluteDeviation.MAD(input);
								
				break;
			}
			
			
			case 6 : {
				System.out.println("Standard Deviation \n");

				System.out.print("Enter comma seperated values (No spaces): ");				
				keyboard.nextLine();	//skip the new line delimiter
				String str = keyboard.nextLine();
				
				double[] input = parseCSV(str);				
				Standard_Deviation.StandardDeviation(input);
								
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
	
	
	
	
	public static double[] parseCSV(String csv)
	{
		String[] values = csv.split(",");
		double[] res = new double[values.length];
		
		for (int i = 0; i < values.length; ++i)
		{
			//can use this regex instead of try catch
			//https://stackoverflow.com/questions/3543729/how-to-check-that-a-string-is-parseable-to-a-double
			res[i] = eval(values[i].trim());
		}
		
		return res;
	}
	
	
	
	public static double eval(final String str) 
	{
        return new Object() 
        {
            int pos = -1, ch;
    
            void nextChar() 
            {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
    
            boolean eat(int charToEat) 
            {
                while (ch == ' ') 
                	nextChar();
                
                if (ch == charToEat) 
                {
                    nextChar();
                    return true;
                }
                
                return false;
            }
    
            double parse() 
            {
                nextChar();
                
                double x = parseExpression();
                
                if (pos < str.length()) 
                	throw new NumberFormatException("Unexpected: " + (char)ch);
                
                return x;
            }
    
            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor
    
            double parseExpression() 
            {
                double x = parseTerm();
                
                for (;;) 
                {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }
    
            double parseTerm() 
            {
                double x = parseFactor();
                
                for (;;) 
                {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }
    
            double parseFactor() 
            {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus
    
                double x;
                int startPos = this.pos;
                
                if (eat('(')) // parentheses
                { 
                    x = parseExpression();
                    eat(')');
                } 
                
                else if ((ch >= '0' && ch <= '9') || ch == '.') // numbers
                { 
                    while ((ch >= '0' && ch <= '9') || ch == '.') 
                    	nextChar();
                    
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } 
                
                else if (ch >= 'a' && ch <= 'z') 
                { // functions
                    while (ch >= 'a' && ch <= 'z') 
                    	nextChar();
                    
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = mySqrt(x);
                    // else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    // else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    // else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new NumberFormatException("Unknown function: " + func);
                } 
                
                
                else 
                    throw new NumberFormatException("Unexpected: " + (char)ch);
                
    
                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
    
                return x;
            }
        }.parse();
    }
	
	
    public static double mySqrt(double x) {

        double n = 1; 
        double cnt = 1; 
        
        while(true) 
        {
        	if(cnt == 200)
        		return  n; 
	    
        	n = n - (( (n*n)- x) /  (2*n)); 
        	cnt+=1;
        }
        
    }

}
