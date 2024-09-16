package view;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class Sistema {
    private Map<String, Usuario> usuarios;
    private ArrayList<Produto> produtos;
    private Usuario usuarioLogado;

    public Sistema() {
        usuarios = new HashMap<>();
        produtos = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getUsername(), usuario);
    }

    public boolean autenticar(String username, String senha) {
        Usuario usuario = usuarios.get(username);
        if (usuario != null) {
            if (usuario.autenticar(senha)) {
                setUsuarioLogado(usuario);
                return true;
            }
        }
        return false;
    }

    public boolean cadastrarUsuario(String username, String senha) {
        if (usuarios.containsKey(username)) {
            return false; // Usuário já existe
        }
        adicionarUsuario(new Usuario(username, senha));
        return true;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public String consultarProdutos() {
        if (produtos.isEmpty()) {
            return "Nenhum produto cadastrado.";
        }
        StringBuilder sb = new StringBuilder();
        for (Produto p : produtos) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}

