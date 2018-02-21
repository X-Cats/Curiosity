package xcats.app.ui.curiosity.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

/**
 * Created by Gabriel Trevino on 2/17/18.
 */

@Dao
public interface EventsDao {

    @Query("SELECT * FROM events")
    List<Events> getAll();

    @Insert
    void insertAll(Events... events);

    @Delete
    void delete(Events events);

}
