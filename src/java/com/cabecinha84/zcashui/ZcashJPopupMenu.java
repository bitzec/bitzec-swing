package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.JPopupMenu;

public class ZcashJPopupMenu extends JPopupMenu {
	private Color backGroundColor = ZcashXUI.popupmenu;
	public ZcashJPopupMenu() {
		super();
		this.setBackground(backGroundColor);
	}

	public ZcashJPopupMenu(String label) {
		super(label);
		this.setBackground(backGroundColor);
	}		
}

