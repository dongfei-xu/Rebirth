<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<title>saturn</title>
</head>
<body>
这是一个跳转页面测试。
<button type="button" id="button" style="height: 40px;width: 60px;background: green;">跳转</button>

<script type="text/javascript" src="../js/Jquery.js"></script>
<script>
    $(document).ready( function (){
        $("#button").click(function () {
            $.ajax({
                type: "GET",
                url: "http://127.0.0.1:8083/test/str",
                data: {},
                dataType: "jsonp",
                success: function(data){
                    console.log(data);
                },
                error: function (data){
                    console.log(data);
                }
            });
        });

//        function imgToBase64(file){
//            if(typeof FileReader == "undefined"){
//                alert("您的浏览器不支持FileReader对象！");
//            }
//            var reader = new FileReader();
//            var AllowImgFileSize = 210000;
//            var imgUrlBase64;
//            imgUrlBase64 = reader.readAsDataURL(file);
//            if(file) {
//                reader.onload = function (e) {
//                    if(AllowImgFileSize != 0 && AllowImgFileSize < reader.result.length){
//                        console.log("上传失败，请上传不大于200KB的图片！");
//                        alert( '上传失败，请上传不大于200KB的图片！');
//                        return;
//                    } else {
//                        console.log('图片转base64成功！');
//                        return reader.result;
//                    }
//                }
//            }
//        }
    });
</script>
</body>
</html>