package com.github.akagawatsurunaki.memodemo.controller;

import java.util.List;
import javax.swing.JOptionPane;
import com.github.akagawatsurunaki.memodemo.gui.FindWordFrame;
import com.github.akagawatsurunaki.memodemo.model.Word;

public class FindWordController extends Controller {

	// #region Singleton

	private static FindWordController instance = new FindWordController();

	public static FindWordController getInstance() {
		if (instance == null) {
			instance = new FindWordController();
		}
		return instance;
	}

	private FindWordController() {
	}

	// #endregion

	// #region Override Methods

	@Override
	public void invoke() {
		show();
	}

	@Override
	public void show() {
		findWordFrame = new FindWordFrame();
		findWordFrame.setVisible(true);
	}

	// #endregion

	// #region Request Methods
	
	public void rqsFind() {
		String wannaFind = findWordFrame.getTxtFldWord().getText();
		List<Word> found = wordDao.findWords(wannaFind);
		if (found.isEmpty() || found == null) {
			int select = JOptionPane.showConfirmDialog(findWordFrame, "单词" + wannaFind + "是不存在的。\n要创建它吗？", "找不到单词",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (select == 0) {
				NewWordController.getInstance().show();
				NewWordController.getInstance().getNewWordFrame().getTxtFldWord().setText(wannaFind);
			}
		} else if (found.size() == 1) {
			int select = JOptionPane.showConfirmDialog(findWordFrame, "已找到单词" + wannaFind + "。\n要立刻把它放到主界面上吗？",
					"成功找到单词", JOptionPane.YES_NO_OPTION);
			if (select == 0) {
				DemoController.getInstance().setCurrentWord(found.get(0));
			}
		} else {
			JOptionPane.showMessageDialog(findWordFrame, "找到多个内容为" + wannaFind + "单词。", "单词重复",
					JOptionPane.WARNING_MESSAGE);
		}

	}
	
	// #endregion
}
