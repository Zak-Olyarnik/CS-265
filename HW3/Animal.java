import java.awt.Point;
import java.util.Random;

public abstract class Animal{

	protected Point location = new Point();
	private String animalName;
	public Random ranNumGen;

	public String getName()
	{return animalName;}

	public Point getLocation()
	{return location;}

	public void setStartLocation()
	// uses  RNG to set start location, shifted to make sure it is legal
	{
		int x = ranNumGen.nextInt(5);
		x = x+1;
		int y = ranNumGen.nextInt(5);
		y=y+1;
		location.move(x,y);
	}

	abstract void move();

	Animal( String name, Random rng )
	// constructor
	{
		animalName = name;
		ranNumGen = rng;
	}
}
