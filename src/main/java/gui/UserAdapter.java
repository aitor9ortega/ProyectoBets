package gui;

import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import domain.Bet;
import domain.User;

public class UserAdapter extends AbstractTableModel {
	
	private User usuario;
	private Vector<Bet> myList;

	
	public UserAdapter(User user) {
		this.usuario=user;
		myList= user.getApuestas();
	}

	@Override
	public int getRowCount() {
		int size;
	      if (myList == null) {
	         size = 0;
	      }
	      else {
	         size = myList.size();
	      }
	      return size;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object temp = null;
	      if (columnIndex == 0) {
	         temp = myList.get(rowIndex).getEventoAsociado();
	      }
	      else if (columnIndex == 1) {
	         temp = myList.get(rowIndex).getPreguntaAsociada();
	      }
	      else if (columnIndex == 2) {
	         temp =  (myList.get(rowIndex).getEventoAsociado().getEventDate());
	      }
	      else if (columnIndex == 3) {
		         temp =  new Double(myList.get(rowIndex).getCantNumber());
		  }
	      
	      return temp;
	}

	


}

