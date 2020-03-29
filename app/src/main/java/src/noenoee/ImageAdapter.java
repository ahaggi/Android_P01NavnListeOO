package src.noenoee;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.haji.p01_listview.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import src.liste_med_OO.DAO.Person;
import src.liste_med_OO.DAO.PersonDAOMemorySingleton;

/**
 * Created by haji on 1/17/18.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    PersonDAOMemorySingleton dao;
    List<Uri> bilder;

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
        dao = PersonDAOMemorySingleton.getInstance(mContext.getApplicationContext());
        bilder = dao.getAlleUri();
    }

    @Override
    public int getCount() {
        return bilder.size();
    }

    @Override
    public Object getItem(int position) {
        return bilder.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("Adapter***", "***********************************"+ parent.toString());
        ImageView imageView = new ImageView(mContext);
        imageView.setImageURI( bilder.get(position) );
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        return imageView;
    }

}