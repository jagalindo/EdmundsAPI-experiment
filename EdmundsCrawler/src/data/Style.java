package data;

public class Style {
	public Style(Long id, String name, SubModel submodel, String trim) {
		super();
		this.id = id;
		this.name = name;
		this.submodel = submodel;
		this.trim = trim;
	}
	Long id;
	String name;
	SubModel submodel;
	String trim;
	
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
