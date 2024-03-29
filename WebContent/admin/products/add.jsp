<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/CSS/addCss.css" />
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">
    <!-- enctype="multipart/form-data"实现文件上传 -->
    <div id="bg">
    <div id="details">
    <table>
		<tr><td>商品名称</td><td><input type="text" name="gName" /></td></tr>
		<tr><td>商品价格</td><td><input type="text" name="gPrice" /></td></tr>
	<tr>
		<td>商品类别</td><td>
		<select name="gType">
			<option value="" selected="selected">--选择商品类加--</option>
            <option value="卡牌">卡牌</option>
			<option value="冒险">冒险</option>
			<option value="竞技">竞技</option>
			<option value="塔防">塔防</option>
			<option value="模拟">模拟</option>
			<option value="休闲">休闲</option>
			<option value="恐怖">恐怖</option>
			<option value="RPG">RPG</option>
			<option value="策略">策略</option>
			<option value="动作">动作</option>
			<option value="射击">射击</option>
			<option value="音乐">音乐</option>
			<option value="体育">体育</option>
			<option value="格斗">格斗</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>商品图片</td>
		<td colspan="3"><div class="button"><input type="file" name="upload" size="30" value="" /></div></td>
	</tr>
	<tr>
		<td>商品评分</td>
		<td><input type="text" name="gScore" /></td>
	</tr>
	<tr>
	    <td>商品描述</td>
	    <td><textarea name="gDescription" cols="30" rows="3" style="WIDTH: 96%"></textarea></td>
	</tr>
	<tr>
		<td>
		</td>
	</tr>
    </table>
    
    <div class="button" id="bottom">
		<input type="submit" value="确定">	
		<input type="reset" value="重置">
		<input type="button" onclick="history.go(-1)" value="返回" />
	</div>				
    
    </div>
    </div>
</form>
</body>
</html>