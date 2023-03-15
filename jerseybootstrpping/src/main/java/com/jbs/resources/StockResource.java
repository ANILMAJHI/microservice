package com.jbs.resources;

import java.security.SecureRandom;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/stock")
public class StockResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double getMarketPrice(@QueryParam("stockName") String stockName)
	{
		return new SecureRandom().nextDouble();
	}

}
