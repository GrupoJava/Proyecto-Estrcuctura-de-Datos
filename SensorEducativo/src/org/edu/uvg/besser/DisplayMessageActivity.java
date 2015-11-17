/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase DisplayMessageActivity
 */
package org.edu.uvg.besser;

import java.util.ArrayList;
import java.util.List;

import org.edu.uvg.besser.R;
import org.edu.uvg.besser.beans.Tema;
import org.edu.uvg.besser.controladores.Controlador;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Build;

public class DisplayMessageActivity extends ActionBarActivity {
	public final static String EXTRA_MESSAGE = "org.edu.uvg.besser.MESSAGE";
	Intent intencion;
	//Metodo de creacion de la ventana donde se acomodan sus componentes y se llenan las
	//listas visuales
	protected void onCreate(Bundle savedInstanceState) {
		
		intencion= new Intent(this, MostrarTema.class);
		super.onCreate(savedInstanceState);
		ListView listaTemas = new ListView(this);
		List<String> listaTemasNombres = new ArrayList<String>();
		//Se agregan los componentes a la lista
		for(String alarma :Controlador.getInstancia().getAlarmas()){
			listaTemasNombres.add(alarma);
		} 
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, 
                android.R.layout.simple_list_item_1,
                listaTemasNombres );
        listaTemas.setAdapter(arrayAdapter);
        listaTemas.setPadding(60, 80, 80, 20);
		//Se agrega el controlador del click a la lista
        //listaTemas.setOnItemClickListener(new ListenerLista());
        TextView titulo = new TextView(this);
        titulo.setText("Alarmas");
        titulo.setTextSize(14);
        titulo.setPadding(60, 40, 80, 20);
        /*TextView instrucciones = new TextView(this);
        instrucciones.setText("Seleccion el tema a ejercitar");
        instrucciones.setPadding(60, 40, 80, 0);*/
        //Se agregan todos los componenetes al contenedor principal
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);
        layout.addView(titulo);
        //layout.addView(instrucciones);
        layout.addView(listaTemas);
        setContentView(layout);
	}
	//Listener de la lista
	/*private class ListenerLista implements OnItemClickListener{
		public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) { 
        		Controlador.getInstancia().setTemaEscogido(position);
    			intencion.putExtra("org.edu.uvg.besser.MESSAGE", String.valueOf(position));
    			startActivity(intencion);
        	
        }
	}*/
	
}

