import java.awt.Image;

import javax.swing.ImageIcon;

public class Inimigo {

	private int x,y;
	private int larg,alt;	
	private int dx,dy;
	private Image imagem;
	private int posicao,posicaoPassada;
	
	
	public Inimigo() {
		ImageIcon referencia = new ImageIcon("res\\inimigo5.gif");
		imagem = referencia.getImage();
		
		this.x = 186;
		this.y = 232;
		this.larg = imagem.getWidth(null);
		this.alt = imagem.getHeight(null);
		
		
	}
	
	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
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


	public int getDx() {
		return dx;
	}


	public void setDx(int dx) {
		this.dx = dx;
	}


	public int getPosicaPassada() {
		return posicaoPassada;
	}

	public void setPosicaPassada(int posicaPassada) {
		this.posicaoPassada = posicaPassada;
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


	
}
