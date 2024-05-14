
import java.awt.*;
import java.awt.event.*;

public class Rita12 extends Canvas implements Runnable {

  // Tråd
  Thread aktivitet = new Thread(this);
  // Data till spelplan
  int[][] ruta = new int[12][26];
  // Variabler: tid(delay), x, y, tempx, tempy, poäng, high score
  int t, i, j, tempk, temprk, p, h;
  // Variable: Nästa kloss
  int next;
  // Data för klossar
  int[][] kloss = new int[19][6];
  // Labels
  Label points, high;

  KeyListener klyssnare = new KeyAdapter() {
	  public void keyPressed(KeyEvent e) {
	    if(e.getKeyCode() == KeyEvent.VK_LEFT) {
	      // Spara kloss (det suddas i villkor/sudda)
	      tempk=ruta[i][j];
	      // Testa villkor om det går att flytta
	      if(villkor(-1, 0, ruta[i][j]))
	        förflytta();
	      else
	        förflytta();
	      repaint(); }
	    else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
	      tempk=ruta[i][j];
	      if(villkor(1, 0, ruta[i][j]))
	        förflytta();
	      else
	        förflytta();
	      repaint(); }
	    else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
	      // Spara tempk?
	      temprk=tempk;
	
	      // Testar om en speciell kloss får plats(den tänkta(om man vrider))
	      if(temprk==0) { if(villkor(0, 0, 1)) ruta[i][j]=tempk=1;
	                     else ruta[i][j]=tempk; }
	      if(temprk==1) { if(villkor(0, 0, 0)) ruta[i][j]=tempk=0;
	                    else ruta[i][j]=tempk; }
	      if(temprk==2) { if(villkor(0, 0, 3)) ruta[i][j]=tempk=3;
	                     else ruta[i][j]=tempk; }
	      if(temprk==3) { if(villkor(0, 0, 4)) ruta[i][j]=tempk=4;
	                     else ruta[i][j]=tempk; }
	      if(temprk==4) { if(villkor(0, 0, 4)) ruta[i][j]=tempk=5;
	                     else ruta[i][j]=tempk; }
	      if(temprk==5) { if(villkor(0, 0, 5)) ruta[i][j]=tempk=6;
	                     else ruta[i][j]=tempk; }
	      if(temprk==6) { if(villkor(0, 0, 2)) ruta[i][j]=tempk=7;
	                     else ruta[i][j]=tempk; }
	      if(temprk==7) { if(villkor(0, 0, 7)) ruta[i][j]=tempk=8;
	                     else ruta[i][j]=tempk; }
	      if(temprk==8) { if(villkor(0, 0, 8)) ruta[i][j]=tempk=9;
	                     else ruta[i][j]=tempk; }
	      if(temprk==9) { if(villkor(0, 0, 9)) ruta[i][j]=tempk=10;
	                     else ruta[i][j]=tempk; }
	      if(temprk==10) { if(villkor(0, 0, 6)) ruta[i][j]=tempk=11;
	                     else ruta[i][j]=tempk; }
	      if(temprk==11) { if(villkor(0, 0, 12)) ruta[i][j]=tempk=12;
	                     else ruta[i][j]=tempk; }
	      if(temprk==12) { if(villkor(0, 0, 11)) ruta[i][j]=tempk=13;
	                     else ruta[i][j]=tempk; }
	      if(temprk==13) { if(villkor(0, 0, 14)) ruta[i][j]=tempk=14;
	                     else ruta[i][j]=tempk; }
	      if(temprk==14) { if(villkor(0, 0, 13)) ruta[i][j]=tempk=15;
	                     else ruta[i][j]=tempk; }
	      if(temprk==15) { if(villkor(0, 0, 16)) ruta[i][j]=tempk=16;
	                     else ruta[i][j]=tempk; }
	      if(temprk==16) { if(villkor(0, 0, 17)) ruta[i][j]=tempk=16;
	                     else ruta[i][j]=tempk; }
	      if(temprk==17) { if(villkor(0, 0, 18)) ruta[i][j]=tempk=16;
	                     else ruta[i][j]=tempk; }
	      if(temprk==18) { if(villkor(0, 0, 15)) ruta[i][j]=tempk=16;
	                     else ruta[i][j]=tempk; }
	      förflytta();
	      repaint(); }
	      else if(e.getKeyCode() == KeyEvent.VK_UP) {
	        temprk=ruta[i][j];
	      if(temprk==0) { if(villkor(0, 0, 1)) ruta[i][j]=tempk=1;
	                     else ruta[i][j]=tempk; }
	      if(temprk==1) { if(villkor(0, 0, 0)) ruta[i][j]=tempk=0;
	                    else ruta[i][j]=tempk; }
	      if(temprk==2) { if(villkor(0, 0, 5)) ruta[i][j]=tempk=5;
	                     else ruta[i][j]=tempk; }
	      if(temprk==3) { if(villkor(0, 0, 2)) ruta[i][j]=tempk=2;
	                     else ruta[i][j]=tempk; }
	      if(temprk==4) { if(villkor(0, 0, 3)) ruta[i][j]=tempk=3;
	                     else ruta[i][j]=tempk; }
	      if(temprk==5) { if(villkor(0, 0, 4)) ruta[i][j]=tempk=4;
	                     else ruta[i][j]=tempk; }
	      if(temprk==6) { if(villkor(0, 0, 9)) ruta[i][j]=tempk=9;
	                     else ruta[i][j]=tempk; }
	      if(temprk==7) { if(villkor(0, 0, 6)) ruta[i][j]=tempk=6;
	                     else ruta[i][j]=tempk; }
	      if(temprk==8) { if(villkor(0, 0, 7)) ruta[i][j]=tempk=7;
	                     else ruta[i][j]=tempk; }
	      if(temprk==9) { if(villkor(0, 0, 8)) ruta[i][j]=tempk=8;
	                     else ruta[i][j]=tempk; }
	      if(temprk==11) { if(villkor(0, 0, 12)) ruta[i][j]=tempk=12;
	                     else ruta[i][j]=tempk; }
	      if(temprk==12) { if(villkor(0, 0, 11)) ruta[i][j]=tempk=11;
	                     else ruta[i][j]=tempk; }
	      if(temprk==13) { if(villkor(0, 0, 14)) ruta[i][j]=tempk=14;
	                     else ruta[i][j]=tempk; }
	      if(temprk==14) { if(villkor(0, 0, 18)) ruta[i][j]=tempk=13;
	                     else ruta[i][j]=tempk; }
	      if(temprk==15) { if(villkor(0, 0, 15)) ruta[i][j]=tempk=18;
	                     else ruta[i][j]=tempk; }
	      if(temprk==16) { if(villkor(0, 0, 16)) ruta[i][j]=tempk=15;
	                     else ruta[i][j]=tempk; }
	      if(temprk==17) { if(villkor(0, 0, 17)) ruta[i][j]=tempk=16;
	                     else ruta[i][j]=tempk; }
	      if(temprk==18) { if(villkor(0, 0, 15)) ruta[i][j]=tempk=17;
	                     else ruta[i][j]=tempk; }
	        förflytta();
	        repaint(); }
	    
