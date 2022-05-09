package com.test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener {
	CustomerDao dao = CustomerDao.getInstance();

	private Container container;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scrollpane;

	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		container = getContentPane();
		container.setLayout(new FlowLayout());

		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel();
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField(15);

		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");

		jta = new JTextArea(15, 30);
		scrollpane = new JScrollPane(jta);

		jpup.add(new JLabel("폰번호", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이  름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트", (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);

		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);

		container.add(jpup);
		container.add(jpdown);
		container.add(scrollpane);
		setVisible(true);
		setSize(new Dimension(400, 450));
		setLocation(200, 100);

		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) { // 가입
			
			txtPoint.setText("1000");
			String ctel = txtPhone.getText().trim();
			String cname = txtName.getText().trim();
			if (ctel.length() < 8 || cname.length() < 2) {
				jta.setText("전화번호와 이름은 필수 입력 입니다");
				return;
			}
			int result = dao.insertCustomer(ctel, cname);
			if (result == CustomerDao.SUCCESS) {
				jta.setText("회원가입 완료, 기압포인트 1000점 ");
			}
		} else if (e.getSource() == btnSearch) { // 폰검색
			txtName.setText("");
			String ctel = txtPhone.getText().trim();
			if (ctel.length() < 4) {
				jta.setText("4자리 이상 입력하세요");
				return;
			}
			ArrayList<CustoemrDto> customers = dao.cTelGetCustomer(ctel);
			if (customers.size() == 0) {
				jta.setText("입력한 번호의 회원이 존재하지 않습니다.");
			
			} else if(customers.size()==1){
				 {
					txtPhone.setText(customers.get(0).getCtel());
					txtName.setText(customers.get(0).getCname());
					jta.setText("");
				}
			} else if(customers.size()>=1){
				 {
					jta.setText("\"회원번호\t전화번호\t이름\t포인트\n");
					for(CustoemrDto customer : customers) {
						jta.append(customer.toString() + "\n");
					}
				}
			}

		} else if (e.getSource() == btnOutput) { // 전체출력
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("");
			ArrayList<CustoemrDto> customers = dao.getCustomers();
			jta.setText("회원번호\t전화번호\t이름\t포인트\n");
			for (CustoemrDto customer : customers) {
				jta.append(customer.toString() + "\n");
			}
			jta.append("총" + customers.size() + "명");
		
		
		} else if (e.getSource() == btnExit) { //종료
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new CustomerMng("회원관리");
	}
}
