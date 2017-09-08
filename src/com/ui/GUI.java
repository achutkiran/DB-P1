package com.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.naming.directory.SearchResult;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

import org.apache.commons.lang.StringUtils;

import com.mysql.connection.MySQLConnection;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;


public class GUI extends JFrame {

	private JPanel contentPane;
	private final JPanel front = new JPanel();
	private final JPanel searchResults = new JPanel();
	private final JTextField input = new JTextField();
	private final JButton libSearch = new JButton("Search");
	private final JTable table = new JTable();
	private final JPanel checkout = new JPanel();
	private final JTextField cardNum = new JTextField();
	private final JLabel cardNumber = new JLabel("Card Number:");
	private final JButton cardEnter = new JButton("Enter");
	private final JScrollPane scrollPane = new JScrollPane();	
	DefaultTableModel model;
	int selectedRow;
	private final JButton checkIn = new JButton("Check In");
	private final JPanel check = new JPanel();
	private final JTextField BName = new JTextField();
	private final JTextPane txtpnBorrowerName = new JTextPane();
	private final JTextField CardNum = new JTextField();
	private final JTextPane txtpnCardNumber = new JTextPane();
	private final JTextField Isbn = new JTextField();
	private final JTextPane txtpnIsbn = new JTextPane();
	private final JButton checkInBtn = new JButton("Search");
	private final JPanel checkInResult = new JPanel();
	private final JTable checkInTable = new JTable();
	private final JButton checkInResultBtn = new JButton("Check In");
	private final JButton btnAddBorrower = new JButton("Add Borrower");
	private final JPanel BorrowerPn = new JPanel();
	private final JLabel lblName = new JLabel("Name :");
	private final JLabel lblSsn = new JLabel("Ssn :");
	private final JLabel lblPhone = new JLabel("Phone :");
	private final JLabel lblAddress = new JLabel("Address :");
	private final JTextField nameTf = new JTextField();
	private final JTextField ssnTf = new JTextField();
	private final JTextField phoneTf = new JTextField();
	private final JTextField addressTf = new JTextField();
	private final JButton BorrowerDataBtn = new JButton("Enter");
	private final JButton btnFines = new JButton("Fines");
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JPanel finesPn = new JPanel();
	private final JButton btnPayFine = new JButton("Pay Fine");
	private final JButton btnUpdateFines_1 = new JButton("Update Fines");
	private final JPanel payFinesPn = new JPanel();
	private final JTable FinesTb = new JTable();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JPanel finesopPn = new JPanel();
	private final JTable finepayTb = new JTable();
	private final JScrollPane scrollPane_3 = new JScrollPane();
	private final JButton btnPayAll = new JButton("Pay All");
	private final JButton btnNewButton = new JButton("");
	private final JButton btnHome = new JButton("");
	private final JButton btnHome_1 = new JButton("");
	private final JButton btnHome_2 = new JButton("");
	private final JButton btnHome_3 = new JButton("");
	private final JButton btnHome_4 = new JButton("");
	private final JButton btnNewButton_1 = new JButton("");
	private final JButton btnNewButton_2 = new JButton("");
	
	private final Image homeImg = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
	private final JPanel loginPn = new JPanel();
	private final JTextField librarytF = new JTextField();
	private final JTextField userTf = new JTextField();
	private final JPasswordField passwordF = new JPasswordField();
	private final JButton loginbtn = new JButton("login");
	private final JLabel lblNewLabel = new JLabel("library:");
	private final JLabel lblNewLabel_1 = new JLabel("user:");
	private final JLabel lblNewLabel_2 = new JLabel("Password:");
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		userTf.setBounds(136, 104, 200, 20);
		userTf.setColumns(10);
		librarytF.setBounds(136, 42, 200, 20);
		librarytF.setColumns(10);
		addressTf.setBounds(85, 162, 329, 22);
		addressTf.setColumns(10);
		phoneTf.setToolTipText("(000) 000-0000");
		phoneTf.setBounds(85, 118, 329, 22);
		phoneTf.setColumns(10);
		ssnTf.setToolTipText("000-00-0000");
		ssnTf.setBounds(85, 74, 329, 22);
		ssnTf.setColumns(10);
		nameTf.setBounds(85, 29, 329, 20);
		nameTf.setColumns(10);
		Isbn.setBounds(150, 147, 243, 27);
		Isbn.setColumns(10);
		CardNum.setBounds(150, 90, 243, 27);
		CardNum.setColumns(10);
		BName.setBounds(150, 30, 243, 27);
		BName.setColumns(10);
		cardNum.setBounds(152, 70, 228, 27);
		cardNum.setColumns(10);
		input.setToolTipText("isbn,author,book");
		input.setBounds(20, 56, 264, 28);
		input.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(loginPn, "name_91220299912878");
		loginPn.setLayout(null);
		
