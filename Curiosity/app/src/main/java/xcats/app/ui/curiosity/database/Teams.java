package xcats.app.ui.curiosity.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Gabriel Trevino on 2/17/18.
 */

@Entity
public class Teams {

    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "team_num")
    public int teamNum;
}
