//package com.dogcatlife.mysql;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import action_community_board.ListAction;
//import action_community_board.ModifyOkAction;
//import action_community_board.ViewAction;
//import action_community_board.WriteAction;
//import action_community_board.WriteOkAction;
//import action_main.MainListAction;
//import action_user.UserJoinAction;
//import action_user.UserJoinOkAction;
//import mysql.model2.Action1;
//
///**
// * Servlet implementation class ControllerEx01
// */ // 정상요청 , Web2.0방식 요청
//@WebServlet({ "*.mysql", "*.json" })
//public class ControllerEx extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doProcess(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doProcess(request, response);
//	}
//
//	protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//
//		try {
//			request.setCharacterEncoding("utf-8");
//
//			String path = request.getRequestURI().replaceAll(request.getContextPath(), "");
//
//			String url = "";
//			Action1 action = null;
//			// 메인페이지
//			if (path.equals("/*.mysql") || path.equals("/main.mysql")) {
//				System.out.println("컨트롤러 실행");
//				action = new MainListAction();
//				action.execute(request, response);
//				
//				url = "main";
//
//				// 자유게시판 list
//			} else if (path.equals("/community_board_list.mysql")) {
//				System.out.println("자유게시판 list 컨트롤러실행");
//				action = new ListAction();
//				action.execute(request, response);
//
//				url = "/views/community_board_list.jsp";
//
//				// 자유게시판 write
//			} else if (path.equals("/community_board_write.mysql")) {
//				System.out.println("자유게시판 write 컨트롤러실행");
//				action = new WriteAction();
//				action.execute(request, response);
//
//				url = "/views/community_board_write.jsp";
//
//				// 자유게시판 write_ok
//			} else if (path.equals("/community_board_write_ok.mysql")) {
//				System.out.println("자유게시판 writeOk 컨트롤러실행");
//				action = new WriteOkAction();
//				action.execute(request, response);
//
//				url = "/views/community_board_write_ok.jsp";
//
//				// 자유게시판 view
//			} else if (path.equals("/community_board_view.mysql")) {
//				System.out.println("자유게시판 view 컨트롤러실행");
//				action = new ViewAction();
//				action.execute(request, response);
//
//				url = "/views/community_board_view.jsp";
//
//				// 자유게시판 modify
//			} else if (path.equals("/community_board_modify.mysql")) {
//				System.out.println("자유게시판 modify 컨트롤러실행");
//				action = new ModifyOkAction();
//				action.execute(request, response);
//
//				url = "/views/community_board_modify.jsp";
//
//				// 자유게시판 modify_ok
//			} else if (path.equals("/community_board_modify_ok.mysql")) {
//				System.out.println("자유게시판 modify Ok 컨트롤러실행");
//				action = new ModifyOkAction();
//				action.execute(request, response);
//
//				url = "/views/community_board_modify_ok.jsp";
//
//				// 자유게시판 delete
//			} else if (path.equals("/community_board_delete.mysql")) {
//				System.out.println("자유게시판 컨트롤러실행");
//				action = new ListAction();
//				action.execute(request, response);
//
//				url = "/views/community_board_delete.jsp";
//
//				// 자유게시판 delete_ok
//			} else if (path.equals("/community_board_write_ok.mysql")) {
//				System.out.println("자유게시판 컨트롤러실행");
//				action = new ListAction();
//				action.execute(request, response);
//
//				url = "/views/community_board_delete_ok.jsp";
//
//				// 회원가입 페이지
//			} else if (path.equals("/user_join.mysql")) {
//				System.out.println("가입 페이지 컨트롤러실행");
//				action = new UserJoinAction();
//				action.execute(request, response);
//
//				url = "/views/user_join.jsp";
//
//				// 회원가입OK
//			} else if (path.equals("/user_join_ok.mysql")) {
//				System.out.println("가입 컨트롤러실행");
//				action = new UserJoinOkAction();
//				action.execute(request, response);
//
//				url = "/views/user_join_ok.jsp";
//			}
//
//			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//			dispatcher.forward(request, response);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			System.out.println("[에러] : " + e.getMessage());
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			System.out.println("[에러] : " + e.getMessage());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("[에러] : " + e.getMessage());
//		}
//	}
//}