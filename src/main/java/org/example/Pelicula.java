package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {



    private String titulo;
    private int id;
    private String imagen;
    private String url;



    public Pelicula() {
    }

    public Pelicula(String titulo, int id, String imagen, String url, String peliculas) {
        this.titulo = titulo;
        this.id = id;
        this.imagen = imagen;
        this.url = url;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}


