package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.JMenu;

public class ZcashJMenu extends JMenu {
	private Color backGroundColor = ZcashXUI.menu;
	private Color textColor = ZcashXUI.text;
	public ZcashJMenu() {
		super();
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJMenu(Action a) {
		super(a);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJMenu(String s, boolean b) {
		super(s, b);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJMenu(String s) {
		super(s);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	
	
}

