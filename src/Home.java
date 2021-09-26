import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;

public class Home extends JFrame {

	JFrame frame;
	JPanel tablePanel;
	JTable userDataTable;
	JScrollPane userDataScrollPane;
	
	public Home() throws SQLException {
		initFrame();
	}
	
	public void initTableData() throws SQLException {
		
		tablePanel = new JPanel();
		
		UserDAO userDAO = new UserDAO();
		Vector<Object> column = new Vector<>();
		
		column.add("Name");
		column.add("Address");
		column.add("Gender");
		column.add("Age");
		
		userDataTable = new JTable(userDAO.getUserData(), column);
		userDataTable.setEnabled(false);
		
		userDataScrollPane = new JScrollPane(userDataTable);
		userDataScrollPane.setPreferredSize(new Dimension(450, 200));
		userDataScrollPane.setBorder(new EmptyBorder(30, 0, 0, 0));
		
		tablePanel.add(userDataScrollPane);
		
		add(tablePanel, BorderLayout.CENTER);
		
	}
	
	public void initFrame() throws SQLException {
		
		frame = new JFrame();
		initTableData();
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Home");
		setVisible(true);
		
	}

}
