<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Read</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Read Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

        <div class="form-group">
          <label>Bno</label> <input class="form-control" name='bno' value="${board.bno}" readonly>
        </div>

        <div class="form-group">
          <label>Title</label> <input class="form-control" name='title' value="${board.title}" readonly>
        </div>

        <div class="form-group">
          <label>Text area</label>
          <textarea class="form-control" rows="5" name='content' readonly>${board.content}</textarea>
        </div>

        <div class="form-group">
          <label>Writer</label> <input class="form-control" name='writer' value="${board.writer }" readonly>
        </div>


        <button id='modify-btn' class="btn btn-default">수정</button>
        <button id='list-btn' class="btn btn-info">목록</button>


      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<script>
$(document).ready(function() {

      //목록 버튼 이벤트
      document.getElementById('list-btn').addEventListener('click', e => {
          location.href='/board/list';
      });

      //수정 버튼 이벤트
      document.getElementById('modify-btn').addEventListener('click', e => {
          location.href='/board/modify?bno=${board.bno}';
      });

});
</script>


<%@include file="../includes/footer.jsp"%>
