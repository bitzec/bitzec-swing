package com.cabecinha84.zcashui;

import java.awt.Color;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class ZcashJComboBox<T> extends JComboBox {
	private Color backGroundColor = ZcashXUI.combobox;
	private Color textColor = ZcashXUI.text;
	public ZcashJComboBox() {
		super();
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJComboBox(ComboBoxModel aModel) {
		super(aModel);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJComboBox(Object[] items) {
		super(items);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

	public ZcashJComboBox(Vector items) {
		super(items);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
	}

		
}

