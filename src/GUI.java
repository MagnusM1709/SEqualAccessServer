import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField jtf = new JTextField();
	public GUI() {
		jtf.setEditable(false);
		setBounds(0,0,500,200);
		setVisible(true);
		this.add(jtf);
		System.out.println("t");
	}
	public void setText(String t) {
		jtf.setText(t);
	}
}