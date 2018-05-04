<%-- 
    Document   : viewCard
    Created on : Apr 26, 2018, 10:28:56 PM
    Author     : viquy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cart Details</h1>
        <table border="1">
            <tr>
                <th>Product</th>
                <th>Amount</th>
            </tr>
            <s:iterator value="products" var="product">
                <tr>
                    <td><s:property value="key.name"/></td>
                    <td><s:property value="value"/></td>
                    <td><a href="removeProductCart?productId=<s:property value="key.id"/>">remove</a></td>
                </tr>
            </s:iterator>
        </table>
        <label>Total:</label><s:property value="total"/><br/>
        <form action="checkOut">
            Name :<input name="name"/><br/>
            Phone :<input name="phone"/><br/>
            Address: <input name="address"/><br/>
            <input type="submit" value="ok"/>
        </form>
        <a href="index.jsp">Continue buying</a>
    </body>
</html>
