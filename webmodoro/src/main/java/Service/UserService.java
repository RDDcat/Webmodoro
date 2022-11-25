package Service;

import java.util.List;

import Domain.TaskVO;
import Domain.UserVO;
import Persist.UserDAO;

public class UserService {
	UserDAO userDAO = new UserDAO();
	
	public UserVO getUserVO(long userId) {
		return userDAO.load(userId);
	}
	
	public long checkLogin(String userName, String passwd) {
		long userId = userDAO.login(userName, passwd);
		return userId;
	}
	public void register(String name, String passwd, String contact) {
		UserVO userVO = new UserVO(name, passwd, contact);
		if(userDAO.save(userVO)) {
			// 유저 저장 성공
			System.out.println("저장 성공");
			System.out.println(name +" : 저장 : " + passwd + contact);
		}
	}
}
