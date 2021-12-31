$(function(){
	if(error){
		layer.alert(error);
	}
	
	//根据后台的实现选中
	if (sex) {
		$(".staff-form .sex :radio[value=" + sex + "]").prop("checked", true);
	}


	laydate.render({
		elem: "#birthday"
	});
});