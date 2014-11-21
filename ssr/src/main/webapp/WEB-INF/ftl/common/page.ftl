<#macro tablePage>
<div class="text-center">
	<#if page?? && page.totalElements != 0>
		<ul id="page" currentPage="${(page.number+1)!}" totalPages="${(page.totalPages)!}" style="margin: 10px 0"></ul>
		<script type="text/javascript" src="${base}/resources/plugs/bootstrap-paginator/0.5/bootstrap-paginator.min.js"></script>
		<script type="text/javascript">
		<!--
		/**
		 * 分页信息JS
		 */
		function page() {
			var options = {
				currentPage : $("#page").attr("currentPage"),
				totalPages : $("#page").attr("totalPages"),
				onPageClicked : function(e, originalEvent, type, page) {
					var $form = $("#page").parents("form");
					$form.find("input[name='page']").remove();
					$form.append("<input type='hidden' name='page' value='" + (page - 1) + "'>");
					$form.submit();
				}
			};
			$('#page').bootstrapPaginator(options);
		}
		$(function(){page();});
		//-->
		</script>
	<#else>
		<h4>暂无数据！</h4>
	</#if>
</div>
</#macro>
