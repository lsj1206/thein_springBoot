package golf.vo;

import java.sql.Date;

public class TeacherVO {
	private int teacherCode;
	private String teacherName;
	private String className;
	private int classPrice;
	private Date teacherRegistDate;
	private String classArea;

	public int getTeacherCode() {
		return teacherCode;
	}
	public void setTeacherCode(int teacherCode) {
		this.teacherCode = teacherCode;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getClassPrice() {
		return classPrice;
	}
	public void setClassPrice(int classPrice) {
		this.classPrice = classPrice;
	}
	public Date getTeacherRegistDate() {
		return teacherRegistDate;
	}
	public void setTeacherRegistDate(Date teacherRegistDate) {
		this.teacherRegistDate = teacherRegistDate;
	}
	public String getClassArea() {
		return classArea;
	}
	public void setClassArea(String classArea) {
		this.classArea = classArea;
	}
}
