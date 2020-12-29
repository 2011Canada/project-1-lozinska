package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class UserServicesImplementation implements UserServices{
private UserDAO ud;
public UserServicesImplementation(UserDAO ud) {
	this.ud=ud;
}
	@Override
	public User login(String username, String password) {
		User u=ud.getUser(username, password);
		return u;
	}

}
