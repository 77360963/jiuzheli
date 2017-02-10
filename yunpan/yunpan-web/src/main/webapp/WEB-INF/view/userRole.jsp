    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
      
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
        <head>  
            <title>分配角色</title>  
        </head>  
      
        <body>  
            <form action="<%=request.getContextPath()%>/updateUser.html" method="post">  
                <input type="hidden" name="id" value="${requestScope.user.id }" >  
                <table frame="border" width="80%">  
                    <tr>  
                        <td>用户名称</td>  
                        <td>${requestScope.user.username }</td>  
                    </tr>  
                    <tr>  
                        <td>角色信息</td>  
                        <td>  
                            <c:forEach var="r" items="${requestScope.roleList}">  
                               <c:forEach var="ur" items="${requestScope.user.roles}">  
                                    <c:if test="${r.id==ur.id}"><c:set var="choice" value="true" /></c:if>  
                                </c:forEach> 
                                <input type="checkbox" value="${r.id }" name="rid" ${choice=='true'?'checked':'' } />${r.name }  
                                <c:remove var="choice" />  
                            </c:forEach>  
                        </td>  
                    </tr>  
                    <tr>  
                        <td></td>  
                        <td><input type="submit" value="更新用户"></td>  
                    </tr>  
                </table>  
            </form>  
        </body>  
    </html>  