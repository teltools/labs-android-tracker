package com.tracking.android;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tracking.model.Tracked;

public class Trackeds extends ListActivity {

	ArrayList<Tracked> trackedsByUser;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Parameter from activity Menu
		Intent menu = getIntent();
		int id_user = menu.getIntExtra("id_user", 0);

		// TODO: Get a list of trackers from id_user
		// Test
		Tracked artur = new Tracked(id_user, 10, "Artur Tavares", 20);
		Tracked pedro = new Tracked(id_user, 15, "Pedro Rodrigues", 30);

		trackedsByUser = new ArrayList<Tracked>(2);
		trackedsByUser.add(artur);
		trackedsByUser.add(pedro);
		//

		String[] list = new String[trackedsByUser.size()];
		for (int i = 0; i < trackedsByUser.size(); i++) {
			list[i] = trackedsByUser.get(i).getName();
		}

		ArrayAdapter<String> trackers_list = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		setListAdapter(trackers_list);
	}

	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Tracked tracked = trackedsByUser.get(position);

		Intent map = new Intent();
		map.putExtra("id_user", tracked.getId_user());
		map.putExtra("id_tracked", tracked.getId_tracked());
		map.putExtra("name", tracked.getName());
		map.putExtra("time", tracked.getTime());
		map.setAction(".map.TrackingMap");

		startActivity(map);
	}
}
