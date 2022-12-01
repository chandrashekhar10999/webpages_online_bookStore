package com.bookstore.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.UserDao;
import com.bookstore.pojo.User;

@WebServlet("/userurl")
public class UserController extends HttpServlet
{
	String action;
	
	String userName,userEmail,userRole,userPassword;
	
	User user;
	UserDao userDao = new UserDao();
	
	HttpSession session;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		action = req.getParameter("action");
		if(action!=null && action.equals("login"))
		{
			resp.sendRedirect("login.jsp");
		}
		else if(action!=null && action.equals("register"))
		{
			resp.sendRedirect("register.jsp");
		}
		else if(action!=null && action.equals("logout"))
		{
			session.invalidate();
			session = req.getSession();
			session.setAttribute("msg", "Logout Successfully....");
			resp.sendRedirect("index.jsp");
			
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		action = req.getParameter("action");
		session = req.getSession();
		
		if(action!=null && action.equals("login"))
		{
			userEmail = req.getParameter("userEmail");
			userPassword = req.getParameter("userPassword");
			
			user = userDao.login(userEmail, userPassword);
			
			if(user!=null) 
			{
				session.setAttribute("user", user);
				session.setAttribute("msg", "Login Successfull...");
				resp.sendRedirect("index.jsp");
			}
			else
			{
				session.setAttribute("msg", "Login Unsuccessfull...");
				resp.sendRedirect("login.jsp");
			}
			
		}
		else if(action!=null && action.equals("register"))
		{
			userName = req.getParameter("userName");
			userEmail = req.getParameter("userEmail");
			userRole = req.getParameter("userRole");
			userPassword = req.getParameter("userPassword");
			// here we get the data from Registration form
			
			user = new User(userName, userEmail, userPassword, userRole);
			//here we create the object of the data 
			
			userDao.register(user);
			//here we save that object into database.
			
			session.setAttribute("msg", "Your Registration is Successfull.<br/>Please Login here.");
			resp.sendRedirect("login.jsp");
			
		}
	}
}
