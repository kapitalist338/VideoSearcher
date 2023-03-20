import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Window extends JFrame implements ActionListener {
    JButton button, buttU;
    JTextField textField;
    String open;
    JLabel label;
    Window(){
        this.setBounds(100,200, 450, 300);
        this.setLayout(new FlowLayout());
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Video Searcher");
        label = new JLabel();
        label.setText("Video Opener");
        label.setBackground(new Color(77, 91, 169));
        label.setOpaque(true);
        this.add(label);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(400, 45));
        textField.setToolTipText("Youtube");
        this.add(textField);
        button = new JButton();
        button.setSize(200,60);
        button.setText("Search on Youtube");
        button.addActionListener(this);
        buttU = new JButton();
        buttU.setSize(200,60);
        buttU.setText("Search on Udemy");
        buttU.addActionListener(this);
        this.add(button);
        this.add(buttU);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
            openYoutube();

        if (e.getSource() == buttU)
            openUdemy();
    }

    private void openUdemy() {
        open = textField.getText();
        openLink(open, false);
    }

    private void openYoutube() {
        open = textField.getText();
        openLink(open, true);
    }

    private void openLink(String url, boolean udemy) /*throws URISyntaxException, IOException*/ {
        try{
        Desktop desktop = Desktop.getDesktop();
        if(udemy) {
            String link = "https://www.youtube.com/results?search_query=" + url;
            desktop.browse(new URI(link));
        } else{
            String link = "https://www.udemy.com/courses/search/?src=ukw&q=" + url;
            desktop.browse(new URI(link));
            }
        } catch (URISyntaxException | IOException e){
            error();
        }
    }

    private void error(){
        JOptionPane.showMessageDialog(null, "Error occurred", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
