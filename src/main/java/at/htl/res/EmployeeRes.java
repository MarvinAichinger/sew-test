package at.htl.res;

import at.htl.model.Employee;
import at.htl.repo.EmployeeRepo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/api/emp")
public class EmployeeRes {

    @Inject
    EmployeeRepo repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmployees() {
        return repo.findAll().stream().toList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("id") Long id) {
        return repo.findById(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response putEmployee(Employee employee, @Context UriInfo context) {
        try {
            Employee emp = repo.getEntityManager().merge(employee);
            URI uri = context.getAbsolutePathBuilder().path(Long.toString(emp.id)).build();
            return Response.created(uri).build();
        }catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/staff")
    @Transactional
    public Response getStaffOf(Employee manager) {
        List<Employee> staff = repo.getStaffOf(manager);
        if (staff == null) {
            return Response.ok().entity(new ArrayList<>()).build();
        }
        return Response.ok().entity(staff).build();
    }

}