	      else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	    	  tempk=ruta[i][j];
	    	  while(villkor(0, 1, ruta[i][j]))
	    		  förflytta();
	    	  inaktivera();
	    	  repaint(); }
    } };
  public void init(Label l1, Label l2) {
    // Hämtar värden
    points=11;
    high=12;
    // Highscore nollställs
    h=0;
    // Nästa kloss blir...
    next=(int)(Math.random()*18);
    setForeground(Color.black);
    setBackground(Color.white);
    setSize(100, 200);
    // Fyller spelplanen med värdet 20(=blank)
    for(int i=1; i<11; i++) {
      for(int j=0; j<25; j++)
        ruta[i][j]=20; }
    // Fyller en ram längst ner med 21(inaktiv)
    for(int i=0; i<12; i++)
      ruta[i][25]=21;
    // Fyller en ram till höger och vänster med 21
    for(int j=0; j<26; j++) {
      ruta[0][j]=21;
      ruta[11][j]=21; }
    // Värden för de olika klossarna
    // Utgår från en i mitten, 0 är x-kordinaten för kloss två
    // 3 är y-kordinaten för kloss två
    // 1 är x-kordinaten för kloss tre
    // 4 är y-kordinaten för kloss tre
    // etc
    kloss[0][0]=0;kloss[1][0]=-1;kloss[2][0]=-1;kloss[3][0]=-1;kloss[4][0]=-1;kloss[5][0]=0;kloss[6][0]=-1;kloss[7][0]=0;kloss[8][0]=-1;kloss[9][0]=-1;kloss[10][0]=0;kloss[11][0]=-1;kloss[12][0]=-1;kloss[13][0]=-1;kloss[14][0]=-1;kloss[15][0]=-1;kloss[16][0]=-1;kloss[17][0]=0;kloss[18][0]=-1;
    kloss[0][1]=0;kloss[1][1]=-1;kloss[2][1]=1;kloss[3][1]=0;kloss[4][1]=-1;kloss[5][1]=0;kloss[6][1]=1;kloss[7][1]=0;kloss[8][1]=-1;kloss[9][1]=0;kloss[10][1]=1;kloss[11][1]=-1;kloss[12][1]=0;kloss[13][1]=-1;kloss[14][1]=0;kloss[15][1]=0;kloss[16][1]=0;kloss[17][1]=0;kloss[18][1]=0;
    kloss[0][2]=0;kloss[1][2]=1;kloss[2][2]=1;kloss[3][2]=0;kloss[4][2]=1;kloss[5][2]=1;kloss[6][2]=1;kloss[7][2]=1;kloss[8][2]=1;kloss[9][2]=0;kloss[10][2]=1;kloss[11][2]=0;kloss[12][2]=1;kloss[13][2]=0;kloss[14][2]=1;kloss[15][2]=0;kloss[16][2]=1;kloss[17][2]=1;kloss[18][2]=1;
    kloss[0][3]=1;kloss[1][3]=0;kloss[2][3]=0;kloss[3][3]=1;kloss[4][3]=0;kloss[5][3]=1;kloss[6][3]=0;kloss[7][3]=-1;kloss[8][3]=1;kloss[9][3]=-1;kloss[10][3]=-1;kloss[11][3]=1;kloss[12][3]=-1;kloss[13][3]=0;kloss[14][3]=0;kloss[15][3]=0;kloss[16][3]=0;kloss[17][3]=-1;kloss[18][3]=0;
    kloss[0][4]=-1;kloss[1][4]=0;kloss[2][4]=0;kloss[3][4]=1;kloss[4][4]=-1;kloss[5][4]=-1;kloss[6][4]=0;kloss[7][4]=1;kloss[8][4]=0;kloss[9][4]=1;kloss[10][4]=0;kloss[11][4]=0;kloss[12][4]=-1;kloss[13][4]=-1;kloss[14][4]=-1;kloss[15][4]=1;kloss[16][4]=-1;kloss[17][4]=1;kloss[18][4]=1;
    kloss[0][5]=-2;kloss[1][5]=0;kloss[2][5]=1;kloss[3][5]=-1;kloss[4][5]=0;kloss[5][5]=-1;kloss[6][5]=-1;kloss[7][5]=1;kloss[8][5]=0;kloss[9][5]=-1;kloss[10][5]=-1;kloss[11][5]=-1;kloss[12][5]=0;kloss[13][5]=1;kloss[14][5]=-1;kloss[15][5]=-1;kloss[16][5]=0;kloss[17][5]=0;kloss[18][5]=0;
    
    addKeyListener(klyssnare);
    repaint(); }
  
  public void nytt() {
	  // Får fokus
	  requestFocus();
	  // Sätter tiden(tillbaka) till en sekund
	  t=1000;
	  // Nollställer suddar all data från spelplanen
	  for(int i=1; i<11; i++) {
		  for(int j=0; j<25; j++)
			  ruta[i][j]=20; }
	  repaint();
	  // Startar tråden
	  aktivitet.start(); }
  
  public void run() {
	  while(!Thread.interrupted()) {
		  // Testar sleep
		  try {
			  if(t > 300)
				  Thread.sleep(t--);
			  else
				  Thread.sleep(t); }
		  catch(InterruptedException e) {
			  setBackground(Color.white); }
		  if(villkor(0, 1, tempk))
			  förflytta();
		  else
			  inaktivera();
		  repaint(); }
  }
  
  public void update(Graphics g) {
	  // Målar samma bild(suddar ej)
	  paint(g); }
  
  public void paint(Graphics g) {
	  // Går igenom datan för spelplanen
	  for(int i=1; i<11; i++) {
		  for(int j=3; j<25; j++) {
			  // Om rutan har värdet 20, ska den målas vit
			  if(ruta[i][j]==20)
				  g.setColor(Color.white);
			  if(ruta[i][j]==0||ruta[i][j]==1||ruta[i][j]==30||ruta[i][j]==31)
				  g.setColor(Color.red);
			  
			  if(ruta[i][j]>1&&ruta[i][j]<6)
				  g.setColor(Color.green);
			  if(ruta[i][j]>31&&ruta[i][j]<36)
				  g.setColor(Color.green);
			  
			  if(ruta[i][j]>5&&ruta[i][j]<10)
				  g.setColor(Color.blue);
			  if(ruta[i][j]>35&&ruta[i][j]<40)
				  g.setColor(Color.blue);
			  
			  if(ruta[i][j]==10&&ruta[i][j]==40)
				  g.setColor(Color.magenta);
			  if(ruta[i][j]>10&&ruta[i][j]<13)
				  g.setColor(Color.yellow);
			  if(ruta[i][j]>40&&ruta[i][j]<43)
				  g.setColor(Color.yellow);
			  
			  if(ruta[i][j]>12&&ruta[i][j]<15)
				  g.setColor(Color.pink);
			  if(ruta[i][j]>42&&ruta[i][j]<45)
				  g.setColor(Color.pink);
			  
			  if(ruta[i][j]>14&&ruta[i][j]<19)
				  g.setColor(Color.cyan);
			  if(ruta[i][j]>44&&ruta[i][j]<49)
				  g.setColor(Color.cyan);
			  
			  // Om rutan är färgad ska den vara mindre
			  if(ruta[i][j]!=20)
				  g.fillRect(((i-1)*(getWidth()/10)+1), (((j-3)*(getHeight()/22))+1), ((getWidth()/10)-1), ((getHeight()/22))-1);
			  else
				  g.fillRect(((i-1)*(getWidth()/10)+1), (((j-3)*(getHeight()/22))+1), ((getWidth()/10)), ((getHeight()/22))); } }
			  
			  g.setColor(Color.white);
			  
			  // Lägger till två vita streck på de färgade rutorna
			  for(int i=1; i<11; i++) {
				  for(int j=3; j<25; j++) {
					  if(ruta[i][j]!=20) {
						  g.drawLine(((i-1)*(getWidth()/10)), ((j-3)*(getHeight()/22)), (i*(getWidth()/10)), ((j-3)*(getHeight()/22)));
						  g.drawLine(((i-1)*(getWidth()/10)), ((j-3)*(getHeight()/22)), ((i-1)*(getWidth()/10)), ((j-2)*(getHeight()/22))); } } }
			  
			  g.setColor(Color.black);
			  
			  // Lägger till ett svart streck på de färgade rutorna(till höger)
			  for(int i=1; i<11; i++) {
				  for(int j=3; j<25; j++) {
					  if(ruta[i][j]!=20&&ruta[i+1][j]==20)
						  g.drawLine((i*(getWidth()/10)), ((j-3)*(getHeight()/22)), (i*(getWidth()/10)), ((j-2)*(getHeight()/22))); } }
			  
			  // Lägger till ett svart streck på de färgade rutorna(under)
			  for(int i=1; i<11; i++) {
				  for(int j=3; j<25; j++) {
					  if(ruta[i][j]!=20&&ruta[i][j+1]==20)
						  g.drawLine(((i-1)*(getWidth()/10)), ((j-2)*(getHeight()/22)), (i*(getWidth()/10)), ((j-2)*(getHeight()/22))); } }
			  
			  /* g.setColor(Color.white);
			  g.drawLine(0, 0, getWidth(), 0);
			  g.drawLine(0, 0, 0, getHeight());*/
	  }
  
  void rankloss() {
	  // "Nollställer" x- och y-kordinaterna för den nya klossen
	  i=5; j=2;
	  // Rutan och tempk får nytt värde(ny kloss)
	  ruta[i][j]=tempk=next;
	  // Next får nytt värde
	  next=(int)(Math.random()*18);
	  // Ser om det blev highscore
	  if(h<p) {
		  high.setText(String.valueOf(p));
		  h=p; }
	  // Poäng labelen nollställs
	  points.setText("0");
	  // Poäng variablen nollställs
	  p=0;
	  // Stoppar tråden
	  while(!aktivitet.interrupted())
		  aktivitet.interrupt();
	  // Startar om spelet
	  nytt(); }
  
  boolean villkor(int dx, int dy, int k) {
	  // Suddar bort den aktiva klossen för att kunna se efter om en ny kloss får plats
	  sudda();
	  // !Varning! ;)
	  // Ser efter om den nya klossen får plats med hjälp av
	  // x-, y-kordinaten, datan i kloss[][] samt delta-x och delta-y
	  // dvs vilket håll den flyttas
	  // Om alla rutorna är tomma(=20) blir villkor sann
	  if(ruta[(i+dx)][(j+dy)]==20&&ruta[(i+kloss[k][0]+dx)][(j+dy+kloss[k][3])]==20&&ruta[(i+kloss[k][1]+dx)][(j+dy+kloss[k][4])]==20&&ruta[(i+kloss[k][2]+dx)][(j+dy+kloss[k][5])]==20) {
		  i+=dx;
		  j+=dy;
		  return true; }
	  else {
		  return false; } }
  
  void sudda() {
	  // Suddar den första rutan(sparas oftas i tempk)
	  ruta[i][j]=20;
	  // Suddar den tre övriga rutorna med hjälp av kloss[][]
	  for(int q=0; q<3; q++)
		  ruta[(i+kloss[tempk][q])][(j+kloss[tempk][q+3])]=20;
	  return; }
  
  void förflytta() {
	  // Ruta[][] får nytt värde
	  ruta[i][j]=tempk;
	  // De övriga rutorna får värdet tempk+30
	  // de är inaktiva men behöver ID för färgbestämning
	  for(int q=0; q<3; q++)
		  ruta[(i+kloss[tempk][q])][(j+kloss[tempk][(q+3)])]=(tempk+30);
	  // Ökar poängen med ett
	  points.setText(String.valueOf(p++));
	  return; }
  
  void inaktivera() {
	  // Variabel som räknar antal rutor i en rad
	  int n=0;
	  // Ruta[][] blir inaktiv
	  ruta[i][j]=(tempk+30);
	  // Samt de tre övriga rutorna i klossen
	  for(int q=0; q<3; q++)
		  ruta[(i+kloss[tempk][q])][(j+kloss[tempk][(q+3)])]=(tempk+30);
	  // Kör följande sats fyra gånger(=max antal rader man kan ta)
	  for(int yyy=0; yyy<4; yyy++) {
		  // Räknar nerifrån och upp
		  for(int y=24; y>-1; y--) {
			  for(int x=1; x<11; x++) {
				  // Antal ej tomma rutor räknas i raden
				  if(ruta[x][y]!=20) {
					  n++;
					  if(n==10) {
						  // Man får hundra poäng för att ha tagit en rad
						  points.setText(String.valueOf(p=p+100));
						  // Nollställer raden
						  for(int xx=1; xx<11; xx++)
							  ruta[xx][y]=20;
						  // Flyttar ner alla rutor ovanför ner ett steg
						  for(int yy=y; yy>-1; yy--) {
							  for(int xx=1; xx<11; xx++) {
								  if(ruta[xx][yy]!=20) {
									  ruta[xx][(yy+1)]=ruta[xx][yy];
									  ruta[xx][yy]=20; } } } } } }
			  n=0; } }
	  // Om den inaktiverade klossen har 2 som y-värde startas spelet om
	  if(j==2)
		  rankloss();
	  return; }
}
