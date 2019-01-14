package ro.gradi.proiectv1.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "pub_reviews",
        foreignKeys = @ForeignKey(entity = BarsAroundCSIE.class,
                parentColumns = "name",
                childColumns = "pub_name",
                onDelete = CASCADE))
public class PubReview {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "pub_name")
    private String pubName;
    @ColumnInfo(name = "timestamp")
    private long timestamp;
    @ColumnInfo(name = "used")
    private boolean used;
    @ColumnInfo(name = "rec_option")
    private int recOption;

    public PubReview(int id, @NonNull String pubName, long timestamp, boolean used, int recOption)  {
        this.id = id;
        this.pubName = pubName;
        this.timestamp = timestamp;
        this.used = used;
        this.recOption = recOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getPubName() {
        return pubName;
    }

    public void setPubName(@NonNull String pubName) {
        this.pubName = pubName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getRecOption() {
        return recOption;
    }

    public void setRecOption(int recOption) {
        this.recOption = recOption;
    }
}
