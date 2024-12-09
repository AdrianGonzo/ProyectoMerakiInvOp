import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class InterfazMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	
	public InterfazMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnCalcTColas = new JButton("Calculadora Teoria de Colas");
		panel.add(btnCalcTColas);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnCalcTInv = new JButton("Calculadora Teoria de Inventarios");
		panel_1.add(btnCalcTInv);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton btnSimulacionTColas = new JButton("Simulación de Teoria de Colas");
		panel_2.add(btnSimulacionTColas);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnFechasTColas = new JButton("Insertar Pedido");
		panel_4.add(btnFechasTColas);
		
		btnCalcTColas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfazCalcTColas a = new InterfazCalcTColas();
				
			}
		});
		
		btnCalcTInv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfazCalcTInv b = new InterfazCalcTInv();
				
			}
		});
		btnSimulacionTColas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfazDatosSimulacionTColas c = new InterfazDatosSimulacionTColas();
				
			}
		});
		
		btnFechasTColas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfazInsertarPedido d = new InterfazInsertarPedido();
				
			}
		});
		setVisible(true);
	}

}
