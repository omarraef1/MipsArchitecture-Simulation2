/* AdderX simulations implements multi-bit 
 * adder by linking together many full aders.
 * 
 *
 * Author: Omar R. Gebril
 */
public class Sim2_AdderX {

	public RussWire carryOut;
	public RussWire overflow;
	public RussWire[] sum;
	public RussWire[] a,b;
	public Sim2_FullAdder[] fullAdd;
	public NOT not;
	public XOR xor;
	public XOR xor2;
	public int c;

	//Constructor passing int i and storing in variable c
	//for later use in overflow calculation
	//initializes all vatiables
	//and arrays of RussWires or Sim2_FullAdders
	public Sim2_AdderX(int i) {
		c = i;
		not = new NOT();
		xor = new XOR();
		xor2 = new XOR();
		a = new RussWire[i];
		b = new RussWire[i];
		sum = new RussWire[i];
		fullAdd = new Sim2_FullAdder[i];
		carryOut = new RussWire();
		overflow = new RussWire();
		for (int j=0; j<i; j++)
		{
			a  [j] = new RussWire();
			b  [j] = new RussWire();
			sum[j] = new RussWire();
			fullAdd[j] = new Sim2_FullAdder();
			
		}
	
	}

	// loops over bit size array and checks 
	// carry in before executing fullAdder on a and b
	// then calculates sum and carryout and overflow
	public void execute() {
		boolean check = false;
		for (int i = 0; i<a.length; i++) {
			fullAdd[i].carryIn.set(check);
			fullAdd[i].a.set(a[i].get());
			fullAdd[i].b.set(b[i].get());
			fullAdd[i].execute();
			sum[i].set(fullAdd[i].sum.get());
			check = fullAdd[i].carryOut.get();
			
		}
		//carryOut output
		carryOut.set(check);
		
		//first xor 
		xor.a.set(a[c-1].get());
		xor.b.set(b[c-1].get());
		xor.execute();
		
		//not gate
		not.in.set(xor.out.get());
		not.execute();
		
		//second xor
		xor2.a.set(not.out.get());
		xor2.b.set(sum[c-1].get());
		xor2.execute();
		
		
		overflow.set(xor2.out.get());
	}

}
