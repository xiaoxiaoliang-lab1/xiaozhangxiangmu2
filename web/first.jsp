<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>河南省金税三期税源信息管理系统</title>
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/platform.css">
    <link rel="stylesheet" href="static/easyui/uimaker/easyui.css">
</head>

<body>
<div class="container">
    <div id="pf-hd">
        <div class="pf-logo">
            <div class="system-name">税源信息管理系统</div>
        </div>
        <!--顶部用户信息-->
        <div class="pf-user">
            <!--用户头像-->
            <div class="pf-user-photo">
                <img src="static/images/main/user.png" alt="">
            </div>
            <!--用户名-->
<%--            <h4 class="pf-user-name ellipsis" id="">${sessionScope.user.username }</h4>--%>
            <i class="iconfont xiala">&#xe607;</i>
            <!-- 头部用户信息 下拉菜单 -->
            <div class="pf-user-panel" style="width: 200px;">
                <ul class="pf-user-opt">
                    <li>
                        <a href="javascript:void(0);">
                            <i class="iconfont">&#xe60d;</i>
                            <span class="pf-opt-name userInfo" id="userInfo">用户信息</span>
                        </a>
                    </li>
                    <li class="pf-modify-pwd">
                        <a href="javascript:void(0)">
                            <i class="iconfont">&#xe634;</i>
                            <span class="pf-opt-name modify_pwd">修改密码</span>
                        </a>
                    </li>
                    <li class="pf-logout">
                        <a href="javascript:void(0);">
                            <i class="iconfont">&#xe60e;</i>
                            <span class="pf-opt-name exit">退出</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div><!-- 头部用户信息结束 -->

    <!-- 左侧边侧滑菜单 -->
    <div id="pf-bd">
        <div id="pf-sider">
            <!-- 系统菜单 标题-->
            <h2 class="pf-model-name">
                <span class="iconfont">&#xe64a;</span>
                <span class="pf-name">系统菜单</span>
                <span class="toggle-icon"></span>
            </h2>
            <!-- 侧滑菜单开始 -->
            <ul class="sider-nav">
                <!--<li class="current">-->
                <li>
                    <a href="javascript:addTab('纳税人管理','listpayer.jsp')">
                        <span class="iconfont sider-nav-icon">&#xe620;</span>
                        <span class="sider-nav-title">纳税人管理</span>
                        <i class="iconfont">&#xe642;</i>
                    </a>
                </li>
                <li>
                    <a href="javascript:;">
                        <span class="iconfont sider-nav-icon">&#xe625;</span>
                        <span class="sider-nav-title">调查任务管理</span>
                        <i class="iconfont">&#xe642;</i>
                    </a>
                    <ul class="sider-nav-s">
                        <li class="active"><a href="javascript:addTab('任务查询','toSearchTaskServlet.do')">调查任务查询</a></li>
                        <li><a href="javascript:addTab('调查任务录入','toAddTaskServlet.do')">调查任务录入</a></li>
                        <li><a href="javascript:addTab('未调查企业统计', 'statistical.jsp')">未被调查企业统计</a></li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:addTab('办税专员管理','listTaxer.jsp');">
                        <span class="iconfont sider-nav-icon">&#xe620;</span>
                        <span class="sider-nav-title">办税专员管理</span>
                        <i class="iconfont">&#xe642;</i>
                    </a>
                </li>
                <li>
                    <a href="javascript:;">
                        <span class="iconfont sider-nav-icon">&#xe611;</span>
                        <span class="sider-nav-title">个人信息</span>
                        <i class="iconfont">&#xe642;</i>
                    </a>
                    <ul class="sider-nav-s">
                        <li class="active"><a href="javascript:void(0);" class="userInfo">个人基本信息</a></li>
                        <li><a href="javascript:void(0);" class="modify_pwd">密码修改</a></li>
                        <li ><a href="javascript:void(0);" class="exit">退出系统</a></li>
                    </ul>
                </li>
            </ul>
        </div>

        <div id="pf-page">
            <div class="easyui-tabs1" style="width:100%;height:100%;">
                <div title="首页" style="padding:10px 5px 5px 10px;">
                    <iframe class="page-iframe" src="home.jsp" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                </div>
            </div>
        </div>
    </div>

    <div id="pf-ft">
        <div class="system-name">
            <i class="iconfont">&#xe6fe;</i>
            <span>税源信息管理系统&nbsp;v1.0</span>
        </div>
        <div class="copyright-name">
            <span>CopyRight&nbsp;2017&nbsp;&nbsp;zhidisoft.com&nbsp;版权所有</span>
            <i class="iconfont" >&#xe6ff;</i>
        </div>
    </div>
