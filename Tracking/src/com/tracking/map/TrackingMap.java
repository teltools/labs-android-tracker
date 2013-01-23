package com.tracking.map;

import java.util.LinkedList;
import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.tracking.R;
import com.tracking.model.Tracked;

public class TrackingMap extends MapActivity{

	protected MapController controller;
	List<OverlayItem> points = new LinkedList<OverlayItem>();
	MapView mapView;
	Button btRefresh;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	
		
		setContentView(R.layout.mapview);	 
		mapView = (MapView) findViewById(R.id.mapa);
		mapView.setClickable(true);
		controller = mapView.getController();
		btRefresh = (Button) findViewById(R.id.btRefresh);
		
		
		Intent i = getIntent();
		int id_user = i.getIntExtra("id_user", 0);
		int id_tracked = i.getIntExtra("id_tracked", 0);
		String name = i.getStringExtra("name");
		int time = i.getIntExtra("time", 0);
	
		Tracked tracked = new Tracked(id_user, id_tracked, name, time);
		
		Location l = new Location(ACCESSIBILITY_SERVICE);
		l.setLatitude(1E6* -14.442440);
		l.setLongitude(1E6*-60.278971);
		points.add(new OverlayItem(new Point(l.getLatitude(), l.getLongitude()), "Ponto "+(points.size()+1), "15:25"));
		
		Location l1 = new Location(ACCESSIBILITY_SERVICE);
		l1.setLatitude(1E6* -30.442440);
		l1.setLongitude(1E6*-60.278971);
		points.add(new OverlayItem(new Point(l1.getLatitude(), l1.getLongitude()), "Ponto "+(points.size()+1), "15:35"));
		
		
		btRefresh.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				refreshMap(mapView);
			}
		});
	}
	


	// This method collect the points and put them in the map
	public void refreshMap(MapView mapView){
		
		mapView.clearDisappearingChildren();
		
		// Imagem do item que ira aparecer no mapa
		Drawable image = this.getResources().getDrawable(R.drawable.mapicon);

		// TODO: Recuperar pontos no banco
		
		// Adicionar lista de imagens no mapa
		Log.i("LOG", "Numero de pontos Points: " + points.size());
		
		ImageOverlay pointsOverlay = new ImageOverlay(this, points, image);
		Log.i("LOG", "Numero de pontos: " + pointsOverlay.size());
		mapView.getOverlays().add(pointsOverlay);
		controller.setZoom(30);
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}	
	
}
