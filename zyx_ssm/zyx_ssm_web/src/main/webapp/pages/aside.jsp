<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><security:authentication property="principal.username"/></p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- search form -->
        <!--<form action="#" method="get" class="sidebar-form">
<div class="input-group">
    <input type="text" name="q" class="form-control" placeholder="搜索...">
    <span class="input-group-btn">
    <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
    </button>
  </span>
</div>
</form>-->
        <!-- /.search form -->

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index">
                <a href="${pageContext.request.contextPath}/index.jsp"><i class="glyphicon glyphicon-home"></i> <span>首页</span></a>
            </li>

            <!-- 菜单 -->

            <li class="treeview">
                <a href="#">
                    <i class="glyphicon glyphicon-hdd"></i> <span>系统操作</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <li id="admin-profile">
                        <a href="${pageContext.request.contextPath}/user/findAll.do?page=1&size=4">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                    </li>

                    <li id="admin-invoice">
                        <a href="${pageContext.request.contextPath}/role/findAll.do?page=1&size=4">
                            <i class="fa fa-circle-o"></i> 角色管理
                        </a>
                    </li>

                    <li id="product-add">
                        <a href="${pageContext.request.contextPath}/permission/findAll.do?page=1&size=4">
                            <i class="fa fa-circle-o"></i> 资源权限管理
                        </a>
                    </li>

                    <li>
                        <a href="${pageContext.request.contextPath}/sysLog/findAll.do?page=1&size=10">
                            <i class="fa fa-circle-o"></i> 访问日志
                        </a>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-bar-chart"></i> <span>基础数据</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <security:authorize access="hasRole('USER')">
                    <li id="findAll">
                        <a href="${pageContext.request.contextPath}/product/findAll.do?page=1&size=4">
                            <i class="fa fa-circle-o"></i> 产品管理
                        </a>
                    </li>
                    </security:authorize>

                    <li id="charts-inline">
                        <a href="${pageContext.request.contextPath}/orders/findAll.do?page=1&size=4">
                            <i class="fa fa-circle-o"></i> 订单管理
                        </a>
                    </li>

                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>