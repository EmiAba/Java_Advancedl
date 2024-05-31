package F12_Classes_Exc._02Company_Roster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String departmentName = data[3];
            String email = "n/a";
            int age = -1;

            if (data.length == 6) {
                email = data[4];
                age = Integer.parseInt(data[5]);
            } else if (data.length == 5) {
                if (data[4].contains("@")) {
                    email = data[4];
                } else {
                    age = age = Integer.parseInt(data[4]);
                }
            }


            Employee employee = new Employee(name, salary, position, email, age);
            Department department = getDepartmentByName(departments, departmentName);
            department.addEmployee(employee);


        }
        Collections.sort(departments, Comparator.comparing(Department::getDepartmentSalary).reversed());
        Department higestPaidDepartment = departments.get(0);
        Collections.sort(higestPaidDepartment.getEmployees(), Comparator.comparing(Employee::getSalary).reversed());

        System.out.println(higestPaidDepartment);
    }

    private static Department getDepartmentByName(List<Department> departments, String departmentName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department;
            }
        }
        Department department = new Department(departmentName);
        departments.add(department);

        return department;
    }


}
