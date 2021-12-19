package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Homecontroller implements Initializable{
	@FXML
	private Button quit;
	@FXML
	private Group circularObject;
	@FXML
	 public AnchorPane rootPane;
	private Stage stage;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		 RotateTransition rt = new RotateTransition();
		 rt.setDuration(Duration.millis(800));
		// rt.autoReverseProperty();
		 rt.setNode(circularObject);
		 rt.setCycleCount(RotateTransition.INDEFINITE);
		 rt.setByAngle(360);
		 rt.setInterpolator(Interpolator.LINEAR);
		 rt.play();
	}
	public void logout(ActionEvent event) {
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
		
	}
	public void startgame(ActionEvent event) throws IOException {
		Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
