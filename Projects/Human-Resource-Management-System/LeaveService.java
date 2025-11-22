import java.sql.*;
import java.util.Scanner;

public class LeaveService {
    Scanner sc = new Scanner(System.in);

    // Apply Leave
    public void applyLeave() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();
            System.out.print("Enter Leave Days: ");
            int days = sc.nextInt();

            String sql = "INSERT INTO leave_requests(emp_id, leave_days, status) VALUES (?, ?, 'Pending')";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, empId);
            pst.setInt(2, days);

            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Leave Applied! Status: Pending");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Approve / Reject Leave
    public void updateLeaveStatus() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Leave ID: ");
            int leaveId = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Status (Approved/Rejected): ");
            String status = sc.nextLine();

            String sql = "UPDATE leave_requests SET status=? WHERE leave_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, status);
            pst.setInt(2, leaveId);

            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Leave status updated!");
            else System.out.println("Leave ID not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Leaves
    public void viewLeaves() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT l.leave_id, e.name, l.leave_days, l.status " +
                    "FROM leave_requests l JOIN employee e ON l.emp_id = e.emp_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("LeaveID | Employee | Days | Status");
            while (rs.next()) {
                System.out.println(rs.getInt("leave_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("leave_days") + " | " +
                        rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
