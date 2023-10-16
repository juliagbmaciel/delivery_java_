import javax.swing.*;
import java.awt.*;



public class Button extends JButton {

    String action;

    public Button(int width, int height, int x, int y, String text) {
        super();
        this.setSize(width, height);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setLocation(x, y);
        this.action = text;
    }

//    public void addEvent(Janela janela){
////        this.addActionListener(e -> {
////            if (this.action.equals("getText_cnpj_nome")) {
////                TextInput nome = janela.inputs.get(0);
////                TextInput cnpj = janela.inputs.get(1);
////                if (nome.getText().length() < 1 || cnpj.getText().length() < 1){
////                    janela.paintLabelError("Todos os campos são obrigatórios");
////                    return;
////                }
////                System.out.println("Cadaastrei novo restaurannte");
////                Aplicativo.cadastrarRestaurante(new Restaurante(nome.getText(), cnpj.getText()));
////                inputs.add(nome);
////                inputs.add(cnpj);
////
////
////                janela.dispose();
////                this.tela.paintCadMenu();
////                return;
////            }
////            if (this.action.equals("padaria")) {
////                janela.dispose();
////                this.tela.paintCadPadaria();
////            }
////            if (this.action.equals("voltar_initial")) {
////                janela.dispose();
////                this.tela.paintInitialPage();
////            }
////            if (this.action.equals("cad_restaurante")) {
////                TextInput nome = janela.inputs.get(0);
////                TextInput price = janela.inputs.get(1);
////
////                String regex = "^[0-9.]*$"; // Aceita números e um único ponto
////                Pattern pattern = Pattern.compile(regex);
////                Matcher matcher = pattern.matcher(price.getText());
////
////                if(matcher.matches()){
//////                    double newPrice = Double.parseDouble(price.getText());
//////                    Lanche lanche = new Lanche(nome.getText(), newPrice);
//////                    restaurante.adicionarLanche(lanche);
//////                    restaurante.imprimirCardapio();
////                    Aplicativo.imprimirRestaurantes();
////                }else{
////                    janela.paintLabelError("Insira um valor válido.");
////                }
////
////
////            }
////        });
//    }


}
