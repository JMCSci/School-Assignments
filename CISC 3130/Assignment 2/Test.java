package assignment2;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.EOFException;

public class Test {
	static boolean change = false;  	 // if previous change true
	static int type_Index = 0;
	static int cityIndex = 2; 			 // increments of 14 (2, 16, 30, 44 ... etc)
	static int amt_1_Index = 4;
	static int amt_2_Index = 8;
	static int amt_3_Index = 11;
	static byte [] text = new byte [1];
	static byte [] column1 = new byte [3];
	static byte [] column2 = new byte [2];
	static byte [] column3 = new byte [2];
	static byte [] type = new byte [1];
	static String [] cityArray = {"New York", "Miami", "Los Angeles", "Houston", "Chicago"};
	
	public static void main(String[] args) throws Exception {
		String [] type = new String [18];
		int [][] inventory = new int [5][3];
		
		// Class used to calculate inventory
		Inventory warehouse = new Inventory();

		// Call function each time so that it is read sequentially
		initialInventory(inventory);
		for(int i = 0; i < type.length; i++) {
			readData(warehouse, inventory, cityArray);
		}
	}
	
	public static void initialInventory(int inventory[][]) {
		for(int i = 0; i < inventory.length; i++) {
			for(int j = 0; j < inventory[i].length; j++) {
				inventory[i][j] = 0;
			}
		}
		
	}
	
