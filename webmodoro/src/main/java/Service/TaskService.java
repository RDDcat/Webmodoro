package Service;

import java.util.List;

import Domain.TaskVO;
import Persist.TaskDAO;

public class TaskService {
	TaskDAO taskDAO = new TaskDAO();
	public void saveTask(long userid, TaskVO taskVO) {
		taskDAO.save(userid, taskVO);
	}
	public void loadTask() {
		
	}
	public List<TaskVO> loadALLTask(long userId) {
		return taskDAO.loadAll(userId);		
	}
	public void deleteTask(long TaskId) {
		taskDAO.delete(TaskId);
	}

}
