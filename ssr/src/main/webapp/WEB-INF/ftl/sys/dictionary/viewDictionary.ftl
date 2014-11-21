<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>字典列表</title>
</head>
<body>
	<form class="form-horizontal" role="form">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="myModalLabel">添加</h4>
		</div>

		<div class="modal-body">
			<div class="form-group">
				<label for="dicName" class="col-md-2 control-label">名称</label>
				<div class="col-md-5">
					<input type="text" disabled="disabled" class="form-control" value="${dictionary.dicName}" id="dicName" placeholder="名称">
				</div>
			</div>
			<div class="form-group">
				<label for="dicValue" class="col-md-2 control-label">值</label>
				<div class="col-md-5">
					<input type="text" disabled="disabled" class="form-control" value="${dictionary.dicValue}" id="dicValue" placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicGroup" class="col-md-2 control-label">组</label>
				<div class="col-md-5">
					<input type="text" disabled="disabled" class="form-control" value="${dictionary.dicGroup}" id="dicGroup" placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicType" class="col-md-2 control-label">类型</label>
				<div class="col-md-5">
					<input type="text" disabled="disabled" class="form-control" value="${dictionary.dicType}" id="dicType" placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicOrder" class="col-md-2 control-label">排序</label>
				<div class="col-md-5">
					<input type="text" disabled="disabled" class="form-control" value="${dictionary.dicOrder}" id="dicOrder" placeholder="值">
				</div>
			</div>
			<div class="form-group">
				<label for="dicStatus" class="col-md-2 control-label">状态</label>
				<div class="col-md-5">
					<input type="text" disabled="disabled" class="form-control" value="${dictionary.dicStatus}" id="dicStatus" placeholder="值">
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		</div>
	</form>
</body>
</html>
