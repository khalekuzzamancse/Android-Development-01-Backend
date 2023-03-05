package worddatabase.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Word.class, version = 1,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {

    private static WordDatabase instance = null;

    public static WordDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, WordDatabase.class, "wordDatabase")
                    .addCallback(callback)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            db.execSQL("INSERT INTO WordTable (word,definition) VALUES('A','Apple'),('B','Bat')");
        }

        @Override
        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
            super.onDestructiveMigration(db);
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    public abstract WordDao getWordDao();
}
