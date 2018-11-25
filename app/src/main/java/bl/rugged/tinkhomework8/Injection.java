package bl.rugged.tinkhomework8;

import android.arch.persistence.room.Room;
import android.content.Context;

public class Injection {
    private static AppRoomDatabase appRoomDatabase;

    public static AppRoomDatabase provideDatabse(Context context) {
        if (appRoomDatabase == null) {
            synchronized (AppRoomDatabase.class) {
                if (appRoomDatabase == null) {
                    appRoomDatabase = Room.inMemoryDatabaseBuilder(context, //context is ApplicationContext btw
                            AppRoomDatabase.class)//, "word_database")
                            .build();;
                }
            }
        }
        return appRoomDatabase;
    }

}
