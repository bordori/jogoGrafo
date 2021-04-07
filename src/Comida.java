import java.awt.Image;

import javax.swing.ImageIcon;

public class Comida {

	private Boolean tem=false;
	private int x,y;
	private int larg,alt;	
	private int posicao;
	private Image imagem;
	
	
	public Comida() {
		ImageIcon referencia = new ImageIcon("res\\comida3.gif");
		imagem = referencia.getImage();
		
		this.x = 186;
		this.y = 232;
		this.larg = imagem.getWidth(null);
		this.alt = imagem.getHeight(null);
		
		
	}
	
	public Boolean getTem() {
		return tem;
	}

	public void setTem(Boolean tem) {
		this.tem = tem;
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


	


	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public Image getImagem() {
		return imagem;
	}


	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}


	

}