	/* readData: Read data into 2D array */
	public static void readData(Inventory warehouse, int inventory[][], String cityArray[]) throws Exception, EOFException{
		RandomAccessFile inout = new RandomAccessFile(new File("NumCity"), "r");
		int column = 0;
		int city = 0;
		
		// Get type
		inout.seek(type_Index);
		inout.read(type);
		// Save to string - typeByte
		String typeByte = new String(type); 
		// Get city
		inout.seek(cityIndex);
		inout.read(text);
		// Save to string - cityByte
		String cityByte = new String(text);
		// Convert cityByte to integer -- used in conditional
		city = Integer.parseInt(cityByte);
		
		// Get bytes and convert to integers - amt1, amt2, amt3
		inout.seek(amt_1_Index);
		inout.read(column1);
		String amt1 = new String(column1);
		inout.seek(amt_2_Index);
		inout.read(column2);
		String amt2 = new String(column2);
		inout.seek(amt_3_Index);
		inout.read(column3);
		String amt3 = new String(column3);		
	
		if(city == 0) {					// NEW YORK
			// Get current amount in warehouse
			warehouse.setCurrentAmt1(inventory[0][0]);
			warehouse.setCurrentAmt2(inventory[0][1]);
			warehouse.setCurrentAmt3(inventory[0][2]);
			
			warehouse.setType(typeByte);
			
			// Calculate amounts in warehouse -- from file
			warehouse.setTempAmt1(Integer.parseInt(amt1));
			warehouse.setTempAmt2(Integer.parseInt(amt2));
			warehouse.setTempAmt3(Integer.parseInt(amt3));
			
			// Hold amount read from file -- if necessary, use as requiredAmount
			int temp1 = warehouse.getTempAmt1();
			int temp2 = warehouse.getTempAmt2();
			int temp3 = warehouse.getTempAmt3();
			
			// Calculate warehouse totals
			warehouse.calculate();
			// If amount is negative -- check each warehouse to see which one cannot meet order
			// Call findItems method -- use item variable to check array column
			// Find warehouse with the most of item and have it send the amount instead
			if(warehouse.getTempAmt1() < 0 || warehouse.getTempAmt2() < 0 || warehouse.getTempAmt3() < 0) {
				//int largestValue = 0;
				int stockResult = 0;
				if(warehouse.getTempAmt1() < 0) {
					int item1 = 0;
					int requiredAmount = temp1;
					requiredAmount =+ warehouse.getTempAmt1();
					stockResult = findItems(warehouse, inventory, item1, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					// Update amounts add to array  
					inventory[0][column] += stockResult;
					column++;
					inventory[0][column] = warehouse.getTempAmt2();
					column++;
					inventory[0][column] = warehouse.getTempAmt3();
				} 
				
				if(warehouse.getTempAmt2() < 0) {
					int item2 = 1;
					int requiredAmount = temp2;
				//	int stockResult = 0;
					requiredAmount =+ warehouse.getTempAmt2();
					stockResult = findItems(warehouse, inventory, item2, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					// Update amounts add to array
					inventory[0][column] = warehouse.getTempAmt1();
					column++;
					inventory[0][column] += stockResult;
					column++;
					inventory[0][column] = warehouse.getTempAmt3();
				} 
				
				if(warehouse.getTempAmt3() < 0) {
					int item3 = 2;
					int requiredAmount = temp3;
					requiredAmount =+ warehouse.getTempAmt3();
					stockResult = findItems(warehouse, inventory, item3, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					inventory[0][column] = warehouse.getTempAmt1();
					column++;
					inventory[0][column] = warehouse.getTempAmt2();
					column++;
					inventory[0][column] += stockResult;
				}
			} else {
				// Update amounts add to array  
				inventory[0][column] = warehouse.getTempAmt1();
				column++;
				inventory[0][column] = warehouse.getTempAmt2();
				column++;
				inventory[0][column] = warehouse.getTempAmt3();
			}
			
		} else if(city == 1) {				// MIAMI	
			// Get current amount in warehouse
			warehouse.setCurrentAmt1(inventory[1][0]);
			warehouse.setCurrentAmt2(inventory[1][1]);
			warehouse.setCurrentAmt3(inventory[1][2]);
						
			warehouse.setType(typeByte);
						
			// Calculate amounts in warehouse -- from file
			warehouse.setTempAmt1(Integer.parseInt(amt1));
			warehouse.setTempAmt2(Integer.parseInt(amt2));
			warehouse.setTempAmt3(Integer.parseInt(amt3));
			
			// Hold amount read from file -- if necessary, use as requiredAmount
			int temp1 = warehouse.getTempAmt1();
			int temp2 = warehouse.getTempAmt2();
			int temp3 = warehouse.getTempAmt3();
						
			// Calculate warehouse totals
			warehouse.calculate();
			// If amount is negative -- check each warehouse to see which one cannot meet order
			// Call findItems method -- use item variable to check array column
			// Find warehouse with the most of item and have it send the amount instead
			if(warehouse.getTempAmt1() < 0 || warehouse.getTempAmt2() < 0 || warehouse.getTempAmt3() < 0) {
				int stockResult = 0;
				if(warehouse.getTempAmt1() < 0) {
					int item1 = 0;
					int requiredAmount = temp1;
					requiredAmount =+ warehouse.getTempAmt1();
					stockResult = findItems(warehouse, inventory, item1, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					// Update amounts add to array  
					inventory[1][column] =+ stockResult;
					column++;
					inventory[1][column] = warehouse.getTempAmt2();
					column++;
					inventory[1][column] = warehouse.getTempAmt3();
				} 
				
				if(warehouse.getTempAmt2() < 0) {
					int item2 = 1;
					int requiredAmount = temp2;
					requiredAmount =+ warehouse.getTempAmt2();
					stockResult = findItems(warehouse, inventory, item2, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					// Update amounts add to array
					inventory[1][column] = warehouse.getTempAmt1();
					column++;
					inventory[1][column] =+ stockResult;
					column++;
					inventory[1][column] = warehouse.getTempAmt3();
				} 
				
				if(warehouse.getTempAmt3() < 0) {
					int item3 = 2;
					int requiredAmount = temp3;
					requiredAmount =+ warehouse.getTempAmt3();
					stockResult = findItems(warehouse, inventory, item3, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					inventory[1][column] = warehouse.getTempAmt1();
					column++;
					inventory[1][column] = warehouse.getTempAmt2();
					column++;
					inventory[1][column] =+ stockResult;
				}
			} else {
				// Update amounts add to array  
				inventory[1][column] = warehouse.getTempAmt1();
				column++;
				inventory[1][column] = warehouse.getTempAmt2();
				column++;
				inventory[1][column] = warehouse.getTempAmt3();
			}
			
		} else if(city == 2) {				// LOS ANGELES					
			// Get current amount in warehouse
			warehouse.setCurrentAmt1(inventory[2][0]);
			warehouse.setCurrentAmt2(inventory[2][1]);
			warehouse.setCurrentAmt3(inventory[2][2]);
									
			warehouse.setType(typeByte);
									
			// Calculate amounts in warehouse -- from file
			warehouse.setTempAmt1(Integer.parseInt(amt1));
			warehouse.setTempAmt2(Integer.parseInt(amt2));
			warehouse.setTempAmt3(Integer.parseInt(amt3));
			
			// Hold amount read from file -- if necessary, use as requiredAmount
			int temp1 = warehouse.getTempAmt1();
			int temp2 = warehouse.getTempAmt2();
			int temp3 = warehouse.getTempAmt3();
									
			// Calculate warehouse totals
			warehouse.calculate();
			// If amount is negative -- check each warehouse to see which one cannot meet order
			// Call findItems method -- use item variable to check array column
			// Find warehouse with the most of item and have it send the amount instead
			if(warehouse.getTempAmt1() < 0 || warehouse.getTempAmt2() < 0 || warehouse.getTempAmt3() < 0) {
				int stockResult = 0;
				if(warehouse.getTempAmt1() < 0) {
					int item1 = 0;
					int requiredAmount = temp1;
					requiredAmount =+ warehouse.getTempAmt1();
					stockResult = findItems(warehouse, inventory, item1, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					// Update amounts add to array  
					inventory[2][column] =+ stockResult;
					column++;
					inventory[2][column] = warehouse.getTempAmt2();
					column++;
					inventory[2][column] = warehouse.getTempAmt3();
				} 
				
				if(warehouse.getTempAmt2() < 0) {
					int item2 = 1;
					int requiredAmount = temp2;
					requiredAmount =+ warehouse.getTempAmt2();
					stockResult = findItems(warehouse, inventory, item2, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					// Update amounts add to array
					inventory[2][column] = warehouse.getTempAmt1();
					column++;
					inventory[2][column] =+ stockResult;
					column++;
					inventory[2][column] = warehouse.getTempAmt3();
				} 
				
				if(warehouse.getTempAmt3() < 0) {
					int item3 = 2;
					int requiredAmount = temp3;
					requiredAmount =+ warehouse.getTempAmt3();
					stockResult = findItems(warehouse, inventory, item3, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					inventory[0][column] = warehouse.getTempAmt1();
					column++;
					inventory[0][column] = warehouse.getTempAmt2();
					column++;
					inventory[0][column] += stockResult;
				}
			} else {
				// Update amounts add to array  
				inventory[2][column] = warehouse.getTempAmt1();
				column++;
				inventory[2][column] = warehouse.getTempAmt2();
				column++;
				inventory[2][column] = warehouse.getTempAmt3();
			}

		} else if(city == 3) { 					// HOUSTON	
			// Get current amount in warehouse
			warehouse.setCurrentAmt1(inventory[3][0]);
			warehouse.setCurrentAmt2(inventory[3][1]);
			warehouse.setCurrentAmt3(inventory[3][2]);
									
			warehouse.setType(typeByte);
									
			// Calculate amounts in warehouse -- from file
			warehouse.setTempAmt1(Integer.parseInt(amt1));
			warehouse.setTempAmt2(Integer.parseInt(amt2));
			warehouse.setTempAmt3(Integer.parseInt(amt3));
			
			// Hold amount read from file -- if necessary, use as requiredAmount
			int temp1 = warehouse.getTempAmt1();
			int temp2 = warehouse.getTempAmt2();
			int temp3 = warehouse.getTempAmt3();
									
			// Calculate warehouse totals
			warehouse.calculate();
			
			// If amount is negative -- check each warehouse to see which one cannot meet order
			// Call findItems method -- use item variable to check array column
			// Find warehouse with the most of item and have it send the amount instead
			if(warehouse.getTempAmt1() < 0 || warehouse.getTempAmt2() < 0 || warehouse.getTempAmt3() < 0) {
				int stockResult = 0;
				if(warehouse.getTempAmt1() < 0) {
					int item1 = 0;
					int requiredAmount = temp1; 
					requiredAmount =+ warehouse.getTempAmt1();
					stockResult = findItems(warehouse, inventory, item1, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					// Update amounts add to array  
					inventory[3][column] += stockResult;
					column++;
					inventory[3][column] = warehouse.getTempAmt2();
					column++;
					inventory[3][column] = warehouse.getTempAmt3();
				} 
				
				if(warehouse.getTempAmt2() < 0) {
					int item2 = 1;
					int requiredAmount = temp2;
					requiredAmount =+ warehouse.getTempAmt2();
					stockResult = findItems(warehouse, inventory, item2, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					// Update amounts add to array
					inventory[3][column] = warehouse.getTempAmt1();
					column++;
					inventory[3][column] += stockResult;
					column++;
					inventory[3][column] = warehouse.getTempAmt3();
				} 
				
				if(warehouse.getTempAmt3() < 0) {
					int item3 = 2;
					int requiredAmount = temp3;
					requiredAmount =+ warehouse.getTempAmt3();
					stockResult = findItems(warehouse, inventory, item3, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					inventory[3][column] = warehouse.getTempAmt1();
					column++;
					inventory[3][column] = warehouse.getTempAmt2();
					column++;
					inventory[3][column] += stockResult;
				}
			} else {
				// Update amounts add to array  
				inventory[3][column] = warehouse.getTempAmt1();
				column++;
				inventory[3][column] = warehouse.getTempAmt2();
				column++;
				inventory[3][column] = warehouse.getTempAmt3();
			}
			
		} else if(city == 4) {				// CHICAGO
			// Get current amount in warehouse
			warehouse.setCurrentAmt1(inventory[4][0]);
			warehouse.setCurrentAmt2(inventory[4][1]);
			warehouse.setCurrentAmt3(inventory[4][2]);
									
			warehouse.setType(typeByte);
									
			// Calculate amounts in warehouse -- from file
			warehouse.setTempAmt1(Integer.parseInt(amt1));
			warehouse.setTempAmt2(Integer.parseInt(amt2));
			warehouse.setTempAmt3(Integer.parseInt(amt3));
			
			// Hold amount read from file -- if necessary, use as requiredAmount
			int temp1 = warehouse.getTempAmt1();
			int temp2 = warehouse.getTempAmt2();
			int temp3 = warehouse.getTempAmt3();
											
			// Calculate warehouse totals
			warehouse.calculate();
			
			// If amount is negative -- check each warehouse to see which one cannot meet order
			// Call findItems method -- use item variable to check array column
			// Find warehouse with the most of item and have it send the amount instead
			if(warehouse.getTempAmt1() < 0 || warehouse.getTempAmt2() < 0 || warehouse.getTempAmt3() < 0) {
				int stockResult = 0;
				if(warehouse.getTempAmt1() < 0) {
					int item1 = 0;
					int requiredAmount = temp1;
					requiredAmount =+ warehouse.getTempAmt1();
					stockResult = findItems(warehouse, inventory, item1, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					// Update amounts add to array  
					// If there multiple AMT's that need to be check I added a conditional
					// Conditional updates each element one at a time
					// If only one element needs to be changed then conditonal is skipped
					if(change = true) {
						inventory[4][0] += stockResult;
						column = 0;
						change = true;
					} else {
						inventory[4][column] += stockResult;
						column++;
						inventory[4][column] = warehouse.getTempAmt2();
						column++;
						inventory[4][column] = warehouse.getTempAmt3();
						column = 0;
					}
				} 
			 	
				if(warehouse.getTempAmt2() < 0) {
					int item2 = 1;
					int requiredAmount = temp2;
					requiredAmount =+ warehouse.getTempAmt2();
					stockResult = findItems(warehouse, inventory, item2, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
					// Update amounts add to array
						if(change == true) {
							inventory[4][1] += stockResult;
							column = 0;	
							change = true;
						} else {
							inventory[4][column] = warehouse.getTempAmt1();
							column++;
							inventory[4][column] += stockResult;
							column++;
							inventory[4][column] = warehouse.getTempAmt3();
							column = 0;	
						}		
				}
				
				if(warehouse.getTempAmt3() < 0) {		
					int item3 = 2;
					int requiredAmount = temp3;
					requiredAmount =+ warehouse.getTempAmt3();
					stockResult = findItems(warehouse, inventory, item3, requiredAmount, city);
					// Calculate the difference between largest item amount and warehouse stock
						if(change = true) {
							inventory[4][2] += stockResult;
							change = false;
						} else {
							inventory[4][column] = warehouse.getTempAmt1();
							column++;
							inventory[4][column] = warehouse.getTempAmt2();
							column++;
							inventory[4][column] += stockResult;
							column = 0;
						}
				}
			} else {
				// Update amounts add to array  
				inventory[4][column] = warehouse.getTempAmt1();
				column++;
				inventory[4][column] = warehouse.getTempAmt2();
				column++;
				inventory[4][column] = warehouse.getTempAmt3();
			}
			
		}

		// Print card -- Ship or Order
		printCard(typeByte, cityArray, city, amt1, amt2, amt3);	
		
		// Increase file pointer to next line
		type_Index += 14;
		cityIndex += 14;
		amt_1_Index += 14;
		amt_2_Index += 14;
		amt_3_Index += 14;
		inout.close();
	}
	
	public static void printCard(String typeByte, String cityArray[], int city, String amt1, String amt2, String amt3) {
		//System.out.println(typeByte + " " + cityArray[city] + " " + amt1.replaceFirst("0", "") + " " + amt2 + " " + amt3); 
		System.out.printf("%-3s %-12s %s %s %s\n\n" , typeByte ,cityArray[city], amt1.replaceFirst("0", ""), amt2, amt3); 
	}
	
	/* printArray: Print array contents */
	public static void printInventory(int inventory[][], String city[]) {
		for(int i = 0; i < inventory.length; i++) {
			System.out.printf("%-15s", city[i]);
			for(int j = 0; j < inventory[i].length; j++) {
				System.out.print(inventory[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	public static void printArray(String array[]) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static int findItems(Inventory warehouse, int array[][], int item, int requiredAmount, int city) {
		int max = 0;
		int k = 0;
		// Find largest value in column
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				// Find max
				if(array[i][item] > max && array[i][item] > Math.abs(requiredAmount)) {
					max = array[i][item];
					// Get last index of max
					k = i;
				}
			}
		}
		
		if(max > 0) {
			// Update warehouse where max is found 
			array[k][item] = array[k][item] + requiredAmount;
			change = true;
			System.out.println("\n" + Math.abs(requiredAmount) + " of item " + item + " shipped from "
					 +  cityArray[k]  + " to " + cityArray[city]);
			System.out.printf("Price of order: $%.2f \n", warehouse.orderPrice(Math.abs(requiredAmount), item));
			
			return Math.abs(requiredAmount);
		} else {
			System.out.println(cityArray[city] + " order unfilled for item # " + item);
			change = false;
		}
		return max;
	}

}
