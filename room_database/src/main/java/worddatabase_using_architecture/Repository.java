package worddatabase_using_architecture;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import worddatabase.database.Word;

public class Repository {
    private WordDatabase2 database;
    private LiveData<List<Word>> wordList;

    public  Repository(WordDatabase2 database)
    {
        this.database=database;
        wordList=database.getWordDao().getAllWords();
    }

    public LiveData<List<Word>> getWordList() {
        return wordList;
    }
    public void insertWord(Word word){
        WordDao2 dao= database.getWordDao();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    dao.insert(word);
                }
                catch (Exception e){
                    Log.i("Insertion","Failed,the word is already exits");
                }
            }
        });



    }
}
