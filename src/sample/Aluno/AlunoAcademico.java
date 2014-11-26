package sample.Aluno;

import java.io.Serializable;
import java.util.Objects;


public class AlunoAcademico implements Serializable {

    private String Id;
    private String Nome;
    private String Email;
    private String Endereco;
    private String Cpf;
    private String Sexo;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public AlunoAcademico(String id, String nome, String email, String endereco, String cpf, String sexo) {
        Id = id;
        Nome = nome;
        Email = email;
        Endereco = endereco;
        Cpf = cpf;
        Sexo = sexo;
    }

    public AlunoAcademico () {

    }
}
