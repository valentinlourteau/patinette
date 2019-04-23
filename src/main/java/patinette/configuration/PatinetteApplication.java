package patinette.configuration;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class PatinetteApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
	    Set<Class<?>> classes = new HashSet<Class<?>>();
	    //Ajouter les services / ressources ici
	    return classes;
	}
	
	

}
