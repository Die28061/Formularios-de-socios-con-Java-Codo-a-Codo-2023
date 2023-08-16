package clases;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SociosController")
public class SociosController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public SociosController() 
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String accion=null;
		SociosDAO socioDAO=null;
		try 
		{
			socioDAO = new SociosDAO();
			
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		RequestDispatcher dispatcher=null;
		
		accion=request.getParameter("accion");
		
		if(accion==null||accion.isEmpty())
		{
			dispatcher=request.getRequestDispatcher("vistas/socios.jsp");
		}
		else if(accion.equals("modificar"))
		{
			dispatcher=request.getRequestDispatcher("vistas/modificar.jsp");

		}
		else if(accion.equals("actualizar"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String nombre=request.getParameter("nombre");
			String apellido=request.getParameter("apellido");
			int dni=Integer.parseInt(request.getParameter("dni"));
			String mail=request.getParameter("mail");
			Socios socio=new Socios(id,nombre,apellido,dni,mail,true,LocalDate.now());
			socioDAO.actualizarSocio(socio);	
			dispatcher=request.getRequestDispatcher("vistas/socios.jsp");
		}
		else if(accion.equals("eliminar"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			socioDAO.eliminarSocio(id);
			dispatcher=request.getRequestDispatcher("vistas/socios.jsp");
		}
		else if(accion.equals("nuevo"))
		{
			dispatcher=request.getRequestDispatcher("vistas/nuevo.jsp");

		}
		else if(accion.equals("insert"))
		{
			String nombre=request.getParameter("nombre");
			String apellido=request.getParameter("apellido");
			int dni=Integer.parseInt(request.getParameter("dni"));
			String mail=request.getParameter("mail");
			Socios socio=new Socios(0,nombre,apellido,dni,mail,true,LocalDate.now());
			socioDAO.insertarSocio(socio);
			dispatcher=request.getRequestDispatcher("vistas/socios.jsp");		
			
		}
		dispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		doGet(request, response);
	}

}