</div>
<div id="topWindow"></div>
<!-- <script type="text/javascript" src="js/menu.js"></script> -->
<script type="text/javascript" src="static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="static/js/main.js"></script>
<!--[if IE 7]>
<script type="text/javascript">
    $(window).resize(function(){
        $('#pf-bd').height($(window).height()-76);
    }).resize();

</script>
<![endif]-->


<script type="text/javascript">
    //退出按钮注册监听事件
    $(function(){
        //显示用户信息
        $(".userInfo").on("click",function(){
            $("#topWindow").window({
                title:"用户信息",
                width:800,
                height:300,
                content:"<iframe scrolling='no' width='100%' height='100%' src='userInfo.do'></iframe>"
            })
        })

        //修改密码
        $(".modify_pwd").on("click",function(){
            $("#topWindow").window({
                title:"修改密码",
                width:400,
                height:300,
                content:"<iframe scrolling='no' width='100%' height='100%' src='modifypassword.jsp'></iframe>"
            })
        })

        //退出登录
        $(".exit").on("click",function(e){
            $.messager.confirm("警告","确定退出税源信息管理系统？",function(data){
                if(data){
                    //发送退出系统请求
                    //退出成功重定向到登录页面
                    window.location.href="login.html"
                }
            });
        });
    });

    $('.easyui-tabs1').tabs({
        tabHeight: 44,
        onSelect:function(title,index){
            var currentTab = $('.easyui-tabs1').tabs("getSelected");
            if(currentTab.find("iframe") && currentTab.find("iframe").size()){
                currentTab.find("iframe").attr("src",currentTab.find("iframe").attr("src"));
            }
        }
    });
    function addTab(title, url){
        if ($('.easyui-tabs1').tabs('exists', title)){
            $('.easyui-tabs1').tabs('select', title);
        } else {
            var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
            $('.easyui-tabs1').tabs('add',{
                title:title,
                content:content,
                closable:true
            });
        }
    }
    $('.sider-nav-s li a').on('click',function(e){
        var parent = $(this).parent();
        parent.addClass("active").siblings().removeClass("active");

    });
    $(window).resize(function(){
        $('.tabs-panels').height($("#pf-page").height()-46);
        $('.panel-body').height($("#pf-page").height()-76)
    }).resize();

    var page = 0,
        pages = ($('.pf-nav').height() / 70) - 1;

    if(pages === 0){
        $('.pf-nav-prev,.pf-nav-next').hide();
    }
    $(document).on('click', '.pf-nav-prev,.pf-nav-next', function(){
        if($(this).hasClass('disabled')) return;
        if($(this).hasClass('pf-nav-next')){
            page++;
            $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
            if(page == pages){
                $(this).addClass('disabled');
                $('.pf-nav-prev').removeClass('disabled');
            }else{
                $('.pf-nav-prev').removeClass('disabled');
            }

        }else{
            page--;
            $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
            if(page == 0){
                $(this).addClass('disabled');
                $('.pf-nav-next').removeClass('disabled');
            }else{
                $('.pf-nav-next').removeClass('disabled');
            }

        }
    })

    // setTimeout(function(){
    //    $('.tabs-panels').height($("#pf-page").height()-46);
    //    $('.panel-body').height($("#pf-page").height()-76)
    // }, 200)
</script>
</body>
</html>
