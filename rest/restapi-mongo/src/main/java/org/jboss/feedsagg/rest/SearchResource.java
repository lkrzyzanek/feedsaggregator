package org.jboss.feedsagg.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.feedsagg.rest.model.BlogPost;

import io.smallrye.mutiny.Uni;

@Path("/rest/v1/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {

    @Inject BlogPostMongoService blogPostMongoService;

    @GET
    public Uni<List<BlogPost>> search(@QueryParam("from") Integer from, @QueryParam("size") Integer size, @QueryParam("sort") String sort, @QueryParam("feed") String feed, @QueryParam("group") String group) {
        return blogPostMongoService.search(from, size, sort, feed, group);
    }

}
