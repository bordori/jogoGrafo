import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Mapa extends JPanel implements ActionListener{
	
	private Image fundo;
	private Personagem ps;
	private Timer timer;
	private Janelas janelas = new Janelas(this,700,720);
	private Rectangle a,b,c,d,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,comidaBox;
	private AudioClip audio;
	private Vida vida1,vida2,vida3,vida4,vida5;
	private MenorCaminho grafo ;
	private Inimigo inimigo = new Inimigo();
	private Comida comida = new Comida();
	private ArrayList<Integer> noX = new ArrayList<Integer>();
	private ArrayList<Integer> noY = new ArrayList<Integer>();
	private int numeroVidas = 0;
	private Boolean first = true;
	
	
	public Mapa() {
		montarPosicaoNo();
		inimigo.setX(noX.get(0));
		inimigo.setY(noY.get(0));
		inimigo.setPosicao(0);
		montarGrafo();
		setComida();
		andarInimigo();
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());
		ImageIcon referencia = new ImageIcon("res\\Mapa2.png");
		fundo = referencia.getImage();
		ps = new Personagem();
		vida1 = new Vida();
		vida2 = new Vida();
		vida3 = new Vida();
		vida4 = new Vida();
		vida5 = new Vida();
		timer = new Timer(5,this);
		setLayout(null);
		
		
		
		timer.start();
		MontadorParede();
		play("musica2");
		
		
	}
	
	private void montarGrafo(){
		try {
			grafo = new MenorCaminho(31);
			grafo.insertArc(0,1,111);
			grafo.insertArc(0,10,130);
			grafo.insertArc(0,4,48);
			grafo.insertArc(1,0,111);
			grafo.insertArc(1,2,103);
			grafo.insertArc(2,1,103);
			grafo.insertArc(2,5,159);
			grafo.insertArc(2,3,269);
			grafo.insertArc(3,2,269);
			grafo.insertArc(3,8,159);
			grafo.insertArc(4,0,48);
			grafo.insertArc(4,5,103);
			grafo.insertArc(4,12,94);
			grafo.insertArc(5,4,103);
			grafo.insertArc(5,2,159);
			grafo.insertArc(5,6,111);
			grafo.insertArc(6,5,111);
			grafo.insertArc(6,15,147);
			grafo.insertArc(6,7,90);
			grafo.insertArc(7,6,90);
			grafo.insertArc(7,8,68);
			grafo.insertArc(7,16,147);
			grafo.insertArc(8,7,68);
			grafo.insertArc(8,3,159);
			grafo.insertArc(8,9,55);
			grafo.insertArc(9,8,55);
			grafo.insertArc(9,17,147);
			grafo.insertArc(10,0,130);
			grafo.insertArc(10,11,142);
			grafo.insertArc(11,10,142);
			grafo.insertArc(11,12,130);
			grafo.insertArc(11,18,195);
			grafo.insertArc(12,11,130);
			grafo.insertArc(12,4,94);
			grafo.insertArc(12,13,53);
			grafo.insertArc(13,12,53);
			grafo.insertArc(13,19,142);
			grafo.insertArc(13,14,158);
			grafo.insertArc(14,13,158);
			grafo.insertArc(14,15,56);
			grafo.insertArc(14,20,142);
			grafo.insertArc(15,14,56);
			grafo.insertArc(15,6,147);
			grafo.insertArc(15,16,90);
			grafo.insertArc(16,15,90);
			grafo.insertArc(16,7,147);
			grafo.insertArc(16,17,123);
			grafo.insertArc(16,21,142);
			grafo.insertArc(17,16,123);
			grafo.insertArc(17,9,147);
			grafo.insertArc(17,22,142);
			grafo.insertArc(18,11,195);
			grafo.insertArc(18,19,130);
			grafo.insertArc(18,23,42);
			grafo.insertArc(19,18,130);
			grafo.insertArc(19,13,142);
			grafo.insertArc(19,20,158);
			grafo.insertArc(20,19,158);
			grafo.insertArc(20,14,142);
			grafo.insertArc(20,21,146);
			grafo.insertArc(20,26,148);
			grafo.insertArc(21,20,146);
			grafo.insertArc(21,16,142);
			grafo.insertArc(21,29,59);
			grafo.insertArc(22,17,142);
			grafo.insertArc(22,29,64);
			grafo.insertArc(22,30,101);
			grafo.insertArc(23,18,42);
			grafo.insertArc(23,24,106);
			grafo.insertArc(24,23,106);
			grafo.insertArc(24,25,106);
			grafo.insertArc(25,24,106);
			grafo.insertArc(25,26,180);
			grafo.insertArc(26,25,180);
			grafo.insertArc(26,20,148);
			grafo.insertArc(26,27,205);
			grafo.insertArc(27,26,205);
			grafo.insertArc(27,28,47);
			grafo.insertArc(28,27,47);
			grafo.insertArc(28,30,64);
			grafo.insertArc(28,29,101);
			grafo.insertArc(29,28,101);
			grafo.insertArc(29,21,59);
			grafo.insertArc(29,22,64);
			grafo.insertArc(30,28,64);
			grafo.insertArc(30,22,101);
			
			
			//System.out.println("Menor caminho entre 0 e 30 "+grafo.dijkistra(0,30 ));             
	            //grafo.printMatriz(grafo.getMatrizDePesos());
	           
			
		} catch (Exception e) {
			if(e.getMessage() == null) 
                System.out.println("Ocorreu um erro de "+e+" no main"); 
          else  
              System.out.println(e.getMessage()+"XXX"); 
		}
	}

	private void montarPosicaoNo()
	{
		noX.add(191);//0
		noY.add(145);
		
		noX.add(191);//1
		noY.add(28);
		
		noX.add(297);//2
		noY.add(28);
		
		noX.add(564);//3
		noY.add(28);
		
		noX.add(191);//4
		noY.add(195);
		
		noX.add(297);//5
		noY.add(195);
		
		noX.add(403);//6
		noY.add(195);
		
		noX.add(494);//7
		noY.add(195);
		
		noX.add(564);//8
		noY.add(195);
		
		noX.add(615);//9
		noY.add(195);
		
		noX.add(62);//10
		noY.add(145);
		
		noX.add(62);//11
		noY.add(285);
		
		noX.add(191);//12
		noY.add(285);
		
		noX.add(191);//13
		noY.add(335);
		
		noX.add(351);//14
		noY.add(335);
		
		noX.add(403);//15
		noY.add(335);
		
		noX.add(494);//16
		noY.add(335);
		
		noX.add(615);//17
		noY.add(335);
		
		noX.add(62);//18
		noY.add(482);
		
		noX.add(191);//19
		noY.add(482);
		
		noX.add(351);//20
		noY.add(482);
		
		noX.add(494);//21
		noY.add(482);
		
		noX.add(615);//22
		noY.add(482);
		
		noX.add(62);//23
		noY.add(515);
		
		noX.add(170);//24
		noY.add(515);
		
		noX.add(170);//25
		noY.add(621);
		
		noX.add(351);//26
		noY.add(621);
		
		noX.add(551);//27
		noY.add(621);
		
		noX.add(551);//28
		noY.add(582);
		
		noX.add(555);//29
		noY.add(482);
		
		noX.add(615);//30
		noY.add(582);
	}

	public void play(String nomeDoAudio) {
		URL url = getClass().getResource(nomeDoAudio+".wav");
		audio = Applet.newAudioClip(url);
		audio.play();
	}
	
	public void MontadorParede() {
		a = new Rectangle(54,33,127,107);
		b = new Rectangle(236,70,47,120);
		c = new Rectangle(340,70,165,120);
		d = new Rectangle(533,120,20,70);
		//f = new Rectangle(558,66,1,23);
		g = new Rectangle(105,185,75,100);
		h = new Rectangle(236,234,150,97);
		i = new Rectangle(453,234,28,97);
		j = new Rectangle(539,234,63,97);
		k = new Rectangle(105,335,75,120);
		l = new Rectangle(235,380,99,100);
		m = new Rectangle(395,380,82,95);
		n = new Rectangle(545,380,57,97);
		o = new Rectangle(610,33,11,155);
		p = new Rectangle(54,563,100,87);
		q = new Rectangle(109,523,225,1);
		r = new Rectangle(213,541,121,80);
		s = new Rectangle(395,530,138,92);
		t = new Rectangle(598,530,6,52);
		u = new Rectangle(598,623,55,40);
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo,0,0,null);
		graficos.drawImage(ps.getImagem(), ps.getX(), ps.getY(), this);
		graficos.drawImage(inimigo.getImagem(), inimigo.getX(), inimigo.getY(), null);
		graficos.drawImage(comida.getImagem(),comida.getX()+5,comida.getY()+15,null );
		graficos.drawImage(vida1.getImagem(), 10, 10, null);
		graficos.drawImage(vida2.getImagem(), 45, 10, null);
		graficos.drawImage(vida3.getImagem(), 80, 10, null);
		graficos.drawImage(vida4.getImagem(), 115, 10, null);
		graficos.drawImage(vida5.getImagem(), 150, 10, null);
		graficos.setFont(new Font("Arial",1, 22));
		graficos.drawString("PONTOS : "+ ps.getPontos(),10,80);
		g.dispose();
	}
	
	private void andarInimigo() {
		new Thread() {
			
			
			
			public void run() {
				
				List<Integer> percurso = new ArrayList<Integer>();
				while(comida.getTem() != false) {
					try {
						
						grafo.dijkistra(inimigo.getPosicao(),comida.getPosicao() );
						percurso=grafo.getCaminho();
					
						
						for(int i = 0 ; i < percurso.size()-1 ; i++) {
							
							MovimentaInimigo(percurso.get(i), percurso.get(i+1));
							inimigo.setPosicao(percurso.get(i+1));
							if(comida.getPosicao() != percurso.get(percurso.size()-1)){
								break;
							}
						}
					} catch (Exception e) {
						System.out.println("Entrou no catch");
						e.printStackTrace();
					}
				}	
			}
		}.start();
	}
	
	private void MovimentaInimigo(int no,int proxNo ) throws InterruptedException {
		
		int xno = getNoX().get(no);
		int xprox = getNoX().get(proxNo);
		int yno = getNoY().get(no);
		int yprox = getNoY().get(proxNo);
		
		if(xno  == xprox) {
			if(yno < yprox) {
				while(inimigo.getY() != yprox) {
					Thread.sleep(20);
					inimigo.setY(inimigo.getY()+1);
				}
			}else {
				while(inimigo.getY() != yprox) {
					Thread.sleep(20);
					inimigo.setY(inimigo.getY()-1);
				}
			}
		}else {
			if(xno < xprox) {
				while(inimigo.getX() != xprox) {
					Thread.sleep(20);
					inimigo.setX(inimigo.getX()+1);
				}
			}else {
				while(inimigo.getX() != xprox) {
					Thread.sleep(20);
					inimigo.setX(inimigo.getX()-1);
				}
			}
		}
		
		
	}
	
	private void setComida() {
		
		Random random = new Random();
		int no;
		
		if(inimigo.getY() > 350 ) {
			no = random.nextInt(13);
		}else {
			no = random.nextInt(17)+13;
		}
		comida.setPosicao(no);
		int i = getNoX().get(no);
		comida.setX(i);
		i=getNoY().get(no);
		comida.setY(i);
		comida.setTem(true);
		
		comidaBox = new Rectangle(comida.getX(),comida.getY()+10,comida.getLarg(),comida.getAlt()-10);
		
	}
	
	public void GetRectangle(Rectangle a,Rectangle pers) {
		
		double x,y,xa,ya;
		//System.out.println(a.getCenterX());
		x=pers.getX()+(pers.getWidth());
		y=pers.getY()+pers.getHeight();
		xa=a.getX()+a.getWidth();
		ya=a.getY()+a.getHeight();
		//System.out.println( pers.getBounds());
		if (x-1 == a.getX() ) {
			ps.setX(ps.getX()-1);
		}else if(y-1 == a.getY()) {
			ps.setY(ps.getY()-1);
		}else if (pers.getX()+1 == xa ) {
			ps.setX(ps.getX()+1);
		}else if(pers.getY()+1 == ya) {
			ps.setY(ps.getY()+1);
		}
		
		
	}
	public void GetPosicao() {
		int x=ps.getX();
		int y=ps.getY();
		
		if(x <= 239 && y <= 350) {
			Area1();
		}else if ((x > 239 && x <= 428) && (y <= 350)) {
			Area2();
		}else if((x > 428) && (y <= 350)) {
			Area3();
		}else if(x <= 239 && y <= 639) {
			Area4();
		}else if((x>239 && x <= 428) && (y <= 639 )) {
			Area5();
		}else if(x > 428 && y <= 639) {
			Area6();
		}
		
		
	}
	private void Area6() {
		Rectangle perso = new Rectangle(ps.getX(),ps.getY(),ps.getLarg(),ps.getAlt());
		if(perso.intersects(m)) {
			GetRectangle(m,perso);
		}else if(perso.intersects(s)) {
			GetRectangle(s,perso);
		}else if(perso.intersects(n)) {
			GetRectangle(n,perso);
		}else if(perso.intersects(t)) {
			GetRectangle(t,perso);
		}else if(perso.intersects(u)) {
			GetRectangle(u,perso);
		}else {
			ps.andar();
		}
		
	}
	private void Area5() {
		Rectangle perso = new Rectangle(ps.getX(),ps.getY(),ps.getLarg(),ps.getAlt());
		if(perso.intersects(l)) {
			GetRectangle(l,perso);
		}else if(perso.intersects(q)) {
			GetRectangle(q,perso);
		}else if(perso.intersects(r)) {
			GetRectangle(r,perso);
		}else if(perso.intersects(s)) {
			GetRectangle(s,perso);
		}else if(perso.intersects(m)) {
			GetRectangle(m,perso);
		}else {
			ps.andar();
		}
	}
	private void Area4() {
		Rectangle perso = new Rectangle(ps.getX(),ps.getY(),ps.getLarg(),ps.getAlt());
		if(perso.intersects(k)) {
			GetRectangle(k,perso);
		}else if(perso.intersects(p)) {
			GetRectangle(p,perso);
		}else if(perso.intersects(l)) {
			GetRectangle(l,perso);
		}else if(perso.intersects(r)) {
			GetRectangle(r,perso);
		}else if(perso.intersects(q)) {
			GetRectangle(q,perso);
		}else {
			ps.andar();
		}
		
	}
	private void Area3() {
		Rectangle perso = new Rectangle(ps.getX(),ps.getY(),ps.getLarg(),ps.getAlt());
		if(perso.intersects(c)) {
			GetRectangle(c,perso);
		}else if(perso.intersects(d)) {
			GetRectangle(d,perso);
		}else if(perso.intersects(o)) {
			GetRectangle(o,perso);
		}else if(perso.intersects(i)) {
			GetRectangle(i,perso);
		}else if(perso.intersects(j)) {
			GetRectangle(j,perso);
		}else {
			ps.andar();
		}
		
	}
	private void Area2() {
		Rectangle perso = new Rectangle(ps.getX(),ps.getY(),ps.getLarg(),ps.getAlt());
		if(perso.intersects(b)) {
			GetRectangle(b,perso);
		}else if(perso.intersects(c)) {
			GetRectangle(c,perso);
		}else if(perso.intersects(h)) {
			GetRectangle(h,perso);
		}else if(perso.intersects(i)) {
			GetRectangle(i,perso);
		}else {
			ps.andar();
		}
		
	}
	private void Area1() {
		Rectangle perso = new Rectangle(ps.getX(),ps.getY(),ps.getLarg(),ps.getAlt());

		if(perso.intersects(a)) {
			GetRectangle(a,perso);
		}else if(perso.intersects(b)) {
			GetRectangle(b,perso);
		}else if(perso.intersects(g)) {
			GetRectangle(g,perso);
		}else if(perso.intersects(h)) {
			GetRectangle(h,perso);
		}else if(perso.intersects(k)) {
			GetRectangle(k,perso);
		}else {
			ps.andar();
		}
		
		
	}
	
	private void verificaSeComeu(Rectangle comida) {
		
		Rectangle pers,inim ;
		pers = new Rectangle(ps.getX(),ps.getY(),ps.getLarg(),ps.getAlt());
		inim = new Rectangle(inimigo.getX(),inimigo.getY(),inimigo.getLarg(),inimigo.getAlt());
		if(pers.intersects(comida)) {
			ps.setPontos(ps.getPontos()+1);
			setComida();
		}else if(inim.intersects(comida)) {
			setNumeroVidas(1);
			diminuiVida(getNumeroVidas());
			setComida();
		}
	}
	
	private void diminuiVida(int vida) {
		
		if(getNumeroVidas() == 1) {
			vida5.setImagem();
		}else if(getNumeroVidas() == 2) {
			vida4.setImagem();
		}else if(getNumeroVidas() == 3) {
			vida3.setImagem();
		}else if(getNumeroVidas() == 4) {
			vida2.setImagem();
		}else if(getNumeroVidas() == 5) {
			vida1.setImagem();
			
			JOptionPane.showMessageDialog(null, "GAME OVER!\nPONTOS : "+ ps.getPontos());
			comida.setTem(false);
			audio.stop();
			Menu menu = new Menu();
			janelas.dispose();
			
		}
		
	}

	public ArrayList<Integer> getNoX() {
		return noX;
	}

	public void setNoX(ArrayList<Integer> noX) {
		this.noX = noX;
	}

	public ArrayList<Integer> getNoY() {
		return noY;
	}

	public void setNoY(ArrayList<Integer> noY) {
		this.noY = noY;
	}
	

	public int getNumeroVidas() {
		return numeroVidas;
	}

	public void setNumeroVidas(int numeroVidas) {
		this.numeroVidas = numeroVidas + this.numeroVidas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*Rectangle perso = new Rectangle(ps.getX(),ps.getY(),ps.getLarg(),ps.getAlt());
		if(perso.intersects(u)) {
			GetRectangle(u,perso);
			
		}else {
			ps.andar();
		}*/
		verificaSeComeu(comidaBox);
		GetPosicao();
		repaint();
		
	}
	
	private class TecladoAdapter extends KeyAdapter {
		
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			ps.keyPressed(arg0);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
			ps.KeyReleased(arg0);
		}
	}
}
