package com.klef.jfsd.exam;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class ClientDemo {
    public static void main(String args[]) {
        ClientDemo operations = new ClientDemo();
        // Uncomment the method you want to test
        // operations.addDepartment();
        operations.updateDepartment();
    }

    // Add department using Persistent Object (PO)
    public void addDepartment() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        Department department = new Department();
        department.setName("CSE");
        department.setLocation("Hyd");
        department.setHodName("Prem");

        session.persist(department); 
        t.commit();
        System.out.println("Department Added Successfully");
        session.close();
        sf.close();
    }

   
    public void updateDepartment() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Department ID:");
        int id = sc.nextInt();
        System.out.println("Enter New Department Name:");
        String name = sc.next();
        System.out.println("Enter New Department Location:");
        String location = sc.next();
        System.out.println("Enter New HOD Name:");
        String hodName = sc.next();

        MutationQuery query = session.createMutationQuery(
                "update Department set name=?1, location=?2, hodName=?3 where id=?4");
        query.setParameter(1, name);
        query.setParameter(2, location);
        query.setParameter(3, hodName);
        query.setParameter(4, id);

        int n = query.executeUpdate();
        t.commit();
        System.out.println(n + " Department(s) Updated Successfully");

        sc.close();
        session.close();
        sf.close();
    }
}
