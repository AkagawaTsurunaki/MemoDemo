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
			int select = JOptionPane.showConfirmDialog(findWordFrame, "����" + wannaFind + "�ǲ����ڵġ�\nҪ��������", "�Ҳ�������",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (select == 0) {
				NewWordController.getInstance().show();
				NewWordController.getInstance().getNewWordFrame().getTxtFldWord().setText(wannaFind);
			}
		} else if (found.size() == 1) {
			int select = JOptionPane.showConfirmDialog(findWordFrame, "���ҵ�����" + wannaFind + "��\nҪ���̰����ŵ�����������",
					"�ɹ��ҵ�����", JOptionPane.YES_NO_OPTION);
			if (select == 0) {
				DemoController.getInstance().setCurrentWord(found.get(0));
			}
		} else {
			JOptionPane.showMessageDialog(findWordFrame, "�ҵ��������Ϊ" + wannaFind + "���ʡ�", "�����ظ�",
					JOptionPane.WARNING_MESSAGE);
		}

	}
	
	// #endregion
}
