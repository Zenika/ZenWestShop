package com.zenika.cakefactory.servlet;

import com.zenika.cakefactory.CakeFactory;
import com.zenika.cakefactory.produits.sousproduits.Gateau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gtinon
 */
@WebServlet(name = "simpleservlet", urlPatterns = "/")
public class CakeFactoryControlServlet extends HttpServlet {

	@Autowired
	private CakeFactory cakeFactory;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/cake-factory.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gateau gateau = cakeFactory.faireUnBonGateau();
		req.setAttribute("gateau", gateau);
		req.getRequestDispatcher("/WEB-INF/cake-factory.jsp").forward(req, resp);
	}

}
