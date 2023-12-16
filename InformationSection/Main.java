package InformationSection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Main() {
		
		setLocationRelativeTo(null);
		
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 430 + 15, 930 + 15);

	    JButton btnNewButton = new JButton("Start");
	    btnNewButton.setFocusable(false);
	    btnNewButton.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	PassengerDetails passengerDetails = new PassengerDetails();
	            getContentPane().removeAll();
	            getContentPane().add(passengerDetails);
	            revalidate();
	            repaint();
	        }
	    });
	    btnNewButton.setBounds(180, 421, 89, 23);
	    contentPane.add(btnNewButton);
	}

}
