package com.lec.ex4_customer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener {
	// DAO
	CustomerDao dao = CustomerDao.getInstance();
	// ȭ�鱸��
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField txtCid, txtCtel, txtCname, txtCpoint, txtCamount;
	private Vector<String> levelnames;
	private JComboBox<String> comLevelName;
	private JButton btnCidSearch, btnCtelSearch, btnCnameSearch, btnCBuyWithPoint;
	private JButton btnBuy, btnLevelNameOuput, btnAllOutput, btnInsert, btnCTelUpdate, btnDelete, btnExit;
	private JTextArea txtpool;
	private JScrollPane scrollpane;

	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������Ʈ ��ü ����
		
		container = getContentPane(); // �����̳ʴ� �⺻�� BorderLayout
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3)); // �г��� �⺻�� FlowLayout
		jpbtn = new JPanel();
		txtCid = new JTextField(20);
		txtCtel = new JTextField(20);
		txtCname = new JTextField(20);
		txtCpoint = new JTextField(20);
		txtCamount = new JTextField(20);
		levelnames = dao.getLevelNames();
		comLevelName = new JComboBox<String>(levelnames);
		btnCidSearch = new JButton("���̵�˻�");
		btnCtelSearch = new JButton("��4�ڸ�(FULL)�˻�");
		btnCnameSearch = new JButton("���̸��˻�");
		btnCBuyWithPoint = new JButton("����Ʈ�θ�����");
		btnBuy = new JButton("��ǰ����");
		btnLevelNameOuput = new JButton("��޺����");
		btnAllOutput = new JButton("��ü���");
		btnInsert = new JButton("ȸ������");
		btnCTelUpdate = new JButton("��ȣ����");
		btnDelete = new JButton("ȸ��Ż��");
		btnExit = new JButton("������");
		txtpool = new JTextArea(6, 70);
		scrollpane = new JScrollPane(txtpool);
		// �����̳ʿ� ������Ʈ ��ġ
		jpup.add(new JLabel("��  ��  ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("����ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("���̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("��  ��  Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnCBuyWithPoint);
		jpup.add(new JLabel("���űݾ�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCamount);
		jpup.add(new JLabel()); // 5�� 3���� �� �� �߰�
		jpup.add(new JLabel("�����", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOuput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCTelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollpane);
		setVisible(true);
		setSize(new Dimension(800, 400));
		setLocation(200, 100);
		txtpool.setText("\t ���˻� �� �����ϼ���");

		// �̺�Ʈ �߰�
		btnCidSearch.addActionListener(this);
		btnCtelSearch.addActionListener(this);
		btnCnameSearch.addActionListener(this);
		btnCBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOuput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCTelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCidSearch) { // ���̵�˻�
			// cid �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			int cid;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
			} catch (Exception e2) {
				txtpool.setText("��ȿ�� �� ID�� �Է��Ͻ� �� �˻��ϼ��� ");
				return;
			}
			CustomerDto customer = dao.cIdGetCustomer(cid);
			if (customer != null) {
				// txtCid.setText(String.valueOf(customer.getCid()));
				txtCtel.setText(customer.getCtel());
				txtCname.setText(customer.getCname());
				txtCpoint.setText(String.valueOf(customer.getCpoint()));
				txtCamount.setText(""); // ��ǰ���ž� ���� ����
				comLevelName.setSelectedItem(customer.getLevelName());
				txtpool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtpool.append("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
				txtpool.append(customer.toString());
			} else {
				txtpool.setText("�˻����� ���� ID�Դϴ�");
				txtCtel.setText("");
				txtCname.setText("");
				txtCpoint.setText("");
				txtCamount.setText("");
				comLevelName.setSelectedItem("");
			}
		} else if (e.getSource() == btnCtelSearch) { // ��4�ڸ��˻�
			txtCid.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCtel.getText().trim();
			if (ctel.length() < 4) {
				txtpool.setText("��� ��4�ڸ� �̻��� �Է��Ͽ��� �˻��˴ϴ�");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.cTelGetCustomer(ctel);
			if (customers.size() != 0) { // ���
				txtpool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtpool.append("����������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDto customer : customers) {
					txtCid.setText(String.valueOf(customer.getCid()));
					txtCname.setText(customer.getCname());
					txtCtel.setText(customer.getCtel());
					txtCpoint.setText(String.valueOf(customer.getCpoint()));
					txtCamount.setText(""); // ��ǰ������ �ݾ��� �־��� ������ textField
					comLevelName.setSelectedItem(customer.getLevelName());
					txtpool.append(customer.toString() + "\n");
				}
			} else {
				txtpool.setText("��ϵ� ��ȣ ����");
			}
		} else if (e.getSource() == btnCnameSearch) { // �̸��˻�
			txtCid.setText("");
			txtCtel.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String cname = txtCname.getText().trim();
			if (cname.length() < 2) {
				txtpool.setText("��� �̸��� 2���� �̻��� �Է��Ͽ��� �˻��˴ϴ�");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.cNameGetCustomer(cname);
			if (customers.size() != 0) { // ���
				txtpool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtpool.append("����������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDto customer : customers) {
					txtCid.setText(String.valueOf(customer.getCid()));
					txtCname.setText(customer.getCname());
					txtCtel.setText(customer.getCtel());
					txtCpoint.setText(String.valueOf(customer.getCpoint()));
					txtCamount.setText(""); // ��ǰ������ �ݾ��� �־��� ������ textField
					comLevelName.setSelectedItem(customer.getLevelName());
					txtpool.append(customer.toString() + "\n");
				}
			} else {
				txtpool.setText("�ش� �̸��� ���� �˻����� �ʽ��ϴ�. ȸ������ ���ּ���");
			}
		} else if (e.getSource() == btnCBuyWithPoint) { // ����Ʈ����
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
				if (cpoint < camount) {
					txtpool.setText("����Ʈ ����");
					return;
				}

			} catch (Exception e2) {
				txtpool.setText("��ȿ�� ��ID�� point�� ���űݾ��� �Է��Ͻ� �� �����ϼ���");
				return;
			}
			int result = dao.buyWithPoint(cid, camount);
			if (result == CustomerDao.SUCCESS) {
				txtpool.setText("����Ʈ ���� ����");
				txtCpoint.setText(String.valueOf(cpoint - camount));
				txtCamount.setText("");
			} else {
				txtpool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�. �� �˻� �� ������ �ּ���");
			}
		} else if (e.getSource() == btnBuy) { // ��ǰ����
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCamount.getText().trim());
			} catch (Exception e2) {
				txtpool.setText("��ȿ�� �� ID�� �˻� �� , ���űݾ��� �Է��Ͻð� �����ϼ���");
				return;
			}
			int result = dao.buy(cid, camount);
			if (result == CustomerDao.SUCCESS) {
				txtpool.setText("��ǰ ���� �Ϸ�");
				txtCpoint.setText(String.valueOf(cpoint + (int) (camount * 0.05)));
				txtCamount.setText("");
			} else {
				txtpool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�.");
			}
		} else if (e.getSource() == btnLevelNameOuput) { // ��޺� ���
			// levelName �Է� �޺��ڽ� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			// comLevelName.setSelectedItem("");
			String levelName = comLevelName.getSelectedItem().toString();
			if (levelName.length() == 0) {
				txtpool.setText("���ϴ� ����� �����Ͻð� �˻��ϼ���");
				return;
			} // if
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomer(levelName);
			if (customers.size() != 0) { // ���
				txtpool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtpool.append("����������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDto customer : customers) {
					txtpool.append(customer.toString() + "\n");
				}
				txtpool.append("�� " + customers.size() + "��");
			} else {
				txtpool.setText("�ش� ������ ���� �˻����� �ʽ��ϴ�. ȸ������ ���ּ���");
			}
		} else if (e.getSource() == btnAllOutput) { // ��ü���
			// ��� �Է� ���۳�Ʈ�� ������� ���� ����
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedIndex(0);
			ArrayList<CustomerDto> customers = dao.getCustomers();
			if (customers.size() != 0) {
				txtpool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtpool.append("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
				for (CustomerDto customer : customers) {
					txtpool.append(customer.toString() + "\n");
				}
				txtpool.append("��" + customers.size() + "��");
			} else {
				txtpool.setText("�ش� ������ ���� �˻����� �ʽ��ϴ�.");
			}
		} else if (e.getSource() == btnInsert) { // ȸ������
			// ctel, cname �Է¶��� ��ȸ�ϰ� �� ��Ʈ�� �� �ʱⰪ���� ����
			txtCid.setText("");
			txtCpoint.setText("1000");
			txtCamount.setText("");
			comLevelName.setSelectedItem("NORMAL");
			String ctel = txtCtel.getText().trim();
			String cname = txtCname.getText().trim();
			if (ctel.length() < 8 || cname.length() < 2) {
				txtpool.setText("��ȭ��ȣ�� �̸��� �ʼ� �Է»��� �Դϴ�.");
				return;
			}
			int result = dao.insertCustomer(ctel, cname);
			if (result == CustomerDao.SUCCESS) {
				txtpool.setText("ȸ������ �����մϴ�. ����Ʈ 1000���� ���Լ����� �帳�ϴ�");

			}
		} else if (e.getSource() == btnCTelUpdate) { // ��ȣ����
			int cid;
			String ctel;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				ctel = txtCtel.getText().trim();
				if (ctel.length() < 8) {
					txtpool.setText("������ ��ȭ��ȣ�� Ȯ���� �ּ���");
					return;
				}
			} catch (Exception e2) {
				txtpool.setText("��ȿ�� �� ID�� �˻� �� �����ϼ���");
				return;
			}
			int result = dao.updateCustomer(cid, ctel);
			if (result == CustomerDao.SUCCESS) {
				txtpool.setText("��ȭ��ȣ�� �����Ǿ����ϴ�.");
			} else {
				txtpool.setText("��ȿ�� �� ID�� �˻� �� �����ϼ���");
			}
		} else if (e.getSource() == btnDelete) { // ȸ��Ż��
			// ctel �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCtel.getText().trim();
			if (ctel.equals("")) {
				txtpool.setText("��ȭ��ȣ�� �Է� �� ȸ��Ż�� ������ �ּ���");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if (result == CustomerDao.SUCCESS) {
				txtpool.setText("ȸ��Ż�� �Ϸ�");
			} else {
				txtpool.setText("��ϵ� ��ȭ��ȣ�� �����ϴ�.");
			}
		} else if (e.getSource() == btnExit) { // ������
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CustomerMng("���۸���");
	}
}
