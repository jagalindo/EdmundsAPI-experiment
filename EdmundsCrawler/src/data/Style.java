package data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.json.simple.JSONObject;

@Entity
@Table(name = "STYLES")
public class Style {
	@Id
	Long id;
	String name;
	@OneToOne(cascade = CascadeType.PERSIST)
	SubModel submodel;
	String trim;

	public Style() {};

	public Style(Long id, String name, SubModel submodel, String trim) {
		super();
		this.id = id;
		this.name = name;
		this.submodel = submodel;
		this.trim = trim;
	}

	public Style(JSONObject styleObject) {
		super();
		this.id = (Long) styleObject.get("id");
		this.name = (String) styleObject.get("name");
		this.submodel = new SubModel(
				(String) ((JSONObject) styleObject.get("submodel")).get("body"),
				(String) ((JSONObject) styleObject.get("submodel"))
						.get("modelName"), (String) ((JSONObject) styleObject
						.get("submodel")).get("niceName"));
		this.trim = (String) styleObject.get("trim");
		;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SubModel getSubmodel() {
		return submodel;
	}

	public void setSubmodel(SubModel submodel) {
		this.submodel = submodel;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}
}
