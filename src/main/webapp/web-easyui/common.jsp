<%@ page language="java" pageEncoding="utf-8"%>
<!-- 引入需要使用的jsp标签库   begin   -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- 引入需要使用的jsp标签库   end   -->
<!-- 获取当前系统路径  -->
<% pageContext.setAttribute("path",request.getContextPath()); %>
<!-- System.currentTimeMillis 返回自1970年1月1日0时起的毫秒数；不保证精确度 -->
<% pageContext.setAttribute("id",String.valueOf(System.currentTimeMillis())); %>
