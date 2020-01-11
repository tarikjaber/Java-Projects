
public class Tester {

	public static void main(String[] args) {
		
		Employee [] emps = new Employee[5];
		emps[0] = new FullTimeEmployee("Tarik", 12.0, 10);
		emps[1] = new FullTimeEmployee("Ayanav", 6.0, 12);
		emps[2] = new FullTimeEmployee("Pranav", 13.0, 15);
		emps[3] = new PartTimeEmployee("Aarya", 19, 8);
		emps[4] = new PartTimeEmployee("Keshav", 3, 2);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(emps[i].toString());
			
			emps[i].totalPay += emps[i].getPay();
			
			if (emps[i] instanceof PartTimeEmployee) {
				emps[i].partPay += emps[i].getPay();
			} else if (emps[i] instanceof FullTimeEmployee){
				emps[i].fullPay += emps[i].getPay();
			}
		}
		
		System.out.println("Total pay: " + emps[0].totalPay);
		System.out.println("Part-time employee total pay: " + emps[0].partPay);
		System.out.println("Full-time employee total pay: " + emps[0].fullPay);
	}

}
