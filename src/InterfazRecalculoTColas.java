import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InterfazRecalculoTColas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public InterfazRecalculoTColas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		ArrayList<Date> fechaspedido = new ArrayList<Date>();
		ArrayList<Date> fechasinicio = new ArrayList<Date>();
		ArrayList<Date> fechasfin = new ArrayList<Date>();
		
		String query1 = "select fechapedido from pedidos";
		String query2 = "select fechainicio from servicios";
		String query3 = "select fechafin from servicios";
		
		try (Connection c = Conexion.conectar();
                Statement st = c.createStatement())
		{
			 ResultSet rs = st.executeQuery(query1);
			 while (rs.next())
			 {
				 java.sql.Date fechaSql1 = rs.getDate("fechapedido");
				 fechaspedido.add(fechaSql1);
			 }
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (Connection c = Conexion.conectar();
                Statement st = c.createStatement())
		{
			 ResultSet rs = st.executeQuery(query2);
			 while (rs.next())
			 {
				 java.sql.Date fechaSql2 = rs.getDate("fechainicio");
				 fechasinicio.add(fechaSql2);
			 }
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (Connection c = Conexion.conectar();
                Statement st = c.createStatement())
		{
			 ResultSet rs = st.executeQuery(query3);
			 while (rs.next())
			 {
				 java.sql.Date fechaSql3 = rs.getDate("fechafin");
				 fechasfin.add(fechaSql3);
			 }
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Long> llegadas = new ArrayList<Long>();;
		ArrayList<Long> servicios = new ArrayList<Long>();
		int c=0;
		Date primFecha = fechasinicio.get(0);
		for (Date d:fechaspedido)
		{	
			long servicio = ((fechasfin.get(c).getTime())-fechasinicio.get(c).getTime());
			if (c!=0)
			{
				long llegada = (d.getTime())-(primFecha.getTime());
				llegadas.add(llegada/(1000*24*60*60));
			}
			servicios.add(servicio/(1000*24*60*60));
			c++;
			primFecha = d;
		}
		System.out.println(llegadas);
		long sumL=0;
		int contL=0;
		for (Long l:llegadas)
		{
			sumL=sumL+l;
			contL++;
			System.out.println(sumL);
		}
		double lambda=((double) sumL)/contL;
		
		long sumS=0;
		int contS=0;
		for (Long l:servicios)
		{
			sumS=sumS+l;
			contS++;
		}
		double miu= ((double) sumS)/contS;
		
		System.out.println(lambda +""+miu);
		
		TColas res = new TColas(lambda, miu, 1);
		
		JLabel lblNewRes = new JLabel("RESULTADOS:");
		lblNewRes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewRes);
		
		JLabel lblNewLabel_1 = new JLabel("Factor de Utilizacion (rho) ="+Math.round(res.factorUtilizacion()*1000.00)/1000.00);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Probabilidad de que no haya clientes en la cola (P0) = "+Math.round(res.probabilidadCero()*1000.00)/1000.00);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad de clientes en el sistema (Ls) = "+Math.round(res.cantCliSis()*1000.00)/1000.00);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad de clientes en la cola (Lq) = "+Math.round(res.cantCliCola()*1000.00)/1000.00);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TIempo de espera en el sistema (Ws) = "+Math.round(res.tiempoEsperaSis()*1000.00)/1000.00);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tiempo de espera en la cola (Wq) = "+Math.round(res.tiempoEsperaCola()*1000.00)/1000.00);
		contentPane.add(lblNewLabel_7);
		
		
		setVisible(true);
	}

}
