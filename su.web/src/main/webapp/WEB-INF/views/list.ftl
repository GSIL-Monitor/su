<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试页</title>
    <#--<script src="${base}/js/jquery.min.js"-->
</head>
<body>
<form>
    <input type = 'text' id="test" required="required" />
    <input type="file" />
    <input type="button" onclick="test()"> 提交</input>
</form>

</body>
<script type="text/javascript">

    function test(){
        var testvalue = document.getElementById('test').value;
        var testValue = $('#test').val();
        window.location.href=encodeURI(${base}+"/su/check.html?data="+testvalue);
    }


</script>
</html>