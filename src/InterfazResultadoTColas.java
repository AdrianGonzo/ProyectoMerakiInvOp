

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;

public class InterfazResultadoTColas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InterfazResultadoTColas(TColas res, int n, int s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewRes = new JLabel("RESULTADOS:");
		lblNewRes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewRes);
		
		JLabel lblNewLabel_1 = new JLabel("Factor de Utilizacion (rho) ="+Math.round(res.factorUtilizacion()*1000.00)/1000.00);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Probabilidad de que no haya clientes en la cola (P0) = "+Math.round(res.probabilidadCero()*1000.00)/1000.00);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Probabilidad de n clientes en cola (Pn) = "+Math.round(res.probabilidadN(n)*1000.00)/1000.00);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad de clientes en el sistema (Ls) = "+Math.round(res.cantCliSis()*1000.00)/1000.00);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad de clientes en la cola (Lq) = "+Math.round(res.cantCliCola()*1000.00)/1000.00);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TIempo de espera en el sistema (Ws) = "+Math.round(res.tiempoEsperaSis()*1000.00)/1000.00);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tiempo de espera en la cola (Wq) = "+Math.round(res.tiempoEsperaCola()*1000.00)/1000.00);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Probabilidad de esperar t en el sistema = "+Math.round(res.probabilidadEsperaSis(s)*1000.00)/1000.00);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Probabilidad de esperat t en la cola = "+Math.round(res.probabilidadEsperaCola(s)*1000.00)/1000.00);
		contentPane.add(lblNewLabel_9);
		
		setVisible(true);
	}
}
