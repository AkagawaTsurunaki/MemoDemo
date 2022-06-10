package com.github.akagawatsurunaki.memodemo.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.github.akagawatsurunaki.memodemo.controller.DemoController;
import com.github.akagawatsurunaki.memodemo.controller.NewWordController;
import com.github.akagawatsurunaki.memodemo.model.constants.Constants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewWordFrame extends JFrame {

	public JTextField getTxtFldWord() {
		return txtFldWord;
	}

	public JTextField getTxtFldNoun() {
		return txtFldNoun;
	}

	public JTextField getTxtFldPron() {
		return txtFldPron;
	}

	public JTextField getTxtFldAdj() {
		return txtFldAdj;
	}

	public JTextField getTxtFldAdv() {
		return txtFldAdv;
	}

	public JTextField getTxtFldVerb() {
		return txtFldVerb;
	}

	public JTextField getTxtFldNum() {
		return txtFldNum;
	}

	public JTextField getTxtFldArt() {
		return txtFldArt;
	}

	public JTextField getTxtFldPrep() {
		return txtFldPrep;
	}

	public JTextField getTxtFldConj() {
		return txtFldConj;
	}

	public JTextField getTxtFldInterj() {
		return txtFldInterj;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Font font = new Font(Constants.GLOBAL_FONT, Font.BOLD, 25);
	
	private JPanel contentPane;
	private JTextField txtFldWord;
	private JLabel lblWord;
	private JLabel lblNoun;
	private JTextField txtFldNoun;
	private JLabel lblPron;
	private JTextField txtFldPron;
	private JLabel lblAdj;
	private JTextField txtFldAdj;
	private JLabel lblAdv;
	private JTextField txtFldAdv;
	private JLabel lblVerb;
	private JTextField txtFldVerb;
	private JLabel lblNum;
	private JTextField txtFldNum;
	private JTextField txtFldArt;
	private JTextField txtFldPrep;
	private JLabel lblConj;
	private JTextField txtFldConj;
	private JLabel lblInterj;
	private JTextField txtFldInterj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public NewWordFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNoun = new JLabel("NOUN");
		lblNoun.setBounds(38, 57, 130, 30);
		contentPane.add(lblNoun);
		
		txtFldWord = new JTextField();
		txtFldWord.setBounds(212, 10, 249, 35);
		contentPane.add(txtFldWord);
		txtFldWord.setColumns(10);
		
		lblWord = new JLabel("WORD");
		lblWord.setBounds(38, 12, 130, 30);
		contentPane.add(lblWord);
		
		txtFldNoun = new JTextField();
		txtFldNoun.setColumns(10);
		txtFldNoun.setBounds(212, 55, 249, 35);
		contentPane.add(txtFldNoun);
		
		lblPron = new JLabel("PRONOUN");
		lblPron.setBounds(38, 102, 130, 30);
		contentPane.add(lblPron);
		
		txtFldPron = new JTextField();
		txtFldPron.setColumns(10);
		txtFldPron.setBounds(212, 100, 249, 35);
		contentPane.add(txtFldPron);
		
		lblAdj = new JLabel("ADJECTIVE");
		lblAdj.setBounds(38, 147, 130, 30);
		contentPane.add(lblAdj);
		
		txtFldAdj = new JTextField();
		txtFldAdj.setColumns(10);
		txtFldAdj.setBounds(212, 145, 249, 35);
		contentPane.add(txtFldAdj);
		
		lblAdv = new JLabel("ADVERB");
		lblAdv.setBounds(38, 192, 130, 30);
		contentPane.add(lblAdv);
		
		txtFldAdv = new JTextField();
		txtFldAdv.setColumns(10);
		txtFldAdv.setBounds(212, 190, 249, 35);
		contentPane.add(txtFldAdv);
		
		lblVerb = new JLabel("VERB");
		lblVerb.setBounds(38, 237, 130, 30);
		contentPane.add(lblVerb);
		
		txtFldVerb = new JTextField();
		txtFldVerb.setColumns(10);
		txtFldVerb.setBounds(212, 235, 249, 35);
		contentPane.add(txtFldVerb);
		
		lblNum = new JLabel("NUMERAL");
		lblNum.setBounds(38, 282, 130, 30);
		contentPane.add(lblNum);
		
		txtFldNum = new JTextField();
		txtFldNum.setColumns(10);
		txtFldNum.setBounds(212, 280, 249, 35);
		contentPane.add(txtFldNum);
		
		
		lblWord.setFont(font);
		lblNoun.setFont(font);
		lblAdj.setFont(font);
		lblAdv.setFont(font);
		lblPron.setFont(font);
		lblVerb.setFont(font);
		lblNum.setFont(font);
		
		txtFldArt = new JTextField();
		txtFldArt.setColumns(10);
		txtFldArt.setBounds(212, 325, 249, 35);
		contentPane.add(txtFldArt);
		
		JLabel lblArt = new JLabel("ARTICLE");
		lblArt.setFont(new Font("Consolas", Font.BOLD, 25));
		lblArt.setBounds(38, 327, 130, 30);
		contentPane.add(lblArt);
		
		JLabel lblPrep = new JLabel("PREPOSITION");
		lblPrep.setFont(new Font("Consolas", Font.BOLD, 25));
		lblPrep.setBounds(38, 372, 158, 30);
		contentPane.add(lblPrep);
		
		txtFldPrep = new JTextField();
		txtFldPrep.setColumns(10);
		txtFldPrep.setBounds(212, 370, 249, 35);
		contentPane.add(txtFldPrep);
		
		lblConj = new JLabel("CONJUNCTION");
		lblConj.setFont(new Font("Consolas", Font.BOLD, 25));
		lblConj.setBounds(38, 417, 176, 30);
		contentPane.add(lblConj);
		
		txtFldConj = new JTextField();
		txtFldConj.setColumns(10);
		txtFldConj.setBounds(212, 415, 249, 35);
		contentPane.add(txtFldConj);
		
		lblInterj = new JLabel("INTERJECTION");
		lblInterj.setFont(new Font("Consolas", Font.BOLD, 25));
		lblInterj.setBounds(38, 462, 176, 30);
		contentPane.add(lblInterj);
		
		txtFldInterj = new JTextField();
		txtFldInterj.setColumns(10);
		txtFldInterj.setBounds(212, 460, 249, 35);
		contentPane.add(txtFldInterj);
		
		JButton btnAdd = new JButton("Add it!");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewWordController.getInstance().rqsNewWord();
			}
		});
		btnAdd.setBounds(38, 530, 128, 46);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DemoController.getInstance().getMainFrame().setEnabled(true);
				NewWordFrame.this.dispose();
			}
		});
		btnCancel.setBounds(334, 530, 128, 46);
		contentPane.add(btnCancel);
	}
}
