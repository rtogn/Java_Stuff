
class Employee{
   private String name;
   private int salary = 2;
   private final int test;
   
   public static int cat = 100;
   
   public Employee(){
		this.name = "Unknown";
		this.salary = 0;
      this.test = 2;
   }

   public Employee(String name, int salary){
      this.test = 3;
	   this.name = name;
		this.salary = salary;
   }
   
   public String getName(){
      return name;
   }
   
   public int getSalary(){
      return salary;
   }
   
   public String toString(){
		return("Employee Name: " + name + "; Employee Salary: " + salary + " test: " + test);
   }
}

class Manager extends Employee{
	private String department;
	private int salary = 44;

	public Manager(){
		this.department = "No department";

	}
	
	public Manager(String name, int salary, String department){
		super(name, salary);
      this.department = department;
	}
   
   public String getDepartment(){
      return department;
   }
   
   public String toString(){
		return(super.toString() + "Manager Name: " + super.getName() + "; Manager Salary: " + super.getSalary() + "; Department: " + department);
   }	
}

class Executive extends Manager{
	
	public Executive(){
	}
	
	public Executive(String name, int salary, String department){
		super(name, salary, department);
	}
   
   public String toString(){
		return("Executive Name: " + super.getName() + "; Executive Salary: " + super.getSalary() + "; Department: " + super.getDepartment() );
   }	
}   


class EmployeeTest{
   public static void main (String[] args){
      Employee Jane = new Employee("Jane", 35000);
      Manager John = new Manager("John", 50000, "Construction");
      Executive Samantha = new Executive("Samantha", 75000, "Construction");     
      Employee x = null;
      
      System.out.println(Jane);
      System.out.println(John);
      System.out.println(Samantha);

      
   }
}