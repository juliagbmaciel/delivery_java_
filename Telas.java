import javax.swing.*;
import java.util.Objects;

public class Telas {
    ImageIcon icon;
    Janela janela;

    public Telas() {
    }

    public void paintInitialPage(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/background.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(209,51,86,410, "open_user");
        janela.paintButton(209,51,86,470, "open_rest");
        janela.setVisible(true);
    }

    public void paintCadPadaria(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundCadPadaria.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(115,35,53,430, "voltar_initial");
        janela.paintButton(115,35,210,430, "getText_cnpj_nome");
        janela.paintInput(270, 31, 55, 307);
        janela.paintInput(270, 31, 55, 370);
        janela.setVisible(true);
    }

    public void paintCadMenu(boolean isCadMenu){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundCadMenu.png")));
        this.janela = new Janela("Bakelivery", icon);

        if(isCadMenu){
            janela.paintButton(230,35,75,422, "cad_menu_rest");
        }else{
            janela.paintButton(230,35,75,422, "cad_restaurante");
        }

        janela.paintInput(270, 31, 53, 300);
        janela.paintInput(270, 31, 53, 363);
        janela.setVisible(true);
    }



    public void paintCadUsuario(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundCadUsuario.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(115,35,53,430, "voltar_initial");
        janela.paintButton(115,35,210,430, "cad_usuario");
        janela.paintInput(270, 31, 55, 307);
        janela.paintInput(270, 31, 55, 370);
        janela.setVisible(true);
    }

    public void paintChooseUser(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundChooseUser.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(115,35,60,380, "voltar_initial");
        janela.paintButton(115,35,215,380, "choose_user");
        janela.paintCombobox(true, false);
        janela.setVisible(true);
    }

    public void paintSelectRest(boolean isSeeOrder){
        if(isSeeOrder){
            this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundSeeBakeryOrder.png")));
            this.janela = new Janela("Bakelivery", icon);
            janela.paintButton(209,51,90,368, "select_bakery_order");
            janela.paintButton(40,40,18,13, "voltar_initial");

        }else{
            this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundSelectRest.png")));
            this.janela = new Janela("Bakelivery", icon);
            janela.paintButton(209,51,90,368, "select_rest");
        }
        janela.paintCombobox(false, false);
        janela.setVisible(true);
    }

    public void paintCart(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundCart.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintCombobox(false, true);
        janela.paintButton(180,48,146,687, "finish_order");
        janela.paintButton(200,48,93,370, "add_item");
        janela.setVisible(true);
    }

    public void paintCadMenuInd(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundCadMenuInd.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(209,51,90,368, "select_rest_menu");
        janela.paintCombobox(false, false);
        janela.setVisible(true);
    }

    public void paintUserOptions(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundUserOptions.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(209,51,90,410, "usuario");
        janela.paintButton(209,51,90,470, "pedido");
        janela.paintButton(40,40,18,13, "voltar_initial");
        janela.setVisible(true);
    }

    public void paintBakeryOptions(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundBakeryOptions.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(209,51,90,410, "pratos");
        janela.paintButton(209,51,90,470, "pedidos");
        janela.paintButton(209,51,90,530, "padaria");
        janela.paintButton(209,51,90,590, "remove_prato");
        janela.paintButton(40,40,18,13, "voltar_initial");
        janela.setVisible(true);
    }

    public void paintFinalCart(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundCartFinal.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(185, 50, 170, 670, "finish_all");
        janela.paintJTable(true);
        janela.setVisible(true);
    }

    public void paintOwnerOrder(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundSeeOrder.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(209,51,90,368, "select_order");
        janela.paintButton(40,40,18,13, "voltar_initial");
        janela.paintOrders();
        janela.setVisible(true);
    }

    public void paintOrderTable(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundOrderTable.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(40,40,18,13, "voltar_initial");
        janela.paintJTable(false);
        janela.setVisible(true);
    }


    public void paintNoOrder(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundNoOrder.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(40,40,18,13, "voltar_initial");
        janela.setVisible(true);
    }

    public void paintBakeryRemove(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundBakeryRemoveMenu.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintCombobox(false, false);
        janela.paintButton(209,51,90,368, "select_bakery");
        janela.setVisible(true);
    }

    public void paintMenuRemove(){
        this.icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Image/backgroundMenuRemove.png")));
        this.janela = new Janela("Bakelivery", icon);
        janela.paintButton(40,40,18,13, "voltar_initial");
        janela.paintButton(209, 51, 28, 680, "remove_dish");
        janela.paintJTableToRemove();
        janela.setVisible(true);
    }




}
