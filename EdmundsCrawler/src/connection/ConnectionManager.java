package connection;

import org.json.simple.JSONObject;

public class ConnectionManager {

	private ConnectionManager conn=null;
	
	private ConnectionManager(){}
	
	public ConnectionManager getInstance(){
		if(conn==null){
			conn = new ConnectionManager();
		}
		return conn;
	}
	
	public JSONObject getData(String url){
		return null;
	}
}
