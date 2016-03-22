/* will compute the number of milliseconds, seconds or days since January 1,
 * 1970, or the current time, based on command line arguments */

import java.util.Date;	// includes date class functions

public class prob4{
	public static void main( String[] args)
	{
		String strCode = args[0];
		int intCode = Integer.parseInt(strCode);
		Date currentDate = new Date();	// stores current date and time
		long mSec = currentDate.getTime(); // msec since 1/1/1970
		long sec = ( mSec / 1000 );		  // sec since 1/1/1970
		long day = (sec / 3600 / 24);		  // days since 1/1/1970

		switch ( intCode )
		{
			case 0:
				String strMSec = Long.toString(mSec);
				System.out.println("milliseconds since 1/1/1970 : " + strMSec);
				break;
			case 1:
				String strSec = Long.toString(sec);
				System.out.println("seconds since 1/1/1970 : " + strSec);
				break;
			case 2:
				String strDay = Long.toString(day);
				System.out.println("days since 1/1/1970 : " + strDay);
				break;
			case 3:
				System.out.println("current date and time: " + 
						currentDate.toString());
				break;
		}
	}
}

