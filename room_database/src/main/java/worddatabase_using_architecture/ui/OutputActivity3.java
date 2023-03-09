package worddatabase_using_architecture.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.example.room_database.R;

import java.util.List;

import worddatabase.database.Word;
import worddatabase_using_architecture.Repository;
import worddatabase_using_architecture.WordDatabase2;

public class OutputActivity3 extends AppCompatActivity {
    private WordDatabase2 database;
    private Repository repository;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_activity_3);
        database = WordDatabase2.getInstance(this);
        repository = new Repository(database);
        LiveData<List<Word>> wordList = repository.getWordList();
        Observer<List<Word>> observer = new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                Log.i("WordListLiveData", String.valueOf(wordList.getValue()));
            }
        };
        wordList.observe(this, observer);

    }
}