		loginPn.add(librarytF);
		
		loginPn.add(userTf);
		passwordF.setBounds(136, 169, 200, 20);
		
		loginPn.add(passwordF);
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginMd();
			}
		});
		loginbtn.setBounds(133, 218, 89, 23);
		
		loginPn.add(loginbtn);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(74, 42, 52, 18);
		
		loginPn.add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(80, 106, 46, 14);
		
		loginPn.add(lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(49, 171, 77, 14);
		
		loginPn.add(lblNewLabel_2);
		
		contentPane.add(front, "name_198873792816061");
		front.setLayout(null);
		
		front.add(input);
		libSearch.setToolTipText("");
		libSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchDatabase();
			}
		});
		libSearch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		libSearch.setBounds(294, 56, 109, 28);
		
		front.add(libSearch);
		checkIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				front.setVisible(false);
				check.setVisible(true);
			}
		});
		checkIn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		checkIn.setBounds(36, 184, 89, 23);
		
		front.add(checkIn);
		btnAddBorrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				front.setVisible(false);
				BorrowerPn.setVisible(true);
			}
		});
		btnAddBorrower.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAddBorrower.setBounds(164, 185, 109, 23);
		
		front.add(btnAddBorrower);
		btnFines.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				front.setVisible(false);
				finesPn.setVisible(true);
			}
		});
		btnFines.setBounds(302, 184, 101, 23);
		
		front.add(btnFines);
		contentPane.add(searchResults, "name_198880100383326");
		searchResults.setLayout(null);
		scrollPane.setBounds(10, 25, 414, 216);
		
		searchResults.add(scrollPane);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				selectedRow = table.getSelectedRow();
				String avail= model.getValueAt(selectedRow, 3).toString();
				String isbn = model.getValueAt(selectedRow, 0).toString();
				if(avail.equalsIgnoreCase("available")){
					int choice = JOptionPane.showConfirmDialog(null,"Do you want to check out book with isbn ="+isbn );
					if(choice == JOptionPane.YES_OPTION){
						searchResults.setVisible(false);
						checkout.setVisible(true);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "The book is already checkedOut, Try other book","error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		scrollPane.setViewportView(table);
		btnNewButton.setToolTipText("Home");
		btnNewButton.setIcon(new ImageIcon(homeImg));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel currentPn = (JPanel)((JButton)e.getSource()).getParent();
				goHome(currentPn);
			}
		});
		btnNewButton.setBounds(10, 0, 25, 23);
		
		searchResults.add(btnNewButton);
		
		contentPane.add(checkout, "name_199842767351044");
		checkout.setLayout(null);
		
		checkout.add(cardNum);
		cardNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cardNumber.setBounds(48, 70, 94, 27);
		
		checkout.add(cardNumber);
		cardEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookCheckout();
			}
		});
		cardEnter.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cardEnter.setBounds(166, 163, 89, 23);
		
		checkout.add(cardEnter);
		btnHome.setToolTipText("Home");
		btnHome.setIcon(new ImageIcon(homeImg));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel currentPn = (JPanel)((JButton)e.getSource()).getParent();
				goHome(currentPn);
			}
		});
		btnHome.setBounds(10, 11, 27, 23);
		
		checkout.add(btnHome);
		
		contentPane.add(check, "name_373734470391257");
		check.setLayout(null);
		
		check.add(BName);
		txtpnBorrowerName.setBackground(SystemColor.menu);
		txtpnBorrowerName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnBorrowerName.setText("Borrower Name:");
		txtpnBorrowerName.setBounds(22, 30, 118, 27);
		
		check.add(txtpnBorrowerName);
		
		check.add(CardNum);
		txtpnCardNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnCardNumber.setBackground(SystemColor.menu);
		txtpnCardNumber.setText("Card Number :");
		txtpnCardNumber.setBounds(22, 90, 95, 27);
		
		check.add(txtpnCardNumber);
		
		check.add(Isbn);
		txtpnIsbn.setBackground(SystemColor.menu);
		txtpnIsbn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnIsbn.setText("ISBN :");
		txtpnIsbn.setBounds(68, 147, 49, 27);
		
		check.add(txtpnIsbn);
		checkInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkInSearch();
			}
		});
		checkInBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		checkInBtn.setBounds(185, 204, 89, 23);
		
		check.add(checkInBtn);
		btnHome_1.setToolTipText("Home");
		btnHome_1.setIcon(new ImageIcon(homeImg));
		btnHome_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel currentPn = (JPanel)((JButton)e.getSource()).getParent();
				goHome(currentPn);
			}
		});
		btnHome_1.setBounds(0, 0, 29, 23);
		
		check.add(btnHome_1);
		
		contentPane.add(checkInResult, "name_375731239108433");
		checkInResult.setLayout(null);
		checkInResultBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		checkInResultBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkIn();
			}
		});
		checkInResultBtn.setBounds(157, 218, 89, 23);
		
		checkInResult.add(checkInResultBtn);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 11, 404, 168);
		
		checkInResult.add(scrollPane_1);
		scrollPane_1.setViewportView(checkInTable);
		btnHome_2.setToolTipText("Home");
		btnHome_2.setIcon(new ImageIcon(homeImg));
		btnHome_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel currentPn = (JPanel)((JButton)e.getSource()).getParent();
				goHome(currentPn);
			}
		});
		btnHome_2.setBounds(10, 218, 22, 23);
		
		checkInResult.add(btnHome_2);
		
		contentPane.add(BorrowerPn, "name_377992974142703");
		BorrowerPn.setLayout(null);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setBounds(10, 27, 54, 22);
		
		BorrowerPn.add(lblName);
		lblSsn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSsn.setBounds(10, 72, 46, 22);
		
		BorrowerPn.add(lblSsn);
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPhone.setBounds(10, 118, 46, 22);
		
		BorrowerPn.add(lblPhone);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAddress.setBounds(10, 162, 54, 22);
		
		BorrowerPn.add(lblAddress);
		
		BorrowerPn.add(nameTf);
		
		BorrowerPn.add(ssnTf);
		
		BorrowerPn.add(phoneTf);
		
		BorrowerPn.add(addressTf);
		BorrowerDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertBorrowerData();
			}
		});
		BorrowerDataBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		BorrowerDataBtn.setBounds(158, 207, 89, 23);
		
		BorrowerPn.add(BorrowerDataBtn);
		btnHome_3.setToolTipText("Home");
		btnHome_3.setIcon(new ImageIcon(homeImg));
		btnHome_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel currentPn = (JPanel)((JButton)e.getSource()).getParent();
				goHome(currentPn);
			}
		});
		btnHome_3.setBounds(10, 208, 23, 23);
		
		BorrowerPn.add(btnHome_3);
		
		contentPane.add(finesPn, "name_29000145867780");
		finesPn.setLayout(null);
		btnPayFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finesSearch();
			}
		});
		btnPayFine.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPayFine.setBounds(137, 54, 128, 25);
		
		finesPn.add(btnPayFine);
		btnUpdateFines_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateFine();
			}
		});
		btnUpdateFines_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnUpdateFines_1.setBounds(137, 144, 128, 25);
		
		finesPn.add(btnUpdateFines_1);
		btnHome_4.setToolTipText("Home");
		btnHome_4.setIcon(new ImageIcon(homeImg));
		btnHome_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel currentPn = (JPanel)((JButton)e.getSource()).getParent();
				goHome(currentPn);
			}
		});
		btnHome_4.setBounds(10, 11, 23, 23);
		
		finesPn.add(btnHome_4);
		
		contentPane.add(payFinesPn, "name_29259899930781");
		payFinesPn.setLayout(null);
		scrollPane_2.setBounds(24, 11, 390, 230);
		
		payFinesPn.add(scrollPane_2);
		FinesTb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				payFinesMd();
			}
		});
		scrollPane_2.setViewportView(FinesTb);
		btnNewButton_1.setToolTipText("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel currentPn = (JPanel)((JButton)e.getSource()).getParent();
				goHome(currentPn);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(homeImg));
		btnNewButton_1.setBounds(0, 0, 24, 23);
		
		payFinesPn.add(btnNewButton_1);
		
		contentPane.add(finesopPn, "name_30309680808677");
		finesopPn.setLayout(null);
		scrollPane_3.setBounds(10, 11, 404, 194);
		
		finesopPn.add(scrollPane_3);
		finepayTb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				payFine();
			}
		});
		scrollPane_3.setViewportView(finepayTb);
		btnPayAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				finePayAll();
			}
		});
		btnPayAll.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPayAll.setBounds(158, 216, 89, 23);
		
		finesopPn.add(btnPayAll);
		btnNewButton_2.setToolTipText("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel currentPn = (JPanel)((JButton)e.getSource()).getParent();
				goHome(currentPn);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(homeImg));
		btnNewButton_2.setBounds(10, 216, 25, 23);
		
		finesopPn.add(btnNewButton_2);
	}
	
	/*
	 * searching database for given isbn,name
	 */
	
	private void searchDatabase() {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null; 
		String query = "";
		try {
			connection = MySQLConnection.getConnection();
			statement = connection.createStatement();
			String[] searchInput = input.getText().split(",");
			String isbn="";
			int indexIsbn=-1;
			if(searchInput.length==1){
				if(StringUtils.isNumeric(searchInput[0])){
					isbn = searchInput[0];
					query = "SELECT isbn,title,name,available FROM book natural join book_authors natural join authors WHERE isbn="+isbn;
				}
				else{
					query ="SELECT isbn,title,name,available FROM book natural join book_authors natural join authors WHERE title LIKE \"%"+searchInput[0]+"%\""+
							"UNION "+"SELECT isbn,title,name,available FROM book natural join book_authors natural join authors WHERE name LIKE \"%"+searchInput[0]+"%\"";
				}
				rs = statement.executeQuery(query);
			}
			else{
				int i=0;
				if(StringUtils.isNumeric(searchInput[i])){
					isbn = searchInput[i];
					query = String.format("CREATE TABLE temp%d select isbn,title,name,available FROM book natural join book_authors natural join authors WHERE isbn=",i)+isbn;
				}
				else{
					query = String.format("CREATE TABLE temp%d SELECT isbn,title,name,available FROM book natural join book_authors natural join authors WHERE title LIKE ",i)+"\"%"+searchInput[0]+"%\""+
							"UNION "+"SELECT isbn,title,name,available FROM book natural join book_authors natural join authors WHERE name LIKE \"%"+searchInput[0]+"%\"";
				}
				statement.executeUpdate(query);
				for(i = 1;i<searchInput.length;i++){
					String in = searchInput[i];
					System.out.println("Searching is i :"+i);
					if(StringUtils.isNumeric(in)){
						isbn = in;
						query = String.format("CREATE TABLE temp%d select isbn,title,name,available FROM temp%d WHERE isbn=",i,i-1)+isbn;
					}
					else{
						query = String.format("CREATE TABLE temp%d select isbn,title,name,available FROM temp%d WHERE name like",i,i-1)+"\"%"+in+"%\" UNION "+String.format("select isbn,title,name,available FROM temp%d WHERE title LIKE ",i-1)+"\"%"+in+"%\"";
					}
					statement.executeUpdate(query);
					query = String.format("DROP TABLE temp%d", i-1);
					statement.executeUpdate(query);
				}
				query = String.format("SELECT * FROM temp%d",i-1);
				rs = statement.executeQuery(query);
				Statement s = connection.createStatement();
				query = String.format("DROP TABLE temp%d", i-1);
				s.executeUpdate(query);
				
			}
			if (rs.next()) {
				rs.beforeFirst();
				TableModel m = DbUtils.resultSetToTableModel(rs);
				table.setModel(m);
				front.setVisible(false);
				searchResults.setVisible(true);
				checkout.setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(null, "Sorry can't find required book. Try again","error",JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	/*
	 * Checking out book
	 */
	
	
	public void bookCheckout(){
		String number = cardNum.getText();
		String isbn = model.getValueAt(selectedRow, 0).toString();
		String query="SELECT noBooks,card_id,loan_id FROM borrower natural join book_loans WHERE card_id="+number;
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		PreparedStatement pstmt = null;
		int cardId=Integer.parseInt(number);
		try {
			connection = MySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()){
				//rs.beforeFirst();
				cardId = rs.getInt("card_id");
				int n = rs.getInt("noBooks");
				int loan_id = rs.getInt("loan_id");
				query = "Select paid from fines where loan_id = "+ loan_id;
				boolean paid = true;
				rs = statement.executeQuery(query);
				while(rs.next()){
					paid = paid && rs.getBoolean("paid");
				}
				if(n<3 && paid){
					System.out.println("hi");
					java.util.Date date=new java.util.Date();
			        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
			        query = "SELECT DATE_ADD(\""+sqlDate+"\", INTERVAL 14 DAY)";
			        rs = statement.executeQuery(query);
			        query =  "INSERT INTO book_loans(isbn,card_id,date_out,due_date) VALUES (?,?,?,?)";
					pstmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, isbn);
					pstmt.setInt(2, cardId);
					
					pstmt.setDate(3, sqlDate);
					rs.next();
					pstmt.setDate(4, rs.getDate(1));
					pstmt.executeUpdate();
					query = "UPDATE book SET available = ?  WHERE isbn= ?";
					pstmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, "not available");
					pstmt.setString(2, isbn);
					pstmt.executeUpdate();
					query = "UPDATE borrower SET noBooks = ?  WHERE card_id= ?";
					pstmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
					pstmt.setInt(1, n+1);
					pstmt.setInt(2, cardId);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Book checkedout","sucess",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					if(n>=3){
						JOptionPane.showMessageDialog(null, "You are already at your limit","error",JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "You have not paid fine","error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else{
				java.util.Date date=new java.util.Date();
		        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		        query = "SELECT DATE_ADD(\""+sqlDate+"\", INTERVAL 14 DAY)";
		        rs = statement.executeQuery(query);
		        query =  "INSERT INTO book_loans(isbn,card_id,date_out,due_date) VALUES (?,?,?,?)";
				pstmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, isbn);
				pstmt.setInt(2, cardId);
				
				pstmt.setDate(3, sqlDate);
				rs.next();
				pstmt.setDate(4, rs.getDate(1));
				pstmt.executeUpdate();
				query = "UPDATE book SET available = ?  WHERE isbn= ?";
				pstmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, "not available");
				pstmt.setString(2, isbn);
				pstmt.executeUpdate();
				query = "UPDATE borrower SET noBooks = ?  WHERE card_id= ?";
				pstmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, 1);
				pstmt.setInt(2, cardId);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Book checkedout","sucess",JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Entered card id is not present","error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		checkout.setVisible(false);
		front.setVisible(true);
	}
	
	
	/*
	 * searching for book to check in
	 */
	
	public void checkInSearch(){
		
		String isbn = Isbn.getText();
		String name = BName.getText();
		String carN = CardNum.getText();
		String query="SELECT isbn,card_id,bname,loan_id FROM borrower natural join book_loans WHERE ";
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		PreparedStatement pstmt = null;
		try {
			connection = MySQLConnection.getConnection();
			statement = connection.createStatement();
			if(isbn.length()!=0){
				query += "isbn = "+isbn+" and ";
			}
			if(name.length()!=0){
				query += "bname LIKE \"%"+name+"%\" and ";
			}
			if(carN.length()!=0){
				query += "card_id = "+carN;
			}
			else{
				query = query.substring(0, query.length()-4);
			}
			query = query + " and date_in is null";
			System.out.println(query);
			rs = statement.executeQuery(query);
			if (rs.next()) {
				rs.beforeFirst();
				TableModel m = DbUtils.resultSetToTableModel(rs);
				checkInTable.setModel(m);
				check.setVisible(false);
				checkInResult.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "Sorry can't find required information, Please try again","error",JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//check.setVisible(false);
		//checkInResult.setVisible(true);
		
	}
	
	/*
	 * Checking in book
	 */
	
	public void checkIn(){
		DefaultTableModel checkInModel = (DefaultTableModel) checkInTable.getModel();
		selectedRow = checkInTable.getSelectedRow();
		String isbn = checkInTable.getValueAt(selectedRow, 0).toString();
		int cardId = Integer.parseInt(checkInTable.getValueAt(selectedRow, 1).toString());
		int loanId = Integer.parseInt(checkInTable.getValueAt(selectedRow, 3).toString());
		int noBooks = 0 ;
		String query=null;
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement statement = null;
		java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		try {
			connection = MySQLConnection.getConnection();
			statement = connection.createStatement();
			query = "UPDATE book SET available = ?  WHERE isbn= ?";
			pstmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, "available");
			pstmt.setString(2, isbn);
			pstmt.executeUpdate();
			query = "SELECT noBooks FROM borrower WHERE card_id = "+cardId;
			rs = statement.executeQuery(query);
			if(rs.next()){
				noBooks = rs.getInt("noBooks");
			}
			query = "UPDATE borrower SET noBooks = ?  WHERE card_id= ?";
			pstmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, noBooks-1);
			pstmt.setInt(2, cardId);
			pstmt.executeUpdate();
			query = "UPDATE book_loans SET date_in = ? WHERE loan_id = ? ";
			pstmt=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, sqlDate);
			pstmt.setInt(2, loanId);
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Book Checked In","Sucess",JOptionPane.INFORMATION_MESSAGE);
			checkInResult.setVisible(false);
			front.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Creating a new id for new borrower
	 */
	
	public void insertBorrowerData(){
		String ssn = ssnTf.getText();
		String name = nameTf.getText();
		String address = addressTf.getText();
		String phone = phoneTf.getText();
		if(ssn.length()==0 || name.length()==0 || address.length() == 0){
			JOptionPane.showMessageDialog(null, "You have to enter ssn , name, address","error",JOptionPane.ERROR_MESSAGE);
		}
		else{
			try {
				String query=null;
				ResultSet rs = null;
				Connection connection = MySQLConnection.getConnection();
				PreparedStatement pstmt = null;
				if(phone.length()==0){
					query = "INSERT INTO borrower(ssn,bname,address,noBooks)"+"VALUES(?,?,?,?)";
					pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, ssn);
					pstmt.setString(2, name);
					pstmt.setString(3, address);
					pstmt.setInt(4, 0);
					pstmt.executeUpdate();
				}
				else{
					query = "INSERT INTO borrower(ssn,bname,address,noBooks,phone)"+"VALUES(?,?,?,?,?)";
					pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, ssn);
					pstmt.setString(2, name);
					pstmt.setString(3, address);
					pstmt.setInt(4, 0);
					pstmt.setString(5, phone);
					pstmt.executeUpdate();
				}
				JOptionPane.showMessageDialog(null, "New Borrower is added into database","Sucess",JOptionPane.INFORMATION_MESSAGE);
				BorrowerPn.setVisible(false);
				front.setVisible(true);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "The entry with given details already exits, Try again","error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();	
			}
		}
	}
	
	/*
	 * Updating fines
	 */
	
	public void updateFine(){
		String query=null;
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement statement = null;
		java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		try {
			connection = MySQLConnection.getConnection();
			statement = connection.createStatement();
			query = "SELECT loan_id,due_date,date_in FROM book_loans WHERE due_date > "+sqlDate;
			rs = statement.executeQuery(query);
			while(rs.next()){
				String fine ="";
				int loan_id = rs.getInt("loan_id");
				System.out.println(loan_id);
				java.sql.Date due_date = rs.getDate("due_date");
				java.sql.Date date_in = rs.getDate("date_in");
				if(date_in!=null){
					if(date_in.compareTo(due_date)>0){
						long difference =  (date_in.getTime()-due_date.getTime())/86400000;
						long days = Math.abs(difference);
						double f = days * 0.25;
						fine = new DecimalFormat("#0.00").format(f);
					}
					
				}
				else{
					long difference =  (sqlDate.getTime()-due_date.getTime())/86400000;
					long days = Math.abs(difference);
					double f = days * 0.25;
					fine = new DecimalFormat("#0.00").format(f);
				}
				if(fine.length()!=0){
					query ="SELECT paid FROM fines WHERE loan_id="+loan_id;
					Statement statement1 = connection.createStatement();
					ResultSet rs1 = statement1.executeQuery(query);
					if(rs1.next()){
						if(!rs1.getBoolean("paid")){
							query = "UPDATE fines SET fine_amt = ?  WHERE loan_id= ?";
							pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
							pstmt.setString(1, fine);
							pstmt.setInt(2, loan_id);
							pstmt.executeUpdate();
						}
						
					}
					else{
						query = "INSERT INTO fines(loan_id,fine_amt,paid)"+"VALUES(?,?,?)";
						pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
						pstmt.setInt(1, loan_id);
						pstmt.setString(2, fine);
						pstmt.setBoolean(3, false);
						pstmt.executeUpdate();
					}
				}
			}
			JOptionPane.showMessageDialog(null, "The Fines were updated","sucess",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Searching for fines to pay
	 */
	
	public void finesSearch(){
		String query=null;
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement statement = null;
		try {
			connection = MySQLConnection.getConnection();
			statement = connection.createStatement();
			query = "SELECT card_id, SUM(fine_amt) AS total_fine FROM fines natural join book_loans natural join borrower WHERE paid = \"false\" GROUP BY card_id";
			rs = statement.executeQuery(query);
			if (rs.next()) {
				rs.beforeFirst();
				TableModel m = DbUtils.resultSetToTableModel(rs);
				FinesTb.setModel(m);
				finesPn.setVisible(false);
				payFinesPn.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "There are no fines to be paid","error",JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * displaying fines for selected user
	 */
	
	public void payFinesMd(){
		DefaultTableModel m = (DefaultTableModel) FinesTb.getModel();
		int selectedRow = FinesTb.getSelectedRow();
		int card_id = Integer.parseInt(FinesTb.getValueAt(selectedRow, 0).toString());
		String query=null;
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement statement = null;
		try {
			connection = MySQLConnection.getConnection();
			statement = connection.createStatement();
			query = "SELECT loan_id, isbn, fine_amt FROM fines natural join borrower natural join book_loans WHERE paid = \"false\" and card_id = "+ card_id;
			rs = statement.executeQuery(query);
			if (rs.next()) {
				 rs.beforeFirst();
				TableModel m1 = DbUtils.resultSetToTableModel(rs);
				finepayTb.setModel(m1);
				payFinesPn.setVisible(false);
				finesopPn.setVisible(true);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Paying fines for selected book
	 */
	
	public void payFine(){
		DefaultTableModel m = (DefaultTableModel) finepayTb.getModel();
		int selectedRow = finepayTb.getSelectedRow();
		int loan_id = Integer.parseInt(finepayTb.getValueAt(selectedRow, 0).toString());
		String query=null;
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement statement = null;
		try {
			connection = MySQLConnection.getConnection();
			statement = connection.createStatement();
			query = "SELECT date_in,isbn FROM book_loans WHERE loan_id = "+loan_id;
			rs = statement.executeQuery(query);
			rs.next();
			String isbn = rs.getString("isbn");
			Date date_in = rs.getDate("date_in");
			if(date_in!=null){
				query = "UPDATE fines SET paid = ? WHERE loan_id = ?";
				pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				pstmt.setBoolean(1, true);
				pstmt.setInt(2, loan_id);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "The Fine was paid","sucess",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "you have not returend book with isbn ="+isbn+" yet","error",JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Paying fines of all the books
	 */
	
	public void finePayAll(){
		DefaultTableModel m = (DefaultTableModel) finepayTb.getModel();
		int rows = finepayTb.getRowCount();
		String query=null;
		ResultSet rs = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement statement = null;
		try {
			connection = MySQLConnection.getConnection();
			statement = connection.createStatement();
			for(int i = 0 ; i<rows;i++){
				int loan_id = Integer.parseInt(finepayTb.getValueAt(i, 0).toString());
				System.out.println(loan_id);
				query = "SELECT date_in,isbn FROM book_loans WHERE loan_id = "+loan_id;
				rs = statement.executeQuery(query);
				rs.next();
				String isbn = rs.getString("isbn");
				Date date_in = rs.getDate("date_in");
				if(date_in!=null){
					query = "UPDATE fines SET paid = ? WHERE loan_id = ?";
					pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
					pstmt.setBoolean(1, true);
					pstmt.setInt(2, loan_id);
					pstmt.executeUpdate();
				}
				else{
					JOptionPane.showMessageDialog(null, "you have not returend book with isbn ="+isbn+" yet","error",JOptionPane.ERROR_MESSAGE);
				}
			}
			JOptionPane.showMessageDialog(null, "The Fines were paid","sucess",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * going to home panel from present panel
	 */
	
	public void goHome(JPanel currentPn){
		currentPn.setVisible(false);
		front.setVisible(true);
	}
	
	/*
	 * inputting login credentials
	 */
	
	public void loginMd(){
		String library = librarytF.getText();
		String user = userTf.getText();
		String pass = passwordF.getText();
		MySQLConnection.set(library,user,pass);
		loginPn.setVisible(false);
		front.setVisible(true);
		
	}
}

