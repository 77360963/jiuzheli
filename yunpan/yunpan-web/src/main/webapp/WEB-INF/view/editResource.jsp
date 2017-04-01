    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
      
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
      <head>  
        <title>分配权限</title>  
      </head>  
        
      <body>  
        <form action="<%=request.getContextPath()%>/updateResource.html" method="post">  
        <table>  
            <tr>  
                <td>资源uri</td>  
                <td>  
                    <input type="text" name="uri" value="${requestScope.resource.uri }">  
                </td>  
            </tr>  
            <tr>  
                <td>资源描述</td>  
                <td>  
                    <textarea rows="3" cols="50" name="description">${requestScope.resource.description }</textarea>  
                </td>  
            </tr>  
            <tr>  
                <td>资源控制权限</td>  
                <td>  
                    <c:forEach var="p" items="${requestScope.permissionList}">  
                       <input type="radio" name="permissionId" value="${p.id }" ${p.id==requestScope.resource.permission.id?'checked':'' }>${p.name } 
                    </c:forEach>  
                </td>  
            </tr>  
            <tr>  
                <td><input type="text" value="${requestScope.resource.id }" name="id"></td>  
                <td>  
                    <input type="submit" value="添加资源">  
                </td>  
            </tr>  
        </table>  
        </form>  
      </body>  
    </html>  