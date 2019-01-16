var dms = require('./dms')

client = dms.New("demo","demo")
client.on("reconnect",function(){
	console.log("reconnect")
	stopTimer()
})
client.on("offline",function(err){
	console.log("offline",err)
	stopTimer()
})
client.on("connect",function(){
	console.log("connect")
	startTimer()
})
client.on("error",function(err){
	console.log("error",err)
	stopTimer()
})
client.on("close",function(err){
	console.log("close",err)
	stopTimer()
})
var index = 0
var timer = null
function startTimer(){
	if(timer == null){
		timer=	setInterval(function(){
				topic="test_a"
				var msg =  "use " + topic +"  " + (index++ )
				client.publish(topic,msg,function(){
					console.log("send ok")
				});
		},100)	
	}
}
function stopTimer(){
	if(timer != null){
		clearInterval(timer)
		timer = null
	}
}
