package ro.gradi.bere;

public class BarsAroundCSIE {
    public String name;
    public double rating;
    public String vicinity;
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
