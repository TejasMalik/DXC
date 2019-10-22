package Core_Java;

public class StudentTest {
	
	private String getName;
	private int getRegNo;
	
	public StudentTest(String getName, int getRegNo) {
		this.getName = getName;
		this.getRegNo = getRegNo;
	}
	
	public String getName() {
		return this.getName;
	}
	
	public int getRegNo() {
		return this.getRegNo;
	}
	 
    public static void display(int regno) {
        System.out.println("Registration No. " + regno);
    }
 
    public static void display(String name) {
        System.out.println("Name. " + name);
    }
 
    public static void main(String str[]) {
        StudentTest s1 = new StudentTest("Mary",198);
        display(s1.getName());
        display(s1.getRegNo());
    }
}
