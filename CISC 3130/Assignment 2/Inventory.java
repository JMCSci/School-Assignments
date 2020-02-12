package assignment2;

public class Inventory {
	final double p1 = 2.00;
	final double p2 = 7.00;
	final double p3 = 8.50;
	
	int currentAmt1 = 0;
	int currentAmt2 = 0;
	int currentAmt3 = 0;
	
	int tempAmt1 = 0;
	int tempAmt2 = 0;
	int tempAmt3 = 0;
	
	String type = "";
	
	
	Inventory() {
		
	}
	
	public void calculate() {
		// If type is S -- add amount to current amount in warehouse
		if(type.matches("S")) {
			tempAmt1 = currentAmt1 + tempAmt1;
			tempAmt2 = currentAmt2 + tempAmt2;
			tempAmt3 = currentAmt3 + tempAmt3;
		// If type is O -- subtract	from current amount in warehouse
		} else if(type.matches("O")) {
			tempAmt1 = currentAmt1 - tempAmt1;
			tempAmt2 = currentAmt2 - tempAmt2;
			tempAmt3 = currentAmt3 - tempAmt3;
		}
		
		
	}
	
	public void setTempAmt1(int newValue) {
		tempAmt1 = newValue;
	}
	
	public void setTempAmt2(int newValue) {
		tempAmt2 = newValue;
	}

	public void setTempAmt3(int newValue) {
		tempAmt3 = newValue;
	}
	
	public void setCurrentAmt1(int newValue) {
		currentAmt1 = newValue;
	}
	
	public void setCurrentAmt2(int newValue) {
		currentAmt2 = newValue;
	}
	
	public void setCurrentAmt3(int newValue) {
		currentAmt3 = newValue;
	}
	
	public void setType(String newValue) {
		type = newValue;
		
	}
	
	public int getTempAmt1() {
		return tempAmt1;
	}
	
	public int getTempAmt2() {
		return tempAmt2;
	}
	
	public int getTempAmt3() {
		return tempAmt3;
	}
	
	public String getType() {
		return type;
	}




	

}
