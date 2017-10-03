/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresas.aereas.controle;

import empresas.aereas.modelo.Cliente;
import empresas.aereas.modelo.Jato;
import empresas.aereas.modelo.TurboHelice;
import empresas.aereas.persistencia.DAOAeronave;
import empresas.aereas.persistencia.DAOVenda;
import empresas.aereas.visao.TelaVenda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ministerio.aeronautica.modelo.Aeronave;

/**
 *
 * @author Fabricio
 */
public class ControleVendas implements ActionListener {

    private TelaVenda telaVenda;
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
    private JPanel PainelGeral;
    private DAOVenda daov;
    private DAOAeronave daoa;

    public ControleVendas(TelaVenda telaVenda) {
        try {
            daov = new DAOVenda();
            daoa = new DAOAeronave();
            this.telaVenda = telaVenda;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro de Criacao " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de Criacao " + e.getMessage());
        }

    }

    ControleVendas() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            PainelGeral = (JPanel) telaVenda.getContentPane();
            PainelConteudo = (JPanel) PainelGeral.getComponent(0);
            //PainelMeio = (JPanel) PainelGeral.getComponent(1);
            PainelBotoes = (JPanel) PainelGeral.getComponent(1);

            txtcodigoCliente = (JTextField) PainelConteudo.getComponent(1);
            txtNome = (JTextField) PainelConteudo.getComponent(3);
            txtCPF = (JTextField) PainelConteudo.getComponent(5);
            txtcodigoAeronave = (JTextField) PainelConteudo.getComponent(7);
            txttipoAeronave = (JTextField) PainelConteudo.getComponent(9);
            txtvalorAeronave = (JTextField) PainelConteudo.getComponent(11);

            btnVender = (JButton) PainelBotoes.getComponent(0);
            btnConsultar = (JButton) PainelBotoes.getComponent(1);
            btnLimpar = (JButton) PainelBotoes.getComponent(2);
            btnVoltar = (JButton) PainelBotoes.getComponent(3);

            if (e.getSource() == btnVender) {
                venda();
            } else if (e.getSource() == btnConsultar) {
                consultar();
            } else if (e.getSource() == btnLimpar) {
                limpar();
            } else {
                voltar();
            }

        } catch (Exception aux) {
            Logger.getLogger(ControleAeronaves.class.getName()).log(Level.SEVERE, null, aux);
        }

    }

    private void voltar() {
        telaVenda.dispose();
    }

    public void consultar() {
        try {
            Aeronave aeronave;
            aeronave = new Jato();
            aeronave.setCodigoAeronave(txtcodigoAeronave.getText());
            aeronave = daoa.consultar(aeronave);
            txtcodigoAeronave.setText(aeronave.getCodigoAeronave());
            txtvalorAeronave.setText(Double.toString(aeronave.obterValorVenda()));

            if (aeronave.getTipoAeronave().equals("Jato")) {
                JOptionPane.showMessageDialog(null, "Aeronave do tipo Jato.");
                txttipoAeronave.setText(aeronave.getTipoAeronave());
            } else if (aeronave.getTipoAeronave().equals("TurboHelice")) {
                JOptionPane.showMessageDialog(null, "Aeronave do tipo TurboHelice.");
                txttipoAeronave.setText(aeronave.getTipoAeronave());
            }
            //JOptionPane.showMessageDialog(null, "Consulta da Aeronave realizada com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Por favor digite um código de Aeronave.");
            limpar();
        }
    }

    private void limpar() {
        txtcodigoCliente.setText(null);
        txtNome.setText(null);
        txtCPF.setText(null);
        txtcodigoAeronave.setText(null);
        txttipoAeronave.setText(null);
        txtvalorAeronave.setText(null);
    }

    private void venda() throws Exception {

        try {
            Cliente cliente;
            cliente = new Cliente();
            Aeronave aeronave;
            aeronave = new Jato();
            cliente.setCodigoCliente(txtcodigoCliente.getText());
            cliente.setNomeCliente(txtNome.getText());
            cliente.setCpf(txtCPF.getText());
            aeronave.setCodigoAeronave(txtcodigoAeronave.getText());
            aeronave.setTipoAeronave(txttipoAeronave.getText());
            aeronave.setAutonomia(Double.parseDouble(txtvalorAeronave.getText()));
            daov.vender(aeronave, cliente);
            JOptionPane.showMessageDialog(null, "Venda da Aeronave realizada com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível concluir a transação.");
        }
    }
}
