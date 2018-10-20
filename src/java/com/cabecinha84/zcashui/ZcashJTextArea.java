package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.text.Document;

public class ZcashJTextArea extends JTextArea {
	private Color backGroundColor = ZcashXUI.textarea;
	public ZcashJTextArea() {
		super();
		this.setBackground(backGroundColor);
	}

	public ZcashJTextArea(Document doc, String text, int rows, int columns) {
		super(doc, text, rows, columns);
		this.setBackground(backGroundColor);
	}

	public ZcashJTextArea(Document doc) {
		super(doc);
		this.setBackground(backGroundColor);
	}

	public ZcashJTextArea(int rows, int columns) {
		super(rows, columns);
		this.setBackground(backGroundColor);
	}

	public ZcashJTextArea(String text, int rows, int columns) {
		super(text, rows, columns);
		this.setBackground(backGroundColor);
	}

	public ZcashJTextArea(String text) {
		super(text);
		this.setBackground(backGroundColor);
	}

		
		
}

