
<html>
<body>
	<%@ include file="header.jsp"%>
	<main>
		<div class="container">
			<h2>LISTE DES UTILISATEURS</h2>
			<table class="table table-success table-hover">
				<thead>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">City</th>

					<th></th>
					<th></th>
				</thead>

				<tbody>
					<c:forEach items="${users }" var="user">
						<tr>
							<td><c:out value="${ user.id }" /></td>
							<td><c:out value="${ user.name }" /></td>
							<td><c:out value="${ user.email }" /></td>
							<td><c:out value="${ user.city }" /></td>
							<td><a href="">Edite</a></td>
							<td><a href="">Suprimer</a></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	
		
		
	</main>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>