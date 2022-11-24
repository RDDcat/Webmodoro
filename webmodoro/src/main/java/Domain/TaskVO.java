package Domain;

import java.sql.Timestamp;

public class TaskVO {
	long taskId;
	long userId;
	String taskDescribtion;
	Timestamp saveTime;
	Timestamp endTime;	

	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getTaskDescribtion() {
		return taskDescribtion;
	}
	public void setTaskDescribtion(String taskDescribtion) {
		this.taskDescribtion = taskDescribtion;
	}
	public Timestamp getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(Timestamp saveTime) {
		this.saveTime = saveTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}

