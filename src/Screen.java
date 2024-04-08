import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends  JFrame implements ActionListener {
    public Screen(){
       setTitle("Grafos");
       setVisible(true);
       setSize(800,500);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //fechar e não minimizar quando clicado em X
       setResizable(false); //não alterar size da tela
       setLocationRelativeTo(null); //centraliza


        setLayout(null);

        JButton jButton = new JButton("clique aqui");
        jButton.setBounds(100,100,100,30);
        jButton.setFont(new Font("Arial", Font.BOLD,15));
        jButton.setForeground(new Color(100,10,50));
        jButton.setBackground(new Color(10,200,10));
        add(jButton);
        jButton.addActionListener(this);   //chamar método

        JButton jButton2 = new JButton("Enviar");
        jButton2.setBounds(50,200,100,30);
        jButton2.setFont(new Font("Arial", Font.ITALIC,10));
        jButton2.setForeground(new Color(100,100,80));
        jButton2.setBackground(new Color(100,10,80));
        add(jButton2);
        jButton2.addActionListener(this::envia);
    }

    private void envia(ActionEvent actionEvent) {
         System.out.println("Tudo bom ?" +(0.10 * 75));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"clicado", "status", JOptionPane.YES_OPTION);

    }
}
