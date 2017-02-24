package ScalingLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6640595702214843669L;
	public JButton ha, he;
	
	Test() {
		super();
		this.setBounds(200, 300,500,500);
		this.getContentPane().setLayout(new ScalingLayout());
		
		ha = new JButton("Button");
		ha.setBounds(200,200,100,100);
		
		he = new JButton("Be");
		he.setBounds(0,200,50,100);

		
		this.getContentPane().add(ha);
		this.getContentPane().add(he);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Test t = new Test();
	}
}
