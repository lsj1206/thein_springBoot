package golf.vo;

public class SalesVO {
	private int teacherCode;
	private String teacherName;
	private String className;
	private int totalSales;

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
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
}
