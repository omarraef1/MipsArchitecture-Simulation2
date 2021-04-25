/* FullAdder simulation implements two half adders
 * by linking them together
 * outputs sum and carryout
 *
 * Author: Omar R. Gebril
 */


public class Sim2_FullAdder {

	public RussWire a,b;
	public RussWire carryIn;
	public RussWire carryOut;
	public RussWire sum;
	public Sim2_HalfAdder halfAdd;
	public Sim2_HalfAdder halfAdd2;
	public AND and;
	public OR or;
	
	//Constructor
	//initializes all variables for inputs and outputs 
	// and halfadders
	public Sim2_FullAdder()
	{
		and = new AND();
		or = new OR();
		halfAdd = new Sim2_HalfAdder();
		halfAdd2 = new Sim2_HalfAdder();
		a   = new RussWire();
		b   = new RussWire();
		sum = new RussWire();
		

		carryIn = new RussWire();
		carryOut = new RussWire();
	}

	//two half adders executed on a and b inputs
	// then on the carry in and sum.
	// then calculates the final carryout of the two additions
	// using the two carryouts from them.
	public void execute() {
		//first halfadder
		halfAdd.a.set(a.get());
		halfAdd.b.set(b.get());
		halfAdd.execute();
		boolean carryA = halfAdd.carry.get();
		boolean sumA = halfAdd.sum.get();
		
		//second half adder
		halfAdd2.a.set(carryIn.get());
		halfAdd2.b.set(sumA);
		halfAdd2.execute();
		boolean sumB = halfAdd2.sum.get();
		boolean carryB = halfAdd2.carry.get();
		
		//carryOut of two carryOuts
		or.a.set(carryA);
		or.b.set(carryB);
		or.execute();
		carryOut.set(or.out.get());
		sum.set(sumB);
	}


}
