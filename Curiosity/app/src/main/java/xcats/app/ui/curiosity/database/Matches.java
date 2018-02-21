package xcats.app.ui.curiosity.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Gabriel Trevino on 2/20/18.
 */

@Entity
public class Matches {

    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "match_num")
    public int matchNum;

    @ColumnInfo(name = "team_num1")
    public int teamNum1;

    @ColumnInfo(name = "team_num2")
    public int teamNum2;

    @ColumnInfo(name = "team_num3")
    public int teamNum3;

    @ColumnInfo(name = "team_num4")
    public int teamNum4;

    @ColumnInfo(name = "team_num5")
    public int teamNum5;

    @ColumnInfo(name = "team_num6")
    public int teamNum6;

}
