package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.JMenuBar;

public class ZcashJMenuBar extends JMenuBar {
	private Color backGroundColor = ZcashXUI.menubar;
	private Color textColor = ZcashXUI.text;
	public ZcashJMenuBar() {
		super();
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

			
}

