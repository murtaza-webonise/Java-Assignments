<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="bean.userBean"%>
<%@ page import="user.userd"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	<%
		userBean user = new userBean();
	%>
	<%
		userd dao = new userd();
	%>
	<form method="POST" action='userHandler' name="frmEditUser">
		<input type="hidden" name="action" value="edit" />
		<%
			String uid = request.getParameter("userId");
			if (!((uid) == null)) {
				int id = Integer.parseInt(uid);
				user = dao.getUserById(id);
		%>
		<table>
			<tr>
				<td>User ID</td>
				<td><input type="text" name="userId" readonly="readonly"
					value="<%=user.getId()%>"></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
		<%
			} else
				out.println("ID Not Found");
		%>
	</form>
</body>
</html>