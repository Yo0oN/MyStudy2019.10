/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-01-14 08:35:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mariadb.design_005falbum1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import AlbumBeans.Design_album01ListTO;
import java.util.ArrayList;
import AlbumBeans.Design_album01DAO;
import AlbumBeans.Design_album01TO;

public final class board_005flist1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("AlbumBeans.Design_album01ListTO");
    _jspx_imports_classes.add("AlbumBeans.Design_album01DAO");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("AlbumBeans.Design_album01TO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("utf-8");

	int cpage = 1;

	if (request.getParameter("cpage") != null && !request.getParameter("cpage").equals("")) {
		cpage = Integer.parseInt(request.getParameter("cpage"));
	}

	Design_album01ListTO listTO = new Design_album01ListTO();
	listTO.setCpage(cpage);

	Design_album01DAO dao = new Design_album01DAO();

	listTO = dao.board_list1(listTO);

	// 한 페이지당 출력 데이터 개수
	int recordPerPage = listTO.getRecordPerPage();
	// 전체 페이지 개수 = 마지막 페이지
	int totalPage = listTO.getTotalPage();
	// 전체 데이터(글) 개수
	int totalRecord = listTO.getTotalRecord();
	// 페이지번호가 몇개씩 보이게 할지 설정
	int blockPerPage = listTO.getBlockPerPage();
	// 보이는 페이지 번호의 시작부분이다.
	int startBlock = listTO.getStartBlock();
	// 보이는 페이지 번호의 끝부분이다.
	int endBlock = listTO.getEndBlock();
	// 목록을 받아옴
	ArrayList<Design_album01TO> toLists = listTO.getBoardLists();

	StringBuffer sbHTML = new StringBuffer();
	
	for (int i = 0; i < toLists.size(); i++) {
		Design_album01TO dto = toLists.get(i);

		String seq = dto.getSeq();
		String subject = dto.getSubject();
		String writer = dto.getWriter();
		String wdate = dto.getWdate();
		String hit = dto.getHit();
		String filename = dto.getFilename_ch();
		String countComment = dto.getCom_count();

		if (i % 5 == 0) {
			sbHTML.append("<tr>");
		}

		sbHTML.append("<td width='20%' class='last2'>");
		sbHTML.append("<div class='board'>");
		sbHTML.append("<table class='boardT'>");
		sbHTML.append("<tr>");
		sbHTML.append("<td class='boardThumbWrap'>");
		sbHTML.append("<div class='boardThumb'>");
		// 저장한 사진파일이 있으면 해당 파일 보여주기
		if (!filename.equals("")) {
			sbHTML.append("<a href='board_view1.jsp?seq=" + seq + "&cpage=" + cpage
					+ "'><img src='../../upload/" + filename + "' border='0' width='100%' /></a>");
		} else {
			// 사진 파일이 없으면 noimage사진 보여주기
			sbHTML.append("<a href='board_view1.jsp?seq=" + seq + "&cpage=" + cpage
					+ "'><img src='../../images/noimage.jpg' border='0' width='100%' /></a>");
		}
		sbHTML.append("</div>");
		sbHTML.append("</td>");
		sbHTML.append("</tr>");

		sbHTML.append("<tr>");
		sbHTML.append("<td>");
		sbHTML.append("<div class='boardItem'>");
		sbHTML.append("<strong>" + subject + "</strong> ");
		sbHTML.append("<span class='coment_number'><img src='../../images/icon_comment.png' alt='commnet'> "
				+ countComment + "</span> <img src='../../images/icon_hot.gif' alt='HOT'>");
		sbHTML.append("</div>");
		sbHTML.append("</td>");
		sbHTML.append("</tr>");

		sbHTML.append("<tr>");
		sbHTML.append("<td><div class='boardItem'>");
		sbHTML.append("<span class='bold_blue'>" + writer + "</span>");
		sbHTML.append("</div></td>");
		sbHTML.append("</tr>");

		sbHTML.append("<tr>");
		sbHTML.append("<td><div class='boardItem'>" + wdate + "<font> | </font>");
		sbHTML.append("Hit " + hit + "</div></td>");
		sbHTML.append("</tr>");

		sbHTML.append("</table>");
		sbHTML.append("</div>");
		sbHTML.append("</td>");

		// 만약 현재가 마지막페이지고, 마지막페이지에서 보이는 글 개수가 5개 단위로 끊어지지 않을경우,
		// 추가로 td를 더 넣어주어야한다.
		// 만약 cpage가 totalPage와 같으면 마지막페이지라는뜻이다.
		// 거기에서 toLists의 길이가 5보다 작으면 글 수가 5개단위로 끊어지지 않음
		// toLists.size() == (i+1)이라는것은 현재 반복문의 마지막을 돌고있다는 뜻
		// 글이 5의 배수가아니고 마지막글을 sbHTML에 담고있을 때 한 행에 5개가 들어가도록 <td>를 추가해줌.
		if (cpage == totalPage && toLists.size() == (i + 1) && toLists.size() % 5 > 0) {
			for (int k = 0; k < (5 - (toLists.size() % 5)); k++) {
				sbHTML.append("<td></td>");
			}
		}

		if (i % 5 == 4) {
			sbHTML.append("</tr>");
		}
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/board_list.css\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".board_pagetab {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".board_pagetab a {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tfont: 12px verdana;\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("\tpadding: 0 3px 0 3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".board_pagetab a:hover {\r\n");
      out.write("\ttext-decoration: underline;\r\n");
      out.write("\tbackground-color: #f2f2f2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".on a {\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 상단 디자인 -->\r\n");
      out.write("\t<div class=\"contents1\">\r\n");
      out.write("\t\t<div class=\"con_title\">\r\n");
      out.write("\t\t\t<p style=\"margin: 0px; text-align: right\">\r\n");
      out.write("\t\t\t\t<img style=\"vertical-align: middle\" alt=\"\"\r\n");
      out.write("\t\t\t\t\tsrc=\"../../images/home_icon.gif\" /> &gt; 커뮤니티 &gt; <strong>여행지리뷰</strong>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"contents_sub\">\r\n");
      out.write("\t\t\t<div class=\"board_top\">\r\n");
      out.write("\t\t\t\t<div class=\"bold\">\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t총 <span class=\"txt_orange\">");
      out.print(totalRecord);
      out.write("</span>건\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!--게시판-->\r\n");
      out.write("\t\t\t<table class=\"board_list\">\r\n");
      out.write("\t\t\t\t");
      out.print(sbHTML);
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<!--//게시판-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"align_right\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn_write btn_txt01\"\r\n");
      out.write("\t\t\t\t\tstyle=\"cursor: pointer;\"\r\n");
      out.write("\t\t\t\t\tonclick=\"location.href='board_write1.jsp?cpage=");
      out.print(cpage);
      out.write("'\">쓰기</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!--페이지넘버-->\r\n");
      out.write("\t\t\t<div class=\"paginate_regular\">\r\n");
      out.write("\t\t\t\t<div class=\"board_pagetab\">\r\n");
      out.write("\t\t\t\t\t");

						if (endBlock >= totalPage) {
							endBlock = totalPage;
						}

						// << 기호, 페이지 번호는 한번에 5개까지만 보여준다.
						// << 기호를 누르면 이전페이지 번호 5개를 보이게 하는 기능을 주자.
						if (startBlock == 1) {
							out.println("<span><a>&lt;&lt;<a></span>");
						} else {
							out.println("<span><a href='board_list1.jsp?cpage=" + (startBlock - blockPerPage)
									+ "'>&lt;&lt;</a></span>");
						}

						// < 기호, 즉 한페이지 앞으로 가게 해주는 기호는 현재 페이지가 1페이질경우에는 아무 작동을 하지 않지만,
						// 1페이지가 아닐경우에는 한페이지 앞으로 가게 하는 기능을 준다.
						if (cpage == 1) {
							out.println("<span>&lt;</span>");
						} else {
							out.println("<span><a href='board_list1.jsp?cpage=" + (cpage - 1) + "'>&lt;</a></span>");
						}

						out.println("&nbsp; &nbsp;");

						// 아무 이동도 하지 않고 이 게시판에 바로 들어왔을 때에는 주소창이 board_list1.jsp인 상태이다.
						// 하지만 아래의 페이지 번호를 누르게 된다면, 새로운 게시판 목록 창이 열리며 i가 함께 넘어간다.
						// 그렇게 넘어간 i페이지는 현재페이지를 나타내는 cpage에 할당되어 해당 페이지에서 보여야할 글 목록을 보여준다. 
						for (int j = startBlock; j <= endBlock; j++) {
							if (cpage == j) {
								out.println("<span><a><font color=blue>[" + j + "]</font></a></span>");
							} else {
								out.println("<span><a href='board_list1.jsp?cpage=" + j + "'>" + j + "</a></span>");
							}
						}

						out.println("&nbsp; &nbsp;");

						// > 기호, 즉 한페이지 뒤로 가게 해주는 기호는 현재 페이지가 마지막 페이질경우에는 아무 작동을 하지 않지만,
						// 마지막 페이지가 아닐경우에는 뒷페이지로 가게 하는 기능을 준다.
						if (cpage == totalPage) {
							out.println("<span>&gt;</span>");
						} else {
							out.println("<span><a href='board_list1.jsp?cpage=" + (cpage + 1) + "'>&gt;</a></span>");
						}

						// >> 기호, 페이지 번호는 한번에 5개씩만 보여진다. >>를 누르면 다음 5개의 숫자가 보이고, 그 페이지로 이동할 수 있게 해주자.
						// 현재 페이지가 마지막 페이질경우에는 아무 작동을 하지 않지만,
						// 마지막 페이지가 아닐경우에는 마지막 페이지로 가게 하는 기능을 준다.
						if (totalPage <= endBlock) {
							out.println("<span><a>&gt;&gt;</a></span>");
						} else {
							out.println("<span><a href='board_list1.jsp?cpage=" + (startBlock + blockPerPage)
									+ "'>&gt;&gt;</a></span>");
						}
					
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!--//페이지넘버-->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--//하단 디자인 -->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
