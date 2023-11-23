# Integrador
# Proyecto de Peliculas

## Descripción
Este proyecto consiste en una aplicación que permite gestionar una base de datos de películas, incluyendo operaciones de búsqueda, adición, modificación y eliminación de registros. La aplicación está diseñada para trabajar con una base de datos PostgreSQL y ha sido desarrollada en Java.

## Funcionalidades
El proyecto incluye las siguientes funcionalidades:

- Búsqueda de películas por título.
- Búsqueda de películas por género.
- Listado de todas las películas (título y código).
- Visualización detallada de una película seleccionada.
- Registro de nuevas películas en la base de datos.

## Tecnologías Utilizadas
- Java: El lenguaje de programación principal.
- PostgreSQL: La base de datos utilizada para almacenar información sobre películas y géneros.
- JDBC: Para interactuar con la base de datos desde la aplicación Java.

## Estructura del Proyecto
La estructura del proyecto se organiza en clases y paquetes de la siguiente manera:

- Pelicula (Clase): Representa una película con propiedades como código, título, URL, imagen y géneros.
- Genero (Clase): Representa un género de película con un identificador y un nombre.
- PeliculaPorGenero (Clase): Relaciona películas con géneros en una estructura de muchos a muchos.
- PeliculaDAO (Interfaz): Define métodos para acceder a los datos de películas y géneros.
- PeliculaDAOImpl (Clase): Implementa la interfaz `PeliculaDAO` y proporciona métodos de acceso a la base de datos PostgreSQL.
- Main (Clase): Clase principal que contiene el punto de entrada de la aplicación y maneja la interacción con el usuario.

## Instrucciones de Uso
1. Configura la conexión a la base de datos PostgreSQL en `PeliculaDAOImpl` con la URL, usuario y contraseña correctos.
2. Ejecuta la aplicación Java desde la clase `Main`.
3. Sigue las instrucciones en la consola para utilizar las diferentes funcionalidades de la aplicación.

## Script SQL
El script SQL para crear la base de datos y las tablas utilizadas se encuentra en el archivo `script.sql`. Puedes utilizar este script para configurar la base de datos en un entorno PostgreSQL.

## Autor
- [Dillan Chica]

## Perfil Linkedin
https://www.linkedin.com/in/dylan-chica-808578257

## Script de la base de datos

PGDMP      6            	    {            TiendaPeliculas    16.0    16.0     Ã           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            Ä           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            Å           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            Æ           1262    16398    TiendaPeliculas    DATABASE     ‡   CREATE DATABASE "TiendaPeliculas" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Colombia.1252';
 !   DROP DATABASE "TiendaPeliculas";
                postgres    false            ×            1259    16399    genero    TABLE     \   CREATE TABLE public.genero (
    id bigint NOT NULL,
    name character varying NOT NULL
);
    DROP TABLE public.genero;
       public         heap    postgres    false            Ú            1259    16460 
   genero_id_seq    SEQUENCE     Ç   ALTER TABLE public.genero ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.genero_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            Ø            1259    16404    pelicula    TABLE     «   CREATE TABLE public.pelicula (
    id bigint NOT NULL,
    titulo character varying NOT NULL,
    imagen character varying NOT NULL,
    url character varying NOT NULL
);
    DROP TABLE public.pelicula;
       public         heap    postgres    false            Û            1259    16461    pelicula_id_seq    SEQUENCE     Ë   ALTER TABLE public.pelicula ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pelicula_id_seq
    START WITH 3
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            Ù            1259    16444    pelicula_por_genero    TABLE     „   CREATE TABLE public.pelicula_por_genero (
    genero_id bigint NOT NULL,
    pelicula_id bigint NOT NULL,
    id bigint NOT NULL
);
 '   DROP TABLE public.pelicula_por_genero;
       public         heap    postgres    false            Ü            1259    16463    pelicula_por_genero_id_seq    SEQUENCE     á   ALTER TABLE public.pelicula_por_genero ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pelicula_por_genero_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            »          0    16399    genero 
   TABLE DATA           *   COPY public.genero (id, name) FROM stdin;
    public          postgres    false    215   ³       ¼          0    16404    pelicula 
   TABLE DATA           ;   COPY public.pelicula (id, titulo, imagen, url) FROM stdin;
    public          postgres    false    216   
       ½          0    16444    pelicula_por_genero 
   TABLE DATA           I   COPY public.pelicula_por_genero (genero_id, pelicula_id, id) FROM stdin;
    public          postgres    false    217   ©       Ç           0    0 
   genero_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.genero_id_seq', 15, true);
          public          postgres    false    218            È           0    0    pelicula_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.pelicula_id_seq', 19, true);
          public          postgres    false    219            É           0    0    pelicula_por_genero_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.pelicula_por_genero_id_seq', 17, true);
          public          postgres    false    220            %           2606    16403    genero genero_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.genero
    ADD CONSTRAINT genero_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.genero DROP CONSTRAINT genero_pkey;
       public            postgres    false    215            '           2606    16410 
   pelicula id 
   CONSTRAINT     I   ALTER TABLE ONLY public.pelicula
    ADD CONSTRAINT id PRIMARY KEY (id);
 5   ALTER TABLE ONLY public.pelicula DROP CONSTRAINT id;
       public            postgres    false    216            )           2606    16468 ,   pelicula_por_genero pelicula_por_genero_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.pelicula_por_genero
    ADD CONSTRAINT pelicula_por_genero_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.pelicula_por_genero DROP CONSTRAINT pelicula_por_genero_pkey;
       public            postgres    false    217            *           2606    16449     pelicula_por_genero fk_genero_id 
   FK CONSTRAINT     ‚   ALTER TABLE ONLY public.pelicula_por_genero
    ADD CONSTRAINT fk_genero_id FOREIGN KEY (genero_id) REFERENCES public.genero(id);
 J   ALTER TABLE ONLY public.pelicula_por_genero DROP CONSTRAINT fk_genero_id;
       public          postgres    false    4645    217    215            +           2606    16454 "   pelicula_por_genero fk_pelicula_id 
   FK CONSTRAINT     ˆ   ALTER TABLE ONLY public.pelicula_por_genero
    ADD CONSTRAINT fk_pelicula_id FOREIGN KEY (pelicula_id) REFERENCES public.pelicula(id);
 L   ALTER TABLE ONLY public.pelicula_por_genero DROP CONSTRAINT fk_pelicula_id;
       public          postgres    false    4647    217    216            »   J   xœ3ä,I-*Ê/â2âLÌËÌMLÎÌÏã2æLËL³L`Ò¦0†ŒacXÀ–0†¡œegÁYÆpÜxC¸ù1z\\\ .ˆ      ¼   Œ   xœ3âÌÈÏIäLä,æ2å
páÌÎŒ’’+}ýœüäÄœŒüâ.3Î€¢ÒÔ¤DÎ0¥—Ucæ˜p™ã—¶À/m‰_ÚÐ€€¼!y#òÆäMÈ›'x†æœ!‡×–”æäszæ&¦§æ)p†ù(pZp†¸‡ 	ZbŒÑãââ a£’q      ½   >   xœË±€@ÁX*†áÌ?†^è¿äDÁÎ©TÚ&Û~Å%0§X¢b M‰;è	:è	ž 'È±ý¶°D
ú     
