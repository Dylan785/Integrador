package org.example;

import java.util.ArrayList;
import java.util.List;

public class Generos {

    private String name;

    private int id;

    public Generos() {
    }
    public Generos(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
