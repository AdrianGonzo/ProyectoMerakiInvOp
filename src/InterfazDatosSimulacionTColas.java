import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class InterfazDatosSimulacionTColas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLambda;
	private JTextField textFieldMiu;
	private JTextField textFieldNum;


	public InterfazDatosSimulacionTColas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIns = new JLabel("INGRESE LOS DATOS PARA SIMULAR");
		lblIns.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIns, BorderLayout.NORTH);
		
		JPanel panelDatos = new JPanel();
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel11 = new JPanel();
		panelDatos.add(panel11);
		
		JLabel lblLambda = new JLabel("Tasa de llegada");
		panel11.add(lblLambda);
		
		textFieldLambda = new JTextField();
		panel11.add(textFieldLambda);
		textFieldLambda.setColumns(10);
		
		JPanel panel12 = new JPanel();
		panelDatos.add(panel12);
		
		JLabel lblMiu = new JLabel("Tasa de servicio");
		panel12.add(lblMiu);
		
		textFieldMiu = new JTextField();
		panel12.add(textFieldMiu);
		textFieldMiu.setColumns(10);
		
		JPanel panel21 = new JPanel();
		panelDatos.add(panel21);
		
		JLabel lblNum = new JLabel("Numero de clientes");
		panel21.add(lblNum);
		
		textFieldNum = new JTextField();
		panel21.add(textFieldNum);
		textFieldNum.setColumns(10);
		
		JPanel panelBoton = new JPanel();
		contentPane.add(panelBoton, BorderLayout.SOUTH);
		panelBoton.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnSimular = new JButton("Simular");
		panelBoton.add(btnSimular);
		
		textFieldLambda.setText("0.6904");
		textFieldMiu.setText("1");
		
		setVisible(true);
		
		btnSimular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				InterfazSimulacionTColas inter = new InterfazSimulacionTColas(Double.parseDouble(textFieldLambda.getText()),Double.parseDouble(textFieldMiu.getText()),Integer.parseInt(textFieldNum.getText()));
			}
		});
	}

}
