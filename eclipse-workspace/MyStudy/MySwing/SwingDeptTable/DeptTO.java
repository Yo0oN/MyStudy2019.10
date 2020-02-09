package SwingDeptTable;

public class DeptTO {
	// DB에서 들어온 내용을 받고 내보내줌
	private String deptno;
	private String dname;
	private String loc;
	
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
