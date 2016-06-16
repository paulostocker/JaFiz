package br.com.jafiz.seguranca;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SegurancaFilter
 */
@WebFilter("/SegurancaFilter")
public class SegurancaFilter implements Filter {

    private ServletContext context;
    /**
     * Default constructor. 
     */
    public SegurancaFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
         
        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);

        
        HttpSession session = req.getSession(false);
        
        boolean possiveis = (uri.endsWith("html") || uri.endsWith("Login") 
        					|| uri.endsWith("js") 
        					|| uri.endsWith("css") || uri.endsWith("woff")
        					|| uri.endsWith("ttf") || uri.endsWith("svg")
        					|| uri.endsWith("eot") || uri.endsWith("map") 
        					|| uri.endsWith("woff2"));
        if(possiveis)
        {
            chain.doFilter(request, response);
        }
        else if(session == null)
        {
            System.out.println("URL: "+uri);
    		this.context.log("Unauthorized access request");
    		res.sendRedirect("index.html");
        }
        else
        {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
	}

}
