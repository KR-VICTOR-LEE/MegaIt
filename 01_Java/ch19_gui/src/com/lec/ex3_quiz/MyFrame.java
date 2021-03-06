package com.lec.ex3_quiz;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lec.ex2_swing.Ex03_GUI;

public class MyFrame extends JFrame implements ActionListener {
	
		private Container contenPane; 
		private JPanel jp, jp2; 
		private JTextField txtName, txtTel, txtage;
		private ImageIcon icon, icon2;
		private JButton btnIn, btnOut;
		private ArrayList<Person> persons;
		
	
		
		public MyFrame(String title) {
			super(title);
			persons = new ArrayList<Person>();
			setDefaultCloseOperation(EXIT_ON_CLOSE); 
			contenPane = getContentPane();
			jp = new JPanel(new GridLayout(3,2));
			jp2 = new JPanel(new FlowLayout());
			txtName = new JTextField();
			txtTel = new JTextField();
			txtage = new JTextField();
			icon2 = new ImageIcon("icon/join.png");
			btnIn = new JButton("가입", icon);
			icon = new ImageIcon("icon/output.png");
			btnOut = new JButton("출력", icon);
			
			
			
			jp.add(new JLabel("이   름 ", (int)CENTER_ALIGNMENT));
			jp.add(txtName);
			jp.add(new JLabel("전   화 ", (int)CENTER_ALIGNMENT));
			jp.add(txtTel);
			jp.add(new JLabel("나   이 ", (int)CENTER_ALIGNMENT));
			jp.add(txtage);
			jp.add(btnIn);
			jp.add(btnOut);
			
			contenPane.add(jp, BorderLayout.CENTER);
			contenPane.add(jp2, BorderLayout.SOUTH);
			
			
			
			setVisible(true);
//			setSize(new Dimension(400,300));
//			setLocation(200,100);
			setBounds(200,100,300,200);
			
			
			// 이벤트 추가
			
			btnIn.addActionListener(this);
			btnOut.addActionListener(this);
			
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnIn) {
				
			}
			
			
			
			
			
			
			
			//----------------------------------------------------
			if(e.getSource() == btnOut) {
				// txtName, txtTel , txtage 에 입력된 값을 jta에 출력
				String name = txtName.getText().trim();
				String tel = txtTel.getText().trim();
				if(name.equals("") || tel.equals("")) {
					System.out.println("이름과 전화번호는 필수 입력 사항입니다.");
					return;
				}
				if(tel.indexOf("-")==tel.lastIndexOf("-") ||
						tel.indexOf("-")<2||
						tel.lastIndexOf("-")>10) {
					System.out.println("전화번호 형식을 확인해 주세요.");
					return;
				}
				// 나이체크
				int age=0;
				try {
					age  =  Integer.parseInt(txtage.getText());
					if(age < 0 || age>150) {
						System.out.println("유효하지 않는 나이를 입력할 경우 0살로");
						age = 0;
					}
				} catch (Exception e2) {
					System.out.println("유효하지 않는 나이를 입력하셨습니다.");
				}
				
			
			}
		}
		public static void main(String[] args) {
			new Ex03_GUI("");
			
		}
}
