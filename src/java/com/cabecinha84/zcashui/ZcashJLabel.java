package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;

public class ZcashJLabel extends JLabel {

	private Color textColor = ZcashXUI.text;
	
	public ZcashJLabel() {
		super();
		this.setForeground(textColor);
	}

	public ZcashJLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		this.setForeground(textColor);
	}

	public ZcashJLabel(Icon image) {
		super(image);
		this.setForeground(textColor);
	}

	public ZcashJLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		this.setForeground(textColor);
	}

	public ZcashJLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		this.setForeground(textColor);
	}

	public ZcashJLabel(String text) {
		super(text);
		this.setForeground(textColor);
	}
}

