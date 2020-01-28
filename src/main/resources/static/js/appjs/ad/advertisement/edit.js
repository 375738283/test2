$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/ad/advertisement/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true,
				maxlength:32
			},
			price:{ 
				required : true,
				number:true,
				min:0.1,
				max:100
			},
			downloadUrl:{
				maxlength:128
			},
			pictureUrl:{
				maxlength:128
			},
			linkUrl:{
				maxlength:128
			},
			remarks:{
				maxlength:128
			}
		},
		messages : {
			name : {
				required : icon + "请输入名称",
				maxlength:icon + "名称长度不能超过32位"
			},
			price:{
				required:icon + "请输入单价",
				number:"请输入正确的金额"
			},
			downloadUrl:{
				maxlength: icon + "下载地址长度不能超过128位"
			},
			pictureUrl:{
				maxlength: icon + "图片地址不能超过128位"
			},
			linkUrl:{
				maxlength: icon + "链接地址长度不能超过128位"
			},
			remarks:{
				maxlength: icon + "备注长度不能超过128位"
			}
		}
	})
}