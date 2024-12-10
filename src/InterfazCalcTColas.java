import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;


public class InterfazCalcTColas extends JFrame {
	JPanel panelPrincipal;
	
	private JTextField textFieldLambda;
	private JTextField textFieldMiu;
	private JTextField textFieldS;
	private JTextField textFieldN;
	private JTextField textFieldTiempo;
	public InterfazCalcTColas() {
		setSize(600,350);
		setTitle("Calculo variables Teoria de Colas");
		
		
		JLabel lblCalcVar = new JLabel("Calcular variables");
		lblCalcVar.setLabelFor(this);
		lblCalcVar.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCalcVar, BorderLayout.NORTH);
		
		JPanel panelDatos = new JPanel();
		getContentPane().add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(3, 2, 0, 0));
		
		JPanel panel11 = new JPanel();
		panelDatos.add(panel11);
		panel11.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblLambda = new JLabel("Tasa de llegada");
		lblLambda.setHorizontalAlignment(SwingConstants.RIGHT);
		panel11.add(lblLambda);
		
		textFieldLambda = new JTextField();
		panel11.add(textFieldLambda);
		textFieldLambda.setColumns(10);
		panel11.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblLambda, textFieldLambda}));
		
		JPanel panel12 = new JPanel();
		panelDatos.add(panel12);
		panel12.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblMiu = new JLabel("Tasa de Servicio");
		panel12.add(lblMiu);
		
		textFieldMiu = new JTextField();
		panel12.add(textFieldMiu);
		textFieldMiu.setColumns(10);
		
		JPanel panel21 = new JPanel();
		panelDatos.add(panel21);
		panel21.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblS = new JLabel("Cantidad de Servidores");
		panel21.add(lblS);
		
		textFieldS = new JTextField();
		panel21.add(textFieldS);
		textFieldS.setColumns(10);
		
		JPanel panel22 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel22.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelDatos.add(panel22);
		
		JLabel lblN = new JLabel("Cantidad de clientes en cola");
		panel22.add(lblN);
		
		textFieldN = new JTextField();
		panel22.add(textFieldN);
		textFieldN.setColumns(10);
		
		JPanel panel31 = new JPanel();
		panelDatos.add(panel31);
		panel31.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblTiempo = new JLabel("Tiempo de espera");
		panel31.add(lblTiempo);
		
		textFieldTiempo = new JTextField();
		panel31.add(textFieldTiempo);
		textFieldTiempo.setColumns(10);
		
		JPanel panelButtons = new JPanel();
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnCalcular = new JButton("Calcular");
		panelButtons.add(btnCalcular);
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
		
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TColas nuevo = new TColas (Double.parseDouble(textFieldLambda.getText()),Double.parseDouble(textFieldMiu.getText()),Integer.parseInt(textFieldS.getText()));
				int n = Integer.parseInt(textFieldN.getText());
				int s = Integer.parseInt(textFieldS.getText());
				InterfazResultadoTColas resultado = new InterfazResultadoTColas(nuevo, n, s);
				textFieldLambda.setText("");
				textFieldMiu.setText("");
				textFieldS.setText("");
				textFieldN.setText("");
				textFieldTiempo.setText("");
			}
		});
	}

}
