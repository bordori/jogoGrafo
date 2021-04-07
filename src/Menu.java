import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class Menu extends JPanel {
	
	
	private JLabel texto,texto2,texto3,texto4;
	private JButton btnVoltar;
	private Janelas janelas;
	
	
	public Menu() {
		setBackground(SystemColor.text);
		setForeground(Color.WHITE);
		janelas = new Janelas(this,700,480);
		setLayout(null);
	
		MontarLayoult();
	}

	private void MontarLayoult() {
		
		setLayout(null);
		
		JButton button = new JButton("START GAME");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Mapa();
				janelas.dispose();
				
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		button.setBackground(UIManager.getColor("Button.background"));
		button.setBounds(271, 172, 150, 50);
		add(button);
		
		JButton btnOption = new JButton("OBJETIVO");
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				removeAll();
				repaint();
				add(texto);
				add(texto2);
				add(texto3);
				add(texto4);
				add(btnVoltar);
				
			}
		});
		btnOption.setForeground(Color.BLACK);
		btnOption.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnOption.setBackground(UIManager.getColor("Button.background"));
		btnOption.setBounds(271, 233, 150, 50);
		add(btnOption);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setBounds(271, 294, 150, 50);
		add(btnExit);
		
		JLabel lblNewLabel = new JLabel("Feed the Poro");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 68));
		lblNewLabel.setBounds(0, 11, 700, 100);
		add(lblNewLabel);
		
		texto = new JLabel();
		texto.setText(" Objetivo: Pegar o bolinho mais ");
		//texto.setHorizontalAlignment(SwingConstants.TOP);
		texto.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		texto.setBounds(0, 0, 700, 50);
		
		texto2 = new JLabel();
		texto2.setText(" rapido do que seu inimigo.");
		//texto.setHorizontalAlignment(SwingConstants.TOP);
		texto2.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		texto2.setBounds(0, 50, 700, 50);
		
		texto3 = new JLabel();
		texto3.setText(" Controles: Use as setas direcionais");
		//texto.setHorizontalAlignment(SwingConstants.TOP);
		texto3.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		texto3.setBounds(0, 150, 700, 50);
		
		texto4 = new JLabel();
		texto4.setText(" para movimentar o poro.");
		//texto.setHorizontalAlignment(SwingConstants.TOP);
		texto4.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		texto4.setBounds(0, 200, 700, 50);
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				MontarLayoult();
				
			}
		});
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnVoltar.setBackground(UIManager.getColor("Button.background"));
		btnVoltar.setBounds(500, 380, 150, 50);
		
		
		
		repaint();
		
		
		
		
	}
}
