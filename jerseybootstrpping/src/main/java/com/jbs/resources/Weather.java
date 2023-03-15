package com.jbs.resources;

import java.security.SecureRandom;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/weather")
public class Weather {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public int getWeather(@QueryParam("zip") String zip)
	{
		return new SecureRandom().nextInt();
	
	}

}
