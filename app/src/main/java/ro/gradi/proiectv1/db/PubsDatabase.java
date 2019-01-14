package ro.gradi.proiectv1.db;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import androidx.annotation.NonNull;

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */

@Database(entities = {PubReview.class, BarsAroundCSIE.class}, version = 4)
public abstract class PubsDatabase extends RoomDatabase {

    public abstract PubReviewDao reviewsDao();
    public abstract BarsDao barsDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile PubsDatabase INSTANCE;

    public static PubsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PubsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PubsDatabase.class, "word_database")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
