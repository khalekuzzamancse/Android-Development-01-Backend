package worddatabase_using_architecture;

import android.app.Application;
import android.provider.ContactsContract;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import worddatabase.database.Word;

public class WordViewModel extends AndroidViewModel {
    private Repository repository;
    private WordDatabase2 database;
    private LiveData<List<Word>> allWords;

    public WordViewModel(Application application) {
        super(application);
        database = WordDatabase2.getInstance(application);
        repository = new Repository(database);
    }

    public LiveData<List<Word>> getAllWords() {
        return repository.getWordList();
    }

    public void insert(Word word) {
        repository.insertWord(word);
    }
}
