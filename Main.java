public class Main {
    public static void main(String[] args) {
        Telas telas = new Telas();

        Usuario julia = new Usuario("Julia", "47829927855");
        Restaurante padaria = new Restaurante("Padaria da tia", "1068642300160");
        padaria.adicionarLanche(new Lanche("Pão com ovo", 10.50));
        padaria.adicionarLanche(new Lanche("Misto quente", 10.80));
        Aplicativo.usuariosCadastrados.add(julia);
        Aplicativo.restaurantesCadastrados.add(padaria);

        telas.paintInitialPage();
    }


}