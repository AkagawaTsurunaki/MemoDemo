package com.github.akagawatsurunaki.memodemo.controller;

import javax.swing.JOptionPane;

import com.github.akagawatsurunaki.memodemo.exceptions.MemoDemoException;
import com.github.akagawatsurunaki.memodemo.gui.MainFrame;
import com.github.akagawatsurunaki.memodemo.handler.MemoDemoHandler;

public class DemoController extends Controller {

	// #region Singleton

	private static DemoController instance = new DemoController();

	public static DemoController getInstance() {
		if (instance == null) {
			instance = new DemoController();
		}
		return instance;
	}

	private DemoController() {
	}

	// #endregion

	private boolean btnStatus = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DemoController.getInstance().invoke();
		} catch (Exception e) {
			// If a fatal error happened, the whole program will exit with status code -1.
			MemoDemoException me = new MemoDemoException("MemoDemo�ؼ���ֹͣ",  "MemoDemo����������˹ؼ��Դ���\n�������̹رձ�����\n�쳣��Ϣ��" + e.getMessage());
			MemoDemoHandler.handle(me);
		}
		
	}

	public void invoke() {
		show();
		setCurrentWordRandomly();
	}

	public void show() {
		DemoController.getInstance().mainFrame = new MainFrame();
		DemoController.getInstance().mainFrame.setVisible(true);
	}

	public void updateAllWordInfo() {

		// True means show
		if (btnStatus) {
			mainFrame.getCenterWordTextPane().setText(currentWord.toString());
			mainFrame.getBtnhideOrShow().setText("����Ӣ�ĵ���");
		} else {
			mainFrame.getCenterWordTextPane().setText(currentWord.toMeaningString());
			mainFrame.getBtnhideOrShow().setText("��ʾӢ�ĵ���");
		}

		btnStatus = !btnStatus;
		mainFrame.getTxtFldAnswer().setText("");
	}

	public void updateCurrentWordTextPane() {
		mainFrame.getCenterWordTextPane().setText(currentWord.toMeaningString());
		mainFrame.getTxtFldAnswer().setText("");
	}

	public void rqsNext() {

		if (currentWord == null) {
			JOptionPane.showMessageDialog(mainFrame, "û��Ҫƴд�ĵ��ʡ�", "��ǰ����Ϊ��", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if(mainFrame.getTxtFldAnswer().getText().isEmpty()) {
			JOptionPane.showMessageDialog(mainFrame, "����û��ƴд��", "������������", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		boolean flag = wordDao.isCorrectAnswer(mainFrame.getTxtFldAnswer().getText(), currentWord);

		if (flag) {
			currentWord.setAnswerCount(true);
			JOptionPane.showMessageDialog(mainFrame, "�����\n��������Ѿ������" + currentWord.getCorrectAnswerCount() + "�Σ�",
					"����ƴд��ȷ", JOptionPane.INFORMATION_MESSAGE);
			setCurrentWordRandomly(currentWord);
		} else {
			currentWord.setAnswerCount(false);
			JOptionPane
					.showMessageDialog(mainFrame,
							"ƴ�����������룿��һ�����Եģ�\n�������Ѿ�ƴд" + currentWord.getAnswerCount() + "�Σ�\n���ܹ������"
									+ currentWord.getWrongAnswerCount() + "��",
							"����ƴд����", JOptionPane.INFORMATION_MESSAGE);
			mainFrame.getTxtFldAnswer().setText("");
		}
	}

	public void rqsDel() {
		int select = JOptionPane.showConfirmDialog(mainFrame, "Ҫɾ����ǰ�ĵ�����\n����Ҫɾ���ĵ����ǣ�\n" + currentWord.toString(),
				"��ǰ����Ϊ��", JOptionPane.YES_NO_OPTION);
		if (select == 0) {
			wordDao.removeWord(currentWord.getId());
			setCurrentWordRandomly();
		}

	}

	public void rqsSave() {
		wordDao.saveSource();
		JOptionPane.showMessageDialog(mainFrame, "�����յ�Ŭ���ѱ��Կ��ڴ���֮�У�", "����ɹ�", JOptionPane.INFORMATION_MESSAGE);
	}

}
