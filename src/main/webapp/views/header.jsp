<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Magic of Books</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/">Home</a>
        </li>
        <% String id=(String) session.getAttribute("email"); if (id==null) { %>
          <li class="nav-item"><a class="nav-link" href="login">Login</a></li>
          <li class="nav-item">
            <a class="nav-link" href="register">Register</a>
          </li>
          <%}else{ %>
            <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
            <%} %>

              <% String adminFlag=(String) session.getAttribute("admin"); if(adminFlag!=null &&
                adminFlag.equals("true")) { %>
                <li class="nav-item"><a class="nav-link" href="/admin/form">Add Book</a></li>
                <%} %>
      </ul>
    </div>
  </div>
</nav>