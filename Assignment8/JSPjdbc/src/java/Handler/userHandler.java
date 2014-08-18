
package Handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.userd;
import bean.userBean;

public class userHandler extends HttpServlet {
	private static String INSERT = "/user.jsp";
	private static String Edit = "/edit.jsp";
	private static String UserRecord = "/listUser.jsp";
        private static String singleUser="/singleUser.jsp";
        private static String show="/showsingleUser.jsp";
	private userd dao;

	public userHandler() {
		super();
		dao = new userd();
		System.out.println("HI");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String redirect = "";
		String uId = request.getParameter("userid");
		String action = request.getParameter("action");
		System.out.println("Hello");
		if (!((uId) == null) && action.equalsIgnoreCase("insert")) {
			int id = Integer.parseInt(uId);
			userBean user = new userBean();
			user.setId(id);
			user.setfName(request.getParameter("firstName"));
			user.setlName(request.getParameter("lastName"));
			dao.addUser(user);
			redirect = UserRecord;
			
			System.out.println("Record Added Successfully");
		} else if (action.equalsIgnoreCase("delete")) {
			String userId = request.getParameter("userId");
			int uid = Integer.parseInt(userId);
			dao.removeUser(uid);
			redirect = UserRecord;
			
			System.out.println("Record Deleted Successfully");
		} else if (action.equalsIgnoreCase("editform")) {
			redirect = Edit;
		} else if (action.equalsIgnoreCase("edit")) {
			String userId = request.getParameter("userId");
			int uid = Integer.parseInt(userId);
			userBean user = new userBean();
			user.setId(uid);
			user.setfName(request.getParameter("firstName"));
			user.setlName(request.getParameter("lastName"));
			dao.editUser(user);
			
			redirect = UserRecord;
			System.out.println("Record updated Successfully");
		} else if (action.equalsIgnoreCase("listUser")) {
			redirect = UserRecord;
			
		}else if (action.equalsIgnoreCase("userId")) {
			redirect = singleUser;
			
		} 
                else if (action.equalsIgnoreCase("show")) {
			redirect = show+"?action="+uId;
			
		} 
                else {
			redirect = INSERT;
		}

		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
