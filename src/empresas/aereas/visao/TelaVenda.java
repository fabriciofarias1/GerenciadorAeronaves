/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas.aereas.visao;

import empresas.aereas.controle.ControleAeronaves;
import empresas.aereas.controle.ControleVendas;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Fabricio
 */
public class TelaVenda extends JFrame {
    
    private ControleVendas controleVendas;
    
    
    private JLabel lblcodigoCliente;
    private JLabel lblNome;
    private JLabel lblCPF;
    private JLabel lblcodigoAeronave;
    private JLabel lblvalorAeronave;
    private JLabel lbltipoAeronave;
    
    private JTextField txtcodigoCliente;
    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtcodigoAeronave;
    private JTextField txtvalorAeronave;
    private JTextField txttipoAeronave;
    
    private JButton btnVender;
    private JButton btnConsultar;
    private JButton btnLimpar;
    private JButton btnVoltar;
    
    private JPanel PainelConteudo;
    private JPanel PainelBotoes;
    
    
    public TelaVenda(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(300, 100, 700, 480);
        
        setTitle("Gerenciador Vendas de Aeronaves");
        
        controleVendas = new ControleVendas(this);
        
        
        PainelConteudo = new JPanel();
        PainelBotoes = new JPanel();
        
        lblcodigoCliente = new JLabel("Código do Cliente: ");
        lblNome = new JLabel("Nome: ");
        lblCPF = new JLabel("CPF: ");
        lblcodigoAeronave = new JLabel("Código da Aeronave: ");
        lblvalorAeronave = new JLabel("Valor da Aeronave: ");
        lbltipoAeronave = new JLabel("Tipo de Aeronave: ");

        txtcodigoCliente = new JTextField(30);
        txtNome = new JTextField(15);
        txtCPF = new JTextField(11);
        txtcodigoAeronave = new JTextField(10);
        txtvalorAeronave = new JTextField(10);
        txttipoAeronave = new JTextField(10);
        
        btnVender = new JButton("Vender");
        btnConsultar = new JButton("Consultar Aeronave");
        btnLimpar = new JButton("Limpar");
        btnVoltar = new JButton("Voltar");
        
        
        btnVender.addActionListener(controleVendas);
        btnConsultar.addActionListener(controleVendas);
        btnLimpar.addActionListener(controleVendas);
        btnVoltar.addActionListener(controleVendas);
        
        PainelConteudo.add(lblcodigoCliente);
        PainelConteudo.add(txtcodigoCliente);
        PainelConteudo.add(lblNome);
        PainelConteudo.add(txtNome);
        PainelConteudo.add(lblCPF);
        PainelConteudo.add(txtCPF);
        PainelConteudo.add(lblcodigoAeronave);
        PainelConteudo.add(txtcodigoAeronave);
        PainelConteudo.add(lbltipoAeronave);
        PainelConteudo.add(txttipoAeronave);
        PainelConteudo.add(lblvalorAeronave);
        PainelConteudo.add(txtvalorAeronave);
        
        PainelBotoes.add(btnVender);
        PainelBotoes.add(btnConsultar);
        PainelBotoes.add(btnLimpar);
        PainelBotoes.add(btnVoltar);
        
        
        add(PainelConteudo);
        //add(PainelMeio,BorderLayout.CENTER);
        add(PainelBotoes,BorderLayout.SOUTH);
        
    }
    
    
}
