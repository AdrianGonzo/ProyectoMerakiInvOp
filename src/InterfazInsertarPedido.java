import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.FlowLayout;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserCellEditor;

import java.sql.*;
import java.time.*;
import java.util.Date;
import javax.swing.BoxLayout;

public class InterfazInsertarPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public InterfazInsertarPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("Insertar Pedido");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panelDatos = new JPanel();
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panelDatos.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblFecha1 = new JLabel("Fecha Solicitud de Pedido");
		panel.add(lblFecha1);
		
		JDateChooser dateChooser1 = new JDateChooser();
		panel.add(dateChooser1);
		
		JPanel panel_1 = new JPanel();
		panelDatos.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblFecha2 = new JLabel("Fecha Inicio Servicio");
		panel_1.add(lblFecha2);
		
		JDateChooser dateChooser2 = new JDateChooser();
		panel_1.add(dateChooser2);
		
		JPanel panel_2 = new JPanel();
		panelDatos.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel lblFecha3 = new JLabel("Fecha entrega de pedido");
		panel_2.add(lblFecha3);
		
		JDateChooser dateChooser3 = new JDateChooser();
		panel_2.add(dateChooser3);
		
		JPanel panelBoton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBoton.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelBoton, BorderLayout.SOUTH);
		
		JButton btnAgregar = new JButton("Agregar");
		panelBoton.add(btnAgregar);
		
		setVisible(true);
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Date fecha1 = dateChooser1.getDate();
				Date fecha2 = dateChooser2.getDate();
				Date fecha3 = dateChooser3.getDate();
				java.sql.Date sqlDate1 = new java.sql.Date(fecha1.getTime());
				java.sql.Date sqlDate2 = new java.sql.Date(fecha2.getTime());
				java.sql.Date sqlDate3 = new java.sql.Date(fecha3.getTime());
				
				
				String sql1 = "insert into pedidos (fechapedido) values (?)";
				
				
				try (Connection c = Conexion.conectar();
						PreparedStatement st = c.prepareStatement(sql1))
				{
					st.setDate(1, sqlDate1);
					int fIns = st.executeUpdate();
					c.close();
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String sql2 = "insert into servicios (fechainicio, fechafin) values (?, ?)";
				
				
				try (Connection c = Conexion.conectar();
						PreparedStatement st = c.prepareStatement(sql2))
				{
					
					st.setDate(1, sqlDate2);
					st.setDate(2, sqlDate3);
					int fIns = st.executeUpdate();
					c.close();
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				InterfazRecalculoTColas rec = new InterfazRecalculoTColas();
			}
			
		});
	}

}
