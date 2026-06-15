package com.lsj;

import java.sql.SQLException;

public class MyMain {

    public static void main(String[] args) {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        try {
            departmentDAO.printAllDepartments();
            employeeDAO.printAllEmployees();
        } catch (SQLException e) {
            System.out.println("DB 작업 중 오류 발생");
            e.printStackTrace();
        }
    }
}
