/* Sim3_MUX_8by1.java
 * Author: Omar R. Gebril
 */
public class Sim2_MUX_8by1 {

	public RussWire[] control; //3 bit input
	public RussWire[] in;	//8 bit input
	public RussWire out;
	
	public void execute() {
		// TODO Auto-generated method stub
		boolean first = !control[0].get() && !control[1].get() && !control[2].get() && in[0].get();
		boolean second = control[0].get() && !control[1].get() && !control[2].get() && in[1].get();
		boolean third = !control[0].get() && control[1].get() && !control[2].get() && in[2].get();
		boolean fourth = control[0].get() && control[1].get() && !control[2].get() && in[3].get();
		boolean fifth = !control[0].get() && !control[1].get() && control[2].get() && in[4].get();
		boolean sixth = control[0].get() && !control[1].get() && control[2].get() && in[5].get();
		boolean seventh = !control[0].get() && control[1].get() && control[2].get() && in[6].get();
		boolean eighth = control[0].get() && control[1].get() && control[2].get() && in[7].get();
		boolean finalR = first || second || third || fourth || fifth || sixth || seventh || eighth;
		out.set(finalR);
	}
	
	
	public Sim2_MUX_8by1()
	{
		control = new RussWire[3];
		in = new RussWire[8];
		out = new RussWire();
		
		for (int i=0;i<3;i++) {
			control[i] = new RussWire();
		}
		for (int j = 0; j<8;j++) {
			in[j] = new RussWire();
		}
		
	}
}
