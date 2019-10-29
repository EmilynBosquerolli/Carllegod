package com.example.carllegod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.carllegod.entidades.Automovel;
import com.example.carllegod.entidades.Pessoa;
import com.example.carllegod.repositorios.AutomovelRepositorio;
import com.example.carllegod.repositorios.PessoaRepositorio;
import java.util.Date;

@SpringBootApplication
public class Carllegod implements CommandLineRunner {

    @Autowired
    private PessoaRepositorio pessoas;
    @Autowired
    private AutomovelRepositorio automoveis;

    public static void main(String[] args) {
        SpringApplication.run(Carllegod.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = new Pessoa("Luis", new Date(1997, 03, 03));
        pessoas.inserir(p1);
        Pessoa p2 = new Pessoa("Callegari", new Date(1980, 05, 01));
        pessoas.inserir(p2);
        Pessoa p3 = new Pessoa("Adilson", new Date(2000, 10, 9));
        pessoas.inserir(p3);

        Automovel a1 = new Automovel("IWZ0226", "Fusca", null);
        automoveis.inserir(a1);
        Automovel a2 = new Automovel("IHF5744", "Celta", p1);
        automoveis.inserir(a2);
        Automovel a3 = new Automovel("JHG3456", "Ferrari", p2);
        automoveis.inserir(a3);
        Automovel a4 = new Automovel("GOD0001", "Model 3", p2);
        automoveis.inserir(a4);

        System.out.println("Nome das pessoas: ");
        for (Pessoa p : pessoas.consultarTodos()) {
            System.out.println(p.getNome());
        }

//        // Consultar automóvel por sua ID
        System.out.println("Consultar automovel:");
        Automovel au = automoveis.consultar(5);
        System.out.println(au.getId());
        System.out.println(au.getPlaca());
        System.out.println(au.getModelo());
        System.out.println(au.getProprietaria().getNome());

       // Consultar automóveis pela ID do proprietario
        System.out.println("Consultar automoveis:");
        for (Automovel a : automoveis.consultarPorProprietaria(2)) {
            System.out.println("[Nome: "+a.getProprietaria().getNome()+", Placa: "+a.getPlaca()+", Modelo: "+a.getModelo()+"]");
        }
    }
}



















