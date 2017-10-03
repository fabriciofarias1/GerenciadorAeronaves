/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas.aereas.controle;

import empresas.aereas.modelo.Jato;
import empresas.aereas.modelo.TurboHelice;
import empresas.aereas.modelo.AeronaveTransporte;
import empresas.aereas.persistencia.DAOAeronave;
import empresas.aereas.visao.Tela;
import empresas.aereas.visao.TelaVenda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import ministerio.aeronautica.modelo.Aeronave;

/**
 *
 * @author Fabricio
 */
public class ControleAeronaves implements ActionListener {

    private Tela tela;

    private JTextField txtCodigoAeronave;
    //private JTextField txtCodigoCliente;
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
    //private JPanel PainelMeio;
    private JPanel PainelGeral;

    private JRadioButton rdbJato;
    private JRadioButton rdbTurbo;
    private ButtonGroup rdbGroup;
    private DAOAeronave daoa;
    //private DAOVenda daov;
    private ControleVendas vendas;

    public ControleAeronaves(Tela tela) {
        try {
            daoa = new DAOAeronave();
            //daov = new DAOVenda();
            //vendas = new ControleVendas();
            this.tela = tela;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro de Criacao " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de Criacao " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            PainelGeral = (JPanel) tela.getContentPane();
            PainelConteudo = (JPanel) PainelGeral.getComponent(0);
            //PainelMeio = (JPanel) PainelGeral.getComponent(1);
            PainelBotoes = (JPanel) PainelGeral.getComponent(1);

            btnIncluir = (JButton) PainelBotoes.getComponent(0);
            btnExcluir = (JButton) PainelBotoes.getComponent(1);
            btnAlterar = (JButton) PainelBotoes.getComponent(2);
            btnConsultar = (JButton) PainelBotoes.getComponent(3);
            btnLimpar = (JButton) PainelBotoes.getComponent(4);
            btnVender = (JButton) PainelBotoes.getComponent(5);
            btnSair = (JButton) PainelBotoes.getComponent(6);

            txtCodigoAeronave = (JTextField) PainelConteudo.getComponent(1);
            //txtCodigoCliente = (JTextField) PainelConteudo.getComponent(3);
            rdbJato = (JRadioButton) PainelConteudo.getComponent(2);
            rdbTurbo = (JRadioButton) PainelConteudo.getComponent(3);
            txtAutonomia = (JTextField) PainelConteudo.getComponent(5);
            txtNivelVoo = (JTextField) PainelConteudo.getComponent(7);
            txtCapacidadeCarga = (JTextField) PainelConteudo.getComponent(9);
            txtValorVenda = (JTextField) PainelConteudo.getComponent(11);

            if (e.getSource() == btnSair) {
                sair();
            } else if (e.getSource() == btnIncluir) {
                incluir();
            } else if (e.getSource() == btnExcluir) {
                excluir();
            } else if (e.getSource() == btnAlterar) {
                alterar();
            } else if (e.getSource() == btnConsultar) {
                consultar();
            } else if (e.getSource() == btnVender) {
                vender();
            } else {
                limpar();
            }

        } catch (Exception aux) {
            Logger.getLogger(ControleAeronaves.class.getName()).log(Level.SEVERE, null, aux);
        }
    }

    private void sair() {
        tela.dispose();
    }

    private void incluir() throws Exception, SQLException {
        Aeronave aeronave;
        try {
            if (rdbJato.isSelected() == false && rdbTurbo.isSelected() == false) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um tipo de Aeronave.");
                Logger.getLogger(ControleAeronaves.class.getName()).log(Level.SEVERE, "O Cliente nao selecionou o tipo de Aeronave.");
            } else {
                if (rdbJato.isSelected()) {
                    aeronave = new Jato();
                } else {
                    aeronave = new TurboHelice();
                }
                aeronave.setCodigoAeronave(txtCodigoAeronave.getText());
                aeronave.setNivelVoo(Integer.parseInt(txtNivelVoo.getText()));
                aeronave.setCapacidadeCarga(Double.parseDouble(txtCapacidadeCarga.getText()));
                aeronave.setAutonomia(Double.parseDouble(txtAutonomia.getText()));
                daoa.incluir(aeronave);
                JOptionPane.showMessageDialog(null, "Inclusão da Aeronave realizada com sucesso.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir Aeronave.");
        }
    }

