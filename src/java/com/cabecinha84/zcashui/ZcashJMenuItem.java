package com.cabecinha84.zcashui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ZcashJMenuItem extends JMenuItem {
	private Color backGroundColor = ZcashXUI.menuitem;
	private Color textColor = ZcashXUI.text;
	private final MouseListener mouseAction = new MouseAdapter() { //i use this to apply the mouse event
	    @Override
	    public void mouseEntered(MouseEvent e) {
	        ZcashJMenuItem item = (ZcashJMenuItem)e.getSource(); //is this implementation correct ?
	        item.setSelected(true);
	    };

	    @Override
	    public void mouseExited(MouseEvent e) {
	    	ZcashJMenuItem item = (ZcashJMenuItem)e.getSource(); 
	    	item.setSelected(false);
	    };
	};
	public ZcashJMenuItem() {
		super();
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
		this.addMouseListener(mouseAction);
	}

	public ZcashJMenuItem(Action a) {
		super(a);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
		this.addMouseListener(mouseAction);
	}

	public ZcashJMenuItem(Icon icon) {
		super(icon);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
		this.addMouseListener(mouseAction);
	}

	public ZcashJMenuItem(String text, Icon icon) {
		super(text, icon);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
		this.addMouseListener(mouseAction);
	}

	public ZcashJMenuItem(String text, int mnemonic) {
		super(text, mnemonic);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
		this.addMouseListener(mouseAction);
	}

	public ZcashJMenuItem(String text) {
		super(text);
		this.setBackground(backGroundColor);
		this.setForeground(textColor);
		this.addMouseListener(mouseAction);
	}

}

