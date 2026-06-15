package com.golf;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public final class ResultSetPrinter {

    private ResultSetPrinter() {
    }

    public static void printTable(String title, ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        System.out.println("===== " + title + " =====");

        for (int column = 1; column <= columnCount; column++) {
            System.out.print(metaData.getColumnLabel(column));
            System.out.print(column == columnCount ? System.lineSeparator() : "\t");
        }

        while (rs.next()) {
            for (int column = 1; column <= columnCount; column++) {
                Object value = rs.getObject(column);
                System.out.print(value == null ? "NULL" : value);
                System.out.print(column == columnCount ? System.lineSeparator() : "\t");
            }
        }
    }
}
