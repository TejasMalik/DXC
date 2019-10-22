package Core_Java;


public class RegularEmployee extends Employee {
	 private int RegularEmployeeId;
	 private int RegularEmployeeSalary;
	 public RegularEmployee() {
		 
	 }
	public RegularEmployee(int regularEmployeeId, int regularEmployeeSalary) {
		super();
		RegularEmployeeId = regularEmployeeId;
		RegularEmployeeSalary = regularEmployeeSalary;
	}
	public int getRegularEmployeeId() {
		return RegularEmployeeId;
	}
	public void setRegularEmployeeId(int regularEmployeeId) {
		RegularEmployeeId = regularEmployeeId;
	}
	public int getRegularEmployeeSalary() {
		return RegularEmployeeSalary;
	}
	public void setRegularEmployeeSalary(int regularEmployeeSalary) {
		RegularEmployeeSalary = regularEmployeeSalary;
	}
	@Override
	public String toString() {
		return "RegularEmployee [RegularEmployeeId=" + RegularEmployeeId + ", RegularEmployeeSalary="
				+ RegularEmployeeSalary + ", getRegularEmployeeId()=" + getRegularEmployeeId()
				+ ", getRegularEmployeeSalary()=" + getRegularEmployeeSalary() + "]";
	}
	
}

