<%-- 
    Document   : showListProduct
    Created on : May 3, 2018, 5:03:00 PM
    Author     : viquy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <center>
                <table border="1">
                    <tr>
                        <th>Product name</th>
                        <th>Product Price</th>
                        <th>Product description</th>
                    </tr>
                    <s:iterator value="products" var="product">
                        <tr>
                            <td><s:property value="key.name"/> </td>
                            <td><s:property value="key.price"/> </td>
                            <td><s:property value="key.description"/> </td>
                            <td><a href="addToCart?newProductId=<s:property value="id"/>">Add to cart</a></td>
                        </tr>
                    </s:iterator>               
                </table>
            </center>
    </body>
</html>
