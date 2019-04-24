package patinette.endpoints;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import patinette.entity.Location;
import patinette.entity.Trottinette;
import patinette.service.TrottinetteService;

@Path("/trottinette")
public class TrottinetteEndpoint {
	
	@Inject
	private TrottinetteService trottinetteService;
	
    @GET
    @Path("/allTrottinettes")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllAvailableTrottinettes() {
    	List<Trottinette> trottinettes = trottinetteService.findAllAvailableTrottinettes();
    	return Response.ok(trottinettes).build();
    }
    
    @Path("/startLocation")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response startLocation(Location location) {
    	location = trottinetteService.startLocation(location);
		return Response.status(Status.CREATED).entity(location).build();
    }

}
