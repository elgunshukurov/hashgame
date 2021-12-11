package com.example.hashgame.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Hash extends JLabel {

		public Hash() {
			String urlImageO="/images/Hash.png";
			ImageIcon PostItimgIcon=null;
			
			try {
				PostItimgIcon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream(urlImageO)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			setHorizontalAlignment(SwingConstants.CENTER);
			this.setIcon(PostItimgIcon);					
		}
		
}
