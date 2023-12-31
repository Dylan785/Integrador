PGDMP      6            	    {            TiendaPeliculas    16.0    16.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16398    TiendaPeliculas    DATABASE     �   CREATE DATABASE "TiendaPeliculas" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Colombia.1252';
 !   DROP DATABASE "TiendaPeliculas";
                postgres    false            �            1259    16399    genero    TABLE     \   CREATE TABLE public.genero (
    id bigint NOT NULL,
    name character varying NOT NULL
);
    DROP TABLE public.genero;
       public         heap    postgres    false            �            1259    16460    genero_id_seq    SEQUENCE     �   ALTER TABLE public.genero ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.genero_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            �            1259    16404    pelicula    TABLE     �   CREATE TABLE public.pelicula (
    id bigint NOT NULL,
    titulo character varying NOT NULL,
    imagen character varying NOT NULL,
    url character varying NOT NULL
);
    DROP TABLE public.pelicula;
       public         heap    postgres    false            �            1259    16461    pelicula_id_seq    SEQUENCE     �   ALTER TABLE public.pelicula ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pelicula_id_seq
    START WITH 3
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            �            1259    16444    pelicula_por_genero    TABLE     �   CREATE TABLE public.pelicula_por_genero (
    genero_id bigint NOT NULL,
    pelicula_id bigint NOT NULL,
    id bigint NOT NULL
);
 '   DROP TABLE public.pelicula_por_genero;
       public         heap    postgres    false            �            1259    16463    pelicula_por_genero_id_seq    SEQUENCE     �   ALTER TABLE public.pelicula_por_genero ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.pelicula_por_genero_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            �          0    16399    genero 
   TABLE DATA           *   COPY public.genero (id, name) FROM stdin;
    public          postgres    false    215   �       �          0    16404    pelicula 
   TABLE DATA           ;   COPY public.pelicula (id, titulo, imagen, url) FROM stdin;
    public          postgres    false    216          �          0    16444    pelicula_por_genero 
   TABLE DATA           I   COPY public.pelicula_por_genero (genero_id, pelicula_id, id) FROM stdin;
    public          postgres    false    217   �       �           0    0    genero_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.genero_id_seq', 15, true);
          public          postgres    false    218            �           0    0    pelicula_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.pelicula_id_seq', 19, true);
          public          postgres    false    219            �           0    0    pelicula_por_genero_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.pelicula_por_genero_id_seq', 17, true);
          public          postgres    false    220            %           2606    16403    genero genero_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.genero
    ADD CONSTRAINT genero_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.genero DROP CONSTRAINT genero_pkey;
       public            postgres    false    215            '           2606    16410    pelicula id 
   CONSTRAINT     I   ALTER TABLE ONLY public.pelicula
    ADD CONSTRAINT id PRIMARY KEY (id);
 5   ALTER TABLE ONLY public.pelicula DROP CONSTRAINT id;
       public            postgres    false    216            )           2606    16468 ,   pelicula_por_genero pelicula_por_genero_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.pelicula_por_genero
    ADD CONSTRAINT pelicula_por_genero_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.pelicula_por_genero DROP CONSTRAINT pelicula_por_genero_pkey;
       public            postgres    false    217            *           2606    16449     pelicula_por_genero fk_genero_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.pelicula_por_genero
    ADD CONSTRAINT fk_genero_id FOREIGN KEY (genero_id) REFERENCES public.genero(id);
 J   ALTER TABLE ONLY public.pelicula_por_genero DROP CONSTRAINT fk_genero_id;
       public          postgres    false    4645    217    215            +           2606    16454 "   pelicula_por_genero fk_pelicula_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.pelicula_por_genero
    ADD CONSTRAINT fk_pelicula_id FOREIGN KEY (pelicula_id) REFERENCES public.pelicula(id);
 L   ALTER TABLE ONLY public.pelicula_por_genero DROP CONSTRAINT fk_pelicula_id;
       public          postgres    false    4647    217    216            �   J   x�3�,I-*�/�2�L���ML����2�L�L�L`Ҧ0��acX��0���eg�Y�p�xC��1z\\\ .�      �   �   x�3����I�L�,�2�
p��Ό��+}����Ĝ���.3΀��ԤD�0��U�c��p�㗶�/m�_�Ѐ��!y#���Mț�'x��!�ז���sz�&���)p��(pZp����	Zb����� a��q      �   >   x�˱�@�X*���?�^��D�ΩT�&�~�%0�X�bM�;�	:�	��'ȱ���D
�     