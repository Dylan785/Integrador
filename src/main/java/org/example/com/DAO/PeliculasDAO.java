package org.example.com.DAO;
import org.example.model.Genero;
import org.example.model.Pelicula;
import java.sql.SQLException;
import java.util.List;

public interface PeliculasDAO {

    public void RegistrarPelicula(Pelicula peliculas, Genero genero, byte[] imagen) throws Exception;
    public boolean EliminarPelicula(Pelicula peliculas) throws Exception;
    public boolean ActualizarPelicula(Pelicula peliculas) throws Exception;
    public Boolean BuscarPeliculaPorTitulo(Pelicula peliculas) throws Exception;
    public Boolean BuscarPorGenero(Genero genero, Pelicula peliculas) throws SQLException;
    public List<Pelicula> MostrarTodasPeliculas(Pelicula peliculas) throws Exception;
}
