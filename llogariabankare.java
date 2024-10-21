import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.ButtonGroup;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;

public class llogariabankare extends JFrame implements ActionListener {
 
	//Krijohen etiketat butonat dhe fushat e tekstit
	
	public JLabel llogaria = new JLabel("LLOGARIA BANKARE");
	public JLabel balanca = new JLabel("Balanca Aktuale  ");
	public JLabel sasia = new JLabel("Sasia ");
	public JLabel depozitaBankare = new JLabel("DEPOZITA BANKARE");
	public JLabel tipdep = new JLabel("Tipi i Depozitës");
	public JLabel mbetur = new JLabel("Balanca e mbetur është: ");
	public JLabel shdep = new JLabel("Shuma e depozitës");
	public JLabel adep = new JLabel("Afati i depozitës");
	public JLabel interesi= new JLabel("Shuma e interesit është: ");
	public JButton motivation = new JButton("CLICK FOR SOME MOTIVATION");
	public JButton depozito = new JButton("Depozito");
	public JButton terhiq = new JButton("Tërhiq");
	public JButton llogarit = new JButton("Llogarit");
	public JRadioButton rad1 = new JRadioButton("Me afat");
	public JRadioButton rad2 = new JRadioButton("Pa afat ");

	
	public JTextField inbalanca = new JTextField(10);
	public JTextField insasia = new JTextField(10);
	public JTextField inshdep = new JTextField(13);
	public JTextArea inmbetur = new JTextArea(1,10);
	public JTextArea ininteresi = new JTextArea (1,12);
	
	JComboBox afatidep;
	
