
var dms = require("./dms")

var client = dms.New("demo","demo","test1")
client.subscribe(['test_a',"test_b"],function(err,info){
	console.log("subscribe back",err,info)
});

client.on('message', function (topic, message,opts) {
  console.log(topic,"--"+opts.qos+"--",message);
});
client.on("reconnect",function(){
	console.log("reconnect")
})
client.on("offline",function(){
	console.log("offline")
})
client.on("connect",function(){
	console.log("connect")

})
client.on("error",function(){
	console.log("error")
})
client.on("close",function(){
	console.log("close")
})