<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="bean.userBean"%>
<%@ page import="user.userd"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All User</title>
</head>
<body>
	 <%
		//
                int id=Integer.parseInt(request.getParameter("action"));
               userd dao=new userd();
		userBean user = dao.getUserById(id);
		//Iterator<UserBean> itr = userList.iterator();
	%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<tr>
						<td><%=user.getId()%></td>
			<td><%=user.getfName()%></td>
			<td><%=user.getlName()%></td>
			<td><a
				href="userHandler?action=editform&userId=<%=user.getId()%>">Update</a></td>
			<td><a href="userHandler?action=delete&userId=<%=user.getId()%>">Delete</a></td>

		</tr>
		
	</table>
	<p>
		<a href="userHandler?action=insert">Add User</a>
	</p>
</body>
</html>