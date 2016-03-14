package exo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Register dialog = new Register();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Register() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(140, 79, 191, 24);
		contentPanel.add(textArea);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(62, 80, 68, 20);
		contentPanel.add(lblUsername);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(140, 127, 191, 24);
		contentPanel.add(textArea_1);
		
		JLabel lblUserpassword = new JLabel("Userpaw");
		lblUserpassword.setBounds(62, 128, 68, 20);
		contentPanel.add(lblUserpassword);
		
		JLabel lblThisPanelIs = new JLabel("This Panel is for Regist");
		lblThisPanelIs.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 18));
		lblThisPanelIs.setBounds(99, 22, 247, 47);
		contentPanel.add(lblThisPanelIs);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
