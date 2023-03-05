package worddatabase.database;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "WordTable")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(typeAffinity = ColumnInfo.TEXT,collate = ColumnInfo.NOCASE)
    public String word;
    @ColumnInfo(typeAffinity = ColumnInfo.TEXT,collate = ColumnInfo.NOCASE)
    public String definition;
    public Word(@NonNull String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    @NonNull
    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
