package at.htl.res;

import at.htl.model.Department;
import at.htl.model.Employee;
import at.htl.repo.DeparmentRepo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/api/dept")
public class DepartmentRes {

    @Inject
    DeparmentRepo repo;

    @GET
    @Path("/{id}")
    public Department getDepartment(@PathParam("id") Long id) {
        return repo.findById(id);
    }

}
