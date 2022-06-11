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
			MemoDemoException me = new MemoDemoException("MemoDemo关键性停止",  "MemoDemo意外地遇到了关键性错误，\n必须立刻关闭本程序。\n异常信息：" + e.getMessage());
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
			mainFrame.getBtnhideOrShow().setText("隐藏英文单词");
		} else {
			mainFrame.getCenterWordTextPane().setText(currentWord.toMeaningString());
			mainFrame.getBtnhideOrShow().setText("显示英文单词");
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
			JOptionPane.showMessageDialog(mainFrame, "没有要拼写的单词。", "当前单词为空", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if(mainFrame.getTxtFldAnswer().getText().isEmpty()) {
			JOptionPane.showMessageDialog(mainFrame, "您还没有拼写！", "答题栏无输入", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		boolean flag = wordDao.isCorrectAnswer(mainFrame.getTxtFldAnswer().getText(), currentWord);

		if (flag) {
			currentWord.setAnswerCount(true);
			JOptionPane.showMessageDialog(mainFrame, "真棒！\n这个单词已经答对了" + currentWord.getCorrectAnswerCount() + "次！",
					"单词拼写正确", JOptionPane.INFORMATION_MESSAGE);
			setCurrentWordRandomly(currentWord);
		} else {
			currentWord.setAnswerCount(false);
			JOptionPane
					.showMessageDialog(mainFrame,
							"拼错啦，再想想？你一定可以的！\n本单词已经拼写" + currentWord.getAnswerCount() + "次，\n您总共答错了"
									+ currentWord.getWrongAnswerCount() + "次",
							"单词拼写错误", JOptionPane.INFORMATION_MESSAGE);
			mainFrame.getTxtFldAnswer().setText("");
		}
	}

	public void rqsDel() {
		int select = JOptionPane.showConfirmDialog(mainFrame, "要删除当前的单词吗？\n您将要删除的单词是：\n" + currentWord.toString(),
				"当前单词为空", JOptionPane.YES_NO_OPTION);
		if (select == 0) {
			wordDao.removeWord(currentWord.getId());
			setCurrentWordRandomly();
		}

	}

	public void rqsSave() {
		wordDao.saveSource();
		JOptionPane.showMessageDialog(mainFrame, "您今日的努力已被镌刻于磁盘之中！", "保存成功", JOptionPane.INFORMATION_MESSAGE);
	}

}
