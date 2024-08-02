package com.example.Application1;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
@WebServlet( "/toconnect")
public class studentservlets extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		Scanner src = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		String name = req.getParameter("name");
		String Email = req.getParameter("email");
		
		String Password = req.getParameter("password");
		
		student st = new student(0,name,Email,Password);
		
		
	
		s.save(st);
		
		t.commit();
	}

}
