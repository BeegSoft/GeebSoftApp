package com.tecnologiasintech.geebsoftapp.MaestroPerfil.Recycler.DataModel;

/**
 * Created by Sergio on 1/17/2017.
 */

public class MaestroComentario {

    MaestroComentario(){}

    private String Comentario_titulo ;
    private String Comentario_cuerpo;
    private int comentario_rating;

    public MaestroComentario(String comentario_titulo, String comentario_cuerpo, int comentario_rating) {
        Comentario_titulo = comentario_titulo;
        Comentario_cuerpo = comentario_cuerpo;
        this.comentario_rating = comentario_rating;
    }

    public String getComentario_titulo() {
        return Comentario_titulo;
    }

    public void setComentario_titulo(String comentario_titulo) {
        Comentario_titulo = comentario_titulo;
    }

    public String getComentario_cuerpo() {
        return Comentario_cuerpo;
    }

    public void setComentario_cuerpo(String comentario_cuerpo) {
        Comentario_cuerpo = comentario_cuerpo;
    }

    public int getComentario_ranking() {
        return comentario_rating;
    }

    public void setComentario_rating(int comentario_) {
        this.comentario_rating = comentario_;
    }
}