package engine.pp.healthmonitor;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;


@Database(entities = { memJoy.class }, version = 1)
public abstract class memDatabase extends RoomDatabase {

    public abstract memDao getmemDao();

    private static memDatabase noteDB;

    public static memDatabase getInstance(Context context) {
        if (null == noteDB) {
            noteDB = buildDatabaseInstance(context);
        }
        return noteDB;
    }

    private static memDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                        memDatabase.class,
                        "FreeCodeTube")
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        noteDB = null;
    }

}
