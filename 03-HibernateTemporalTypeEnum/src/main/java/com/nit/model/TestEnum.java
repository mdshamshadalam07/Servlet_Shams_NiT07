package com.nit.model;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestEnum {
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
		ProductEnum prod1=new ProductEnum();
		prod1.setProd1Id(150);
		prod1.setProd1Code("Sangita");
		
		Date d = new Date(System.currentTimeMillis());
		prod1.setExpDate(d);
		prod1.setMfgDate(d);
		prod1.setTestSlot(d);
		
		
		Serializable s=ses.save(prod1);
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

