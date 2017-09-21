<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
	<!-- Bootstrap Styles-->
    <link href="/static/assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="/static/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="/static/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- TABLE STYLES-->
    <link href="/static/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body style="background-color: #EDEDED">

<!-- 模态弹出窗内容 -->
<div class="modal" id="mymodal-data" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title">用户添加</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="userName" class="control-label">用户名:</label>
                        <input type="text" class="form-control" id="userName">
                    </div>
                    <div class="form-group">
                        <label for="realName" class="control-label">真实姓名:</label>
                        <input type="text" class="form-control" id="realName">
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label">密码:</label>
                        <input type="text" class="form-control" id="password">
                    </div>
                    <div class="form-group">
                        <label for="password2" class="control-label">再次密码:</label>
                        <input type="text" class="form-control" id="password2">
                    </div>
                    <div class="form-group">
                        <label for="telphone" class="control-label">联系电话:</label>
                        <input type="text" class="form-control" id="telphone">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>

    <div class="header" style="padding-top: 20px;">
        <ol class="breadcrumb">
            <li><a href="#">系统管理</a></li>
            <li class="active">用户管理1</li>
        </ol>
    </div>
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                         系统用户信息表
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive" style="overflow-x:visible">
                            <table  id="userTables" class="table table-bordered table-striped table-hover" style="text-align:center">
                                <thead>
                                    <tr>
                                        <th style="text-align:center"></th>
                                        <th style="text-align:center"></th>
                                        <th style="text-align:center"></th>
                                        <th style="text-align:center"></th>
                                        <th style="text-align:center"></th>
                                        <th style="text-align:center"></th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="/static/assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="/static/assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="/static/assets/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="/static/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="/static/assets/js/dataTables/dataTables.bootstrap.js"></script>
        <script type="text/javascript">
            var lang = {
                "sProcessing": "处理中...",
                "sLengthMenu": "每页 _MENU_ 项",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
                "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页",
                    "sJump": "跳转"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            };
            $(document).ready(function () {

                $("#userTables").DataTable({
//                    "dom": '<"toolbar">frtip',
                    "dom": "<'row'<'col-xs-2'l><'#mytool.col-xs-4'><'col-xs-6'f>r>t" +
                    "<'row'<'col-xs-6'i><'col-xs-6'p>>",
                    serverSide: true,  //启用服务器端分页
                    showRowNumber: true,
                    language:lang,  //提示信息
                    searching: false,//搜索
                    ajax: function (data, callback, settings) {
                        //封装请求参数
                        var param = {};
                        param.limit = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                        param.start = data.start;//开始的记录序号
                        param.page = (data.start / data.length)+1;//当前页码
                        param.orderby=data.orderBys;
                        //ajax请求数据
                        $.ajax({
                            type: "post",
                            url: "/system/users",
                            cache: false,  //禁用缓存
                            data: param,  //传入组装的参数
                            dataType: "json",
                            success: function (result) {
                                //封装返回数据
                                var returnData = {};
                                returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                                returnData.recordsTotal = result.total;//返回数据全部记录
                                returnData.recordsFiltered = result.total;//后台不实现过滤功能，每次查询均视作全部结果
                                returnData.data = result.data;//返回的数据列表
                                callback(returnData);
                            }
                        });
                    },
                    columns: [
                        {
                            target:0,
                            data: "id",
                            title: "用户ID"
                        },
                        {
                            target:1,
                            data: "userName",
                            title: "用户名称"
                        },
                        {
                            target:2,
                            data: "password",
                            title: "用户密码"
                        },
                        {
                            target:3,
                            data: "telphone",
                            title: "用户电话"
                        },
                        {
                            target:5,
                            data: "updateTime",
                            title: "更新时间"
                        },
                        {
                            target:4,
                            data: "createType",
                            title: "创建途径",
                            render:function(data){
                                if(data==0){
                                    return "数据库方式";
                                }else if(data==1){
                                    return "网页方式";
                                }
                                return "其他";
                            }
                        }
                    ],
                    initComplete:function(){
                        $("#mytool").append('<button type="button" class="btn btn-primary delete" data-toggle="modal" ' +
                                'data-whatever="@mdo" data-target="#mymodal-data">添加</button>');
                    }
                });
//                $("div.toolbar").html("<button class='btn btn-primary delete' data-toggle='modal'data-target='#mymodal-data' data-whatever='@mdo'>修改</button>");
            });

    </script>
</body>
</html>
