public class Lanche {
    String nome;
    double preco;

    public Lanche(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return
                nome  +
                " - R$: " + preco
                ;
    }
}
