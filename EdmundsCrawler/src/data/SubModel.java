package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBMODEL")
public class SubModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String niceName;

	String body;
	String modelNanem;

	public SubModel() {};

	public SubModel(String body, String modelNanem, String niceName) {
		super();
		this.body = body;
		this.modelNanem = modelNanem;
		this.niceName = niceName;
	}

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
