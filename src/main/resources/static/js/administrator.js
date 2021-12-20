$(function() {

    $("#updateStaffInfoDiv").hide();
    $("#deleteStaffInfoDiv").hide();
    $("#insertStaffInfoDiv").hide();
    $("#closestaff").hide();
    $("#insertstaff").hide();
    $("#updatestaff").hide();
    $("#cancelupdate").hide();
    $("#submitupdate").hide();
    $("#deletestaff").hide();

    $('#printstaff').click(function () {

        $("#printstaff").hide();
        $("#closestaff").show();
        $("#updatestaff").show();
        $("#insertstaff").show();
        $("#deletestaff").show();
        htmlobj = $.ajax({
            url: "printAllStaff",
            dataType: 'json',
            //data: {userId:"1"}, //请求的附加参数，用json对象
            method: 'POST',
            success: function (data) {
                //$("#StaffInfoDiv").html(htmlobj.responseText);
                var jsonObj = eval(data);
                var tab = $("<table border='1'><tr><td>员工工号</td><td>员工姓名</td><td>登录密码</td><td>员工权限</td></tr></table>");
                for (var i = 0; i < jsonObj.length; i++) {
                    var obj = jsonObj[i];
                    var tr = $("<tr><td>" + obj.staffId + "</td><td>" + obj.staffName + "</td><td>" + obj.password + "</td><td>" + obj.permission + "</td></tr>")
                    tab.append(tr);
                }
                //$('#text').html(data);
                $("#StaffInfoDiv").append(tab);
                $("#StaffInfoDiv").show();
                /* if (data = "") {
                     alert("查找不到数据！")
                 } else {
                     $('#text').empty();
                     $('#text').html(data);
                 }*/
                //  $.messager.alert('消息',data.add,'');
            }
        })
    }), $('#closestaff').click(function () {

        $("#StaffInfoDiv").hide();
        $("#StaffInfoDiv").html("");
        $("#printstaff").show();
        $("#closestaff").hide();
        $("#insertstaff").hide();
        $("#updatestaff").hide();
        $("#deletestaff").hide();

    }), $('#updatestaff').click(function () {

        $("#updateStaffInfoDiv").show();
        $("#updatestaff").hide();
        $("#submitupdate").show();
        $("#cancelupdate").show();

    }), $('#cancelupdate').click(function () {

        $("#updateStaffInfoDiv").hide();
        $("#updatestaff").show();
        $("#submitupdate").hide();
        $("#cancelupdate").hide();

    }), $('#submitupdate').click(function () {

        let staffId = $("input[name=staffId]").val();
        let staffName = $("input[name=staffName]").val();
        let password = $("input[name=password]").val();
        let permission = $("select[name=permission]").val();

        htmlobj = $.ajax({
            url: "updateStaff",
            dataType: 'json',
            data: {staffId: staffId, staffName: staffName, password: password, permission: permission}, //请求的附加参数，用json对象
            method: 'POST',
            success: function (data) {
                $("#updateStaffInfoDiv").hide();
                $("#StaffInfoDiv").html("");
                var jsonObj = eval(data);
                var tab = $("<table border='1'><tr><td>员工工号</td><td>员工姓名</td><td>登录密码</td><td>员工权限</td></tr></table>");
                for (var i = 0; i < jsonObj.length; i++) {
                    var obj = jsonObj[i];
                    var tr = $("<tr><td>" + obj.staffId + "</td><td>" + obj.staffName + "</td><td>" + obj.password + "</td><td>" + obj.permission + "</td></tr>")
                    tab.append(tr);
                }
                $("#StaffInfoDiv").append(tab);
                $("#StaffInfoDiv").show();
                $("#updatestaff").show();
                $("#submitupdate").hide();
                $("#cancelupdate").hide();
                $("#updateStaffInfoDiv").hide();
            }
        })
    }), $('#insertstaff').click(function () {
        $("#insertStaffInfoDiv").show();
        $("#insertstaff").hide();
        $("#submitinsert").show();
        $("#cancelinsert").show();

    }), $('#cancelinsert').click(function () {

        $("#insertStaffInfoDiv").hide();
        $("#insertstaff").show();
        $("#submitinsert").hide();
        $("#cancelinsert").hide();

    }), $('#submitinsert').click(function () {

        let staffId = $("input[name=staffId0]").val();
        let staffName = $("input[name=staffName0]").val();
        let password = $("input[name=password0]").val();
        let permission = $("select[name=permission]").val();

        htmlobj = $.ajax({
            url: "insertStaff",
            dataType: 'json',
            data: {staffId: staffId, staffName: staffName, password: password, permission: permission}, //请求的附加参数，用json对象
            method: 'POST',
            success: function (data) {
                $("#updateStaffInfoDiv").hide();
                $("#StaffInfoDiv").html("");
                var jsonObj = eval(data);
                var tab = $("<table border='1'><tr><td>员工工号</td><td>员工姓名</td><td>登录密码</td><td>员工权限</td></tr></table>");
                for (var i = 0; i < jsonObj.length; i++) {
                    var obj = jsonObj[i];
                    var tr = $("<tr><td>" + obj.staffId + "</td><td>" + obj.staffName + "</td><td>" + obj.password + "</td><td>" + obj.permission + "</td></tr>")
                    tab.append(tr);
                }
                $("#StaffInfoDiv").append(tab);
                $("#StaffInfoDiv").show();
                $("#insertstaff").show();
                $("#submitinsert").hide();
                $("#cancelinsert").hide();
                $("#insertStaffInfoDiv").hide();
            }
        })
    }), $('#deletestaff').click(function () {
        $("#deleteStaffInfoDiv").show();
        $("#deletestaff").hide();
        $("#submitdelete").show();
        $("#canceldelete").show();

    }), $('#canceldelete').click(function () {

        $("#deleteStaffInfoDiv").hide();
        $("#deletestaff").show();
        $("#submitdelete").hide();
        $("#canceldelete").hide();

    }), $('#submitdelete').click(function () {

        let staffId = $("input[name=staffId1]").val();

        htmlobj = $.ajax({
            url: "deleteStaff",
            dataType: 'json',
            data: {staffId: staffId}, //请求的附加参数，用json对象
            method: 'POST',
            success: function (data) {
                $("#updateStaffInfoDiv").hide();
                $("#StaffInfoDiv").html("");
                var jsonObj = eval(data);
                var tab = $("<table border='1'><tr><td>员工工号</td><td>员工姓名</td><td>登录密码</td><td>员工权限</td></tr></table>");
                for (var i = 0; i < jsonObj.length; i++) {
                    var obj = jsonObj[i];
                    var tr = $("<tr><td>" + obj.staffId + "</td><td>" + obj.staffName + "</td><td>" + obj.password + "</td><td>" + obj.permission + "</td></tr>")
                    tab.append(tr);
                }
                $("#StaffInfoDiv").append(tab);
                $("#StaffInfoDiv").show();
                $("#deletestaff").show();
                $("#submitdelete").hide();
                $("#canceldelete").hide();
                $("#deleteStaffInfoDiv").hide();
            }
        })
    })
})