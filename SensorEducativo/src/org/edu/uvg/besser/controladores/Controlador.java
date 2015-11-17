/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase Controlador
 */
package org.edu.uvg.besser.controladores;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.edu.uvg.besser.TaskConexion;
import org.edu.uvg.besser.beans.Alumno;
import org.edu.uvg.besser.beans.Ejercicio;
import org.edu.uvg.besser.beans.Profesor;
import org.edu.uvg.besser.beans.Respuesta;
import org.edu.uvg.besser.beans.SubTema;
import org.edu.uvg.besser.beans.Tema;
import org.edu.uvg.besser.beans.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import android.util.Log;
import android.widget.Toast;

public class Controlador {
	//Atributos
	private static Controlador instancia = null;
	private Tema[] temas;
	private Usuario[] usuarios;
	private String[] alarmas;
	
	
	private int idUsuario;
	private int temaEscogido;
	private int subTemaEscogido;
	private int tiempoSeleccionado;
	private int diaProblematico;
	private int horaProblematica;
	
	JSONArray jArray = null;
	String result = null;
	StringBuilder sb = null;
	InputStream is = null;

	//Arquitectura de programacion de singletone
	public static synchronized Controlador getInstancia(){
		if(instancia == null){
			instancia = new Controlador();
		}
		
		return instancia;
	}
	public String[] getAlarmas() {
		return alarmas;
	}
	public void setAlarmas(String[] alarmas) {
		this.alarmas = alarmas;
	}
	public int getDiaProblematico() {
		return diaProblematico;
	}
	public void setDiaProblematico(int diaProblematico) {
		this.diaProblematico = diaProblematico;
	}
	public int getHoraProblematica() {
		return horaProblematica;
	}
	public void setHoraProblematica(int horaProblematica) {
		this.horaProblematica = horaProblematica;
	}
	public int getTiempoSeleccionado() {
		return tiempoSeleccionado;
	}
	public void setTiempoSeleccionado(int tiempoSeleccionado) {
		this.tiempoSeleccionado = tiempoSeleccionado;
	}
	//Getters y setters
	private Controlador(){
		
	}
	
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	public int getsubTemaEscogido() {
		return subTemaEscogido;
	}

	public void setsubTemaEscogido(int subTemaEscogido) {
		this.subTemaEscogido = subTemaEscogido;
	}

	public int getTemaEscogido() {
		return temaEscogido;
	}

	public void setTemaEscogido(int temaEscogido) {
		this.temaEscogido = temaEscogido;
	}

	public Tema[] getTemas() {
		return temas;
	}

	public void setTemas(Tema[] temas) {
		this.temas = temas;
	}

	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int buscarEstudiante(int estudiante) {
		try{
			String[] consulta = {"http://http://sensoreducativo.vacau.com/busquedaEstudiante.php?estudiante="+estudiante};
			try {
				new TaskConexion().execute(consulta).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			jArray = new JSONArray(result);
			idUsuario = jArray.getJSONObject(0).getInt("carne");
			return 1;	
		}catch(Exception e){
			return 0;
		}
		
	}
	public void cargarAlarmas() {
		try{
			ArrayList<Integer> dias = new ArrayList<Integer>(); 
			ArrayList<Integer> horas = new ArrayList<Integer>();
			String[] consulta = {"http://sensoreducativo.vacau.com/busquedaAlarmas.php?estudiante="+idUsuario};
			try {
				new TaskConexion().execute(consulta).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			jArray = new JSONArray(result);
			alarmas = new String[jArray.length()];
			JSONObject json_data=null;
			String linea = null;
			for(int i=0;i<jArray.length();i++){
			//Sunday =1
				json_data = jArray.getJSONObject(i);
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date date;
				int hora=0;
				try {
					date = sdf.parse(json_data.getString("hora"));
					Calendar calendar = GregorianCalendar.getInstance();
					calendar.setTime(date);
					hora=calendar.get(Calendar.HOUR);
					horas.add(hora);
					linea = hora+":"+calendar.get(Calendar.MINUTE)+" ";
					sdf = new SimpleDateFormat("yyyy-MM-dd");
					date = sdf.parse(json_data.getString("fecha"));
					calendar = Calendar.getInstance();
					calendar.setTime(date);
					int dia =calendar.get(Calendar.DAY_OF_WEEK);
					dias.add(dia);
					switch(dia){
						case 1:
							linea = "Domingo "+linea;
							break;
						case 2:
							linea = "Lunes "+linea;
							break;
						case 3:
							linea = "Martes"+linea;
							break;
						case 4:
							linea = "Miercoles "+linea;
							break;
						case 5:
							linea = "Jueves "+linea;
							break;
						case 6:
							linea = "Viernes "+linea;
							break;
						case 7:
							linea = "Sabado "+linea;
							break;
					}
					linea = linea+date;
					alarmas[i]=linea;
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			int repeticiones =0;
			for(int i=0;i<=23;i++){
				if(repeticiones<Collections.frequency(horas, i)){
					horaProblematica=i;
					repeticiones=Collections.frequency(horas, i);
				}
			}
			repeticiones=0;
			for(int i=1;i<=7;i++){
				if(repeticiones<Collections.frequency(dias, i)){
					diaProblematico=i;
					repeticiones=Collections.frequency(horas, i);
				}
			}
		 } catch (JSONException e) {
				e.printStackTrace();
		}
	}
	public void hacerConsulta(InputStream input){
		is = input;
		//convert response to string
		try{
		      BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
		       sb = new StringBuilder();
		       sb.append(reader.readLine() + "\n");
		       String line="0";
		       while ((line = reader.readLine()) != null) {
		                      sb.append(line + "\n");
		        }
		        is.close();
		        result=sb.toString();
		        }catch(Exception e){
		              Log.e("log_tag", "Error converting result "+e.toString());
		        }
	}
	
	public int gettemaEscogido() {
		return temaEscogido;
	}
	public void settemaEscogido(int temaEscogido) {
		this.temaEscogido = temaEscogido;
	}
	
	
}
