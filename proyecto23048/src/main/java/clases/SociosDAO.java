package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class SociosDAO 
{

	Connection conexion=null;
	
	public SociosDAO() throws ClassNotFoundException
	{
		Conexion con=new Conexion();
		conexion=con.getConnection();
	}
	
	
	public List<Socios> listarSocios()
	{
		PreparedStatement ps;
		ResultSet rs;
		List<Socios> lista=new ArrayList<Socios>();
		
		try
		{
			ps=conexion.prepareStatement("select * from socios");
			rs=ps.executeQuery();			
			while(rs.next())
			{
				int id=rs.getInt("id_socio");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellido");
				int dni=rs.getInt("dni");
				String mail=rs.getString("mail");
				boolean estado=rs.getBoolean("estado");
				LocalDate fecha_alta=rs.getDate("fecha_alta").toLocalDate();				
				Socios socio=new Socios(id,nombre,apellido,dni,mail,estado,fecha_alta);
				lista.add(socio);
			}
			return lista;
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return null;
		}		
	}
	
	public boolean insertarSocio(Socios socio) 
	{
		PreparedStatement ps;
		try
		{
			ps=conexion.prepareStatement("insert into socios(nombre,apellido,dni,mail,estado,fecha_alta) values (?,?,?,?,?,?)");
			ps.setString(1, socio.getNombre());
			ps.setString(2, socio.getApellido());
			ps.setInt(3, socio.getDni());
			ps.setString(4, socio.getMail());
			ps.setBoolean(5, true);
			ps.setObject(6,LocalDate.now());			
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}	
	}
	
	public boolean actualizarSocio(Socios socio)
	{
		PreparedStatement ps;
		try
		{
			ps=conexion.prepareStatement("update socios set nombre=?,apellido=?,dni=?,mail=? where id_socio=?");
			ps.setString(1, socio.getNombre());
			ps.setString(2, socio.getApellido());
			ps.setInt(3, socio.getDni());
			ps.setString(4, socio.getMail());
			ps.setInt(5, socio.getId_socio());						
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}	
		
	}
	
	
	public boolean eliminarSocio(int id)
	{
		PreparedStatement ps;
		try
		{
			ps=conexion.prepareStatement("delete from socios where id_socio=?");
			ps.setInt(1, id);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}	
	}
	
	public  Socios mostrarSocio(int id)
	{
		PreparedStatement ps;
		ResultSet rs;
		Socios socio=null;
		
		try
		{
			ps=conexion.prepareStatement("select * from socios where id_socio=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
			int _id=rs.getInt("id_socio");
			String nombre=rs.getString("nombre");
			String apellido=rs.getString("apellido");
			int dni=rs.getInt("dni");
			String mail=rs.getString("mail");
			boolean estado=rs.getBoolean("estado");
			LocalDate fecha_alta=rs.getDate("fecha_alta").toLocalDate();			
			socio=new Socios(_id,nombre,apellido,dni,mail,estado,fecha_alta);			
			}
			return socio;			
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	
	
	
	
	
	
	
}
