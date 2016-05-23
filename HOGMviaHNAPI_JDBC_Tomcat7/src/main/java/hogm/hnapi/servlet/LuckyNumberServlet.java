package hogm.hnapi.servlet;

import hogm.hnapi.dao.LuckyNumberDAO;
import hogm.hnapi.pojo.LuckyNumberPojo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LuckyNumberServlet", urlPatterns = {"/LuckyNumberServlet"})
public class LuckyNumberServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8841123471498140882L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LuckyNumberServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LuckyNumberServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse
		response) throws ServletException, IOException, Exception {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            LuckyNumberDAO luckyNumberDAO = new LuckyNumberDAO();
            //LuckyNumberEntity luckyNumberEntity = new LuckyNumberEntity();
            //luckyNumberEntity.setLuckynumber(new Random().nextInt(1000000));

            //luckyNumberDAO.persist_cs_without_cfg(luckyNumberEntity);
            //luckyNumberDAO.persist_os_without_cfg(luckyNumberEntity);
            
            LuckyNumberPojo luckyNumberPojo = new LuckyNumberPojo();
            luckyNumberPojo.setLuckynumber(new Random().nextInt(1000000));

            luckyNumberDAO.persist_cs_with_cfg(luckyNumberPojo);
            //luckyNumberDAO.persist_os_with_cfg(luckyNumberPojo);
            
            response.sendRedirect("/HOGMviaHNAPI_JDBC_Tomcat7/index.jsp");
        } finally {
            out.close();
        }
	}
}
