package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import modelo.Usuario;

@WebServlet(urlPatterns = "/exemploServlet" )
public class ExemploServlet extends HttpServlet {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4909965054032768806L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = new Usuario();
		String email = req.getParameter("email");
		usuario.setEmail(email);
		PrintWriter out = resp.getWriter();		
		out.print("<html><head><title>Meu Servlet</title></head><body>");
		out.print("O email digitado foi: "+email);
		out.print("O email digitado foi: "+usuario.getEmail());	
		
		if(dao.incluir(usuario)) {
			out.print(" Usuário inserido com sucesso!");
		}
		
		out.print("<br>Olá Servlet</body></html>");	
	}
}