	public double sasiaTot ;
	public double diferenca;
	public double shumaTotal1,shumaTotal2;
	
	
	//Krijohet konstruktori
	public llogariabankare() {
		JFrame frame = new JFrame("Llogaria Bankare");
		frame.getContentPane().setBackground(Color.orange);
		Toolkit theKit = frame.getToolkit();  
		Dimension permasat = theKit.getScreenSize();
		frame.setSize(500,600);
		frame.setTitle("Llogaria Bankare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		//Vlerat qe do te permbaje JCombo Box
		String[] Afati = {"1 mujor", "6 mujor","12 mujor","24 mujor"};
		afatidep = new JComboBox(Afati);
		
		//Rregullohet paraqitja e titujve
		JLabel llogaria = new JLabel("LLOGARIA BANKARE");
		llogaria.setFont(new Font ("SansSerif", Font.BOLD, 16));
		
		JLabel depozitaBankare = new JLabel("DEPOZITA BANKARE");
		depozitaBankare.setFont(new Font ("SansSerif", Font.BOLD, 16));
		
		//Grupohen buttonat e tipit Radio Button ne menyre qe te zgjidhet veteme njeri
		ButtonGroup group = new ButtonGroup();
		group.add(rad1);
		group.add(rad2);
		
		//Vendosen kompenentet ne Box
		
		//Krijohet Box i pare qe do te vendoset majtas
		Box vertical1= Box.createVerticalBox();	
		vertical1.add(Box.createVerticalStrut(25));
		vertical1.add(llogaria);
		vertical1.add(Box.createVerticalStrut(25));
		vertical1.add(balanca);
		vertical1.add(Box.createVerticalStrut(20));
		vertical1.add(sasia);
		vertical1.add(Box.createVerticalStrut(20));
		vertical1.add(depozito);
		vertical1.add(Box.createVerticalStrut(20));
		vertical1.add(mbetur);
		vertical1.add(Box.createVerticalStrut(20));
		vertical1.add(depozitaBankare);
		vertical1.add(Box.createVerticalStrut(20));
		vertical1.add(shdep);
		vertical1.add(Box.createVerticalStrut(20));
		vertical1.add(tipdep);
		vertical1.add(Box.createVerticalStrut(20));
		vertical1.add(adep);
		vertical1.add(Box.createVerticalStrut(20));
		vertical1.add(llogarit);
		vertical1.add(Box.createVerticalStrut(20));
		vertical1.add(interesi);
		
		//Krijohet Box i dyte qe do te vendoset djathtas
		Box vertical2= Box.createVerticalBox();
		vertical2.add(Box.createVerticalStrut(70));
		vertical2.add(inbalanca);
		vertical2.add(Box.createVerticalStrut(15));
		vertical2.add(insasia);
		vertical2.add(Box.createVerticalStrut(17));
		vertical2.add(terhiq);
		vertical2.add(Box.createVerticalStrut(20));
		vertical2.add(inmbetur);
		vertical2.add(Box.createVerticalStrut(60));
		vertical2.add(inshdep);
		vertical2.add(Box.createVerticalStrut(2));
		vertical2.add(rad1);
		vertical2.add(rad2);
		vertical2.add(Box.createVerticalStrut(2));
		vertical2.add(afatidep);
		vertical2.add(Box.createVerticalStrut(60));
		vertical2.add(ininteresi);	

		//Krijohet konteineri qe do te permbaje elementet
	    Container content = frame.getContentPane();  
	    FlowLayout flow = new FlowLayout();
		content.setLayout(flow); 
		
		//Vendosen elementet ne konteiner
		content.add(vertical1);
		content.add(vertical2);	
		content.add(motivation);
		
		//Percaktohen fushat qe do te jene te paeditueshme
		inmbetur.setEditable(false);
		ininteresi.setEditable(false);
		frame.setVisible(true); 
		
		//Aktivizohet "pergjuesi" i butonave
		depozito.addActionListener(this);
		terhiq.addActionListener(this);
		rad1.addActionListener(this);
		rad2.addActionListener(this);
		afatidep.addActionListener(this);
		llogarit.addActionListener(this);
		motivation.addActionListener(this);
	}
	
	//Krijohet funksioni qe do te therritet kur te klikohen butonat "Terhiq" dhe "Depozito"
	public void llogaritgjendjen() {
		
		String balancatext = inbalanca.getText();
		String sasiatext = insasia.getText();
		
		double dbalanca = Double.parseDouble(balancatext);	
		double dsasia = Double.parseDouble(sasiatext);
		
		sasiaTot = dbalanca + dsasia;
		diferenca = dbalanca - dsasia;
		
	}
	
	//Krijohet funksioni qe do te therritet kur te klikohet Radio Butoni "Me Afat"
	public void afatiidepozites () {
		
		String shumaDepozites = inshdep.getText();
		double shdepozites = Double.parseDouble(shumaDepozites);
		
		if (afatidep.getSelectedItem().equals("1 mujor")) 
			  shumaTotal1 = shdepozites*0.4;
		
		else if (afatidep.getSelectedItem().equals("6 mujor")) 
			  shumaTotal1 = shdepozites*0.6;
		
		else if (afatidep.getSelectedItem().equals("12 mujor")) 
			  shumaTotal1 = shdepozites*0.12;
		
		else if (afatidep.getSelectedItem().equals("24 mujor")) 
			  shumaTotal1 = shdepozites*0.24;
		
		}
	
	//Krijohet funksioni qe do te therritet kur te klikohet butoni "Pa Afat"
	public void depozitapaafat () {
		
		String shumaDepozites = inshdep.getText();
		double shdepozites = Double.parseDouble(shumaDepozites);
		
		shumaTotal2 = shdepozites*0.01;

	}
	
	//Krijohet funksioni qe do te therritet kur te klikohet butoni "Click for some motivation"
	public void motivim() {
		   JFrame f=new JFrame("This is your daily dose of motivation");  
		   JOptionPane.showMessageDialog(f,"“Sometimes, you’ve got to work a little, so you can ball a lot.”"
				   
				   
				   ,"Your Daily Dose Of Motivation",JOptionPane.PLAIN_MESSAGE);  

			
		}
	
	//Krijohet metoda ActionPerformed e cila do te aktivizohet me aplikimin e butonave te ndryshem
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == motivation) {
			
			motivim();
			}
		if(e.getSource() == depozito) {
			
			llogaritgjendjen();
			String s1 = Double.toString(sasiaTot);
			inmbetur.setText(s1);
			}
		else if(e.getSource() == terhiq) {
			
			llogaritgjendjen();
			String s2 = Double.toString(diferenca);
			inmbetur.setText(s2);
		}	
		 if(rad1.isSelected()) {
			 afatiidepozites();
			 if(e.getSource()==llogarit) {
		    	  
					String s3=Double.toString(shumaTotal1);
					ininteresi.setText(s3);
				}
			 }
		 
		 else if(rad2.isSelected()){
			 depozitapaafat();
			 if(e.getSource()==llogarit) {
		    	  
					String s3=Double.toString(shumaTotal2);
					ininteresi.setText(s3);
				}
		 }
		
		
		
	}
	
	//Krijohet metoda main e cila do te therrase konstruktorin
		
	public static void main(String[] args) {
		
		new llogariabankare(); 
	    
	}

}