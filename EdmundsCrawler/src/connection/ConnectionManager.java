package connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ConnectionManager {

	private static ConnectionManager conn=null;
	private static String baseURL="https://api.edmunds.com/api/vehicle/v2/";
	private static String key="?fmt=json&api_key=tkupetpgargcqgfdr48p99x2";
	private static Long lastConnection=System.currentTimeMillis();
	private static Properties p= new Properties();
	
	private ConnectionManager(){}
	
	public static ConnectionManager getInstance(){
		if(conn==null){
			conn = new ConnectionManager();
			lastConnection=System.currentTimeMillis();
			try {
				p.load(new FileInputStream(new File("./conf/urls.conf")));
			} catch (IOException e) {
				System.err.println("The file ./conf/urls.conf does not exits... and it's a magical file.");
				e.printStackTrace();
			}
			

		}
		return conn;
	}
	
	public JSONObject getData(String partialURL) throws IOException, InterruptedException{
		//This is a small timeout to not get banned
		if(System.currentTimeMillis()-lastConnection<2000){
			Thread.sleep(4000);
			lastConnection=System.currentTimeMillis();
		}
		String url=baseURL+partialURL+key;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", "MOZILLA");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		JSONObject parse = (JSONObject) JSONValue.parse(in);
		return parse;
	}
	
	public JSONArray getArrayJson(String query) throws FileNotFoundException, IOException, InterruptedException{
		String partialURL = (String) p.get(query);
		JSONObject data = getData(partialURL);
		return (JSONArray) data.get(query);
	}

	public JSONArray getArrayJson(String niceName, String query) throws IOException, InterruptedException {
		
		String partialURL = (String) p.get(query);
		JSONObject data = getData(niceName+"/"+partialURL);
		return (JSONArray) data.get(query);
		
		
	}
	
	
}
