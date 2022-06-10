package com.github.akagawatsurunaki.memodemo.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.akagawatsurunaki.memodemo.controller.FindWordController;
import com.github.akagawatsurunaki.memodemo.controller.DemoController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindWordFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public JTextField getTxtFldWord() {
		return txtFldWord;
	}


	private JPanel contentPane;
	private JTextField txtFldWord;

	public FindWordFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Find Word");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNewLabel.setBounds(63, 27, 145, 39);
		contentPane.add(lblNewLabel);
		
		txtFldWord = new JTextField();
		txtFldWord.setFont(new Font("Consolas", Font.PLAIN, 16));
		txtFldWord.setBounds(63, 76, 309, 21);
		contentPane.add(txtFldWord);
		txtFldWord.setColumns(10);
		
		JButton btnNewButton = new JButton("Find");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindWordController.getInstance().rqsFind();
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 16));
		btnNewButton.setBounds(63, 214, 97, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DemoController.getInstance().getMainFrame().setEnabled(true);
				FindWordFrame.this.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Consolas", Font.BOLD, 16));
		btnNewButton_1.setBounds(275, 214, 97, 39);
		contentPane.add(btnNewButton_1);
	}
}
