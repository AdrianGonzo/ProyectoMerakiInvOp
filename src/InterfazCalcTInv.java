import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;

public class InterfazCalcTInv extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldK;
	private JTextField textFieldC;
	private JTextField textFieldH;
	private JTextField textFieldD;
	private JTextField textFieldL;
	

	/**
	 * Create the frame.
	 */
	public InterfazCalcTInv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBoton = new JPanel();
		contentPane.add(panelBoton, BorderLayout.SOUTH);
		panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnCalcular = new JButton("Calcular");
		panelBoton.add(btnCalcular);
		
		JLabel lblCalcVar = new JLabel("Calcular Variables");
		lblCalcVar.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCalcVar, BorderLayout.NORTH);
		
		JPanel panelDatos = new JPanel();
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(3, 2, 0, 0));
		
		JPanel panel11 = new JPanel();
		panelDatos.add(panel11);
		panel11.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblK = new JLabel("Costo de ordenar (k)");
		lblK.setHorizontalAlignment(SwingConstants.CENTER);
		panel11.add(lblK);
		
		textFieldK = new JTextField();
		panel11.add(textFieldK);
		textFieldK.setColumns(10);
		
		JPanel panel12 = new JPanel();
		panelDatos.add(panel12);
		panel12.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblC = new JLabel("Costo unitario (c)");
		panel12.add(lblC);
		
		textFieldC = new JTextField();
		panel12.add(textFieldC);
		textFieldC.setColumns(10);
		
		JPanel panel21 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel21.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelDatos.add(panel21);
		
		JLabel lblH = new JLabel("Costo de mantener en inventario (h)");
		panel21.add(lblH);
		
		textFieldH = new JTextField();
		panel21.add(textFieldH);
		textFieldH.setColumns(10);
		
		JPanel panel22 = new JPanel();
		panelDatos.add(panel22);
		panel22.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblD = new JLabel("Tasa de demanda (d)");
		panel22.add(lblD);
		
		textFieldD = new JTextField();
		panel22.add(textFieldD);
		textFieldD.setColumns(10);
		
		JPanel panel31 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel31.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panelDatos.add(panel31);
		
		JLabel lblL = new JLabel("Tiempo de espera pedido (L)");
		lblL.setHorizontalAlignment(SwingConstants.RIGHT);
		panel31.add(lblL);
		
		textFieldL = new JTextField();
		textFieldL.setHorizontalAlignment(SwingConstants.RIGHT);
		panel31.add(textFieldL);
		textFieldL.setColumns(10);
		
		setVisible(true);
		
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TInv inven = new TInv(Double.parseDouble(textFieldK.getText()),Double.parseDouble(textFieldC.getText()),Double.parseDouble(textFieldH.getText()),Double.parseDouble(textFieldD.getText()),Double.parseDouble(textFieldL.getText()));
				InterfazResultadosTInv inter = new InterfazResultadosTInv(inven);
				textFieldK.setText("");
				textFieldC.setText("");
				textFieldH.setText("");
				textFieldD.setText("");
				textFieldL.setText("");
				
			}
		});
	}

}
