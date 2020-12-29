package com.revature.repositories;

public class UserDebugger {
public static void main(String[] args) {
	
	UserDAO user=new UserPostgresDAO();
	System.out.println(user.getUser("aharris","12345").getFirstName()+" "+user.getUser("aharris","12345").getLastName());
	
}
}
