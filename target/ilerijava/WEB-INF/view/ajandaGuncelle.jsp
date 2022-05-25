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
               <input type="hidden" name="ajandaId" id="ajandaId" value="${ajanda.ajandaId}">
               <input type="hidden" name="ikId" id="dataUrl" value="${pageContext.request.contextPath}/ajandaKaydet">
               <input type="hidden" name="ikId" id="redirectUrl" value="${pageContext.request.contextPath}/ajandaListele">

               <div class="form-gruop mb-1">
                 <label for="ajandaIsim">Ajanda İsmi Giriniz</label>
                 <input class="form-control" type="text" name="ajandaIsim" id="ajandaIsim"  placeholder="Ajanda İsmi Giriniz"
                        value="${ajanda.ajandaIsim}"
                 >
               </div>
               <div class="form-gruop mb-1">
                 <label for="baslangicTarihi">Ajanda Başlangıç Tarihi</label>
                 <input class="form-control" type="date" name="baslangicTarihi" id="baslangicTarihi"  placeholder="Ajanda Başlangıç Tarihi"
                        value="${ajanda.baslangicTarihi}"
                 >
               </div>
               <div class="form-gruop mb-1">
                 <label for="bitisTarihi">Ajanda  Bitiş  Tarihi</label>
                 <input class="form-control" type="date" name="bitisTarihi" id="bitisTarihi"  placeholder="Davalı Telefon Giriniz"
                        value="${ajanda.bitisTarihi}"
                 >
               </div>

               <div class="form-gruop mt-1">
                 <button class="btn btn-outline-success"  id="btnAjandaGuncelle" type="button">GÜNCELLE</button>
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


