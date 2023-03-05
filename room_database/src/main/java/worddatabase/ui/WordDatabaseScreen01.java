package worddatabase.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.util.Log;

import com.example.room_database.R;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import worddatabase.database.Word;
import worddatabase.database.WordDao;
import worddatabase.database.WordDatabase;

public class WordDatabaseScreen01 extends AppCompatActivity {
    private WordDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_database_ui01);
        database = WordDatabase.getInstance(this);
        WordDao wordDao = database.getWordDao();
        try {
            wordDao.insert(new Word("C","Cat"));
        }
        catch(SQLiteConstraintException exception){
            Log.i("InsertionFailed","The word is already exits");
        }

        List<Word> wordList = wordDao.getAllWords();
        Log.i("WordList", String.valueOf(wordList));


    }
}