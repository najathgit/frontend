package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class HospitalAPI
 */
@WebServlet("/HospitalAPI")
public class HospitalAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User hospitalObj = new User();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = userObj.insertUser(
				request.getParameter("hosID"),
				request.getParameter("First Name"),
				request.getParameter("Lst Name"),
				request.getParameter("dateOfBirth"),
				request.getParameter("Address"),
				request.getParameter("TelephoneNo"),
				request.getParameter("UserNAme"),
				request.getParameter("Password"),
				request.getParameter("Password"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = userObj.updateUser(
				paras.get("hidhosNOSave").toString(), 
				paras.get("hosID").toString(),
				paras.get("First Name").toString(),
				paras.get("Lst Name").toString(),
				paras.get("dateOfBirth").toString(),
				paras.get("Address").toString(),
				paras.get("TelephoneNo").toString(),
				paras.get("UserNAme").toString(),
				paras.get("Password").toString(),
			);
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = userObj.deleteUser(paras.get("hosNO").toString());
		response.getWriter().write(output);
	}

}
