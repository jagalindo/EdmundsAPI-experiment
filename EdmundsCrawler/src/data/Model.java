package data;

import java.util.Collection;

public class Model {
	public Model(String id, String name, String niceName, Collection<Year> years) {
		super();
		this.id = id;
		this.name = name;
		this.niceName = niceName;
		this.years = years;
	}
	String id;
	String name;
	String niceName;
	Collection<Year> years;
	
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
