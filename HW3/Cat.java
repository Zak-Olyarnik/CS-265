import java.util.Random;

public class Cat extends Animal {

	Cat( String name, Random rng )
	{ super(name,rng);}

	public void move()
	{
		double currentX = location.getX();
		double currentY = location.getY();
		int translate = ranNumGen.nextInt(4);

		switch(translate){
			// controls cat movement.  Readjusts position if cat would land on
			// water
			case 0:	// east
				currentX = currentX+1;
				if (currentX == 6)
					currentX = 4;
				break;
			case 1:	// north
				currentY = currentY+1;
				if (currentY == 6)
					currentY = 4;
				break;
			case 2:	// west
				currentX = currentX-1;
				if (currentX == 0)
					currentX = 2;
				break;
			case 3:	// south
				currentY = currentY-1;
				if (currentY == 0)
					currentY = 2;
				break;
		}

		location.setLocation(currentX,currentY);
	
	}
}
