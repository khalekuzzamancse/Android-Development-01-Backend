package worddatabase.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insert(Word word);
    @Query("DELETE FROM WordTable")
    void deleteAll();
    @Query("SELECT * FROM WordTable ORDER BY word ASC")
    List<Word> getAllWords();
}
