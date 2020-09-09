<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Registration</title>
</head>
<body>
<form action="Insert" method="post">
	<table>
		<tr><td>User Name</td><td><input type="text" name="uname"></td></tr>
		<tr><td></td><td><input type="submit" name="Register"></td></tr>
	</table>
</form>
</br>
</br>
<form action="select" method="post">
	<table>
		<tr><td></td><td><input type="submit" value="Show All" name="Register"></td></tr>
	</table>
</form>
</br>
</br>
<form action="Update" method="post">
	<table>
		<tr><td>Old Name</td><td><input type="text" name="old"></td><td></td><td>New Name</td><td><input type="text" name="new"></td></tr>
		<tr><td></td><td><input type="submit" value="Update"></td></tr>
	</table>
</form>

</br>
</br>
<form action="Delete" method="post">
	<table>
		<tr><td>User Name</td><td><input type="text" name="uname"></td><td></td><td><input type="submit" value="Delete"></td></tr>
	</table>
</form>
</body>
</html>