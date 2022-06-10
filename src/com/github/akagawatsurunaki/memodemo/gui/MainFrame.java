package com.github.akagawatsurunaki.memodemo.gui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.akagawatsurunaki.memodemo.controller.FindWordController;
import com.github.akagawatsurunaki.memodemo.controller.DemoController;
import com.github.akagawatsurunaki.memodemo.controller.NewWordController;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainFrame extends JFrame {


	public JButton getBtnhideOrShow() {
		return btnhideOrShow;
	}

	public JTextField getTxtFldAnswer() {
		return txtFldAnswer;
	}

	public JTextPane getCenterWordTextPane() {
		return centerWordTextPane;
	}

	private static final long serialVersionUID = 1L;
	private static final String iconPath = ".\\data\\icon\\icon.png";
	private JPanel contentPane;
	private JTextPane centerWordTextPane;
	private JTextField txtFldAnswer;
	private JToolBar toolBar;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	JButton btnhideOrShow;
	private JButton btnNewButton;
	private JButton btnNewButton_5;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("MemoDemo -- 您背单词的小助手 ver.2022.6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(751, 308);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(iconPath));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		centerWordTextPane = new JTextPane();
		contentPane.add(centerWordTextPane, BorderLayout.CENTER);
		centerWordTextPane.setEditable(false);
		
		txtFldAnswer = new JTextField();
		contentPane.add(txtFldAnswer, BorderLayout.SOUTH);
		txtFldAnswer.setColumns(10);
		
		btnhideOrShow = new JButton("显示英文单词");
		btnhideOrShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DemoController.getInstance().updateAllWordInfo();
			}
		});
		contentPane.add(btnhideOrShow, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("我拼对了吗？");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DemoController.getInstance().rqsNext();
			}
		});
		contentPane.add(btnNewButton_1, BorderLayout.EAST);
		
		toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnNewButton_2 = new JButton("New");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewWordController.getInstance().show();
			}
		});
		btnNewButton_2.setFont(new Font("Consolas", Font.PLAIN, 16));
		toolBar.add(btnNewButton_2);
		
		btnNewButton_4 = new JButton("Find");
		btnNewButton_4.setFont(new Font("Consolas", Font.PLAIN, 16));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindWordController.getInstance().invoke();
				MainFrame.this.setEnabled(false);
			}
		});
		
		btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DemoController.getInstance().rqsDel();
			}
		});
		btnNewButton_3.setFont(new Font("Consolas", Font.PLAIN, 16));
		toolBar.add(btnNewButton_3);
		toolBar.add(btnNewButton_4);
		
		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DemoController.getInstance().rqsSave();
			}
		});
		
		btnNewButton_5 = new JButton("Edit");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewWordController.getInstance().rqsEdit();
			}
		});
		btnNewButton_5.setFont(new Font("Consolas", Font.PLAIN, 16));
		toolBar.add(btnNewButton_5);
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 16));
		toolBar.add(btnNewButton);
	}

}
