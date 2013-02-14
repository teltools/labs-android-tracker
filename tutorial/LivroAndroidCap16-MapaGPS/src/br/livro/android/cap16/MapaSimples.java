package br.livro.android.cap16;

import java.util.ArrayList;
import java.util.List;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class MapaSimples extends MapActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.mapview);
		MapView mapView = (MapView) findViewById(R.id.mapa);
		mapView.setClickable(true);
		mapView.displayZoomControls(true);

		// Imagem do item que ira aparecer no mapa
		Drawable image = this.getResources().getDrawable(R.drawable.mapicon);

		List<OverlayItem> points = new ArrayList<OverlayItem>();
		points.add(new OverlayItem(new GeoPoint(-25443195, -49280977), "Ponto "
				+ (points.size() + 1), "15:30"));
		points.add(new OverlayItem(new GeoPoint(-45442770, -80279830), "Ponto "
				+ (points.size() + 1), "15:40"));

		// Adicionar lista de imagens no mapa
		ImagesOverlay pointsOverlay = new ImagesOverlay(this, points, image);
		mapView.getOverlays().add(pointsOverlay);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
