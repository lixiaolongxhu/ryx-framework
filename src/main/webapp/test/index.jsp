<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.Date"%>
<%@page import="com.sample.util.DateUtil"%>
<html>
<body>
<h2>欢迎使用我封装的框架--李小龙! Time=<%=DateUtil.dateToString(new Date(), DateUtil.DATAFORMAT0) %></h2>
</body>
</html>
