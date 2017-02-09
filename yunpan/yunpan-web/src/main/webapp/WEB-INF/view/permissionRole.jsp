    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
      
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
      <head>  
        <title>分配权限</title>  
      </head>  
        
      <body>  
         <form action="<%=request.getContextPath()%>/updateRole.html" method="post">  
        <input type="hidden" name="id" value="${requestScope.role.id }">  
        <input type="hidden" name="name" value="${requestScope.role.name }">  
        <input type="hidden" name="description" value="${requestScope.role.description }">  
        <table frame="border" width="80%">  
            <tr>  
                <td>角色名称</td>  
                <td>${requestScope.role.name }</td>  
            </tr>  
              
            <tr>  
                <td>角色描述</td>  
                <td>${requestScope.role.description }</td>  
            </tr>  
              
            <tr>  
                <td>拥有的权限</td>  
                <td>  
                    <c:forEach var="p" items="${requestScope.permission}">  
                        <c:forEach var="rp" items="${requestScope.role.permissions}">  
                            <c:if test="${p.id==rp.id}"><c:set var="choice" value="true" /></c:if>  
                        </c:forEach>  
                        <input type="checkbox" value="${p.id }" name="pid" ${choice=='true'?'checked':'' } />${p.name }  
                        <c:remove var="choice" />  
                    </c:forEach>  
                </td>  
            </tr>  
            <tr>  
                <td></td>  
                <td><input type="submit" value="更新角色"></td>  
            </tr>  
        </table>  
        </form>  
      </body>  
    </html>  