<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AggiungiGalleria</title>
</head>
<h2>Aggiungi Galleria</h2>
<body>
	<form action="museo" method="post">
		<div>
			NAME: <input type="text" name="nome" value='${nome}' />
			${errNonInserito}
			${errSpecialChar}
			${errNomeGalleriaPreso}
		</div>
		<input type=submit name="sumbit" value="invia" /> 
	</form>
		
</body>
</html>