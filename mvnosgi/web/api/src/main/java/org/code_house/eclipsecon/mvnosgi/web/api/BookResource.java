package org.code_house.eclipsecon.mvnosgi.web.api;

import org.code_house.eclipsecon.mvnosgi.dto.BookDTO;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;

public interface BookResource extends Resource {

    @GET
    BookDTO get();

    @DELETE
    boolean delete();

}
