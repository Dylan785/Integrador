package org.example.com.DAO;

import org.example.Generos;
import org.example.Pelicula;
import org.example.connection.database.PeliculaPorGenero;


import java.sql.SQLException;
import java.util.List;

public interface PeliculasDAO {

    public void RegistrarPelicula(Pelicula peliculas, Generos generos, PeliculaPorGenero pgenero) throws Exception;
    public void EliminarPelicula(Pelicula peliculas) throws Exception;
    public void ActualizarPelicula(Pelicula peliculas) throws Exception;
    public Boolean BuscarPeliculaPorTitulo(Pelicula peliculas) throws Exception;

    public Boolean BuscarPorGenero(Generos generos, Pelicula peliculas) throws SQLException;

    public List<Pelicula> MostrarTodasPeliculas(Pelicula peliculas) throws Exception;



}
