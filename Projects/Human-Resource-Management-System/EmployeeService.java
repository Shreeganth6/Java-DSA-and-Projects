import java.sql.*;
import java.util.Scanner;

public class EmployeeService {

    Scanner sc = new Scanner(System.in);

    // Add Employee
    public void addEmployee() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume \n
            System.out.print("Enter Department ID: ");
            int deptId = sc.nextInt();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            String sql = "INSERT INTO employee(name, age, dept_id, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setInt(3, deptId);
            pst.setDouble(4, salary);

            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Employee added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Employees
    public void viewEmployees() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("ID | Name | Age | Dept | Salary");
            while (rs.next()) {
                System.out.println(rs.getInt("emp_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getInt("dept_id") + " | " +
                        rs.getDouble("salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Employee
    public void updateEmployee() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Employee ID to Update: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            System.out.print("Enter New Age: ");
            int age = sc.nextInt();
            System.out.print("Enter New Dept ID: ");
            int deptId = sc.nextInt();
            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            String sql = "UPDATE employee SET name=?, age=?, dept_id=?, salary=? WHERE emp_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setInt(3, deptId);
            pst.setDouble(4, salary);
            pst.setInt(5, id);

            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Employee updated!");
            else System.out.println("Employee not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Employee ID to Delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM employee WHERE emp_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Employee deleted!");
            else System.out.println("Employee not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

