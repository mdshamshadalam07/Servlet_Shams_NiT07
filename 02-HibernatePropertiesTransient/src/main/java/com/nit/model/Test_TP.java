package com.nit.model;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test_TP {
	public static void main(String[] args) {
		try {
		//1. create config obj
		Configuration cfg=new Configuration();
		//2. load cfg.xml
		cfg.configure();
		//3. build ses fact
		SessionFactory sf=cfg.buildSessionFactory();
		//4. open one session
		Session ses=sf.openSession();
		//5. begin Tx
		Transaction tx=ses.beginTransaction();
		//6. perform save operation
		Product5 prod=new Product5();
		prod.setProdId(11);
		prod.setProdCode("804402");
		prod.setProdCost(10.5);
		prod.setProdGst(2.5);
		
		Serializable s=ses.save(prod);
		Integer id=(Integer)s;
        //7. commit
		tx.commit();
		//8.close ses
		ses.close();
		
		System.out.println("Done:"+id);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
   }
}
