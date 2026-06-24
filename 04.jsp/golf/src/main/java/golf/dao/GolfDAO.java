package golf.dao;

import golf.DBconnection;
import golf.vo.TeacherVO;
import golf.vo.MemberVO;
import golf.vo.SalesVO;
import golf.vo.ClassVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 골프연습장 수강신청 관련 데이터베이스 연동을 담당하는 Data Access Object 클래스입니다.
 */
public class GolfDAO {

	/**
	 * 데이터베이스에서 강사 목록 및 담당 강의, 강의장 정보를 조회합니다.
	 * 
	 * @return 강사 정보 목록 (TeacherVO 리스트)
	 * @throws Exception 데이터베이스 연동 및 쿼리 실행 실패 시 발생
	 */
	public List<TeacherVO> getTeacherList() throws Exception {
		List<TeacherVO> list = new ArrayList<>();
		String sql = "SELECT t.teacher_code, t.teacher_name, t.class_name, t.class_price, t.teacher_regist_date, " +
		             "(SELECT DISTINCT class_area FROM golf_class WHERE teacher_code = t.teacher_code LIMIT 1) AS class_area " +
		             "FROM golf_teacher t ORDER BY t.teacher_code ASC";

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
				vo.setClassArea(rs.getString("class_area"));
				list.add(vo);
			}
		}
		return list;
	}

	/**
	 * 전체 회원 정보와 각 회원의 수강 정보(강의명, 강의장, 수강료, 수강월)를 함께 조회합니다.
	 * 회원 테이블을 기준으로 수강 내역이 없는 회원도 조회되도록 LEFT JOIN을 수행합니다.
	 * 
	 * @return 회원 및 수강 정보 목록 (MemberVO 리스트)
	 * @throws Exception 데이터베이스 연동 및 쿼리 실행 실패 시 발생
	 */
	public List<MemberVO> getMemberList() throws Exception {
		List<MemberVO> list = new ArrayList<>();
		String sql = "SELECT m.c_no, m.c_name, m.phone, m.address, m.grade, t.class_name, c.class_area, c.tuition, c.regist_month " +
		             "FROM golf_member m " +
		             "LEFT JOIN golf_class c ON m.c_no = c.c_no " +
		             "LEFT JOIN golf_teacher t ON c.teacher_code = t.teacher_code " +
		             "ORDER BY m.c_no ASC";

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
				vo.setClassName(rs.getString("class_name"));
				vo.setClassArea(rs.getString("class_area"));
				vo.setTuition(rs.getInt("tuition"));
				vo.setRegistMonth(rs.getString("regist_month"));
				list.add(vo);
			}
		}
		return list;
	}

	/**
	 * 강사별 총 매출액(수강료 합계)을 집계하여 조회합니다.
	 * 수강생이 없는 강사는 매출액이 0으로 조회됩니다.
	 * 
	 * @return 강사별 매출 정보 목록 (SalesVO 리스트)
	 * @throws Exception 데이터베이스 연동 및 쿼리 실행 실패 시 발생
	 */
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

	/**
	 * 사용자가 작성한 수강신청(수강월, 회원번호, 강의장, 수강료, 강사코드) 데이터를 수강 테이블에 등록합니다.
	 * 
	 * @param vo 수강신청 정보가 담긴 VO 객체
	 * @return 등록에 성공한 행의 개수 (성공 시 1)
	 * @throws Exception 데이터베이스 연동 및 쿼리 실행 실패 시 발생
	 */
	public int insertClass(ClassVO vo) throws Exception {
		String sql = "INSERT INTO golf_class (regist_month, c_no, class_area, tuition, teacher_code) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = DBconnection.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getRegistMonth());
			pstmt.setInt(2, vo.getcNo());
			pstmt.setString(3, vo.getClassArea());
			pstmt.setInt(4, vo.getTuition());
			pstmt.setInt(5, vo.getTeacherCode());
			return pstmt.executeUpdate();
		}
	}
}
