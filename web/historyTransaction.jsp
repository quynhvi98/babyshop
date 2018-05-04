<%-- 
    Document   : pay
    Created on : May 3, 2018, 4:07:50 PM
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
        <table border="1">
            <h4>History Transaction</h4>
            <th>Name</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Total</th>
            <s:iterator value="customers" var="c">
                <tr>
                    <td><s:property value="name"/></td>
                    <td><s:property value="phone"/></td>
                    <td><s:property value="address"/></td>
                    <td><s:property value="total"/>$</td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
