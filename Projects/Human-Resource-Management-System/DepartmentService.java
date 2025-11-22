import java.sql.*;
import java.util.Scanner;

public class DepartmentService {
    Scanner sc = new Scanner(System.in);

    // Add Department
    public void addDepartment() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Department Name: ");
            String name = sc.nextLine();

            String sql = "INSERT INTO department(dept_name) VALUES (?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);

            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Department added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Departments
    public void viewDepartments() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM department";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("DeptID | DeptName");
            while (rs.next()) {
                System.out.println(rs.getInt("dept_id") + " | " +
                        rs.getString("dept_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Employees by Department
    public void viewEmployeesByDepartment() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT e.emp_id, e.name, e.salary, d.dept_name " +
                    "FROM employee e JOIN department d ON e.dept_id = d.dept_id " +
                    "ORDER BY d.dept_name";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("EmpID | Name | Salary | Department");
            while (rs.next()) {
                System.out.println(rs.getInt("emp_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("salary") + " | " +
                        rs.getString("dept_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

