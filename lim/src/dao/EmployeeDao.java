package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bean.DepartmentBean;
import bean.EmployeeBean;

public class EmployeeDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String username = "system";
	private String password = "0000";
	private Connection conn = null;

	public EmployeeDao() {

		try {
			Class.forName(driver);// 1. Load driver
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find class(jar file is not exist)");
			e.printStackTrace();
		}
	}// Constructor

	private Connection getConnection() {

		try {
			conn = DriverManager.getConnection(url, username, password); // 2.
																			// Load
																			// driver
		} catch (SQLException e) {
			System.out.println("Connection error");
			e.printStackTrace();
		}
		return conn;
	}// getConnection

	private void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}// closeConnection

	// GetAllEmployee
	public ArrayList<EmployeeBean> getAllEmployee() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Employee order by employee_id";
		ArrayList<EmployeeBean> lists = new ArrayList<EmployeeBean>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeBean person = new EmployeeBean();

				person.setEmployee_ID(rs.getInt("employee_ID"));
				person.setLogin_ID(rs.getString("login_ID"));
				person.setDepartment_ID(rs.getInt("department_ID"));
				person.setManager_ID(rs.getInt("manager_ID"));
				person.setTitle(rs.getString("title"));
				person.setBirthDate(rs.getDate("birthdate"));
				person.setMaritalStatus(rs.getString("maritalStatus"));
				person.setHireDate(rs.getDate("hiredate"));
				person.setVacationHours(rs.getInt("vacationHours"));
				person.setSickLeaveHours(rs.getInt("sickLeaveHours"));
				person.setModified_Date(rs.getDate("modified_Date"));
				person.setGender(rs.getString("Gender"));

				lists.add(person);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return lists;

	}

	public ArrayList<EmployeeBean> getEmployee(int empId) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Employee where employee_id= ?";
		ArrayList<EmployeeBean> lists = new ArrayList<EmployeeBean>();

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			rs = pstmt.executeQuery();
			 

			while (rs.next()) {
				EmployeeBean person = new EmployeeBean();

				person.setEmployee_ID(rs.getInt("employee_ID"));
				person.setLogin_ID(rs.getString("login_ID"));
				person.setDepartment_ID(rs.getInt("department_ID"));
				person.setManager_ID(rs.getInt("manager_ID"));
				person.setTitle(rs.getString("title"));
				person.setBirthDate(rs.getDate("birthdate"));
				person.setMaritalStatus(rs.getString("maritalStatus"));
				person.setHireDate(rs.getDate("hiredate"));
				person.setVacationHours(rs.getInt("vacationHours"));
				person.setSickLeaveHours(rs.getInt("sickLeaveHours"));
				person.setModified_Date(rs.getDate("modified_Date"));
				person.setGender(rs.getString("Gender"));

				lists.add(person);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return lists;

	}

	public void updateEmployee(int id, int sel, int sel_i, String sel_str, String sel_d) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate localDate = LocalDate.now();
		String modified = dtf.format(localDate);

		try {

			switch (sel) {
			case 1:
				sql = "update employee set login_id=?,modified_Date=to_date(?,'YYYYMMDD') where employee_id=?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sel_str);
				break;
			case 2:
				sql = "update employee set department_ID=?,modified_Date = to_date(?,'YYYYMMDD') where employee_id= ?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sel_i);
				break;
			case 3:
				sql = "update employee set manager_ID=?,modified_Date = to_date(?,'YYYYMMDD') where employee_id= ?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sel_i);
				break;
			case 4:
				sql = "update employee set title=?,modified_Date = to_date(?,'YYYYMMDD') where employee_id= ?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sel_str);

				break;
			case 5:
				sql = "update employee set birthDate=to_date(?,'YYYYMMDD'),modified_Date = to_date(?,'YYYYMMDD') where employee_id= ?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sel_d);

				break;
			case 6:
				sql = "update employee set maritalStatus=?,modified_Date = to_date(?,'YYYYMMDD') where employee_id= ?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sel_str);

				break;
			case 7:
				sql = "update employee set hireDate=to_date(?,'YYYYMMDD'),modified_Date = to_date(?,'YYYYMMDD') where employee_id= ?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sel_d);

				break;
			case 8:
				sql = "update employee set vacationHours=?,modified_Date = to_date(?,'YYYYMMDD') where employee_id= ?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sel_i);

				break;
			case 9:
				sql = "update employee set sickLeaveHours=?,modified_Date = to_date(?,'YYYYMMDD') where employee_id= ?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sel_i);

				break;
			case 10:
				sql = "update employee set gender=?,modified_Date = to_date(?,'YYYYMMDD') where employee_id= ?";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sel_str);

				break;
			}

			pstmt.setString(2, modified);
			pstmt.setInt(3, id);
			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("Failed");
			} else {
				System.out.println("\nUpdated successfully\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void deleteEmployee(int id) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate localDate = LocalDate.now();
		String modified = dtf.format(localDate);

		sql = "delete from employee where employee_id= ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("Failed");
			} else {
				System.out.println("\nDeleted successfully\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void addEmployee(int Employee_ID, String Login_ID, int Department_ID, int Manager_ID, String Title, String BirthDate, String MaritalStatus, String HireDate, int VacationHours, int SickLeaveHours, String Modified_Date, String Gender) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate localDate = LocalDate.now();
		String modified = dtf.format(localDate);

				
		try{
			sql = "insert into employee VALUES(?,?,?,?,?,to_date(?,'YYYYMMDD'),?,to_date(?,'YYYYMMDD'),?,?,to_date(?,'YYYYMMDD'),?)";
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Employee_ID);
				pstmt.setString(2, Login_ID);
				pstmt.setInt(3, Department_ID);
				pstmt.setInt(4, Manager_ID);
				pstmt.setString(5, Title);
				pstmt.setString(6, BirthDate);
				pstmt.setString(7, MaritalStatus);
				pstmt.setString(8, HireDate);
				pstmt.setInt(9, VacationHours);
				pstmt.setInt(10, SickLeaveHours);
				pstmt.setString(11, Modified_Date);
				pstmt.setString(12, Gender);
				
			int count = pstmt.executeUpdate();

			if (count == 0) {
				System.out.println("Failed");
			} else {
				System.out.println("\nAdded successfully\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	
	public ArrayList<DepartmentBean> getDepartment(int employeeID) {

		EmployeeDao emp = new EmployeeDao();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from department where department_id = (select department_id from employee where employee_id = ?)";
		;
		ArrayList<DepartmentBean> lists = new ArrayList<DepartmentBean>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				DepartmentBean dep = new DepartmentBean();

				dep.setDepartment_ID(rs.getInt("department_ID"));
				dep.setName(rs.getString("name"));
				dep.setGroup_name(rs.getString("group_name"));
				dep.setModified_Date(rs.getDate("modified_Date"));

				lists.add(dep);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return lists;

	}

}
