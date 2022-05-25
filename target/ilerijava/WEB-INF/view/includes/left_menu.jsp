<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="mt-2">
  <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
    <li class="nav-item">
      <a href="${pageContext.request.contextPath}/davaListele" class="nav-link">
        <i class="nav-icon fas fa-people-arrows"></i>
        <p>
          Dava İşlemleri
        </p>
      </a>

    </li>
    <li class="nav-item">
      <a href="${pageContext.request.contextPath}/mustekiListele" class="nav-link"

      >
        <i class="nav-icon fas fa-people-carry"></i>
        <p>
          Müşteki İşlemleri
        </p>
      </a>

    </li>
    <li class="nav-item">
      <a href="${pageContext.request.contextPath}/davaliListele" class="nav-link ">
        <i class="nav-icon fas fa-tachometer-alt"></i>
        <p>
          Davalı İşlemleri
        </p>
      </a>

    </li>
    <li class="nav-item">
      <a href="${pageContext.request.contextPath}/ajandaListele" class="nav-link ">
        <i class="nav-icon fas fa-user-md"></i>
        <p>
          Ajanda İşlemleri
        </p>
      </a>

    </li>
    <li class="nav-item">
      <a href="${pageContext.request.contextPath}/avukatListele" class="nav-link ">
        <i class="nav-icon fas fa-user-alt"></i>
        <p>
          Avukat İşlemleri
        </p>
      </a>

    </li>
  </ul>
</nav>
