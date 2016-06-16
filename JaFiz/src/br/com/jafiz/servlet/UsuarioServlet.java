package br.com.jafiz.servlet;

import br.com.jafiz.models.Atividade;
import br.com.jafiz.models.Usuario;
import br.com.jafiz.controllers.AtividadeController;
import br.com.jafiz.controllers.UsuarioController;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/Usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String nome;
    private String email;
    private String senha;
    private String datnasc;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final int INSERIR = 1;
       // final int VISUALIZAR = 2;
        final int EDITAR = 2;
        final int LOGIN = 3;
        final int LISTALL = 5;
        final int LOGOUT = 9;

        /**
        String text = "some text";
        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        response.getWriter().write(text); 
       */
        
        nome 	= request.getParameter("nome");
        email 	= request.getParameter("email");
        senha 	= request.getParameter("senha");
		datnasc = request.getParameter("nasc");
        
        /**
         * @see HttpServlet#HttpServlet()
         */
		System.out.println("REQUEST: "+request.getParameter("ind"));
        switch (Integer.parseInt(request.getParameter("ind"))) {

            case INSERIR:
                
                Usuario M_usu = new Usuario();

                M_usu.setNome(nome);
                M_usu.setEmail(email);
                M_usu.setSenha(senha);
                M_usu.setDatnsc(datnasc);
                
                UsuarioController C_usu = new UsuarioController();
                C_usu.Create(M_usu);
    
                break;

            case EDITAR:

                break;
                
            case LOGIN:
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
                
            case LISTALL:
            	Usuario usu = new Usuario();
            	UsuarioController usuC = new UsuarioController();
            	List<Usuario> listall = usuC.allUsers(usu);
            	request.setAttribute("listall", listall);
            	if (!response.isCommitted()){
                	RequestDispatcher out = request.getRequestDispatcher("views/ListaUsuarios.jsp");
                	out.forward(request, response);
            	}
                break;
                
            case LOGOUT:
                HttpSession session = request.getSession(false);
                if(session != null){
                    System.out.println("LOGOUT User= "+session.getAttribute("email"));
                    session.invalidate();
                }
            	if (!response.isCommitted()){
                    response.sendRedirect("index.html");
            	}
                break;
                
                
            default:
                //request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}
	
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
