<%@ page language="java" pageEncoding="utf-8"%>

<!-- 获取当前系统路径  -->
<% pageContext.setAttribute("path",request.getContextPath()); %>
<!-- System.currentTimeMillis 返回自1970年1月1日0时起的毫秒数；不保证精确度 -->
<% pageContext.setAttribute("id",String.valueOf(System.currentTimeMillis())); %>
