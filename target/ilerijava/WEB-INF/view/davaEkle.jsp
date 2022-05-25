<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                 <label for="davaAd">Dava İsmini Giriniz</label>
                 <input class="form-control" type="text" name="davaAd" id="davaAd"  placeholder="Dava İsmini Giriniz"
                 >
               </div>
               <div class="form-gruop mb-1">
                 <label for="davaTipi">Dava Tipini Giriniz</label>
                 <input class="form-control" type="text" name="davaTipi" id="davaTipi"  placeholder="Dava Tipini Giriniz">
               </div>
               <div class="form-gruop mb-1">
                 <label for="davaNumarasi">Dava Numarası Giriniz</label>
                 <input class="form-control" type="number" name="davaNumarasi" id="davaNumarasi"  placeholder="Dava Numarası Giriniz">
               </div>
               <div class="form-gruop mb-1">
                 <label for="davaliId">Davalı şeçiniz</label>
                 <select name="davaliId" id="davaliId" class="form-control">
                   <c:forEach var="davali" items="${davaliList}" >
                     <option value="${davali.davaliId}" selected>${davali.davaliAdSoyad}</option>
                   </c:forEach>

                 </select>
               </div>
               <div class="form-gruop mb-1">
                 <label for="mustekiId">Müşteki şeçiniz</label>
                 <select name="mustekiId" id="mustekiId" class="form-control">
                   <c:forEach var="musteki" items="${mustekiList}" >
                     <option value="${musteki.mustekiId}" selected>${musteki.mustekiAdSoyad}</option>
                   </c:forEach>

                 </select>
               </div>
               <div class="form-gruop mt-1">
                 <button class="btn btn-outline-success"  id="btnDavaKaydet" type="button">EKLE</button>
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


