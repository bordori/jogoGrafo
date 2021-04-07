import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Personagem {

	private int x,y;
	private int larg,alt;	
	private int dx,dy;
	private Image imagem;
	private int pontos = 0;
	
	
	public Personagem() {
		ImageIcon referencia = new ImageIcon("res\\poro2.gif");
		imagem = referencia.getImage();
		
		this.x = 182;
		this.y = 150;
		this.larg = imagem.getWidth(null);
		this.alt = imagem.getHeight(null);
		
		
	}
	
	public void andar() {
		// x 1 664
		//y  4 649
		x += dx;
		y += dy;
		//System.out.println(x + " , "+y);
		if(this.x < 50 ) {
			x =50;
		}
		if(this.x > 615) {
			x=615;
		}
		if(this.y < 28) {
			y=28;
		}
		if(this.y > 639) {
			y=639;
		}
		
  		
	}
	
	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_UP) {
			setDy(-1);
		}
		if(codigo == KeyEvent.VK_DOWN) {
			setDy(1);
		}
		if(codigo == KeyEvent.VK_LEFT) {
			setDx(-1);
		}
		if(codigo == KeyEvent.VK_RIGHT) {
			setDx(1);
		}
	}
	
	public void KeyReleased(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		if(codigo == KeyEvent.VK_UP) {
			setDy(0);
		}
		if(codigo == KeyEvent.VK_DOWN) {
			setDy(0);
		}
		if(codigo == KeyEvent.VK_LEFT) {
			setDx(0);
		}
		if(codigo == KeyEvent.VK_RIGHT) {
			setDx(0);
		}
	}
	
	
	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
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
	
	public int getDx() {
		return dx;
	}
	
	public void setDx(int dx) {
		this.dx = dx;
	}
	
	public int getDy() {
		return dy;
	}
	
	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public Image getImagem() {
		return imagem;
	}
	
	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public int getLarg() {
		return larg;
	}

	public void setLarg(int larg) {
		this.larg = larg;
	}

	public int getAlt() {
		return alt;
	}

	public void setAlt(int alt) {
		this.alt = alt;
	}

	
}
