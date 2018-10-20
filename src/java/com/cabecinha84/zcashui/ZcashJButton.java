package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class ZcashJButton extends JButton {
	private Color backGroundColor = ZcashXUI.button;
	private Color textColor = ZcashXUI.text;
	public ZcashJButton() {
		super();
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJButton(Action a) {
		super(a);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJButton(Icon icon) {
		super(icon);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJButton(String text, Icon icon) {
		super(text, icon);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJButton(String text) {
		super(text);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}


	
}

