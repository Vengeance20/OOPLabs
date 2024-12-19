package hust.soict.cybersecurity.aims.screen;



import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.cybersecurity.aims.cart.Cart;
import hust.soict.cybersecurity.aims.media.DigitalVideoDisc;
import hust.soict.cybersecurity.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField director;
	private JTextField length;

	public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart, ControllerScreen c) {
		super(store, cart, c);
	}
	@Override
	void updateAdd(JPanel panel) {
		this.numberInput = 6;
		JLabel directorLabel = new JLabel("Director", JLabel.TRAILING);
		panel.add(directorLabel);
		director = new JTextField(2);
		director.setPreferredSize(new Dimension(150, 20));
		directorLabel.setLabelFor(director);
		panel.add(director);
		JLabel lengthLabel = new JLabel("Length", JLabel.TRAILING);
		panel.add(lengthLabel);
		length = new JTextField(2);
		lengthLabel.setLabelFor(length);
		panel.add(length);
		JButton tes = new JButton("Ddd");
		tes.setVisible(false);
		panel.add(tes);
		panel.setPreferredSize(new Dimension(100, 300));
		addBtn = new JButton("Ddd");
		addBtn.addActionListener(e -> {
			addMedia();
		});
		panel.add(addBtn);
	}

	public void addMedia() {
		String title = this.title.getText();
		String director = this.director.getText();
		String category = this.category.getText();
		float cost = Float.parseFloat(this.cost.getText());
		int length = Integer.parseInt(this.length.getText());
		DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
		this.store.addMedia(dvd);
		JOptionPane.showMessageDialog(null, "DVD added successfully!");
		clearTextField();
		
	}
	public void clearTextField(){
		this.title.setText("");
		this.director.setText("");
		this.cost.setText("");
		this.length.setText("");
		this.category.setText("");
	}
	

}