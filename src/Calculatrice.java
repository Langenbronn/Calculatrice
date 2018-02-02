import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculatrice extends JFrame{
	  //Tableau stockant les éléments à afficher dans la calculatrice
	  String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
	  JButton[] tab_button = new JButton[tab_string.length];
	  private JPanel container = new JPanel();
	  private JLabel affichage= new JLabel();
	  private Dimension dim = new Dimension(50, 40);
	  private Dimension dim2 = new Dimension(50, 31);
	  
	  public Calculatrice(){
			
		    this.setTitle("Calculatrice");
		    this.setSize(240, 260);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    this.setLayout(new BorderLayout());
		    initComposant();
		    this.setContentPane(container);
		    this.setVisible(true);
		  }
	  private void initComposant(){
		 
		  JPanel chiffre = new JPanel(); 
		  chiffre.setPreferredSize(new Dimension(165, 225));
		  JPanel ecran = new JPanel();
		  ecran.setPreferredSize(new Dimension(220, 30)); 
		  JPanel operateur = new JPanel();
		  operateur.setPreferredSize(new Dimension(55, 225));
		  Font police = new Font("Arial", Font.BOLD, 20);
		  // initialisation de l'écran
		  affichage = new JLabel("0 ");
		  affichage.setFont(police);
		  affichage.setHorizontalAlignment(JLabel.RIGHT);
		  affichage.setPreferredSize(new Dimension(220, 20));
		  ecran.add(affichage);
		  ecran.setBackground(Color.WHITE);
		  ecran.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		  // initialisation des boutons
		  for (int i = 0; i < tab_string.length;i++){
			  tab_button[i] = new JButton(tab_string[i]);
		      tab_button[i].setPreferredSize(dim);
			  switch (i){	  
			  case 11:
				  chiffre.add(tab_button[i]);
				  break;
			  case 12:
				  operateur.add(tab_button[i]);
		          tab_button[i].setPreferredSize(dim2);
				  tab_button[i].addActionListener(new ResteListener()); 
				  break;
			  case 13:
				  operateur.add(tab_button[i]);
		          tab_button[i].setPreferredSize(dim2);
				  break;
			  case 14:
				  operateur.add(tab_button[i]);
		          tab_button[i].setPreferredSize(dim2);
				  break;
			  case 15:
				  operateur.add(tab_button[i]);
		          tab_button[i].setPreferredSize(dim2);
				  break;
			  case 16:
				  operateur.add(tab_button[i]);
		          tab_button[i].setPreferredSize(dim2);
				  break;
			  default:
				  chiffre.add(tab_button[i]);
				  tab_button[i].addActionListener(new ChiffreListener()); 
			  }
		  }
		  container.add(ecran, BorderLayout.NORTH);
		  container.add(chiffre, BorderLayout.WEST);
		  container.add(operateur, BorderLayout.EAST);
	  }
	  class ResteListener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		        affichage.setText(" ");
		    }
		  }
	  class ChiffreListener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		        String str = ((JButton)e.getSource()).getText();
		        if(!affichage.getText().equals("0")){
		        	str = affichage.getText() + str;
		        }
		        affichage.setText(str);
		    }
		  }
}
