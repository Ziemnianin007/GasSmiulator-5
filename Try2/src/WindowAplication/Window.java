package WindowAplication; /**
 * Created by Jakub on 2016-11-07.
 */


import Graphic.GraphicModule;
import Graphic.GraphicPanel;
import Graphic.ImagePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class Window extends JFrame {

    //Default global variables

    //definiton of window components
    private JButton Start;
    private JButton Open;
    private JButton Reset;

    private JButton Logo;

    private JPanel UpperButtons;
    private JPanel panel;
    private JLabel ImgLabel;

    //Default constructor
    public Window() {

        //Title of the window
        super("GasSim 0.1");

        //Creating the flow layout to which we can work on and adding panel to frame
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Upper buttons panel
        UpperButtons = new JPanel();
        Start = new JButton("Start");
        Open = new JButton("Open");
        Reset = new JButton("Reset");
        UpperButtons.add(Start);
        UpperButtons.add(Open);
        UpperButtons.add(Reset);

        //definition of placing components
        c.ipady = 0;       //reset to default
        //c.weighty = 1.0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(2,2,2,2);  //interspace
        c.gridx = 1;

        c.gridy = 0;
        add(UpperButtons,c);

        //Logo
        BufferedImage thumbnail = null;
        try {
            BufferedImage tempImg = ImageIO.read(new File("Kinetic theory of gases.png"));
            thumbnail = GraphicModule.resizeImage(tempImg,tempImg.getType(),50,50);

        } catch (IOException e) {
        }
        Image ImgLogo= thumbnail;
        ImageIcon icon = new ImageIcon(ImgLogo,"GasSim 0.1");

        Logo = new JButton(icon);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        //c.weighty = 1.0;   //vertical space
        c.anchor = GridBagConstraints.PAGE_START; //place
        c.insets = new Insets(7,4,0,0);  //top padding
        c.gridx = 0;       //column
        //c.gridwidth = 2;   //columns wide
        c.gridy = 0;       //row
        add(Logo,c);

        //Image panel
        thumbnail = null;
        try {
            BufferedImage tempImg = ImageIO.read(new File("Kinetic theory of gases.png"));
            thumbnail = GraphicModule.resizeImage(tempImg,tempImg.getType(),600,600);

        } catch (IOException e) {
        }
        ImgLogo= thumbnail;
        icon = new ImageIcon(ImgLogo,"GasSim 0.1");
        ImgLabel = new JLabel("",icon, JLabel.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        //c.weighty = 1.0;   //vertical space
        c.anchor = GridBagConstraints.PAGE_START; //place
        c.insets = new Insets(4,4,4,4);  //top padding
        c.gridx = 1;       //column
        //c.gridwidth = 2;   //columns wide
        c.gridy = 1;       //row
        add(ImgLabel,c);


        //Graphic panel
        panel = new GraphicPanel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        //c.weighty = 1.0;   //vertical space
        c.anchor = GridBagConstraints.PAGE_START; //place
        c.insets = new Insets(4,4,4,4);  //top padding
        c.gridx = 0;       //column
        //c.gridwidth = 2;   //columns wide
        c.gridy = 1;       //row
        add(panel,c);




        //initalizing the window
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Handler constructor to do the actionlistening
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Submit");
            }
        });
        Open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
