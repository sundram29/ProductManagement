import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainClass {

	JFrame frame=new JFrame("Product management systems");
	JButton[] bt=new JButton[5];
	
	static int drCount =0, irCount =0, sarCount =0, urCount=0, srCount =0;
	
	public MainClass() {
		frame.setSize(600,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		DbConnection.createConnection();
		addButtons();
		frame.setVisible(true);
	}
	private void addButtons()
	{
		frame.setLayout(null);
		int y=60;
		String[] str= {"Insert","Delete","Show all","Update","Search"};
		Font fo=new Font("arial",Font.PLAIN,20);
		MenuListener listener=new MenuListener();
		for(int i=0;i<5;i++)
		{
			bt[i]=new JButton(str[i]+" record");
			bt[i].setBounds(200,y,200,35);
			bt[i].setFont(fo);
			bt[i].addActionListener(listener);
			frame.add(bt[i]);
			y+=75;
		}
	}
	class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			JButton bb=(JButton)evt.getSource();
			if(bb==bt[0])//Insert record
			{
				if (irCount == 0) {
					new InsertRecord();
					irCount = 1;
				}
			}
			else if(bb==bt[1])//Delete record
			{
				if (drCount == 0) {
					new DeleteRecord();
					drCount = 1;
				}
			}
			else if(bb==bt[2])//Show all record
			{
				if (sarCount == 0) {
					new ShowAllRecord();
					sarCount = 1;
				}
			}
			else if(bb==bt[3])//Update record
			{
				if (urCount == 0) {
					new UpdateRecord();
					urCount = 1;
				}
			}
			else if(bb==bt[4])//Search record
			{
				if (srCount == 0) {
					new SearchRecord();
					srCount = 1;
				}
			}
		}
	}
	public static void main(String[] args) {
		new MainClass();
	}

}
