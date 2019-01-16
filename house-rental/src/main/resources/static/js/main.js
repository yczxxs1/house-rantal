var imgPreview = "http://127.0.0.1";
//nav
layui.use('element', function () {
    var element = layui.element;

    //…
});


function handleHouseImg(rentInfoData){
    var x=document.getElementsByName("houseImg");
    for (var i = 0; i < x.length; i++) {
        rentInfoData.houseImgs=rentInfoData.houseImgs+x[i].alt+";";
    }
    rentInfoData.houseImgs=rentInfoData.houseImgs.substring(0,rentInfoData.houseImgs.length-1);
}

//form
layui.use('form', function () {
    var form = layui.form;


    //监听提交
    //发布
    form.on('submit(rentalCreate)', function (data) {
        //layer.msg(JSON.stringify(data.field));
        var rentInfoData = data.field;
        rentInfoData.rentalInfoUserId = $.cookie('user_id');
        handleHouseImg(rentInfoData);
        $.ajax({
            url: "/rentalInfo",
            type: "POST",
            data: rentInfoData,
            dataType: "json",
            success: function (msg) {
                if (msg.status === 0) {
                    layer.alert('发布成功!', {closeBtn: 0}, function (index) {
                        $(location).attr('href', 'list.html');
                        layer.close(index);
                    });

                } else {
                    layer.msg("发布失败！");
                }

            },
            error: function (msg) {
                layer.msg("发布失败！");
            }
        });

        return false;
    });


    //更新
    form.on('submit(rentalEdit)', function (data) {
        var rentInfoData = data.field;
        var rentalId = $("#editRentalId").val();
        handleHouseImg(rentInfoData);
        if (rentalId !== undefined && rentalId !== null && rentalId !== "") {
            $.ajax({
                url: "/rentalInfo/" + rentalId + "/edit",
                type: "POST",
                data: rentInfoData,
                dataType: "json",
                success: function (msg) {
                    if (msg.status === 0) {
                        layer.alert('更新成功!', {closeBtn: 0}, function (index) {
                            $(location).attr('href', 'list.html?userId=' + $.cookie('user_id'));
                            layer.close(index);
                        });

                    } else {
                        layer.msg("更新失败！");
                    }

                },
                error: function (msg) {
                    layer.msg("更新失败！");
                }
            });

        }
        return false;
    });


});


layui.use('upload', function () {

    var upload = layui.upload;

    var uploadIns=upload.render({
        elem: '#test2'
        , url: '/upload/img'
        , accept: 'images' //允许上传的文件类型
        , size: 5000 //最大允许上传的文件大小
        , auto: true
        , multiple: true
        , number: 5
        , choose: function (obj) {
            //一般用于非自动上传
            //将每次选择的文件追加到文件队列
            //var files = obj.pushFile();
        }
        , before: function (obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            layer.load(); //上传loading
            //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
            obj.preview(function (index, file, result) {
                //这里还可以做一些 append 文件列表 DOM 的操作
                //obj.upload(index, file); //对上传失败的单个文件重新上传，一般在某个事件中使用
                //delete files[index]; //删除列表中对应的文件，一般在某个事件中使用
            });
        }
        , done: function (res, index, upload) {
            //var imgUrls = $('#houseImgs').val();
            //$('#houseImgs').val(imgUrls + res.data + ';');

            var imgElement = $(['<span class="img-preview">'
                , '<img name="houseImg" src="' + imgPreview+res.data + '" alt="' + res.data + '" class="layui-upload-img">'
                , '<i class="layui-icon layui-icon-delete img-remove"></i>'
                , '</span>'].join(''));
            imgElement.find('.img-remove').on('click', function () {
                imgElement.remove();
                uploadIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
            });
            $('#demo2').append(imgElement);
            layer.closeAll('loading'); //关闭loading
        }
        , error: function (index, upload) {
            layer.closeAll('loading'); //关闭loading
        }
        //,……

    });


});


