import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Janela extends JFrame{

    MainLabel label;
    Telas telas = new Telas();
    TextInput textInput;
    ArrayList<TextInput> inputs = new ArrayList<>();
    Pedido pedido = new Pedido();

    JComboBox<Usuario> comboBox;
    JComboBox<Restaurante> comboBoxRest;
    JComboBox<Lanche> comboBoxFood;
    JComboBox<Pedido> comboBoxPedido;
    JLabel cartLabel;
    JLabel textError;

    JTable menu;

    DefaultTableModel modelMenu;

    Janela(String title, ImageIcon icon){
        super(title);
        label = new MainLabel(icon);
        this.add(label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 393, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cartLabel = new JLabel("0");
        textError = new JLabel("");
    }

    public void paintButton(int width, int height, int x, int y, String text){
        Button button = new Button(width, height, x, y, text);
        button.addActionListener(e -> this.createActionListener(button));
        label.add(button);
    }

    public void paintInput(int width, int height, int x, int y){
        textInput = new TextInput(width, height, x, y);
        label.add(textInput);
        inputs.add(textInput);
    }


    public void paintLabelError(String error){
        textError.setText("" +error);
        textError.setBounds(55, 450, 300, 100);
        textError.setForeground(Color.RED);
        textError.setFont(new Font("Arial", Font.BOLD , 15));

        remove(textError);
        label.add(textError);
        label.repaint();
    }


    public void createActionListener(Button button){
        switch (button.action) {
            case "getText_cnpj_nome" -> {
                if (inputs.get(0).getText().length() < 1 || inputs.get(1).getText().length() < 1) {
                    paintLabelError("Todos os campos são obrigatórios");
                    return;
                }
                Aplicativo.cache.add(inputs.get(0).getText());
                Aplicativo.cache.add(inputs.get(1).getText());
                this.dispose();
                telas.paintCadMenu(false);
            }
            case "cad_usuario" -> cadUsuario();
            case "cad_restaurante" -> cadRestaurante();
            case "padaria" -> {
                dispose();
                telas.paintCadPadaria();
            }
            case "voltar_initial" -> {
                Aplicativo.restaurante = null;
                Aplicativo.cachePedido.clear();
                dispose();
                telas.paintInitialPage();
            }
            case "usuario" -> {
                dispose();
                telas.paintCadUsuario();
            }
            case "pedido" -> {
                dispose();
                telas.paintChooseUser();
            }
            case "choose_user" -> chooseUser();
            case "select_rest" -> selectRest();
            case "pratos" -> {
                dispose();
                telas.paintCadMenuInd();
            }
            case "select_rest_menu" -> selectRestMenu();
            case "cad_menu_rest" -> cadMenuRest();
            case "add_item" -> addItemToCart();
            case "open_user" -> {
                dispose();
                telas.paintUserOptions();
            }
            case "open_rest" -> {
                dispose();
                telas.paintBakeryOptions();
            }
            case "finish_order" -> finishOrder();
            case "finish_all" -> impressNote();
            case "pedidos" -> {
                dispose();
                telas.paintSelectRest(true);
            }
            case "select_bakery_order" -> this.chooseOrder();
            case "select_order" -> this.selectOrder();
            case "remove_prato" -> {
                dispose();
                telas.paintBakeryRemove();
            }
            case "select_bakery" -> {
                selectBakery();
                dispose();
                telas.paintMenuRemove();
            }
            case "remove_dish" -> removeDish();
        }

    }
    public void removeDish(){
        if(menu.getSelectedRow() != -1) {
            Aplicativo.restaurante.lanches.remove(menu.getSelectedRow());
            modelMenu.setRowCount(0);
            for (Lanche lanche : Aplicativo.restaurante.lanches) {
                modelMenu.addRow(new Object[]{lanche.nome, lanche.preco});
            }
        }
    }

    public void selectBakery(){
        Aplicativo.restaurante = comboBoxRest.getItemAt(comboBoxRest.getSelectedIndex());
    }

    public void cadRestaurante(){
        if (inputs.get(0).getText().length() < 1 || inputs.get(1).getText().length() < 1) {
            paintLabelError("Insira um valor válido.");
            return;
        }



        Restaurante restaurante = new Restaurante(Aplicativo.cache.get(0), Aplicativo.cache.get(1));
        TextInput nome = inputs.get(0);
        TextInput price = inputs.get(1);
        Pattern pattern = Pattern.compile("^[0-9.]*$");
        Matcher matcher = pattern.matcher(price.getText());

        if(matcher.matches()){
            double newPrice = Double.parseDouble(price.getText());
            Lanche lanche = new Lanche(nome.getText(), newPrice);
            restaurante.adicionarLanche(lanche);
            Aplicativo.cadastrarRestaurante(restaurante);
            Aplicativo.cache.clear();
            this.dispose();
            JOptionPane.showMessageDialog(this, "Restaurante cadastrado com sucesso");
            telas.paintInitialPage();
        }else{
            paintLabelError("Insira um valor válido.");
        }
    }

    public void cadUsuario(){
        if (inputs.get(0).getText().length() < 1 || inputs.get(1).getText().length() < 1) {
            paintLabelError("Insira um valor válido");
            return;
        }
        if (inputs.get(1).getText().length() < 10) {
            paintLabelError("Insira um valor válido de cpf.");
            return;
        }
        Usuario usuario = new Usuario(inputs.get(0).getText(), inputs.get(1).getText());
        Aplicativo.cadastrarUsuario(usuario);
        System.out.println(Aplicativo.usuariosCadastrados);
        dispose();
        telas.paintInitialPage();
        JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso");
    }

    public void chooseUser (){
        pedido.usuario = comboBox.getItemAt(comboBox.getSelectedIndex());
        Aplicativo.cachePedido.add(pedido);
        dispose();
        telas.paintSelectRest(false);
    }

    public void selectRest (){
        Aplicativo.cachePedido.get(0).restaurante = comboBoxRest.getItemAt(comboBoxRest.getSelectedIndex());
        Aplicativo.restaurante = comboBoxRest.getItemAt(comboBoxRest.getSelectedIndex());
        dispose();
        telas.paintCart();
    }

    public void selectRestMenu (){
        Aplicativo.cadMenu = comboBoxRest.getItemAt(comboBoxRest.getSelectedIndex());
        dispose();
        telas.paintCadMenu(true);
    }

    public void paintCombobox(Boolean isUser, Boolean isFood){
        if(isUser){
            DefaultComboBoxModel<Usuario> model = new DefaultComboBoxModel<>(Aplicativo.usuariosCadastrados.toArray(new Usuario[0]));
            comboBox = new JComboBox<>(model);
            comboBox.setBounds(82, 295, 226, 31);
            comboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
            comboBox.setVisible(true);
            label.add(comboBox);
        }else if(isFood){
            DefaultComboBoxModel<Lanche> model = new DefaultComboBoxModel<>(Aplicativo.cachePedido.get(0).restaurante.lanches.toArray(new Lanche[0]));
            comboBoxFood = new JComboBox<>(model);
            comboBoxFood.setBounds(82, 295, 226, 31);
            comboBoxFood.setBorder(null);
            comboBoxFood.setVisible(true);
            label.add(comboBoxFood);
        }else {
            DefaultComboBoxModel<Restaurante> model = new DefaultComboBoxModel<>(Aplicativo.restaurantesCadastrados.toArray(new Restaurante[0]));
            comboBoxRest = new JComboBox<>(model);
            comboBoxRest.setBounds(82, 295, 226, 31);
            comboBoxRest.setBorder(new EmptyBorder(0, 0, 0, 0));
            comboBoxRest.setVisible(true);
            label.add(comboBoxRest);
        }
    }


    public void cadMenuRest(){
        if (inputs.get(0).getText().length() < 1 || inputs.get(1).getText().length() < 1) {
            paintLabelError("Insira um valor válido.");
            return;
        }
        TextInput nome = inputs.get(0);
        TextInput price = inputs.get(1);
        Pattern pattern = Pattern.compile("^[0-9.]*$");
        Matcher matcher = pattern.matcher(price.getText());

        if(matcher.matches()){
            double newPrice = Double.parseDouble(price.getText());
            Aplicativo.cadMenu.adicionarLanche(new Lanche(nome.getText(), newPrice));
            Aplicativo.cadMenu = null;
            this.dispose();
            telas.paintInitialPage();
            JOptionPane.showMessageDialog(this, "Pratos cadastrados com sucesso");

        }else{
            paintLabelError("Insira um valor válido.");
        }

        System.out.println("Adicionado com sucesso");

    }

    public void addItemToCart(){
        Pedido pedido = Aplicativo.cachePedido.get(0);
        if(comboBoxFood.getItemAt(comboBoxFood.getSelectedIndex()) == null){
            JOptionPane.showMessageDialog(this, "Opa, o cardápio está vazio");
            dispose();
            telas.paintInitialPage();
        }
        Lanche lancheSelecionado = comboBoxFood.getItemAt(comboBoxFood.getSelectedIndex());
        pedido.lanchesSelecionados.add(lancheSelecionado);
        paintCartLenght(pedido.lanchesSelecionados.size());
    }

    public void finishOrder(){
        Aplicativo.pedidosFeitos.add(Aplicativo.cachePedido.get(0));
        Aplicativo.restaurante.pedidos.add(Aplicativo.cachePedido.get(0));
        Aplicativo.restaurante = null;
        dispose();
        telas.paintFinalCart();
    }

    public void paintJTableToRemove(){
        JPanel panel = new JPanel();
        panel.setBounds(40,200,300,400);
        panel.setLayout(new BorderLayout());
        modelMenu = new DefaultTableModel(new Object[]{"nome", "preco"},0);
        for (Lanche lanche : Aplicativo.restaurante.lanches) {
            Object[] row = {lanche.nome, lanche.preco};
            modelMenu.addRow(row);
        }
        menu = new JTable(modelMenu);
        menu.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(menu);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(scrollPane);
        panel.setVisible(true);

        label.add(panel);
    }

    public void paintJTable(boolean isSeeCart){
        JPanel panel = new JPanel();
        panel.setBounds(40,120,300,400);
        panel.setLayout(new BorderLayout());
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"nome", "preco"},0);
        Pedido pedido = Aplicativo.cachePedido.get(0);
        for (Lanche lanche : pedido.lanchesSelecionados) {
            Object[] row = {lanche.nome, lanche.preco};
            if(isSeeCart){
                pedido.total += lanche.preco;
            }
            modelo.addRow(row);
        }
        JTable tabela = new JTable(modelo);
        tabela.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(scrollPane);
        panel.setVisible(true);
        paintTotal(pedido.total);
        label.add(panel);

    }

    public void paintTotal(double total){
        String totalFormat = String.format("%.2f", total);
        JLabel totalText = new JLabel("R$ " + totalFormat);
        totalText.setBounds(105, 540, 300, 100);
        totalText.setForeground(Color.decode("#7e463e"));
        totalText.setFont(new Font("Inter", Font.PLAIN , 18));
        revalidate();
        repaint();
        label.add(totalText);
        label.repaint();
    }

    public void impressNote(){
        Aplicativo.cachePedido.get(0).imprimirNota();
        Aplicativo.cachePedido.clear();
        JOptionPane.showMessageDialog(this, "Nota impressa no terminal, volte sempre!");
        dispose();
        telas.paintInitialPage();
    }

    public void paintCartLenght(int num){
        cartLabel.setText(""+ num);
        cartLabel.setBounds(325, -35, 300, 100);
        cartLabel.setForeground(Color.decode("#7E463E"));
        cartLabel.setFont(new Font("Inter", Font.BOLD , 13));
        label.remove(cartLabel);
        label.add(cartLabel);
        label.repaint();
    }

    public void chooseOrder(){
        Aplicativo.restaurante = comboBoxRest.getItemAt(comboBoxRest.getSelectedIndex());
        dispose();
        telas.paintOwnerOrder();
    }

    public void paintOrders(){
        DefaultComboBoxModel<Pedido> model = new DefaultComboBoxModel<>(Aplicativo.restaurante.pedidos.toArray(new Pedido[0]));
        comboBoxPedido = new JComboBox<>(model);
        comboBoxPedido.setBounds(82, 295, 226, 31);
        comboBoxPedido.setBorder(new EmptyBorder(0, 0, 0, 0));
        comboBoxPedido.setVisible(true);
        label.add(comboBoxPedido);
    }


    public void selectOrder(){
        if(comboBoxPedido.getItemAt(comboBoxPedido.getSelectedIndex()) == null){
            dispose();
            telas.paintNoOrder();
        }else{
            Aplicativo.cachePedido.clear();
            Aplicativo.cachePedido.add(comboBoxPedido.getItemAt(comboBoxPedido.getSelectedIndex()));
            JOptionPane.showMessageDialog(this,"Usuario: " + Aplicativo.cachePedido.get(0).usuario.nome + " \nCPF do usuário: "
            + Aplicativo.cachePedido.get(0).usuario.cpf);
            dispose();
            telas.paintOrderTable();
        }
    }




}
