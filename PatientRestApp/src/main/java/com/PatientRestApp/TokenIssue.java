package com.PatientRestApp;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authenticate")
public class TokenIssue {

	
	
		@Path("/authenticateUser")
	    @POST
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	    public Response authenticateUser(@FormParam("username") String username, 
	                                     @FormParam("password") String password) {

	        try {

	            // Authenticate the user using the credentials provided
	            authenticate(username, password);

	            // Issue a token for the user
	            String token = issueToken(username);

	            // Return the token on the response
	            return Response.ok(token).build();

	        } catch (Exception e) {
	            return Response.status(Response.Status.UNAUTHORIZED).build();
	        }      
	    }

	  private void authenticate(String username, String password) throws Exception {
	        
		  if("user".equals(username)&& "password".equals(password)){
			   return;			   
		   }
	  }
		  // Authenticate against a database, LDAP, file or whatever
	        // Throw an Exception if the credentials are invalid
	    private String issueToken(String username) {
		    
	    	RandToken randToken = new RandToken();
	    	
	    	String string = randToken.nextSessionId();
	    	System.out.println(string);
	    	return string;
	    	    
	    		 
	        // Issue a token (can be a random String persisted to a database or a JWT token)
	        // The issued token must be associated to a user
	        // Return the issued token
	    }
	}

