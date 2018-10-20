package com.cabecinha84.zcashui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class ZcashJFileChooser extends JFileChooser {
	private Color backGroundColor = ZcashXUI.filechooser;
	private Color textColor = ZcashXUI.text;
	public ZcashJFileChooser() {
		super();
		this.setBackground(backGroundColor);
		changeColor(this.getComponents());
		this.setForeground(textColor);
	}

	public ZcashJFileChooser(File currentDirectory, FileSystemView fsv) {
		super(currentDirectory, fsv);
		this.setBackground(backGroundColor);
		changeColor(this.getComponents());
		this.setForeground(textColor);
	}

	public ZcashJFileChooser(File currentDirectory) {
		super(currentDirectory);
		this.setBackground(backGroundColor);
		changeColor(this.getComponents());
		this.setForeground(textColor);
	}

	public ZcashJFileChooser(FileSystemView fsv) {
		super(fsv);
		this.setBackground(backGroundColor);
		changeColor(this.getComponents());
		this.setForeground(textColor);
	}

	public ZcashJFileChooser(String currentDirectoryPath, FileSystemView fsv) {
		super(currentDirectoryPath, fsv);
		this.setBackground(backGroundColor);
		changeColor(this.getComponents());
		this.setForeground(textColor);
	}

	public ZcashJFileChooser(String currentDirectoryPath) {
		super(currentDirectoryPath);
		this.setBackground(backGroundColor);
		changeColor(this.getComponents());
		this.setForeground(textColor);
	}
	
	private void changeColor(Component[] comp)
    {
         for(int x=0; x<comp.length; x++)
         {
              try
              {
                   comp[x].setBackground(backGroundColor);
                   comp[x].setForeground(textColor);
              }
              catch(Exception e) {}
         if(comp[x] instanceof Container)
              changeColor(((Container)comp[x]).getComponents());
         }
    }
		
}

