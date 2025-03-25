<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Registro</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex vh-100">
  <div class="row justify-content-center align-self-center w-100">
    <div class="col-md-4">
      <h2 class="text-center">Registro</h2>
      <form action="register-servlet" method="post">
        <div class="mb-3">
          <label for="user" class="form-label">Usuario</label>
          <input type="text" class="form-control" id="user" name="user" placeholder="Usuario">
        </div>
        <div class="mb-3">
          <label for="pass" class="form-label">Contraseña</label>
          <input type="password" class="form-control" id="pass" name="pass" placeholder="Contraseña">
        </div>
        <div class="mb-3">
          <label for="role" class="form-label">Rol</label>
          <select class="form-control" id="role" name="role">
            <option value="user">Usuario</option>
            <option value="admin">Admin</option>
          </select>
        </div>
        <button type="submit" class="btn btn-primary w-100">Registrar</button>
      </form>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>