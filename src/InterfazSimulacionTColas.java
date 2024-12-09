import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class InterfazSimulacionTColas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public InterfazSimulacionTColas(double lambda, double miu, int n) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblNro = new JLabel("Nro Clientes");
		lblNro.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNro);
		
		JLabel lblTLlegadas = new JLabel("Tiempo entre llegadas");
		lblTLlegadas.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTLlegadas);
		
		JLabel lblMoLlegadas = new JLabel("Momento de llegada");
		lblMoLlegadas.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMoLlegadas);
		
		JLabel lblTInicio = new JLabel("Tiempo Inicio Servicio");
		lblTInicio.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTInicio);
		
		JLabel lblTEspera = new JLabel("Tiempo de espera");
		lblTEspera.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTEspera);
		
		JLabel lblTServicio = new JLabel("Tiempo de Inicio de Servicio");
		lblTServicio.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTServicio);
		
		JLabel lblTTerminacion = new JLabel("Tiempo Fin Servicio");
		lblTTerminacion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTTerminacion);
		
		double amoLlegadas = 0.0;
		double aTFinS = 0.0;
		for (int i=1;i<=n;i++)
		{
			JLabel label1 = new JLabel(""+i);
			contentPane.add(label1);
			Random rand = new Random();
			double aleatorio1 = rand.nextDouble();
			double tLlegadas = (-Math.log(1-aleatorio1)/lambda);
			double moLlegadas = amoLlegadas + tLlegadas;
			double tInicioS = Math.max(moLlegadas, aTFinS);
			double tEspera = tInicioS-moLlegadas;
			double aleatorio2 = rand.nextDouble();
			double tServicio = (-Math.log(1-aleatorio2)/miu);
			double tFinS = tInicioS + tServicio;
			JLabel label2 = new JLabel(""+tLlegadas);
			contentPane.add(label2);
			JLabel label3 = new JLabel(""+moLlegadas);
			contentPane.add(label3);
			JLabel label4 = new JLabel(""+tInicioS);
			contentPane.add(label4);
			JLabel label5 = new JLabel(""+tEspera);
			contentPane.add(label5);
			JLabel label6 = new JLabel(""+tServicio);
			contentPane.add(label6);
			JLabel label7 = new JLabel(""+tFinS);
			contentPane.add(label7);

			amoLlegadas = moLlegadas;
			aTFinS = tFinS;
			
			setVisible(true);
		}
		
	}

}
