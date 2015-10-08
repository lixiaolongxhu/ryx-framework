<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function join(){
		
		var a=[1,2,3,4,5,6];
		alert("将数组转换为字符串："+a.join());
		alert("将数组转换为字符串："+a.join(""));
		alert("将数组转换为字符串(并向其中插入元素)："+a.join("@"));
	}

</script>
<body>
<h2>将js数组转换为字符串</h2>
<p>  
	<input type="button"  value="js数组转换为字符串"  onclick='join()'/>

</p>
</body>
</html>
