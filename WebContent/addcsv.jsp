<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>



	<form enctype="multipart/form-data"  action="./product" method="post">
		<table align="center">
			
			<tr>
				<td>CSV</td>
				<td><input type="file" name="chooser" ></td>
			</tr>
			
			<tr>
				<td>
				
				
				<input type="hidden" value="import" name="action">
				
				
				</td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>