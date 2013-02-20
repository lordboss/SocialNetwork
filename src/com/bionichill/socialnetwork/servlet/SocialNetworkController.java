package com.bionichill.socialnetwork.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bionichill.socialnetwork.actionimpl.UserActionImpl;
import com.bionichill.socialnetwork.dto.User;

/**
 * Servlet implementation class SocialNetworkServlet
 */
@WebServlet("/SocialNetworkServlet")
public class SocialNetworkController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public SocialNetworkController() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	UserActionImpl uai = new UserActionImpl();
	uai.getUserList();
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("<title>List of users</title>");
	out.println("</head>");
	out.println("<body>");
	// out.println("<h1>hello</h1>");
	for (User user : uai.getUserList()) {
	    out.println(user.toString());
	}
	out.println("</body>");
    }

}
