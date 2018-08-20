(function(){
	var app=angular.module("Project2");

app.service("submitStudentRecord",submitStudentRecord);
app.service("getAllStudentRecord",getAllStudentRecord);
app.service("getRecordsByBelt",getRecordsByBelt);
app.service("getRecordsByRank",getRecordsByRank);
app.service("getRecordsByYear",getRecordsByYear);
app.service("getRecordsByCombo",getRecordsByCombo);
app.service("submitExtraServices",submitExtraServices);
app.service("getGeneralRecordsForForm",getGeneralRecordsForForm);
app.service("updatedFormsServices",updatedFormsServices);
	

	// Api get all records
	function getAllStudentRecord($http){

		//get all student
		var self = this;
		self.getRecords= function(data){
			console.log("inside service");
			console.log(data);
			
			var p1= $http.get('http://localhost:8080/student');
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all active students
		var self = this;
		self.getActRecords= function(){
			console.log("call to get active student");
			var p1= $http.get('http://localhost:8080/student/status/active');
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}
	}

	//Api get only records by belt
	function getRecordsByBelt($http){

		var self = this;
		self.getRecords= function(data){
			console.log("inside service");
			console.log("inside getRecordsByBelt Data =" + data);
			
			var p1= $http.get('http://localhost:8080/student/belt/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}
	}

	//Api get only records by rank
	function getRecordsByRank($http){

		var self = this;
		self.getRecords= function(data){
			console.log("inside service");
			console.log("inside getRecordsByRank Data =" + data);
			
			var p1= $http.get('http://localhost:8080/student/rank/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}
	}

	//Api get only records by year
	function getRecordsByYear($http){

		var self = this;
		self.getRecords= function(data){
			console.log("inside service");
			console.log("inside getRecordsByYear1 Data =" + data);
			
			var p1= $http.get('http://localhost:8080/student/year/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		self.getRecordsLt= function(data){
			console.log("inside service");
			console.log("inside getRecordsByYear2 Data =" + data);
			
			var p1= $http.get('http://localhost:8080/student/yearLt/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}
		self.getRecordsGt= function(data){
			console.log("inside service");
			console.log("inside getRecordsByYear3 Data =" + data);
			
			var p1= $http.get('http://localhost:8080/student/yearGt/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}
	}


	//Api get only records by combo
	function getRecordsByCombo($http){

		var self = this;
		self.getRecords= function(data1,data2,data3){
			console.log("inside service");
			console.log("inside getRecordsByCombo Data =" + data1+data2+data3);
			
			var p1= $http.get('http://localhost:8080/student/combo/'+data1+"/"+data2+"/"+data3);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}
	}

	//General API calls to fetch data for forms.
	function getGeneralRecordsForForm($http){
		var self = this;

		//get all class records
		self.getClassRecords= function(){
			console.log("inside getClassRecords service");
			var p1= $http.get('http://localhost:8080/class/');
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all schedule for classes
		self.getClassSchedule=function(data){
			console.log("inside getClassSchedule service");
			var p1= $http.get('http://localhost:8080/classSchedule/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all schedule for all classes
		self.getAllClassSchedule=function(){
			console.log("inside getAllClassSchedule service");
			var p1= $http.get('http://localhost:8080/classSchedule/');
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all rank info
		self.getRankRecords= function(){
			console.log("inside getRankRecords service with data");
			var p1= $http.get('http://localhost:8080/rank/');
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get rank req
		self.getRankReqRecords= function(data){
			console.log("inside getRankReqRecords service with data" + data);
			var p1= $http.get('http://localhost:8080/rankReq/'+ data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get All rank req
		self.getAllRankReqRecords= function(){
			console.log("inside getAllRankReqRecords service with data");
			var p1= $http.get('http://localhost:8080/rankReq/');
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get one student info
		self.getOneStudentRecord= function(data){
			console.log("inside getOneStudentRecord service");
			var p1= $http.get('http://localhost:8080/student/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all rank number occupied by students
		self.getUniqueRank= function(){
			console.log("inside getUniqueRank service");
			var p1= $http.get('http://localhost:8080/student/activeRank');
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all rank belts occupied by students
		self.getUniqueRankBelt= function(){
			console.log("inside getUniqueRank service");
			var p1= $http.get('http://localhost:8080/student/activeRankBelt');
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all fee record per student
		self.getAllFeeRecordPerStud= function(data){
			console.log("inside getAllFeeRecordPerStud service");
			var p1= $http.get('http://localhost:8080/fee/stud/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all parent record per student
		self.getAllParentRecordPerStud= function(data){
			console.log("inside getAllParentRecordPerStud service");
			var p1= $http.get('http://localhost:8080/parent/stud/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all attendence records
		self.getAllAttendRecordPerStud= function(data){
			console.log("inside getAllAttendRecordPerStud service");
			var p1= $http.get('http://localhost:8080/classAttendance/stud/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all rank req  records
		self.getAllRankReqRecordPerStud= function(data){
			console.log("inside getAllRankReqRecordPerStud service");
			var p1= $http.get('http://localhost:8080/rankReqHist/stud/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}

		//get all rank Hist  records
		self.getAllRankHistRecordPerStud= function(data){
			console.log("inside getAllRankHistRecordPerStud service");
			var p1= $http.get('http://localhost:8080/rankHist/stud/'+data);
			var p2= p1.then(function (response){
				console.log(response.data);
				return response.data;
			});
			return p2;
		}


	}


	//API to submit student record
	function submitStudentRecord($http){
		var self=this;	
		self.saveRecord = function(data){
			self.local=data;
			console.log("inside service");
			console.log(self.local.name);
			console.log(self.local.age);
			console.log(self.local.rank);
			console.log(self.local.year);
			console.log(self.local.belts);
			console.log("End of user input");
			var promise1 = $http.post("http://localhost:8080/student",self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}
	}

	//API to hold all update pages call
	function updatedFormsServices($http){
		var self=this;	

		//update student record
		self.updateStudent = function(data){
			self.local=data;
			console.log("Object recieved self.local" + self.local.std_num);
			var promise1 = $http.put("http://localhost:8080/student/"+self.local.std_num,self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}

		//update student Fee record
		self.updateStudentFee = function(data){
			self.local=data;
			console.log("Object recieved self.local" + self.local);
			var promise1 = $http.post("http://localhost:8080/fee/",self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}
		
		//update student Parent record
		self.updateStudentParent = function(data){
			self.local=data;
			console.log("Object recieved self.local" + self.local);
			var promise1 = $http.post("http://localhost:8080/parent/",self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}

		//update student Attendence record
		self.updateStudentAttendence = function(data){
			self.local=data;
			console.log("Object recieved self.local" + self.local);
			var promise1 = $http.post("http://localhost:8080/classAttendance/",self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}

		//update student Rank Achived record
		self.updateStudentRankReqAch = function(data){
			self.local=data;
			console.log("Object recieved self.local" + self.local);
			var promise1 = $http.post("http://localhost:8080/rankReqHist/",self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}


	}

	//API to submit general data
	function submitExtraServices($http){
		var self=this;

		//save class record	
		self.saveClass = function(data){
			self.local=data;
			console.log("inside submitExtraServices");
			console.log(self.local);
			var promise1 = $http.post("http://localhost:8080/class",self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}

		//save class class schedule
		self.saveClassSchedule = function(data){
			self.local=data;
			console.log("inside save class schedule");
			console.log(self.local);
			var promise1 = $http.post("http://localhost:8080/classSchedule",self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}

		//save class Rank
		self.saveRank = function(data){
			self.local=data;
			console.log("inside save Rank");
			console.log(self.local);
			var promise1 = $http.post("http://localhost:8080/rank",self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}

		//save rank req
		self.apiCallToSaveRankReq= function(data){
			self.local=data;
			console.log("inside save Rank");
			console.log(self.local);
			var promise1 = $http.post("http://localhost:8080/rankReq",self.local);
			var promise2 = promise1.then(function (response) {
					console.log("Respone = " + response.data);
					return response.data;
			});
			return promise2;
		}




	}


})();