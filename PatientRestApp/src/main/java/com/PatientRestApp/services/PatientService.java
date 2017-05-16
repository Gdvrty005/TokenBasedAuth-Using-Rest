package com.PatientRestApp.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.PatientRestApp.Dao.PatientDao;
import com.PatientRestApp.Entity.Patients;
import com.PatientRestApp.Entity.Token;
import com.google.gson.Gson;


@Path("PatientService")
public class PatientService {
	
	@Path("/patient/getpatientdetails")
	@GET
	public Response getPatientDetails(@HeaderParam("id") int id,@HeaderParam("token") String token){
		
		Response response = null;
		JSONObject request = null;
		int newId =0;
		
		List<Token> token2 = PatientDao.getByToken(token);
		
		
		if(token2 == null){
			
			return response = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid Token Id")
                    .build();
		}
		else{
			for(Token s:token2){  
				 newId = s.getId();  
				} 
			
			if(id ==newId){
				Patients patients = PatientDao.getPatientsById(id);
				 Gson gson = new Gson();
				    String jsonString = gson.toJson(patients);
				    try {
				        request = new JSONObject(jsonString);
				    } catch (JSONException e) {
				        // TODO Auto-generated catch block
				        e.printStackTrace();
				    }
				
				if(patients==null){
					return response = Response
		                    .status(Response.Status.UNAUTHORIZED)
		                    .entity("There are no details with this id")
		                    .build();
				}
				else{
					return response = Response
		                    .status(Response.Status.OK)
		                    .entity("Patients details :"+request)
		                    .build();
				}
			}else{ 
				return response =  Response
		                    .status(Response.Status.UNAUTHORIZED)
		                    .entity("Username and  token id doesn't match")
		                    .build();
		     }
			
		}
			
				
				
					
				
			
			   
		
		
	}
}
	
					
		
		
		
	



//@RequestMapping(value = "/patient/getpatientDetails", method = RequestMethod.GET)
//public ResponseEntity<?> getPatientInfo(@RequestHeader(value="userName") String userName,@RequestHeader(value="token") String tokenId){
//			
//	ResponseEntity<?> responseEntity = null; 
//	Token token = tokenRepository.findByToken(tokenId);
//	if(token==null){
//		responseEntity = new ResponseEntity<>("Invalid token id",HttpStatus.UNAUTHORIZED);
//	}else{
//		if(userName.equals(token.getUserid())){
//			PatientDetails patient = patientRepository.findByUserid(userName);
//			if(patient==null){
//				responseEntity = new ResponseEntity<>("Invalid Username", HttpStatus.UNAUTHORIZED);
//			}else{
//				responseEntity = new ResponseEntity<>(patient, HttpStatus.OK);
//			}
//		}else{
//			responseEntity = new ResponseEntity<>("Username and  token id doesn't match",HttpStatus.UNAUTHORIZED);
//		}
//	}
//	
//	return responseEntity;
//}
