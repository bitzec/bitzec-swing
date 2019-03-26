package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class ZcashJTextField extends JTextField {
	private Color backGroundColor = ZcashXUI.textarea;
	private Color textColor = ZcashXUI.text;
	public ZcashJTextField() {
		super();
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJTextField(int columns) {
		super(columns);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJTextField(String text, int columns) {
		super(text, columns);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJTextField(String text) {
		super(text);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	
		
}

