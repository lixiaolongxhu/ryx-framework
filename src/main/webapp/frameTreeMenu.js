/**
 * 程序主入口
 */
Ext.onReady(function() {
			/**
			 * 上,panel.Panel
			 */
			this.topPanel = Ext.create('Ext.panel.Panel', {
						region : 'north',
						height : 55
					});
			/**
			 * 左,panel.Panel
			 */
			this.leftPanel = Ext.create('Ext.panel.Panel', {
						region : 'west',
						title : '导航栏',
						width : 230,
						layout : 'accordion',
						collapsible : true
					});
			/**
			 * 右,tab.Panel
			 */
			this.rightPanel = Ext.create('Ext.tab.Panel', {
						region : 'center',
						layout : 'fit',
						tabWidth : 120,
						deferredRender : false,  
       		 			activeTab : 0,  
       					resizeTabs : true, // turn on tab resizing  
       					minTabWidth : 115,  
       					tabWidth : 135,  
        				enableTabScroll : true ,
        				id :0,
						items : [{
									title : '首页'
								}]
					});
			/**
			 * 组建树
			 */
			var buildTree = function(json) {
				//alert(json);
				return Ext.create('Ext.tree.Panel', {
							
						
							 border: false,  //边框
				              
				               enableDD: true,
				               rootVisible: false,  //隐藏根节点
				               useArrows:true, //树节点使用箭头
				              containerScroll: true,
				               collapsible: false,
				               autoScroll: false,                
				                //singleExpand:true   //展示单个子节点，其它的子节点合并。
							store : Ext.create('Ext.data.TreeStore', {
								
				                // 数据代理
							    nodeParam : 'parentId',  //这个属性是异步加载主要特征，通过该节点去请求子节点
							 // 根节点的参数值是0
				                defaultRootId : 0,
				               
							    proxy : {
							    	type : 'ajax',
							 	    url : 'ui/manage/user/permissionMenu',
							 	 	folderSort: true,
					                sorters: [{
					                    property: 'name',
					                    direction: 'ASC'
					                }]
							    },
							    reader : {
								      type:'json'
								    },
							 // 设置根节点
								  root : {
								    //text : '根节点',
								     //id : '-1',
								    expanded : true
								  }
								
							})
							,
							listeners : {
								itemclick: function(view, record, item,
										index, e) {
								 
								 //	alert(record.get('leaf'));
								 //	alert(record.raw.id)	
											var id =record.raw.id+record.raw.text;
								 var n = rightPanel.getComponent(id);  
			                   //  alert("n="+n)
                                 if (!n &&  record.raw.leaf==true) { // 判断是否已经打开该面板  
                                           n = rightPanel.add({  
                                                'id' : id,  
                                                'title' : record.raw.text,  
                                                 closable : true, // 通过html载入目标页  
                                                 html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="'+record.raw.id+'"></iframe>'  
                                           
                                            });  
                                  }  
                                  rightPanel.setActiveTab(n);   
								}
							}
						});
			};
			/**
			 * 加载菜单树
			 */
			Ext.Ajax.request({
						url : 'ui/manage/user/permissionMenu',
						success : function(response) {
							var json = Ext.JSON.decode(response.responseText)
							
							
							leftPanel.add(buildTree(json))
							Ext.each(json, function(el) {
										var panel = Ext.create(
												'Ext.panel.Panel', {
													id : el.id,
													title : el.name,
													layout : 'fit'
												});
									//	alert(el);
								
										
									//	panel.add(buildTree(el));
									leftPanel.add(panel);
							});
						},
						failure : function(request) {
							Ext.MessageBox.show({
										title : '操作提示',
										msg : "连接服务器失败",
										buttons : Ext.MessageBox.OK,
										icon : Ext.MessageBox.ERROR
									});
						},
						method : 'post'
					});
			/**
			 * Viewport
			 */
			Ext.create('Ext.container.Viewport', {
						layout : 'border',
						renderTo : Ext.getBody(),
						items : [this.topPanel, this.leftPanel, this.rightPanel]
					});
		});

	