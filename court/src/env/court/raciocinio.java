// CArtAgO artifact code for project court

package court;

import cartago.*;

public class raciocinio extends Artifact {
	
	public Argument[] argumentList = new Argument[0]; 
	public Argument[] temp = new Argument[0]; 
	public Argument[] temp2 = new Argument[0]; 
	public Argument[] temp3 = new Argument[0]; 
	public Argument[] validArgumentList = new Argument[0];
	public int[] attacksReceived = new int[0];
	public Argument add;
	
	public void init() {
		
	}

	@OPERATION
	public void makeSimpleArgument(int i, String n, int a) {
		//signal("print", n);
		
		int[] aux = new int[1];
		aux[0] = a;
		add = new Argument(i,n,aux);
		addArgument(add);
	}
	
	@OPERATION
	public void addArgument(Argument a) {
		int aux;
		aux = argumentList.length + 1;
		
		temp3 = new Argument[aux];
		
		for(int i=0;i<argumentList.length;i++) {
			temp3[i] = argumentList[i];
		}
		temp3[argumentList.length] = a;
		
		argumentList = temp3;
		
		updateAttacks();
	}
	
	@OPERATION
	public void addValidArgument(Argument a) {
		int aux;
		aux = validArgumentList.length + 1;
		
		temp2 = new Argument[aux];
		
		for(int i=0;i<validArgumentList.length;i++) {
			temp2[i] = validArgumentList[i];
		}
		temp2[validArgumentList.length] = a;
		
		validArgumentList = temp2;
		
	}
	
	@OPERATION
	public void addAttack(int id, int[] attack) {
		
	}
	
	@OPERATION
	public void removeArgument(int id) {
		
	}
	
	@OPERATION
	public void removeTempArgument(int id) {
		int j = 0;
		boolean alreadyRemoved = true;
		int aux = temp.length - 1;
		
		for(int k=0;k<temp.length;k++) {
			if(temp[k].getId() == id) {
				alreadyRemoved = false;
			}
			
		}
		if(!alreadyRemoved) {
			if(aux>0) {
				Argument[] aux2 = new Argument[aux];
				for(int i=0;i<temp.length;i++) {
					if(temp[i].getId() != id) {
						aux2[j] = temp[i];
						j++;
					}
				}
			temp = aux2;
			
			for(int n =0;n<temp.length;n++) {//para cada temp arg
				if(temp[n].getAttacked() != null) {
					int blob = temp[n].getAttacked().length;
					//signal("print", "numero" + temp[n].getId());
					for(int w = 0;
							w < blob;
							w++) {//para cada relacao de atacado
						if(temp[n].getAttacked().length >= w) {
							if(temp[n].getAttacked()[w] == id) {//se foi atacado pelo arg que vai ser removido
								int[] help = new int[0];
								temp[n].setAttacked(help); //remove a relacao de atacado
							}
						}
					}
				}
			}
			
			
			} else {
				temp = new Argument[0];
			}
		} else {}
		
		
	}
	
	@OPERATION
	public void removeAttack(int id, int[] attack) {
		
	}
	
	@OPERATION
	public void updateAttacks() {
		int aux;
		aux = argumentList.length;
		
		int[] atklist;
		for(int i=0;i<aux;i++) {//para cada argumento
			atklist = argumentList[i].getAttacks();
			
			for(int j=0;j<atklist.length;j++) {//para cada ataque o argumento alvo recebe um ataque deste argumento
				for(int k=0;k<argumentList.length;k++) {
					if(argumentList[k].getId() == atklist[j]) {
						argumentList[k].addAttacked(argumentList[i].getId());
					}
				}
			}
		}
		
	}

	@OPERATION
	public void updateValidAttacks() {
		int aux;
		aux = validArgumentList.length;
		
		int[] atklist;
		for(int i=0;i<=aux;i++) {//para cada argumento
			atklist = validArgumentList[i].getAttacks();
			
			for(int j=0;j<atklist.length;j++) {//para cada ataque o argumento alvo recebe um ataque deste argumento
				for(int k=0;k<validArgumentList.length;k++) {
					if(validArgumentList[k].getId() == atklist[j]) {
						validArgumentList[atklist[j]].addAttacked(validArgumentList[i].getId());
					}
				}
			}
		}
		
	}
	
	@OPERATION
	public void updateValidArguments() {
		temp = argumentList;
		int validargumentAmount=0;
		boolean repeat = true;
		boolean alreadyAdded = false;
		while(repeat) {
		//signal("print", validargumentAmount);
			//printer(1);
			//printer(2);
			//printer(3);
			//printer(4);
			//printer(5);
			for(int i=0;i<temp.length;i++) {
				if(temp[i].getAttacked() != null) {
					if(temp[i].getAttacked().length == 0) {//se o argumento não sofre nenhum ataque, ele fica
					
						for(int m=0;m<validArgumentList.length;m++) {
							if(temp[i].getId() == validArgumentList[m].getId()) {
								alreadyAdded = true;
							} 
						}
						if(!alreadyAdded) {
							addValidArgument(temp[i]);
						}
					}
				}
			}
			
			if(validargumentAmount == validArgumentList.length) {//se não for adicionado nada novo, para o loop
				repeat = false;
			} else {
				validargumentAmount = validArgumentList.length;
			}
			
			for(int j=0;j<validArgumentList.length;j++) {//se o argumento sofre um ataque de um argumento da lista de válidos, ele é removido
				for(int k=0;k<validArgumentList[j].attacks.length;k++) { //para cada ataque do argumento da lista
					//signal("print", validArgumentList[j].attacks[k]);
					removeTempArgument(validArgumentList[j].attacks[k]);
				}
			
			}
		}
	}
	
	
	@OPERATION
	public void judge() {
		updateValidArguments();
		boolean verdict = false;
		
		for(int i=0; i<validArgumentList.length;i++) {
			
			signal("print", "Argumento Válido " + validArgumentList[i].getName());
			if(validArgumentList[i].getId() == 1 ||validArgumentList[i].getId() == 2) {
				verdict = true;
			}
		}
		if(verdict == false) {
			signal("print", "SemProvasSuficientes");
		} else {
		}
		
	}
	
	
	@OPERATION
	public void test() {
		signal("print", "Helllkjlkjlkjlkjlkjo");
	}
	
	@OPERATION
	public void printer(int id) {
		for(int i=0;i<argumentList.length;i++) {
			if(argumentList[i].getId() == id) {
				signal("print", argumentList[i].getAttacked());
			}
		}
	}
}

