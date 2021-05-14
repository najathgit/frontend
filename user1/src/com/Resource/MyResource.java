package com.n.User.Resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.n.User.Model.User;
import com.n.User.Service.UserService;



@Path("/user")
public class MyResource {
	
	UserService app = new UserService();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers()
	{
		System.out.println("Display User List Successfully");
		return app.getUsers();
	}
	
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") int id)
	{
		System.out.println("Display Selected User Successfully");
		return app.getUser(id);
	
	}
	
	@GET
	@Path("username/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getPatientID(@PathParam("username") int username)
	{
		System.out.println("Display Username User Successfully");
		return app.getUsername(username);
	
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User createUser(User u1)
	{
		System.out.println("Insert Your User Successfully");
		app.createUser(u1);
		
		return u1;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User u1)
	{
		
		if(app.getUser(u1.getId()).getId()==0) {
			System.out.println("Insert Your User Successfully");
			app.createUser(u1);
			
		}
		else
		{
			System.out.println("Update Your User Successfully");
			app.updateUser(u1);
			
		}
		
		return u1;
	}
	
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User deleteUser(@PathParam("id") int id)
	{
		User u = app.getUser(id);
		
		if(u.getId()!=0)
			System.out.println("Delete Your User Successfully");
			app.deleteUser(id);
		return null;
	}
	
}
