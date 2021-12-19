package application;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Controller {
	Game g;
	@FXML
	Text t;

	@FXML
	Button bt;
	
	@FXML
	TextField p1s;
	
	@FXML
	TextField p1t;
	
	@FXML
	TextField p2s;
	
	@FXML
	TextField p2t;
	
	@FXML
	VBox p1box;
	
	@FXML
	VBox p2box;
	
	@FXML
	private Group circularObject;
	
	
	private Rollnum clock;
	
	private class Rollnum extends AnimationTimer{
		
		private long Frames=50L;
		private long interval=1000000000L/Frames;
		private int max_c=20;
		
		
		private long last=0;
		private int count=0;
		
		
		@Override
		public void handle(long n) {
			if(n-last>interval) {
				int x1=1+(int)(Math.random()+7);
				setnum(x1);
				last=n;
				count++;
				if(count>max_c) {
					clock.stop();
					roll();
					count=0;
				}
				
				
				
			}
			
			
		}
	}
	
	
	
	
	
	@FXML
	public void initialize() {
		/* RotateTransition rt = new RotateTransition();
		 rt.setDuration(Duration.millis(800));
		// rt.autoReverseProperty();
		 rt.setNode(circularObject);
		 rt.setCycleCount(RotateTransition.INDEFINITE);
		 rt.setByAngle(360);
		 rt.setInterpolator(Interpolator.LINEAR);
		 rt.play();*/
		clock=new Rollnum();
		g=new Game("P1","P2");
		System.out.println("Hi");
		bt.setOnAction(event->roll());
		update();
		
		
		
	}
	
	public void update() {
		setnum(g.getR().getTop());
		p1s.setText(""+g.getP1().getCurrscore());
		p1t.setText(""+g.getP1().getTotal());
		p2s.setText(""+g.getP2().getCurrscore());
		p2t.setText(""+g.getP2().getTotal());
		if(g.p1Turn()) {
			p1box.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
			p2box.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
			
		}
		else {
			p2box.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
			p1box.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		}
		
	}
	public void RollAnimation(){
		clock.start();
		
	}
	public void setnum(int x) {
		//x++;
		t.setText(""+x);
	}
	
	public void roll() {
		
		g.roll();
		update();
		
	}
	
	

}
