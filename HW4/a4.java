import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class a4
{
	public static void main (String[] args)
	{
		if (args.length == 0)
		{
			System.out.println("To use the cash register, type:\n\'init " +
					"= {ones fives tens twenties}\',\n\'purchase {price} " +
					"= {ones fives tens twenties}\',\n\'change " +
					"{ones fives tens twenties} = " +
					"{requested ones fives tens twenties}\', or\n\'report\'. ");
			System.exit(1);	// bad arguments error
		}

		// initializes register "slots" and their constant values
		int amt = 0;
		int amt2 = 0;
		int ones = 0;
		int fives = 0;
		int tens = 0;
		int twenties = 0;
		final int VAL1 = 1;
		final int VAL5 = 5;
		final int VAL10 = 10;
		final int VAL20 = 20;

		// the first argument will be the name of the subcommand to be run
		String subcommand = args[0];

		switch(subcommand)
		{
			case "init":
			// initializes or overwrites drawer

				if (args.length < 4 || args.length > 7 ||
						!(args[2].equals("=")) || !(isInteger(args[1])) ||
						!(isInteger(args[3])))
				{System.exit(1);}   // bad arguments error
				
				amt = Integer.parseInt(args[1]);
				ones = Integer.parseInt(args[3]);
				
				// necessary to handle variable number of arguments
				if (args.length > 4)
				{
					if	(isInteger(args[4]))
						{fives = Integer.parseInt(args[4]);}
					else
						{System.exit(1);}		// bad arguments error
				}
				if (args.length > 5)
				{
					if	(isInteger(args[5]))
						{tens = Integer.parseInt(args[5]);}
					else
						{System.exit(1);}    // bad arguments error
				}
				if (args.length > 6)
				{
				 	if (isInteger(args[6]))
						{twenties = Integer.parseInt(args[6]);}
					else
						{System.exit(1);}    // bad arguments error
				}
				
				// calculates total and compares to expected, writes to file if
				// correct
				amt2 = ones*VAL1 + fives*VAL5 + tens*VAL10 + twenties*VAL20;
				if (amt != amt2)
				{System.exit(2);}	// non-matching amounts error
				else
				{
					String register = "0 : " + amt2 + " = " + ones + " " + fives
						+ " " + tens + " " + twenties;
					writeFile(register);
				}		

				break;


			case "purchase":

				if (args.length < 4 || args.length > 7 ||
						!(args[2].equals("="))|| !(isInteger(args[1])) ||
						                  !(isInteger(args[3])))
				{System.exit(1);}   // bad arguments error

				amt = Integer.parseInt(args[1]);
            ones = Integer.parseInt(args[3]);

				// necessary to handle variable number of arguments
			 if (args.length > 4)
            {
               if (isInteger(args[4]))
                  {fives = Integer.parseInt(args[4]);}
               else
                  {System.exit(1);}    // bad arguments error
            }
            if (args.length > 5)
            {
               if (isInteger(args[5]))
                  {tens = Integer.parseInt(args[5]);}
               else
                  {System.exit(1);}    // bad arguments error
            }
            if (args.length > 6)
            {
               if (isInteger(args[6]))
                  {twenties = Integer.parseInt(args[6]);}
               else
                  {System.exit(1);}    // bad arguments error
            }

				// calculates total and compares to expected
				amt2 = ones*VAL1 + fives*VAL5 + tens*VAL10 + twenties*VAL20;
				if (amt > amt2)
				{System.exit(2);}	// non-matching amounts error
				else
				{
					// gets contents of register
					String delim2 = "[ ]";
					String register = readFile();
					String[] registerVal = register.split(delim2);
					int registerSales = Integer.parseInt(registerVal[0]);
					int registerTotal = Integer.parseInt(registerVal[2]);
					int register1 = Integer.parseInt(registerVal[4]);
					int register5 = Integer.parseInt(registerVal[5]);
					int register10 = Integer.parseInt(registerVal[6]);
					int register20	= Integer.parseInt(registerVal[7]);
					
					// temporarily add to register, in case it would help make
					// change
					register1 = register1 + ones;
					register5 = register5 + fives;
					register10 = register10 + tens;
					register20 = register20 + twenties;
					
					// counters for output
					int change1 = 0;
					int change5 = 0;
					int change10 = 0;
					int change20 = 0;

					int change = amt2 - amt;
					
					// makes change by always picking the largest denomination
					// available, updating the register drawers, the change still
					// due, and the output counters
					while (change != 0)
					{
						while (change >= 20 )
						{
							if (register20 != 0)
							{
								register20 = register20 - 1;
								change = change - 20;
								change20 = change20 + 1;
							}
							else if (register10 != 0)
							{
								register10 = register10 - 1;
								change = change - 10;
								change10 = change10 + 1;
							}
							else if (register5 != 0)
							{
								register5 = register5 - 1;
								change = change - 5;
								change5 = change5 + 1;
							}  
							else if (register1 != 0)
							{
								register1 = register1 - 1;
								change = change - 1;
								change1 = change1 + 1;
							}
							else
							{System.exit(3);}
						}
						
						while  (change >= 10 )
						{
							if (register10 != 0)
							{
								register10 = register10 - 1;
								change = change - 10;
								change10 = change10 + 1;
							}
							else if (register5 != 0 )
							{
								register5 = register5 - 1;
								change = change - 5;
								change5 = change5 + 1;
							}
							else if (register1 != 0)
							{
								register1 = register1 - 1;
								change = change - 1;
								change1 = change1 + 1;
							}
							else
							{System.exit(3);}
						}
						
						while (change >= 5 )
						{
							if (register5 != 0)
							{
								register5 = register5 - 1;
								change = change - 5;
								change5 = change5 + 1;
							}
							else if (register1 != 0)
							{
								register1 = register1 - 1;
								change = change - 1;
								change1 = change1 + 1;
							}
							else
							{System.exit(3);}
						}

						while (change >= 1 )
						{
							if (register1 != 0)
							{
								register1 = register1 - 1;
								change = change - 1;
								change1 = change1 + 1;
							}
							else
							{System.exit(3);}
						}						
					} // while change != 0

					// Success making change
					System.out.println(change1 + " " + change5 + " " + change10 +
							" " + change20);
					registerSales = registerSales + amt;
					registerTotal = registerTotal + amt;
					register = registerSales + " : " + registerTotal + " = " +
						register1 + " " + register5 + " " + register10 + " " +
						register20;
					writeFile(register);

				}	// else


				break;
			
			
			case "change":
 			
				if (args.length < 4 || args.length > 10)
	         {System.exit(1);}   // bad arguments error
				
				// turn arguments array into one string
				String entered = "";
				for (String item : args)
				{entered = entered + " " + item;}
				
				// patse string into left and right arguments
				String delim1 = "=";
				String delim2 = "[ ]";
				entered = entered.trim();
				String[] tokens = entered.split(delim1);
				tokens[0] = tokens[0].trim();
				tokens[1] = tokens[1].trim();
				String[] left = tokens[0].split(delim2);
				String[] right = tokens[1].split(delim2);
				
				// store values or given and requested bills
				if (isInteger(left[1]))
				{ones = Integer.parseInt(left[1]);}
				else
				{System.exit(1);}		// bad arguments error
				if (left.length > 2)
				{
					if (isInteger(left[2]))
					{fives = Integer.parseInt(left[2]);}
					else
					{System.exit(1);}    // bad arguments error
				}
				if (left.length > 3)
				{
					if (isInteger(left[3]))				
					{tens = Integer.parseInt(left[3]);}
					else
					{System.exit(1);}    // bad arguments error
				}				
				if (left.length > 4)
				{
					if (isInteger(left[4]))				
					{twenties = Integer.parseInt(left[4]);}
					else
					{System.exit(1);}		// bad arguments error
				}

				int onesReq = 0;
				int fivesReq = 0;
				int tensReq = 0;
				int twentiesReq = 0;

				if (isInteger(right[0]))				
				{onesReq = Integer.parseInt(right[0]);}
				else
				{System.exit(1);}    // bad arguments error
				if (right.length > 1)
				{
					if (isInteger(right[1]))				
					{fivesReq = Integer.parseInt(right[1]);}
					else
					{System.exit(1);}		// bad arguments error
				}				
				if (right.length > 2)
				{	
					if (isInteger(right[2]))
					{tensReq = Integer.parseInt(right[2]);}
					else
					{System.exit(1);}    // bad arguments error
				
				}
				if (right.length > 3)
				{
					if (isInteger(right[3]))				
					{twentiesReq = Integer.parseInt(right[3]);}
					else
					{System.exit(1);}    // bad arguments error
				}
				
				// calculate and compare total amounts
				amt = ones*VAL1 + fives*VAL5 + tens*VAL10 + twenties*VAL20;
				amt2 = onesReq*VAL1 + fivesReq*VAL5 + tensReq*VAL10 +
					twentiesReq*VAL20;
			   
				if (amt != amt2)
				{System.exit(2);}	// non-matching amounts error
			   else
				{
					// read file and compare amounts requested to amounts present
					String register = readFile();
					String[] registerVal = register.split(delim2);
					int register1 = Integer.parseInt(registerVal[4]);
					int register5 = Integer.parseInt(registerVal[5]);
					int register10 = Integer.parseInt(registerVal[6]);
					int register20 = Integer.parseInt(registerVal[7]);

					if (register1 < onesReq || register5 < fivesReq || register10
							< tensReq || register20 < twentiesReq)
					{System.exit(3);}
					else
					{
						// make change and update file
						register1 = register1 - onesReq + ones;
						register5 = register5 - fivesReq + fives;
						register10 = register10 - tensReq + tens;
						register20 = register20 - twentiesReq + twenties;
						register = registerVal[0] + " " + registerVal[1] + " " +
							registerVal[2] + " " + registerVal[3] + " " + register1
							+ " " + register5 + " " + register10 + " " +
							register20;
						writeFile(register);
						System.out.println(onesReq + " " + fivesReq + " " +
								tensReq + " " + twentiesReq);
					}
				}


				break;
			
			
			case "report":
			// prints report of what's in the register
				
				if (args.length > 1)
				{
					//System.out.println("Error 1: Bad arguments");
					System.exit(1);	// bad arguments error
				}
		
				String register = readFile();

				// register value is stored in the correct format in
				// register.txt, so it can just be printed
				System.out.println(register);
				System.exit(0);	// all good
				break;
			
			
			default:
				//System.out.println("Error 1: Bad arguments");
				System.exit(1);	// bad arguments error
				break;
		}
	}	// main

	public static String readFile()
	{
 		// reads register value from file
		String file = "register.txt";
		String register = "";
		BufferedReader fileReader = null;
		
		try
		{
			fileReader = new BufferedReader(new FileReader(file));
			register = fileReader.readLine();
			fileReader.close();
		}
		catch(Exception e){System.exit(4);} // file error
		finally
		{
			try{fileReader.close();}
			catch(IOException e){System.exit(4);}	// file error
		}

		return register;

	}	// readFile

	public static void writeFile(String register)
	{
		// writes register value to file
		String file = "register.txt";
		BufferedWriter fileWriter = null;

		try
		{
			fileWriter = new BufferedWriter(new FileWriter(file, false));
			fileWriter.write(register);
			fileWriter.newLine();
			fileWriter.close();
		}
		catch(Exception e){System.exit(4);}	// file error
		finally
		{
			try{fileWriter.close();}
			catch(IOException e){System.exit(4);}  // file error
		}
	}	// writeFile


	public static boolean isInteger( String input )
	{
		try
		{
			Integer.parseInt( input );
			return true;
		}
		catch( Exception e ) {return false;}
	} // isInteger

}	// a4




