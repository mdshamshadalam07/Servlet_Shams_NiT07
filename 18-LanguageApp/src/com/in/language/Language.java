package com.in.language;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

public class Language {
	public static void main(String[ ] args) {
		int sum=1, j=0, k=0;
		 LinkedHashSet<String> s1 = new  LinkedHashSet<String>();
		  Locale[ ] s =Locale.getAvailableLocales();
		   for(int i = 0; i <s.length; i++) {
			   s1.add(s [i].getDisplayLanguage());
		   }  // for

		    Iterator it = s1. iterator();
			while(it.hasNext()) {
				Object object = (Object) it.next();
				System.out.print(object+"  ");
				k++; j++;
				if (k==7) { 
					System.out.println();
					k=0;
				}
			}
			System.out.println(j);
	} // main
} // class