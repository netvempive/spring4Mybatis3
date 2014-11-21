<#-- 模态窗口 --> 
<#macro modal>
<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content"></div>
	</div>
</div>
<script type="text/javascript">
<!--
$(function(){modal();});
/* 模态窗口JS */
function modal() {
	$("#myModal").on("hidden.bs.modal", function(e) {
		$(this).removeData("bs.modal").find(".modal-content").empty();
	});
}
//-->
</script>
</#macro>
