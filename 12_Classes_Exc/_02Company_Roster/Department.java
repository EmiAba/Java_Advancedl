package F12_Classes_Exc._02Company_Roster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;


    public Department(String name) {
        this.name = name;
        this.employees=new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addEmployee(Employee employee){
        employees.add(employee);
    }


    public double getDepartmentSalary(){
        double sum=0;
        for(Employee employee: employees){
            sum+=employee.getSalary();
        }
        return sum;
    }

    public List<Employee> getEmployees() {
        return employees;
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Highest Average Salary: ").append(name).append(System.lineSeparator());
        for(Employee employee: employees){
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
