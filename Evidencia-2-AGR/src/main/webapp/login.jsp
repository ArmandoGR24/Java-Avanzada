<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <title>Login - Brand</title>
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
  <link rel="stylesheet" href="assets/css/Login-Form-Basic-icons.css">
</head>

<body class="bg-gradient-primary">
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-9 col-lg-12 col-xl-10" style="width: 522px;">
      <div class="card shadow-lg o-hidden border-0 my-5">
        <div class="card-body p-0">
          <div class="row">
            <div class="col-lg-12">
              <div class="p-5">
                <div class="text-center">
                  <h4 class="text-dark mb-4">Login</h4>
                </div>
                <form class="user" action="LoginServlet" method="post">
                  <div class="mb-3"><input id="user" class="form-control form-control-user" type="text" aria-describedby="user" placeholder="Usuario" name="user" /></div>
                  <div class="mb-3"><input class="form-control form-control-user" type="password" id="pass" placeholder="Contraseña" name="pass"></div>
                  <div class="mb-3">
                    <div class="custom-checkbox small"></div>
                  </div><button class="btn btn-primary d-block btn-user w-100" type="submit">Login</button>
                </form>
                <div class="text-center"></div>
                <div class="text-center"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/theme.js"></script>
</body>

</html>