/* 
 * 通用的资源Grid
 * 这里只提供资源列表的基本框架
 * 该资源列表可以用户管理员界面和监控界面，具体的行为由相关的Controller进行控制
 */

Ext.define('RYIVS.view.common.LeftMenu', {
	requires: 'RYIVS.store.common.LeftMenu',
	extend : 'Ext.grid.Panel',
	alias : 'widget.layerLeftMenu',
	hideHeaders: true,
	title : '资源',
	iconCls: 's_resource',
	stores: 'RYIVS.store.common.LeftMenu',
 // 定义 autoload
	autoload : true,
      dockedItems: [{
          dock: 'top',
          xtype: 'toolbar',
          items: [{
              tooltip: 'Toggle the visibility of the summary row',
              text: 'Toggle Summary',
              enableToggle: true,
              pressed: true,
              handler: function(){
                  var view = grid.getView();
                  showSummary = !showSummary;
                  view.getFeature('group').toggleSummaryRow(showSummary);
                  view.refresh();
              }
          }]
      }],
      features: [{
          id: 'group',
          ftype: 'groupingsummary',
          groupHeaderTpl: '{name}',
          hideGroupedHeader: true,
          enableGroupingMenu: false
      }],
      columns: [{
          text: 'Task',
          flex: 1,
          tdCls: 'task',
          sortable: true,
          dataIndex: 'description',
          hideable: false,
          summaryType: 'count',
          summaryRenderer: function(value, summaryData, dataIndex) {
              return ((value === 0 || value > 1) ? '(' + value + ' Tasks)' : '(1 Task)');
          }
      }, {
          header: 'Project',
          width: 180,
          sortable: true,
          dataIndex: 'project'
      }]
});
