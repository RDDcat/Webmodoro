package Service;

import java.util.List;

import Domain.TaskVO;
import Persist.TaskDAO;

public class TaskService {
	TaskDAO taskDAO = new TaskDAO();
	public void saveTask(long id) {
		// TODO id 값이 없으면 디비에 새로저장
		
		// TODO id 값이 있으면 디비에 업데이트
		
	}
	public void loadTask() {
		
	}
	public List<TaskVO> loadALLTask(long userId) {
		return taskDAO.loadAll(userId);		
	}

}
