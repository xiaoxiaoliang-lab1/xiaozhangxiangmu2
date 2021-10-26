<%@ page import="java.util.List" %>
<%@ page import="entity.TaxPayer" %><%--
  Created by IntelliJ IDEA.
  User: zhangchengxian
  Date: 2021/10/20
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            text-align: center;
        }
    </style>
</head>
<body>
<form action="toEditTaxPayerServlet.do" method="post">
<table >

    <tr>
        <th cowspan="4">纳税人详情</th>
    </tr>

    <tr>
        <td>纳税人识别号</td>
        <td>
            <input type="hidden" name="id" value="${requestScope.gaitaxPayer.id}">
            <input type="text" name="payerCode" value="${gaitaxPayer.payerCode}">

        </td>
        <td>纳税人名称</td>
        <td>
            <input type="text" name="payerName" value="${gaitaxPayer.payerName}">
        </td>
    </tr>

    <tr>
        <td>生产经营地址</td>
        <td>
            <input type="text" name="bizAddress" value="${gaitaxPayer.bizAddress}">
            ${taxPayer.bizAddress}</td>
        <td>生产经营地电话</td>
        <td>
            <input type="text" name="legalMobile" value="${gaitaxPayer.legalMobile}">
        </td>
    </tr>


    <tr>
        <td>所属税务机关</td>
        <td>
<%--            <select>--%>
<%--            <c:forEach items="${requestScope.organs}" var="a">--%>
<%--                <option value="${a.id}">${a.organName}</option>--%>
<%--            </c:forEach>--%>
<%--            </select>--%>

            <select name="taxOrganId" id="selectOrgan" >
                <option>请选择税务机关</option>
                <c:forEach items="${sessionScope.organs}" var="organ">
                    <option value="${organ.id }" ${organ.id == gaitaxPayer.taxOrganId?"selected":""}>${organ.organName }</option>
                </c:forEach>
            </select>
        </td>
        <td>行业</td>
        <td>
            <select name="taxIndustr"  >
                <option>请选择行业类型</option>
                <c:forEach items="${sessionScope.Allhangye}" var="a">
                    <option value="${a.id }" ${a.id == requestScope.gaitaxPayer.industryId ? "selected":""}>${a.industryName}</option>
                </c:forEach>
            </select>
        </td>
    </tr>


    <tr>
        <td>生产经营范围</td>
        <td>
            <input type="text" name="bizScope" value="${gaitaxPayer.bizScope}">
        </td>
        <td>票种核定</td>
        <td>
            <select name="piaozhong">
                <option value="增值税普通发票"  ${requestScope.gaitaxPayer.invoiceType == "增值税普通发票" ? "selected":"" }>增值税普通发票</option>
                <option value="增值税专用发票" ${requestScope.gaitaxPayer.invoiceType == "增值税专用发票" ? "selected":"" }>增值税专用发票</option>
            </select>

        </td>
    </tr>


    <tr>
        <td>法定代表人</td>
        <td>
            <input type="text" name="legalPerson" value="${gaitaxPayer.legalPerson}">
        </td>
        <td>法人身份证号</td>
        <td>
            <input type="text" name="legalIdCard" value="${gaitaxPayer.legalIdCard}">
         </td>
    </tr>


    <tr>
        <td>主管财务</td>
        <td>
            <input type="text" name="finaceName" value="${gaitaxPayer.finaceName}">
        </td>
        <td>财务身份证号</td>
        <td>
            <input type="text" name="finaceIdCard" value="${gaitaxPayer.finaceIdCard}">
         </td>
    </tr>


    <tr>
        <td>法人身份证照片</td>
        <td></td>
        <td>财务身份证照片</td>
        <td></td>
    </tr>


    <tr>
        <td>录入人员</td>
        <td>${requestScope.gaitaxerName}</td>
        <td>录入日期</td>
        <td>${gaitaxPayer.recordDate}</td>

    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="提交"></td>
        <td colspan="2"><input type="reset" value="重置"></td>
    </tr>
</table>
</form>
</body>
</html>
