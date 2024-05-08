import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private int clicks = 0;
    private int casas = 0;
    private JFrame frame;
    private JLabel EtiquetaClicks;
    private JLabel EtiquetaCasas;
    private JPanel panel;

    public GUI(){
        frame = new JFrame();

        JButton button = new JButton("Chambea");
        button.addActionListener(this);
        JButton comprarCasas = new JButton("Compra una casa");
        comprarCasas.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (clicks>=10){
                            clicks-=10;
                            casas +=1;
                            EtiquetaClicks.setText("Tu dinero: "+clicks);
                            EtiquetaCasas.setText("Numero de casas: "+casas);
                        } else if (clicks<10) {
                            JOptionPane.showMessageDialog(null,"No tienes suficiente dinero");
                        }
                    }
                }
        );

        EtiquetaClicks = new JLabel("Tu dinero: "+clicks);
        EtiquetaCasas = new JLabel("Numero de casas: "+casas);


        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(540,960,200,200));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(comprarCasas);
        panel.add(EtiquetaClicks);
        panel.add(EtiquetaCasas);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clicks++;
        EtiquetaClicks.setText("Tu dinero: "+clicks);
    }
}
