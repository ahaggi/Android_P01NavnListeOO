package src.noenoee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.haji.p01_listview.R;

import java.util.ArrayList;

import src.liste_med_OO.DAO.Person;
import src.liste_med_OO.DAO.PersonDAOMemorySingleton;

public class AlleBilde_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allebilde_layout);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener((adapterView, view, pos, id)->{

            PersonDAOMemorySingleton dao = PersonDAOMemorySingleton.getInstance(getApplicationContext());
            ArrayList<Person> personer = (ArrayList<Person>) dao.getAllePersoner();

            Intent intent = new Intent(AlleBilde_Activity.this, Bilde_Activity.class);
            Person p =personer.get(pos);
            intent.putExtra("person" , (Parcelable) personer.get(pos));

            startActivity(intent);

        });




    }
}