    private void excluir() throws Exception {
        Aeronave aeronave;
        aeronave = new Jato();
        aeronave.setCodigoAeronave(txtCodigoAeronave.getText());
        daoa.excluir(aeronave);
        JOptionPane.showMessageDialog(null, "Exclusão da Aeronave realizada com sucesso.");
    }

    private void alterar() throws Exception {
        Aeronave aeronave = null;
        if (rdbJato.isSelected() == false && rdbTurbo.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um tipo de Aeronave.");
            Logger.getLogger(ControleAeronaves.class.getName()).log(Level.SEVERE, "O Cliente nao selecionou o tipo de Aeronave.");
        } else {
            if (rdbJato.isSelected()) {
                aeronave = new Jato();
            } else {
                aeronave = new TurboHelice();
            }
            aeronave.setCodigoAeronave(txtCodigoAeronave.getText());
            aeronave.setNivelVoo(Integer.parseInt(txtNivelVoo.getText()));
            aeronave.setCapacidadeCarga(Double.parseDouble(txtCapacidadeCarga.getText()));
            aeronave.setAutonomia(Double.parseDouble(txtAutonomia.getText()));
            daoa.alterar(aeronave);
            JOptionPane.showMessageDialog(null, "Alteração da Aeronave realizada com sucesso");
        }
    }

    private void consultar() throws Exception {
        try {
            Aeronave aeronave;
            if (rdbJato.isSelected()) {
                aeronave = new Jato();
            } else {
                aeronave = new TurboHelice();
            }
            aeronave.setCodigoAeronave(txtCodigoAeronave.getText());
            aeronave = daoa.consultar(aeronave);
            txtCodigoAeronave.setText(aeronave.getCodigoAeronave());
            txtNivelVoo.setText(Double.toString(aeronave.getNivelVoo()));
            txtCapacidadeCarga.setText(Double.toString(aeronave.getCapacidadeCarga()));
            txtAutonomia.setText(Double.toString(aeronave.getAutonomia()));
            txtValorVenda.setText(Double.toString(aeronave.obterValorVenda()));

            if (aeronave.getTipoAeronave().equals("Jato")) {
                JOptionPane.showMessageDialog(null, "Aeronave do tipo Jato.");
                rdbJato.setSelected(true);
            } else if (aeronave.getTipoAeronave().equals("TurboHelice")) {
                JOptionPane.showMessageDialog(null, "Aeronave do tipo TurboHelice.");
                rdbTurbo.setSelected(true);
            }
            //JOptionPane.showMessageDialog(null, "Consulta da Aeronave realizada com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar Aeronave.");
            limpar();
        }
    }

    private void limpar() {
        txtCodigoAeronave.setText(null);
        txtNivelVoo.setText(null);
        txtCapacidadeCarga.setText(null);
        txtAutonomia.setText(null);
        txtValorVenda.setText(null);
    }

    public void vender() throws Exception {
        TelaVenda telaVenda = new TelaVenda();
        telaVenda.setVisible(true);
        //Aeronave aeronave;
        //if (rdbJato.isSelected()) {
        //    aeronave = new Jato();
        //} else {
        //    aeronave = new TurboHelice();
        //}
        //aeronave.setCodigoAeronave(txtCodigoAeronave.getText());
        //aeronave.obterValorVenda();
        //vendas = new ControleVendas();
        //vendas.vender(aeronave);
        //JOptionPane.showMessageDialog(null, "Cada cliente só pode comprar uma aeronave por venda.");

        //JOptionPane.showMessageDialog(null, "Venda da aeronave realizada com sucesso.");
        //tela.setVisible(false);
    }
}
