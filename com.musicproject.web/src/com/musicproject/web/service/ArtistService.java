package com.musicproject.web.service;

import java.util.HashMap;
import java.util.Map;

import com.musicproject.web.data.Artist;

public class ArtistService {

	private static Map<Integer, Artist> ARTIST_DATA = new HashMap<Integer, Artist>();

	private int getNewId() {
		int newId = 0;
		for (int id : ARTIST_DATA.keySet()) {
			if (newId < id)
				newId = id;
		}
		return ++newId;
	}

	public Artist addArtist(Artist s) {
		int id = getNewId();
		if (ARTIST_DATA.get(s.getId()) != null) {
			return null;
		}
		s.setId(id);
		ARTIST_DATA.put(id, s);
		return s;
	}

	public boolean deleteArtist(int id) {
		if (ARTIST_DATA.get(id) == null) {
			return false;
		}
		ARTIST_DATA.remove(id);
		return true;
	}

	public Artist getArtist(int id) {
		return ARTIST_DATA.get(id);
	}

	public Artist getArtistByName(String name) {
		Artist artist = null;
		for (Map.Entry<Integer,Artist> entry : ARTIST_DATA.entrySet()) {
			if (entry.getValue().getName().equalsIgnoreCase(name)) {
				artist = entry.getValue();
			}
		}
		return artist;
	}

}
