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
               <input type="hidden" name="departmanId" id="mustekiId" value="${musteki.mustekiId}">
               <input type="hidden" name="dataUrl" id="dataUrl" value="${pageContext.request.contextPath}/mustekiKaydet">
               <input type="hidden" name="redirectUrl" id="redirectUrl" value="${pageContext.request.contextPath}/mustekiListele">
               <div class="form-gruop mb-1">
                 <label for="mustekiAd">Müşteki İsmini Giriniz</label>
                 <input class="form-control" type="text" name="mustekiAd" id="mustekiAd"  placeholder="Müşteki İsmini Giriniz"
                 value="${musteki.mustekiAd}"
                 >
               </div>
               <div class="form-gruop mb-1">
                 <label for="mustekiSoyad">Müşteki Soyismini Giriniz</label>
                 <input class="form-control" type="text" name="mustekiSoyad" id="mustekiSoyad"  placeholder="Müşteki Soyismini Giriniz"
                 value="${musteki.mustekiSoyad}"
                 >
               </div>
               <div class="form-gruop mb-1">
                 <label for="mustekiTelefon">Müşteki Telefon Giriniz</label>
                 <input class="form-control" type="number" name="mustekiTelefon" id="mustekiTelefon"  placeholder="Müşteki Telefon Giriniz"
                 value="${musteki.mustekiTelefon}"
                 >
               </div>
               <div class="form-gruop mb-1">
                 <label for="mustekiEposta">Müşteki Eposta Giriniz</label>
                 <input class="form-control" type="email" name="mustekiEposta" id="mustekiEposta"  placeholder="Müşteki Eposta Giriniz"
                        value="${musteki.mustekiEposta}"
                 >
               </div>

               <div class="form-gruop mt-1">
                 <button class="btn btn-outline-success" data-id="${musteki.mustekiId}" id="btnDepartmanGuncelle" type="button">GÜNCELLE</button>
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


