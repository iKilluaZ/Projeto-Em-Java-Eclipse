package view;

public class Usuario {
    private String username;
    private String senha;

    public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}

