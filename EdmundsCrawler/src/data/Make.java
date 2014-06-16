package data;

import java.util.Collection;

public class Make {
	public Make(Long id, String name, String niceName, Collection<Model> models) {
		super();
		this.id = id;
		this.name = name;
		this.niceName = niceName;
		this.models = models;
	}
	Long id;
	String name;
	String niceName;
	Collection<Model> models;
	
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
