import java.util.Scanner;

public class HRMSApp{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EmployeeService empService = new EmployeeService();
        PayrollService payrollService = new PayrollService();
        LeaveService leaveService = new LeaveService();
        DepartmentService deptService = new DepartmentService();

        while (true) {
            System.out.println("\n=== HRMS MENU ===");
            System.out.println("1. Employee - Add");
            System.out.println("2. Employee - View All");
            System.out.println("3. Employee - Update");
            System.out.println("4. Employee - Delete");
            System.out.println("5. Payroll - Calculate & Record");
            System.out.println("6. Payroll - View All");
            System.out.println("7. Leave - Apply");
            System.out.println("8. Leave - Approve/Reject");
            System.out.println("9. Leave - View All");
            System.out.println("10. Department - Add");
            System.out.println("11. Department - View All");
            System.out.println("12. Employees by Department");
            System.out.println("13. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: empService.addEmployee(); break;
                case 2: empService.viewEmployees(); break;
                case 3: empService.updateEmployee(); break;
                case 4: empService.deleteEmployee(); break;
                case 5: payrollService.calculatePayroll(); break;
                case 6: payrollService.viewPayroll(); break;
                case 7: leaveService.applyLeave(); break;
                case 8: leaveService.updateLeaveStatus(); break;
                case 9: leaveService.viewLeaves(); break;
                case 10: deptService.addDepartment(); break;
                case 11: deptService.viewDepartments(); break;
                case 12: deptService.viewEmployeesByDepartment(); break;
                case 13: System.out.println("Exiting HRMS..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
