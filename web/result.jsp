<%-- 
    Document   : result
    Created on : Apr 26, 2018, 10:28:45 PM
    Author     : viquy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Product List of search <s:property value="keyword"/></h1>
        <table>
            <s:iterator value="products" var="product">
                <tr>
                    <td><s:property value="name"/></td>
                    <td><s:property value="price"/></td>
                    <td><s:property value="description"/></td>
                    <td><a href="addToCart?newProductId=<s:property value="id"/>">Add to cart</a></td>
                </tr>
            </s:iterator>
            <a href="index.jsp">Back</a>
        </table>
    </body>
</html>
