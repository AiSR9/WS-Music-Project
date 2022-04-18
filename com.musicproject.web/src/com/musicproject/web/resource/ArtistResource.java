package com.musicproject.web.resource;

import java.net.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.musicproject.web.data.Artist;
import com.musicproject.web.service.ArtistService;

@Path("/artists")
public class ArtistResource {

	ArtistService service = new ArtistService();

	@Context
	UriInfo uriInfo;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addStudent(Artist s) {
		Artist artist = service.addArtist(s);
		if (artist == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		URI uri = uriInfo.getRequestUri();
		String newUri = uri.getPath() + "/" + artist.getId();
		return Response.status(Response.Status.CREATED).entity(artist).contentLocation(uri.resolve(newUri)).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteArtist(@PathParam("id") int id) {
		if (service.deleteArtist(id) == false) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getArtist(@PathParam("id") int id) {
		Artist artist = service.getArtist(id);
		if (artist == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri()).rel("self").type("application/xml").build();
		return Response.status(Response.Status.OK).entity(artist).links(link).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getArtistByName(@PathParam("name") String name) {
		Artist artist = service.getArtistByName(name);
		if (artist == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Link link = Link.fromUri(uriInfo.getRequestUri()).rel("self").type("application/xml").build();
		return Response.status(Response.Status.OK).entity(artist).links(link).build();
	}
}