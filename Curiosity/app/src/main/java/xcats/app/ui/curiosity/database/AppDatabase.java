package xcats.app.ui.curiosity.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Gabriel Trevino on 2/17/18.
 */

@Database(entities = {Events.class, Teams.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract EventsDao eventsDao();

    public abstract TeamsDao teamsDao();
}
