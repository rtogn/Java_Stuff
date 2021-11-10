import java.util.Date;
class Person1{
	private String name;
	private String address;
	private String phoneNumber;
	private String email;

	public Person1(String name, String address, String phoneNumber, String email){
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public String toString(){
		return("Name: " + name + " *adress: " + address + " *phoneNumber: " + phoneNumber + " *email: " + email);
	}
}

class Student extends Person1{
	private final String classStatus;
	
	public Student(String name, String address, String phoneNumber, String email, String classStatus){
		super(name, address, phoneNumber, email);
		this.classStatus = classStatus;
	}
	
	public String toString(){
			return(super.toString() + " *Class Status: " + classStatus);
	}
}

class Employee extends Person1{
	private String office;
	private final Date hireDate;
	private double salary;
	
	public Employee(String name, String address, String phoneNumber, String email, String office, double salary){
		super(name, address, phoneNumber, email);
		this.hireDate = new Date();
		this.office = office;
		this.salary = salary;
	}
	
	public String toString(){
		return(super.toString() + " \n*office: " + office + " *date hired: " + hireDate + " *salary : " + salary);
	}	
}

class Faculty extends Employee{
	private String officeHours;
	private String rank;
	
	public Faculty(String name, String address, String phoneNumber, String email, String office, 
	double salary, String officeHours, String rank){
		super(name, address, phoneNumber, email, office, salary);
		this.officeHours = officeHours;
		this.rank = rank;
	}	
	
	public String toString(){
		return(super.toString() + " \n*office hours: " + officeHours + " *rank: " + rank);
	}
}

class Staff extends Employee{
	private String title;
	
	public Staff(String name, String address, String phoneNumber, String email, String office, 
	double salary, String title){
		super(name, address, phoneNumber, email, office, salary);
		this.title = title;
	}	
	
	public String toString(){
		return(super.toString() + " title: " + title);
	}
}

class Person1Test{
   public static void main (String[] args){
	   Person1 James = new Person1("James", "102 Perosn Lane", "111-111-1111", "james@person.org" );
	   Person1 Jill = new Student("Jill", "103 Student Lane", "222-222-2222", "Jill@student.org", "Junior");
	   Person1 Jennifer = new Employee("Jennifer", "104 Employee Lane", "333-333-3333", "Jen@employee.org",
	   "office1", 55000);
	   Person1 Jesus = new Faculty("Jesus", "105 Faculty Lane", "444-444-4444", "Jesus@faculty.org",
	   "office2", 45000, "11:30-12:45", "tenured");
	   Person1 Jack = new Staff("Jack", "106 Staff Lane", "555-555-5555", "Jack@staff.org",
	   "office 3", 35000, "Gardener");
		
		Person1[] peepArray = {James, Jill, Jennifer, Jesus, Jack};
		for (Person1 human : peepArray)	
			System.out.println(human);
   
   }
}