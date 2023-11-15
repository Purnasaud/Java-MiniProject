/*
Developers: 
            Purna Bahadur Saud (22)
           
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Formatter;
import java.awt.Color;
import javax.swing.UIManager;
public class ConversionTool extends JFrame implements ActionListener {
    private JPanel container;
    private JPanel panel2;
    //private JPanel panel1;
    private JPanel panel1_1;
    private JTextField tFpxa;
    private JTextField tFpya;
    private JTextField tFpdab;
    private JTextField tFpdeg;
    private JTextField tFpxb;
    private JTextField tFxa;
    private JTextField tFya;
    private JTextField tFdab;
    private JTextField tFxb;
    private JTextField tFyb;
    private JComboBox comboBox ;
    public int selectedValue;
    private JTextField tFpmin;
    private JTextField tFpsec;
    private JTextField tFpyb;
    public int value;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    miniproject.ConversionTool frame = new miniproject.ConversionTool();
                    //frame.displayPanel();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Creating the frame
     */
    public ConversionTool() {
        setTitle("Surveyors Calculator");
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1001, 655);
        container = new JPanel();
        container.setBackground(new Color(230, 230, 250));
        container.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(container);
        container.setLayout(null);

        //Clearing panel to place ComboBox
        JPanel comboPanel = new JPanel();
        comboPanel.setBackground(UIManager.getColor("ToolBar.background"));
        comboPanel.setBounds(82, 60, 844, 75);
        container.add(comboPanel);
        comboPanel.setLayout(null);

        //JComboBox  Creating ComboBox For Selection
        comboBox = new JComboBox();
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBox.addActionListener(this);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT---------------------", "Distance Between Two Coordinates", "X Y From Distance And Bearing "}));
        comboBox.setBounds(316, 23, 319, 41);
        comboPanel.add(comboBox);

        //Heading Label
        JLabel lblNewLabel = new JLabel("Surveyor's Calculator");
        lblNewLabel.setBackground(new Color(46, 139, 87));
        lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 25));
        lblNewLabel.setBounds(403, 10, 289, 52);
        container.add(lblNewLabel);

        //Panel_1 To Calculate Coordinates From Distance, Bearing and Preceding Coordinates Value
        panel1_1 = new JPanel();
        panel1_1.setBackground(UIManager.getColor("Button.shadow"));
        panel1_1.setBounds(147, 145, 713, 423);
        container.add(panel1_1);
        panel1_1.setLayout(null);

        //TextField for XA in Panel_1
        tFpxa = new JTextField();
        tFpxa.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tFpxa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    Double.parseDouble(tFpxa.getText()+e.getKeyChar());
                }
                catch(NumberFormatException ev){
                    e.consume();
                }
            }
        });
        tFpxa.setColumns(10);
        tFpxa.setBounds(290, 62, 107, 43);
        panel1_1.add(tFpxa);


        // Creating Label For XA, YA, XB, YB, Degree, Minute, Seconds for Panel_1
        JLabel labelpxa = new JLabel("XA:");
        labelpxa.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        labelpxa.setBounds(243, 74, 41, 14);
        panel1_1.add(labelpxa);

        JLabel labelpya = new JLabel("YA:");
        labelpya.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        labelpya.setBounds(441, 74, 41, 14);
        panel1_1.add(labelpya);

        JLabel labelpxb = new JLabel("XB:");
        labelpxb.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        labelpxb.setBounds(162, 316, 41, 21);
        panel1_1.add(labelpxb);

        JLabel labelpyb = new JLabel("YB:");
        labelpyb.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        labelpyb.setBounds(480, 316, 69, 21);
        panel1_1.add(labelpyb);

        JLabel labelpDeg = new JLabel("°");
        labelpDeg.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        labelpDeg.setBounds(360, 189, 15, 19);
        panel1_1.add(labelpDeg);

        JLabel labelpMin = new JLabel("'");
        labelpMin.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        labelpMin.setBounds(491, 189, 15, 19);
        panel1_1.add(labelpMin);

        JLabel labelPsec = new JLabel("\"");
        labelPsec.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        labelPsec.setBounds(608, 189, 15, 19);
        panel1_1.add(labelPsec);
        getContentPane().add(panel1_1);

        JLabel labelBab = new JLabel("Bearing of AB:");
        labelBab.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        labelBab.setBounds(152, 189, 132, 29);
        panel1_1.add(labelBab);


        JLabel labelDab = new JLabel("Distance Between AB (m):");
        labelDab.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        labelDab.setBounds(177, 115, 220, 42);
        panel1_1.add(labelDab);

        //Creating TextField for XA, YA, Distance, Bearing, XB and YB
        tFpya = new JTextField();
        tFpya.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tFpya.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    Double.parseDouble(tFpya.getText()+e.getKeyChar());
                }
                catch(NumberFormatException ev){
                    e.consume();
                }
            }
        });
        tFpya.setColumns(10);
        tFpya.setBounds(480, 62, 118, 43);
        panel1_1.add(tFpya);

        tFpdab = new JTextField();
        tFpdab.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tFpdab.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    Double.parseDouble(tFpdab.getText()+e.getKeyChar());
                }
                catch(NumberFormatException ev){
                    e.consume();
                }
            }
        });
        tFpdab.setColumns(10);
        tFpdab.setBounds(387, 124, 106, 40);
        panel1_1.add(tFpdab);

        tFpdeg = new JTextField();
        tFpdeg.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tFpdeg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    Integer.parseInt(tFpdeg.getText()+e.getKeyChar());
                }
                catch(NumberFormatException ev){
                    e.consume();
                }
            }
        });
        tFpdeg.setColumns(10);
        tFpdeg.setBounds(269, 183, 81, 35);
        panel1_1.add(tFpdeg);

        tFpxb = new JTextField();
        tFpxb.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tFpxb.setColumns(10);
        tFpxb.setBounds(214, 309, 106, 40);
        panel1_1.add(tFpxb);

        tFpyb = new JTextField();
        tFpyb.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tFpyb.setBounds(517, 309, 106, 40);
        panel1_1.add(tFpyb);
        tFpyb.setColumns(10);

        tFpmin = new JTextField();
        tFpmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tFpmin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    Integer.parseInt(tFpmin.getText()+e.getKeyChar());
                }
                catch(NumberFormatException ev){
                    e.consume();
                }
            }
        });
        tFpmin.setColumns(10);
        tFpmin.setBounds(401, 183, 81, 35);
        panel1_1.add(tFpmin);

        tFpsec = new JTextField();
        tFpsec.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tFpsec.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    Double.parseDouble(tFpsec.getText()+e.getKeyChar());
                }
                catch(NumberFormatException ev){
                    e.consume();
                }
            }
        });
        tFpsec.setColumns(10);
        tFpsec.setBounds(517, 183, 81, 35);
        panel1_1.add(tFpsec);



        // Creating Button and adding ActionListener to calculate Coordinates of XB and YB
        JButton buttonpCalcx = new JButton("Calculate X");
        buttonpCalcx.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        buttonpCalcx.setBounds(257, 249, 132, 40);
        panel1_1.add(buttonpCalcx);
        buttonpCalcx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Formatter formatter = new Formatter();
                double l = Double.parseDouble(tFpdab.getText());
                double xa = Double.parseDouble(tFpxa.getText());
                double ya = Double.parseDouble(tFpya.getText());
                int deg = Integer.parseInt(tFpdeg.getText());
                int min = Integer.parseInt(tFpmin.getText());
                double sec = Double.parseDouble(tFpsec.getText());
                double fdeg =  (deg  + (min/60) + (sec/3600));
                double xb = xa + (l * (Math.sin(Math.toRadians(fdeg))));
                tFpxb.setText(formatter.format("%.3f", xb).toString());
            }
        });

        // Creating the button To Clear the textField and Adding ActionListener for Panel_1
        JButton buttonCle = new JButton("Clear");
        buttonCle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tFpxa.setText("");
                tFpya.setText("");
                tFpdab.setText("");
                tFpdeg.setText("");
                tFpsec.setText("");
                tFpmin.setText("");
                tFpxb.setText("");
                tFpyb.setText("");
            }
        });
        buttonCle.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        buttonCle.setBounds(367, 340, 89, 40);
        panel1_1.add(buttonCle);

        JButton buttonpCalcy = new JButton("Calculate Y");
        buttonpCalcy.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        buttonpCalcy.setBounds(493, 249, 132, 40);
        panel1_1.add(buttonpCalcy);
        buttonpCalcy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Formatter formatter = new Formatter();
                double l = Double.parseDouble(tFpdab.getText());
                double xa = Double.parseDouble(tFpxa.getText());
                double ya = Double.parseDouble(tFpya.getText());
                int deg = Integer.parseInt(tFpdeg.getText());
                int min = Integer.parseInt(tFpmin.getText());
                double sec = Double.parseDouble(tFpsec.getText());

                double fdeg =  (deg  + (min/60) + (sec/3600));  //((deg + (min/60) + (sec / 3600))*180)/(Math.PI);
                double yb = ya + (l * (Math.cos(Math.toRadians(fdeg))));
                tFpyb.setText(formatter.format("%.3f", yb).toString());
            }
        });


        // Creating Panel2 to Calculate Distance between Two Points
        panel2 = new JPanel();
        panel2.setBounds(147, 142, 713, 426);
        container.add(panel2);
        panel2.setBackground(new Color(192, 192, 192));
        panel2.setLayout(null);

        //Creating TextField for XA, YA, XB, YB
        tFxa = new JTextField();
        tFxa.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tFxa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    Double.parseDouble(tFxa.getText()+e.getKeyChar());
                }
                catch(NumberFormatException ev){
                    e.consume();
                }
            }
        });
        panel2.add(tFxa);
        tFxa.setColumns(10);
        tFxa.setBounds(250, 87, 98, 42);

        tFya = new JTextField();
        tFya.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tFya.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    Double.parseDouble(tFya.getText()+e.getKeyChar());
                }
                catch(NumberFormatException ev){
                    e.consume();
                }

            }
        });
        tFya.setColumns(10);
        tFya.setBounds(441, 87, 96, 42);
        panel2.add(tFya);

        tFxb = new JTextField();
        tFxb.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tFxb.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    Double.parseDouble(tFxb.getText()+e.getKeyChar());
                }
                catch(NumberFormatException ev){
                    e.consume();
                }

            }
        });
        tFxb.setColumns(10);
        tFxb.setBounds(252, 142, 96, 42);
        panel2.add(tFxb);

        tFyb = new JTextField();
        tFyb.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tFyb.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    Double.parseDouble(tFyb.getText()+e.getKeyChar());
                }
                catch(NumberFormatException ev){
                    e.consume();
                }

            }
        });
        tFyb.setColumns(10);
        tFyb.setBounds(441, 142, 96, 42);
        panel2.add(tFyb);

        //Label for XA and YA Coordinates
        JLabel labelya = new JLabel("YA:");
        labelya.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        labelya.setBounds(390, 97, 41, 14);
        panel2.add(labelya);

        JLabel labelxa = new JLabel("XA:");
        labelxa.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        labelxa.setBounds(181, 97, 59, 14);
        panel2.add(labelxa);

        //Label For XB and YB Coordinates
        JLabel labelxb = new JLabel("XB:");
        labelxb.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        labelxb.setBounds(185, 145, 55, 30);
        panel2.add(labelxb);

        JLabel labelyb = new JLabel("YB:");
        labelyb.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        labelyb.setBounds(390, 153, 55, 14);
        panel2.add(labelyb);

        //TextField for Distance between AB
        tFdab = new JTextField();
        tFdab.setFont(new Font("Tahoma", Font.PLAIN, 16));

        tFdab.setColumns(10);
        tFdab.setBounds(363, 268, 137, 42);
        panel2.add(tFdab);

        //Label For Distance between AB
        JLabel labelab = new JLabel("Distance Between AB:");
        labelab.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        labelab.setBounds(109, 276, 230, 19);
        panel2.add(labelab);

        // Creating Button to calculate distance  and display Output
        JButton buttonCalc = new JButton("Calculate");
        buttonCalc.setBackground(UIManager.getColor("Button.light"));
        buttonCalc.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        buttonCalc.setBounds(263, 206, 115, 42);
        panel2.add(buttonCalc);
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Formatter formatter = new Formatter();
                double x1 = Double.parseDouble(tFxa.getText());
                double y1 = Double.parseDouble(tFya.getText());
                double x2 = Double.parseDouble(tFxb.getText());
                double y2 = Double.parseDouble(tFyb.getText());
                Double distance = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
                //formatter.format("%.3f", distance );
                tFdab.setText(formatter.format("%.3f", distance ).toString());
            }
        });

        // Creating Button To clear Selected Text Field
        JButton buttonClear = new JButton("Clear");
        buttonClear.setBackground(UIManager.getColor("Button.light"));
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tFxa.setText("");
                tFya.setText("");
                tFxb.setText("");
                tFyb.setText("");
                tFdab.setText("");
            }
        });
        buttonClear.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        buttonClear.setBounds(441, 206, 89, 42);
        panel2.add(buttonClear);

        //Initially, setting Panel Visibility to False
        panel2.setVisible(false);
        panel1_1.setVisible(false);
    }

    @Override
    //actionPerformed to set the visibility of Panel based of ComboBox Item Selection
    public void actionPerformed (ActionEvent e)
    {
        selectedValue= comboBox.getSelectedIndex();
        if(selectedValue == 1) {
            panel2.setVisible(true);
            panel1_1.setVisible(false);
        }
        else if(selectedValue == 2) {
            panel1_1.setVisible(true);
            panel2.setVisible(false);
        }
    }
}

