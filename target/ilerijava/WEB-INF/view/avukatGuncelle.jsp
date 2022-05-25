<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <div class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1 class="m-0">${title}</h1>
        </div><!-- /.col -->
        <div class="col-sm-6">

        </div><!-- /.col -->
      </div><!-- /.row -->
    </div><!-- /.container-fluid -->
  </div>
  <!-- /.content-header -->

  <!-- Main content -->
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-8">
          <div class="card">
           <div class="card-body">
             <form action="javascript:void(0)">
               <input type="hidden" name="ikId" id="ikId" value="${avukat.avukatId}">
               <input type="hidden" name="ikId" id="dataUrl" value="${pageContext.request.contextPath}/avukatUpdate">
               <input type="hidden" name="ikId" id="redirectUrl" value="${pageContext.request.contextPath}/avukatListele">
               <div class="form-gruop mb-1">
                 <label for="isim">Avukat İsmini Giriniz</label>
                 <input class="form-control" type="text" name="isim" id="isim" placeholder="Avukat İsmini Giriniz"
                        value="${avukat.avukatAd}"
                 >
               </div>
               <div class="form-gruop mt-1">
                 <label for="soyisim">Avukat Soyisim Giriniz</label>
                 <input class="form-control" type="text" name="soyisim" id="soyisim" placeholder="Avukat Soyisim Giriniz"
                        value="${avukat.avukatSoyad}"
                 >
               </div>
               <div class="form-gruop mt-1">
                 <label for="email">Avukat Email Giriniz</label>
                 <input class="form-control" type="email" name="email" id="email" placeholder="Avukat Email Giriniz"
                        value="${avukat.avukatEposta}"
                 >
               </div>
               <div class="form-gruop mt-1">
                 <label for="password">Avukat Şifre Giriniz</label>
                 <input class="form-control" type="password" name="password" id="password" placeholder="Avukat Şifre Giriniz"
                        value="${avukat.avukatSifre}"
                 >
               </div>
               <div class="form-gruop mt-1">
                 <button class="btn btn-outline-success" type="button" id="btnIkGuncelle">GÜNCELLE</button>
               </div>
             </form>
           </div>
          </div>
        </div>
      </div>
      <!-- /.row -->
    </div><!-- /.container-fluid -->
  </div>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->


<%@include file="includes/footer.jsp"%>


