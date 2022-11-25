package Persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domain.UserVO;

public class UserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	
	
	// insert
	public boolean save(UserVO userVO) {
		connect();
		String sql = "insert into tbl_user(user_name, passwd, contact) values (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, userVO.getPasswd());
			pstmt.setString(2, userVO.getUserName());
			pstmt.setString(3, userVO.getContact());
			pstmt.executeUpdate(); 
		} 
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
			return true;
		}		
	}
	// select
	public UserVO load() {
		connect();
		UserVO userVO = new UserVO();
		String sql = "select * from tbl_user where user_id= ?";
		try {
			pstmt = conn.prepareStatement (sql);
			pstmt.setString(1, userVO.getPasswd());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			userVO.setUserId(rs.getLong("user_id"));
			userVO.setUserName(rs.getString("user_name"));
			userVO.setPasswd (rs.getString("passwd")); 
			userVO.setContact(rs.getString("contact"));			
			rs.close();
		} 
		catch (SQLException e) { 
			e.printStackTrace();
		} 
		finally { 
			disconnect();
		}
		return userVO;
	}
	// update
	public void update() {
		connect();
		
	}
	// delete
	public void delete() {
		connect();
		
	}
	
	void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, "jspbook","passwd");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void disconnect() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
