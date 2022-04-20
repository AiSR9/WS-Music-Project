# WS-Music-Project

Report of WEB SERVICES’ PROJECT

Project 5: Music events and Music Web Service

by the students:
Aitor Sánchez Rojo       and       Markidi Christina
(aitorsanchezr99@gmail.com)                (chrimarkidi@gmail.com) 

Cergy 2022


--------------------------------------------------------------------

Table of contents:
1. Project Description ………………………………………...… 
2. Collect informations ………………………………………....
3. First Part : Create the service ……….……….................
4. Second Part : Display ………………………………………..

--------------------------------------------------------------------

1. Project Description

The purpose of this project is to create a service that registers and provides information for upcoming events, either by area or by artist. So, the first part of the project is to use the web services to create some events and artists, from our client. The second part is for the client to display the events grouped by artist. Along with each event we included the nationality of the artist, retrieved from a music Web service. 

The main functionalities of the project are to add, delete, and retrieve information from the artist and the events.

---------------------------------------------------------------------

2. Data classes

2.1 Artist
Class that defines and implements the artist attributes (id, name, nationality) and the constructors, getters and setters of these attributes.

2.2 Event
Class that defines and implements the artist attributes (id, name, area, date, artist_id) and the constructors, getters and setters of these attributes.

---------------------------------------------------------------------

3. Service classes

  3.1 ArtistService
In this class we have all the functions that define the internal usage of the Web Service referred to the artists. 

  3.1.1. getNewId()
A function that generates a new ID based on how many artists are in the map and then it returns the new ID.

  3.1.2. Artist addArtist(Artist s)
A function that adds an artist to the map and returns the same artist.

  3.1.3. deleteArtist(int id)
A function that deletes the artist based on its ID and returns a boolean parameter depending on the deletion of the artist.

  3.1.4. Artist getArtist(int id)
A function that gets the artist’s info by its ID and returns the event matching the type ID.

  3.1.5. Artist getArtistByName(String name)
A function that gets the artist’s info by its name and returns the artist matching typed name.



  3.2. EventService
In a similar way as the ArtistService, we created some functions that help us achieve the wanted results.

  3.2.1. getNewId()
A function that generates a new ID based on how many events are in the map and then it returns the new ID.

  3.2.2. Event addEvent(Event s)
A function that adds an event to the map and returns the same artist.

  3.2.3. deleteEvent(int id)
A function that deletes the event based on its ID and returns a boolean parameter depending on the deletion of the event.

  3.2.4. Event getEvent(int id)
A function that gets the event’s info by its ID and returns the event matching the type ID.

  3.2.5. Event getEventByName(String name)
A function that gets the event’s info by its name and returns the event matching typed name.

---------------------------------------------------------------------

4.1. ArtistResource

4.2. EventResource

These two classes define and implement the same functions as the Service classes in a way they can comunicate and exchange information with the client. They are use as intermediaries betweeen the client and the Web Service.

---------------------------------------------------------------------

Summary:

- IN CLIENT:
Test

- IN WEB:
Data.artist
Data.events
Artist.Resource
Event.Resource
Artist.Service
Event.Service
