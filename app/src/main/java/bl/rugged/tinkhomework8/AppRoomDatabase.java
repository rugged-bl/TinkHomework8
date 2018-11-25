package bl.rugged.tinkhomework8;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Node.class}, version = 1)
public abstract class AppRoomDatabase extends RoomDatabase {
    public abstract NodeDao nodeDao();
}