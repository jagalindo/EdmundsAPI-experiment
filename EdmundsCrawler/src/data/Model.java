package data;

import java.util.Collection;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Model {
	String id;
	String name;
	String niceName;
	Collection<Year> years;
	
	public Model(String id, String name, String niceName, Collection<Year> years) {
		super();
		this.id = id;
		this.name = name;
		this.niceName = niceName;
		this.years = years;
	}
	public Model(JSONObject mo) {
		super();
		this.id=(String) mo.get("id");
		this.name=(String) mo.get("name");
		this.niceName=(String) mo.get("niceName");
		this.years=new LinkedList<Year>();
		JSONArray yearsJson=(JSONArray) mo.get("years");
		for(Object yearobj:yearsJson){
			years.add(new Year((JSONObject)yearobj));
		}
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNiceName() {
		return niceName;
	}
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}
	public Collection<Year> getYears() {
		return years;
	}
	public void setYears(Collection<Year> years) {
		this.years = years;
	}

}
