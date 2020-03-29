package src.noenoee;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.haji.p01_listview.R;

import java.util.ArrayList;

import src.liste_med_OO.DAO.Person;
import src.liste_med_OO.DAO.PersonDAOMemorySingleton;

public class ListeMedNavn_Activity extends AppCompatActivity {
    ArrayList<Person> personer = new ArrayList<>();
    ArrayList<String> navnListe = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listemednavn_layout);

        fyllpaa_array();


        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1, navnListe);
        /** eller kan vi definere vårt eget list_item som innholder kun en "textView"
         * og kalle den med (R.layout.list_item) UTEN ANDROID
         *  Se android.R.layout.simple_list_item_1*/

        ListView listView = findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

                listView.setOnItemClickListener(
                        (AdapterView<?> adapterView, View view, int i, long l)->{

                            Intent intent = new Intent(ListeMedNavn_Activity.this, Bilde_Activity.class);
                            intent.putExtra("person" , (Parcelable) personer.get(i));
                            startActivity(intent); });

    }

public void fyllpaa_array(){
    PersonDAOMemorySingleton dao = PersonDAOMemorySingleton.getInstance(getApplicationContext());
    personer = (ArrayList<Person>) dao.getAllePersoner();
    navnListe = (ArrayList<String>) dao.getAlleNavnliste();
}



}