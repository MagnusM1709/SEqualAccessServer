
public class CClient extends Client {

	public CClient(String pServerIP, int pServerPort) {
		super(pServerIP, pServerPort);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processMessage(String pMessage) {
		System.out.println(pMessage);

	}

}
