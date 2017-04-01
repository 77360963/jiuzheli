    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
      
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
      <head>  
        <title>My JSP 'rolelist.jsp' starting page</title>  
      </head>  
        
      <body>  
          <table width="90%">  
            <tr>  
                <td align="right">  
                    <a href="<%=request.getContextPath()%>/addRole.html">添加角色</a>  
                </td>  
            </tr>  
        </table>  
          
        <table frame="border" width="90%">  
            <tr>  
                <td>角色名称</td>  
                <td>角色描述</td>  
                <td>角色拥有的权限</td>  
                <td>操作</td>  
            </tr>  
            <c:forEach var="r" items="${roleList}">  
                <tr>  
                    <td>${r.name}</td>  
                    <td>${r.description }</td>  
                    <td>  
                       <%--  <c:forEach var="p" items="${r.permissions}">  
                            ${p.name }  
                        </c:forEach>   --%>
                    </td>  
                    <td>  
                        <a href="<%=request.getContextPath()%>/rolePermission.html?id=${r.id}">分配权限</a>  
                        <a href="<%=request.getContextPath()%>/delRole.html?id=${r.id}"">删除</a>  
                    </td>  
                </tr>  
            </c:forEach>  
          
        </table>  
      </body>  
    </html>  