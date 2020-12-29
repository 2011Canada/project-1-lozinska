package com.revature.repositories;

import com.revature.models.User;

public interface UserDAO {
public User getUser(String username, String password);
}
