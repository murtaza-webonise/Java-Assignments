<%-- 
    Document   : singleUser
    Created on : 18 Aug, 2014, 4:22:18 PM
    Author     : webonise
--%>

<%@page import="bean.userBean"%>
<%@page import="user.userd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form method="POST" action='userHandler' name="frmAddUser">
		<input type="hidden" name="action" value="show" />
		<p>
			<b>Find User by Id</b>
		</p>
		<table>
			<tr>
				<td>User ID</td>
				<td><input type="text" name="userid" /></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
               
	</form>
    </body>
</html>
