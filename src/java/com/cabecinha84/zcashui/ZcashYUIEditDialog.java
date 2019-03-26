package com.cabecinha84.zcashui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.vaklinov.zcashui.LanguageUtil;
import com.vaklinov.zcashui.Log;
import com.vaklinov.zcashui.OSUtil;
import com.vaklinov.zcashui.ZCashClientCaller.WalletCallException;
import com.vaklinov.zcashui.ZCashUI;

/**
 * Dialog showing the information about a user's identity
 */
public class ZcashYUIEditDialog
	extends ZcashJDialog
{
	private static final String CURRENCYDEFAULT = "USD";
	private static final String TIER1DEFAULT = "#ffffff";
	private static final String TIER2DEFAULT = "#cceeff";
	private static final String TIER3DEFAULT = "#0069cc";
	private static final String TEXTDEFAULT = "#000000";
	
	protected ZcashJTextField tierOneColor;
	protected ZcashJTextField tierTwoColor;
	protected ZcashJTextField tierThreeColor;
	protected ZcashJTextField textColorTextField;
	protected ZcashJComboBox currencyOptions;
	
	private String currency;
	private String tier1Color;
	private String tier2Color;
	private String tier3Color;
	private String textColor;
	
	private Color color1;
	private Color color2;
	private Color color3;
	private Color colorText;
	
	private ZcashJFrame parentFrame;
	
	private static ZcashJButton defaultsButton;
	private static ZcashJButton saveButton;
	private static ZcashJButton tier1Button;
	private static ZcashJButton tier2Button;
	private static ZcashJButton tier3Button;
	private static ZcashJButton textButton;
	
	
	public ZcashYUIEditDialog(ZcashJFrame parent)
			throws UnsupportedEncodingException
	{
		parentFrame = parent;
		loadZCashUISettings();
		LanguageUtil langUtil = LanguageUtil.instance();
		this.setTitle(langUtil.getString("dialog.zcashuiedit.title"));
		this.setSize(620, 440);
	    this.setLocation(100, 100);
		this.setLocationRelativeTo(parent);
		this.setModal(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


		ZcashJPanel tempPanel = new ZcashJPanel(new BorderLayout(0, 0));
		tempPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		ZcashJLabel infoLabel = new ZcashJLabel(langUtil.getString("dialog.zcashuiedit.info"));
	    tempPanel.add(infoLabel, BorderLayout.CENTER);
		this.getContentPane().add(tempPanel, BorderLayout.NORTH);
		
		tier1Button = new ZcashJButton(langUtil.getString("dialog.zcashuiedit.selectColor"));
		tier2Button = new ZcashJButton(langUtil.getString("dialog.zcashuiedit.selectColor"));
		tier3Button = new ZcashJButton(langUtil.getString("dialog.zcashuiedit.selectColor"));
		textButton = new ZcashJButton(langUtil.getString("dialog.zcashuiedit.selectColor"));
		currencyOptions = new ZcashJComboBox<>(getAvailableCurrencys());
		currencyOptions.setSelectedItem(currency);
		
		ZcashJPanel detailsPanel = new ZcashJPanel();
		detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));

		addFormField(detailsPanel, langUtil.getString("dialog.zcashuiedit.currency"),  currencyOptions);
		addFormField(detailsPanel, langUtil.getString("dialog.zcashuiedit.textcolor"),  textColorTextField = new ZcashJTextField(7), textButton);
		addFormField(detailsPanel, langUtil.getString("dialog.zcashuiedit.tier1color"),  tierOneColor = new ZcashJTextField(7), tier1Button);
		addFormField(detailsPanel, langUtil.getString("dialog.zcashuiedit.tier2color"),  tierTwoColor = new ZcashJTextField(7), tier2Button);
		addFormField(detailsPanel, langUtil.getString("dialog.zcashuiedit.tier3color"),  tierThreeColor = new ZcashJTextField(7), tier3Button);

		textColorTextField.setText(textColor);
		tierOneColor.setText(tier1Color);
		tierTwoColor.setText(tier2Color);
		tierThreeColor.setText(tier3Color);
		textColorTextField.setEditable(false);;
		tierOneColor.setEditable(false);
		tierTwoColor.setEditable(false);
		tierThreeColor.setEditable(false);
		textColorTextField.setForeground(colorText);
		tierOneColor.setBackground(color1);
		tierTwoColor.setBackground(color2);
		tierThreeColor.setBackground(color3);
		detailsPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.getContentPane().add(detailsPanel, BorderLayout.CENTER);
	

		ZcashJPanel closePanel = new ZcashJPanel();
		closePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
		ZcashJButton closeButon = new ZcashJButton(langUtil.getString("dialog.about.button.close.text"));
		closePanel.add(closeButon);
		defaultsButton = new ZcashJButton(langUtil.getString("dialog.zcashuiedit.setDefaults"));
		closePanel.add(defaultsButton);
		saveButton = new ZcashJButton(langUtil.getString("dialog.zcashuiedit.save"));
		closePanel.add(saveButton);

		this.getContentPane().add(closePanel, BorderLayout.SOUTH);
		
		closeButon.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					ZcashYUIEditDialog.this.parentFrame.repaint();
					ZcashYUIEditDialog.this.setVisible(false);
					ZcashYUIEditDialog.this.dispose();
				}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				ZcashYUIEditDialog.this.saveZCashUISettings();			
				new ZcashXUI();
				try {
					ZCashUI z = new ZCashUI(null);
					ZcashYUIEditDialog.this.parentFrame.setVisible(false);
					ZcashYUIEditDialog.this.parentFrame.dispose();
					ZcashYUIEditDialog.this.parentFrame = z;	
					ZcashYUIEditDialog.this.parentFrame.repaint();
					ZcashYUIEditDialog.this.parentFrame.setVisible(true);
					ZcashYUIEditDialog dialog = new ZcashYUIEditDialog(ZcashYUIEditDialog.this.parentFrame);
					ZcashYUIEditDialog.this.setVisible(false);
					ZcashYUIEditDialog.this.dispose();
					dialog.setVisible(true);
				}
				catch (WalletCallException wce)
		        {
		        	Log.error("Unexpected error: ", wce);

		            if ((wce.getMessage().indexOf("{\"code\":-28,\"message\"") != -1) ||
		            	(wce.getMessage().indexOf("error code: -28") != -1))
		            {
		                JOptionPane.showMessageDialog(
		                        null,
		                        LanguageUtil.instance().getString("main.frame.option.pane.wallet.communication.error.text"),
		                        LanguageUtil.instance().getString("main.frame.option.pane.wallet.communication.error.title"),
		                        JOptionPane.ERROR_MESSAGE);
		            } else
		            {
		                JOptionPane.showMessageDialog(
		                    null,
		                        LanguageUtil.instance().getString("main.frame.option.pane.wallet.communication.error.2.text", wce.getMessage()),
		                        LanguageUtil.instance().getString("main.frame.option.pane.wallet.communication.error.2.title"),
		                    JOptionPane.ERROR_MESSAGE);
		            }

		            System.exit(2);
		        } catch (Exception ex)
		        {
		        	Log.error("Unexpected error: ", ex);
		            JOptionPane.showMessageDialog(
		                null,
		                LanguageUtil.instance().getString("main.frame.option.pane.wallet.critical.error.text", ex.getMessage()),
		                LanguageUtil.instance().getString("main.frame.option.pane.wallet.critical.error.title"),
		                JOptionPane.ERROR_MESSAGE);
		            System.exit(3);
		        } catch (Error err)
		        {
		        	// Last resort catch for unexpected problems - just to inform the user
		            err.printStackTrace();
		            JOptionPane.showMessageDialog(
		                null,
		                    LanguageUtil.instance().getString("main.frame.option.pane.wallet.critical.error.2.text", err.getMessage()),
		                    LanguageUtil.instance().getString("main.frame.option.pane.wallet.critical.error.2.title"),
		                    JOptionPane.ERROR_MESSAGE);
		            System.exit(4);
		        }
				saveButton.setSelected(false);
				saveButton.setFocusable(false);
			}
		});
		
		
		defaultsButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				currency = CURRENCYDEFAULT;
				currencyOptions.setSelectedItem(currency);
				tier1Color = TIER1DEFAULT;
				tier2Color = TIER2DEFAULT;
				tier3Color = TIER3DEFAULT;
				textColor = TEXTDEFAULT;
				color1 = Color.decode(tier1Color);
				color2 = Color.decode(tier2Color);
				color3 = Color.decode(tier3Color);
				colorText = Color.decode(textColor);
				tierOneColor.setBackground(color1);
				tierTwoColor.setBackground(color2);
				tierThreeColor.setBackground(color3);
				textColorTextField.setForeground(colorText);
				ZcashYUIEditDialog.this.saveZCashUISettings();			
				new ZcashXUI();
				try {
					ZCashUI z = new ZCashUI(null);
					ZcashYUIEditDialog.this.parentFrame.setVisible(false);
					ZcashYUIEditDialog.this.parentFrame.dispose();
					ZcashYUIEditDialog.this.parentFrame = z;	
					ZcashYUIEditDialog.this.parentFrame.repaint();
					ZcashYUIEditDialog.this.parentFrame.setVisible(true);
					ZcashYUIEditDialog dialog = new ZcashYUIEditDialog(ZcashYUIEditDialog.this.parentFrame);
					ZcashYUIEditDialog.this.setVisible(false);
					ZcashYUIEditDialog.this.dispose();
					dialog.setVisible(true);
				}
				catch (WalletCallException wce)
		        {
		        	Log.error("Unexpected error: ", wce);

		            if ((wce.getMessage().indexOf("{\"code\":-28,\"message\"") != -1) ||
		            	(wce.getMessage().indexOf("error code: -28") != -1))
		            {
		                JOptionPane.showMessageDialog(
		                        null,
		                        LanguageUtil.instance().getString("main.frame.option.pane.wallet.communication.error.text"),
		                        LanguageUtil.instance().getString("main.frame.option.pane.wallet.communication.error.title"),
		                        JOptionPane.ERROR_MESSAGE);
		            } else
		            {
		                JOptionPane.showMessageDialog(
		                    null,
		                        LanguageUtil.instance().getString("main.frame.option.pane.wallet.communication.error.2.text", wce.getMessage()),
		                        LanguageUtil.instance().getString("main.frame.option.pane.wallet.communication.error.2.title"),
		                    JOptionPane.ERROR_MESSAGE);
		            }

		            System.exit(2);
		        } catch (Exception ex)
		        {
		        	Log.error("Unexpected error: ", ex);
		            JOptionPane.showMessageDialog(
		                null,
		                LanguageUtil.instance().getString("main.frame.option.pane.wallet.critical.error.text", ex.getMessage()),
		                LanguageUtil.instance().getString("main.frame.option.pane.wallet.critical.error.title"),
		                JOptionPane.ERROR_MESSAGE);
		            System.exit(3);
		        } catch (Error err)
		        {
		        	// Last resort catch for unexpected problems - just to inform the user
		            err.printStackTrace();
		            JOptionPane.showMessageDialog(
		                null,
		                    LanguageUtil.instance().getString("main.frame.option.pane.wallet.critical.error.2.text", err.getMessage()),
		                    LanguageUtil.instance().getString("main.frame.option.pane.wallet.critical.error.2.title"),
		                    JOptionPane.ERROR_MESSAGE);
		            System.exit(4);
		        }
				defaultsButton.setSelected(false);
				defaultsButton.setFocusable(false);
			}
		});
		
		textButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Color color = ZcashJColorChooser.showDialog(ZcashYUIEditDialog.this, "Pick Color", colorText);
				ZcashYUIEditDialog.this.repaint();
				ZcashYUIEditDialog.this.parentFrame.repaint();
				if(color == null) {
					colorText = Color.decode(textColor);
				}
				else {
					textColor = toHexString(color);
					textColorTextField.setForeground(color);
				}
				textButton.setSelected(false);
				textButton.setFocusable(false);
				
			}
		});
		
		tier1Button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Color color = ZcashJColorChooser.showDialog(ZcashYUIEditDialog.this, "Pick Color", color1);
				ZcashYUIEditDialog.this.repaint();
				ZcashYUIEditDialog.this.parentFrame.repaint();
				if(color == null) {
                    color1 = Color.decode(tier1Color);
				}
				else {
					tier1Color = toHexString(color);
					tierOneColor.setBackground(color);
				}
				tier1Button.setSelected(false);
				tier1Button.setFocusable(false);
			}
		});
		
		tier2Button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Color color = ZcashJColorChooser.showDialog(ZcashYUIEditDialog.this, "Pick Color", color2);
				ZcashYUIEditDialog.this.repaint();
				ZcashYUIEditDialog.this.parentFrame.repaint();
				if(color == null) {
                    color2 = Color.decode(tier2Color);
				}
				else {
					tier2Color = toHexString(color);
					tierTwoColor.setBackground(color);
				}
				tier2Button.setSelected(false);
				tier2Button.setFocusable(false);
			}
		});
		
		tier3Button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Color color = ZcashJColorChooser.showDialog(ZcashYUIEditDialog.this, "Pick Color", color3);
				ZcashYUIEditDialog.this.repaint();
				ZcashYUIEditDialog.this.parentFrame.repaint();
				if(color == null) {
                    color3 = Color.decode(tier3Color);
				}
				else {
					tier3Color = toHexString(color);
					tierThreeColor.setBackground(color);
				}
				tier3Button.setSelected(false);
				tier3Button.setFocusable(false);
			}
		});
		
		pack();
	}
	
	public final static String toHexString(Color colour) throws NullPointerException {
		  String hexColour = Integer.toHexString(colour.getRGB() & 0xffffff);
		  if (hexColour.length() < 6) {
		    hexColour = "000000".substring(0, 6 - hexColour.length()) + hexColour;
		  }
		  return "#" + hexColour;
		}
	
	private void addFormField(ZcashJPanel detailsPanel, String name, JComponent field, ZcashJButton button)
	{
		ZcashJPanel tempPanel = new ZcashJPanel(new FlowLayout(FlowLayout.LEFT, 4, 2));
		ZcashJLabel tempLabel = new ZcashJLabel(name, JLabel.RIGHT);
		// TODO: hard sizing of labels may not scale!
		final int width = new ZcashJLabel("Sender identiication T address:").getPreferredSize().width + 10;
		tempLabel.setPreferredSize(new Dimension(width, tempLabel.getPreferredSize().height));
		tempPanel.add(tempLabel);
		tempPanel.add(field);
		tempPanel.add(button);
		detailsPanel.add(tempPanel);
	}
	
	private void addFormField(ZcashJPanel detailsPanel, String name, JComponent field)
	{
		ZcashJPanel tempPanel = new ZcashJPanel(new FlowLayout(FlowLayout.LEFT, 4, 2));
		ZcashJLabel tempLabel = new ZcashJLabel(name, JLabel.RIGHT);
		// TODO: hard sizing of labels may not scale!
		final int width = new ZcashJLabel("Sender identiication T address:").getPreferredSize().width + 10;
		tempLabel.setPreferredSize(new Dimension(width, tempLabel.getPreferredSize().height));
		tempPanel.add(tempLabel);
		tempPanel.add(field);
		detailsPanel.add(tempPanel);
	}
	

	private void loadZCashUISettings() {
		try {
			
			String settingsDir = OSUtil.getSettingsDirectory();
			File zcashConf = new File(settingsDir + File.separator + "zcash_ui.properties");
			if (!zcashConf.exists())
			{
				Log.error("Could not find file: {0} !", zcashConf.getAbsolutePath());
				
			} 
			Log.info("File zcash_ui.properties found");
			Properties confProps = new Properties();
			FileInputStream fis = null;
			try
			{
				Log.info("Lets parse all the ui settings");
				fis = new FileInputStream(zcashConf);
				confProps.load(fis);
				textColor = confProps.getProperty(ZcashXUI.TEXT_PROPERTY_COLOR)!= null? confProps.getProperty(ZcashXUI.TEXT_PROPERTY_COLOR).trim():ZcashXUI.DEFAULT_COLOR_BLACK; 
				tier1Color = confProps.getProperty(ZcashXUI.FRAME_PROPERTY_COLOR)!= null? confProps.getProperty(ZcashXUI.FRAME_PROPERTY_COLOR).trim():ZcashXUI.DEFAULT_COLOR; 
				tier2Color = confProps.getProperty(ZcashXUI.TABLE_HEADER_PROPERTY_COLOR)!= null? confProps.getProperty(ZcashXUI.TABLE_HEADER_PROPERTY_COLOR).trim():ZcashXUI.DEFAULT_COLOR; 
				tier3Color = confProps.getProperty(ZcashXUI.PROGRESSBAR_FOREGROUND_PROPERTY_COLOR)!= null? confProps.getProperty(ZcashXUI.PROGRESSBAR_FOREGROUND_PROPERTY_COLOR).trim():ZcashXUI.DEFAULT_COLOR; 
				currency = confProps.getProperty(ZcashXUI.CURRENCY)!= null? confProps.getProperty(ZcashXUI.CURRENCY).toUpperCase().trim():ZcashXUI.DEFAULT_CURRENCY; 
				color1 = Color.decode(tier1Color);
				color2 = Color.decode(tier2Color);
				color3 = Color.decode(tier3Color);
				colorText = Color.decode(textColor);
				
			} finally
			{
				if (fis != null)
				{
					fis.close();
				}
			}
		}
		catch(Exception e) {
			Log.warning("Error obtaining properties from zcash_ui.properties file due to: {0} {1}",
					e.getClass().getName(), e.getMessage());
		}	
	}

	private void saveZCashUISettings() {
		try {
			
			String settingsDir = OSUtil.getSettingsDirectory();
			File zcashConf = new File(settingsDir + File.separator + "zcash_ui.properties");
			if (!zcashConf.exists())
			{
				Log.error("Could not find file: {0} !", zcashConf.getAbsolutePath());
				
			} 
			Log.info("File zcash_ui.properties found");
			Properties confProps = new Properties();
			FileInputStream fis = null;
			FileOutputStream fr = null;  
	        
			try
			{
				Log.info("Lets parse all the ui settings");
				fis = new FileInputStream(zcashConf);
				fr = new FileOutputStream(zcashConf);
				confProps.load(fis);
				confProps.setProperty(ZcashXUI.BUTTON_PROPERTY_COLOR, tier2Color);
				confProps.setProperty(ZcashXUI.BUTTON_SELECT_PROPERTY_COLOR, tier2Color); 
				confProps.setProperty(ZcashXUI.CHECKBOX_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.CHECKBOX_SELECT_PROPERTY_COLOR, tier2Color);
				confProps.setProperty(ZcashXUI.COLORCHOOSER_PROPERTY_COLOR, tier1Color);
				confProps.setProperty(ZcashXUI.COMBOBOX_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.CONTAINER_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.DIALOG_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.FILECHOOSER_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.FRAME_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.LIST_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.MENU_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.MENU_SELECTION_PROPERTY_COLOR, tier2Color); 
				confProps.setProperty(ZcashXUI.MENUBAR_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.MENUITEM_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.MENUITEM_SELECTION_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.PANEL_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.PASSWORDFIELD_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.POPUPMENU_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.PRESENTATIONPANEL_PROPERTY_COLOR, tier2Color); 
				confProps.setProperty(ZcashXUI.PRESENTATIONPANEL_BORDER_PROPERTY_COLOR, tier2Color); 
				confProps.setProperty(ZcashXUI.PROGRESSBAR_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.PROGRESSBAR_FOREGROUND_PROPERTY_COLOR, tier3Color); 
				confProps.setProperty(ZcashXUI.RADIOBUTTON_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.SCROLLBAR_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.SCROLLBAR_FOREGROUND_PROPERTY_COLOR, tier3Color); 
				confProps.setProperty(ZcashXUI.SCROLLBAR_THUMB_PROPERTY_COLOR, tier3Color); 
				confProps.setProperty(ZcashXUI.SCROLLPANE_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.SPLITPANE_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.STARTUP_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.TABBEDPANE_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.TABBEDPANE_UNSELECTED_PROPERTY_COLOR, tier2Color); 
				confProps.setProperty(ZcashXUI.TABLE_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.TABLE_HEADER_PROPERTY_COLOR, tier2Color); 
				confProps.setProperty(ZcashXUI.TEXTAREA_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.TEXTFIELD_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.TEXTPANE_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.TOOLTIP_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.VIEWPORT_PROPERTY_COLOR, tier1Color); 
				confProps.setProperty(ZcashXUI.TEXT_PROPERTY_COLOR, textColor); 
				confProps.setProperty(ZcashXUI.CURRENCY, currencyOptions.getSelectedItem().toString());  
				confProps.store(fr, "Save zcash_ui.properties file");
				
			} finally
			{
				if (fr != null) {
					fr.close();
				}
				if (fis != null)
				{
					fis.close();
				}
			}
		}
		catch(Exception e) {
			Log.warning("Error obtaining properties from zcash_ui.properties file due to: {0} {1}",
					e.getClass().getName(), e.getMessage());
		}	
	}
	
	private String[] getAvailableCurrencys() {
		String[] currencys = null;
		try {
			URL u = new URL("https://rates.zec.zeltrez.io");
			Reader r = new InputStreamReader(u.openStream(), "UTF-8");
			JsonArray ar = Json.parse(r).asArray();
			currencys = new String[ar.size()];
			for (int i = 0; i < ar.size(); ++i) {
				JsonObject obj = ar.get(i).asObject();
				String currency = obj.get("code").toString().replaceAll("\"", "");
				currencys[i] = currency;
				
			}
			Arrays.sort(currencys);
		} catch (Exception ioe) {
			Log.warning("Could not obtain BZCinformation from rates.zec.zeltrez.io due to: {0} {1}",
					ioe.getClass().getName(), ioe.getMessage());
		}
		return currencys;

	}
	
	public void restartApplication() throws URISyntaxException, IOException
	{
	  final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
	  final File currentJar = new File(ZCashUI.class.getProtectionDomain().getCodeSource().getLocation().toURI());

	  /* is it a jar file? */
	  if(!currentJar.getName().endsWith(".jar"))
	    return;

	  /* Build command: java -jar application.jar */
	  final ArrayList<String> command = new ArrayList<String>();
	  command.add(javaBin);
	  command.add("-jar");
	  command.add(currentJar.getPath());

	  final ProcessBuilder builder = new ProcessBuilder(command);
	  builder.start();
	  System.exit(0);
	}
	
} // End public class ZcashYUIEditDialog
