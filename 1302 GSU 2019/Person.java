class Person{
	private String name;
	private String dateOfBirth;
	
	public Person(){
		this.name = "unknown";
		this.dateOfBirth = "unknown date";
	}

	public Person(String name, String dateOfBirth){
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName(){
		return name;
	}
	
	public String getDateOfBirth(){
		return dateOfBirth;
	}
	
	public String toString(){
		return ( "Name: " + name + ", Date of Birth: " + dateOfBirth);
	}
}


class Student extends Person{
	private String major;
	
	public Student(){
		this.major = "Undecided";
	}
	
	public Student(String name, String dateOfBirth, String major){
		super(name, dateOfBirth);
		this.major = major;
	}

	public String getMajor(){
		return major;
	}
	
	public String toString(){
		return ( "Name: " + super.getName() + ", Date of Birth: " + super.getDateOfBirth() + ", major: " + major);
	}
}

class Instructor extends Person{
	private int salary;
	
	public Instructor(){
		salary = 0;
	}

	public Instructor(String name, String dateOfBirth, int salary){
		super(name, dateOfBirth);
		this.salary = salary;
	}	
	
	public int getSalary(){
		return salary;
	}
	
	public String toString(){
		return ( "Name: " + super.getName() + ", Date of Birth: " + super.getDateOfBirth() + salary);
	}
}

class personTest{
   Person Jane = new Person("Jane", "01/01/1901"); 
}