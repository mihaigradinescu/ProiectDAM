package ro.gradi.proiectv1.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "pubs")
public class BarsAroundCSIE {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "rating")
    public double rating;
    @ColumnInfo(name = "vicinity")
    public String vicinity;
    @ColumnInfo(name = "photoURL")
    public String photoURL;

    public BarsAroundCSIE() {
    }

    public BarsAroundCSIE(String name, float rating, String vicinity) {
        this.name = name;
        this.rating = rating;
        this.vicinity = vicinity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}
