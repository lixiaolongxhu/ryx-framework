(function($) {
	var cometd = $.cometd;
	$(document).ready(function() {
		
		
		// 连接建立
		function _connectionEstablished() {
			alert("建立连接");
		}

		// 连接断开
		function _connectionBroken() {

		}

		// 连接关闭
		function _connectionClosed() {

		}

		// Function that manages the connection status with the Bayeux server
		var _connected = false;

		function _metaConnect(message) {
			//alert("metaconnect: "+message)
			if (cometd.isDisconnected()) {
				_connected = false;
				_connectionClosed();
				return;
			}

			var wasConnected = _connected;
			_connected = message.successful === true;

			if (!wasConnected && _connected) {
				_connectionEstablished();
			} else if (wasConnected && !_connected) {
				_connectionBroken();
			}
		}
		
		// 握手
		function _metaHandshake(handshake) {
			alert("handshake.successful:   "+handshake.successful);
			
			if (handshake.successful === true) {
				cometd.batch(function() {
					alert("comet.batch");
					cometd.subscribe('/notify123', function(message) {
						alert("/notify="+message);
						//这里收到消息
					//	if (controller.alarmList) {
						//	controller.alarmList.onAlarm();
					//	}
					});
					cometd.subscribe('/video123', function(message) {
						alert("/video="+message);
						//这里收到消息
						var json = Ext.decode(message.data);
						debugger;
						var notice = '设备：<br>';
						switch(json[0].state){
						case 1:
							state = '已连接';
							icon = Ext.Msg.INFO;
							break;
						case 2:
							state = '已断开';
							icon = Ext.Msg.ERROR;
							break;
						}
						for(var i = 0;i < json.length; i++){
							var state;
							var icon;
							notice += json[i].resName + ',处于' + state + '状态！<br>';
						}
						
						Ext.Msg.show({
							title : '提示',
							msg : notice,
							buttons : Ext.Msg.OK,
							icon : icon,
							scope : this,
							fn : function(btn) {
								if (btn == 'ok') {					
									return false;
								}
							}
						 });
						
					});
				});
			}
		}

		$(window).unload(function() {
			cometd.disconnect(true);
		});
		
		//是否使用websocket
		cometd.websocketEnabled = false;
		
		var cometURL = location.protocol + "//" + location.host + config.contextPath + "/cometd";
		cometd.configure({
			url : "http://localhost:8080/cometd",
			maxBackoff : 864000,
			logLevel : 'debug'
		});
		
		cometd.addListener('/meta/handshake', _metaHandshake);
		cometd.addListener('/meta/connect', _metaConnect);

		cometd.handshake();
		

	
		
	});
})(jQuery);
