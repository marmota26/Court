package court;

public class Argument {
	int id;
	String name;
	int[] attacks;
	int[] attacked = new int[0];
	int[] temp = new int[0];
	
	public Argument(int i, String n, int[] a) {
		id = i;
		name = n;
		attacks = a;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getAttacks() {
		return attacks;
	}

	public void setAttacks(int[] attacks) {
		this.attacks = attacks;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int[] getAttacked() {
		return attacked;
	}

	public void setAttacked(int[] attacked) {
		this.attacked = attacked;
	}
	
	public void addAttacked(int a) {
		
		int aux;
		aux = attacked.length + 1;
		
		temp = new int[aux];
		
		for(int i=0;i<attacked.length;i++) {
			temp[i] = attacked[i];
		}
		temp[attacked.length] = a;
		
		attacked = temp;
		
	}

	public int[] getTemp() {
		return temp;
	}

	public void setTemp(int[] temp) {
		this.temp = temp;
	}

	
	
}
