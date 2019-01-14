package ro.gradi.proiectv1.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BarsDao {

    @Insert
    void insert(BarsAroundCSIE bar);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBars(List<BarsAroundCSIE> bars);

    @Query("DELETE FROM pubs")
    void deleteAll();

    @Query("SELECT * from pubs ORDER BY name ASC")
    List<BarsAroundCSIE> getAllPubs();
}
