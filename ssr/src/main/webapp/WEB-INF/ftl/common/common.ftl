<#assign base=request.contextPath />

<#-- 公共标签引入 -->
<#include "/common/page.ftl"/>
<#include "/common/modal.ftl"/>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<#--CSS样式定义 -->
<link href="${base}/resources/css/bootstrap/3.1.1/bootstrap.min.css" rel="stylesheet">
<link href="${base}/resources/css/bootstrap/3.1.1/bootstrap-theme.min.css" rel="stylesheet">
<link href="${base}/resources/css/common.css" rel="stylesheet">

<#-- JS脚本定义 -->
<script type="text/javascript" src="${base}/resources/js/jquery/1.11.0/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/js/common/common.js"></script>
<script type="text/javascript" src="${base}/resources/js/bootstrap/3.1.1/bootstrap.min.js"></script>

<#-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="${base}/resources/js/common/html5shiv.min.js"></script>
  <script src="${base}/resources/js/common/respond.min.js"></script>
<![endif]-->

<#-- easyui组件信息 --> 
<#macro easyui>
<link href="${base}/resources/plugs/easy-ui/1.3.5/themes/bootstrap/easyui.css" rel="stylesheet">
<link href="${base}/resources/plugs/easy-ui/1.3.5/themes/icon.css" rel="stylesheet">
<script type="text/javascript" src="${base}/resources/plugs/easy-ui/1.3.5/jquery.easyui.min.js"></script>
</#macro>

<#-- pnotify组件  -->
<#macro pnotify>
<link href="${base}/resources/plugs/pnotify/1.2.2/jquery.pnotify.default.css" rel="stylesheet">
<link href="${base}/resources/plugs/pnotify/1.2.2/jquery.pnotify.default.icons.css" rel="stylesheet">
<script type="text/javascript" src="${base}/resources/plugs/pnotify/1.2.2/jquery.pnotify.js"></script>
</#macro>

