package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;

public class ZcashJCheckBox extends JCheckBox {
	private Color backGroundColor = ZcashXUI.checkbox;
	private Color textColor = ZcashXUI.text;
	public ZcashJCheckBox() {
		super();
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJCheckBox(Action a) {
		super(a);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJCheckBox(Icon icon, boolean selected) {
		super(icon, selected);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJCheckBox(Icon icon) {
		super(icon);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJCheckBox(String text, boolean selected) {
		super(text, selected);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJCheckBox(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJCheckBox(String text, Icon icon) {
		super(text, icon);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJCheckBox(String text) {
		super(text);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

		
}

