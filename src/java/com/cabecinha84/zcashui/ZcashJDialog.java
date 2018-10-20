package com.cabecinha84.zcashui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

import javax.swing.JDialog;

public class ZcashJDialog extends JDialog {
	private Color backGroundColor = ZcashXUI.dialog;
	public ZcashJDialog() {
		super();
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Dialog owner, boolean modal) {
		super(owner, modal);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Dialog owner, String title) {
		super(owner, title);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Dialog owner) {
		super(owner);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Frame owner, boolean modal) {
		super(owner, modal);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Frame owner, String title) {
		super(owner, title);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Frame owner) {
		super(owner);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Window owner, ModalityType modalityType) {
		super(owner, modalityType);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
		super(owner, title, modalityType, gc);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Window owner, String title, ModalityType modalityType) {
		super(owner, title, modalityType);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Window owner, String title) {
		super(owner, title);
		this.setBackground(backGroundColor);
	}

	public ZcashJDialog(Window owner) {
		super(owner);
		this.setBackground(backGroundColor);
	}
		
}

