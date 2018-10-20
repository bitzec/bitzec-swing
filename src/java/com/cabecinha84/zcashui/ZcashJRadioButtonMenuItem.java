package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButtonMenuItem;

public class ZcashJRadioButtonMenuItem extends JRadioButtonMenuItem {
	private Color backGroundColor = ZcashXUI.radiobutton;

	public ZcashJRadioButtonMenuItem() {
		super();
		this.setBackground(backGroundColor);
	}

	public ZcashJRadioButtonMenuItem(Action a) {
		super(a);
		this.setBackground(backGroundColor);
	}

	public ZcashJRadioButtonMenuItem(Icon icon, boolean selected) {
		super(icon, selected);
		this.setBackground(backGroundColor);
	}

	public ZcashJRadioButtonMenuItem(Icon icon) {
		super(icon);
		this.setBackground(backGroundColor);
	}

	public ZcashJRadioButtonMenuItem(String text, boolean selected) {
		super(text, selected);
		this.setBackground(backGroundColor);
	}

	public ZcashJRadioButtonMenuItem(String text, Icon icon, boolean selected) {
		super(text, icon, selected);
		this.setBackground(backGroundColor);
	}

	public ZcashJRadioButtonMenuItem(String text, Icon icon) {
		super(text, icon);
		this.setBackground(backGroundColor);
	}

	public ZcashJRadioButtonMenuItem(String text) {
		super(text);
		this.setBackground(backGroundColor);
	}
	
}

