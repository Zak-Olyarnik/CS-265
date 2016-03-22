import java.awt.Point;
import java.util.Random;

public class Chase {

	public static int playGame(Cat tom, Mouse jerry)
	{
		// defines locations of bridges
		Point bridge1 = new Point(2,0);
		Point bridge2 = new Point(4,0);
		Point bridge3 = new Point(6,2);
		Point bridge4 = new Point(6,4);
		Point bridge5 = new Point(4,6);
		Point bridge6 = new Point(2,6);
		Point bridge7 = new Point(0,4);
		Point bridge8 = new Point(0,2);

		// sets start locations, resetting mouse if they are the same
		tom.setStartLocation();
		jerry.setStartLocation();
		while(tom.getLocation().equals(jerry.getLocation()))
		{
			// debugging to test relocation
			//System.out.println(jerry.getLocation().getX());
			//System.out.println(jerry.getLocation().getY());
			//System.out.println(tom.getLocation().getX());
			//System.out.println(tom.getLocation().getY());
			jerry.setStartLocation();
		}

		boolean endgame = false;	// controls if game has ended
		while(!endgame)
		{
			jerry.move();
			if (jerry.getLocation().equals(tom.getLocation()))
			{
				endgame = true;
				// debugging used to confirm the correct spacing at endgame
				//System.out.println(jerry.getLocation().getX());
				//System.out.println(jerry.getLocation().getY());
				//System.out.println(tom.getLocation().getX());
				//System.out.println(tom.getLocation().getY());
				return 0;		// cat eats mouse
			}
			else if(jerry.getLocation().equals(bridge1) ||
					jerry.getLocation().equals(bridge2) ||
					jerry.getLocation().equals(bridge3) ||
					jerry.getLocation().equals(bridge4) ||
					jerry.getLocation().equals(bridge5) ||
					jerry.getLocation().equals(bridge6) ||
					jerry.getLocation().equals(bridge7) ||
					jerry.getLocation().equals(bridge8)){
						endgame = true;
						//  debugging used to confirm spacing at endgame
						//System.out.println(jerry.getLocation().getX());
						//System.out.println(jerry.getLocation().getY());
						return  1;		// mouse has landed on a bridge
			}
			else if(jerry.getLocation().getX() == 0 ||
					jerry.getLocation().getX() == 6 || jerry.getLocation().getY() == 0 ||
					jerry.getLocation().getY() == 6){
				endgame = true;
				//debugging usedto confirm spacing at endgame
				//System.out.println(jerry.getLocation().getX());
				//System.out.println(jerry.getLocation().getY());
				return 2;		// mouse has landed on water
			}

			tom.move();
			if (jerry.getLocation().equals(tom.getLocation()))
			{
				endgame = true;
				// debugging used to confirm the correct spacing at endgame
				//System.out.println(jerry.getLocation().getX());
				//System.out.println(jerry.getLocation().getY());
				//System.out.println(tom.getLocation().getX());
				//System.out.println(tom.getLocation().getY());
				return 0;		// cat eats mouse
			}
		}
		return 0;	// dummy return, Java complains otherwise
	}

	public static void main(String[] args)
	{
		Random rng = new Random();
		Cat c = new Cat("Tom", rng);
		Mouse m = new Mouse("Jerry", rng);
		float eaten=0;
		float drowned=0;
		float escaped=0;

		for(int i = 0; i < 30; i++)	// plays 30 games
		{
			String outPut = "";
			int result = playGame(c, m);

			switch(result){
				// converts game results into string output
				case 0:
					outPut = "The cat ate the mouse...";
					eaten+=1;
					break;
				case 1:
					outPut = "The mouse escaped!";
					escaped+=1;
					break;
				case 2:
					outPut = "The mouse drowned...";
					drowned+=1;
					break;
			}
			System.out.println(outPut);
		}
		
		System.out.println();
		
		float percent = eaten/30;
		percent = percent*100;
		System.out.format("The mouse was eaten %f percent of the time.%n", percent);
		
		percent = drowned/30;
		percent = percent*100;
		System.out.format("The mouse drowned %f percent of the time.%n",
				percent);

		percent = escaped/30;
		percent = percent*100;
		System.out.format("The mouse escaped %f percent of the time.%n",
				percent);

	}


}

