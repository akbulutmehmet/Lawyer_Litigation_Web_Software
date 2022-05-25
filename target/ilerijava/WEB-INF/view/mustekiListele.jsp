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
                       <div class="row">
                           <div class="col-6">

                           </div>
                           <div class="col-6">
                               <a href="${pageContext.request.contextPath}/mustekiEkle" class="btn btn-outline-info m-auto ">
                                   <i class="fa fa-plus"></i>
                                   YENİ MÜŞTEKİ EKLE</a>
                           </div>
                       </div>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                   <div class="col-md-12">
                    <div class="card">
                      <div class="card-body">
                          <table class="table table-hover table-bordered" id="dataTables">
                              <thead>
                              <tr>
                                  <th>İD</th>
                                  <th>Müşteki Ad</th>
                                  <th>Müşteki Soyad</th>
                                  <th>Müşteki Eposta</th>
                                  <th>Müşteki Telefon</th>
                                  <th>İşlemler</th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="musteki" items="${mustekiList}" >
                                 <tr>
                                     <td>
                                         <c:out value=" ${musteki.mustekiId}"></c:out>
                                     </td>
                                     <td>
                                         <c:out value=" ${musteki.mustekiAd}"></c:out>
                                     </td>
                                     <td>
                                         <c:out value=" ${musteki.mustekiSoyad}"></c:out>
                                     </td>
                                     <td>
                                         <c:out value=" ${musteki.mustekiTelefon}"></c:out>
                                     </td>
                                     <td>
                                         <c:out value=" ${musteki.mustekiEposta}"></c:out>
                                     </td>
                                     <td>
                                         <a href="${pageContext.request.contextPath}/mustekiGuncelle/${musteki.mustekiId}" class="btn  btn-info" data-id="#1">GÜNCELLE</a>
                                         <button class="btn  btn-blok btn-danger btnDepartmanSil" type="button"   data-id="${musteki.mustekiId}">SİL</button>
                                     </td>
                                 </tr>


                              </c:forEach>

                              </tbody>
                          </table>
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


