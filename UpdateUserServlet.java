package com.servlets;
import java.io.IOException;
import java.sql.PreparedStatement;

import com.dao.UserDao;
import com.db.DBconnect;
import com.entities.User;
import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/update_profile")
public class UpdateUserServlet  extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
	try
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String qua=req.getParameter("qua");
		String email=req.getParameter("email");
		String ps=req.getParameter("ps");
		UserDao dao =new UserDao(DBconnect.getClass());
		User  u=new User( id,  name,  email, password,qualification, role);
		boolean f=dao.updateUser(u);
		httpSession session=req.getSession();
		if(f)
		{
			Session.setAttribute("succMsg","profile update successfully");
			resp.sendRedirect("user_view.jsp");
		}
		else
		{
			Session.setAttribute("succMsg","something wrong on server");
			resp.sendRedirect("user_view.jsp");
			}
		
	
	}catch(Exception e)
	{
		e.printStackTrace();
		
		}
	return u;
}
public boolean updateUser(User u) {
	boolean f=false;
	try
	{
		String="update user name" ?qualification=?,email=?,password=?where id=;preparedStatement(sql);
		PreparedStatement ps=conn.preparedStatement(sql);
		ps.setString(1, u.getName());
		ps.setString(2,u.getQualification());
		ps.setString(1, u.getEmail());
		ps.setString(2,u.getPassword());
		ps.setString(1, u.getgetId());
		 int i=ps.executeUpdate();
		 if(i==1)
		 {
			 f=true;
		 }
		 
		 }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return f;
}
}


		



