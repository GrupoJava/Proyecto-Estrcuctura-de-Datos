package org.edu.uvg.besser;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.edu.uvg.besser.controladores.Controlador;
import org.neo4j.rest.graphdb.RestAPI;
import org.neo4j.rest.graphdb.RestAPIFacade;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

import android.os.AsyncTask;

public class TaskConexion extends AsyncTask<String, String, String>{
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	
	
	@Override
	protected String doInBackground(String... consulta) {
		/**
		 * HIVE M8
		 * GET REKTD
		 * 
		 */
		/*try {
		      Class.forName(driverName);
		    } catch (ClassNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		      System.exit(1);
		    }
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:hive://ec2-52-34-60-15.us-west-2.compute.amazonaws.com:10000/default", "hive", "");
			Statement stmt = con.createStatement();
			String tableName = "estudiante";
			 String sql = "select * from " + tableName;
			 System.out.println("Running: " + sql);
			 ResultSet res = stmt.executeQuery(sql);
			 while (res.next()) {
			      System.out.println(String.valueOf(res.getString(1)) + "\t" + res.getString(2));
			 }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    */
		/**
		 * 
		 *  NEO4J
		
		 */
		
		// Make sure Neo4j Driver is registered
		RestAPI restAPI = new RestAPIFacade("http://proyectoalgoritmos.sb02.stations.graphenedb.com:24789/db/data/","proyecto_algoritmos","OuGKPY1oSluWHgoGCRhK");
		//restAPI.
		WebResource resource = Client.create().resource( "http://proyecto_algoritmos:OuGKPY1oSluWHgoGCRhK@proyectoalgoritmos.sb02.stations.graphenedb.com:24789/db/data/" );

		String payload = "{\"statements\" : [ {\"statement\" : \"" +query + "\"} ]}";
		ClientResponse response = resource
		        .accept( MediaType.APPLICATION_JSON )
		        .type( MediaType.APPLICATION_JSON )
		        .entity( payload )
		        .post( ClientResponse.class );

		System.out.println( String.format(
		        "POST [%s] to [%s], status code [%d], returned data: "
		                + System.lineSeparator() + "%s",
		        payload, txUri, response.getStatus(),
		        response.getEntity( String.class ) ) );

		response.close();
		
		
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		try{
		     HttpClient httpclient = new DefaultHttpClient();
		     HttpPost httppost = new HttpPost(consulta[0]);
		     httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		     HttpResponse response = httpclient.execute(httppost);
		     HttpEntity entity = response.getEntity();
		     Controlador.getInstancia().hacerConsulta(entity.getContent());
		     
		     }catch(Exception e){
		         System.out.println("Error");
		    }
		return null;
	}

}
