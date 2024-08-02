package com.example.Application1;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class studentcontroller {
	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);
		int ch;
		do {
			displayMenu();
			// if our choice is in string we have to convert int into String by using parseInt method  
			ch = Integer.parseInt(src.nextLine());
			switch (ch) {
			case 1:insertion();
			break;
			case 2: deletion();
			break;
			case 3 : update();
			break;
			case 4 : getall();
			break;
			case 5 : getbyid();
			break;
			case 6 :
				System.exit(0);
			    break;

			default:
				System.out.println("Invalid Operation");
				break;
			}
			
		}
		while(ch>0);
		
		
	}

	private static void getbyid() {
		Scanner src = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("enter id");
		int id = src.nextInt();
		Transaction t = s.beginTransaction();
		student st  = s.get(student.class, id);
		if(st!=null) {
			System.out.println("id"+st.getId());
			System.out.println("name"+st.getName());
			System.out.println("email"+st.getEmail());
			System.out.println("password"+st.getPassword());
		}
		else {
			System.out.println("Data is not available");
		}
		t.commit();
	}

	private static void getall() {
		
		Scanner src = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		List<student>li = s.createQuery("from student",student.class).list();
		t.commit();
		for(student st:li) {
			System.out.println("id:"+st.getId());
			System.out.println("name:"+st.getName());
			System.out.println("email:"+st.getEmail());
			System.out.println("password:"+st.getPassword());
			
		}
		
		
	}

	private static void update() {
		Scanner src = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("enter id");
		int id = src.nextInt();
		Transaction t = s.beginTransaction();
		student st  = s.get(student.class, id);
		if(st!=null) {
			System.out.println("Enter new name");
			String name = src.next();
			st.setName(name);
			System.out.println("Enter new email");
			String email = src.next();
			st.setEmail(email);
			System.out.println("Enter new password");
			String password = src.next();
			st.setPassword(password);
			System.out.println("Table is updated");
		}
		else {
			System.out.println("error");
		}
		t.commit();
		
		
	}

	private static void deletion() {
		
		Scanner src = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("enter id");
		int id = src.nextInt();
		Transaction t = s.beginTransaction();
		student st  = s.get(student.class, id);
		
		
		
		
		
		s.delete(st);
		t.commit();
		System.out.println("successfully deleted");
		
	}

	private static void insertion() {
		Scanner src = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		student st = new student();
		System.out.println("enter the name");
		String name = src.nextLine();
		st.setName(name);
		System.out.println("enter the email");
		String email = src.nextLine();
		st.setEmail(email);
		System.out.println("enter the password");
		String password = src.nextLine();
		st.setPassword(password);
		
		s.save(st);
		t.commit();
				}

	private static void displayMenu() {
		System.out.println("______");
		System.out.println("\t1.insertion");
		System.out.println("\t2.deletion");
		System.out.println("\t3.update");
		System.out.println("\t4.getall");
		System.out.println("\t5.getbyid");
		
	}

}
