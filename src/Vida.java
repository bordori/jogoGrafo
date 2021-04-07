import java.awt.Image;

import javax.swing.ImageIcon;

public class Vida {

	private Image imagem;
	private int x,y;
	
	public Vida() {
		ImageIcon referencia = new ImageIcon("res\\coracao2.png");
		imagem = referencia.getImage();
		imagem.getScaledInstance(25, 30, java.awt.Image.SCALE_SMOOTH);
		
	
		
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem() {
		ImageIcon referencia = new ImageIcon("res\\coracaoMorto.png");
		imagem = referencia.getImage();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
