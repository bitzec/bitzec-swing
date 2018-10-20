package com.cabecinha84.zcashui;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class ZcashJFrame extends JFrame {
	private Color backGroundColor = ZcashXUI.frame;
	public ZcashJFrame() throws HeadlessException {
		super();
		this.setBackground(backGroundColor);
	}

	public ZcashJFrame(GraphicsConfiguration gc) {
		super(gc);
		this.setBackground(backGroundColor);
	}

	public ZcashJFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.setBackground(backGroundColor);
	}

	public ZcashJFrame(String title) throws HeadlessException {
		super(title);
		this.setBackground(backGroundColor);
	}
	
}

