package br.com.jafiz.seguranca;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jafiz.controllers.AtividadeController;
import br.com.jafiz.controllers.UsuarioController;
import br.com.jafiz.models.Atividade;
import br.com.jafiz.models.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String nome;
    private String email;
    private String senha;
    private String datnasc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        nome 	= request.getParameter("nome");
        email 	= request.getParameter("email");
        senha 	= request.getParameter("senha");
		datnasc = request.getParameter("nasc");
		
		System.out.println("REQUEST: "+request.getParameter("ind"));
        switch (Integer.parseInt(request.getParameter("ind"))) {
        	case 1:
                HttpSession ver_session = request.getSession(false);
            	if(ver_session == null){
            		UsuarioController L_usu = new UsuarioController();
            		L_usu.Login(request, response);
            	}else{
            		Integer userid = (Integer) ver_session.getAttribute("id");
                	Atividade atv = new Atividade();
                	AtividadeController atvC = new AtividadeController();
                	atv.setCdn_usuario(userid);
                	List<Atividade> listall = atvC.byUser(atv);
                	request.setAttribute("listall", listall);
                	if (!response.isCommitted()){
                    	RequestDispatcher out = request.getRequestDispatcher("views/site.jsp");
                    	out.forward(request, response);
                	}
            	}
        		break;
            case 2:
                
                Usuario M_usu = new Usuario();

                M_usu.setNome(nome);
                M_usu.setEmail(email);
                M_usu.setSenha(senha);
                M_usu.setDatnsc(datnasc);
                
                UsuarioController C_usu = new UsuarioController();
                C_usu.Create(M_usu);
    
                break;
        }
        
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
