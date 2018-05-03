<%-- 
    Document   : viewCard
    Created on : Apr 26, 2018, 10:28:56 PM
    Author     : viquy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Details</title>
    </head>
    <body>
        <h1>Cart Details</h1>
        <table border="1">
            <tr>
                <th>Product</th>
                <th>Unit</th>
                <th>Amount</th>
            </tr>
            <s:iterator value="products" var="product">
                <tr>
                    <td><s:property value="key.name"/></td>
                    <td><s:property value="key.price"/></td>
                    <td><s:property value="value"/></td>
                </tr>
            </s:iterator>
        </table>
        <label> Total: </label><s:property value="total"/> <br/>
        <a href="index.jsp">Continue shopping</a>
        <a href="pay.jsp"> Pay </a>
    </body>
</html>
