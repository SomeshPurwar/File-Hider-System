package service;

import java.sql.SQLException;

import dao.UserDAO;
import model.User;

public class UserService {
	
	public static Integer saveUser(User user) {
		try {
			if(UserDAO.isExists(user.getEmail())) {
				return 0;
			}else {
				
				return UserDAO.saveUser(user);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
