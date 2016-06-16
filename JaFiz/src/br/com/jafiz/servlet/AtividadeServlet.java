package br.com.jafiz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jafiz.controllers.AtividadeController;
import br.com.jafiz.models.Atividade;

/**
 * Servlet implementation class AtividadeServlet
 */
@WebServlet("/Atividade")
public class AtividadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtividadeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final int INSERIR 	= 1;
        final int EDITAR 	= 2;
        final int EXCLUIR 	= 3;
        final int LISTALL 	= 5;
        Atividade M_atv 	= new Atividade();
        AtividadeController C_atv = new AtividadeController();


        /**
        
         * @see HttpServlet#HttpServlet()
         */
		//System.out.println("REQUEST: "+request.getParameter("ind"));
        switch (Integer.parseInt(request.getParameter("ind"))) {

            case INSERIR:
            	if(request.getParameter("cdn_usuario")==null || request.getParameter("cdn_usuario").isEmpty()){
                	RequestDispatcher out = request.getRequestDispatcher("views/cadastraAtividade.jsp");
                	out.forward(request, response);
            	}else{
            		
            		// editType!=null && !editType.isEmpty()
            		String estipulado 	= request.getParameter("qtd_tempo_estipulado");
            		String realizado 	= request.getParameter("qtd_tempo_realizado");
            		String status 		= request.getParameter("ind_status");
            		Double utilizado 	= 0.00;

            		if(estipulado==null || estipulado.isEmpty()) {
            			estipulado = "0";
            		} else {
            			estipulado = estipulado.replace(":","");
            		}
            		if(realizado==null || realizado.isEmpty()) {
            			realizado = "0";
            		} else {
            			realizado = realizado.replace(":","");
            		}
            		if(status==null || status.isEmpty()) {
            			status = "0";
            		}
            		
            		//if(realizado!=null && estipulado!=null)
            		//	utilizado = "0.00";
            		
            		/* Realizar calculo percentual */
           
	                Integer cdn_usuario 			= Integer.parseInt(request.getParameter("cdn_usuario"));
	                String nom_atividade 			= request.getParameter("nom_atividade");
	                String des_atividade 			= request.getParameter("des_atividade");
	                Integer qtd_tempo_estipulado 	= Integer.parseInt(estipulado);
	                Integer qtd_tempo_realizado 	= Integer.parseInt(realizado);
	                Integer ind_status 				= Integer.parseInt(status);
	                Double perc_tempo_utilizado 	= utilizado;
	                
	                M_atv.setCdn_usuario(cdn_usuario);
	                M_atv.setNom_atividade(nom_atividade);
	                M_atv.setDes_atividade(des_atividade);
	                M_atv.setQtd_tempo_estipulado(qtd_tempo_estipulado);
	                M_atv.setQtd_tempo_realizado(qtd_tempo_realizado);
	                M_atv.setPerc_tempo_utilizado(perc_tempo_utilizado);
	                M_atv.setInd_status(ind_status);
	                
	                if(C_atv.Create(M_atv)){
	                	RequestDispatcher out = request.getRequestDispatcher("views/cadastraAtividade.jsp");
	                	out.forward(request, response);
	                }else{
	                	RequestDispatcher out = request.getRequestDispatcher("views/cadastraAtividade.jsp");
	                	out.forward(request, response);
	                }
            	}
                break;
            case EXCLUIR:
                Integer cdn_atividade	= Integer.parseInt(request.getParameter("cdn_atividade"));
            	M_atv.setCdn_atividade(cdn_atividade);
            	if (C_atv.Delete(M_atv)){
                	RequestDispatcher out = request.getRequestDispatcher("views/ListaAtividades.jsp");
                	out.forward(request, response);
            	}
            	break;
            case EDITAR:

                break;
      
            case LISTALL:
            	
                HttpSession ver_session = request.getSession(false);
        		Integer userid = (Integer) ver_session.getAttribute("id");
        		
            	Atividade atv = new Atividade();
            	atv.setCdn_usuario(userid);
            	AtividadeController atvC = new AtividadeController();
            	List<Atividade> listall = atvC.byUser(atv);
            	request.setAttribute("listall", listall);
            	if (!response.isCommitted()){
                	RequestDispatcher out = request.getRequestDispatcher("views/ListaAtividades.jsp");
                	out.forward(request, response);
            	}
                break;
                
            default:
                //request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
    
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
