package estoque;

public class Produto {
    private String nome;
    private double preco;
    private int qtd_estoque;
    private double valor_estoque;

    public Produto (String nome, double preco, int qtd_estoque) {
        this.nome = nome;
        this.preco = preco;
        this.qtd_estoque = qtd_estoque;
        this.valor_estoque = qtd_estoque*preco;
    }

    public String getNome () {
        return this.nome;
    }

    public void aumentaEstoque (int valor) {
        this.qtd_estoque += valor;
        this.valor_estoque += (valor*this.preco);
    }

    public void diminuiEstoque (int valor) {
        if (this.qtd_estoque < valor) {
            System.out.println("Quantidade indisponível");
        } else {
            this.qtd_estoque -= valor;
            this.valor_estoque -= (valor*preco);
        }
    }

    public void exibirProduto () {
        System.out.println(this.nome);
        System.out.println("Preço unitário: R$ " + this.preco);
        System.out.println("Quantidade em estoque: " + this.qtd_estoque);
        System.out.println("Valor total em estoque: R$ " + this.valor_estoque);
    }
}
