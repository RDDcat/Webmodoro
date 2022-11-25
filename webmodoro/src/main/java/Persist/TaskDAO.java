package Persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Domain.TaskVO;

public class TaskDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url = "jdbc:mysql://localhost/jspdb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	

	// insert
	// insert시 시간 저장
	public boolean save(long userId, TaskVO taskVO) {
		connect();
		String sql = "insert into tbl_task(user_id, task_describtion, is_task, save_time, end_time) values (?,?,?,?,?)"; 
		
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setLong(1, userId);
			pstmt.setString(2, taskVO.getTaskDescribtion()); 
			pstmt.setBoolean(3, taskVO.isTask()); 
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis())); 
			pstmt.setTimestamp(5, taskVO.getEndTime());
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
	public TaskVO load() {
		return null;
	}
	// todo list에서 쓸거
	public List<TaskVO> loadAll(long userId) {
		connect();
		ArrayList<TaskVO> taskVO = new ArrayList<TaskVO>();
		String sql = "select * from tbl_task where user_id = ?";
		try {
			pstmt = conn.prepareStatement (sql);
			pstmt.setLong(1, userId); 
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				TaskVO vo= new TaskVO();
				vo.setTaskId(rs.getLong("task_id"));
				vo.setTaskDescribtion(rs.getString("task_describtion"));
				taskVO.add(vo);
			}
		rs.close();
		} 
		catch (SQLException e) { 
			e.printStackTrace();
		} 
		finally { 
			disconnect();
		}
		return taskVO;
	}
	// update
	// 테스크 완료 업데이트
	public boolean updateTaskDone(TaskVO taskVO) {
		return updateTaskDone(taskVO.getTaskId());		
	}
	public boolean updateTaskDone(long taskId) {
		connect();
		String sql = "update tbl_task set is_task=true where id=?"; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, taskId); 
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
	// 테스크 내용 수정 업데이트
	public boolean updateTask(TaskVO taskVO) {
		connect();
		String sql = "update tbl_task set task_describtion=? where id=?"; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, taskVO.getTaskDescribtion()); 
			pstmt.setLong(2, taskVO.getTaskId()); 
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
	// delete
	public boolean delete(TaskVO taskVO) {
		return delete(taskVO.getTaskId());
	}
	public boolean delete(long taskId) {
		connect();
		String sql = "DELETE * FROM tbl_task WHERE id=?"; 
		System.out.println("Delete 실행");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, taskId);
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
