package golf.dao;

import golf.DBconnection;
import golf.vo.TeacherVO;
import golf.vo.MemberVO;
import golf.vo.SalesVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GolfDAO {

	public List<TeacherVO> getTeacherList() throws Exception {
		List<TeacherVO> list = new ArrayList<>();
		String sql = "SELECT teacher_code, teacher_name, class_name, class_price, teacher_regist_date FROM golf_teacher ORDER BY teacher_code ASC";

		try (Connection conn = DBconnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				TeacherVO vo = new TeacherVO();
				vo.setTeacherCode(rs.getInt("teacher_code"));
				vo.setTeacherName(rs.getString("teacher_name"));
				vo.setClassName(rs.getString("class_name"));
				vo.setClassPrice(rs.getInt("class_price"));
				vo.setTeacherRegistDate(rs.getDate("teacher_regist_date"));
				list.add(vo);
			}
		}
		return list;
	}

	public List<MemberVO> getMemberList() throws Exception {
		List<MemberVO> list = new ArrayList<>();
		String sql = "SELECT c_no, c_name, phone, address, grade FROM golf_member ORDER BY c_no ASC";

		try (Connection conn = DBconnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setcNo(rs.getInt("c_no"));
				vo.setcName(rs.getString("c_name"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setGrade(rs.getString("grade"));
				list.add(vo);
			}
		}
		return list;
	}

	public List<SalesVO> getSalesList() throws Exception {
		List<SalesVO> list = new ArrayList<>();
		String sql = "SELECT t.teacher_code, t.teacher_name, t.class_name, COALESCE(SUM(c.tuition), 0) AS total_sales " +
		             "FROM golf_teacher t " +
		             "LEFT JOIN golf_class c ON t.teacher_code = c.teacher_code " +
		             "GROUP BY t.teacher_code, t.teacher_name, t.class_name " +
		             "ORDER BY t.teacher_code ASC";

		try (Connection conn = DBconnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				SalesVO vo = new SalesVO();
				vo.setTeacherCode(rs.getInt("teacher_code"));
				vo.setTeacherName(rs.getString("teacher_name"));
				vo.setClassName(rs.getString("class_name"));
				vo.setTotalSales(rs.getInt("total_sales"));
				list.add(vo);
			}
		}
		return list;
	}
}
