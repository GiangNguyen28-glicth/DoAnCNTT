<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="sidebar py-3" id="sidebar">
    <h6 class="sidebar-heading">Main</h6>
    <ul class="list-unstyled">
        <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="${pageContext.request.contextPath}/admin-home">
            <svg class="svg-icon svg-icon-md me-3">
                <use xlink:href="icons/orion-svg-sprite.57a86639.svg#real-estate-1"> </use>
            </svg><span class="sidebar-link-title active text-muted">Dashboard</span></a></li>
        <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="${pageContext.request.contextPath}/trang-chu">
            <svg class="svg-icon svg-icon-md me-3">
                <use xlink:href="icons/orion-svg-sprite.57a86639.svg#real-estate-1"> </use>
            </svg><span class="sidebar-link-title active text-muted">Home</span></a></li>
        <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="#" data-bs-target="#cmsDropdown" role="button" aria-expanded="false" data-bs-toggle="collapse">
            <svg class="svg-icon svg-icon-md me-3">
                <use xlink:href="icons/orion-svg-sprite.57a86639.svg#reading-1"> </use>
            </svg><span class="sidebar-link-title">CMS </span></a>
            <ul class="sidebar-menu list-unstyled collapse " id="cmsDropdown">
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="${pageContext.request.contextPath}/admin-category">Categories</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="${pageContext.request.contextPath}/admin-product?page=1&&maxPageItem=2">Products</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="${pageContext.request.contextPath}/admin-product?action=insert">Products - New</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="${pageContext.request.contextPath}/admin-user">User</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="${pageContext.request.contextPath}/admin-delivery">Delivery</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="${pageContext.request.contextPath}/admin-delivery?action=insert">Delivery - New</a></li>
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="${pageContext.request.contextPath}/admin-saledetail">Saledetails</a></li>
            </ul>
        </li>
        <li class="sidebar-list-item"><a class="sidebar-link text-muted " href="#" data-bs-target="#widgetsDropdown" role="button" aria-expanded="false" data-bs-toggle="collapse">
            <svg class="svg-icon svg-icon-md me-3">
                <use xlink:href="icons/orion-svg-sprite.57a86639.svg#statistic-1"> </use>
            </svg><span class="sidebar-link-title">Customer </span></a>
            <ul class="sidebar-menu list-unstyled collapse " id="widgetsDropdown">
                <li class="sidebar-list-item"><a class="sidebar-link text-muted" href="${pageContext.request.contextPath}/admin-customers">List Customer</a></li>
            </ul>
        </li>
    </ul>
</div>