package com.PatientRestApp.services;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.PatientRestApp.Dao.PatientDao;
import com.PatientRestApp.Entity.Patients;
import com.PatientRestApp.Entity.Token;

@Path("TokenService")
public class TokenServices {
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
     public Patients getpatients(@PathParam("id") int id){
		
		System.out.println(id);
		
		Patients patient = PatientDao.getPatientsById(id);
		
		return patient;
				
	}
/*	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Patients> getAllPatients(){
		
		List<Patients> patients = PatientDao.getAllPatients();
		
		return patients;
	}
	*/
	@Path("/token/gettoken")
	@GET
	public Response getToken(@HeaderParam("id") int id,@HeaderParam("password") String password){
		
		Response response = null;
		
		PatientDao patientDao = new PatientDao();
		
		Patients patients = PatientDao.getPatientsById(id);
		
		if(patients!=null){
			if(!password.equals(patients.getPwd())){
				
				response = Response
                        .status(Response.Status.UNAUTHORIZED)
                        .entity("User cannot access this reousrce")
                        .build();
				
			}
			else {
				String tokenId = UUID.randomUUID().toString();
				Token token = new Token(id,tokenId);
				patientDao.saveToken(token);
				System.out.println("token: "+token.getToken());
				response = Response
                        .status(Response.Status.OK)
                        .entity("Your Token :"+token.getToken())
                        .build();
			}
		
		}
		return response;
	}
	
	
		
		
		
		
		
	
	
	
	
	
	
}
