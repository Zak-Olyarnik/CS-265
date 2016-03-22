import junit.framework.*;

public class gIntTest extends TestCase
{
	private gInt r1i1;
	private gInt r5i2;
	private gInt rn2i3;
	private gInt r3in4;

	public gIntTest(String name)
	{
		super(name);
	}

	protected void setUp()
	{
		// gInts to test methods
		r1i1 = new gInt(1,1);
		r5i2 = new gInt(5,2);
		rn2i3 = new gInt(-2,3);
		r3in4 = new gInt(3,-4);
	}

	protected void tearDown(){}

	public static Test suite()
	{
		return new TestSuite(gIntTest.class);
	}



//   Tests



	public void testReal()
	{	
		// integers corresponding to the private data of the gInts defined
		// above
		int one = 1;
		int three = 3;
		int five = 5;
		int negTwo = -2;

		assertNotNull(one);
		assertNotNull(three);
		assertNotNull(five);
		assertNotNull(negTwo);

		assertNotNull(r1i1.real());
		assertNotNull(r5i2.real());
		assertNotNull(rn2i3.real());
		assertNotNull(r3in4.real());

		assertEquals(one, r1i1.real());
		assertEquals(five, r5i2.real());
		assertEquals(negTwo, rn2i3.real());
		assertEquals(three, r3in4.real());
	}

	public void testImag()
	{
		// integers corresponding to the private data of the gInts defined
		// above
		int one = 1;
		int two = 2;
		int three = 3;
		int negFour = -4;

		assertNotNull(one);
		assertNotNull(two);
		assertNotNull(three);
		assertNotNull(negFour);

		assertNotNull(r1i1.imag());
		assertNotNull(r5i2.imag());
		assertNotNull(rn2i3.imag());
		assertNotNull(r3in4.imag());

		assertEquals(one, r1i1.imag());
		assertEquals(two, r5i2.imag());
		assertEquals(three, rn2i3.imag());
		assertEquals(negFour, r3in4.imag());
	}

	public void testAdd()
	{
		gInt expected_r6i3 = new gInt(6,3);
		gInt expected_rn1i4 = new gInt(-1,4);
		gInt expected_r4in3 = new gInt(4,-3);

		assertNotNull(expected_r6i3);
		assertNotNull(expected_rn1i4);
		assertNotNull(expected_r4in3);

		assertNotNull(r1i1);
		assertNotNull(r5i2);
		assertNotNull(rn2i3);
		assertNotNull(r3in4);

		// basic case
		gInt result_r6i3 = r1i1.add(r5i2);
		assertNotNull(result_r6i3);
		assertEquals(expected_r6i3, result_r6i3);

		// order of operands does not matter
		result_r6i3 = r5i2.add(r1i1);
		assertNotNull(result_r6i3);
		assertEquals(expected_r6i3, result_r6i3);

		// adding w/ negative real
		gInt result_rn1i4 = r1i1.add(rn2i3);
		assertNotNull(result_rn1i4);
		assertEquals(expected_rn1i4, result_rn1i4);

		// adding w/ negative imaginary
		gInt result_r4in3 = r1i1.add(r3in4);
		assertNotNull(result_r4in3);
		assertEquals(expected_r4in3, result_r4in3);
	}

	public void testMultiply()
	{
		gInt expected_r3i7 = new gInt(3,7);
		gInt expected_rn5i1 = new gInt(-5,1);
		gInt expected_r7in1 = new gInt(7,-1);

		assertNotNull(expected_r3i7);
		assertNotNull(expected_rn5i1);
		assertNotNull(expected_r7in1);

		assertNotNull(r1i1);
		assertNotNull(r5i2);
		assertNotNull(rn2i3);
		assertNotNull(r3in4);

		// basic case
		gInt result_r3i7 = r1i1.multiply(r5i2);
		assertNotNull(result_r3i7);
		assertEquals(expected_r3i7, result_r3i7);

		// order or operands does not matter
		result_r3i7 = r5i2.multiply(r1i1);
		assertNotNull(result_r3i7);
		assertEquals(expected_r3i7, result_r3i7);

		// multiplying w/ negative real
		gInt result_rn5i1 = r1i1.multiply(rn2i3);
		assertNotNull(result_rn5i1);
		assertEquals(expected_rn5i1, result_rn5i1);

		// multiplying w/ negative imaginary
		gInt result_r7in1 = r1i1.multiply(r3in4);
		assertNotNull(result_r7in1);
		assertEquals(expected_r7in1, result_r7in1);
	}

	public void testNorm()
	{
		float expected_sqrt2 = (float) Math.sqrt(2);
		float expected_sqrt29 = (float) Math.sqrt(29);
		float expected_sqrt13 = (float) Math.sqrt(13);
		float expected_5 = (float) 5;

		assertNotNull(expected_sqrt2);
		assertNotNull(expected_sqrt29);
		assertNotNull(expected_sqrt13);
		assertNotNull(expected_5);

		assertNotNull(r1i1);
		assertNotNull(r5i2);
		assertNotNull(rn2i3);
		assertNotNull(r3in4);

		assertEquals(r1i1.norm(), expected_sqrt2);
		assertEquals(r5i2.norm(), expected_sqrt29);
		assertEquals(rn2i3.norm(), expected_sqrt13);
		assertEquals(r3in4.norm(), expected_5);
	}

	public void testEquals()
	{
		gInt expected_r1i1 = new gInt(1,1);
		gInt expected_r5i2 = new gInt(5,2);
		gInt expected_rn2i3 = new gInt(-2,3);
		gInt expected_r3in4 = new gInt(3,-4);

		assertNotNull(expected_r1i1);
		assertNotNull(expected_r5i2);
		assertNotNull(expected_rn2i3);
		assertNotNull(expected_r3in4);

		assertNotNull(r1i1);
		assertNotNull(r5i2);
		assertNotNull(rn2i3);
		assertNotNull(r3in4);

		// object equality with itself
		assertEquals(r1i1, r1i1);
		assertEquals(r5i2, r5i2);
		assertEquals(rn2i3, rn2i3);
		assertEquals(r3in4, r3in4);
		assertEquals(expected_r1i1, expected_r1i1);
		assertEquals(expected_r5i2, expected_r5i2);
		assertEquals(expected_rn2i3, expected_rn2i3);
		assertEquals(expected_r3in4, expected_r3in4);

		// basic case
		assertEquals(r1i1, expected_r1i1);
		assertEquals(r5i2, expected_r5i2);
		assertEquals(rn2i3, expected_rn2i3);
		assertEquals(r3in4, expected_r3in4);
								       
		// order of operands does not matter
		assertEquals(expected_r1i1, r1i1);
		assertEquals(expected_r5i2, r5i2);
		assertEquals(expected_rn2i3, rn2i3);
		assertEquals(expected_r3in4, r3in4);

		// not equivalent
		assertFalse(r1i1.equals(r5i2));
		assertFalse(r5i2.equals(rn2i3));
		assertFalse(rn2i3.equals(r3in4));
		assertFalse(r3in4.equals(r1i1));
	}



	public static void main(String args[])
	{
		//System.out.println("Done");
		String[] caseName = {gIntTest.class.getName()};
		junit.textui.TestRunner.main(caseName);
		//System.out.println("Done");
	}
}
