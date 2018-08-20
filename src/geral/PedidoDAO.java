package geral;

import java.sql.ResultSet;
import java.util.ArrayList;
import beans.Pedido;

public class PedidoDAO {

	public static void Incluir(Pedido pedido) throws Exception{
		String sql = "insert into Pedido (dmaPedido, horario, idCliente) "+
				"values('"+pedido.getDmaPedido()+"', '"+pedido.getHorario()+"',"
						+ " '"+pedido.getIdCliente() +"')";
		Conexao.execSql(sql);;
	}
	
	public static void Delete(Pedido pedido) throws Exception{
		String sql = "delete from Pedido where codigo ="+pedido.getCodigoPedido()+"";
		Conexao.execSql(sql);
	}
	
	public static ArrayList<Pedido> getData() throws Exception {
		String sql = "select * from Pedido order by nome";
		ResultSet rs = Conexao.getList(sql);
		
		if (rs == null)
			throw new Exception("Não existe registros");
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		
		while (rs.next()) {
			Pedido pedido = new Pedido();
			pedido.setCodigoPedido(rs.getInt("codigoPedido"));
			pedido.setDmaPedido(rs.getString("dmaPedido"));
			pedido.setHorario(rs.getString("horario"));
			pedido.setIdCliente(rs.getInt("idCliente"));
			
			pedidos.add(pedido);
		}
		return pedidos;
	}
}
