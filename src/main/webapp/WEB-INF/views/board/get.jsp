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

<script src="/js/custom/reply.js" ></script>

<script>
$(document).ready(function() {


      //댓글 목록 부르기
      const url = '/replies/1/1';
      const repliesList = replyService.getList(url);
      repliesList.then(rep => {
        console.log(rep);
      });
      
      //댓글 추가
      /*
      replyService.add({
        reply: "js로 댓글써보기",
        replyer: "김태평",
        bno: "${board.bno}"
      }, result => {
        console.log(result);
      });
      */

      //목록 버튼 이벤트
      document.getElementById('list-btn').addEventListener('click', e => {
          location.href='/board/list?page=${pageInfo.page}&type=${pageInfo.type}&keyword=${pageInfo.keyword}';
      });

      //수정 버튼 이벤트
      document.getElementById('modify-btn').addEventListener('click', e => {
          location.href='/board/modify?page=${pageInfo.page}&type=${pageInfo.type}&keyword=${pageInfo.keyword}&bno=${board.bno}';
      });

});
</script>


<%@include file="../includes/footer.jsp"%>
