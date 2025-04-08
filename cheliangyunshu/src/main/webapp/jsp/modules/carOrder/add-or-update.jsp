<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑订单</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">订单管理</li>
                        <li class="breadcrumb-item active">编辑订单</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">订单信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa car">
                                        <label>车辆</label>
                                        <div>
                                            <select id="carSelect" name="carSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 car">
                                        <label>车辆名字</label>
                                        <input id="carName" name="carName" class="form-control"
                                               placeholder="车辆名字" readonly>
                                    </div>
                                    <div class="form-group col-md-6 car">
                                        <label>车辆类型</label>
                                        <input id="carValue" name="carValue" class="form-control"
                                               placeholder="车辆类型" readonly>
                                    </div>
                                    <%--<div class="form-group col-md-6 car">--%>
                                        <%--<label>车辆品牌类型</label>--%>
                                        <%--<input id="carPinpaiValue" name="carPinpaiValue" class="form-control"--%>
                                               <%--placeholder="车辆品牌类型" readonly>--%>
                                    <%--</div>--%>
                                    <div class="form-group col-md-6 car">
                                        <label>车牌号</label>
                                        <input id="carPaiNumber" name="carPaiNumber" class="form-control"
                                               placeholder="车牌号" readonly>
                                    </div>
                                    <%--<div class="form-group col-md-6 car">--%>
                                        <%--<label>车辆照片</label>--%>
                                        <%--<img id="carPhotoImg" src="" width="100" height="100">--%>
                                    <%--</div>--%>
                                    <%--<div class="form-group col-md-6 car">--%>
                                        <%--<label>是否在使用</label>--%>
                                        <%--<input id="carYesnoValue" name="carYesnoValue" class="form-control"--%>
                                               <%--placeholder="是否在使用" readonly>--%>
                                    <%--</div>--%>
                                    <div class="form-group col-md-6 aaaaaa siji">
                                        <label>司机</label>
                                        <div>
                                            <select id="sijiSelect" name="sijiSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 siji">
                                        <label>司机姓名</label>
                                        <input id="sijiName" name="sijiName" class="form-control"
                                               placeholder="司机姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6 siji">
                                        <label>司机手机号</label>
                                        <input id="sijiPhone" name="sijiPhone" class="form-control"
                                               placeholder="司机手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6 siji">
                                        <label>司机身份证号</label>
                                        <input id="sijiIdNumber" name="sijiIdNumber" class="form-control"
                                               placeholder="司机身份证号" readonly>
                                    </div>
                                    <%--<div class="form-group col-md-6 siji">--%>
                                        <%--<label>司机照片</label>--%>
                                        <%--<img id="sijiPhotoImg" src="" width="100" height="100">--%>
                                    <%--</div>--%>
                                    <%--<div class="form-group col-md-6 siji">--%>
                                        <%--<label>司机状态</label>--%>
                                        <%--<input id="sijiYesnoValue" name="sijiYesnoValue" class="form-control"--%>
                                               <%--placeholder="司机状态" readonly>--%>
                                    <%--</div>--%>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>单号</label>
                                        <input id="carDanhaoNumber" name="carDanhaoNumber" class="form-control"
                                               placeholder="单号">
                                    </div>
                                <input id="sijiId" name="sijiId" type="hidden">
                                <input id="carId" name="carId" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>商品名字</label>
                                        <input id="shangpinName" name="shangpinName" class="form-control"
                                               placeholder="商品名字">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>商品数量</label>
                                        <input id="shangpinNumber" name="shangpinNumber" class="form-control"
                                               onchange="shangpinNumberChickValue(this)"  placeholder="商品数量">
                                    </div>

                                    <div class="form-group col-md-6">
                                        <label>运输价格</label>
                                        <input id="yunshuMoney" name="yunshuMoney" class="form-control"
                                               onchange="yunshuMoneyChickValue(this)" placeholder="运输价格">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>出行时间</label>
                                        <input id="chuxingTime-input" name="chuxingTime" type="text" class="form-control layui-input">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>订单状态</label>
                                        <select id="carOrderYesnoTypesSelect" name="carOrderYesnoTypes" class="form-control">
                                        </select>
                                    </div>
                                    <div class="form-group col-md-12 mb-3">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "carOrder";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var carOrderYesnoTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var carOptions = [];
    var sijiOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '司机'){//当前登录用户不为这个
                if($("#sijiId") !=null){
                    var sijiId = $("#sijiId").val();
                    if(sijiId == null || sijiId =='' || sijiId == 'null'){
                        alert("司机不能为空");
                        return;
                    }
                }
            }
            if(window.sessionStorage.getItem('role') != '车辆'){//当前登录用户不为这个
                if($("#carId") !=null){
                    var carId = $("#carId").val();
                    if(carId == null || carId =='' || carId == 'null'){
                        alert("车辆不能为空");
                        return;
                    }
                }
            }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';

            }
            httpJson("carOrder/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addcarOrder');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function carOrderYesnoTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=car_order_yesno_types", "GET", {}, (res) => {
                if(res.code == 0){
                    carOrderYesnoTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function carSelect() {
            //填充下拉框选项
            http("car/page?page=1&limit=100&sort=&order=&carYesnoTypes=1", "GET", {}, (res) => {
                if(res.code == 0){
                    carOptions = res.data.list;
                }
            });
        }

        function carSelectOne(id) {
            http("car/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                carShowImg();
                carShowVideo();
                carDataBind();
            }
        });
        }
        function sijiSelect() {
            //填充下拉框选项
            http("siji/page?page=1&limit=100&sort=&order=&sijiYesnoTypes=1", "GET", {}, (res) => {
                if(res.code == 0){
                    sijiOptions = res.data.list;
                }
            });
        }

        function sijiSelectOne(id) {
            http("siji/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                sijiShowImg();
                sijiShowVideo();
                sijiDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationCarorderyesnotypesSelect(){
            var carOrderYesnoTypesSelect = document.getElementById('carOrderYesnoTypesSelect');
            if(carOrderYesnoTypesSelect != null && carOrderYesnoTypesOptions != null  && carOrderYesnoTypesOptions.length > 0 ){
                for (var i = 0; i < carOrderYesnoTypesOptions.length; i++) {
                    carOrderYesnoTypesSelect.add(new Option(carOrderYesnoTypesOptions[i].indexName,carOrderYesnoTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationcarSelect() {
            var carSelect = document.getElementById('carSelect');
            if(carSelect != null && carOptions != null  && carOptions.length > 0 ) {
                for (var i = 0; i < carOptions.length; i++) {
                        carSelect.add(new Option(carOptions[i].carName, carOptions[i].id));
                }

                $("#carSelect").change(function(e) {
                        carSelectOne(e.target.value);
                });
            }

        }

        function initializationsijiSelect() {
            var sijiSelect = document.getElementById('sijiSelect');
            if(sijiSelect != null && sijiOptions != null  && sijiOptions.length > 0 ) {
                for (var i = 0; i < sijiOptions.length; i++) {
                        sijiSelect.add(new Option(sijiOptions[i].sijiName, sijiOptions[i].id));
                }

                $("#sijiSelect").change(function(e) {
                        sijiSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var carOrderYesnoTypesSelect = document.getElementById("carOrderYesnoTypesSelect");
        if(carOrderYesnoTypesSelect != null && carOrderYesnoTypesOptions != null  && carOrderYesnoTypesOptions.length > 0 ) {
            for (var i = 0; i < carOrderYesnoTypesOptions.length; i++) {
                if (carOrderYesnoTypesOptions[i].codeIndex == ruleForm.carOrderYesnoTypes) {//下拉框value对比,如果一致就赋值汉字
                        carOrderYesnoTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var carSelect = document.getElementById("carSelect");
            if(carSelect != null && carOptions != null  && carOptions.length > 0 ) {
                for (var i = 0; i < carOptions.length; i++) {
                    if (carOptions[i].id == ruleForm.carId) {//下拉框value对比,如果一致就赋值汉字
                        carSelect.options[i+1].selected = true;
                        $("#carSelect" ).selectpicker('refresh');
                    }
                }
            }
            var sijiSelect = document.getElementById("sijiSelect");
            if(sijiSelect != null && sijiOptions != null  && sijiOptions.length > 0 ) {
                for (var i = 0; i < sijiOptions.length; i++) {
                    if (sijiOptions[i].id == ruleForm.sijiId) {//下拉框value对比,如果一致就赋值汉字
                        sijiSelect.options[i+1].selected = true;
                        $("#sijiSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function shangpinNumberChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9][0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }
        function yunshuMoneyChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[0-9]{0,6}(\.[0-9]{1,2})?$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("只允许输入整数6位,小数2位的数字");
                return false;
            }
        }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addcarOrder');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                carDanhaoNumber: "required",
                sijiId: "required",
                carId: "required",
                shangpinName: "required",
                shangpinNumber: "required",
                yunshuMoney: "required",
                chuxingTime: "required",
                carOrderYesnoTypes: "required",
                insertTime: "required",
            },
            messages: {
                carDanhaoNumber: "单号不能为空",
                sijiId: "司机不能为空",
                carId: "车辆不能为空",
                shangpinName: "商品名字不能为空",
                shangpinNumber: "商品数量不能为空",
                yunshuMoney: "运输价格不能为空",
                chuxingTime: "出行时间不能为空",
                carOrderYesnoTypes: "订单状态不能为空",
                insertTime: "添加时间不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addcarOrder = window.sessionStorage.getItem("addcarOrder");
        if (addcarOrder != null && addcarOrder != "" && addcarOrder != "null") {
            //注册表单验证
            $(validform());

            $("#carDanhaoNumber").val(new Date().getTime()+Math.floor(Math.random()*10+1));
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("carOrder/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
            laydate.render({
                elem: '#chuxingTime-input'
                ,type: 'datetime'
            });
            laydate.render({
                elem: '#insertTime-input'
                ,type: 'datetime'
            });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        carDataBind();
        sijiDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#carDanhaoNumber").val(ruleForm.carDanhaoNumber);
        $("#sijiId").val(ruleForm.sijiId);
        $("#carId").val(ruleForm.carId);
        $("#shangpinName").val(ruleForm.shangpinName);
        $("#shangpinNumber").val(ruleForm.shangpinNumber);
        $("#yunshuMoney").val(ruleForm.yunshuMoney);
        $("#chuxingTime-input").val(ruleForm.chuxingTime);
        $("#insertTime-input").val(ruleForm.insertTime);

    }
    <!--  级联表的数据回显  -->
    function carDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#carId").val(ruleForm.id);

        $("#carName").val(ruleForm.carName);
        $("#carValue").val(ruleForm.carValue);
        $("#carPinpaiValue").val(ruleForm.carPinpaiValue);
        $("#carPaiNumber").val(ruleForm.carPaiNumber);
        $("#carYesnoValue").val(ruleForm.carYesnoValue);
    }

    function sijiDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#sijiId").val(ruleForm.id);

        $("#sijiName").val(ruleForm.sijiName);
        $("#sijiPhone").val(ruleForm.sijiPhone);
        $("#sijiIdNumber").val(ruleForm.sijiIdNumber);
        $("#sijiYesnoValue").val(ruleForm.sijiYesnoValue);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        carShowImg();
        sijiShowImg();
    }


    <!--  级联表的图片  -->

    function carShowImg() {
        $("#carPhotoImg").attr("src",ruleForm.carPhoto);
    }


    function sijiShowImg() {
        $("#sijiPhotoImg").attr("src",ruleForm.sijiPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        carShowVideo();
        sijiShowVideo();
    }


    <!--  级联表的视频  -->

    function carShowVideo() {
        $("#carPhotoV").attr("src",ruleForm.carPhoto);
    }

    function sijiShowVideo() {
        $("#sijiPhotoV").attr("src",ruleForm.sijiPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            carOrderYesnoTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            carSelect();
            sijiSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationCarorderyesnotypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationcarSelect();
            initializationsijiSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('addcarOrder');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events: none;');
        }
		else if (window.sessionStorage.getItem('role') == '司机') {
            // $(".aaaaaa").remove();
            $(".siji").remove();//删除当前用户的信息
            // 运输价格设置不可选
            $('#yunshuMoney').attr('readonly', 'readonly');
        }
        else{
            // alert("未知情况.......");
            // var replyContentUeditor = UE.getEditor('replyContentEditor');
            // replyContentUeditor.ready(function () {
            //     replyContentUeditor.setDisabled('fullscreen');
            // });
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>