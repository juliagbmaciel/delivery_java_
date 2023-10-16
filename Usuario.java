public class Usuario {
    String nome;
//    String endereco;
    String cpf;

    @Override
    public String toString() {
        return nome;
    }

    public Usuario(String nome, String cpf) {
        this.nome = nome;
//        this.endereco = endereco;
        this.cpf = cpf;
    }
}
