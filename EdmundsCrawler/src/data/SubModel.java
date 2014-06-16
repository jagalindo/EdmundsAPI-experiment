package data;


public class SubModel {
	public SubModel(String body, String modelNanem, String niceName) {
		super();
		this.body = body;
		this.modelNanem = modelNanem;
		this.niceName = niceName;
	}
	String body;
	String modelNanem;
	String niceName;
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getModelNanem() {
		return modelNanem;
	}
	public void setModelNanem(String modelNanem) {
		this.modelNanem = modelNanem;
	}
	public String getNiceName() {
		return niceName;
	}
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}
}
