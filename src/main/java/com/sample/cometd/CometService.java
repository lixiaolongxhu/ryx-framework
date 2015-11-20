/*
 * Copyright (c) 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sample.cometd;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.LocalSession;
import org.cometd.bayeux.server.ServerChannel;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.annotation.Service;
import org.cometd.annotation.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@Singleton
@Service("cometService")
public class CometService {
	
	private static final Logger log=LoggerFactory.getLogger(CometService.class);
	
	@Inject
	private BayeuxServer bayeux;

	@Session
	private ServerSession serverSession;

	@Session
	private LocalSession localSession;

	@PostConstruct
	public void init() {

	}
	

	// 服务器广播
	public void clientNotify(Object msg) {
		log.info("调用  cometService   clientNOtify   == " + msg);
		ServerChannel channel = this.bayeux.getChannel("/notify123");
		if (channel != null) {
			ServerMessage.Mutable message = this.bayeux.newMessage();
			message.setChannel("/notify123");
			message.setData(msg);
			channel.publish(this.serverSession, message);
		}

	}
	public void videoChannelNotify(Object msg){
		ServerChannel channel = this.bayeux.getChannel("/video123");
		if (channel != null) {
			ServerMessage.Mutable message = this.bayeux.newMessage();
			message.setChannel("/video123");
			message.setData(msg);
			channel.publish(this.serverSession, message);
		}
	}
//	
//	@org.cometd.annotation.Listener("/notify")
//    public void echo(ServerSession remote, String msg)
//    {
//		ServerMessage.Mutable message = this.bayeux.newMessage();
//		message.setChannel("/notify");
//		message.setData(msg);
//        remote.deliver(serverSession, message);
//    }

}
