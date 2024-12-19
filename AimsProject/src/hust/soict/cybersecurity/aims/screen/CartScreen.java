package hust.soict.cybersecurity.aims.screen;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.cybersecurity.aims.cart.Cart;
import hust.soict.cybersecurity.aims.media.Book;
import hust.soict.cybersecurity.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Cart cart;
	private ControllerScreen controllerscreen;
	
	public CartScreen(Cart cart, ControllerScreen c) {
		super();
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setPreferredSize(new Dimension(1024, 768));
		this.setTitle("Cart");
		this.setVisible(true);
		pack();
		
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().
							getResource("/hust/soict/cybersecurity/aims/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart, c);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
	}

}
