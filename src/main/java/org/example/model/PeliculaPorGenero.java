package org.example.model;

public class PeliculaPorGenero {

    private int generoid;
    private int peliculaid;

    private int id;

    public PeliculaPorGenero() {
    }

    public PeliculaPorGenero(int generoid, int peliculaid, int id) {
        this.generoid = generoid;
        this.peliculaid = peliculaid;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneroid() {
        return generoid;
    }

    public void setGeneroid(int generoid) {
        this.generoid = generoid;
    }

    public int getPeliculaid() {
        return peliculaid;
    }

    public void setPeliculaid(int peliculaid) {
        this.peliculaid = peliculaid;
    }
}