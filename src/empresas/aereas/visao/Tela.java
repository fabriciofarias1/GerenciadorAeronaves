/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas.aereas.visao;

import empresas.aereas.controle.ControleAeronaves;
import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Fabricio
 */
public class Tela extends JFrame {
    
    private JLabel lblCodigoAeronave;
    private JLabel lblNivelVoo;
    private JLabel lblCapacidadeCarga;
    private JLabel lblAutonomia;
    private JLabel lblValorVenda;
    
    private JTextField txtCodigoAeronave;
    private JTextField txtNivelVoo;
    private JTextField txtCapacidadeCarga;
    private JTextField txtAutonomia;
    private JTextField txtValorVenda;
    
    private JButton btnIncluir;
    private JButton btnExcluir;
    private JButton btnAlterar;
    private JButton btnConsultar;
    private JButton btnLimpar;
    private JButton btnSair;
    private JButton btnVender;
    
    private JPanel PainelConteudo;
    private JPanel PainelBotoes;
    
    
    private JRadioButton rdbJato;
    private JRadioButton rdbTurbo;
    private ButtonGroup rdbGroup;
    
    private ControleAeronaves controleAeronaves;
    
    public Tela() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 100, 700, 480);
        
        setTitle("Gerenciador de Aeronaves");
        //setExtendedState(JFrame.MAXIMIZED_BOTH); 
       
        //setLayout(new BorderLayout());
        
        controleAeronaves = new ControleAeronaves(this);
        
        PainelConteudo = new JPanel();
        //PainelMeio = new JPanel();
        PainelBotoes = new JPanel();

        lblCodigoAeronave = new JLabel("Codigo da Aeronave: ");
        txtCodigoAeronave = new JTextField(30);
        //lblCodigoCliente = new JLabel("Código do Cliente: ");
        //txtCodigoCliente = new JTextField(30);
        lblNivelVoo = new JLabel("Nível de Voo: ");
        txtNivelVoo = new JTextField(10);
        lblCapacidadeCarga = new JLabel("Capacidade de Carga: ");
        txtCapacidadeCarga = new JTextField(10);
        lblAutonomia = new JLabel("Autonomia de Voo: ");
        txtAutonomia = new JTextField(10);
        lblValorVenda = new JLabel("Valor da Aeronave: "); 
        txtValorVenda = new JTextField(10);
        
        rdbJato = new JRadioButton("Jato");
        rdbTurbo = new JRadioButton("Turbo-Hélice");
        rdbGroup = new ButtonGroup();
        
        btnIncluir = new JButton("Incluir");
        btnExcluir = new JButton("Excluir");
        btnAlterar = new JButton("Alterar");
        btnConsultar = new JButton("Consultar");
        btnLimpar = new JButton("Limpar");
        btnVender = new JButton("Vender");
        btnSair = new JButton("Sair");
        
        rdbGroup.add(rdbJato);
        rdbGroup.add(rdbTurbo);
        
        btnIncluir.addActionListener(controleAeronaves);
        btnExcluir.addActionListener(controleAeronaves);
        btnAlterar.addActionListener(controleAeronaves);
        btnConsultar.addActionListener(controleAeronaves);
        btnLimpar.addActionListener(controleAeronaves);
        btnVender.addActionListener(controleAeronaves);
        btnSair.addActionListener(controleAeronaves);

        PainelConteudo.add(lblCodigoAeronave);
        PainelConteudo.add(txtCodigoAeronave);
        //PainelConteudo.add(lblCodigoCliente);
        //PainelConteudo.add(txtCodigoCliente);
        PainelConteudo.add(rdbJato);
        PainelConteudo.add(rdbTurbo);
        PainelConteudo.add(lblAutonomia);
        PainelConteudo.add(txtAutonomia);
        PainelConteudo.add(lblNivelVoo);
        PainelConteudo.add(txtNivelVoo);
        PainelConteudo.add(lblCapacidadeCarga);
        PainelConteudo.add(txtCapacidadeCarga);
        PainelConteudo.add(lblValorVenda);
        PainelConteudo.add(txtValorVenda);
        
        PainelBotoes.add(btnIncluir);
        PainelBotoes.add(btnExcluir);
        PainelBotoes.add(btnAlterar);
        PainelBotoes.add(btnConsultar);
        PainelBotoes.add(btnLimpar);
        PainelBotoes.add(btnVender);
        PainelBotoes.add(btnSair);

        add(PainelConteudo);
        //add(PainelMeio,BorderLayout.CENTER);
        add(PainelBotoes,BorderLayout.SOUTH);

    }

    
    
}
