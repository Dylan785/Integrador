package org.example.model;
import org.example.com.DAO.PeliculaDAOImpl;
import org.example.com.DAO.PeliculasDAO;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("------------------------------------------------");
            System.out.println("Tienda de peliculas");
            System.out.println("------------------------------------------------");
            System.out.println("A continuacion se desplegara un menu de opciones");
            System.out.println("Presione \n 1. Buscar pelicula por titulo \n 2. Buscar pelicula por genero \n 3. Agregar una pelicula \n 4. Ver todas las peliculas \n 5. Eliminar una pelicula \n 6. Actualizar una pelicula \n 7. Si desea finalizar el programa");
            int resp = scanner.nextInt();
            switch (resp) {
                case 1:
                    try {
                        PeliculasDAO peliculaDAO = new PeliculaDAOImpl();
                        Pelicula pelicula = new Pelicula();
                        System.out.println("Escriba el nombre de la pelicula a buscar: ");
                        String resp1 = scanner.next();
                        pelicula.setTitulo(resp1);
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
                    Genero genero = new Genero();
                    PeliculasDAO peliculaDAO = new PeliculaDAOImpl();
                    try {
                        boolean peliculaDisponible = peliculaDAO.BuscarPorGenero(genero, pelicula);
                        if (peliculaDisponible) {
                            System.out.println("Información de la película encontrada:");
                            System.out.println("Género: " + genero.getName());
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
                case 3:
                    Genero gender = new Genero();
                    Pelicula peliculas = new Pelicula();
                    System.out.println("Cual es el nombre de la película?");
                    String titulo = scanner.next();
                    scanner.nextLine();
                    peliculas.setTitulo(titulo);
                    System.out.println("Cual es la URL de la película?");
                    String url = scanner.next();
                    peliculas.setUrl(url);
                    System.out.println("Cual es el género principal de la película?");
                    String gend = scanner.next();
                    gender.setName(gend);
                    List<Genero> generos = new ArrayList<>();
                    generos.add(gender);
                    PeliculaDAOImpl peliculasDAO = new PeliculaDAOImpl();

                    boolean next = true;
                    while (next) {
                        try {
                            System.out.println("Cual es la ubicación local de la imagen de la película?");
                            String imagePath = scanner.next();
                            System.out.println("Ubicación de la imagen: " + imagePath);
                            File imageFile = new File(imagePath);

                            if (!imageFile.exists() || imageFile.isDirectory()) {
                                System.out.println("La ubicación del archivo de imagen no es válida.");
                                next = true;
                            } else {
                                byte[] imagen = Files.readAllBytes(imageFile.toPath());
                                peliculas.setImagen(imagen);


                                peliculasDAO.RegistrarPelicula(peliculas, gender, imagen);

                                System.out.println("Imagen registrada con éxito.");
                                next = false;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.err.println("Error al leer la imagen desde la ubicación local.");
                        }
                    }
                    break;
                case 4:
                    try {
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
                case 5:
                    try {
                        Pelicula pel = new Pelicula();
                        PeliculasDAO peliculDAO = new PeliculaDAOImpl();
                        System.out.println("Escriba el nombre de la pelicula a Eliminar");
                        String resp2 = scanner.next();
                        pel.setTitulo(resp2);
                        boolean eliminada = peliculDAO.EliminarPelicula(pel);
                        if (eliminada) {
                            System.out.println("La pelicula fue eliminada con exito");
                        } else {
                            System.out.println("Error: La pelicula no pudo ser eliminada con exito");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    Pelicula pel = new Pelicula();
                    PeliculasDAO peldao = new PeliculaDAOImpl();
                    try {
                        System.out.println("Escriba el ID de la pelicula que desea modificar");
                        int resps = scanner.nextInt();
                        pel.setId(resps);
                        System.out.println("Escriba el nuevo titulo para la pelicula");
                        String resp2 = scanner.next();
                        pel.setTitulo(resp2);
                        boolean eliminada = peldao.ActualizarPelicula(pel);
                        if (eliminada) {
                            System.out.println("La pelicula fue modificada con exito");
                        } else {
                            System.out.println("Error: La pelicula no pudo ser modificada con exito");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 7:
                    continuar = false;
                    break;
            }
        }
    }
}