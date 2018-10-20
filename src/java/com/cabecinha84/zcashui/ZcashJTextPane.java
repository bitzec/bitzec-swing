package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class ZcashJTextPane extends JTextPane {
	private Color backGroundColor = ZcashXUI.textpane;
	public ZcashJTextPane() {
		super();
		this.setBackground(backGroundColor);
	}

	public ZcashJTextPane(StyledDocument doc) {
		super(doc);
		this.setBackground(backGroundColor);
	}

		
}

