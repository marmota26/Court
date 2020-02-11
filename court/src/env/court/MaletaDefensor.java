// CArtAgO artifact code for project court

package court;

import cartago.*;

public class MaletaDefensor extends Artifact {
	
	public Argument argument4;
	public Argument argument5;
	
	void init() {
		

		int[] atksA = new int[1];
		atksA[0] = 1;
		
		argument4 = new Argument(4, "PistolaDoCristiano", atksA);
		
		int[] atksB = new int[1];
		atksA[0] = 3;

		argument5 = new Argument(5, "PistolaNaAutopsia", atksB);
		
		defineObsProperty("digitais", "criminoso");
	}

	Argument getArgument4() {
		
		return argument4;
	}
	
	Argument getArgument5() {
		
		return argument5;
	}
}

