package br.senai.sp.jandira.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.senai.sp.jandira.lista.TipoConsole;
import br.senai.sp.jandira.model.Fabricante;
import br.senai.sp.jandira.model.Jogo;
import br.senai.sp.jandira.repository.FabricanteRepository;
import br.senai.sp.jandira.repository.JogoRepository;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTituloDoJogo;
	private JTextField textFieldValorEstimado;
	private JLabel lblConsole;
	

	public Tela() {

		// Criação dos fabricantes:
		ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
		Fabricante sega = new Fabricante("Sega", "1970", 30000000);
		Fabricante capcom = new Fabricante("Capcom", "1980", 40000000);
		Fabricante steam = new Fabricante("Steam", "1990", 100000000);
		Fabricante nintendo = new Fabricante("Nintendo", "1980", 100000000);
		fabricantes.add(sega);
		fabricantes.add(capcom);
		fabricantes.add(steam);
		fabricantes.add(nintendo);

		// Gravação dos fabricantes no repositório:
		FabricanteRepository repositorioFabricante = new FabricanteRepository();
		fabricantes.forEach(fabricantesLocal -> {
			repositorioFabricante.gravar(fabricantesLocal);
		});
			
		
		// Gravação no repositório de Jogos:
		JogoRepository jogoRepository = new JogoRepository();

		// Frame:
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tela.class
				.getResource("/br/senai/sp/jandira/ui/img/jogos.png")));
		setTitle("Gerenciador de jogos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 747);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 61, 223, -64);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 0, 810, 145);
		contentPane.add(panel_1); 
		panel_1.setLayout(null);

		JLabel lblControle2 = new JLabel("");
		lblControle2.setBounds(725, 25, 64, 64);
		lblControle2.setIcon(new ImageIcon(Tela.class.getResource(
				"/br/senai/sp/jandira/ui/img/controle-de-video-game.png")));
		panel_1.add(lblControle2);

		JLabel lblControle1 = new JLabel("");
		lblControle1.setIcon(new ImageIcon(Tela.class.getResource(
				"/br/senai/sp/jandira/ui/img/controle-de-video-game.png")));
		lblControle1.setBounds(10, 34, 64, 55);
		panel_1.add(lblControle1);

		JLabel lblGerenciadorDeJogos = new JLabel("Gerenciador de jogos");
		lblGerenciadorDeJogos.setForeground(new Color(255, 255, 255));
		lblGerenciadorDeJogos.setFont(new Font("Verdana", Font.BOLD, 26));
		lblGerenciadorDeJogos.setBounds(236, 34, 317, 55);
		panel_1.add(lblGerenciadorDeJogos);

		JLabel lblTituloDoJogo = new JLabel("T\u00EDtulo do jogo:");
		lblTituloDoJogo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTituloDoJogo.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblTituloDoJogo.setBounds(10, 174, 151, 26);
		contentPane.add(lblTituloDoJogo);

		textFieldTituloDoJogo = new JTextField();
		textFieldTituloDoJogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTituloDoJogo.setBounds(163, 173, 276, 32);
		contentPane.add(textFieldTituloDoJogo);
		textFieldTituloDoJogo.setColumns(10);

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFabricante.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblFabricante.setBounds(9, 267, 151, 26);
		contentPane.add(lblFabricante);

		JComboBox<String> comboBoxFabricante = new JComboBox<String>();
		comboBoxFabricante.setBounds(163, 265, 276, 32);
		contentPane.add(comboBoxFabricante);

		Fabricante[] fabricantesArr = repositorioFabricante.listarTodos();
		DefaultComboBoxModel<String> comboFabricante =
				new DefaultComboBoxModel<String>();
		for (Fabricante fabricante : fabricantesArr) {
			comboFabricante.addElement(fabricante.getNomeFabricante());
		}
		comboBoxFabricante.setModel(comboFabricante);

		JCheckBox checkBoxZerado = new JCheckBox("Zerado");
		checkBoxZerado.setHorizontalAlignment(SwingConstants.LEFT);
		checkBoxZerado.setBackground(new Color(176, 196, 222));
		checkBoxZerado.setFont(new Font("Montserrat", Font.PLAIN, 20));
		checkBoxZerado.setBounds(163, 219, 104, 32);
		contentPane.add(checkBoxZerado);

		lblConsole = new JLabel("Console:");
		lblConsole.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConsole.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblConsole.setBounds(10, 312, 149, 32);
		contentPane.add(lblConsole);

		JComboBox<String> comboBoxConsole = new JComboBox<String>();
		comboBoxConsole.setBounds(163, 315, 276, 31);
		contentPane.add(comboBoxConsole);

		DefaultComboBoxModel<String> comboModelConsole =
				new DefaultComboBoxModel<String>();

		for (TipoConsole console : TipoConsole.values()) {
			comboModelConsole.addElement(console.getDescription());
		}

		comboBoxConsole.setModel(comboModelConsole);

		JLabel lblValorEstimado = new JLabel("Valor estimado:");
		lblValorEstimado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorEstimado.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblValorEstimado.setBounds(3, 367, 157, 26);
		contentPane.add(lblValorEstimado);

		textFieldValorEstimado = new JTextField();
		textFieldValorEstimado.setBounds(163, 365, 276, 32);
		contentPane.add(textFieldValorEstimado);
		textFieldValorEstimado.setColumns(10);

		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservacoes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObservacoes.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblObservacoes.setBounds(10, 411, 148, 26);
		contentPane.add(lblObservacoes);

		JButton btnSalvar = new JButton("salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(112, 128, 144));
		btnSalvar.setBounds(163, 647, 134, 38);
		contentPane.add(btnSalvar);

		JLabel lblMeusJogos = new JLabel("Meus jogos:");
		lblMeusJogos.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblMeusJogos.setBounds(465, 170, 140, 32);
		contentPane.add(lblMeusJogos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(465, 214, 325, 403);
		contentPane.add(scrollPane);

		JList<String> listJogos = new JList<String>();
		listJogos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(listJogos);

		JButton btnVoltar = new JButton("<");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(112, 128, 144));
		btnVoltar.setBounds(465, 647, 89, 38);
		contentPane.add(btnVoltar);

		JButton btnAvanca = new JButton(">");
		btnAvanca.setForeground(Color.WHITE);
		btnAvanca.setBackground(new Color(112, 128, 144));
		btnAvanca.setBounds(701, 647, 89, 38);
		contentPane.add(btnAvanca);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(128, 520, -4, 22);
		contentPane.add(textArea);

		JTextArea textAreaObservacoes = new JTextArea();
		textAreaObservacoes.setLineWrap(true);
		textAreaObservacoes.setBounds(163, 418, 276, 199);
		contentPane.add(textAreaObservacoes);

		DefaultListModel<String> modelJogos = new DefaultListModel<String>();
		listJogos.setModel(modelJogos);

		JButton btnExibirtxt = new JButton("Exibir.txt");
		btnExibirtxt.setForeground(Color.WHITE);
		btnExibirtxt.setBackground(new Color(112, 128, 144));
		btnExibirtxt.setBounds(564, 647, 128, 38);
		contentPane.add(btnExibirtxt);

		JButton btnSalvarEdit = new JButton("Salvar edi\u00E7\u00E3o");
		btnSalvarEdit.setForeground(Color.WHITE);
		btnSalvarEdit.setBackground(new Color(112, 128, 144));
		btnSalvarEdit.setBounds(305, 647, 134, 38);
		contentPane.add(btnSalvarEdit);

	

		// Actions:
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String txtTituloJogo = textFieldTituloDoJogo.getText();
				String txtValorEstimado = textFieldValorEstimado.getText();
				String txtObservacoes = textAreaObservacoes.getText();
				int fabricanteItem = comboBoxFabricante.getSelectedIndex();
				String consoleItem =
						comboBoxConsole.getSelectedItem().toString();
				TipoConsole consoleEnum =
						TipoConsole.getValueForEnum(consoleItem);
				boolean checkBoxStatus = checkBoxZerado.isSelected();

				Jogo jogo = new Jogo();
				jogo.setName(txtTituloJogo);
				jogo.setValor(Double
						.parseDouble(txtValorEstimado.replaceAll(",", ".")));
				jogo.setObservacoes(txtObservacoes);
				jogo.setFabricante(
						repositorioFabricante.listarFabricante(fabricanteItem));
				jogo.setTipoConsole(consoleEnum);
				jogo.setZerado(checkBoxStatus);
				
				
				
				jogoRepository.gravar(jogo);

				textFieldTituloDoJogo.setText(null);
				textFieldValorEstimado.setText(null);
				textAreaObservacoes.setText(null);
				checkBoxZerado.setSelected(false);
				comboBoxFabricante.setSelectedIndex(0);
				comboBoxConsole.setSelectedIndex(0);
				textFieldTituloDoJogo.requestFocus();

				modelJogos.addElement(jogo.getName());

			}
		});

		listJogos.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				Jogo gameSelected =
						jogoRepository.listarJogo(listJogos.getSelectedIndex());
				textFieldTituloDoJogo.setText(gameSelected.getName());
				textFieldValorEstimado
						.setText(String.valueOf(gameSelected.getValor()));
				textAreaObservacoes.setText(gameSelected.getObservacoes());
				checkBoxZerado.setSelected(gameSelected.getZerado());

				comboBoxConsole.setSelectedIndex(
						gameSelected.getTipoConsole().ordinal());
				comboBoxFabricante.setSelectedItem(
						gameSelected.getFabricante().getNomeFabricante());

				btnSalvar.setEnabled(false);

				// Botão salvar edição:
				btnSalvarEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Jogo gameSelectedEditJogo = jogoRepository
								.listarJogo(listJogos.getSelectedIndex());

						textFieldTituloDoJogo
								.setText(gameSelectedEditJogo.getName());
						textFieldValorEstimado.setText(String
								.valueOf(gameSelectedEditJogo.getValor()));
						textAreaObservacoes
								.setText(gameSelectedEditJogo.getObservacoes());
						checkBoxZerado
								.setSelected(gameSelectedEditJogo.getZerado());

						comboBoxConsole.setSelectedIndex(gameSelectedEditJogo
								.getTipoConsole().ordinal());
						comboBoxFabricante.setSelectedItem(gameSelectedEditJogo
								.getFabricante().getNomeFabricante());

						textFieldTituloDoJogo.setText(null);
						textFieldValorEstimado.setText(null);
						textAreaObservacoes.setText(null);
						checkBoxZerado.setSelected(false);
						comboBoxFabricante.setSelectedIndex(0);
						comboBoxConsole.setSelectedIndex(0);
						textFieldTituloDoJogo.requestFocus();

						btnSalvar.setEnabled(true);
					}
				});

			}
		});

		// Botão avançar:
		btnAvanca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int posicaoDaLista = listJogos.getSelectedIndex();

				if (posicaoDaLista == listJogos.getLastVisibleIndex()) {
					listJogos
							.setSelectedIndex(listJogos.getFirstVisibleIndex());
				} else {
					listJogos.setSelectedIndex(posicaoDaLista + 1);
				}
			}
		});

		// Botão voltar:
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int posicaoDaLista = listJogos.getSelectedIndex();

				if (posicaoDaLista == listJogos.getFirstVisibleIndex()) {
					listJogos.setSelectedIndex(listJogos.getLastVisibleIndex());
				} else {
					listJogos.setSelectedIndex(posicaoDaLista - 1);
				}
			}
		});

	}
}

/*
 * Caso necessário:
 * 
 * if (cont == ds1t.getTamanho()) { btnSalvar.setEnabled(false);
 * JOptionPane.showMessageDialog(null, "A turma já enchu!", "Cheio",
 * JOptionPane.WARNING_MESSAGE); }
 */
