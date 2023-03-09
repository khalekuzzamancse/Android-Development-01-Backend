package worddatabase_using_architecture;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import worddatabase.database.Word;

@Dao
public interface WordDao2 {
    @Insert
    void insert(Word word);
    @Query("DELETE FROM WordTable")
    void deleteAll();
    @Query("SELECT * FROM WordTable ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}
