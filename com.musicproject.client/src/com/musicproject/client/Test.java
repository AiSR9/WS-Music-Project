package com.musicproject.client;

import java.util.Date;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.cxf.jaxrs.client.*;
import com.musicproject.web.data.*;

import java.util.Scanner;

public class Test {

	private static String WSEvents = "http://localhost:8080/student.musicproject.web/api/events";
	private static String WSArtists = "http://localhost:8080/com.musicproject.web/api/artists";
	private static Scanner entry = new Scanner(System.in);

	public static void main(String[] args) {
		
		String name, nationality, area, date, artist_name;
		int option, artist_id;
		Artist artist;
		Event event;	

		System.out.println("Web Services Project: music");
		System.out.println("Please choose an option (0 to quit): ");
		System.out.println("1- Create an artist");
		System.out.println("2- Create an event");
		System.out.println("3- Retrieve an artist");
		System.out.println("4- Retrieve an event");
		System.out.println("5- Delete an artist");
		System.out.println("6-  an event");


		option = entry.nextInt();

		while (option != 0) {

			switch (option) {

			case 1:
				System.out.print("Type the artist's name: ");
				name = entry.next();
				System.out.print("Type the artist's nationality: ");
				nationality = entry.next();
				addArtist(name, nationality);
				break;

			case 2:
				System.out.print("Type the event's name: ");
				name = entry.next();
				System.out.print("Type the event's area: ");
				area = entry.next();
				System.out.print("Type the event's date: ");
				date = entry.next();
				System.out.print("Type the event's artist name: ");
				artist_name = entry.next();
				artist_id = getArtistByName(artist_name).getId();
				addEvent(name, area, date, artist_id);
				break;

			case 3:
				System.out.print("Type the artist's name: ");
				name = entry.next();
				artist = getArtistByName(name);
				System.out.print("Artist's info: ");
				artist.toString();

			case 4:
				System.out.print("Type the event's name: ");
				name = entry.next();
				event = getEventByName(name);
				System.out.print("Event's info: ");
				event.toString();
				
			case 5:
				System.out.print("Type the artist's name: ");
				name = entry.next();
				artist = getArtistByName(name);
				deleteArtist(artist.getId());
				
			case 6:
				System.out.print("Type the event's name: ");
				name = entry.next();
				event = getEventByName(name);
				deleteEvent(event.getId());
			}
			System.out.println("Please choose an option");
			option = entry.nextInt();
		}
	}

//------------------------------------------------------------------------------------------------------

	private static Integer addArtist(String name, String nationality) {
		System.out.print("Adding " + name + "... ");
		WebClient c = WebClient.create(WSArtists);
		Artist ArtistAdded = new Artist(name, nationality);
		Response r = c.post(ArtistAdded);
		if (r.getStatus() == 400) {
			System.out.println("Oops!");
			return null;
		}
		String uri = r.getHeaderString("Content-Location");
		System.out.println("OK.");
		return Integer.parseInt(uri.substring(uri.lastIndexOf('/') + 1));
	}

	private static Integer addEvent(String name, String area, String date, int artist_id) {
		System.out.print("Adding " + name + "... ");
		WebClient c = WebClient.create(WSEvents);
		Event EventAdded = new Event(name, area, date, artist_id);
		Response r = c.post(EventAdded);
		if (r.getStatus() == 400) {
			System.out.println("Oops!");
			return null;
		}
		String uri = r.getHeaderString("Content-Location");
		System.out.println("OK.");
		return Integer.parseInt(uri.substring(uri.lastIndexOf('/') + 1));
	}

	// Método para encontrar id por name

	private static Boolean deleteArtist(Integer id) {
		System.out.print("Deleting " + id + "... ");
		WebClient c = WebClient.create(WSArtists).path(id);
		int status = c.delete().getStatus();
		if (status == 200) {
			System.out.println("OK.");
			return true;
		}
		System.out.println("Oops!");
		return false;
	}

	private static Boolean deleteEvent(Integer id) {
		System.out.print("Deleting " + id + "... ");
		WebClient c = WebClient.create(WSEvents).path(id);
		int status = c.delete().getStatus();
		if (status == 200) {
			System.out.println("OK.");
			return true;
		}
		System.out.println("Oops!");
		return false;
	}

	private static Artist getArtist(Integer id) {
		System.out.print("Getting " + id + "... ");
		WebClient c = WebClient.create(WSArtists).path(id);
		Artist s = null;
		try {
			s = c.get(Artist.class);
			System.out.println(s.toString());
		} catch (NotFoundException e) {
			System.out.println("Oops!");
		}
		return s;
	}

	private static Event getEvent(Integer id) {
		System.out.print("Getting " + id + "... ");
		WebClient c = WebClient.create(WSEvents).path(id);
		Event s = null;
		try {
			s = c.get(Event.class);
			System.out.println(s.toString());
		} catch (NotFoundException e) {
			System.out.println("Oops!");
		}
		return s;
	}
	
	private static Artist getArtistByName(String name) {
		System.out.print("Getting " + name + " 's info");
		WebClient c = WebClient.create(WSArtists);
		Artist s = null;
		try {
			s = c.get(Artist.class);
			System.out.println(s.toString());
		} catch (NotFoundException e) {
			System.out.println("Oops!");
		}
		return s;
	}
	
	private static Event getEventByName(String name) {
		System.out.print("Getting " + name + "event info");
		WebClient c = WebClient.create(WSEvents);
		Event s = null;
		try {
			s = c.get(Event.class);
			System.out.println(s.toString());
		} catch (NotFoundException e) {
			System.out.println("Oops!");
		}
		return s;
	}

//--------------------------------------------------------------------------------------------------

}
