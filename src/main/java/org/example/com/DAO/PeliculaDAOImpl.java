package org.example.com.DAO;

import org.example.Generos;
import org.example.Pelicula;

import org.example.connection.database.PeliculaPorGenero;
import org.example.connection.database.PostgresqlConexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeliculaDAOImpl extends PostgresqlConexion implements PeliculasDAO {


    Scanner Scanner = new Scanner(System.in);


    @Override
    public void RegistrarPelicula(Pelicula peliculas, Generos generos, PeliculaPorGenero pgenero) throws Exception {
        try {
            this.connect();
            PreparedStatement pst = this.connection.prepareStatement(
                    "INSERT INTO pelicula(titulo, url, imagen) VALUES (?, ?, ?) RETURNING id"
            );
            pst.setString(1, peliculas.getTitulo());
            pst.setString(2, peliculas.getUrl());
            pst.setString(3, peliculas.getImagen());
            ResultSet rs = pst.executeQuery();

            int peliculaId;
            if (rs.next()) {
                peliculaId = rs.getInt(1);
            } else {
                throw new Exception("Error al insertar la película.");
            }

            PreparedStatement genero = this.connection.prepareStatement(
                    "INSERT INTO genero (name) VALUES (?) RETURNING id"
            );
            genero.setString(1, generos.getName());
            ResultSet generoResultSet = genero.executeQuery();

            int generoId;
            if (generoResultSet.next()) {
                generoId = generoResultSet.getInt(1);
            } else {
                throw new Exception("Error al insertar el género.");
            }
            PreparedStatement PGenero = this.connection.prepareStatement(
                    "INSERT INTO pelicula_por_genero (pelicula_id, genero_id) VALUES (?, ?)"
            );
            PGenero.setInt(1, peliculaId);
            PGenero.setInt(2, generoId);
            PGenero.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }


    @Override
    public void EliminarPelicula(Pelicula pelicula) throws Exception {
        try {
            this.connect();
            PreparedStatement pst = this.connection.prepareStatement("DELETE FROM pelicula WHERE titulo = ?");
            pst.setString(1, pelicula.getTitulo());
            pst.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public void ActualizarPelicula(Pelicula peliculas) throws Exception {
        try {
            this.connect();
            PreparedStatement pst = this.connection.prepareStatement("UPDATE pelicula set titulo = ? WHERE id = ?");
            pst.setString(1, peliculas.getTitulo());
            pst.setInt(2, peliculas.getId());
            pst.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public Boolean BuscarPeliculaPorTitulo(Pelicula peliculas) throws Exception {
        boolean peliculaDisponible = false;
        try {
            this.connect();
            PreparedStatement pst = this.connection.prepareStatement("SELECT titulo, id, url, imagen FROM pelicula WHERE titulo = ?");
            pst.setString(1, peliculas.getTitulo());


            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                peliculaDisponible = true;
                peliculas.setId(rs.getInt("id"));
                peliculas.setUrl(rs.getString("url"));
                peliculas.setImagen(rs.getString("imagen"));
                peliculas.setTitulo(rs.getString("titulo"));
                System.out.println("codigo: " + peliculas.getId());
                System.out.println("La película '" + peliculas.getTitulo() + "' está disponible.");
                System.out.println("imagen: " + peliculas.getImagen());
                System.out.println("url: " + peliculas.getUrl());
            } else{
                System.out.println("La película '" + peliculas.getTitulo() + "' NO está disponible.");

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        return peliculaDisponible;
    }

    @Override
    public Boolean BuscarPorGenero(Generos generos, Pelicula peliculas) throws SQLException {
        boolean peliculaDisponible = false;
        System.out.println("1.Terror\n2.Ficcion\n3.Animacion ");
        int gen = Scanner.nextInt();

        try {
            this.connect();
            String resp = null;
            switch (gen) {
                case 1: resp = "terror";
                    break;
                case 2: resp = "ficcion";
                    break;
                case 3: resp = "animacion";
                    break;
            }

            PreparedStatement pst = this.connection.prepareStatement(
                    "SELECT p.id, p.titulo, p.url, p.imagen, g.name " +
                            "FROM pelicula p " +
                            "INNER JOIN pelicula_por_genero pg ON p.id = pg.pelicula_id " +
                            "INNER JOIN genero g ON pg.genero_id = g.id " +
                            "WHERE g.name = ?");
            pst.setString(1, resp);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                peliculaDisponible = true;
                generos.setName(rs.getString("name"));
                peliculas.setId(rs.getInt("id"));
                peliculas.setUrl(rs.getString("url"));
                peliculas.setImagen(rs.getString("imagen"));
                peliculas.setTitulo(rs.getString("titulo"));
                System.out.println("Género: " + generos.getName());
                System.out.println("codigo: " + peliculas.getId());
                System.out.println("url: " + peliculas.getUrl());
                System.out.println("imagen: " + peliculas.getImagen());
                System.out.println("La película '" + peliculas.getTitulo() + "' está disponible.");


            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
        return peliculaDisponible;
    }

    @Override
    public List<Pelicula> MostrarTodasPeliculas(Pelicula peliculas) throws Exception {
        List<Pelicula> lista = new ArrayList<>();

        try {
            this.connect();
            PreparedStatement pst = this.connection.prepareStatement("SELECT p.id, p.titulo, p.url, p.imagen, g.name" +
                    " FROM pelicula p " +
                    " INNER JOIN pelicula_por_genero pg ON p.id = pg.pelicula_id " +
                    " INNER JOIN genero g ON pg.genero_id = g.id; ");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Pelicula p = new Pelicula();
                p.setTitulo(rs.getString("titulo"));
                p.setId(rs.getInt("id"));
                lista.add(p);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }

        return lista;
    }

    }








