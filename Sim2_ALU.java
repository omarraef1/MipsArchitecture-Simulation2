/* Sim3_ALU.java
 * Author: Omar R. Gebril
 */
public class Sim2_ALU {

	public Sim2_ALU(int i) {
		// TODO Auto-generated constructor stub
		x = i;
		result = new RussWire[x];
		a = new RussWire[x];
		b = new RussWire[x];
		bNegate = new RussWire();
		aluOp = new RussWire[3];
		aluel = new Sim2_ALUElement[x];
		
		//aluel = new Sim2_ALUElement();
		for (int i1 = 0 ; i1<x;i1++) {
			aluel[i1] = new Sim2_ALUElement();
			result[i1] = new RussWire();
			a[i1]=new RussWire();
			b[i1]= new RussWire();
		}
		for (int j = 0; j<3; j++) {
			aluOp[j] = new RussWire();
		}
		
	}
	
	public int x; 	//amount passed

	public RussWire[] aluOp;
	public RussWire bNegate;
	public RussWire[] a;
	public RussWire[] b;
	public RussWire[] result;
	public Sim2_ALUElement[] aluel;
	
	
	
	public void execute() {
		// TODO Auto-generated method stub

		
		
		
		for (int k=0;k<x;k++) {
			aluel[k].bInvert.set(bNegate.get());

			aluel[k].aluOp[0].set(aluOp[0].get());
			aluel[k].aluOp[1].set(aluOp[1].get());
			aluel[k].aluOp[2].set(aluOp[2].get());
			
			aluel[k].a.set(a[k].get());
			aluel[k].b.set(b[k].get());
			aluel[k].execute_pass1();
			aluel[k].execute_pass2();
			result[k].set(aluel[k].result.get());
		}
		
	}


}
