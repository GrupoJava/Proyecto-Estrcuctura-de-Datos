package org.edu.uvg.besser;

import java.util.ArrayList;
import java.util.List;

import org.edu.uvg.besser.EditarTema.PlaceholderFragment;
import org.edu.uvg.besser.beans.Tema;
import org.edu.uvg.besser.controladores.Controlador;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Build;

public class EditarTema extends ActionBarActivity {
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_tema);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		//Controlador.getInstancia().cargarTemas();
		List<String> listaTemasN = new ArrayList<String>();
		listaTemasN.add("Esta tema no tiene ejercitaciones. Agregue nuevos");
		if(Controlador.getInstancia().getTemas() != null){
			listaTemasN.clear();
			for(Tema tema : Controlador.getInstancia().getTemas()){
				listaTemasN.add(tema.getTema());
			}	
		}
		ListView listaTemas = (ListView) findViewById(R.id.editarTemasLista);
		System.out.println((ListView) findViewById(R.id.editarTemasLista));
		listaTemas.setOnItemClickListener(new ListenerLista());
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, 
                R.layout.fuentedicion,
                listaTemasN );
		listaTemas.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged(); 
	}
	private class ListenerLista implements OnItemClickListener{
		

		public void onItemClick(AdapterView<?> adapterView, View view,int position, long id) { 
			for (int j = 0; j < adapterView.getChildCount(); j++)
                adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);
            view.setBackgroundColor(Color.LTGRAY);
            Controlador.getInstancia().setTemaEscogido(position);
        }
	}
	public void agregar(View view){
		
		//Controlador.getInstancia().agregarTema(((TextView) findViewById(R.id.nombreTemaEditar)).getText().toString(), ((TextView)findViewById(R.id.descripcionTemaEditar)).getText().toString());
		//Controlador.getInstancia().cargarTemas();
		List<String> listaTemasN = new ArrayList<String>();
		listaTemasN.add("Esta tema no tiene ejercitaciones. Agregue nuevos");
		if(Controlador.getInstancia().getTemas() != null){
			listaTemasN.clear();
			for(Tema tema : Controlador.getInstancia().getTemas()){
				listaTemasN.add(tema.getTema());
			}	
		}
		ListView listaTemas = (ListView) findViewById(R.id.editarTemasLista);
		listaTemas.setOnItemClickListener(new ListenerLista());
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, 
                R.layout.fuentedicion,
                listaTemasN );
		listaTemas.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged(); 
	}
	
	public void eliminar(View view){
		//Controlador.getInstancia().cargarTemas();
		//Controlador.getInstancia().eliminarTema();
		List<String> listaTemasN = new ArrayList<String>();
		listaTemasN.add("Esta tema no tiene ejercitaciones. Agregue nuevos");
		if(Controlador.getInstancia().getTemas()!= null){
			listaTemasN.clear();
			for(Tema tema : Controlador.getInstancia().getTemas()){
				listaTemasN.add(tema.getTema());
			}	
		}
		ListView listaTemas = (ListView) findViewById(R.id.editarTemasLista);
		listaTemas.setOnItemClickListener(new ListenerLista());
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, 
                R.layout.fuentedicion,
                listaTemasN );
		listaTemas.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();  
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.editar_ejercitacion, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_editar_ejercitacion, container, false);
			return rootView;
		}
	}


}
