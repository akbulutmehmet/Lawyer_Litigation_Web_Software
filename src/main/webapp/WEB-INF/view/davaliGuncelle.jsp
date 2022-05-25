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
               <input type="hidden" name="departmanId" id="davaliId" value="${davali.davaliId}">
               <input type="hidden" name="dataUrl" id="dataUrl" value="${pageContext.request.contextPath}/davaliKaydet">
               <input type="hidden" name="redirectUrl" id="redirectUrl" value="${pageContext.request.contextPath}/davaliListele">
               <div class="form-gruop mb-1">
                 <label for="davaliAd">Davalı İsmini Giriniz</label>
                 <input class="form-control" type="text" name="davaliAd" id="davaliAd"  placeholder="Davalı İsmini Giriniz"
                 value="${davali.davaliAd}"
                 >
               </div>
               <div class="form-gruop mb-1">
                 <label for="davaliSoyad">Davalı Soyismini Giriniz</label>
                 <input class="form-control" type="text" name="davaliSoyad" id="davaliSoyad"  placeholder="Davalı Soyismini Giriniz"
                 value="${davali.davaliSoyad}"
                 >
               </div>
               <div class="form-gruop mb-1">
                 <label for="davaliTelefon">Davalı Telefon Giriniz</label>
                 <input class="form-control" type="number" name="davaliTelefon" id="davaliTelefon"  placeholder="Davalı Telefon Giriniz"
                 value="${davali.davaliTelefon}"
                 >
               </div>
               <div class="form-gruop mb-1">
                 <label for="davaliEposta">Davalı Eposta Giriniz</label>
                 <input class="form-control" type="email" name="davaliEposta" id="davaliEposta"  placeholder="Davalı Eposta Giriniz"
                        value="${davali.davaliEposta}"
                 >
               </div>

               <div class="form-gruop mt-1">
                 <button class="btn btn-outline-success" data-id="${davali.davaliId}" id="btnDavaliGuncelle" type="button">GÜNCELLE</button>
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


