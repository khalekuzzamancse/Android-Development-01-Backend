package com.example.sqlite_raw.data;

public class Word {
    public int id;
    public String word;
    public String definition;
    public Word(int id, String word, String definition) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }
}
