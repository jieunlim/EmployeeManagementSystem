package manager;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import bean.DepartmentBean;
import bean.EmployeeBean;
import dao.EmployeeDao;

public class Manager {
	
	Scanner input = new Scanner(System.in);
	EmployeeDao dao= new EmployeeDao();
	
	public Manager() {
		
		init();
		
	}
	
	
	public void init(){
		while(true){
			System.out.println("\n======= Select Menu=========");
			System.out.println("1.All Employees");
			System.out.println("2.Display Employee by ID");
			System.out.println("3.Display Employee's department by ID");
			System.out.println("4.Update Employee's info");
			System.out.println("5.Delete Employee");
			System.out.println("6.Add new Employee");
			System.out.println("7.Exit");
			System.out.print("========= Select: > ");

			int menu = input.nextInt();
			int id;
			ArrayList<EmployeeBean> lists;
			ArrayList<DepartmentBean> lists1;
			
			switch (menu) {
			case 1:
				//GetAllEmployee
				System.out.println("");
				lists= dao.getAllEmployee();
				showEmployee(lists);
				break;
			case 2:
				//GetEmployee();
				System.out.print("\nPlease enter employee's ID: > ");
				id = input.nextInt();
				lists= dao.getEmployee(id);
				showEmployee(lists);
				break;
			
			case 3:
				//DisplayDepartment();
				System.out.print("\nPlease enter employee's ID: > ");
				id = input.nextInt();
				lists1= dao.getDepartment(id);
				showDepartment(lists1);
				break;
			case 4:
				//UpdateEmployee();
				int selection;
				int selection_int = 0;
				String selection_str = "";
				String selection_d = "";
				
				System.out.print("\nPlease enter employee's ID to update: > ");
				id = input.nextInt();
				lists= dao.getEmployee(id);
				showEmployee(lists);
				
				System.out.print("\nWhich information do you want to update: > ");
				System.out.println("======= Select Menu=========");
				System.out.println("1.Login_ID");
				System.out.println("2.Department_ID");
				System.out.println("3.Manager_ID");
				System.out.println("4.Title");
				System.out.println("5.BirthDate");
				System.out.println("6.MaritalStatus");
				System.out.println("7.HireDate");
				System.out.println("8.VacationHours");
				System.out.println("9.SickLeaveHours");
				System.out.println("10.Gender");
				System.out.println("11.Exit");
				System.out.print("========= Select: > ");
				selection = input.nextInt();
				//integer
				if(selection == 2||selection == 3||selection == 8||selection == 9){
					System.out.print("\nUpdate to : > ");
					selection_int = input.nextInt();
				}
				//string
				else if(selection == 1||selection == 4||selection == 6 ||selection == 10){
					System.out.print("Update to : > ");
					selection_str = input.next();
				}//date
				else if(selection == 5||selection == 7){
					System.out.print("\nPlease follow this format \"20170101\"\n");
					System.out.print("Update to : > ");
					selection_d = input.next();
					System.out.println("");
					
				}else 
					break;
				
				dao.updateEmployee(id, selection,selection_int,selection_str,selection_d);
				lists= dao.getAllEmployee();	
				showEmployee(lists);
				break;
			case 5:
				//DeleteData();
				System.out.print("\nPlease enter employee's ID to delete: > ");
				id = input.nextInt();
				lists= dao.getEmployee(id);
				showEmployee(lists);
				System.out.print("\nAre you sure to delete this employee? (y/n): > ");
				String anw = input.next();
				if(anw.equalsIgnoreCase("y")) {
					dao.deleteEmployee(id);
					lists= dao.getAllEmployee();	
					showEmployee(lists);
				}
				
				break;
			case 6:
				//InsertData();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
				LocalDate localDate = LocalDate.now();
				String Modified_Date =  dtf.format(localDate);
				
				int Employee_ID = dao.getAllEmployee().size() + 1;
				System.out.print("\nPlease enter Login_ID to add: > ");
				String Login_ID =  input.next();
				System.out.print("Please enter Department_ID to add: > ");
				int Department_ID = input.nextInt();
				System.out.print("Please enter Manager_ID to add: > ");
				int Manager_ID = input.nextInt();
				System.out.print("Please enter Title to add: > ");
				String Title = input.next();
				System.out.print("Please enter BirthDate to add. The format has to be \"20170101\": > ");
				String BirthDate = input.next();
				System.out.print("Please enter MaritalStatus to add (Single: S/ Married: M): > ");
				String MaritalStatus = input.next();
				System.out.print("Please enter HireDate to add. The format has to be \"20170101\": > ");
				String HireDate = input.next();
				int VacationHours = 0;
				int SickLeaveHours = 0;
				System.out.print("Please enter Gender to add. (Female: F, Male: M, Others: O): > ");
				String Gender = input.next();
				dao.addEmployee(Employee_ID, Login_ID, Department_ID, Manager_ID, Title, BirthDate, MaritalStatus, HireDate, VacationHours, SickLeaveHours, Modified_Date, Gender);
				lists= dao.getAllEmployee();	
				showEmployee(lists);
			
				break;
			case 7:
				System.out.println("Bye");
				System.exit(0);
				break;
			default:
				break;
			}
		}
		
	}


	
	//ShowPerson


private void showEmployee(ArrayList<EmployeeBean> lists){

	String imsi = "ID\t" + "LogID\t" +"DepNum\t" +"MagID\t" + "Title\t" + "Birth date\t"+ "Mstat\t"+ "HireDate\t"+ "VHours\t"+ "Sick\t"+ "Modified\t"+ "Gender\t";
	System.out.println(imsi);

	/*
		 for(int i=0; i<lists.size();i++){
		 lists.get(i).getNum();
	}*/


	for(EmployeeBean person : lists){
		String result = 
				person.getEmployee_ID()+"\t"+
				person.getLogin_ID()+"\t"+
				person.getDepartment_ID()+"\t"+
				person.getManager_ID()+"\t"+
				person.getTitle() +"\t"+
				person.getBirthDate() +"\t"+
				person.getMaritalStatus() +"\t"+
				person.getHireDate() +"\t"+
				person.getVacationHours() +"\t"+
				person.getSickLeaveHours() + "\t"+
				person.getModified_Date() +"\t"+
				person.getGender()+"\t";
		
		

		System.out.println(result);

	}

}

private void showDepartment(ArrayList<DepartmentBean> lists){

	String imsi = "DepID\t" + "Name\t" +"Group_Name\t" +"Modified\t";
	System.out.println(imsi);

	/*
		 for(int i=0; i<lists.size();i++){
		 lists.get(i).getNum();
	}*/


	for(DepartmentBean dep : lists){

		String result = 
				dep.getDepartment_ID()+"\t"+
				dep.getName()+"\t"+
				dep.getGroup_name()+"\t"+"\t"+
				dep.getModified_Date()+"\t";
		
		

		System.out.println(result);

	}

}


}
