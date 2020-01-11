public class FullTimeEmployee extends Employee {
	private int empID;
	
	
   public FullTimeEmployee(){
      super();
      empID = ID;
   }
   
   public FullTimeEmployee(String n, double r, int h) {
	   super(n,r,h);
   }
   

   public double getPay() {
      double pay;
      
      if (hours <= 40)
         pay = rate * hours;
      else
         pay = rate * 40 +  rate * 2 * (hours - 40);
      return pay;
   }
   
   public String toString() {
	   return "Name: " + name + " Rate: " + rate + " Hours: " + hours + " ID: " + empID + " Pay: " + getPay();
   }
}
