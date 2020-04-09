package DAOs;

public class TempBoardTO {
	private String board_id;
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	private String seq;
	private String cseq;
	private String subject;
	private String writer;
	private String mem_seq;
	private String content; 
	private String hit;
	private String wgap;
	
	public String getWgap() {
		return wgap;
	}
	public void setWgap(String wgap) {
		this.wgap = wgap;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMem_seq() {
		return mem_seq;
	}
	public void setMem_seq(String mem_seq) {
		this.mem_seq = mem_seq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}
	public String getFile_original() {
		return file_original;
	}
	public void setFile_original(String file_original) {
		this.file_original = file_original;
	}
	public String getFile_change() {
		return file_change;
	}
	public void setFile_change(String file_change) {
		this.file_change = file_change;
	}
	private String wdate;
	private String updated_date;
	private String file_original;
	private String file_change;
}