package com.cabecinha84.zcashui;

import java.awt.Color;

import javax.swing.BoundedRangeModel;
import javax.swing.JProgressBar;

public class ZcashJProgressBar extends JProgressBar {
	private Color backGroundColor = ZcashXUI.progressbar;
	private Color foreGroundColor = ZcashXUI.progressbarForeground;
	public ZcashJProgressBar() {
		super();
		this.setBackground(backGroundColor);
		this.setForeground(foreGroundColor);
	}

	public ZcashJProgressBar(BoundedRangeModel newModel) {
		super(newModel);
		this.setBackground(backGroundColor);
		this.setForeground(foreGroundColor);
	}

	public ZcashJProgressBar(int orient, int min, int max) {
		super(orient, min, max);
		this.setBackground(backGroundColor);
		this.setForeground(foreGroundColor);
	}

	public ZcashJProgressBar(int min, int max) {
		super(min, max);
		this.setBackground(backGroundColor);
		this.setForeground(foreGroundColor);
	}

	public ZcashJProgressBar(int orient) {
		super(orient);
		this.setBackground(backGroundColor);
		this.setForeground(foreGroundColor);
	}

		
}

