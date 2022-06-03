package jp.co.aforce.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.CustomerDAO;
import jp.co.aforce.beans.Customer;

@WebServlet(urlPatterns = {"/jp.co.aforce.controll/LoginAction"})
public class LoginAction extends HttpServlet {




	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");

		CustomerDAO dao = new CustomerDAO();
		try {

			Customer customer = dao.search(id, password);

			int i = customer.getId();


			if (customer != null) {
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("../jsp/login2.jsp").forward(request, response);
			} else {
				out.println("<p>IDもしくはパスワードが違います</p>");
				out.println("<p>" + id + "</p>");
//				request.setAttribute("", ((Customer) customer).getId());
			}

		} catch (Exception e) {
			out.println("<p>IDもしくはパスワードが違います</p>");
			out.println("<p>" + id + "</p>");
			e.printStackTrace();

		}


	}


	}



