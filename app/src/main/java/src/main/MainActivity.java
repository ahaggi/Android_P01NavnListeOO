    package src.main;

    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.ListAdapter;
    import android.widget.ListView;

    import src.noenoee.AlleBilde_Activity;
    import src.noenoee.ListeMedNavn_Activity;
    import com.example.haji.p01_listview.R;
    import java.util.HashMap;

    public class MainActivity extends AppCompatActivity {
        HashMap<String, Intent> actions = new HashMap<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_layout);

            prepareMenu();


            /*
            * Map som inneholder
            *   -keys String "action-navn"
            *   -Intent med passende Klasse/Aktivity
            *
            * Adapter inneholder String Keys
            *
            * ListView
            *
            * */
            String[] keys = actions.keySet().toArray(new String[actions.keySet().size()]);

            ListAdapter adapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_1, keys);

            ListView lstVw = findViewById(R.id.activities_list);
            lstVw.setAdapter(adapter);

            lstVw.setOnItemClickListener(
                    (AdapterView<?> adapterView, View view, int i, long l)->{
                        String key = (String) adapterView.getItemAtPosition(i);
                        startActivity((Intent) actions.get(key));
                    }
            );

        }

        void prepareMenu() {
            actions.put("ListeMedNavn",  new Intent(this, ListeMedNavn_Activity.class));
            actions.put("AlleBilde",  new Intent(this, AlleBilde_Activity.class));

             /*
             actions.put("Indicators", IndicatorsActivity.class);
             actions.put("Containers", ContainersActivity.class);
             actions.put("Text Display", TextDisplayActivity.class);
             actions.put("Events", EventsActivity.class);
             actions.put("Video", VideoViewActivity.class);
             */
        }

    }