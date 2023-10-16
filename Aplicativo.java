import java.util.ArrayList;

public class Aplicativo {
    public static ArrayList<Restaurante> restaurantesCadastrados = new ArrayList<>();
    static ArrayList<Usuario> usuariosCadastrados = new ArrayList<>();
    static ArrayList<Pedido> pedidosFeitos = new ArrayList<>();
    static ArrayList<String> cache = new ArrayList<>();

    static Restaurante restaurante;

    static ArrayList<Pedido> cachePedido = new ArrayList<>();
    static Restaurante cadMenu;

    public Aplicativo() {}

    public static void cadastrarRestaurante(Restaurante restaurante){
        restaurantesCadastrados.add(restaurante);
    }

    public static void cadastrarUsuario(Usuario usuario){
        usuariosCadastrados.add(usuario);
    }

    public static void imprimirRestaurantes(){
        System.out.println(restaurantesCadastrados);
    }
}
