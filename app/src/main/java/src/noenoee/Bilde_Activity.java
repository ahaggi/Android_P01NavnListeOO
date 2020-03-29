package src.noenoee;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.haji.p01_listview.R;

import src.liste_med_OO.DAO.Person;

public class Bilde_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bildemednavn_layout);
        Bundle noe = getIntent().getExtras();
        Person person = (Person) noe.getParcelable("person");

        TextView txt = findViewById(R.id.textView);
        ImageView img = findViewById(R.id.imageView);

        txt.setText(person.getNavn());
        img.setImageURI(person.getUri());
    }
}