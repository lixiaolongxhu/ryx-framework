<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	
	/** 参考资料网站： http://blog.csdn.net/renfufei/article/details/39376311  */
	
	/**concat js数组合并方法
	*/
	function  concat(){
		var src=[1,2,3,4,5];
		var dest=[6,7,8,9];
		var result=src.concat(dest);
		alert("concat数组合并src="+src);
		alert("concat数组合并desc="+dest);
		alert("concat数组合并结果result="+result);
		src=desc=null;
	}
	
	function  reduce(){
		var q = [ 5, 5, 1, 9, 9, 6, 4, 5, 8];  
		var b = [ "tie", "mao", "csdn", "ren", "fu", "fei" ]; 
		// `b` onto `q`:
		q = b.reduce( function(coll,item){
		    coll.push( item );
		    return coll;
		}, q );

		alert("reduce合并数组`b` onto `q`= "+q);
		q; // [5,5,1,9,9,6,4,5,8,"tie","mao","csdn","ren","fu","fei"]

		// or `q` into `b`:
		b = q.reduceRight( function(coll,item){
			coll.push( item );
		//    coll.unshift( item );
		    return coll;
		}, b );
		alert("reduce合并数组`q` into `b`="+b)
		b; // [5,5,1,9,9,6,4,5,8,"tie","mao","csdn","ren","fu","fei"]
	}



</script>
<body>
<h2>js数组合并的方法以及比较</h2>
<p>
<input  type="button"  onclick="concat()" value="concat数组合并结果" />  
<br/>
concat(..)方法<br/>

最常见的用法如下:<br/>


复制代码 代码如下:<br/>
var c = q.concat( b );<br/>

q; // [5,5,1,9,9,6,4,5,8]<br/>
b; // ["tie","mao","csdn","ren","fu","fei"];<br/>

c; // [5,5,1,9,9,6,4,5,8,"tie","mao","csdn","ren","fu","fei"]<br/>


如您所见, c 是一个全新的数组, 表示 q 和 b 这两个数组的组合, 但是 q 和 b 现在没用了是吧?<br/>

如果 q 数组有10000个元素, b 数组也有有10000个元素? 那么数组c现在就有20000个元素, 这种方式占用了2倍的内存.<br/>

“这没问题!”,你可能会觉得. 只要将 q 和 b 置空就行, 然后就会被垃圾回收,对吗?问题解决了!<br/>


复制代码 代码如下:<br/>
q = b = null; // `q` and `b` 现在可以被垃圾回收了<br/>

额? 如果数组都很小,那自然没问题. 但对大型的数组,或需要多次重复处理时, 内存就被限制了, 它还需要进行优化.<br/>


</p>

<p><input  type="button"  onclick="reduce()" value="reduce数组合并结果" />  
<br/> </p>
</body>
</html>
