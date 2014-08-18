import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class seprateThread implements Runnable {
	Thread t;
	Socket clientSocket;
	JTextArea txt;

	public seprateThread(Socket clientSocket, JTextArea txt) {
		t = new Thread(this);
		this.clientSocket = clientSocket;
		t.start();
		this.txt = txt;
	}

	public void run() {
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				txt.append(br.readLine() + "\n");
			}
		} catch (IOException en) {
			en.printStackTrace();
		}

	}
}

class JChat extends JFrame implements ActionListener {
	String name;
	int port;
	JTextArea txt = new JTextArea();
	JScrollPane sp = new JScrollPane(txt);
	JTextField write = new JTextField("Write Something Here");
	JButton send = new JButton("Send");
	JButton clear = new JButton("Clear Chat");
	private final String host;
	Socket clientSocket;
	PrintStream ps;

	public JChat(String username, String groupAdr, int portNr)
			throws IOException {
		name = username;
		port = portNr;
		host = groupAdr;
		setTitle("Chatting with " + name + " with IP as " + host + " on Port "
				+ portNr);
		txt.setEditable(true);
		sp.setPreferredSize(new Dimension(100, 275));

		add(send, BorderLayout.LINE_END);
		add(clear, BorderLayout.LINE_START);
		add(sp, BorderLayout.NORTH);
		add(write, BorderLayout.CENTER);
		send.addActionListener(this);
		clear.addActionListener(this);
		write.addActionListener(this);
		setSize(600, 350);
		setVisible(true);
		txt.setAutoscrolls(rootPaneCheckingEnabled);
		write.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txt.append("me: " + write.getText() + "\n");
					ps.println("Murtaza: " + write.getText());
					ps.flush();
					write.setText("");

				}
			}
		});
		write.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {

				write.setText("");

			}

		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			clientSocket = new Socket(host, port);
			ps = new PrintStream(clientSocket.getOutputStream());
			ps.println("Murtaza");
		} catch (IOException ex) {
			Logger.getLogger(JChat.class.getName()).log(Level.SEVERE, null, ex);
		}

		new seprateThread(clientSocket, txt);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equalsIgnoreCase("send")) {

			txt.append("me: " + write.getText() + "\n");
			ps.println("Murtaza: " + write.getText());
			ps.flush();
			write.setText("");

		}
		if (e.getActionCommand().equalsIgnoreCase("Clear Chat")) {
			txt.setText("");
		}

	}

}

class client extends JWindow {
	Image img = Toolkit.getDefaultToolkit().getImage("src/b1.png");
	ImageIcon imgicon = new ImageIcon(img);

	public client() {
		try {
			setSize(642, 361);
			setLocationRelativeTo(null);
			this.show();
			Thread.sleep(5000);
			dispose();
			javax.swing.JOptionPane.showMessageDialog(
					(java.awt.Component) null, "Welcome to my Chat", "Welcome Screen:",
					javax.swing.JOptionPane.DEFAULT_OPTION);
		} catch (Exception exception) {
			javax.swing.JOptionPane.showMessageDialog(
					(java.awt.Component) null,
					"Error" + exception.getMessage(), "Error:",
					javax.swing.JOptionPane.DEFAULT_OPTION);
		}
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}

	public static void main(String[] args) throws IOException {
		new client();
		new JChat("Server", "127.0.0.1", 6858);

	}
}
