/* halfAdder simulation implements 1-bit adder
 * that does not have a carry in bit
 *
 * Author: Omar R. Gebril
 */


public class Sim2_HalfAdder {

	public void execute() {
			xor.a.set(a.get());
			xor.b.set(b.get());
			xor.execute();
			
			
			sum.set(xor.out.get());
			
			and.a.set(a.get());
			and.b.set(b.get());
			and.execute();
			
			carry.set(and.out.get());
		
	}
	
	
	// inputs
		public RussWire a,b;
		
	//	public RussWire[] a,b;
		

		// outputs
		public RussWire sum;
		public RussWire carry;
		
		private XOR xor;
	//	private Sim2_XOR xor2;
		
		private AND and;

		//Constructor initializing a and b and xor / and gates
		//and carryout
		public Sim2_HalfAdder()
		{

			a   = new RussWire();
			b   = new RussWire();
			sum = new RussWire();
			
			and = new AND();
			
			xor = new XOR();
			

			carry = new RussWire();
		}

}
