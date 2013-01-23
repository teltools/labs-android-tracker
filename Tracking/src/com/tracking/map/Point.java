package com.tracking.map;

import android.location.Location;

import com.google.android.maps.GeoPoint;

public class Point extends GeoPoint{

	public Point(int latitudeE6, int longitudeE6) {
		super(latitudeE6, longitudeE6);
	}
	
	public Point(double latitude, double longitude){
		this((int) (latitude*1E6), (int)(longitude*1E6));
	}
	
	public Point(Location location){
		this(location.getLatitude(), location.getLongitude());
	}

}
