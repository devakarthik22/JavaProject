package application;

public class Game {
	private Roll r;
	private Player p1;
	private Player p2;
	private Player curr;
	
	public Game(String p1s,String p2s) {
		r=new Roll();
		p1=new Player(p1s);
		setP2(new Player(p2s));
		setCurr(p1);
		
		
	}

	public Roll getR() {
		return r;
	}

	public void setR(Roll r) {
		this.r = r;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}
	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getCurr() {
		return curr;
	}

	public void setCurr(Player curr) {
		this.curr = curr;
	}
	
	// some code -----
	public boolean gameover() {
		return curr.getTotal()>=50;
	}
	
	
	public boolean p1Turn() {
		return curr==p1;
	}
	public boolean p2Turn() {
		return curr==p2;
	}
	//play methods
	public void switchTurn() {
		if(p1Turn()) {
			curr=p2;
		}
		else {
			curr=p1;
		}
	}
	public void roll() {
			r.randomgenerate();
			int x=r.getTop();
			curr.update(x);
			if(x==0) {
				curr.reset();
			}
			switchTurn();
			
	}
	public static void main(String[] args) {
		Game g=new Game("A","B");
		g.roll();
		System.out.println(g.getP1().getTotal());
		g.roll();
		System.out.println(g.getP2().getTotal());
		g.roll();
		
		System.out.println(g.getP1().getTotal());
		
		
		
	}
	
 
	

}
