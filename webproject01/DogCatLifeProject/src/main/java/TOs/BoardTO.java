package TOs;

public class BoardTO {
	private String pseq;
	private String seq;
	private String subject;
	private String mseq;
	private String writer;
	private String content;
	private String filename;
	private int wgap;
	
	
	public int getWgap() {
		return wgap;
	}
	public void setWgap(int wgap) {
		this.wgap = wgap;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	private String hit;
	private String cmt;
	private String wdate_ori;
	private String wdate_mod;
	
	public String getPesq() {
		return pseq;
	}
	public void setPesq(String pesq) {
		this.pseq = pesq;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMseq() {
		return mseq;
	}
	public void setMseq(String mseq) {
		this.mseq = mseq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getWdate_ori() {
		return wdate_ori;
	}
	public void setWdate_ori(String wdate_ori) {
		this.wdate_ori = wdate_ori;
	}
	public String getWdate_mod() {
		return wdate_mod;
	}
	public void setWdate_mod(String wdate_mod) {
		this.wdate_mod = wdate_mod;
	}
}