//flow
layui.use('flow', function () {
    var flow = layui.flow;

    var pullDate = function (options) {
        $.extend({}, {
            "page": 1
        });
        $('.layadmin-tabsbody-item').off('scroll');
        flow.load({
            elem: '#LAY_demo1' //流加载容器
            , done: function (page, next) { //执行下一页的回调
                var lis = [];
                var formData = {
                    "page": page,
                    "bedroomNum": document.getElementById("bedroomNum").value,
                    "houseContactIdentity": document.getElementById("houseContactIdentity").value,
                    "maxRent": document.getElementById("maxRent").value,
                    "minRent": document.getElementById("minRent").value,
                    "rentalInfoUserId": options
                };
                $.ajax({
                    url: "/rentalInfo/list",
                    type: "GET",
                    dataType: "json",
                    data: formData,
                    success: function (res) {
                        layui.each(res.data.list, function (index, item) {
                            lis.push(
                                '<li>' +

                                '<div class="layui-row">' +
                                '<div class="layui-col-xs3">' +
                                '<div class="layui-form-mid"><img class="main-list-img" src="' + imgPreview + item.houseImgs.split(";")[0] + '" id="demo1">' +
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
                                '<span>联系人身份:' + item.houseContactIdentity + '</span>' +
                                '</div>' +
                                '</div>' +

                                '<div class="layui-inline myEditOrRemove" style="float: right;display: none">' +
                                '<button class="layui-btn layui-btn-primary layui-btn-xs" id="edit" onclick="edit(this)">' +
                                '<input type="hidden" id="rentalInfoId" value="' + item.rentalInfoId + '">' +
                                '<i class="layui-icon layui-icon-edit">更新</i>' +
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
                    },
                    complete: function () {

                        if (options !== undefined && options !== null && options !== "") {
                            $(".myEditOrRemove").show();
                        }

                    }
                })
            }
        });
    };


    //初始加载
    //pullDate();
    var userId = getUrlParam().userId;
    if (userId !== undefined && userId !== null && userId !== "") {
        pullDate($.cookie('user_id'));
    } else {
        pullDate();
    }


    //条件查询
    $("#queryByCondition").on("click", function () {
        $("#LAY_demo1").html("");
        pullDate();

    });

    //我的
    $("#myPost").on("click", function () {
        $("#LAY_demo1").html("");
        var userId = $.cookie('user_id');
        if (userId != null) {
            pullDate(userId);
        } else {
            layer.msg("请先登录!");
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
        $(location).attr('href', 'rentalInfo.html');
    } else {
        layer.msg("请先登录");
    }


});


//返回我的页面
$("#backMyList").on("click", function () {

    $(location).attr('href', 'list.html?userId=' + $.cookie('user_id'));

});


//删除
function remove(a) {


    layer.confirm('确认删除?', function (index) {
        //do something
        var questUrl = "/rentalInfo/" + a.firstElementChild.value + "/remove";
        $.ajax({
            url: questUrl,
            type: "POST",
            dataType: "json",
            success: function (msg) {
                if (msg.status === 0) {

                    layer.msg("删除成功！");
                    a.parentElement.parentElement.parentElement.parentElement.remove();

                } else {
                    layer.msg("删除失败！");
                }

            },
            error: function (msg) {
                layer.msg("删除失败！");
            }
        });
        layer.close(index);
    });

}


function edit(a) {

    var rentalId = a.firstElementChild.value;
    $(location).attr('href', 'rentalInfo.html?editRentalId=' + rentalId);

}


function getUrlParam() {
    var url = location.search; //获取url中"?"符后的字串
    var params = {};
    if (url.indexOf("?") !== -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            params[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return params;
}

function renderForm() {
    layui.use('form', function () {
        var form = layui.form; //高版本建议把括号去掉，有的低版本，需要加()
        form.render();
    });
}









