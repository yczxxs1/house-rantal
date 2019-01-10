
(function ($) {
    "use strict";

    /*==================================================================
    [ Focus Contact2 ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })

    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');
    $('#login-button').on('click',function(){


        $.post("/user/login",
            {"userName":input[0].value,
                "password":input[1].value,

            },
            function(result){
                if (result.status==0) {
                    //跳转页面
                    $(location).attr('href', 'list.html');
                    $.cookie('user_id', result.data.userId);
                }else{
                    alert(result.data);
                }

            });

    });

    $('#register-button').on('click',function(){
        if (input[1].value!=input[2].value){
            alert("两次密码不一致!");
            return;
        }

        $.post("/user/register",
            {"userName":input[0].value,
                "password":input[1].value,
            },
            function(result){

                if (result.status==0) {
                    //跳转页面
                    $(location).attr('href', 'login.html');
                }else{
                    alert(result.data);
                }
            });

    });
    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    

})(jQuery);