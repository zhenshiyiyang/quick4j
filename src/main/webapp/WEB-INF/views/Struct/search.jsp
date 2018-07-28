<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>查询</title>
	<meta name="MobileOptimized" content="320">
	<link rel="stylesheet" type="text/css" href="app/css/qmp/chart.css" />
	<link rel="stylesheet" type="text/css" href="app/css/qmp/public.css">
	<link rel="stylesheet" type="text/css" href="app/css/qmp/search.css">
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body style="background-color:white;">

<div  class="container con">

	<div class=" sql">
		<!--Body content-->

		<div class="panel panel-primary pad">
			<div class="panel-heading" role="tab" id="headingOne">
				<h4 class="panel-title">
					<a role="button" data-toggle="collapse"
					   data-parent="#accordion" href="#collapseOne"
					   aria-expanded="true" aria-controls="collapseOne" id="c1a"> 选择数据库
					</a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in"
				 role="tabpanel" aria-labelledby="headingOne">
				<div class="panel-body">
					<div id="div_1">
						<table >
							<tr>
								<td><button type="button" class="btn btn-lg " ><span class="glyphicon glyphicon-floppy-disk " style="color:white;">Driver</span></button></td>
								<td><select class="div_1_input dbsel" name="driver" id="dbDriver">
									<option value=""></option>
									<option value="oracle">mysql</option>
								</select></td>
							</tr>
							<tr>
								<!-- <td>URL:</td>-->
								<td><input class="inpMain" size="42" type="text" name="url" id="dbUrl" style="display:none"/></td>
							</tr>
							<tr>
								<!-- <td>Username:</td> -->
								<td><input class="inpMain" size="42" type="text" name="username" id="dbName" style="display:none"/></td>
							</tr>
							<tr>
								<!-- <td>Password:</td>-->
								<td><input class="inpMain" size="42" type="text" name="password" id="dbPwd" style="display:none"/></td>
							</tr>
						</table>
						<div id="" class="btn_right" >
							<input type="button" class="btn btn-primary" value="前进" id="pro_1" />
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-primary pad">
			<div class="panel-heading" role="tab" id="headingTwo">
				<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse"
					   data-parent="#accordion" href="#collapseTwo"
					   aria-expanded="false" aria-controls="collapseTwo" id="c4a"> 选择模块类别   </a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse"
				 role="tabpanel" aria-labelledby="headingTwo">
				<div class="panel-body">
					<div id="div_4" >
						<div id="div_4_1">
							<div id="div_4_1_1">
								<table>
									<tr>
										<td>
											<select multiple class="form-control" id="select_4_1"></select>
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div id="div_4_2" class="btn_right">
							<input type="button" class="btn btn-primary" value="后退" id="pro_4_back">
							<input type="button" class="btn btn-primary" value="前进"  id="pro_4" />
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="panel panel-primary pad" >
			<div class="panel-heading" role="tab" id="headingThree">
				<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse"
					   data-parent="#accordion" href="#collapseThree"
					   aria-expanded="false" aria-controls="collapseThree" id="c2a"> 选择查询的表   </a>
				</h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse"
				 role="tabpanel" aria-labelledby="headingThree">
				<div class="panel-body">
					<div id="div_2" >
						<div id="div_2_1">
							<div id="div_2_1_1">
								<table>
									<tr>
										<td>
											<select multiple class="form-control" id="select_2_1"></select>
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div id="div_2_2" class="btn_right">
							<input type="button" class="btn btn-primary" value="后退" id="pro_2_back">
							<input type="button" class="btn btn-primary" value="前进"  id="pro_2" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="panel panel-primary pad">
			<div class="panel-heading" role="tab" id="headingFive">
				<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse"
					   data-parent="#accordion" href="#collapseFive"
					   aria-expanded="false" aria-controls="collapseFive" id="c3a">
						选择查询的属性 </a>
				</h4>
			</div>
			<div id="collapseFive" class="panel-collapse collapse"
				 role="tabpanel" aria-labelledby="headingFive">
				<div class="panel-body">
					<div id="div_3" >
						<div id="simDiv" >
							<div id="div_3_1">
								<div id="div_3_1_1">
									<!-- <table>
                                        <tr>
                                            <td>
                                                <select multiple class="form-control" id="select_3_1"></select>
                                            </td>
                                        </tr>
                                    </table> -->

									<div id="list" style="display: block">
										<table  width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic" id="searchSelectTable">
											<tr>
												<button type="button" class="btn btn-default label" id="addSearch" title="增加一个查询条件"><span class="glyphicon glyphicon-plus " ></span></button>
												<button type="button" class="btn btn-default label minus" id="removeSearch" title="删除最新添加的一个查询条件"><span class="glyphicon glyphicon-minus " ></span></button>

											</tr>
											<tr>
												<td class="td0">
													<input id="checkAll" type="checkbox" />


												</td>
												<td class="td1">全选
												</td>
												<td class="td2">
												</td>
												<td class="td3">

													<button type="button" class="btn btn-default " id="delAll" style="float:right;" title="删除勾选的查询条件"><span class="glyphicon glyphicon-remove " ></span></button>


												</td>
											</tr>
											<tr>
												<td >

													<input name="subBox" type="checkbox" id="box"/>

												</td>
												<td class="td1">

													<div class="dropdown ">

														<button class="btn btn-default dropdown-toggle drop" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" >查询条件<span class="caret"></span></button>
														<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
														</ul>
													</div>
												</td>
												<td  class="td2">
													<div style="display:none;" id="t">
														<select class="bs-docs-example div_1_input comsel" style="width: 50px" name="com" id="com" >
															<option value="max-">&gt;</option>
															<option value="min-">&lt;</option>
															<option value="equ-">=</option>
														</select>
													</div>
												</td>
												<td class="td3"><div><input type="text" size="20" class="inpMain inp" id="input0" /></div></td>
											</tr>
										</table>
									</div>


								</div>
								<div id="div_3_1_3">
									<div style="float:left;">
										<button type="button" id="attrbtn" title="选择显示的属性" class="btn btn-primary " style="height: 2%;"><span class="glyphicon glyphicon-th-list "></span></button></div>
									<div class="btn_right">
										<input type="button" class="btn btn-primary" value="后退" id="div_3_back" />
										<input type="button" class="btn btn-primary" value="导出excel" id="down" />
										<input type="button" class="btn btn-primary" value="查询" id="chaxun" />
									</div>
								</div>
							</div>

						</div>

					</div>
				</div>
			</div>

		</div>
	</div>
	<div class=" result">


		<div id = "bkim" style="margin-top:6%;">

			<div style=" font-size: 40px;">  您查询的表信息将在此展示   </div>
			<img src="app/img/p.png" style="margin-top:20px"/>
		</div>
		<!--Sidebar content-->
		<input type="text" id="jsonInput" class="hide"/>
		<div >
			<div class="btn_right" hidden="hidden" id="qx" >
				<input type="button" class="btn btn-primary" value="隐藏空列" id="nul"  />
				<input type="button" class="btn btn-primary" value="全选" id="all"  />
				<input type="button" class="btn btn-primary" value="全不选" id="non" />

			</div>
			<table  id = "attrlist" hidden="hidden">
			</table>
		</div>
		<div id = "listAll"></div>

		<script src="app/js/Struct/select.js" type="text/javascript"></script>

	</div>
</div>

<div  style="display:none;"><input type='text' id="rehash"/></div>
<div  style="display:none;"><input type='text' id="searchCount" value="2"/></div>
<div  style="display:none;"><input type='text' id="selectArray" /></div>
</body>
<!-- END BODY -->
</html>