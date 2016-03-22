import java.util.Random;

public class Mouse extends Animal {

	Mouse( String name, Random rng )
	{ super(name,rng);}
	
	public void move()
	{
		double currentX = location.getX();
		double currentY = location.getY();
		int translate = ranNumGen.nextInt(4);
		
		switch(translate){
			// controls mouse movement
			case 0:	// east
				currentX = currentX+1;
				break;
			case 1:	// north
				currentY = currentY+1;
				break;
			case 2:	// west
				currentX = currentX-1;
				break;
			case 3:	// south
				currentY = currentY-1;
				break;
		}
		
		location.setLocation(currentX,currentY);
	}
}

