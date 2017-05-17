package bean;

import java.sql.Date;

public class EmployeeBean {
	private int employee_ID;	
	private String login_ID;	
	private int department_ID;  
	private int manager_ID;
	private String title;
	private Date birthDate;
	private String maritalStatus;
	private Date hireDate;
	private int vacationHours;
	private int sickLeaveHours;
	private Date modified_Date;
	private String gender;
	
	public int getEmployee_ID() {
		return employee_ID;
	}
	public void setEmployee_ID(int employee_ID) {
		this.employee_ID = employee_ID;
	}
	public String getLogin_ID() {
		return login_ID;
	}
	public void setLogin_ID(String login_ID) {
		this.login_ID = login_ID;
	}
	public int getDepartment_ID() {
		return department_ID;
	}
	public void setDepartment_ID(int department_ID) {
		this.department_ID = department_ID;
	}
	public int getManager_ID() {
		return manager_ID;
	}
	public void setManager_ID(int manager_ID) {
		this.manager_ID = manager_ID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public int getVacationHours() {
		return vacationHours;
	}
	public void setVacationHours(int vacationHours) {
		this.vacationHours = vacationHours;
	}
	public int getSickLeaveHours() {
		return sickLeaveHours;
	}
	public void setSickLeaveHours(int sickLeaveHours) {
		this.sickLeaveHours = sickLeaveHours;
	}
	public Date getModified_Date() {
		return modified_Date;
	}
	public void setModified_Date(Date modified_Date) {
		this.modified_Date = modified_Date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
	
	
	
	
	
}
