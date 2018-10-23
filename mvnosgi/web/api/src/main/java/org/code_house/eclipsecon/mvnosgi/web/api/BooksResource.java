package org.code_house.eclipsecon.mvnosgi.web.api;

import org.code_house.eclipsecon.mvnosgi.dto.BookDTO;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.UUID;

@Path("/")
public interface BooksResource extends Resource {

    @GET
    List<BookDTO> get();

    @Path("/{id}")
    BookResource book(@PathParam("id") UUID book);

    @POST
    BookResource create(BookDTO book);
}
