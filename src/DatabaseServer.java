
public class DatabaseServer extends Server {
	DatabaseConnector databaseConnector;
	GUI gui = new GUI();
	
	public static void main(String[] args) {
		int port = 50000 + 9;
		new DatabaseServer(port);	
		//CClient c = new CClient("0.0.0.0", port);
		//c.send("File:/Users/magnusmuller/Desktop/Buchhandel.accdb");
		//c.send("Cmd:SELECT * FROM Buch");
	}


	public DatabaseServer(int pPort) {
		super(pPort);
		
	}

	
	@Override
	public void processNewConnection(String pClientIP, int pClientPort) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void processMessage(String pClientIP, int pClientPort, String pMessage) {
		gui.setText(pMessage);
		if(pMessage.startsWith("File:")) {
			databaseConnector = new DatabaseConnector("", 0, pMessage.split(":", 2)[1], "", "");
			send(pClientIP, pClientPort, "Ok");
		}else if(pMessage.startsWith("Cmd:")) {
			databaseConnector.executeStatement(pMessage.split(":", 2)[1]);
			send(pClientIP, pClientPort, "Msg:" + databaseConnector.getCurrentQueryResult().toUnformattedString());
			send(pClientIP, pClientPort, "Err:" + databaseConnector.getErrorMessage());
		}
		
	}
	
	@Override
	public void processClosingConnection(String pClientIP, int pClientPort) {
		// TODO Auto-generated method stub
		
	
	}

}
