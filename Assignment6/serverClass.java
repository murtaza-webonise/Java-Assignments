import java.sql.*;
import java.net.*;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

class ServerThread implements Runnable {
	Thread t;
	Server server;
	Socket socket;
	static int count = 1;
	BufferedReader br;

	public ServerThread(Server server, Socket socket) {
		// Save the parameters

		this.server = server;
		this.socket = socket;
		t = new Thread(this, "thread" + count);
		// System.out.println(count);
		// Start up the thread
		count++;
		t.start();
	}

	public void run() {

		try {
			while (true) {
				PrintStream socketOutput = new PrintStream(
						socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(System.in));
				// send it

				socketOutput.println("server: " + br.readLine());
				socketOutput.flush();
				// socketOutput.close();

				br = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				System.out.println(br.readLine());
				// br.close();

			}

		} catch (Exception e) {
		}

	}
}

class Server {

	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost/chatdb";
	String USER = "root";
	String PASS = "root";
	Connection conn = null;
	Statement stmt = null;
	private String name;
	private String IP;
	private String age;
	BufferedReader br;

	public Server(int port) throws IOException {
		// All we have to do is listen
		listen(port);
	}

	private void listen(int port) throws IOException {
		// Create the ServerSocket
		ServerSocket connectionSocket = new ServerSocket(port);

		System.out.println("Listening on " + connectionSocket);

		// Keep accepting connections forever
		while (true) {

			// Grab the next incoming connection
			Socket dataSocket = connectionSocket.accept();
			System.out.println("Connection from " + dataSocket);
			System.out.println(dataSocket.getInetAddress());
			br = new BufferedReader(new InputStreamReader(
					dataSocket.getInputStream()));
			name = br.readLine();
			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Inserting value in given table...");
				stmt = conn.createStatement();
				String sql = "Insert into clients(name,IP,age,DateTime) values('"
						+ name
						+ "','"
						+ dataSocket.getInetAddress()
						+ "',45,now());";
				stmt.executeUpdate(sql);
				System.out.println("data has been inserted  given table...");
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						conn.close();
				} catch (SQLException se) {
				}// do nothing
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}// end finally try
			}// end try

			// Create a new thread for this connection, and then forget
			// about it
			new ServerThread(this, dataSocket);
		}
	}
}

public class serverClass {
	public static void main(String[] args) throws IOException {
		int serverPortNum = 6858;
		new Server(serverPortNum);

	}

}
