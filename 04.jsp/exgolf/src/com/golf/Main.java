package com.golf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("조회할 테이블명을 입력하세요: ");
			String tableName = scanner.nextLine().trim();

			if (!isValidTable(tableName)) {
				System.out.println("오류: 허용되지 않거나 존재하지 않는 테이블명입니다.");
				return;
			}

			String query = "SELECT * FROM " + tableName;

			try (Connection conn = DBconnection.getConnection();
				 Statement stmt = conn.createStatement();
				 ResultSet rs = stmt.executeQuery(query)) {

				ResultSetPrinter.printTable(tableName, rs);

			} catch (SQLException e) {
				System.err.println("데이터베이스 처리 중 오류 발생: " + e.getMessage());
			}
		}
	}

	private static boolean isValidTable(String tableName) {
		return "golf_teacher".equalsIgnoreCase(tableName)
				|| "golf_member".equalsIgnoreCase(tableName)
				|| "golf_class".equalsIgnoreCase(tableName);
	}
}
