$(function(){
    $('#a0').click(function(){
        // $("#all").html("");
     //   $("#all").html("");
        $.ajax({
            url: "printFruits",
            dataType:'json',
            method:'POST',
            success: function(data){
                var jsonObj=eval(data);
                var tab=$("<table border='1'><tr><td>商品id</td><td>类型</td><td>品牌</td><td>名称</td><td>图片</td><td>价格</td><td>净含量</td><td>数量</td><td>产地</td></tr></table>");
                for(var i=0;i<jsonObj.length;i++){
                    var obj=jsonObj[i];
                    var tr=$("<tr><td>"+obj.goodsId+"</td><td>"+obj.type+"</td><td>"+obj.brand+"</td><td>"+obj.goodsName+"</td>td>"+obj.price+"</td><td>"+obj.img+"</td>td>"+obj.netwt+"</td><td>"+obj.quantity+"</td><td>"+obj.origin+"</td></tr>")
                    tab.append(tr);
                }
               // console.log(tab);
                $("#myDiv").append(tab);
                $("#myDiv").show();
            }
        })
    })
})//显示商品信息
$(function(){
    $("#myDiv").hide();
    $("#myDiv3").hide();
    $("#myDiv2").hide();
    $("#myDiv1").hide();
    $('#a0').click(function() {
        $("#myDiv").html("");
        $("#myDiv1").hide();
        $("#myDiv2").hide();
        $("#myDiv3").hide();
        $("#OrderInfoDiv").hide();
        $("#updateOrderInfoDiv").hide();
    })
    $('#a1').click(function() {
        $("#myDiv").html("");
        $("#myDiv").hide();
        $("#myDiv2").hide();
        $("#OrderInfoDiv").hide();
        $("#updateOrderInfoDiv").hide();
        $("#myDiv1").show();
    })
    $('#a2').click(function() {
        $("#myDiv").html("");
        $("#myDiv").hide();
        $("#myDiv1").hide();
        $("#myDiv3").hide();
        $("#OrderInfoDiv").hide();
        $("#updateOrderInfoDiv").hide();
        $("#myDiv2").show();


    })
    $('#a3').click(function() {
        $("#myDiv").html("");
        $("#myDiv").hide();
        $("#myDiv1").hide();
        $("#myDiv2").hide();
        $("#OrderInfoDiv").hide();
        $("#updateOrderInfoDiv").hide();
        $("#myDiv3").show();
    })

})
$(function(){
    $('#add').click(function(){
        var idd= $("#ids").val();
        var type= $("#type").val();
        var brand= $("#brand").val()
        var goodsName= $("#goodsname").val();
        var price= $("#price").val();
        var img= $("#img").val();
        var netwt= $("#netwt").val();
        var quantity= $("#quantity").val();
        var origin= $("#origin").val();
        console.log( quantity)
        var patt1=new RegExp("^\\d+(\\.\\d+)?$");
        patt1.test(price)
        console.log(patt1.test(price));
       // var regex=/[a-zA-Z0-9_]*/;
        if(idd===''||type===''||goodsName===''|brand===''||price===0.0||img===''||netwt===''||quantity===0||origin==='')
        {
            alert("每个都需要填入信息，才可成功增加！")
        }if(!patt1.test(price)){
            alert("你输入的格式错误，只可输入数字！")
        }else{
            console.log(quantity)
            let data = JSON.stringify({
                goodsId: idd,
                type:type,
                brand:brand,
                goodsName:goodsName,
                price: price,
                img: img,
                netwt: netwt,
                quantity: quantity,
                origin: origin,
            })
            $.ajax({
                url: "addFruits",
                contentType: "application/json;charset=utf-8",
                method:'POST',
                data,
                success: function(datas){
                    var stats=eval(datas);
                    if(stats==false){
                        alert("增加商品数据失败,请检查输入的信息或格式是否正确！")
                    }else{
                        alert("增加商品数据成功！")
                    }
                }
            })
        }

    })
})//增加商品信息
$(function(){
    $('#update').click(function(){
        var idd1= $("#id1").val();
        var type1= $("#type1").val();
        var brand1= $("#brand1").val()
        var goodsName1= $("#goodsname1").val();
        var price1= $("#price1").val();
        var img1= $("#img1").val();
        var netwt1= $("#netwt1").val();
        var quantity1= $("#quantity1").val();
        var origin1= $("#origin1").val();
      console.log(quantity1)
        let data = JSON.stringify({
            goodsId: idd1,
            type:type1,
            brand:brand1,
            goodsName:goodsName1,
            price: price1,
            img: img1,
            netwt: netwt1,
            quantity: quantity1,
            origin: origin1,
        })
        $.ajax({
            url: "updateGoods",
            contentType: "application/json;charset=utf-8",
            method:'POST',
            data,
            success: function(){
                    alert("修改数据成功！")

            }
        })
    })
})//修改商品信息
$(function(){
    $('#delete').click(function(){
        var idd3= $("#deleteId").val();
        console.log(idd3);
        $.ajax({
            url: "deleteGoods",
           // contentType: "application/json;charset=utf-8",
            method:'POST',
            data:{goodsId: idd3},
            success: function(){
                alert("删除数据成功！")

            }
        })
    })
})//删除商品信息