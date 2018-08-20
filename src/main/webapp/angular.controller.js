(function(){
	var app= angular.module("Project2", []);

	app.controller('studentSearch', function(getAllStudentRecord,submitStudentRecord,getRecordsByBelt
		,getRecordsByRank,getRecordsByYear,getRecordsByCombo,submitExtraServices,getGeneralRecordsForForm,updatedFormsServices){

		var self=this;
		self.searchType= "All";
		var studentRecord ;
		var classRecords;
		var rankRecords;
		var rankReqRecords;
		var classSchRecords;
		var uniqueRankRecords;
		var studFeeRecords;
		var studParentRecords;
		var studAttRecords;
		var studRankAchRecords;
		var studRankHistRecords;
		var classAllSchRecords;
		var allRankReqRecords;
		self.pageTypeSearch=true;
		self.recordNotInserted=false;
		self.recInsertedSuccessfully=true;
		self.isSearchByBelts=false;  //search for belts only
		self.searchByCatgory=false;
		self.isSearchByCombo=false;
		self.isSearchByRank=false;
		self.isSearchByYear=false;
		self.showStudentResult=false; // show the block of student search data
		self.addStudentPage=false;
		self.addClassPage=false;
		self.addSchedulePage=false;
		self.addRankPage=false;
		self.addRankReqPage=false;
		self.addPageSelected=false;
		self.showUpdatePage=false;
		self.showViewFullPage=false;
		self.yearOptionSelected="=";
		self.alertMessage="";
		self.beltSearchType="";
		self.updateStudNumRecord="";


	//varibables to send data to backend
	self.studentStruct={
		"std_fname":"",
		"std_lname":"",
		"std_dob":"",
		"std_date_enroll":"",
		"std_phone":"",
		"std_email":"",
		"std_address_line1":"",
		"std_address_line2":"",
		"std_address_city":"",
		"std_address_prov":"",
		"std_address_zipcode":"",
		"status":"",
		"rank": {
				"rk_code" : "",
				"rk_name": "",
				"rk_belt_color":""
				}
	};

	//structure to hold class info
	self.classStruct={
		"cls_code":"",
		"cls_description":"",
		"cls_level":"",
		"instructor":{
			"ins_number":""
		}

	};

	//structure to hold Schedule page
	self.scheduleStruct={
		"sch_dayweek":"",
		"start_time":"",
		"end_time":"",
		"classs":{
			"cls_code":"",
			"cls_description":""
		}
	};

	//struture to hold Rank Page
	self.rankStruct={
		"rk_code":"",
		"rk_name":"",
		"rk_belt_color":""
	};

	//structure to hold Rank Reg page
	self.rankReqStruct={
		"dt_achieved": "",
		"student":{
			"std_num": ""
		},
		"rank":{
			"rk_code" :""
		},
		"rank_req":{
			"req_num" :""
		}
	};

	//structure of saving new rankRe
	self.newRankReq={
		"req_num": "",
		"req_description" : "",
		"rank":{
		"rk_code" : ""
		}
	};

	//structure to hold fee
	self.newFeeStruct={
		"fee_description" : "",
		"fee_date" : "",
		"fee_value" : "",
		"student":{
			"std_num":""
		}
	};

	//structure to hold parent
	self.newParentStruct={
		"prt_type" : "",
		"prt_fname" : "",
		"prt_lname" : "",
		"prt_phone" : "",
		"prt_email" : "",
		"student" :{
			"std_num" : ""
		},
		"studentParent" :{
			"std_num" : ""
		}
	};

	//structure to hold class attendence
	self.newClassAttendence={
		"att_date" : "",
		"studentFee" : {
			"std_num" : ""
		},
		"classs": {
			"cls_code" : ""
		},
		"classSch": {
			"sch_num" : ""
		}
	};

	//structure to hold student rank req achieved
	self.newClassAchReq={
		"dt_achieved": "",
		"student":{
			"std_num": ""
		},
		"rank":{
			"rk_code" :""
		},
		"rank_req":{
			"req_num" :""
		}
	};

	//********************initialise******************//
	//initialise structure for next student insertion	
	self.refreshData = 	function(){
		self.studentStruct.std_num = "";
		self.studentStruct.std_fname = "";
		self.studentStruct.std_fname = "";
		self.studentStruct.std_lname="";
		self.studentStruct.std_dob="";
		self.studentStruct.std_date_enroll="";
		self.studentStruct.std_phone="";
		self.studentStruct.std_email="";
		self.studentStruct.std_address_line1="";
		self.studentStruct.std_address_line2="";
		self.studentStruct.std_address_city="";
		self.studentStruct.std_address_prov="";
		self.studentStruct.std_address_zipcode="";
		self.studentStruct.status="";
		self.studentStruct.rank.rk_code="";
		self.studentStruct.rank.rk_name="";
		self.studentStruct.rank.rk_belt_color="";
	}

	//initialise structure for next student insertion	
	self.refreshClassData = function(){
		self.classStruct.cls_code="";
		self.classStruct.cls_description = "";
		self.classStruct.cls_level="";
		self.classStruct.instructor.ins_number="";
	}

	self.refreshscheduleStruct= function(){
		self.scheduleStruct.sch_dayweek="";
		self.scheduleStruct.start_time="";
		self.scheduleStruct.end_time="";
		self.scheduleStruct.classs.cls_code="";
		self.scheduleStruct.classs.cls_description="";
		
	}

	self.refreshrankStruct=function(){
		self.rankStruct.rk_code="";
		self.rankStruct.rk_name="";
		self.rankStruct.rk_belt_color="";
	}

	self.refreshrankReqStruct=function(){
		self.rankReqStruct.dt_achieved="";
		self.rankReqStruct.student.std_num="";
		self.rankReqStruct.rank.rk_code="";
		self.rankReqStruct.rank_req.req_num="";
	}

	self.refreshnewRankReq=function(){
		self.newRankReq.req_num="";
		self.newRankReq.req_description="";
		self.newRankReq.rank.rk_code="";
	}

	self.refreshnewFeeStruct=function(){
		self.newFeeStruct.fee_description="";
		self.newFeeStruct.fee_date="";
		self.newFeeStruct.fee_value="";
		self.newFeeStruct.student.std_num="";
	}

	self.refreshnewParentStruct= function(){
		self.newParentStruct.prt_type="";
		self.newParentStruct.prt_fname="";
		self.newParentStruct.prt_lname="";
		self.newParentStruct.prt_phone="";
		self.newParentStruct.prt_email="";
		self.newParentStruct.student.std_num="";
		self.newParentStruct.studentParent.std_num="";
	}

	self.refreshnewClassAttendence= function(){
		self.newClassAttendence.att_date="";
		self.newClassAttendence.studentFee.std_num="";
		self.newClassAttendence.classs.cls_code="";
		self.newClassAttendence.classSch.sch_num="";
	}

	self.refreshnewClassAchReq=function(){
		self.newClassAchReq.dt_achieved="";
		self.newClassAchReq.student.std_num="";
		self.newClassAchReq.rank.rk_code="";
		self.newClassAchReq.rank_req.req_num="";
	}
	
	//******************functions to save data **************//
	//function to save student record
	self.saveStudent = function(){
		self.studentStruct.rank.rk_code=4;
		console.log(self.studentStruct);
		self.recordNotInserted=true;
		self.addStudentPage=false;
		self.apiCallToSaveStudent(self.studentStruct);
		//self.refreshData();
	}
	//function to save class record
	self.saveClass = function(){
		console.log(self.classStruct);
		self.apiCallToSaveClass(self.classStruct);
		self.recordNotInserted=true;
		self.addClassPage=false;
		//flush the data
		//self.refreshClassData();
	}
	//function to save Schedule record
	self.saveSchedule = function(){
		self.apiCallToSaveClassSchedule(self.scheduleStruct);
		self.recordNotInserted=true;
		self.addSchedulePage=false;
	}
	//function to save Rank record
	self.saveRank = function(){
		self.apiCallToSaveRank(self.rankStruct);
		self.recordNotInserted=true;
		self.addRankPage=false;
	}
	//function to save Rank Reg record
	self.saveRankReq = function(){
		self.apiCallToSaveRankReq(self.newRankReq);
		self.recordNotInserted=true;
		self.addRankReqPage=false;
	}

	

	//************UPDATE CALLS*************//
	self.showSearchPage=function(){
		//console.log("Call recieved to show search page");
		self.showUpdatePage=false;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudParentPage=false;
		self.showStdClassAttPage=false;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=false;
	}
	self.viewFullInfoPage=function(data){
		//console.log("Call recieved to show update page");
		self.apiCallToGetGeneralRecordsForOneStudent(data);
		self.showUpdatePage=true;
		self.showViewFullPage=true;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudParentPage=false;
		self.showStudClassAttPage=false;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=false;
	}
	self.viewFullEditStudPage=function(data){
		//console.log("Call recieved to show update page");
		self.apiCallToGetGeneralRecordsForOneStudent(data);
		self.apiCallToGetGeneralRecordsForRank();
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=true;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudParentPage=false;
		self.showStudClassAttPage=false;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=false;
	}
	self.viewStudFeePage=function(data){
		//console.log("Call recieved to show update page");
		self.refreshnewFeeStruct();
		if(data != 0){
			self.updateStudNumRecord=data;
		}
		console.log("self.updateStudNumRecord" + self.updateStudNumRecord);
		self.apiCallToGetGeneralRecordsForFeePaid(self.updateStudNumRecord);
		self.newFeeStruct.student.std_num=data;
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showStudFeePage=true;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudParentPage=false;
		self.showStudClassAttPage=false;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=false;
	}
	self.viewAddFeePage=function(){
		//console.log("Call recieved to show update page");
		self.refreshnewFeeStruct();
		console.log("self.updateStudNumRecord = " + self.updateStudNumRecord);
		self.newFeeStruct.student.std_num=self.updateStudNumRecord;
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=true;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudParentPage=false;
		self.showStudClassAttPage=false;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=false;
	}
	self.viewStudParentPage=function(data){
		console.log("Call recieved to show update page");
		self.refreshnewParentStruct();
		if(data != 0){
			self.updateStudNumRecord=data;
		}
		console.log("self.updateStudNumRecord" + self.updateStudNumRecord);
		self.apiCallToGetGeneralRecordsForStudParent(self.updateStudNumRecord);
		self.newParentStruct.student.std_num=data;
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showStudParentPage=true;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudClassAttPage=false;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=false;
	}
	self.viewAddParentPage=function(){
		console.log("Call recieved to show update page");
		self.refreshnewParentStruct();
		console.log("self.updateStudNumRecord" + self.updateStudNumRecord);
		self.newParentStruct.student.std_num=self.updateStudNumRecord;
		self.apiCall();
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=true;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudParentPage=false;
		self.showStudClassAttPage=false;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=false;
	}
	self.viewStudClassAttPage=function(data){
		//console.log("Call recieved to show update page");
		self.refreshnewClassAttendence();
		if(data != 0){
			self.updateStudNumRecord=data;
		}
		console.log("self.updateStudNumRecord" + self.updateStudNumRecord);
		self.apiCallToGetGeneralRecordsForStudAttd(self.updateStudNumRecord);
		self.classSchRecords="";
		self.newClassAttendence.studentFee.std_num=data;
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudParentPage=false;
		self.showStudClassAttPage=true;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=false;
	}
	self.viewAddClassAttPage=function(){
		//console.log("Call recieved to show update page");
		self.refreshnewClassAttendence();
		self.classSchRecords="";
		self.apiCallToGetGeneralRecordsForClass();
		console.log("self.updateStudNumRecord" + self.updateStudNumRecord);
		self.newClassAttendence.studentFee.std_num=self.updateStudNumRecord;
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=true;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudParentPage=false;
		self.showStudClassAttPage=false;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=false;
	}
	self.viewStudRankReqCompPage=function(data){
		console.log("Calling viewStudRankReqCompPage");
		self.refreshnewClassAchReq();
			if(data != 0){
			self.updateStudNumRecord=data;
		}
		console.log("self.updateStudNumRecord" + self.updateStudNumRecord);
		self.apiCallToGetGeneralRecordsForStudRankAch(self.updateStudNumRecord);
		self.newClassAchReq.student.std_num=data;
		self.rankRecords="";
		self.rankReqRecords="";
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudParentPage=false;
		self.showStudClassAttPage=false;
		self.showStudRankReqCompPage=true;
		self.showStudRankHistCompPage=false;
	}
	self.viewStudRankHistCompPage=function(){
		console.log("Calling viewStudRankReqCompPage");
		console.log("self.updateStudNumRecord" + self.updateStudNumRecord);
		self.apiCallToGetGeneralRecordsForStudRankHist(self.updateStudNumRecord);
		self.rankRecords="";
		self.rankReqRecords="";
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=false;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudParentPage=false;
		self.showStudClassAttPage=false;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=true;
	}
	self.viewAddRankReqCompPage=function(){
		//console.log("Call recieved to show update page");
		console.log("call to viewAddRankReqCompPage");
		self.refreshnewClassAchReq();
		console.log("self.updateStudNumRecord" + self.updateStudNumRecord);
		self.newClassAchReq.student.std_num=self.updateStudNumRecord;
		self.rankRecords="";
		self.rankReqRecords="";
		self.apiCallToGetGeneralRecordsForRank();
		self.showUpdatePage=true;
		self.showViewFullPage=false;
		self.showEditStudPage=false;
		self.showAddFeePage=false;
		self.showAddParentPage=false;
		self.showAddClassAttPage=false;
		self.showAddRankReqCompPage=true;
		self.recordNotInserted=false;
		self.showStudFeePage=false;
		self.showStudParentPage=false;
		self.showStudClassAttPage=false;
		self.showStudRankReqCompPage=false;
		self.showStudRankHistCompPage=false;
	}


	//function to Update student record
	self.updateStudentInfo = function(){
		console.log("Got the call");
		self.apiCallToUpdateStudentInfo(self.studentStruct);
		self.recordNotInserted=true;
		self.showEditStudPage=false;
	}

	//update student fees record
	self.updateStudentFeeRecord =  function(){
		console.log("Got the call to updateStudentFeeRecord");
		self.apiCallToUpdateStudentFeeInfo(self.newFeeStruct);
		self.recordNotInserted=true;
		self.showAddFeePage=false;
	}

	//update student parent records
	self.updateStudentParentRecord =  function(){
		console.log("Got the call to updateStudentParentRecord");
		self.apiCallToUpdateStudentParentInfo(self.newParentStruct);
		self.recordNotInserted=true;
		self.showAddParentPage=false;
	}

	//update student attendence records
	self.updateStudentAttendenceRecord =  function(){
		console.log("Got the call to updateStudentAttendenceRecord");
		self.apiCallToUpdateStudentAttendenceInfo(self.newClassAttendence);
		self.recordNotInserted=true;
		self.showAddClassAttPage=false;
	}

	//update student 
	self.UpdateStudentRankReqRecord=function(){
		console.log("Got the call to UpdateStudentRankReqRecord");
		console.log("Data**********" + self.newClassAchReq.dt_achieved);
		self.apiCallToUpdateStudentRankReqInfo(self.newClassAchReq);
		self.recordNotInserted=true;
		self.showAddRankReqCompPage=false;
	}


	//*************End of Update function calls



	self.searchCall= function(data){
		if(data == 'All'){
			self.searchType= "All";	
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=false;
			self.isSearchByCombo=false;
			self.isSearchByRank=false;
			self.isSearchByYear=false;
			self.showStudentResult=true;
			self.refreshData();
			self.studentRecord="";
			self.apiCall();	
		}
		else if(data == 'Active'){
			self.searchType= "All";	
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=false;
			self.isSearchByCombo=false;
			self.isSearchByRank=false;
			self.isSearchByYear=false;
			self.showStudentResult=true;
			self.refreshData();
			self.studentRecord="";
			self.apiCallToGetActStud();
		}
		else if(data == 'Combo'){
			self.searchType= "Combo";
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=false;
			self.isSearchByRank=false;
			self.isSearchByCombo=true;
			self.isSearchByYear=false;
			self.showStudentResult=false;
			self.studentRecord="";
			self.yearOptionSelected="=";
			self.beltSearchType="";
			self.uniqueRankRecords="";
			self.refreshData();
			self.apiCallToGetGeneralRecordsForActiveRankBelt();
		}
		else if(data == 'Rank'){
			self.searchType= "By Rank";
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=true;
			self.isSearchByCombo=false;
			self.isSearchByRank=true;
			self.isSearchByYear=false;
			self.showStudentResult=false;
			self.studentRecord="";
			self.uniqueRankRecords="";
			self.refreshData();
			self.apiCallToGetGeneralRecordsForActiveRankNumber();
		}
		else if(data == 'Year'){
			self.searchType= "By Year";
			//unset the fields
			self.isSearchByBelts=false;
			self.searchByCatgory=true;
			self.isSearchByCombo=false;
			self.isSearchByRank=false;
			self.isSearchByYear=true;
			self.showStudentResult=false;
			self.studentRecord="";
			self.yearOptionSelected="=";
			self.refreshData();
		}
		else if(data == 'Belts'){
			self.searchType= "By Belts";
			self.isSearchByBelts=true;
			self.searchByCatgory=true;
			self.isSearchByRank=false;
			self.isSearchByCombo=false;
			self.isSearchByYear=false;
			self.showStudentResult=false;
			self.studentRecord="";
			self.beltSearchType="";
			self.uniqueRankRecords="";
			self.refreshData();
			self.apiCallToGetGeneralRecordsForActiveRankBelt();
		}
	}
	self.changePage=function(data){
		self.pageTypeSearch=data;

		if(data == false){
			self.refreshData();
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=false;
			self.refreshData();
		}
		else {
			self.refreshData();
			self.recordNotInserted=false;
			self.isSearchByBelts=false;
			self.searchByCatgory=false;
			self.isSearchByRank=false;
			self.isSearchByCombo=false;
			self.isSearchByYear=false;
			self.showStudentResult=false;
			self.addPageSelected=false;
		}
	}


	//function to handle switching of Add block
	self.addCallSwitch= function(data){
		if(data == 'Student'){
			self.recordNotInserted=false;
			self.addStudentPage=true;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
			self.viewClassPage=false;
			self.viewSchedulePage=false;
			self.viewRankPage=false;
			self.viewRankReqPage=false;
			self.refreshData();
		}
		else if(data == 'Class'){
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=true;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
			self.viewClassPage=false;
			self.viewSchedulePage=false;
			self.viewRankPage=false;
			self.viewRankReqPage=false;
			self.refreshClassData();
		}
		else if(data == 'ViewClass'){
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
			self.viewClassPage=true;
			self.viewSchedulePage=false;
			self.viewRankPage=false;
			self.viewRankReqPage=false;
			self.refreshClassData();
			self.apiCallToGetGeneralRecordsForClass();
		}
		else if(data == 'Schedule'){
			//self.refreshClassData();
			self.refreshscheduleStruct();
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=true;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
			self.viewClassPage=false;
			self.viewSchedulePage=false;
			self.viewRankPage=false;
			self.viewRankReqPage=false;
			self.apiCallToGetGeneralRecordsForClass();
		}
		else if(data == 'ViewSchedule'){
			self.refreshscheduleStruct();
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
			self.viewClassPage=false;
			self.viewSchedulePage=true;
			self.viewRankPage=false;
			self.viewRankReqPage=false;
			self.apiCallToGetGeneralRecordsForAllClassSchedule();
		}
		else if(data == 'Rank'){
			self.refreshrankStruct();
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=true;
			self.addRankReqPage=false;
			self.addPageSelected=true;
			self.viewClassPage=false;
			self.viewSchedulePage=false;
			self.viewRankPage=false;
			self.viewRankReqPage=false;
		}
		else if(data == 'ViewRank'){
			self.refreshrankStruct();
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
			self.viewClassPage=false;
			self.viewSchedulePage=false;
			self.viewRankPage=true;
			self.viewRankReqPage=false;
			self.apiCallToGetGeneralRecordsForRank();
		}
		else if(data == 'RankReq'){
			//self.refreshrankReqStruct();
			self.refreshnewRankReq();
			self.apiCallToGetGeneralRecordsForRank(); // get all class id record
			self.rankReqRecords="";
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=true;
			self.addPageSelected=true;
			self.viewClassPage=false;
			self.viewSchedulePage=false;
			self.viewRankPage=false;
			self.viewRankReqPage=false;
		}
		else if(data == 'ViewRankReq'){
			//self.refreshrankReqStruct();
			self.refreshnewRankReq();
			self.rankReqRecords="";
			self.recordNotInserted=false;
			self.addStudentPage=false;
			self.addClassPage=false;
			self.addSchedulePage=false;
			self.addRankPage=false;
			self.addRankReqPage=false;
			self.addPageSelected=true;
			self.viewClassPage=false;
			self.viewSchedulePage=false;
			self.viewRankPage=false;
			self.viewRankReqPage=true;
			self.apiCallToGetGeneralRecordsForAllRankReq();
		}
	}


	//function to call API to get all student for a belt
	self.searchByBelt=function(data){
		//console.log("Call to searchByBelt recieved");
		self.showStudentResult=true;
		self.apiCallToGetStudByBelt(data);
	}
	//function to call API to get all student for a year
	self.searchByYear=function(data1,data2){
		console.log("mode recieved= " + data2);
		console.log("value recieved =" + data1);
		if(data2 == ">="){
			self.searchByYearGt(data1);
		}
		else if(data2=="<="){
			self.searchByYearLt(data1);
		}
		self.apiCallToGetStudByYear(data1);
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a year greater
	self.searchByYearGt=function(data1){
		console.log("Call recieved in searchByYearGt with data = " + data1);
		self.apiCallToGetStudByYearGt(data1);
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a year less
	self.searchByYearLt=function(data1){
		console.log("Call recieved in searchByYearLt with data = " + data1);
		self.apiCallToGetStudByYearLt(data1);
		self.showStudentResult=true;
		//call API
	}
	//function to call API to get all student for a rank
	self.searchByRank=function(data){
		console.log("Data = " + data);
		self.showStudentResult=true;
		self.apiCallToGetStudByRank(data);
	}
	//function to call API to get all student for a combo
	self.searchByCombo=function(data1,data2,data3){
		console.log("Call recieved in searchByCombo with data = " + data1 + data2 +data3);
		self.showStudentResult=true;
		self.apiCallToGetStudByCombo(data1,data2,data3);
		//call API
	}



	//************API CALL Functions**************//
	//Api call to get all student
	self.apiCall=function(){
		getAllStudentRecord.getRecords(self.searchType)
		.then(function(data){
			self.studentRecord =data;
			console.log("studentRecord" + data);
		})
	}

	//Api call to get all active student
	self.apiCallToGetActStud=function(){
		getAllStudentRecord.getActRecords(self.searchType)
		.then(function(data){
			self.studentRecord =data;
			console.log("studentRecord" + data);
		})
	}
	
	//Api call to get all by rank 
	self.apiCallToGetStudByRank=function(arg1){
		getRecordsByRank.getRecords(arg1)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}

	//Api call to get all by belt 
	self.apiCallToGetStudByBelt=function(arg1){
		getRecordsByBelt.getRecords(arg1)
		.then(function(data){
			self.studentRecord =data;
			console.log( "studentRecord" + self.studentRecord);
		})
	}

	//Api call to get all by = year 
	self.apiCallToGetStudByYear=function(arg1){
		getRecordsByYear.getRecords(arg1)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}
	
	//Api call to get all by <= year 
	self.apiCallToGetStudByYearLt=function(arg1){
		getRecordsByYear.getRecordsLt(arg1)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}

	//Api call to get all by >= year 
	self.apiCallToGetStudByYearGt=function(arg1){
		getRecordsByYear.getRecordsGt(arg1)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}

	//Api call to get all by combo 
	self.apiCallToGetStudByCombo=function(arg1,arg2,arg3){
		getRecordsByCombo.getRecords(arg1,arg2,arg3)
		.then(function(data){
			console.log(data);
			self.studentRecord =data;
		})
	}

	//Api call to get all class records
	self.apiCallToGetGeneralRecordsForClass=function(){
		getGeneralRecordsForForm.getClassRecords()
		.then(function(data){
			console.log(data);
			self.classRecords =data;
		})
	}


	//API to get all rank
	self.apiCallToGetGeneralRecordsForRank=function(){
		getGeneralRecordsForForm.getRankRecords()
		.then(function(data){
			console.log(data);
			self.rankRecords =data;
		})
	}


	//get rank req
	self.apiCallToGetGeneralRecordsForRankReq=function(data){
		getGeneralRecordsForForm.getRankReqRecords(data)
		.then(function(data){
			console.log(data);
			self.rankReqRecords =data;
		})
	}

	//get all rank req
	self.apiCallToGetGeneralRecordsForAllRankReq=function(){
		getGeneralRecordsForForm.getAllRankReqRecords()
		.then(function(data){
			console.log(data);
			self.allRankReqRecords =data;
		})
	}
	
	//get class schedule
	self.apiCallToGetGeneralRecordsForClassSchedule=function(data){
		console.log("call to apiCallToGetGeneralRecordsForClassSchedule recieved");
		console.log("data = "+ data);
		getGeneralRecordsForForm.getClassSchedule(data)
		.then(function(data){
			console.log(data);
			self.classSchRecords =data;
		})
	}

	//get all schedule
	self.apiCallToGetGeneralRecordsForAllClassSchedule=function(data){
		console.log("call to apiCallToGetGeneralRecordsForClassSchedule recieved");
		console.log("data = "+ data);
		getGeneralRecordsForForm.getAllClassSchedule(data)
		.then(function(data){
			console.log(data);
			self.classAllSchRecords =data;
		})
	}

	//get only one student
	self.apiCallToGetGeneralRecordsForOneStudent=function(data){
		getGeneralRecordsForForm.getOneStudentRecord(data)
		.then(function(data){
			console.log(data);
			self.studentStruct =data;
		})
	}

	//get all rank number occupied by students 
	self.apiCallToGetGeneralRecordsForActiveRankNumber=function(){
		getGeneralRecordsForForm.getUniqueRank()
		.then(function(data){
			console.log(data);
			self.uniqueRankRecords =data;
		})
	}
	
	//get all rank belts occupied by students 
	self.apiCallToGetGeneralRecordsForActiveRankBelt=function(){
		getGeneralRecordsForForm.getUniqueRankBelt()
		.then(function(data){
			console.log(data);
			self.uniqueRankRecords =data;
		})
	}

	//get all fee paid  by students 
	self.apiCallToGetGeneralRecordsForFeePaid=function(arg1){
		getGeneralRecordsForForm.getAllFeeRecordPerStud(arg1)
		.then(function(data){
			console.log(data);
			self.studFeeRecords =data;
		})
	}

	//get all Parent records by students 
	self.apiCallToGetGeneralRecordsForStudParent=function(arg1){
		getGeneralRecordsForForm.getAllParentRecordPerStud(arg1)
		.then(function(data){
			console.log(data);
			self.studParentRecords =data;
		})
	}

	//get all Attend records by students 
	self.apiCallToGetGeneralRecordsForStudAttd=function(arg1){
		getGeneralRecordsForForm.getAllAttendRecordPerStud(arg1)
		.then(function(data){
			console.log(data);
			self.studAttRecords =data;
		})
	}

	
	//get all Rank Req Ach records by students 
	self.apiCallToGetGeneralRecordsForStudRankAch=function(arg1){
		getGeneralRecordsForForm.getAllRankReqRecordPerStud(arg1)
		.then(function(data){
			console.log(data);
			self.studRankAchRecords =data;
		})
	}

	//get all Rank History records by students 
	self.apiCallToGetGeneralRecordsForStudRankHist=function(arg1){
		getGeneralRecordsForForm.getAllRankHistRecordPerStud(arg1)
		.then(function(data){
			console.log(data);
			self.studRankHistRecords =data;
		})
	}

	//*******************SAVE API Calls**************//
	//API to save Student information
	self.apiCallToSaveStudent=function(arg1){
		submitStudentRecord.saveRecord(arg1)
		.then(function (argument) {
			console.log("Success");
			self.alertMessage="Student";
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}

	//Api call to save Class info
	self.apiCallToSaveClass=function(arg1){
		submitExtraServices.saveClass(arg1)
		.then(function (argument) {
			console.log("Success");
			self.alertMessage="Class";
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}

	//Api call to save Class Schedule
	self.apiCallToSaveClassSchedule=function(arg1){
		submitExtraServices.saveClassSchedule(arg1)
		.then(function (argument) {
			console.log("Success");
			self.alertMessage="Class Schedule";
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}

	//Api call to save Rank 
	self.apiCallToSaveRank=function(arg1){
		submitExtraServices.saveRank(arg1)
		.then(function (argument) {
			console.log("Success");
			self.alertMessage="Rank";
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}

	//Api to save new rank req
	self.apiCallToSaveRankReq=function(arg1){
		submitExtraServices.apiCallToSaveRankReq(arg1)
		.then(function (argument) {
			console.log("Success");
			self.alertMessage="Rank Requirement";
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}


	//API to update student record
	self.apiCallToUpdateStudentInfo=function(arg1){
		updatedFormsServices.updateStudent(arg1)
		.then(function (argument) {
			console.log("Success");
			self.alertMessage="Student updated";
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}

	//API to update student fee record
	self.apiCallToUpdateStudentFeeInfo=function(arg1){
		updatedFormsServices.updateStudentFee(arg1)
		.then(function (argument) {
			console.log("Success");
			self.alertMessage="Student Fee added";
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}

	
	//API to update student Parent record
	self.apiCallToUpdateStudentParentInfo=function(arg1){
		updatedFormsServices.updateStudentParent(arg1)
		.then(function (argument) {
			console.log("Success");
			self.alertMessage="Parent added";
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}

	
	//API to update student Attendence record
	self.apiCallToUpdateStudentAttendenceInfo=function(arg1){
		updatedFormsServices.updateStudentAttendence(arg1)
		.then(function (argument) {
			console.log("Success");
			self.alertMessage="Student Attendence added";
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}
	
	//API to update student Rank Req record
	self.apiCallToUpdateStudentRankReqInfo=function(arg1){
		updatedFormsServices.updateStudentRankReqAch(arg1)
		.then(function (argument) {
			console.log("Success");
			self.alertMessage="Student Rank Achieved updated";
			self.recInsertedSuccessfully=true;
		},function (argument){
			console.log("Failure");
			self.recInsertedSuccessfully=false;
		});
	}


});

})();