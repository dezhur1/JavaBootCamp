package sef.module17.activity;
//Needs to be completed
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeJDBC { 
	public static void main(String arg[]) {
		Connection con = createConnection();
		System.out.println(con);
		
		//Insert Employee
		Employee e1 = new Employee();
		e1.setId("1");
		e1.setFirstName("Bob");
		e1.setLastName("White");
		e1.setSalary(3000);
		
		insertEmployee(e1);
		
		//Insert Employee
		Employee e2 = new Employee();
		e2.setId("2");
		e2.setFirstName("Bob");
		e2.setLastName("Marley");
		e2.setSalary(4000);
		
		insertEmployee(e2);
		
		//Insert Employee
		Employee e3 = new Employee();
		e3.setId("3");
		e3.setFirstName("Sam");
		e3.setLastName("Smith");
		e3.setSalary(5000);
				
		insertEmployee(e3);
		
		//Get Employee by ID
		String searchById = "2";
		
		System.out.println("\nSearch by ID "+searchById+":");
		System.out.println(findEmployeeById(searchById).firstName);
		
		//Get Employee by Name
		String searchByName = "Bob";
		
		Employee empByName = new Employee();
		System.out.println("\nSearch by Name "+searchByName+":");
		ArrayList<Employee> employeesByName = findEmployeesByName(searchByName);
		
	    for (int i = 0; i < employeesByName.size(); i++) {
			System.out.println(employeesByName.get(i).lastName);
	    }
	    // Get Employee by Salary
	    int searchSalary = 5000;
	    
	    Employee empBySalary = new Employee();
	    System.out.println("\nSearch by salary "+searchSalary+":");
		ArrayList<Employee> employeesBySalary = findEmployeesBySalary(searchSalary);

	    for (int i = 0; i < employeesBySalary.size(); i++) {
	    	System.out.println(employeesBySalary.get(i).lastName);
	    }
	}

	public static Connection createConnection()
	{
		Connection con=null;
		String url = "jdbc:mysql://localhost/activity?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String pass = "password";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection successfully established!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static Employee findEmployeeById(String id)
	{
		Connection con = createConnection();
		Employee emp=null;
		try {
		// 1 - Create a PreparedStatement with a query
			PreparedStatement pStmt = con.prepareStatement("select * from employee where id = ?");

		// 2 - Search for the given id
			pStmt.setString(1, id);
			//pStmt.setInt(1, 1);
		// 3 - Execute this query
			ResultSet rs = pStmt.executeQuery();
		// 4 - If resultset is not null, then initialize emp object with data 
			if(rs.next()) {
				emp = new Employee ();
				emp.setId(rs.getString(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setSalary(Integer.parseInt(rs.getString(4)));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

	public static ArrayList<Employee> findEmployeesByName(String name)
	{
		Connection con = createConnection();
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		try {
			// 1 - Create a PreparedStatement with a query
			PreparedStatement pStmt = con.prepareStatement("select * from employee where firstName like ? or lastName like ?");
	
			// 2 - Search for the given id
			pStmt.setString(1,  "%"+name+"%");
			pStmt.setString(2,  "%"+name+"%");
			// 3 - Execute this query
			ResultSet rs = pStmt.executeQuery();
			
			// 4 - While there are some records, continue 
			while(rs.next()) {
				Employee emp = new Employee ();
				emp.setId(rs.getString(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setSalary(Integer.parseInt(rs.getString(4)));
				list.add(emp);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public static ArrayList<Employee> findEmployeesBySalary(int salary)
	{
		Connection con = createConnection();
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		try {
		// 1 - Create a PreparedStatement with a query
			PreparedStatement pStmt = con.prepareStatement("select * from employee where salary = ? ");


		// 2 - Search for the given salary
			pStmt.setInt(1, salary);


		// 3 - Execute this query
			ResultSet rs = pStmt.executeQuery();

		
		// 4 - While there are records, continue 
			while(rs.next()) {
				Employee emp = new Employee ();
				emp.setId(rs.getString(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setSalary(Integer.parseInt(rs.getString(4)));
				list.add(emp);
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public static void insertEmployee(Employee emp)
	{
		Connection con = createConnection();
		
		//1 - Create a PreparedStatement with a query "insert into employee values(?,?,?,?)" 
		try {
			PreparedStatement pStmt = con.prepareStatement("insert into employee values(?,?,?,?)");
			con.setAutoCommit(false);
		//	Substitute the ? now.
			pStmt.setString(1, emp.getId());
			pStmt.setString(2, emp.getFirstName());
			pStmt.setString(3, emp.getLastName());
			pStmt.setInt(4, emp.getSalary());
		//2 - Execute this query using executeUpdate()
			int rows = pStmt.executeUpdate();		
			System.out.println(rows + " row(s) added!");
			con.commit();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
