package interfazGrafica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import app.Link;

public class MenuPrincipal extends DefaultTableModel {
	private JFrame ventanaMenu;

	private JFrame frame;
	
	public MenuPrincipal() {
		this.ventanaMenu = new JFrame();
		pantallaMenu();
	}

	private JComboBox crearComboBox(Object[] array, int x, int y, int width, int heigth, int index) {
		JComboBox box = new JComboBox(array);
		box.setBounds(x, y, width, heigth);
		box.setSelectedIndex(index);
		return box;
	}
	
	private JTextArea crearTextArea(boolean editable, String text, int x, int y, int width, int heigth) {
		JTextArea texto = new JTextArea();
		texto.setEditable(editable);
		texto.setBackground(Color.BLACK);
		texto.setText(text);
		texto.setBounds(x, y, width, heigth);
		return texto;
	}
	
	private JButton crearBoton(String nombre, String text, int x, int y, int width, int heigth) {
		JButton boton = new JButton(nombre);
		boton.setText(text);
		boton.setBounds(x, y, width, heigth);
		return boton;
	}
	
	private JRadioButton crearRadioBoton(String nombre, String text, int x, int y, int width, int heigth) {
		JRadioButton boton = new JRadioButton(nombre);
		boton.setText(text);
		boton.setBounds(x, y, width, heigth);
		return boton;
	}

	private Component agregarComponente(JFrame frame, Component componente){
		return frame.getContentPane().add(componente);
	}
	
	private Component agregarAPanel(JPanel panel, Component componente){
		return panel.add(componente);
	}
	
	private File abrirArchivo() {
		  String aux="";   
		  String texto="";
		  File archivo=null;
		  try
		  {
		   
		   JFileChooser file=new JFileChooser();
		   FileNameExtensionFilter filter = new FileNameExtensionFilter(".json","json",".JSON","JSON");
			file.setFileFilter(filter);
		   file.showOpenDialog(frame);
		   
		   archivo=file.getSelectedFile();

		   
		   if(archivo!=null)
		   {     
		      FileReader archivos=new FileReader(archivo);
		      BufferedReader lee=new BufferedReader(archivos);
		      while((aux=lee.readLine())!=null)
		      {
		         texto+= aux+ "\n";
		      }
		         lee.close();
		    }    
		    
		   }
		   catch(IOException ex)
		   {
		     JOptionPane.showMessageDialog(null,ex+"" +
		           "\nNo se ha encontrado el archivo",
		                 "ATENCION!!!",JOptionPane.WARNING_MESSAGE);
		    }
		  return archivo;
		
		}
	
	private JFrame inicializarVentana() {
		JFrame ventana = new JFrame("");
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		ventana.setTitle("Gestion de espias 2.01");
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanioPantalla = miPantalla.getScreenSize();
		ventana.setSize(480, 270);
		ventana.setLocation(480, 270);
		ventana.getContentPane().setLayout(null);
		return ventana;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void pantallaMenu() {
		
		JFrame configuraciones = inicializarVentana();
		configuraciones.setSize(539, 360);
		configuraciones.setResizable(false);
		configuraciones.setVisible(true);

		JTextArea encabezado = crearTextArea(false, "GESTION DE CONEXION OPTIMA ENTRE ESPIAS 2.01 ", 60,8, 450, 30);
		encabezado.setFont(new Font("Arial", Font.BOLD, 16));
		encabezado.setForeground(Color.WHITE);
		encabezado.setOpaque(false);
		agregarComponente(configuraciones, encabezado);
		
		JTextArea enunciadoCarga = crearTextArea(false, "Leer archivo README.md antes \ny despues cargar el archivo :", 30, 60, 235, 35);
		enunciadoCarga.setFont(new Font("Arial", Font.BOLD,14));
		enunciadoCarga.setBackground(Color.DARK_GRAY);
		enunciadoCarga.setForeground(Color.WHITE);
		agregarComponente(configuraciones, enunciadoCarga);
		
		JButton botonCargar = crearBoton("botonCarga", "CARGAR", 210, 265, 150, 50);
		botonCargar.setBackground(Color.gray);
		botonCargar.setForeground(Color.white);
		botonCargar.setBorderPainted(true);
		botonCargar.setFont(new Font("Arial", Font.BOLD,16));
		
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					configuraciones.setVisible(false);
					File archivo= abrirArchivo();
					
					Link link=new Link();
					link.cargarGrafo(archivo);
					String[][] grafoKruskal = link.ordenRecorridoAGMKruskal();
					String[][] grafoPrim = link.ordenRecorridoAGMPrimm();
					ventanaResultados(grafoPrim, "Conexion recomendada entre espias: (Prim : "+String.valueOf(link.tiempoPrim())+"  Milisegundos");
					ventanaResultados(grafoKruskal,"Conexion recomendada entre espias: (Kruskal : "+String.valueOf(link.tiempoKruskal())+"  Milisegundos");
			}
		
		});
		agregarComponente(configuraciones, botonCargar);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("fondoConfiguraciones.jpg")));
		fondo.setBounds(0, 0, 523, 321);
		agregarComponente(configuraciones, fondo);
	}
	
	public void ventanaResultados(String[][] datosTuplas, String nombre)
	{
	    JFrame resultadosVentana;

	    JTable tablaResultados;

		resultadosVentana = new JFrame();

		resultadosVentana.setTitle(nombre);

		String[] nombreColumnas = { "Espia ", "Espia ", "Prob. de interferencia" };

		tablaResultados = new JTable(datosTuplas, nombreColumnas);
		tablaResultados.setBounds(30, 40, 200, 300);
		tablaResultados.setBackground(Color.gray);
		tablaResultados.setForeground(Color.white);
	    
		JScrollPane sp = new JScrollPane(tablaResultados);
	       
		resultadosVentana.add(sp);
	       
		resultadosVentana.setSize(500, 200);
	    
		resultadosVentana.setVisible(true);
	}
}