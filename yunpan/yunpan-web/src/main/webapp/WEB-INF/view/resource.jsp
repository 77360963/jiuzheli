    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
      
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
      <head>  
        <title>资源管理</title>  
      </head>  
        
      <body>  
         <table width="90%">  
            <tr>  
                <td align="right">  
                    <a href="<%=request.getContextPath()%>/addResource.html">添加资源</a>  
                </td>  
            </tr>  
        </table>  
        <table frame="border" width="90%">  
            <tr>  
                <td>资源URI</td>  
                <td>资源描述</td>  
                <td>管理资源的权限</td>  
                <td>操作</td>  
            </tr>  
            <c:forEach var="resource" items="${requestScope.resourceList}">  
                <tr>  
                    <td>${resource.uri }</td>  
                    <td>${resource.description }</td>  
                    <td>${resource.permission.name}</td>  
                    <td>  
                        <a href="<%=request.getContextPath()%>/editResource.html?id=${resource.id }">分配权限</a>  
                        <a href="<%=request.getContextPath()%>/delResource.html?id=${resource.id }">删除</a>  
                    </td>  
                </tr>  
            </c:forEach>  
        </table>  
      </body>  
    </html>  