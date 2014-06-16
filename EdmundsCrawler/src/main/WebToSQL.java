package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import connection.ConnectionManager;
import data.Make;
import data.Model;

public class WebToSQL {

	private static final String PERSISTENCE_UNIT_NAME = "EdmundsCrawler";
    private static EntityManagerFactory factory;
	
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		
		//Persistence Stuff
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
       
		
		
		ConnectionManager manager = ConnectionManager.getInstance();
		JSONArray arrayJson = manager.getArrayJson("makes");
		
		//Get all makes
		Collection<Make> makes= new LinkedList<>();
		for(Object o:arrayJson){
			makes.add(new Make((JSONObject) o));
		}
		
		//getall vehicle data
		for(Make m:makes){
			JSONArray models = manager.getArrayJson(m.getNiceName(),"models");
			for(Object mo:models){
				m.getModels().add(new Model((JSONObject)mo));
			}
		}
		
	    em.getTransaction().begin();
	    em.persist(makes);
	    em.getTransaction().commit();
	    em.close();
	}

}
