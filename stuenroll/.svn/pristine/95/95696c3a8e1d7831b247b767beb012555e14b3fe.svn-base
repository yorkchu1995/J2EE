$(function() {

	// 接口与实现
	I_RecordDetail = function() {
	}

	/**
	 * 初始化抽象方法
	 * 
	 * @param {Object}
	 *            json
	 * @param {Object}
	 *            bool
	 */
	I_RecordDetail.prototype.init = function(json, bool) {
		throw "抽象方法";
	}

	/**
	 * 加载学生信息抽象方法
	 * 
	 * @param {Object}
	 *            json
	 */
	I_RecordDetail.loadStudentInfo = function(json) {
		throw "抽象方法";
	}

	/**
	 * 加载学生头像抽象方法
	 * 
	 * @param {Object}
	 *            json
	 */
	I_RecordDetail.loadStudentImg = function(json) {
		throw "抽象方法";
	}

	/**
	 * 加载回访详细信息抽象方法
	 * 
	 * @param {Object}
	 *            json
	 */
	I_RecordDetail.prototype.loadRecordDetails = function(json) {
		throw "抽象方法";
	}

	/**
	 * 加载录音文件
	 * 
	 * @param {Object}
	 *            json
	 */
	I_RecordDetail.prototype.loadRecord = function(json) {
		throw "抽象方法";
	}

	/**
	 * 加载学生出勤信息并绘制出勤/请假环形图以及月历
	 * 
	 * @param {Object}
	 *            json
	 */
	I_RecordDetail.prototype.loadStudentAttendance = function(json) {
		throw "抽象方法";
	}

	/**
	 * 保存回访信息抽象方法
	 * 
	 * @param {Object}
	 *            json
	 */
	I_RecordDetail.prototype.saveInfo = function(json) {
		throw "抽象方法";
	}

	/** ****************************实现************************************ */
	var RecordDetail = function() {
	}
	RecordDetail.prototype = new I_RecordDetail();

	/**
	 * 初始化抽象方法
	 * 
	 * @param {Object}
	 *            json
	 * @param {Object}
	 *            bool
	 */
	RecordDetail.prototype.init = function(json, bool) {
		this.loadStudentInfo(json);
		this.loadStudentImg(json);
		this.loadStudentAttendance(json);
		this.loadStudentScore(json);
		if (bool) {
			this.loadRecordDetails(json);
			this.loadRecord(json);
		}
	}

	/**
	 * 加载学生信息抽象方法
	 * 
	 * @param {Object}
	 *            json
	 */
	RecordDetail.prototype.loadStudentInfo = function(json) {
		var details = $(".main-container .review-container .info-container[data-index='studentInfo'] .student .details");
		details.find("input[name='name']").val(sessionStorage.studentName);
		details.find("input[data-sex='" + sessionStorage.studentSex + "']").attr("checked", "checked");
		details.find("input[name='year']").val(sessionStorage.studentBrthYear);
		details.find("input[name='month']").val(sessionStorage.studentBrthMonth);
		details.find("input[name='day']").val(sessionStorage.studentBrthDay);
		details.find("input[name='pid']").val(sessionStorage.studentPid);
		details.find("input[name='email']").val(sessionStorage.studentEmail);
		details.find("input[name='tel']").val(sessionStorage.studentTel);
		details.find("input[name='residentAddress']").val(sessionStorage.studentResidentAddress);
		details.find("input[name='homeAddress']").val(sessionStorage.studentHomeAddress);
		details.find("input[name='permanentAddress']").val(sessionStorage.studentPermanentAddress);
		details.find("input[name='graduateSchool']").val(sessionStorage.studentGraduateSchool);
		details.find("input[name='major']").val(sessionStorage.studentMajor);
		var student = $(".main-container .charts-container .phone-container .student");
		student.find(".info span[name='name']").text(sessionStorage.studentName);
		student.find(".info span[name='sex']").text(sessionStorage.studentSex);
		var year = new Number(sessionStorage.studentBrthYear);
		year = new Number(new Date().getFullYear() - year + 1);
		student.find(".info span[name='age']").text(year);
		student.find(".tel span").text(sessionStorage.studentTel);
	}

	/**
	 * 加载学生头像抽象方法
	 * 
	 * @param {Object}
	 *            json
	 */
	RecordDetail.prototype.loadStudentImg = function(json) {
		$.ajax({
			"url" : "/stuenroll/reviewDetails/searchStudentImage",
			"type" : "post",
			"dataType" : "json",
			"data" : json,
			"success" : function(json) {
				var student = $(".main-container .charts-container .phone-container .student");
				if (json == null) {
					student.find(".photo img").attr("src", "../../../img/5.png");
				}
				else {
					student.find(".photo img").attr("src", "http://127.0.0.1/stuenroll/img/searchImage?id=" + json.result);
				}

			},
			"error" : function() {
				toastr.error("系统异常");
			}
		});
	}

	/**
	 * 加载回访详细信息方法
	 * 
	 * @param {Object}
	 *            json
	 */
	RecordDetail.prototype.loadRecordDetails = function(json) {
		$.ajax({
			"url" : "/stuenroll/reviewDetails/searchReviewDetails",
			"type" : "post",
			"dataType" : "json",
			"data" : json,
			"success" : function(json) {
				var data = json.result;
				var details = $(".main-container .review-container .info-container[data-index='reviewInfo'] .questions");
				var answer = details.find("answer");
				$(answer[0]).find("input[name='" + data.student_info + "']").attr("checked", "checked");
				$(answer[1]).find("input[name='" + data.conversion_trianing + "']").attr("checked", "checked");
				$(answer[2]).find("input[name='" + data.conversion_organization + "']").attr("checked", "checked");
				$(answer[3]).find("input[name='" + data.conversion_teaching + "']").attr("checked", "checked");
				$(answer[4]).find("input[name='" + data.daliy_management + "']").attr("checked", "checked");
				$(answer[5]).find("input[name='" + data.profession_setting + "']").attr("checked", "checked");
				$(answer[6]).find("input[name='" + data.learning_cycle + "']").attr("checked", "checked");
				$(answer[7]).find("textarea[name='changes']").text(data.organization_changes);
				$(answer[8]).find("input[name='" + data.employed + "']").attr("checked", "checked");
				$(answer[9]).find("input[name='" + data.company_size + "']").attr("checked", "checked");
				$(answer[10]).find("input[name='" + data.company_nature + "']").attr("checked", "checked");
				$(answer[11]).find("input[name='" + data.salary_level + "']").attr("checked", "checked");
				$(answer[12]).find("input[name='" + data.profession_counterparts + "']").attr("checked", "checked");
				$(answer[13]).find("input[name='" + data.job_satisfaction + "']").attr("checked", "checked");
				$(answer[14]).find("input[name='" + data.employed_way + "']").attr("checked", "checked");
				$(answer[15]).find("input[name='" + data.employed_satisfaction + "']").attr("checked", "checked");
				$(answer[16]).find("textarea[name='jobAdvice']").text(data.job_advice);
			},
			"error" : function() {
				toastr.error("系统异常");
			}
		});
	}

	/**
	 * 加载录音文件
	 * 
	 * @param {Object}
	 *            json
	 */
	RecordDetail.prototype.loadRecord = function(json) {
		$.ajax({
			"url" : "",
			"type" : "post",
			"dataType" : "json",
			"data" : json,
			"success" : function(json) {
				
			},
			"error" : function() {
				toastr.error("系统异常");
			}
		});
	}

	/**
	 * 加载学生出勤信息并绘制出勤/请假环形图以及月历
	 * 
	 * @param {Object}
	 *            json
	 */
	RecordDetail.prototype.loadStudentAttendance = function(json) {
		$.ajax({
			"url" : "/stuenroll/reviewDetails/searchStudentAttendence",
			"type" : "post",
			"dataType" : "json",
			"data" : json,
			"success" : function(json) {
				
			},
			"error" : function() {
				toastr.error("系统异常");
			}
		});
	}

	/**
	 * 加载学生考试成绩数据并绘制考试成绩折线图和考试成绩列表
	 * 
	 * @param {Object}
	 *            json
	 */
	RecordDetail.prototype.loadStudentScore = function(json) {
		$.ajax({
			"url" : "/stuenroll/reviewDetails/searchStudentScore",
			"type" : "post",
			"dataType" : "json",
			"data" : json,
			"success" : function(json) {

			},
			"error" : function() {
				toastr.error("系统异常");
			}
		});
	}

	/**
	 * 保存回访信息
	 * 
	 * @param {Object}
	 *            json
	 */
	RecordDetail.prototype.saveInfo = function(json) {
		$.ajax({
			"url" : "/stuenroll/reviewDetails/addReviewRecord",
			"type" : "post",
			"dataType" : "json",
			"data" : json,
			"success" : function(json) {

			},
			"error" : function() {
				toastr.error("系统异常");
			}
		});
	}

	/** ****************************实现结束************************************ */

	/** ****************************工厂方法*********************************** */
	function Factory(key) {
		if (key == "RecordDetail") {
			return new RecordDetail();
		}
	}
	/** ***************************工厂方法结束********************************** */

	var recordDetail = Factory("RecordDetail");
	var recordJson = {};
	// 1. 读取sessionStorage数据并根据具体情况加载数据
	var bool = sessionStorage.bool;
	recordJson.bool = bool;
	// 1.1 加载被访问学生信息
	if (bool == true) {
		recordJson.reviewId = sessionStorage.reviewId;
		// 1.2 禁用所有input
		$("input").attr("disabled", "true");
	}
	else {
		recordJson.studentId = sessionStorage.studentId;
	}
	recordDetail.init(recordJson, bool);

	// TODO 2. 使用echarts加载图例
//	recordDetail.loadStudentAttendance(recordJson);
//	recordDetail.loadStudentScore(recordJson);
	// TODO 3. 设置定时器并判断是否打通电话
	var bools = false;
	if (!bool) {
		var timer = setTimeout(function() {
			var details = $(".main-container .review-container .info-container[data-index='reviewInfo'] .questions");
			var checkbox = details.find(".answer input[type='checkbox']");
			for (var i = 0; i < checkbox.length; i++) {
				bools = bools || $(checkbox[i]).is(":checked");
			}
			var textarea = details.find(".answer textarea");
			for (var i = 0; i < textarea.length; i++) {
				bools = bools || ($(textarea[i]).text() != '' || $(textarea[i]).text() != null || $(textarea[i]).text() != undefined);
			}
			if (!bools) {
				json.reviewee = $(".main-container .charts-container .phone-container .phone-container .student .info span[name='name']").text();
				json.time = end - start;
				json.reviewer = sessionStorage.name;
				json.content = "测试内容";
				json.classInfoId = sessionStorage.classInfoId;
				json.studentId = sessionStorage.studentId;
				json.reviewResult =  1 ;
				json.satisfaction = "满意";
				recordDetail.saveInfo(json);
				location.href = sessionStorage.locations;
			}
			clearTimeout(timer);
		}, 3000);
	}
	// TODO 4. 跳转到当前页面即开始拨打电话
	var callBtn = $(".main-container .charts-container .phone-container .call .callBtn");
	callBtn.find("span[name='拨打']").removeClass("item-active");
	callBtn.find("span[name='挂断']").addClass("item-active");
	var start = new Date().getSeconds();

	// TODO 5. 挂断电话即保存此次回访信息：若打通，则保存回访记录和回访内容；若不打通，则只保存回访记录
	$(".main-container .charts-container .phone-container .call .callBtn span").click(function() {
		$(this).removeClass("item-active");
		$(this).siblings().addClass("item-active");
		var end = new Date().getSeconds();
		// 1. 读取回访记录详细信息
		var date = new Date();
		var json = {};
		if (bools) {
			var details = $(".main-container .review-container .info-container[data-index='reviewInfo'] .questions");
			var answer = details.find("answer");
			var checkbox = answer.find("input[type='checkbox']");
			var q = [];
			var j = 0;
			for (var i = 0; i < checkbox.length; i++) {
				if ($(checkbox[i]).is(":checked")) {
					q[j] = $(checkbox[i]).val();
					j = j + 1;
				}
			}
			q[j] = $(answer[8]).find("textarea[name='changes']").text();
			j = j + 1;
			q[j] = $(answer[18]).find("textarea[name='jobAdvice']").text();
			json.answer = q;
		}
		// 2. 保存回访记录
		json.reviewee = $(this).parents(".phone-container").find(".student .info span[name='name']").text();
		json.time = end - start;
		json.reviewer = sessionStorage.name;
		json.content = "测试内容";
		json.classInfoId = sessionStorage.classInfoId;
		json.studentId = sessionStorage.studentId;
		json.reviewResult = bools == false ? 1 : 0;
		json.satisfaction = "满意";
		recordDetail.saveInfo(json);
		location.href = sessionStorage.locations;
	});

	$(".main-container .review-container .info-container[data-index='reviewInfo'] .questions .answer input[type='checkbox']").click(
			function() {
				$(this).siblings("input[type='checkbox']").removeAttr("checked");
			});

});