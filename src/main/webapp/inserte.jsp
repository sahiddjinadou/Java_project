
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<h1>Page d'insertion user</h1>
	
	<form method="post" action="register">
  <div class="mb-3 ms-3">
    <label for="exampleInputEmail1" class="form-label">User Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="username"  aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3 ms-3">
    <label for="exampleInputPassword1" class="form-label">Email</label>
    <input type="email" class="form-control" name="email" id="exampleInputPassword1">
  </div>
  <div class="mb-3 ms-3 form-check">
    <input type="radio" class="form-check-input" name="city" value="Cotonou" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Cotonou</label><br>
    <input type="radio" class="form-check-input"  name="city" value="Parakou" id="exampleCheck2">
    <label class="form-check-label" for="exampleCheck1">Parakou</label><br>
    <input type="radio" class="form-check-input"  name="city" value="Ouidah" id="exampleCheck3">
    <label class="form-check-label" for="exampleCheck1">Ouidah</label>
  </div>
  <button type="submit" class="ms-3 btn btn-primary">Submit</button>
</form>
</body>
</html>