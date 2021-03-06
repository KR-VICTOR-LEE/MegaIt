package com.lec.ex1_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex03 extends Frame implements ActionListener{
	private Panel panel;
	private TextField txtfield;
	private Button btnOk, btnExit;
	private List list;

	public Ex03() {
		panel = new Panel();
		txtfield = new TextField(20);
		btnOk = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();
		panel.add(new Label("write"));
		
		panel.add(txtfield);
		panel.add(btnOk);
		panel.add(btnExit);
		
		add(panel, BorderLayout.NORTH);
		add(list, BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400, 150));
		setLocation(200, 50);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // 안보이게
				dispose(); // 자원해제
				System.exit(0); // 강제종료
			}
		});
		// 이벤트 추가 1. implements ActionListener -> override
		//		   2. 이벤트 리스너 추가(V)
		btnOk.addActionListener(this);
		btnExit.addActionListener(this);
		//         3. override된 메소드 안에 로직추가
	}

	public Ex03(String title) {
		this();
		setTitle(title);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk) { // OK버튼 클릭시 수행 로직
			list.add(txtfield.getText().trim().toUpperCase());
			txtfield.setText("");
		}else if (e.getSource() == btnExit) { // 종료 로직
			setVisible(false); // 안보이게
			dispose(); // 자원해제
			System.exit(0); // 강제종료
		}
	}
	public static void main(String[] args) {
		new Ex03();
	}

		
}
