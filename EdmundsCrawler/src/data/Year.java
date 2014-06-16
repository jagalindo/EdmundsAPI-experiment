package data;

import java.util.Collection;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Year {

	Long id;
	Long year;
	Collection<Style> styles;
	
	public Year(Long id, Long year, Collection<Style> styles) {
		super();
		this.id = id;
		this.year = year;
		this.styles = styles;
	}
	
	public Year(JSONObject yearobj) {
		super();
		this.id=(Long) yearobj.get("id");
		this.year=(Long) yearobj.get("year");
		this.styles= new LinkedList<Style>();
		JSONArray stylesJson=(JSONArray) yearobj.get("styles");
		for(Object styleObject:stylesJson){
			this.styles.add(new Style((JSONObject)styleObject));
		}
	}


	
}
