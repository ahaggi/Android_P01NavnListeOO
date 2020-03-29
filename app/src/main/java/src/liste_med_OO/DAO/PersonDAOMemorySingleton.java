package src.liste_med_OO.DAO;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by haji on 1/18/18.
 */

public class PersonDAOMemorySingleton {

    private final List<Person> personer = new ArrayList<>();
    private static final Integer FIRST_INDEX = 0;
    private Integer nesteId = FIRST_INDEX;
    private Context mContext;

    private static PersonDAOMemorySingleton instance;

    public PersonDAOMemorySingleton(Context m){
        mContext = m;
        fyllpaa_liste();
    }


    public static synchronized PersonDAOMemorySingleton getInstance(Context m) {
        if (instance == null) {
            instance = new PersonDAOMemorySingleton(m);
        }
        return instance;
    }

    public void fyllpaa_liste(){
        for(String n : new String[]{"Android", "IPhone", "WindowsMobile", "Blackberry", "Ubuntu", "Windows10"}){
            String bmpPath = "android.resource://"+ mContext.getPackageName()+"/drawable/"+"b_"+n.toLowerCase();
            personer.add(new Person (getNesteId(), n , bmpPath));
        }
    }

    public synchronized void leggTilPerson(String name, String bmpPath ){
        personer.add(new Person (getNesteId(), name , bmpPath));
    }

    public synchronized void leggTilPerson(final Person person) {
        final int index = personer.indexOf(person);
        if (index == -1) {
            personer.add(person);
        }
    }

    public List<Person> getAllePersoner() {
        return personer;
    }

    public List<String> getAlleNavnliste() {
        ArrayList<String> navnListe = new ArrayList<>();
        for (Person p: getAllePersoner()) {
            navnListe.add(p.getNavn());
        }
        return navnListe;
    }

    public List<Uri> getAlleUri() {
        ArrayList<Uri> bilder = new ArrayList<>();
        for (Person p: getAllePersoner()) {
            bilder.add(p.getUri());
        }
        return bilder;
    }


/*
    public Person finnPerson(final String id) {
        final int index = personer.indexOf(new Person(id));
        return index >= 0 ? personer.get(index) : null;
    }
*/

    public synchronized String getNesteId() {

        String n = nesteId.toString();
        nesteId++;
        return n;
    }
}


