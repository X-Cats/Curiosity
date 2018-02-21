package xcats.app.ui.curiosity.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

/**
 * Created by Gabriel Trevino on 2/20/18.
 */

@Dao
public interface MatchesDao {

    @Query("SELECT * FROM matches")
    List<Matches> getAll();

    @Insert
    void insertAll(Matches... matches);

    @Delete
    void delete(Matches matches);

}
