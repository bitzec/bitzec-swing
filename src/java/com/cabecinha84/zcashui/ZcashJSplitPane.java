package com.cabecinha84.zcashui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JSplitPane;

public class ZcashJSplitPane extends JSplitPane {
	private Color backGroundColor = ZcashXUI.splitpane;
	public ZcashJSplitPane() {
		super();
		this.setBackground(backGroundColor);
	}

	public ZcashJSplitPane(int newOrientation, boolean newContinuousLayout, Component newLeftComponent,
			Component newRightComponent) {
		super(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent);
		this.setBackground(backGroundColor);
	}

	public ZcashJSplitPane(int newOrientation, boolean newContinuousLayout) {
		super(newOrientation, newContinuousLayout);
		this.setBackground(backGroundColor);
	}

	public ZcashJSplitPane(int newOrientation, Component newLeftComponent, Component newRightComponent) {
		super(newOrientation, newLeftComponent, newRightComponent);
		this.setBackground(backGroundColor);
	}

	public ZcashJSplitPane(int newOrientation) {
		super(newOrientation);
		this.setBackground(backGroundColor);
	}


	
}

