package com.example.carllegod.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

    public Pessoa(){}

    public Pessoa(String nome, Date dtNascimento){
        this.nome = nome;
        this.dtNascimento = dtNascimento;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setIdade(Date idade) {
        this.dtNascimento = idade;
    }


}
