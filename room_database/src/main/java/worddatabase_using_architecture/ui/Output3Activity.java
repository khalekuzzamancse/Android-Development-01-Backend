package worddatabase_using_architecture.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.util.Log;

import com.example.room_database.R;

import java.util.List;

import worddatabase.database.Word;
import worddatabase_using_architecture.WordDao2;
import worddatabase_using_architecture.WordDatabase2;

public class Output3Activity extends AppCompatActivity {
    private WordDatabase2 database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_on_background_thread);
        database = WordDatabase2.getInstance(this);
        WordDao2 wordDao = database.getWordDao();
        try {
            wordDao.insert(new Word("C","Cat"));
        }
        catch(SQLiteConstraintException exception){
            Log.i("InsertionFailed","The word is already exits");
        }

        LiveData<List<Word>> wordList =wordDao.getAllWords();
        Observer<List<Word>> observer=new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                Log.i("WordListLiveData", String.valueOf(wordList.getValue()));
            }
        };
        wordList.observe(this,observer);

    }
}