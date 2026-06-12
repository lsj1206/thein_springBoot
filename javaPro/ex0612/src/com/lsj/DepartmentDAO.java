package com.lsj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAO {

    public void printAllDepartments() throws SQLException {
        String sql = "SELECT id, name FROM departments ORDER BY id";

        try (
            Connection conn = DBConnector.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()
        ) {
            ResultSetPrinter.printTable("departments 목록", rs);
        }
    }
}
