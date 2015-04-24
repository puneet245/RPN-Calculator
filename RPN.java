import java.util.Scanner;
import java.util.Stack;


/**
 * @author puneet
 *
 */
public class RPN {

	boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	double evaluate( String input) throws Exception{

		Stack<String> stack = new Stack<String>();
		
		for(String s: input.split("\\s+")){
			if( isDouble( s ))
				stack.push(s);
			else{
				double right = Double.valueOf( stack.pop());
				double left = Double.valueOf( stack.pop());
				if( s.equals("+"))
					stack.push(String.valueOf(left+right));
				else if ( s.equals("-"))
					stack.push(String.valueOf(left-right));
				else if( s.equals("*"))
					stack.push(String.valueOf(left*right));
				else if( s.equals("/"))
					stack.push(String.valueOf(left/right));
				else throw new Exception();
			
		}
		
	}
		double result = Double.valueOf(stack.pop());
		if( !stack.empty())
			throw new Exception();
		else
			return result;

	}
	public static void main(String arg[]){
		
		RPN n = new RPN();
		String toContinue = "yes";
		Scanner sc = new Scanner(System.in);
		
		while( toContinue.equalsIgnoreCase("yes") )
		{
		System.out.println( "Enter the string in Reverse Polish Notation: \n");
		String input = sc.nextLine();
		try{
			if( input.trim().length() == 0)
				System.out.println("");
			else
				System.out.println( n.evaluate( input ) );
		}
		catch( Exception E )
		{
			System.out.println( "The input is invalid " + E );
		}
		
		toContinue = "";
		while ( !toContinue.equalsIgnoreCase("yes") && !toContinue.equalsIgnoreCase("no"))
		{
		System.out.println( "\nType YES to evaluate another RPN string or NO to exit:");
		toContinue = sc.nextLine();
		}
		
		if( toContinue.equalsIgnoreCase("no"))
			System.exit(0);
		
		}
		sc.close();
	}
}
