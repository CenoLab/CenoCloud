var mqtt = require('mqtt')
var util = require("util");
var events = require("events");
var crypto = require('crypto');



var host = "mqtt.dms.aodianyun.com";

exports.New = function(pubkey,subkey,cid){
	return new DMS(pubkey,subkey,cid)
}
function DMS(pubkey,subkey,cid){
	this.client_ = null;
	if(cid == null){
		cid = 'mqttjs_' + crypto.randomBytes(8).toString('hex');
	}
	console.log(cid)
	this.client_ = mqtt.createClient(1883, host,{username:pubkey,password:subkey,clean:false,clientId:cid});
	this.client_.on("reconnect",this.emit.bind(this,"reconnect"))
	this.client_.on("offline",this.emit.bind(this,"offline"))
	this.client_.on("connect",this.emit.bind(this,"connect"))
	this.client_.on("error",this.emit.bind(this,"error"))
	this.client_.on("close",this.emit.bind(this,"close"))
	var self = this;
	this.client_.on('message',function(topic, message,opts){
		if(topic == "__sys__"){
			try{
				var msg = JSON.parse(message);
				if(msg.cmd == "kill"){
					self.disconnect();
					self.emit('connectold');
	
					return;
				}
			}catch(err){

			}
		}
		self.emit('message',topic,message,opts)
	})
}
util.inherits(DMS, events.EventEmitter);
DMS.prototype.disconnect = function(){
	this.client_.end()
}
DMS.prototype.publish=function(topic,msg,callback){
	var opt = {qos: 1, retain: false}
	this.client_.publish(topic,msg,opt,callback);
}
DMS.prototype.subscribe = function(topic,callback){
	var map={}
	if (topic instanceof Array){
		for(var k in topic){
			map[topic[k]]=1
		}
	}else{
		map[topic]=1
	}
	this.client_.subscribe(map,callback);
}
DMS.prototype.unsubscribe = function(topic,callback){
	this.client_.unsubscribe(topic,callback);
}