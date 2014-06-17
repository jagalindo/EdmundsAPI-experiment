package data;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Entity
@Table(name = "YEARS")
public class Year {
	@Id
	Long id;
	Long year;
	@OneToMany(cascade = CascadeType.PERSIST)
	Collection<Style> styles;

	public Year() {}

	public Year(Long id, Long year, Collection<Style> styles) {
		super();
		this.id = id;
		this.year = year;
		this.styles = styles;
	}

	public Year(JSONObject yearobj) {
		super();
		this.id = (Long) yearobj.get("id");
		this.year = (Long) yearobj.get("year");
		this.styles = new LinkedList<Style>();
		JSONArray stylesJson = (JSONArray) yearobj.get("styles");
		for (Object styleObject : stylesJson) {
			this.styles.add(new Style((JSONObject) styleObject));
		}
	}

}
