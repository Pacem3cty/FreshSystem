$(function() {

    $("#myDiv").html("");
    $("#myDiv").hide();
    $("#myDiv1").hide();
    $("#myDiv2").hide();
    $("#myDiv3").hide();
    $("#updateOrderInfoDiv").hide();
    $("#deleteOrderInfoDiv").hide();
    $("#insertOrderInfoDiv").hide();
    $("#closeorder").hide();
    $("#updateorder").hide();
    $("#cancelupdate").hide();
    $("#submitupdate").hide();


    $('#printorder').click(function () {

        $("#printorder").hide();
        $("#closeorder").show();
        $("#updateorder").show();
        htmlobj = $.ajax({
            url: "printOrder",
            dataType: 'json',
            //data: {userId:"1"}, //请求的附加参数，用json对象
            method: 'POST',
            success: function (data) {
                //$("#StaffInfoDiv").html(htmlobj.responseText);
                var jsonObj = eval(data);
                var tab = $("<table border='1'><td>订单编号</td><td>订单价格</td><td>收货号码</td><td>收货地址</td><td>配送员编号</td><td>是否退单</td></table>");
                for (var i = 0; i < jsonObj.length; i++) {
                    var obj = jsonObj[i];
                    var tr = $("<tr><td>" + obj.orderId + "</td><td>" + obj.orderPrice + "</td><td>" + obj.consignNum + "</td><td>" + obj.consignAddress + "</td><td>" + obj.deliverymanId + "</td><td>" + obj.isReturn + "</td></tr>")
                    tab.append(tr);
                }
                //$('#text').html(data);
                $("#OrderInfoDiv").append(tab);
                $("#OrderInfoDiv").show();
                /* if (data = "") {
                     alert("查找不到数据！")
                 } else {
                     $('#text').empty();
                     $('#text').html(data);
                 }*/
                //  $.messager.alert('消息',data.add,'');
            }
        })
    }), $('#closeorder').click(function () {

        $("#OrderInfoDiv").hide();
        $("#OrderInfoDiv").html("");
        $("#printorder").show();
        $("#closeorder").hide();
        $("#updateorder").hide();


    }), $('#updateorder').click(function () {

        $("#updateOrderInfoDiv").show();
        $("#updateorder").hide();
        $("#submitupdate").show();
        $("#cancelupdate").show();

    }), $('#cancelupdate').click(function () {

        $("#updateOrderInfoDiv").hide();
        $("#updateorder").show();
        $("#submitupdate").hide();
        $("#cancelupdate").hide();

    }), $('#submitupdate').click(function () {

        let orderId = $("input[name=orderId]").val();
        let orderPrice = $("input[name=orderPrice]").val();
        let consignNum = $("input[name=consignNum]").val();
        let consignAddress = $("input[name=consignAddress]").val();
        let deliverymanId = $("input[name=deliverymanId]").val();
        let isReturn = $("select[name=isReturn]").val();

        htmlobj = $.ajax({
            url: "updateOrder",
            dataType: 'json',
            data: {orderId: orderId, orderPrice: orderPrice, consignNum: consignNum, consignAddress: consignAddress,deliverymanId:deliverymanId,isReturn:isReturn}, //请求的附加参数，用json对象
            method: 'POST',
            success: function (data) {
                $("#updateOrderInfoDiv").hide();
                $("#OrderInfoDiv").html("");
                var jsonObj = eval(data);
                var tab = $("<table border='0'><td>订单编号</td><td>订单价格</td><td>收货号码</td><td>收货地址</td><td>配送员编号</td><td>是否退单</td></table>");
                for (var i = 0; i < jsonObj.length; i++) {
                    var obj = jsonObj[i];
                    var tr = $("<tr><td>" + obj.orderId + "</td><td>" + obj.orderPrice + "</td><td>" + obj.consignNum + "</td><td>" + obj.consignAddress + "</td><td>" + obj.deliverymanId + "</td><td>" + obj.isReturn + "</td></tr>")
                    tab.append(tr);
                }
                $("#OrderInfoDiv").append(tab);
                $("#OrderInfoDiv").show();
                $("#updateorder").show();
                $("#submitupdate").hide();
                $("#cancelupdate").hide();
                $("#updateOrderInfoDiv").hide();
            }
        })
    })
})