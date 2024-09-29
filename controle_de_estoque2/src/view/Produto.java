package view;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
	private int identificacao;

    public Produto(int identificacao, String nome, double preco, int quantidade) {
        this.identificacao = identificacao;
    	this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getIdentificacao() {
    	return identificacao;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Identificação" + identificacao + "Produto: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade;
    }
}

