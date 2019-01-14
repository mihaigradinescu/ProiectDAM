package ro.gradi.proiectv1.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PubReviewDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insert(PubReview pubReview);

    @Query("DELETE FROM pub_reviews")
    void deleteAll();

    @Query("SELECT * from pub_reviews ORDER BY timestamp DESC")
    List<PubReview> getAllPubReviews();
}
