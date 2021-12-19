package application;

public class Player{
	private String Pname;
	private int currscore;
	private int total;
	public Player(String Pname) {
		this.Pname=Pname;
		currscore=0;
		total=0;
	}
	public int getCurrscore() {
		return currscore;
	}
	public void setCurrscore(int currscore) {
		this.currscore = currscore;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	//methods
	public void reset() {
		currscore=0;
	}
	public void update(int x) {
		currscore=x;
		total+=x;
	}
	public void savescore() {
		total+=currscore;
		reset();
	}
	public static void main(String[] args) {
		Roll r=new Roll(6,0);
		Player p=new Player("Ramu");
		System.out.println(p.getTotal());
		System.out.println(p.getCurrscore());
		
		
	
		//System.out.println(r.getTop());
		for(int i=0;i<10;i++) {
			r.randomgenerate();
			p.update(r.getTop());
			//System.out.println(r.getTop());
			System.out.println(p.getCurrscore());
			System.out.println("total "+p.getTotal());
		}
		
	}
	
	
	
	

}
