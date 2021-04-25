/* Sim3_ALUElement.java
 * Author: Omar R. Gebril
 */
public class Sim2_ALUElement {

	public RussWire[] aluOp;
	public RussWire bInvert;
	public RussWire a;
	public RussWire b;
	public RussWire carryIn;
	public RussWire less;
	public RussWire result;
	public RussWire addResult;
	public RussWire carryOut;
	public Sim2_FullAdder fullAdd;
	public Sim2_FullAdder fullAdd2;
//	public OR or;
	public AND and;
	public AND and2;
	public OR or;
	public XOR xor;
	
	public Sim2_ALUElement() {
		and = new AND();
		and2 = new AND();
		or = new OR();
		xor = new XOR();
		
		aluOp = new RussWire[3];
		for (int i = 0; i<3;i++) {
			aluOp[i] = new RussWire();
		}
		bInvert = new RussWire();
		a = new RussWire();
		b = new RussWire();
		carryIn = new RussWire();
		less = new RussWire();
		result = new RussWire();
		addResult = new RussWire();
		carryOut = new RussWire();
		fullAdd = new Sim2_FullAdder();
		fullAdd2 = new Sim2_FullAdder();
	}
	public void execute_pass1() {
		// TODO Auto-generated method stub
		
		// binvert and aluOp?
		
		//boolean first = aluOp[0].get() && aluOp[1].get() && aluOp[2].get() && bInvert.get();
		
		and2.a.set(b.get());
		and2.b.set(bInvert.get());
		and2.execute();
		
		fullAdd.a.set(a.get());
		fullAdd.b.set(and2.out.get());
		
		
		fullAdd.carryIn.set(false);
		
		fullAdd.execute();
		
		addResult.set(fullAdd.sum.get());
		carryOut.set(fullAdd.carryOut.get());
		
		
	}
	public void execute_pass2() {
		// TODO Auto-generated method stub
		boolean first = aluOp[0].get() && aluOp[1].get() && aluOp[2].get() && less.get();

		
		
		
		and.a.set(addResult.get());
		and.b.set(first);
		and.execute();
		
		
		
		
		result.set(and.out.get());
	}

}
