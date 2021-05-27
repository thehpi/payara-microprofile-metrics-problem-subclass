package nl.hans.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cdi")
public class CDIResource {
    @Inject
    CDIBean cdiBean;

    @GET
    public Response get() {
        return Response.status(200).entity(cdiBean.runPlugins()).build();
    }
}
