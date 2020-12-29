package com.revature.services;

import java.util.Scanner;

import com.revature.repositories.UserPostgresDAO;

public class UserDebugger {
public static void main(String[]args) {
	UserServices us=new UserServicesImplementation(new UserPostgresDAO());
Scanner user=new Scanner(System.in);

System.out.println("username");
String username=user.nextLine();
System.out.println("password");
String password=user.nextLine();
System.out.println(us.login(username, password).getFirstName());
}
}
