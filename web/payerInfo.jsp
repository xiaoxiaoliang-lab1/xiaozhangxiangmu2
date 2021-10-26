<%--
  Created by IntelliJ IDEA.
  User: zhangchengxian
  Date: 2021/10/20
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px solid black;
            mso-cellspacing: 0px;

        }
        td{
            border: 1px solid black;
            width: 200px;
        }
    </style>
</head>
<body>
<%--<base href="<%=basePath%>">--%>
<title>查看办税专员</title>
<%--<link href="static/css/base.css" rel="stylesheet">--%>
<%--<link rel="stylesheet" href="static/easyui/uimaker/easyui.css">--%>
<%--<link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">--%>
<%--<link href="static/css/edit.css" rel="stylesheet">--%>

<table >

    <tr>
        <th cowspan="4">纳税人详情</th>
    </tr>

    <tr>
        <td>纳税人识别号</td>
        <td>${taxPayer.payerCode}</td>
        <td>纳税人名称</td>
        <td>${taxPayer.payerName}</td>
    </tr>

    <tr>
        <td>生产经营地址</td>
        <td>${taxPayer.bizAddress}</td>
        <td>生产经营地电话</td>
        <td>${taxPayer.legalMobile}</td>
    </tr>


    <tr>
        <td>所属税务机关</td>
        <td>${taxPayer.organName}</td>
        <td>行业</td>
        <td>${taxPayer.industryName}</td>
    </tr>


    <tr>
        <td>生产经营范围</td>
        <td>${taxPayer.bizScope}</td>
        <td>票种核定</td>
        <td>${taxPayer.invoiceType}</td>
    </tr>


    <tr>
        <td>法定代表人</td>
        <td>${taxPayer.legalPerson}</td>
        <td>法人身份证号</td>
        <td>${taxPayer.legalIdCard}</td>
    </tr>


    <tr>
        <td>主管财务</td>
        <td>${taxPayer.finaceName}</td>
        <td>财务身份证号</td>
        <td>${taxPayer.finaceIdCard}</td>
    </tr>


    <tr>
        <td>法人身份证照片</td>
        <td></td>
        <td>财务身份证照片</td>
        <td></td>
    </tr>


    <tr>
        <td>录入人员</td>
        <td>${requestScope.taxerName}</td>
        <td>录入日期</td>
        <td>${taxPayer.recordDate}</td>
    </tr>

</table>

</body>
</html>
