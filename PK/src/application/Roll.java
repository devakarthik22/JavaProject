package application;




//inheritance


public class Roll extends Random{
	//private int number;
	//private int top;
	public Roll(int number,int top) {
		this.number=number;
		this.top=top;
	}
	public Roll() {
		number=6;
		top=0;
	}
	//getters setters
	public int getTop() {
		return top;
	}

	//checkers
	
	
	
	public void setnumber(int x) {
		if(x>0 && x<=number) {
			top=x;
			
		}
	}
	
	
	
	//methods
	
	public static void main(String[] args) {
		Roll r=new Roll(6,0);
		System.out.println(r.getTop());
		for(int i=0;i<10;i++) {
			r.randomgenerate();
			System.out.println(r.getTop());
		}
		
	}
	

}
