package com.exam.jdbc01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private DataSource dataSource;

	@RequestMapping(value = "/jdbc01.do")
	public String jdbc01() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql = "select now() as now";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("시간출력" + rs.getString("now"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e1) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return "jdbc01";
	}
}
