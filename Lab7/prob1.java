/* takes in a name from the command line and prints it 100 times */

public class prob1{
	public static void main( String[] args)
	{
		String userName = args[0];
		int i =0;
		while (i < 99)
		{
			userName = userName.concat(" " + args[0]);
			i++;
		}
		System.out.println(userName);
	}
}
