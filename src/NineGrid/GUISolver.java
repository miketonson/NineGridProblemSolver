package NineGrid;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class GUISolver {

	private JFrame frame;
	private JTextField txtNineGridProblem;
	private JTextField[][] txtNineSquare;
	private ArrayList<NineSquare> resultList;
	private JButton btnNewButton_2;
	/**
	 * Launch the application.
	 */
	public static void creatWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISolver window = new GUISolver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUISolver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Solve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2.setVisible(false);
				Integer[][] nineSquare = new Integer[9][9];
				//System.out.println(txtNineSquare[0][0].getText());
				for(int i=0; i<9; i++){
					for(int j=0; j<9; j++){
						if(txtNineSquare[i][j].getText().equals("")){
							nineSquare[i][j] = 0;
							continue;
						}
						if(txtNineSquare[i][j].getText().length() > 1){
							txtNineGridProblem.setText("Something wrong with input");
							return;
						}
						if(!Character.isDigit(txtNineSquare[i][j].getText().charAt(0))){
							txtNineGridProblem.setText("Input must be a number");
							return;
						}
						if(Integer.parseInt(txtNineSquare[i][j].getText()) < 1 || Integer.parseInt(txtNineSquare[i][j].getText()) > 9){
							txtNineGridProblem.setText("Input must be a number between 1 and 9");
							return;
						}
						nineSquare[i][j] = Integer.parseInt(txtNineSquare[i][j].getText());
						txtNineSquare[i][j].setBackground(Color.LIGHT_GRAY);
					}
				}
				if(!SquareGame.hasSameNum(nineSquare)){
					txtNineGridProblem.setText("Have same number in row, column, or square");
					return;
				}
				NineSquare initSquare = new NineSquare(nineSquare);
				CalculateNineSquare calculate = new CalculateNineSquare();
				resultList = new ArrayList<NineSquare>();
				if(!calculate.calculateResult(initSquare)){
					txtNineGridProblem.setText("We already have a answer");
					return;
				}
				resultList = calculate.returnResult();
				txtNineGridProblem.setText("There are " + resultList.size() + " result for this problem");
				if(resultList.size() == 0){
					return;
				}
				if(resultList.size() > 1){
					btnNewButton_2.setVisible(true);
				}
				NineSquare resultNineSquare = resultList.remove(resultList.size()-1);
				for(int i=0; i<9; i++){
					for(int j=0; j<9; j++){
						txtNineSquare[i][j].setText(resultNineSquare.getNineSquare()[i][j].toString());
					}
				}
			}
		});
		panel.add(btnNewButton, BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNineGridProblem.setText("Nine Grid Problem Solver");
				resultList = null;
				btnNewButton_2.setVisible(false);
				for(int i=0; i<9; i++){
					for(int j=0; j<9; j++){
						txtNineSquare[i][j].setText("");
						txtNineSquare[i][j].setBackground(Color.white);
					}
				}
			}
		});
		panel.add(btnNewButton_1, BorderLayout.WEST);
		
		btnNewButton_2 = new JButton("Next");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNineGridProblem.setText("There are " + resultList.size() + " result left");
				if(resultList.size() == 0){
					return;
				}
				if(resultList.size() == 1){
					btnNewButton_2.setVisible(false);
				}
				NineSquare resultNineSquare = resultList.remove(resultList.size()-1);
				for(int i=0; i<9; i++){
					for(int j=0; j<9; j++){
						txtNineSquare[i][j].setText(resultNineSquare.getNineSquare()[i][j].toString());
					}
				}
			}
		});
		panel.add(btnNewButton_2, BorderLayout.EAST);
		btnNewButton_2.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		txtNineGridProblem = new JTextField();
		txtNineGridProblem.setBackground(Color.LIGHT_GRAY);
		txtNineGridProblem.setEditable(false);
		txtNineGridProblem.setHorizontalAlignment(SwingConstants.CENTER);
		txtNineGridProblem.setText("Nine Grid Problem Solver");
		panel_1.add(txtNineGridProblem, BorderLayout.NORTH);
		txtNineGridProblem.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(3, 3, 3, 3));
		JPanel[][] panelNine = new JPanel[3][3];
		txtNineSquare = new JTextField[9][9];
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				panelNine[i][j] = new JPanel();
				panelNine[i][j].setLayout(new GridLayout(3,3));
				for(int k=i*3; k<i*3+3; k++){
					for(int h=j*3; h<j*3+3; h++){
						txtNineSquare[k][h] = new JTextField();
						txtNineSquare[k][h].setHorizontalAlignment(SwingConstants.CENTER);
						panelNine[i][j].add(txtNineSquare[k][h]);
					}
				}
				panel_2.add(panelNine[i][j]);
			}
		}
	}

}
