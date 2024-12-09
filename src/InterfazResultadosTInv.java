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
		contentPane.setLayout(new GridLayout(6, 0, 0, 0));
		
		JLabel lblRes = new JLabel("RESULTADOS");
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRes);
		
		
		JLabel lblNewLabel = new JLabel("Cantidad Optima de pedido (Q*) = "+res.cantOptimaPedido());
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tiempo de un ciclo de producción (t*) = "+res.tiempoCicloProduccion());
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número de ciclos por unidad de tiempo (N) = "+res.numCiclosTiempo());
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Costo total por unidad de tiempo (CTt) = "+res.costoTotalTiempo());
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Costo total por ciclo (CLcl) = "+res.costoTotalCiclo());
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Punto de Reorden (R) = "+res.puntoReorden());
		contentPane.add(lblNewLabel_5);
		
		setVisible(true);
	}
	

}
