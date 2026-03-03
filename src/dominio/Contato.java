package dominio;

import teste.AgendaTeste01;

public class Contato {
    private String nome;
    private String numero;
    private String email;

    public Contato(String nome, String numero, String email) {
        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome inválido!");
        }
        if (!AgendaTeste01.validarEmail(email)){
            throw new IllegalArgumentException("Email inválido");
        }
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("""
                Nome: %s
                Número: %s
                Email: %s
                """, nome, numero, email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}