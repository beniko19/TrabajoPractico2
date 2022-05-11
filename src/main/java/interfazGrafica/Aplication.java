package interfazGrafica;

import javax.swing.*;


public class Aplication {
	
	public Aplication() {
		final MenuPrincipal view = new MenuPrincipal();
	}
	
	public static void main(String...args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Aplication();
			}
		});
	}
}
		

