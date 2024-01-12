package actividadestema5Listeners;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfugue.player.Player;

public class PianoGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 501087020652781553L;
	private Player player;
    private JButton buttonDo, buttonRe, buttonMi, buttonFa, buttonSol, buttonLa, buttonSi, buttonDoMajor;
    private JPanel logoPanel;
    private JLabel lblLogoSteinway;
    private JButton rickRolledButton;
    private JPanel contentPane;
    private JPanel panel;
    private JPanel panel_1;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    
    
    public static void main(String[] args) {
        new PianoGUI();
    }

    public PianoGUI() {
        player = new Player();
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));
        
        logoPanel = new JPanel();
        contentPane.add(logoPanel);
        
        lblLogoSteinway = new JLabel("");
        lblLogoSteinway.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir") 
        		+ "\\DesarrolloDeInterfaces\\actividadestema5Listeners\\steinwaysons.jpg");
        
        lblLogoSteinway.addComponentListener(new ComponentAdapter(){
        	public void componentResized(ComponentEvent e) {
        Image image = icon.getImage().
        		getScaledInstance(lblLogoSteinway.getWidth(), lblLogoSteinway.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        lblLogoSteinway.setIcon(scaledIcon);
        	}
        	});
        logoPanel.setLayout(new BorderLayout(0, 0));
//        lblImagen.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
//        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        logoPanel.add(lblLogoSteinway, BorderLayout.CENTER);
        
        rickRolledButton = new JButton("AUTO-PLAY");
        rickRolledButton.setForeground(new Color(255, 255, 255));
        rickRolledButton.setBackground(new Color(82, 61, 39));
        rickRolledButton.setFont(new Font("Times New Roman", Font.BOLD, 29));
        rickRolledButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String neverGonnaGiveYouUp = "T180 V0 I0 " +
				        "E4q F#4q G4q G4q A4q F#4q "
				        + "E4q E4q F#4q G4q"
				        + " D4q D5q D5q A4q " +
				        "E4q E4q F#4q G4q E4q G4q A4q F#4q E4q D4q"
				        + " E4q E4q F#4q G4q " +
				        "E4q D4q A4q A4q A4q B4q A4q"
				        + " G4q A4q B4q G4q A4q A4q A4q B4q A4q D4q " +
				        "E4q F#4q G4q E4q "
				        + "A4q B4q A4q D4q E4q G4q E4q B4q B4q A4q " +
				        "D4q E4q G4q E4q A4q A4q G4q D4q E4q G4q E4q"
				        + " G4q A4q D4q " +
				        "D4q D4q D4q A4q G4q D4q E4q G4q E4q "
				        + "B4q B4q A4q D4q E4q G4q E4q D5q F#4q " +
				        "G4q D4q E4q G4q E4q  G4q A4q F#4q D4q A4q G4q";

				
				player.play(neverGonnaGiveYouUp);
			}
        });
        logoPanel.add(rickRolledButton, BorderLayout.SOUTH);
        
        panel = new JPanel();
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        //        System.getProperty("user.dir") + "\\AccesoADatos\\fichero3readingXML\\book.xml"
        String pianoKeysPath= System.getProperty("user.dir") + 
        		"\\DesarrolloDeInterfaces\\actividadestema5Listeners\\pianokey.png";
               buttonDo = new JButton();
               ImageIcon pianoKeysIcon = new ImageIcon(pianoKeysPath);
               buttonDo.addComponentListener(new ComponentAdapter() {
            	   public void componentResized(ComponentEvent e) {
            		   	Image pianoKeys = pianoKeysIcon.getImage().
            		   			getScaledInstance(buttonDo.getWidth(), buttonDo.getHeight(), Image.SCALE_SMOOTH);
            	        ImageIcon scaledPianoKeys = new ImageIcon(pianoKeys);
            	        buttonDo.setIcon(scaledPianoKeys);
            	   }
               });
                buttonRe = new JButton();
                buttonRe.addComponentListener(new ComponentAdapter() {
             	   public void componentResized(ComponentEvent e) {
             		   	Image pianoKeys = pianoKeysIcon.getImage().
             		   			getScaledInstance(buttonRe.getWidth(), buttonRe.getHeight(), Image.SCALE_SMOOTH);
             	        ImageIcon scaledPianoKeys = new ImageIcon(pianoKeys);
             	        buttonRe.setIcon(scaledPianoKeys);
             	   }
                });
                buttonMi = new JButton();
                buttonMi.addComponentListener(new ComponentAdapter() {
             	   public void componentResized(ComponentEvent e) {
             		   	Image pianoKeys = pianoKeysIcon.getImage().
             		   			getScaledInstance(buttonMi.getWidth(), buttonMi.getHeight(), Image.SCALE_SMOOTH);
             	        ImageIcon scaledPianoKeys = new ImageIcon(pianoKeys);
             	        buttonMi.setIcon(scaledPianoKeys);
             	   }
                });
                buttonFa = new JButton();
                buttonFa.addComponentListener(new ComponentAdapter() {
             	   public void componentResized(ComponentEvent e) {
             		   	Image pianoKeys = pianoKeysIcon.getImage().
             		   	getScaledInstance(buttonFa.getWidth(), buttonFa.getHeight(), Image.SCALE_SMOOTH);
             	        ImageIcon scaledPianoKeys = new ImageIcon(pianoKeys);
             	        buttonFa.setIcon(scaledPianoKeys);
             	   }
                });
                buttonSol = new JButton();
                buttonSol.addComponentListener(new ComponentAdapter() {
             	   public void componentResized(ComponentEvent e) {
             		   	Image pianoKeys = pianoKeysIcon.getImage().
             		   	getScaledInstance(buttonSol.getWidth(), buttonSol.getHeight(), Image.SCALE_SMOOTH);
             	        ImageIcon scaledPianoKeys = new ImageIcon(pianoKeys);
             	        buttonSol.setIcon(scaledPianoKeys);
             	   }
                });
                buttonLa = new JButton();
                buttonLa.addComponentListener(new ComponentAdapter() {
             	   public void componentResized(ComponentEvent e) {
             		   	Image pianoKeys = pianoKeysIcon.getImage().
             		   	getScaledInstance(buttonLa.getWidth(), buttonLa.getHeight(), Image.SCALE_SMOOTH);
             	        ImageIcon scaledPianoKeys = new ImageIcon(pianoKeys);
             	        buttonLa.setIcon(scaledPianoKeys);
             	   }
                });
                buttonSi = new JButton();
                buttonSi.addComponentListener(new ComponentAdapter() {
             	   public void componentResized(ComponentEvent e) {
             		   	Image pianoKeys = pianoKeysIcon.getImage().
             		   	getScaledInstance(buttonSi.getWidth(), buttonSi.getHeight(), Image.SCALE_SMOOTH);
             	        ImageIcon scaledPianoKeys = new ImageIcon(pianoKeys);
             	        buttonSi.setIcon(scaledPianoKeys);
             	   }
                });
                buttonDoMajor = new JButton();
                buttonDoMajor.addComponentListener(new ComponentAdapter() {
             	   public void componentResized(ComponentEvent e) {
             		   	Image pianoKeys = pianoKeysIcon.getImage().
             		   	getScaledInstance(buttonDoMajor.getWidth(), buttonDoMajor.getHeight(), Image.SCALE_SMOOTH);
             	        ImageIcon scaledPianoKeys = new ImageIcon(pianoKeys);
             	        buttonDoMajor.setIcon(scaledPianoKeys);
             	   }
                });
                        buttonDo.addActionListener(this);
                        buttonRe.addActionListener(this);
                        buttonMi.addActionListener(this);
                        buttonFa.addActionListener(this);
                        buttonSol.addActionListener(this);
                        buttonLa.addActionListener(this);
                        buttonSi.addActionListener(this);
                        buttonDoMajor.addActionListener(this);

        JPanel pianoKeysPanel = new JPanel();
        panel.add(pianoKeysPanel, BorderLayout.CENTER);
        pianoKeysPanel.setLayout(new GridLayout(1, 8, 0, 0));
        pianoKeysPanel.add(buttonDo);
        pianoKeysPanel.add(buttonRe);
        pianoKeysPanel.add(buttonMi);
        pianoKeysPanel.add(buttonFa);
        pianoKeysPanel.add(buttonSol);
        pianoKeysPanel.add(buttonLa);
        pianoKeysPanel.add(buttonSi);
        pianoKeysPanel.add(buttonDoMajor);
        
        panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new GridLayout(0, 8, 0, 0));
        
        lblNewLabel = new JLabel("DO");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("RE");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("MI");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("FA");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("SOL");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("LA");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("SI");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_6);
        
        lblNewLabel_7 = new JLabel("DO^");
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_7);
        this.setSize(663, 657);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Steinway & Sons Virtual Piano");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonDo) {
            player.play("C");
        } else if (e.getSource() == buttonRe) {
            player.play("D");
        } else if (e.getSource() == buttonMi) {
            player.play("E");
        } else if (e.getSource() == buttonFa) {
            player.play("F");
        } else if (e.getSource() == buttonSol) {
            player.play("G");
        } else if (e.getSource() == buttonLa) {
            player.play("A");
        } else if (e.getSource() == buttonSi) {
            player.play("B");
        } else if (e.getSource() == buttonDoMajor) {
        	player.play("C6");
        }
        	
    }


}