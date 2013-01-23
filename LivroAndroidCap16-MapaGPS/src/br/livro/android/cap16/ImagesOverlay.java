package br.livro.android.cap16;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class ImagesOverlay extends ItemizedOverlay<OverlayItem>{
	
	private final List<OverlayItem> items;
	private final Context context;

	public ImagesOverlay(Context context, List<OverlayItem> items, Drawable drawable) {
		super(boundCenterBottom(drawable));
		this.context = context;
		this.items = items;
		this.populate();	
	}
	
	@Override
	protected OverlayItem createItem(int i) {
		return items.get(i);
	}

	@Override
	public int size() {
		return (items != null) ? items.size() : 0;
	}
	
	@Override
	protected boolean onTap(int i){
		OverlayItem item = items.get(i);
		String text = item.getTitle() + " - " + item.getSnippet();
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
		return true;
	}
	

}
