package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ErrorController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;


public class FrontController extends HttpServlet{
	
	private ErrorController errorController = new ErrorController();
	private UserController userController=new UserController();
	private ReimbursementController reimbursementController= new ReimbursementController();
	protected void directControlRouter(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//how to get a value from your init params
		/*System.out.println(this.getInitParameter("DefaultRole"));
		ServletContext sc = this.getServletContext();
		
		System.out.println(sc.getInitParameter("JavaCoolFactor"));
		*/
		//be our front controller
		String URI = req.getRequestURI().substring(req.getContextPath().length(), 
													req.getRequestURI().length());
		
		System.out.println(URI);
		switch (URI) {
			case "/login":{
				switch (req.getMethod()) {
					case "GET":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "POST":{
						userController.userLogin(req, res);
						break;
					}
					case "PUT":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "DELETE":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				
				}
				break;
			}
			case "/viewAllTickets": {
				switch (req.getMethod()) {
					case "GET":{
						reimbursementController.findAllTickets(req, res);
						break;
					}
					case "POST":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "PUT":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "DELETE":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				}
				break;
			}
			case "/addTicket":{
				switch (req.getMethod()) {
				case "GET":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "POST":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "PUT":{
					reimbursementController.createTicket(req, res);
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "DELETE":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				default:{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
			}
			break;
			}
			case "/statusChange":{
				switch (req.getMethod()) {
				case "GET":{
					//TODO
					break;
				}
				case "POST":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "PUT":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "DELETE":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				default:{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
			}
			break;
			}
			case "/filterByStatus":{
				switch (req.getMethod()) {
				case "GET":{
					//TODO
					break;
				}
				case "POST":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "PUT":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "DELETE":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				default:{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
			}
			break;
			}
			default:{
				res.setStatus(404);
				res.getWriter().write("No Such Resource");
				break;
			}
			
		}
		
		
		
	}
	
	
	protected void directControl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//to handle all internal errors/exceptions
		try {
			directControlRouter(request, response);
		}catch (Throwable t) {
			errorController.handle(request, response, t);//go to the error controller
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
