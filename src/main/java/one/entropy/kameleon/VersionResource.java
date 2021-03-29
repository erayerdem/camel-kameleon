package one.entropy.kameleon;

import io.quarkus.cache.CacheResult;
import io.vertx.core.json.JsonArray;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/version")
public class VersionResource {

    @Inject
    VersionService versionService;

    @GET
    @Path("/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    @CacheResult(cacheName = "versions")
    public JsonArray versions(@PathParam("type") String type) throws Exception {
        return versionService.getVersions(type);
    }

}