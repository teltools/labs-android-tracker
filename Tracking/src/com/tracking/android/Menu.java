package com.tracking.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Menu extends ListActivity{
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        String [] tracking = new String[] {"Rastrear","Registrar Tracked","Sair"};
	        ArrayAdapter<String> options = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tracking);
	        setListAdapter(options);
	 }
	 
	 protected void onListItemClick(ListView l, View v, int position, long id)
	 {
		 super.onListItemClick(l, v, position, id);	 
		 
		// Get parameter from Login Activity
		 Intent login_intent = getIntent();
		 int id_user = login_intent.getIntExtra("id_user", 0);
		 if(id_user == 0){
			 Log.i("LOG", "Erro: id inválido");
		 }
		 
		 switch(position) {
		 case 0:
			 //Activity Map
			 Intent trackeds = new Intent();
			 trackeds.putExtra("id_user", id_user);
			 trackeds.setAction(".android.Trackeds");
			 startActivity(trackeds); 
			 break;
		 case 1:
			 // Activity RegisterUser
			 Intent registerTime = new Intent();
			 registerTime.putExtra("id_user", id_user);
			 registerTime.setAction(".android.RegisterTime");
			 startActivity(registerTime); 
		 case 2:
			 finish(); break;
		default: finish();
			 
		 }
	 }
}
