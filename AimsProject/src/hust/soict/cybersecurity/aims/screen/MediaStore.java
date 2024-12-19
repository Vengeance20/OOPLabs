package hust.soict.cybersecurity.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hust.soict.cybersecurity.aims.cart.Cart;
import hust.soict.cybersecurity.aims.media.Media;
import hust.soict.cybersecurity.aims.media.Playable;

public class MediaStore extends JPanel{
	private Media media;
	
	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addCartBtn = new JButton("Add to cart");
		addCartBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cart.addMedia(media);
				} catch (LimitExceededException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		container.add(addCartBtn);
		
		if (media instanceof Playable) {
			JButton playBtn = new JButton("Play");
			playBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JDialog playDialog = new JDialog();
					JPanel mainGUI = new JPanel(new BorderLayout());
			        mainGUI.setBorder(new EmptyBorder(100, 100, 100, 100));
			        mainGUI.add(new JLabel("Playing....."), BorderLayout.CENTER);
			        JPanel buttonPanel = new JPanel(new FlowLayout());
			        mainGUI.add(buttonPanel, BorderLayout.SOUTH);
			        JButton close = new JButton("Stop");
			        close.addActionListener(ev->playDialog.setVisible(false));
			        buttonPanel.add(close);
			        playDialog.setContentPane(mainGUI);
			        playDialog.setLocationRelativeTo(playBtn);
			        playDialog.pack();
			        playDialog.setVisible(true);
				}
			});
			container.add(playBtn);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
