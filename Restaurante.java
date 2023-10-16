import java.util.ArrayList;
public class Restaurante {
    String nome;
    String cnpj;
    ArrayList<Lanche> lanches = new ArrayList<>();

    ArrayList<Pedido> pedidos = new ArrayList<>();

    public Restaurante(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public void imprimirCardapio(){
        System.out.println(lanches);
    }

    public void adicionarLanche(Lanche lanche){
        lanches.add(lanche);
    }

    public void removerLanche(Lanche lanche){
        lanches.remove(lanche);
    }

    @Override
    public String toString() {
        return nome;
    }

}
