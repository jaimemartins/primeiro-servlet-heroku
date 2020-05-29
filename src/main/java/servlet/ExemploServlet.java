package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/exemploServlet" )
public class ExemploServlet extends HttpServlet {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4909965054032768806L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");		
		PrintWriter out = resp.getWriter();		
		out.print("<html><head><title>Meu Servlet</title></head><body>");
		out.print("O email digitado foi: "+email);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10343341","sql10343341","G6TfZrisC1");
			
			PreparedStatement pst = conexao.prepareStatement("insert into usuario (email) values (?) ");
			pst.setString(1, email);
			pst.execute();				
			pst.close();
			conexao.close();			
		} catch (Exception e) {
			out.print("falha no Banco de Dados");
			
		}		
		out.print("<br>Olá Servlet</body></html>");	
	}
}
