package br.com.coutsoft.babywords.model;

import java.time.LocalDate;

public class Word {
    private String wordName;
    private LocalDate date;

    public Word(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
