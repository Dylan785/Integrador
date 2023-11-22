package org.example.model;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {



    private String titulo;
    private int id;
    private byte [] imagen;
    private String url;

    private List<Genero> genero;





    public Pelicula() {

        genero = new ArrayList<>();
    }

    public Pelicula(String titulo, int id, byte [] imagen, String url, String peliculas, List<Genero> generos) {
        this.titulo = titulo;
        this.id = id;
        this.imagen = imagen;
        this.url = url;

    }

    public List<Genero> getGenero() {
        return genero;
    }

    public void setGenero(List<Genero> genero) {
        this.genero = genero;
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte [] imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public static class ImageDisplayFrame extends JFrame {
        public ImageDisplayFrame(BufferedImage image) {
            JLabel label = new JLabel(new ImageIcon(image));
            getContentPane().add(label);
            pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }


}


