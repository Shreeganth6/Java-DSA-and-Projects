import java.sql.*;
import java.util.Scanner;

public class PayrollService {
    Scanner sc = new Scanner(System.in);

    // Calculate Net Salary = basic_salary - deductions
    public void calculatePayroll() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();

            System.out.print("Enter Basic Salary: ");
            double basic = sc.nextDouble();

            System.out.print("Enter Deductions: ");
            double ded = sc.nextDouble();

            double net = basic - ded;

            // Insert into payroll table
            String sql = "INSERT INTO payroll(emp_id, basic_salary, deductions, net_salary) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, empId);
            pst.setDouble(2, basic);
            pst.setDouble(3, ded);
            pst.setDouble(4, net);

            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Payroll recorded! Net Salary: " + net);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Payroll
    public void viewPayroll() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT p.payroll_id, e.name, p.basic_salary, p.deductions, p.net_salary " +
                    "FROM payroll p JOIN employee e ON p.emp_id = e.emp_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("PayrollID | Employee | Basic | Deductions | Net");
            while (rs.next()) {
                System.out.println(rs.getInt("payroll_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("basic_salary") + " | " +
                        rs.getDouble("deductions") + " | " +
                        rs.getDouble("net_salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

