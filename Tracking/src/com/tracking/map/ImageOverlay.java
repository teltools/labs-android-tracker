package com.tracking.map;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class ImageOverlay extends ItemizedOverlay<OverlayItem>{
	
	private final List<OverlayItem> items;
	private final Context context;

	public ImageOverlay(Context context, List<OverlayItem> items, Drawable drawable) {
		super(drawable);
		this.context = context;
		this.items = items;
		boundCenterBottom(drawable);
		this.populate();	
	}
	
	protected OverlayItem createItem(int i) {
		return items.get(i);
	}

	@Override
	public int size() {
		return items.size();
	}
	
	protected boolean onTap(int i){
		OverlayItem item = items.get(i);
		String text = item.getTitle() + " - " + item.getSnippet();
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
		return true;
	}

}
