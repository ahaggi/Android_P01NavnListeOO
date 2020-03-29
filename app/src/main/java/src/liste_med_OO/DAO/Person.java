package src.liste_med_OO.DAO;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.net.URI;

public class Person implements Parcelable {
   private String id;
   private String navn;
   private Uri uri;

   public Person(String i, String n, String u){
       id = i;
       navn = n;
       uri = Uri.parse(u);
   }

    protected Person(Parcel in) {
        id = in.readString();
        navn = in.readString();
        uri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    /*
       public Person(String i){
           id = i;
       }
       */
   public String getId (){return id;}

   public void setId (String i){ id = i;}

   public String getNavn (){return navn;}

   public void setNavn (String n){ navn = n;}

   public Uri getUri (){return uri;}

   public void setUri (Uri u){ uri = u;}

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(navn);
        dest.writeParcelable(uri, flags);
    }

/*
   public final boolean equals(final Object obj) {
       if (this == obj) {
           return true;
       }
       if (obj == null) {
           return false;
       }
       if (getClass() != obj.getClass()) {
           return false;
       }
       Person other = (Person) obj;
       return this.id == other.id;
   }
*/
}
