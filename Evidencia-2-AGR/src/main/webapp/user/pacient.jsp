<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tag" uri="http://example.com/tags" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <title>Tabla de Pacientes</title>
  <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
  <link rel="stylesheet" href="../assets/fonts/fontawesome-all.min.css">
  <link rel="stylesheet" href="../assets/css/Login-Form-Basic-icons.css">
</head>

<body id="page-top">
<div id="wrapper">
  <nav class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark">
    <div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
      <div class="sidebar-brand-text mx-3"><span>Evidencia 2</span></div>
    </a>
      <hr class="sidebar-divider my-0">
      <ul class="navbar-nav text-light" id="accordionSidebar">
        <%
          if (session != null && "admin".equals(session.getAttribute("role"))) {
        %>
        <li class="nav-item"><a class="nav-link" href="/Evidencia_2_AGR_war_exploded/admin/users.jsp"><i class="fas fa-table"></i><span>Usuarios</span></a></li>
        <%
          }
        %>
        <li class="nav-item"><a class="nav-link active" href="/Evidencia_2_AGR_war_exploded/user/pacient.jsp"><i class="fas fa-table"></i><span>Pacientes</span></a></li>
        <li class="nav-item"><a class="nav-link" href="/Evidencia_2_AGR_war_exploded/"><i class="far fa-user-circle"></i><span>Inicio</span></a></li>
      </ul>
      <div class="text-center d-none d-md-inline">
        <a href="../LogoutServlet" class="btn rounded-circle border-0" id="sidebarToggle" role="button"></a>
      </div>
    </div>
  </nav>
  <div class="d-flex flex-column" id="content-wrapper">
    <div id="content">
      <nav class="navbar navbar-expand bg-white shadow mb-4 topbar">
        <div class="container-fluid">
          <%
            HttpSession currentSession = request.getSession(false);
            if (currentSession != null && currentSession.getAttribute("username") != null) {
              String username = (String) currentSession.getAttribute("username");
              String color = (String) currentSession.getAttribute("color");
          %>
          <span style="color: <%= color %>;">Usuario Activo: <%= username %></span>
          <%
            }
          %>
        </div>
      </nav>
      <div class="container-fluid">
        <h3 class="text-dark mb-4">Pacientes</h3>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#registerUserModal">
          Registrar Paciente
        </button>
        <br/>
        <br>
        <div class="card shadow">
          <div class="card-header py-3">
            <p class="text-primary m-0 fw-bold">Lista de Pacientes</p>
          </div>
          <div class="card-body">
            <div class="row">
              <div class="col-md-6 text-nowrap">
              </div>
              <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                <tag:pacientable/>
              </div>
            </div>
          </div>
        </div>
      </div>
      <footer class="bg-white sticky-footer">
        <div class="container my-auto">
          <div class="text-center my-auto copyright"></div>
        </div>
      </footer>
    </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
  </div>

  <!-- Modal -->
  <div class="modal fade" id="registerUserModal" tabindex="-1" aria-labelledby="registerUserModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="registerUserModalLabel">Registrar Paciente</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form id="registerUserForm" method="post" action="../PacientServlet">
            <div class="mb-3">
              <label for="name" class="form-label">Nombre</label>
              <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="mb-3">
              <label for="age" class="form-label">Edad</label>
              <input type="number" class="form-control" id="age" name="age" required>
            </div>
            <div class="mb-3">
              <label for="role" class="form-label">Sexo</label>
              <select class="form-control" id="role" name="role" required>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
                <option value="Helicptero Apache">Helicoptero Apache</option>
              </select>
            </div>
            <div class="mb-3">
              <label for="stature" class="form-label">Estatura</label>
              <input type="number" class="form-control" id="stature" name="stature" step="0.01" required>
            </div>
            <div class="mb-3">
              <label for="weight" class="form-label">Peso</label>
              <input type="number" class="form-control" id="weight" name="weight" step="0.01" required>
            </div>
            <div class="mb-3">
              <label for="cadera" class="form-label">Cadera</label>
              <input type="number" class="form-control" id="cadera" name="cadera" step="0.01" required>
            </div>
            <button type="submit" class="btn btn-primary">Registrar</button>
          </form>
        </div>
      </div>
    </div>
  </div>

  <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
  <script src="../assets/js/theme.js"></script>
</body>

</html>