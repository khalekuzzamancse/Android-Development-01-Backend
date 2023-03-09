package worddatabase_using_architecture.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.room_database.R;

import java.util.List;

import worddatabase.database.Word;
import worddatabase_using_architecture.WordViewModel;

public class OutputActivity4 extends AppCompatActivity {
    private WordViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_output4);
        viewModel = new ViewModelProvider(this).get(WordViewModel.class);
        LiveData<List<Word>> wordList = viewModel.getAllWords();
        Observer<List<Word>> observer = new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                Log.i("WordListLiveData", String.valueOf(wordList.getValue()));
            }
        };
        wordList.observe(this, observer);

    }
}