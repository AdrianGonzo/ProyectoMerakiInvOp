import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InterfazResultadosTInv extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public InterfazResultadosTInv(TInv res) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(7, 0, 0, 0));
		
		JLabel lblRes = new JLabel("RESULTADOS");
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRes);
		
		
		JLabel lblNewLabel = new JLabel("Cantidad Optima de pedido (Q*) = "+Math.round(res.cantOptimaPedido()*1000.00)/1000.00 + " [unidades/lote]");
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tiempo de un ciclo de producción (t*) = "+Math.round(res.tiempoCicloProduccion()*1000.00)/1000.00+" [sem/ciclo]");
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número de ciclos por unidad de tiempo (N) = "+Math.round(res.numCiclosTiempo()*1000.00)/1000.00+" [ciclo/sem]");
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Costo total por unidad de tiempo (CTt) = "+Math.round(res.costoTotalTiempo()*1000.00)/1000.00+" [Bs./semana]");
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Costo total por ciclo (CLcl) = "+Math.round(res.costoTotalCiclo()*1000.00)/1000.00+" [Bs./ciclo]");
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Punto de Reorden (R) = "+Math.round(res.puntoReorden()*1000.00)/1000.00+" [unidades]");
		contentPane.add(lblNewLabel_5);
		
		setVisible(true);
	}
	

}
