package com.rev.etl.faker.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.rev.etl.faker.dao.OrderDAO;
import com.rev.etl.faker.entities.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.ws.rs.QueryParam;
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;
import java.io.StringWriter;





@Path("/services")
public class SampleOrderResource {

    private final static Logger logger = LoggerFactory.getLogger(SampleOrderResource.class.getSimpleName());

    public final static int PRETTY_PRINT_INDENT_FACTOR = 4;

    private OrderDAO orderDAO;
    private Marshaller marshaller;

    public SampleOrderResource(OrderDAO orderDAO, Marshaller marshaller) {
        this.orderDAO = orderDAO;
        this.marshaller = marshaller;
    }


    @GET
    @Path("/sampleorder")
    @Produces(MediaType.APPLICATION_XML)
    @Timed
    @ExceptionMetered
    public Response getSampleOrder(@QueryParam("format") String format) throws JAXBException {
        Order order = orderDAO.getOrder();
        StringWriter sw = new StringWriter();
        marshaller.marshal(order, sw);

        if(format!=null  && format.equals("xml")){
            return Response.ok().entity(sw.toString()).build();

        }

        String jsonPrettyPrintString = null;
        try{
            JSONObject xmlJSONObj = XML.toJSONObject(sw.toString());
            jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);

            }
        catch (JSONException je) {
            System.out.println(je.toString());
        }
        return Response.ok().entity(jsonPrettyPrintString).build();
    }
}
