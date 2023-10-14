package org.example;

import org.example.com.DAO.PeliculaDAOImpl;
import org.example.com.DAO.PeliculasDAO;
import org.example.connection.database.PeliculaPorGenero;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner Scanner = new Scanner(System.in);

        System.out.println("------------------------------------------------");
        System.out.println("Tienda de peliculas");
        System.out.println("------------------------------------------------");

        System.out.println("A continuacion se desplegara un menu de opciones");

        System.out.println("Presione \n 1. Buscar pelicula por titulo \n 2. Buscar pelicula por genero \n 3. Agregar una pelicula \n 4. Ver todas las peliculas ");
        int resp = Scanner.nextInt();

        switch(resp) {
            case 1:
                try {
                    PeliculasDAO peliculaDAO = new PeliculaDAOImpl();
                    Pelicula pelicula = new Pelicula();
                    pelicula.setTitulo("Prueba");


                    if (peliculaDAO.BuscarPeliculaPorTitulo(pelicula)) {
                    } else {
                        System.out.println("La película no se encontró.");
                    }
                } catch (Exception e) {
                    throw e;

                }
                break;

            case 2:
                Pelicula pelicula = new Pelicula();
                Generos generos = new Generos();
                PeliculasDAO peliculaDAO = new PeliculaDAOImpl();

                try {
                    boolean peliculaDisponible = peliculaDAO.BuscarPorGenero(generos, pelicula);
                    if (peliculaDisponible) {
                        System.out.println("Información de la película encontrada:");
                        System.out.println("Género: " + generos.getName());
                        System.out.println("Código de película: " + pelicula.getId());
                        System.out.println("Título de la película: " + pelicula.getTitulo());
                        System.out.println("URL de la película: " + pelicula.getUrl());
                        System.out.println("Imagen de la película: " + pelicula.getImagen());
                    } else {
                        System.out.println("No se encontraron películas para el género seleccionado.");
                    }
                } catch (Exception e) {
                    throw e;
                }
                break;
            case 3:  Pelicula peliculas = new Pelicula();
                peliculas.setTitulo("TEST");
                peliculas.setUrl("URL ");
                peliculas.setImagen("Imagen ");

                Generos genders = new Generos();
                genders.setName("terror");

                PeliculaPorGenero pgenero = new PeliculaPorGenero();
                pgenero.setPeliculaid(1);
                pgenero.setGeneroid(1);

                PeliculaDAOImpl peliculasDAO = new PeliculaDAOImpl();

                try {
                    peliculasDAO.RegistrarPelicula(peliculas, genders, pgenero);
                    System.out.println("Película registrada con éxito.");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Error al registrar la película.");
                }
                break;

            case 4: try {
                Pelicula pel = new Pelicula();
                PeliculasDAO peliculDAO = new PeliculaDAOImpl();
                List<Pelicula> todasPeliculas = peliculDAO.MostrarTodasPeliculas(pel);

                if (todasPeliculas.isEmpty()) {
                    System.out.println("No se encontraron películas.");
                } else {
                    System.out.println("Listado de películas:");
                    for (Pelicula pelic : todasPeliculas) {
                        System.out.println("ID: " + pelic.getId());
                        System.out.println("Título: " + pelic.getTitulo());
                        System.out.println("----");
                    }
                }
            } catch (
                    Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            break;

        }
    }
}








