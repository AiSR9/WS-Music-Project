package com.musicproject.web.service;

import java.util.HashMap;
import java.util.Map;
import com.musicproject.web.data.*;

public class EventService {

	private static Map<Integer, Event> EVENT_DATA = new HashMap<Integer, Event>();

	private int getNewId() {
		int newId = 0;
		for (int id : EVENT_DATA.keySet()) {
			if (newId < id)
				newId = id;
		}
		return ++newId;
	}

	public Event addEvent(Event s) {
		int id = getNewId();
		if (EVENT_DATA.get(s.getId()) != null) {
			return null;
		}
		s.setId(id);
		EVENT_DATA.put(id, s);
		return s;
	}

	public boolean deleteEvent(int id) {
		if (EVENT_DATA.get(id) == null) {
			return false;
		}
		EVENT_DATA.remove(id);
		return true;
	}

	public Event getEvent(int id) {
		return EVENT_DATA.get(id);
	}
	
	public Event getEventByName(String name) {
		Event event = null;
		for (Map.Entry<Integer,Event> entry : EVENT_DATA.entrySet()) {
			if (entry.getValue().getName().equalsIgnoreCase(name)) {
				event = entry.getValue();
			}
		}
		return event;
	}

	// CAmbiar para recuperar el string con el id de artista!!!!!!!!!!
	//public String[] getAllEVENT(int id) {
	//	return EVENT_DATA.get(id);
	//}

}