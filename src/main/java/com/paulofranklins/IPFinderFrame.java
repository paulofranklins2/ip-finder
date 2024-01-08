package com.paulofranklins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPFinderFrame extends JFrame {
    private JTextField jTextField;

    public IPFinderFrame(String title) {
        super(title);
        initUI();
    }

    private void initUI() {
        setBounds(100, 100, 1000, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel jLabel = new JLabel("Enter URL: ");
        jLabel.setBounds(50, 70, 200, 20);

        jTextField = new JTextField();
        jTextField.setBounds(50, 100, 300, 20);

        JButton jButton = new JButton("Find IP");
        jButton.setBounds(50, 150, 100, 30);

        jButton.addActionListener(new FindIPAction());

        add(jLabel);
        add(jTextField);
        add(jButton);
        setLayout(new GridLayout());
        setVisible(true);
    }

    private class FindIPAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            String url = jTextField.getText();
            try {
                InetAddress inetAddress = InetAddress.getByName(url);
                String ip = inetAddress.getHostAddress();
                JOptionPane.showMessageDialog(IPFinderFrame.this, ip);
            } catch (UnknownHostException ex) {
                JOptionPane.showMessageDialog(IPFinderFrame.this, "Invalid IP");
            }
        }
    }
}
