/**
 * Rudy Garrido 14366
 * Jackeline Juarez 14041
 * Leonel Guillen 14451
 * 
 * Proyecto Besser
 * Clase MostrarTema
 */
package org.edu.uvg.besser;

import java.util.ArrayList;
import java.util.List;

import org.edu.uvg.besser.beans.SubTema;
import org.edu.uvg.besser.controladores.Controlador;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Build;

public class MostrarTema extends ActionBarActivity {
	public final static String EXTRA_MESSAGE = "org.edu.uvg.besser.MESSAGE";
	private AlertDialog alertDialog;
	Intent intencionSalida;
	
	//Metodo para la creacion de la ventana con sus componentes
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intencion= getIntent();
		intencionSalida = new Intent(this, MostrarEjercicios.class);
		String temaIdUsuario = intencion.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE);
		//Controlador.getInstancia().cargarEjercitaciones();
		TextView titulo = new TextView(this);
		TextView instrucciones = new TextView(this);
		List<String> listaSubTemasNombres = new ArrayList<String>();
		int temaId;
		if(temaIdUsuario == null) {
			temaId = Controlador.getInstancia().getTemaEscogido();
		}else{
			temaId= Integer.parseInt(temaIdUsuario);
		}
		titulo.setText(Controlador.getInstancia().getTemas()[temaId].getTema());
		titulo.setPadding(60, 80, 80, 0);
		titulo.setTextSize(18);
		instrucciones.setText(Controlador.getInstancia().getTemas()[temaId].getExplicacion());
		instrucciones.setPadding(60, 20, 80, 0);
		for(SubTema subTema : Controlador.getInstancia().getTemas()[temaId].getSubTemas()){
			listaSubTemasNombres.add(subTema.getSubTema());
		}
        ListView listaSubTemas = new ListView(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, 
                android.R.layout.simple_list_item_1,
                listaSubTemasNombres );
        listaSubTemas.setAdapter(arrayAdapter);
        listaSubTemas.setPadding(60, 80, 80, 20);
        alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Aplicacion En Contruccion");
		alertDialog.setMessage("Lo sentimos esta aplicacion esta en contruccion.");
		alertDialog.setButton("OK", new ListenerBoton());
        listaSubTemas.setOnItemClickListener(new ListenerLista());
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(1);
		layout.addView(titulo);
		layout.addView(instrucciones);
		layout.addView(listaSubTemas);
		layout.setBackgroundColor(0x00FF00);
		setContentView(layout);
		
	}
	//Listener de la lista
	private class ListenerLista implements OnItemClickListener{
		public void onItemClick(AdapterView<?> parent, View view,int position, long id) { 
			//Controlador.getInstancia().cargarEjercicio();
        	if(Controlador.getInstancia().getTemas()[Controlador.getInstancia().getTemaEscogido()].getSubTemas()[position].getEjercicios() !=null){
            	Controlador.getInstancia().setsubTemaEscogido(position);
    			intencionSalida.putExtra("org.edu.uvg.besser.MESSAGE", String.valueOf(position));
    			startActivity(intencionSalida);
        	}else{
        		alertDialog.show();
        	}
        }
	}
	//Listener del boton de la ventana emergente
	private class ListenerBoton implements DialogInterface.OnClickListener{
		public void onClick(DialogInterface dialog, int id) {
            alertDialog.hide();
        }
	}

}
