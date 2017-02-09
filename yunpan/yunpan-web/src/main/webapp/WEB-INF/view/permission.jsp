<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>权限列表</title>  
  </head>  
    
  <body>  
     <table width="90%">  
        <tr>  
            <td align="right"> 
               <a href="<%=request.getContextPath()%>/addPermission.html">添加权限</a>   
            </td>  
        </tr>  
    </table>  
      
    <table frame="border" width="90%">  
        <tr>  
            <td>权限名称</td>  
            <td>权限描述</td>  
            <td>操作</td>  
        </tr>       
       
          
        <c:forEach var="p" items="${requestScope.permissionList}">  
            <tr>  
                <td>${p.name }</td>  
                <td>${p.description }</td>  
                <td>  
                   <a href="<%=request.getContextPath()%>/delPermission.html?id=${p.id}">删除</a>
                </td>  
            </tr>  
        </c:forEach>  
      
    </table>  
  </body>  
</html> 