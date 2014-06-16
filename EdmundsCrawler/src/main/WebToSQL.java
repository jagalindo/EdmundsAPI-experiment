package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import connection.ConnectionManager;
import data.Make;
import data.Model;

public class WebToSQL {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
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
	}

}
