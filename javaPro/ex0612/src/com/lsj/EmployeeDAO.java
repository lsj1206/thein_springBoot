package com.lsj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    public void printAllEmployees() throws SQLException {
        String sql =
            "SELECT e.id, e.name, e.department_id, d.name AS department_name " +
            "FROM employees e " +
            "JOIN departments d ON d.id = e.department_id " +
            "ORDER BY e.id";

        try (
            Connection conn = DBConnector.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()
        ) {
            ResultSetPrinter.printTable("employees 목록", rs);
        }
    }
}
