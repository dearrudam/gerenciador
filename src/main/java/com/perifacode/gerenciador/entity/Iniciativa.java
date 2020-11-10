package com.perifacode.gerenciador.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Iniciativa extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;

    @ManyToOne
    private TipoIniciativa tipoIniciativa;

    @OneToMany
    private List<Membro> responsaveis;

    private boolean ativo;

    public Iniciativa() {
    }

    public Iniciativa(String titulo, TipoIniciativa tipoIniciativa, List<Membro> responsaveis, boolean ativo) {
        this.titulo = titulo;
        this.tipoIniciativa = tipoIniciativa;
        this.responsaveis = responsaveis;
        this.ativo = ativo;
    }

    public static Iniciativa construirNovaIniciativa(String titulo, TipoIniciativa tipoIniciativa,
                                                     List<Membro> responsaveis) {
        return new Iniciativa(titulo, tipoIniciativa, responsaveis, true);
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public TipoIniciativa getTipoIniciativa() {
        return tipoIniciativa;
    }

    public List<Membro> getResponsaveis() {
        return responsaveis;
    }
}
