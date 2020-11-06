package gui;

import java.awt.Color;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Event;
import domain.User;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import businessLogic.BLFactory;
import businessLogic.ExtendedIterator;

public class ApplicationLauncher { 
	
	public static void main(String[] args) {
		
		// obtener el objeto Facade local
		int isLocal = 1;
		BLFacade blFacade = (new BLFactory()).getBusinessLogicFactory(isLocal);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = sdf.parse("17/12/2020"); // 17 del mes que viene
			ExtendedIterator<Event> i = blFacade.getEventsIterator(date);
			Event e;
			System.out.println("_____________________");
			System.out.println("RECORRIDO HACIA ATRÁS");
			i.goLast(); // Hacia atrás
			while (i.hasPrevious()) {
				e = i.previous();
				System.out.println(e.toString());
			}
			System.out.println();
			System.out.println("_____________________");
			System.out.println("RECORRIDO HACIA ADELANTE");
			i.goFirst(); // Hacia adelante
			while (i.hasNext()) {
				e = i.next();
				System.out.println(e.toString());
			}
			
		} catch (ParseException e1) {
			System.out.println("Problems with date?? " + "17/12/2020");
		}
		
	}

}
