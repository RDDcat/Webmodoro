package Persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Domain.TaskVO;

public class TaskDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	

	// insert
	// insert시 시간 저장
	public void save() {
		connect();
		
	}
	// select
	public TaskVO load() {
		connect();
		return null;
	}
	public List<TaskVO> loadAll() {
		connect();
		return null;		
	}
	// update
	// 테스크 완료 업데이트
	public void updateTaskDone() {
		connect();
		
	}
	// 테스크 내용 수정 업데이트
	public void updateTask() {
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
