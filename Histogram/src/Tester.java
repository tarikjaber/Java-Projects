
public class Tester {

	public static void main(String[] args) {
		int [] array = new int[8];
		array[0] = 3;
		array[1] = 5;
		array[2] = 9;
		array[3] = 10;
		array[4] = 12;
		array[5] = 11;
		array[6] = 9;
		array[7] = 4;
		
		
		dataSet set = new dataSet(array);
		System.out.println("Is mode: " + set.isMode(4));
		System.out.println("Mode index: " + set.modeIndex());
		set.printHistogram(20, "c");

	}

}
