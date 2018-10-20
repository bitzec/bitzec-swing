package com.cabecinha84.zcashui;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class ZcashJPanel extends JPanel {
	private Color backGroundColor = ZcashXUI.panel;
	public ZcashJPanel() {
		super();
		this.setBackground(backGroundColor);
	}

	public ZcashJPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		this.setBackground(backGroundColor);
	}

	public ZcashJPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		this.setBackground(backGroundColor);
	}

	public ZcashJPanel(LayoutManager layout) {
		super(layout);
		this.setBackground(backGroundColor);
	}
	
}

