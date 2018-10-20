package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.text.Document;

public class ZcashJPasswordField extends JPasswordField {
	private Color backGroundColor = ZcashXUI.passwordfield;
	private Color textColor = ZcashXUI.text;
	public ZcashJPasswordField() {
		super();
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJPasswordField(Document doc, String txt, int columns) {
		super(doc, txt, columns);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJPasswordField(int columns) {
		super(columns);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJPasswordField(String text, int columns) {
		super(text, columns);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJPasswordField(String text) {
		super(text);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

		
}

