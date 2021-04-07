import java.awt.Component;

import javax.swing.JFrame;

public class Janelas extends JFrame{
	
	
	public Janelas(Component tela,int l , int a) {
		
		add( tela);
		setTitle("Nome do jogo");
		setSize (l,a);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	
		
	}
	public void setTamanho(int l, int a) {
		 setSize(l,a);
	}
	
	
}
