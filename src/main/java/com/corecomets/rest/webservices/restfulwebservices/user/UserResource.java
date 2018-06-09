package com.corecomets.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id-"+ id);
		
		//HATEOS Application as the Engine of Application State
		//- Sends response back with the User info along with the link to other information. like all users etc.
		// Input - user id
		// Output - User information and link with a relative name
		// "all-users", SERVER_PATH + "/users"
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		
		return resource;
	}

	//Delete a user
	// input - send id of the user to be deleted
	//output -  sends a http status message with some explanation from the customized response entity exception handler
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User deletedUser = service.deleteById(id);
		
		//If we need to send back some response use the below commented code
//		URI location  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(deletedUser.getId()).toUri();
//		System.out.println("printing the location : " +location );
//		return (ResponseEntity<Object>) ResponseEntity.noContent();
		
		//If we want to just send a status response then use below code
		if(deletedUser == null) {
			throw new UserNotFoundException("id- " +id);
		}
	}

	//
	// input - details of user
	// output - CREATED & Return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// CREATED
		// /user/{id}     savedUser.getId()
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
