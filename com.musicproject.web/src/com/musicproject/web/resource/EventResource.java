package com.musicproject.web.resource;

import java.net.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.musicproject.web.data.Event;
import com.musicproject.web.service.EventService;

@Path("/events")
public class EventResource {

	EventService service = new EventService();

	@Context
	UriInfo uriInfo;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addStudent(Event s) {
		Event event = service.addEvent(s);
		if (event == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		URI uri = uriInfo.getRequestUri();
		String newUri = uri.getPath() + "/" + event.getId();
		return Response.status(Response.Status.CREATED).entity(event).contentLocation(uri.resolve(newUri)).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteEvent(@PathParam("id") int id) {
		if (service.deleteEvent(id) == false) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getEvent(@PathParam("id") int id) {
		Event event = service.getEvent(id);
		if (event == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri()).rel("self").type("application/xml").build();
		return Response.status(Response.Status.OK).entity(event).links(link).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getEventbyName(@PathParam("name") String name) {
		Event event = service.getEventByName(name);
		if (event == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri()).rel("self").type("application/xml").build();
		return Response.status(Response.Status.OK).entity(event).links(link).build();
	}
	
}
