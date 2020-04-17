package TOs;

public class CommentTO {
	
	private String seq;
	private String cseq;
	private String mseq;
	private String cwriter;
	private String content;
	private String wdate_ori;
	private String wdate_mod;
	
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
	public String getMseq() {
		return mseq;
	}
	public void setMseq(String mseq) {
		this.mseq = mseq;
	}
	public String getCwriter() {
		return cwriter;
	}
	public void setCwriter(String writer) {
		this.cwriter = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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