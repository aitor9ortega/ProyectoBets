package businessLogic;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import domain.Event;

public class ExtendedIteratorEvents implements ExtendedIterator<Event>{
	
	Object[] list;
	private int size;
	
	public ExtendedIteratorEvents(Vector<Event> events) {
		list= events.toArray();	
	}
	
	
	@Override
	public boolean hasNext() {
        if (size < list.length-1)
            return true;
        else
            return false;
	}

	@Override
	public Event next() {
        if (this.hasNext()) {
        	size++;
            return (Event) list[size];
        }else {
            return null;
        }
	}

	@Override
	public Event previous() {
        if (this.hasPrevious()) {
        	size--;
            return (Event) list[size];
        } else {
            return null;
        }
	}

	@Override
	public boolean hasPrevious() {
        if (size > 0)
            return true;
        else
            return false;
	}

	@Override
	public void goFirst() {
		size=-1;}

	@Override
	public void goLast() {
		size=list.length;}

}
