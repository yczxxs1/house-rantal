//nav
layui.use('element', function () {
    var element = layui.element;

    //…
});

//form
layui.use('form', function () {
    var form = layui.form;


    //监听提交
    form.on('submit(formDemo)', function (data) {
        //layer.msg(JSON.stringify(data.field));
        var rentInfoData = data.field;
        rentInfoData.rentalInfoUserId = $.cookie('user_id');
        $.ajax({
            url: "/rentalInfo",
            type: "POST",
            data: rentInfoData,
            dataType: "json",
            success: function (msg) {
                if (msg.status == 0) {
                    $(location).attr('href', 'list.html');
                    layer.msg("发布成功");

                } else {
                    layer.msg("发布失败");
                }

            },
            error: function (msg) {
                layer.msg("发布失败");
            }
        });

        return false;
    });
});

//flow
layui.use('flow', function () {
    var flow = layui.flow;

    flow.load({
        elem: '#LAY_demo1' //流加载容器
        , done: function (page, next) { //执行下一页的回调
            var lis = [];
            //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
                //"rentalInfoUserId":null,
            var formData={
                "page":page,
                "bedroomNum": document.getElementById("bedroomNum").value,
                "houseContactIdentity":document.getElementById("houseContactIdentity").value,
                "maxRent":document.getElementById("maxRent").value,
                "minRent":document.getElementById("minRent").value
            };

            $.ajax({
                url: "/rentalInfo/list",
                type: "GET",
                dataType: "json",
                data:formData,
                success: function (res) {
                    layui.each(res.data.list, function (index, item) {
                        lis.push(
                            '<li>' +

                            '<div class="layui-row">' +
                            '<div class="layui-col-xs3">' +
                            '<div class="layui-form-mid"><img class="main-list-img" src="' + item.houseImgs + '" id="demo1">' +
                            '</div>' +
                            '</div>' +
                            '<div class="layui-col-xs9">' +

                            '<div class="layui-form-item" style="margin-bottom: 1px">' +
                            '<div class="layui-inline">' +
                            '<div class="layui-form-mid">' +
                            '<span class="main-title">' + item.houseName + '</span>' +
                            '</div>' +
                            '</div>' +
                            '<div class="main-list-right">' +
                            '<span class="main-money">' + item.houseRent + '元/月</span>' +
                            '</div>' +
                            '</div>' +

                            '<div class="layui-form-item" style="margin-bottom: 1px">' +
                            '<div class="layui-inline">' +
                            '<div class="layui-form-mid">' +
                            '<span>户型:' + item.houseType + '</span>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +

                            '<div class="layui-form-item" style="margin-bottom: 1px">' +
                            '<div class="layui-inline">' +
                            '<div class="layui-form-mid">' +
                            '<span>位置:' + item.houseLocation + '</span>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +

                            '<div class="layui-form-item" style="margin-bottom: 1px">' +
                            '<div class="layui-inline">' +
                            '<div class="layui-form-mid">' +
                            '<span>联系身份:' + item.houseContactIdentity + '</span>' +
                            '</div>' +
                            '</div>' +

                            '<div class="layui-inline" style="float: right">' +
                            '<button class="layui-btn layui-btn-primary layui-btn-xs" id="edit"><i class="layui-icon layui-icon-edit">更新</i>' +
                            '</button>' +
                            '<button class="layui-btn layui-btn-primary layui-btn-xs" id="remove" onclick="remove(this)">' +
                            '<input type="hidden" id="rentalInfoId" value="' + item.rentalInfoId + '">' +
                            '<i class="layui-icon layui-icon-delete">删除</i>' +
                            '</button>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +

                            '</li>'
                        );
                    });

                    //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                    //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                    next(lis.join(''), page < res.data.lastPage);
                }


            })


        }
    });


});

//退出登录
$("#quitFun").on("click", function () {
    $.cookie("user_id", null);
    $(location).attr('href', 'login.html');

});

//我要发布
$("#postRental").on("click", function () {
    if ($.cookie('user_id') != null) {
        $(location).attr('href', 'postRentalInfo.html');
    } else {
        layer.msg("请先登录");
    }


});


function remove(a) {


    var questUrl = "/rentalInfo/" + a.firstElementChild.value + "/remove";
    $.ajax({
        url: questUrl,
        type: "POST",
        dataType: "json",
        success: function (msg) {
            if (msg.status == 0) {
                layer.msg("删除成功");
                a.parentElement.parentElement.parentElement.parentElement.remove();

            } else {
                layer.msg("删除失败");
            }

        },
        error: function (msg) {
            layer.msg("删除失败");
        }
    });


}





