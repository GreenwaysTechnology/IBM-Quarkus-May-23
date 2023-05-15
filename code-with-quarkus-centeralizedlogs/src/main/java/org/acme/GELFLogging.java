package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.logging.Logger;

@Path("/log")
@ApplicationScoped
public class GELFLogging {

    private static final Logger LOG =Logger.getLogger(GELFLogging.class);
    @GET
    public String log(){
        LOG.info("This is ELF logs");
        return "hello";
    }
}
