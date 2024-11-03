package br.com.fiap.main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Contato;
import br.com.fiap.beans.Funcionarios;
import br.com.fiap.beans.Mecanica;
import br.com.fiap.beans.PcdOuIdoso;
import br.com.fiap.beans.PecaMecanica;
import br.com.fiap.beans.Registro;
import br.com.fiap.beans.Veiculo;
import br.com.fiap.dao.InicializadorDAO;
import br.com.fiap.model.Endereco;
import br.com.fiap.service.ViaCepService;

public class Inicializador {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws IOException {

        // String
        String nome = null;
        String bairro = null, cidade = null, estado = null;
        String telefone = "333 76786", site = "https://www.portoseguro.com.br/consulta-de-clientes/fale-conosco";
        String modelo = null, marca = null;
        String nomepeça = null;
        String tipo = null;
        String cep = null;

        // Int
        int codigofnc = 0;
        int codigouser = 0;
        int qtd = 100;
        int resultado;

        // Boolean
        Boolean idoso = null;
        Boolean pcd = null;

        // Padrões para validação de entrada
        Pattern senhaPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$");
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9]+([._%+-][a-zA-Z0-9]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,}){1,2}$");
        Pattern cepPattern = Pattern.compile("^\\d{5}-?\\d{3}$");
        
        // Classes
        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        PcdOuIdoso pid = new PcdOuIdoso();
        pid.setIdoso(idoso);
        pid.setPcd(pcd);

        Endereco endereço = new Endereco();
        endereço.setBairro(bairro);
        endereço.setCidade(cidade);
        endereço.setEstado(estado);

        Contato contato = new Contato();
        contato.setTelefoneEmpresa(telefone);
        contato.setSite(site);

        Funcionarios fnc = new Funcionarios();
        fnc.setCódigo_funcionario(codigofnc);
        fnc.setNome_funcionario(nome);

        Mecanica meca = new Mecanica();
        meca.setCep(cep);
        meca.setBairro(bairro);
        meca.setCidade(cidade);
        meca.setEstado(estado);

        Registro registro = new Registro();
        registro.setCódigo(codigouser);

        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);

        PecaMecanica peça = new PecaMecanica();
        peça.setNome(nomepeça);
        peça.setTipo(tipo);
        peça.setQuantidade(qtd);

        ViaCepService viaCep = new ViaCepService();
        
        JTextField fieldNome = new JTextField(5);
        JTextField fieldEmail = new JTextField(5);
        JTextField fieldCep = new JTextField(5);
        JPasswordField fieldSenha = new JPasswordField(5);
        JPasswordField fieldConfirmaSenha = new JPasswordField(5);
        
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

        // Tela Inicial
        
        JFrame frame = new JFrame("AS - Confirmação de necessidades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setResizable(false);
        
        Image icon = ImageIO.read(new File("img\\Wheel.png"));
        frame.setIconImage(icon);

        JPanel myPanel1 = new JPanel();
        myPanel1.setLayout(new BoxLayout(myPanel1, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(myPanel1);
        scrollPane.setPreferredSize(new Dimension(380, 280));
        
        frame.setLocationRelativeTo(null);
        frame.add(scrollPane);
        
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JFrame menuFrame = new JFrame("AS - Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(400, 300);
        menuFrame.setResizable(false);

        menuFrame.setIconImage(icon);

        menuFrame.setLocationRelativeTo(null);
        menuFrame.add(menuPanel);

        // Tela de Registro

        JFrame regFrame = new JFrame("AS - Registro");
        regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regFrame.setSize(500, 300);
        regFrame.setResizable(false);

        regFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;

        Font font = new Font("Arial", Font.PLAIN, 16);
        Font boldFont = new Font("Arial", Font.BOLD, 16); // Fonte em negrito

        JTextField marcaField = new JTextField(25);
        marcaField.setFont(font);
        JTextField modeloField = new JTextField(25);
        modeloField.setFont(font);
        JTextField placaField = new JTextField(25);
        placaField.setFont(font);

        JPanel regPanel = new JPanel();
        regPanel.setLayout(new BoxLayout(regPanel, BoxLayout.Y_AXIS));

        JLabel marcaLabel = new JLabel("Marca:");
        marcaLabel.setFont(font);
        marcaLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        marcaField.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        marcaField.setMaximumSize(marcaField.getPreferredSize());

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setFont(font);
        modeloLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        modeloField.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        modeloField.setMaximumSize(modeloField.getPreferredSize());

        JLabel placaLabel = new JLabel("Placa:");
        placaLabel.setFont(font);
        placaLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        placaField.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        placaField.setMaximumSize(placaField.getPreferredSize());

        regPanel.add(marcaLabel);
        regPanel.add(marcaField);
        regPanel.add(Box.createVerticalStrut(15));

        regPanel.add(modeloLabel);
        regPanel.add(modeloField);
        regPanel.add(Box.createVerticalStrut(15));

        regPanel.add(placaLabel);
        regPanel.add(placaField);

        JButton botaoRegistro = new JButton("ENVIAR");
        botaoRegistro.setPreferredSize(new Dimension(250, 50));
        botaoRegistro.setFont(boldFont);
        botaoRegistro.setAlignmentX(JButton.CENTER_ALIGNMENT);

        regPanel.add(Box.createVerticalStrut(25)); 
        regPanel.add(botaoRegistro);

        regFrame.add(regPanel, gbc);
        regFrame.setLocationRelativeTo(null);
        
        try {
            while (true) {
                myPanel.removeAll();
                myPanel.add(new JLabel("Bem-vindo ao serviço da AutoScan! Por favor, realize o cadastro para prosseguir."));
                myPanel.add(Box.createVerticalStrut(20)); // Espaçador
                myPanel.add(new JLabel("Digite Seu Nome:"));
                myPanel.add(fieldNome);
                myPanel.add(Box.createVerticalStrut(15)); // Espaçador
                myPanel.add(new JLabel("Digite Seu Email:"));
                myPanel.add(fieldEmail);
                myPanel.add(Box.createVerticalStrut(15)); // Espaçador
                myPanel.add(new JLabel("Digite Seu CEP:"));
                myPanel.add(fieldCep);
                myPanel.add(Box.createVerticalStrut(15)); // Espaçador
                myPanel.add(new JLabel("Digite Sua Senha:"));
                myPanel.add(fieldSenha);
                myPanel.add(Box.createVerticalStrut(15)); // Espaçador
                myPanel.add(new JLabel("Confirme Sua Senha:"));
                myPanel.add(fieldConfirmaSenha);

                resultado = JOptionPane.showConfirmDialog(null, myPanel, "AutoScan - Cadastro", JOptionPane.OK_CANCEL_OPTION);

                if (resultado == JOptionPane.OK_OPTION) {
                    String inputNome = fieldNome.getText().trim();
                    String inputEmail = fieldEmail.getText().trim();
                    String inputCep = fieldCep.getText().trim();
                    String inputSenha = new String(fieldSenha.getPassword()).trim();
                    String inputConfirmaSenha = new String(fieldConfirmaSenha.getPassword()).trim();

                    // Validação
                    Matcher emailMatcher = emailPattern.matcher(inputEmail);
                    Matcher senhaMatcher = senhaPattern.matcher(inputSenha);
                    Matcher cepMatcher = cepPattern.matcher(inputCep);

                    if (inputNome.isEmpty() || inputEmail.isEmpty() || inputCep.isEmpty() || inputSenha.isEmpty() || inputConfirmaSenha.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "AVISO", JOptionPane.WARNING_MESSAGE);
                    } else if (!cepMatcher.matches()) {
                        JOptionPane.showMessageDialog(null, "CEP inválido! Formato esperado: 00000-000 ou 00000000", "AVISO", JOptionPane.WARNING_MESSAGE);
                    } else if (!emailMatcher.matches()) {
                        JOptionPane.showMessageDialog(null, "Email inválido!", "AVISO", JOptionPane.WARNING_MESSAGE);
                    } else if (!senhaMatcher.matches()) {
                        JOptionPane.showMessageDialog(null, "Senha inválida!\n"
                                + "\nMínimo 1 letra maiúscula e minúscula"
                                + "\nMínimo 1 número"
                                + "\nMínimo 1 caractere especial"
                                + "\nMínimo 8 caracteres.", "AVISO", JOptionPane.WARNING_MESSAGE);
                    } else if (!inputSenha.equals(inputConfirmaSenha)) {
                        JOptionPane.showMessageDialog(null, "As senhas não correspondem!", "AVISO", JOptionPane.WARNING_MESSAGE);
                    } else {

                        cliente.setNome(inputNome);
                        cliente.setEmail(inputEmail);
                        cliente.setCep(inputCep);
                        cliente.setSenha(inputSenha);

                        frame.setVisible(true);
                        JLabel titulo = new JLabel("Informe sobre suas necessidades abaixo: ");
                        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
                        myPanel1.add(titulo);
                        JCheckBox idosoCheckBox = new JCheckBox("Idoso (60+)");
                        idosoCheckBox.setBorder(BorderFactory.createEmptyBorder(35, 0, 25, 0));
                        myPanel1.add(idosoCheckBox);
                        JCheckBox pcdCheckBox = new JCheckBox("PcD (Pessoa com Deficiência)");
                        pcdCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 35, 0));
                        myPanel1.add(pcdCheckBox);
                        JPanel buttonPanel = new JPanel();
                        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                        JButton continuarButton = new JButton("Continuar");
                        buttonPanel.add(continuarButton);
                        myPanel1.add(buttonPanel);                                          
                        myPanel1.revalidate();
                        
                        continuarButton.addActionListener(e -> {
                            InicializadorDAO dao = null;
                            try {
                                dao = new InicializadorDAO();
                            } catch (ClassNotFoundException | SQLException e1) {
                                e1.printStackTrace();
                            }

                            pid.setIdoso(idosoCheckBox.isSelected());
                            pid.setPcd(pcdCheckBox.isSelected());

                            try {
								System.out.println(dao.inserirCadastro(cliente, pid) + "\n"
										+ viaCep.getEndereco(inputCep));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                            
                            frame.dispose();

                            JLabel menutitulo = new JLabel("Auto Scan", JLabel.CENTER);
                            menutitulo.setFont(new Font("Arial", Font.BOLD, 24));
                            menutitulo.setBorder(BorderFactory.createEmptyBorder(20, 48, 0, 0));
                            menuPanel.add(menutitulo);

                            JPanel buttonMenuPanel = new JPanel(new GridBagLayout());
                            GridBagConstraints gbc2 = new GridBagConstraints();
                            gbc2.fill = GridBagConstraints.HORIZONTAL;
                            gbc2.insets = new java.awt.Insets(5, 5, 5, 5);

                            Dimension buttonSize = new Dimension(130, 30);

                            JButton butaoRegistro = new JButton("Registro");
                            butaoRegistro.setPreferredSize(buttonSize);
                            butaoRegistro.addActionListener(btregistro -> {
                                regFrame.setVisible(true);
                            });

                            botaoRegistro.addActionListener(e3 -> {
                                String marca2 = marcaField.getText().trim();
                                String modelo2 = modeloField.getText().trim();
                                String placa = placaField.getText().trim();

                                if (marca2.isEmpty() || modelo2.isEmpty() || placa.isEmpty()) {
                                    JOptionPane.showMessageDialog(regFrame, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }

                                String regexPlaca = "^[A-Z]{3}[0-9][A-Z][0-9]{2}$"; // Exemplo de regex para placas no formato ABC1D23
                                Pattern pattern = Pattern.compile(regexPlaca);
                                if (!pattern.matcher(placa).matches()) {
                                    JOptionPane.showMessageDialog(regFrame, "A placa deve estar no formato ABC1D23.", "Erro", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }

                                veiculo.setMarca(marca2);
                                veiculo.setModelo(modelo2);
                                veiculo.setPlaca(placa);

                                InicializadorDAO dao2 = null;
                                try {
                                    dao2 = new InicializadorDAO();

                                    if (dao2.inserirRegistro(veiculo) != null) {
                                        JOptionPane.showMessageDialog(null, "Registro entregue aos serviços da AutoScan!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Falha ao registrar o veículo.", "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (ClassNotFoundException | SQLException e2) {
                                    e2.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e2.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                } finally {
                                    regFrame.dispose();
                                }
                            });
                            
                            
                                         
                            JButton botaoPecas = new JButton("Peças");
                            botaoPecas.setPreferredSize(buttonSize);
                            botaoPecas.addActionListener(btpecas -> {
                            	peça.escolha(qtd);								
                            });
                            
                            JButton suporte = new JButton("Suporte");
                            suporte.setPreferredSize(buttonSize);                           
                            suporte.addActionListener(ajuda -> {
                            	JOptionPane.showMessageDialog(null, "Telefone: " + telefone + "\nSite: " + site, "Suporte", JOptionPane.INFORMATION_MESSAGE);
                            });
                            
                            JButton sair = new JButton("Saída");
                            sair.setPreferredSize(buttonSize);
                            sair.addActionListener(saida -> {
                            	JOptionPane.showMessageDialog(null, "Obrigado por usar o programa!");
                            	System.exit(0);
                            });

                            gbc.gridx = 0;
                            gbc.gridy = 0;
                            buttonMenuPanel.add(butaoRegistro, gbc);

                            gbc.gridy = 1;
                            buttonMenuPanel.add(botaoPecas, gbc);

                            gbc.gridy = 2;
                            buttonMenuPanel.add(suporte, gbc);

                            gbc.gridy = 3;
                            buttonMenuPanel.add(sair, gbc);

                            menuPanel.add(buttonMenuPanel);
                            menuPanel.revalidate();
                            menuFrame.setVisible(true);
                        });        
                        break;
                    }
                } else {
                    break;
                }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no programa: " + e.getMessage());
        }
    }
}