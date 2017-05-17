package bean;

import java.sql.Date;

public class DepartmentBean {
	private int department_ID;	
	private String name;	
	private String group_name;  
	private Date modified_Date;
		
	
	public int getDepartment_ID() {
		return department_ID;
	}
	public void setDepartment_ID(int department_ID) {
		this.department_ID = department_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public Date getModified_Date() {
		return modified_Date;
	}
	public void setModified_Date(Date modified_Date) {
		this.modified_Date = modified_Date;
	}
	
	
	
	
	
	
	
	
}
