package patinette.endpoints;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import patinette.entity.User;
import patinette.service.UserService;

@Path("/authentication")
public class AuthenticationEndpoint {
	
	@Inject
	private UserService userService;
	
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(User user) {
    	try {
            // Authenticate the user using the credentials provided
            user = authenticate(user.getLogin(), user.getPassword());
            return Response.ok(user).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }      
    }
    
    @Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		boolean success = userService.createUser(user.getLogin(), user.getPassword());
		if (success)
			return Response.status(Status.CREATED).entity(user).build();
		else
			return Response.status(Status.CONFLICT).entity("L'utilisateur existe déjà").build();
	}
    
    private User authenticate(String login, String password) throws Exception {
    	if (!userService.authenticateUser(login, password)) {
    		throw new Exception("Echec lors de l'authentification");
    	}
    	return userService.findUserByLogin(login);
    }
    
}