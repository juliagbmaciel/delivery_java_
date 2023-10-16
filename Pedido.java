import java.util.ArrayList;

public class Pedido {
    Restaurante restaurante;
    Usuario usuario;
    ArrayList<Lanche> lanchesSelecionados = new ArrayList<>();
    double total = 0;

    @Override
    public String toString() {
        return this.usuario.nome;
    }

    public void imprimirNota() {
        System.out.println("NOTA FISCAL BAKELIVERY:");
        for(Lanche lanche : lanchesSelecionados){
            System.out.println("| " + lanche.nome + " | R$ " + lanche.preco + " |");
        }
        String totalFormat = String.format("%.2f", total);
        System.out.println("Total da compra: R$ " + totalFormat);
    }

}
