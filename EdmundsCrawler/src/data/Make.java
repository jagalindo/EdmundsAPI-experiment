package data;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.simple.JSONObject;

@Entity
@Table(name = "MAKES")
public class Make {

	@Id
	Long id;

	String name;
	String niceName;
	@OneToMany
	Collection<Model> models;

	public Make() {}

	public Make(Long id, String name, String niceName, Collection<Model> models) {
		super();
		this.id = id;
		this.name = name;
		this.niceName = niceName;
		this.models = models;
	}

	public Make(JSONObject object) {
		// this parsing is intended for the get all makes in edmunds
		this.id = (Long) object.get("id");
		this.name = (String) object.get("name");
		this.niceName = (String) object.get("niceName");
		this.models = new LinkedList<>();
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

	public String getNiceName() {
		return niceName;
	}

	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}

	public Collection<Model> getModels() {
		return models;
	}

	public void setModels(Collection<Model> models) {
		this.models = models;
	}
}
