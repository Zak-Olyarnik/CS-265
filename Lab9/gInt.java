import java.io.*;
import java.lang.Math;

public class gInt
{

	private int nReal;
	private int nImag;

	public gInt(int r)
	{
		nReal = r;
		nImag = 0;
	}

	public gInt(int r, int i)
	{
		nReal = r;
		nImag = i;
	}

	int real()
	{
		// pre-cond: nReal not null
		// post-cond: return nReal
		return nReal;
	}

	int imag()
	{
		// pre-cond: nImag not null
		// post-cond: return nImag
		return nImag;
	}

	public gInt add(gInt rhs)
	{
		// pre-cond: gInt and rhs not null
		// post-cond: returns the sum as computed by the given fomula
		return new gInt(real()+rhs.real(), imag()+rhs.imag());
	}

	public gInt multiply(gInt rhs)
	{
		// pre-cond: gInt and rhs not null
		// post-cond: returns the product as computed by the given formula
		return new gInt((real()*rhs.real()) - (imag()*rhs.imag()),
				(real()*rhs.imag()) + (imag()*rhs.real()));
	}

	public float norm() //L2 norm, sqrt(nReal^2+nImag^2)
	{
		// pre-cond: gInt not null
		// post-cond: the L2 norm as computed by the given formula.  Must be
		// converted to different data types several times to make use of the
		// sqrt() function and the given return type
		double doubleForSQRT = ((real()*real()) + (imag()*imag()));
		double afterSQRT = Math.sqrt(doubleForSQRT);
		float floatForReturn = (float) afterSQRT;
		return floatForReturn;
	}

	public boolean equals( Object anObject)	
		// necessary to use assetEquals()
	{
		// pre-cond: neither object null
		// post-cond: will either be true or false
		if(anObject instanceof gInt)
		{
			gInt agInt = (gInt)anObject;
			return agInt.real() == real() && agInt.imag() == imag();
		}
		return false;
	}

}
