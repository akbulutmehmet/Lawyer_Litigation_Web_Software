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
               <div class="form-gruop mb-1">
                 <label for="ajandaIsim">Ajanda İsmi Giriniz</label>
                 <input class="form-control" type="text" name="ajandaIsim" id="ajandaIsim"  placeholder="Ajanda İsmi Giriniz"
                 >
               </div>
               <div class="form-gruop mb-1">
                 <label for="baslangicTarihi">Ajanda Başlangıç Tarihi</label>
                 <input class="form-control" type="date" name="baslangicTarihi" id="baslangicTarihi"  placeholder="Ajanda Başlangıç Tarihi">
               </div>
               <div class="form-gruop mb-1">
                 <label for="bitisTarihi">Ajanda  Bitiş  Tarihi</label>
                 <input class="form-control" type="date" name="bitisTarihi" id="bitisTarihi"  placeholder="Davalı Telefon Giriniz">
               </div>

               <div class="form-gruop mt-1">
                 <button class="btn btn-outline-success"  id="btnAjandaEkle" type="button">EKLE</button>
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


