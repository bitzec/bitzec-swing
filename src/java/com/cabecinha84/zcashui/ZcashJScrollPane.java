package com.cabecinha84.zcashui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;

public class ZcashJScrollPane extends JScrollPane {
	private Color backGroundColor = ZcashXUI.scrollpane;
	public ZcashJScrollPane() {
		super();
		this.setBackground(backGroundColor);
	}

	public ZcashJScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
		super(view, vsbPolicy, hsbPolicy);
		this.setBackground(backGroundColor);
	}

	public ZcashJScrollPane(Component view) {
		super(view);
		this.setBackground(backGroundColor);
	}

	public ZcashJScrollPane(int vsbPolicy, int hsbPolicy) {
		super(vsbPolicy, hsbPolicy);
		this.setBackground(backGroundColor);
	}

		
}

