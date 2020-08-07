package Modelo;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Practica {

	public static void main(String[] args) {
		Date date=new Date();
		
		 
		Calendar calendario=new GregorianCalendar();
		calendario.setTime(new Date());
		System.out.println(date.toLocaleString().intern());
		/*ArrayList<Calendar> lista=new ArrayList<Calendar>();
		for(int i=0;i<5;i++) {
			Calendar calendario=new GregorianCalendar();
			calendario.setTime(new Date());
			lista.add(calendario);
			Thread a=new Thread();
			try {
				System.out.println(1);
				a.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getTime());
		}*/
		
		
	}

}
