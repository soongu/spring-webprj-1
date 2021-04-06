<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Modify</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">

            <div class="panel-heading">Board Modify</div>
            <!-- /.panel-heading -->
            <div class="panel-body">

                <form role="form" action="/board/modify" method="post">

                    <div class="form-group">
                        <label>Bno</label>
                        <input class="form-control" name='bno' value='${board.bno}' readonly>
                    </div>

                    <div class="form-group">
                        <label>Title</label>
                        <input class="form-control" name='title' value='${board.title}'>
                    </div>

                    <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" rows="5" name='content'>${board.content}</textarea>
                    </div>

                    <div class="form-group">
                        <label>Writer</label>
                        <input class="form-control" name='writer' value='${board.writer}' readonly>
                    </div>

                    <div class="form-group">
                        <label>RegDate</label>
                        <input class="form-control" name='regDate'
                            value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.regDate}" />' readonly>
                    </div>

                    <div class="form-group">
                        <label>Update Date</label>
                        <input class="form-control" name='updateDate'
                            value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.updateDate}" />' readonly>
                    </div>



                    <div class="btn-group">
                        <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
                        <button type="button" data-oper='remove' class="btn btn-danger">Remove</button>
                        <button type="button" data-oper='list' class="btn btn-info">List</button>
                    </div>
                </form>


            </div>
            <!--  end panel-body -->

        </div>
        <!--  end panel-body -->
    </div>
    <!-- end panel -->
</div>
<!-- /.row -->



<%@include file="../includes/footer.jsp"%>