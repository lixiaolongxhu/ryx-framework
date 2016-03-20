<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>test</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">



<script type="text/javascript">
		
		
		 var myObject={
				 num :2,
				 add :function(){
					 this.num=3;
					 (function(){
						 alert(this.num);
						 this.num=4;
						 
					 })();
					 
					 alert(this.num);
				 }
				  
				  
		  }
		function init(){
		   //alert("初始踩入");
		  // var  str='({name:"test",id:1})';
		  // alert(str);
		  // var a=eval(str);
		  // alert(a.name);
		  
		//  var txt=new Array("Ge","jon","thomes");
		  //alert(txt[0]);
		
		  
		 
		  
			// myObject.add();
		 
		}	
		 
		 
		 
		
	</script>
</head>
<body onload="init()">
	<button id="btnSave" value="牛"></button>
	<script type="text/javascript">
	 var btn=document.getElementById("btnSave");
	 alert(btn);
	 btn.onclick=function(){
		 alert("hello");
	 }
	</script>
</body>
</html>