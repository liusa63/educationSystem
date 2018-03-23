/*
 * Grid
 */

(function($) {
    $.uedWidget('ued.Grid', {
        options : /**@lends Grid# */
        {
            /**
             *@example
             * $('#ued-grid').uedGrid({
             * 	tableHead:sampleCol,
             * 	tableBody:sampleData
             * });
             */
			tableHead : null, 
			thead : null,
            //totalHead : null, //琛ㄥご锛堟瘡涓�垪鐨勫搴﹀繀椤讳紶锛�
            tableBody : null, //鏁版嵁锛堥�杩噆ey鏉ュ尮閰嶅埌瀵瑰簲鐨勫垪涓婏級
			tbody : null,
			headCount : 1, //澶撮儴琛屾暟锛岄粯璁や负1
            nowrap : true, //鏄惁鑷姩鎹㈣锛岄粯璁や负true
            checkbox : null, /*鏄惁鍚敤棣栧垪checkbox鍒楋紝涓�粡鍚敤锛岃嚜鍔ㄥ喕缁�濡傛灉鏄鏉傜殑checkbox鍒欎紶鍏ヤ笅鎷夎彍鍗曠殑dom
             {
				 single : false,//
				 obj : null//
             }
			 {
				single : false,
				obj:{
					getObj:function(obj){
						 console.log(obj)
					},
					data : data
				}
			}
			 */
            operator : null, //鏄惁鍚敤灏惧垪鎿嶄綔鍒楋紝涓�粡鍚敤锛岃嚜鍔ㄥ喕缁擄紝濡傛灉鏈夊垯浼犲叆dom
			/*
				{
					type : "normal",//panel涓轰笅鎷夐潰鏉匡紝normal涓烘搷浣滄澘
					width : 200
				}
				{
					type : "panel"//panel涓轰笅鎷夐潰鏉匡紝normal涓烘搷浣滄澘
				},
			*/
			height : 300, //琛ㄦ牸楂樺害锛岄粯璁や负300
			widthResize : true,
            options : null,
            settings : null,
            pagination : {},
            sortCallBack : null,
			defaultSortType : 'desc'
        },
        _create : function() {
            var $el = this.element, options = this.options, self = this;
			
            $el.addClass("uew-table");
			//=======鍒ゆ柇鍗曞厓鏍煎唴瀹规槸鍚﹀厑璁告崲琛�=======
            if (options.nowrap) {
                $el.addClass("uew-table-nowrap");
            }
			options.tableHead = options.thead || options.tableHead;
			options.tableBody = options.tbody || options.tableBody;
			//瀹氫箟缁勪欢鍐呴儴灞炴�
			var _define = this._define = {};
			_define.tableHead = options.tableHead;
			_define.blankWidth = 10;//瀹氫箟绌虹櫧鍒楃殑鏈�皬瀹藉害
			this.$domCache = {};//缂撳瓨甯哥敤dom鑺傜偣
			//缁樺埗琛ㄦ牸DOM鍏冪礌,chrome 8.5ms,IE骞冲潎38ms
			this._createTableDom($el, options, _define);
			//鍒濆鍖栬〃鏍兼暟鎹�
			this.setData(options.tableBody, options.tableHead);
			//缁戝畾琛ㄦ牸鎿嶄綔浜嬩欢
			this._bindEvent($el, options);
			
        },
		_createTableDom : function($el, options, _define){
			var settings = options.settings, options = options.options, $domCache = this.$domCache;
			//********缁樺埗鎿嶄綔鏉�******
			var $optBar = $("<div class='uew-table-optBar'></div>");
			
			//缁樺埗宸︿晶鎿嶄綔IE 15ms chrome 1ms
			if(options){
				this._setOptData($optBar,options); 
			}
			//缁樺埗鍙充晶璁剧疆IE 16ms chrome 1ms
			if(settings){
				var $setting = $("<div class='uew-table-setting'></div>");
				for(var i = settings.length - 1; i >= 0; i--){
					var setting = settings[i], type = setting.type;
					
					if(type){
						//缁樺埗琛ㄦ牸瀹氬埗
						if(type == "custom" && this.options.headCount == 1){
							$button = $("<button type='button' class='__customBtn ue-button ue-state-default long3'><span class='ue-btn-icon btn-icon-table-draft'></span><span class='btn-text'>瀹氬埗</span></button>");
							//淇濆瓨琛ㄦ牸瀹氬埗鎸夐挳鎵�互
							_define.customIndex = i;
							_define.sequence = setting.sequence;
							_define.currentSequence = setting.sequence;
							if(!settings[i].defaultSequence && this.options.tableHead){
								setting[i].defaultSequence = this._getAllSequence();
							}
						}else if(type == "fullScreen"){
							$button = $("<button type='button' class='ue-button ue-state-default long3'><span class='ue-btn-icon btn-icon-full-screen'></span><span class='btn-text'>鍏ㄥ睆</span></button>");
							_define.fullScreenIndex = i;	
						}else if(type == "rowCount"){
							$button = $('<select class="rowSelect" width="70" unit="鏉�></select>');
							_define.rowCountIndex = i;
						}else{
							throw new Error("Wrong Settings Type");
						}
					}else{
						throw new Error("Wrong Settings Type");
					}
                    $setting.append($button);
                    
				}
				$optBar.append($setting);
				//濉厖璁剧疆鏁版嵁
				this._setSettingData($setting,_define.rowCountIndex, settings,$setting);
			}

			if($optBar.html() != ""){
				$el.append($optBar);
				//鍒濆鍖杝elect
				$optBar.find('.rowSelect').uedSelect();
			}
			
			options = this.options;
			//******缁樺埗琛ㄦ牸panel鍖哄煙********
			var $tablePanel = $domCache.$tablePanel = $('<div class="uew-table-panel __panel"></div>');
			//缁樺埗琛ㄦ牸澶撮儴
			var $tableThead = $domCache.$tableThead = $('<div class="uew-table-thead"></div>');
			//鏄惁鏈塩heckbox灞炴�
			if(options.checkbox){
				$el.addClass('uew-table-fixed-checkbox');
				var $tableFront = $('<div class="__theadFront table-front-fixed"></div>');
				if(options.headCount == 1){
					var $table = $('<table><thead><tr><th class="uew-table-checkbox"><div class="uew-table-thTitle"><input type="checkbox"></div></th></tr></thead></table>');
				}else{
					var $table = $('<table><thead><tr><th class="uew-table-checkbox" rowspan="2"><div class="uew-table-thTitle"><input type="checkbox"></div></th></tr></thead></table>');
				}
				if(options.checkbox.disable){
					$table.find('input[type=checkbox]').attr('disabled','disabled');
				}
				if(!options.checkbox.single){
					$table.find('.uew-table-thTitle').append('<a href="javascript:;" class="ue-state-default"><span class="__optPanelBtn uew-icon uew-icon-triangle-1-s"></span></a>');
					var $optPanelBtn = $('.__optPanelBtn',$table)
					var $optPanel = $('<div class="__optPanel"></div>');
					var obj = options.checkbox.obj;

					$el.append($optPanel);
					obj.opter = [$optPanelBtn];
					$optPanel.uedOptPanel(obj);
					$optPanelBtn.bind("click", function() {
						$optPanel.uedOptPanel("setPosition", $(this).offset().left-25, $(this).offset().top+$el.find(".__optPanelBtn").height()+1);
						$optPanel.uedOptPanel("open");
					});
					
				}
				$tableFront.append($table);
				$tableThead.append($tableFront);
			}
			//缁樺埗琛ㄦ牸澶撮儴鏄剧ず鍒梩able
			var $headMain = $domCache.$headMain =  $('<div class="__theadMain uew-table-main"><table><thead><tr></tr></thead></table></div>');
			$tableThead.append($headMain);
			//缁樺埗琛ㄦ牸鍐呴儴鍙充晶鎿嶄綔鍖哄煙
			if(options.operator){
				$el.addClass('uew-table-fixed-opt');
				if(options.headCount == 1){
					var $theadFianl = $('<div class="__theadFinal table-finale-fixed"><table><thead><tr><th class="uew-table-operation"><div class="uew-table-thTitle">鎿嶄綔</div></th></tr></thead></table></div>');
				}else{
					var $theadFianl = $('<div class="__theadFinal table-finale-fixed"><table><thead><tr><th class="uew-table-operation" rowspan="2"><div class="uew-table-thTitle">鎿嶄綔</div></th></tr></thead></table></div>');

				}
				$tableThead.append($theadFianl);
			}
			$tablePanel.append($tableThead);

			//********缁樺埗琛ㄦ牸涓讳綋鍐呭鍖哄煙*********
			var height = options.height == 'auto'? 'auto' : (options.height+5)+'px';

			var $tableTbody = $domCache.$tableTbody = $('<div class="uew-table-tbody uew-scroll-webkit" style="height:'+ height +'"></div>');
			if(options.checkbox){
				if(options.headCount == 2){
					var $tbodyFront = $('<div class="__tbodyFront table-front-fixed"><table><thead><tr><th>1</th></tr><tr><th style="height:34px;">1</th></tr></thead><tbody class="__bodyfront"></tbody></table></div>');
				}else{
					var $tbodyFront = $('<div class="__tbodyFront table-front-fixed"><table><thead><tr><th>1</th></tr></thead><tbody class="__bodyfront"></tbody></table></div>');
				}
				
				$tableTbody.append($tbodyFront);
				//瀛樺偍checkbox鑺傜偣瀵硅薄
				$domCache.$tbodyFront = $tbodyFront;
			}
			if(options.operator){
				if(options.headCount == 2){
					var $tbodyFinal = $('<div class="__tbodyFinal table-finale-fixed"><table><thead><tr><th>1</th></tr><tr><th style="height:34px;">1</th></tr></thead><tbody class="__bodyfinal"></tbody></table></div>');
				}else{
					var $tbodyFinal = $('<div class="__tbodyFinal table-finale-fixed"><table><thead><tr><th>1</th></tr></thead><tbody class="__bodyfinal"></tbody></table></div>');
				}
				$tableTbody.append($tbodyFinal);
				//瀛樺偍鎿嶄綔琛岃妭鐐瑰璞�
				$domCache.$tbodyFinal = $tbodyFinal;
			}
			var $tableMain = $('<div class="__tbodyMain uew-table-main"><table><thead></thead><tbody class="__data"></tbody></table></div>');
			$tableTbody.append($tableMain);
			
			//缁樺埗鏃犳暟鎹拰鍔犺浇涓�
			var $tableNoData = $domCache.$tableNoData = $('<div style="display:none;" class="uew-nodata-tip">鏃犳暟鎹�/div>');
			$tableTbody.append($tableNoData);
			var $tableLoading = $domCache.$tableLoading = $('<div style="display:none;" class="uew-table-loading">鏁版嵁鍔犺浇涓�..</div>');
			$tableTbody.append($tableLoading);

			$tablePanel.append($tableTbody);
			//缁樺埗琛ㄦ牸妯粴鍔ㄦ潯鍖哄煙
			var $tableScroll = $('<div class="__tablescroll uew-table-scroll-horizontal uew-scroll-webkit"><div></div></div>')
			$tablePanel.append($tableScroll);
			var $division = $domCache.$division = $('<div class="uew-table-division"></div>');
			$tablePanel.append($division);
			$domCache.$tableScroll = $tableScroll;//缂撳瓨婊氬姩鏉¤妭鐐�
			$el.append($tablePanel);

			//缁樺埗鍒嗛〉鍖哄煙
			$paginatObj = $('<div></div>');
			$el.append($paginatObj);
			this.$paginatObj = $paginatObj;
			this._createPagination(options.pagination);
		},
		/*
		 * 濉厖琛ㄦ牸鎿嶄綔鏉℃暟鎹俊鎭�
		 */
		_setOptData : function($optBar,options){
			for(var i = 0, len = options.length; i < len; i++){
				var option = options[i];
                var $button = $("<button type='button' class='ue-button ue-state-default long" + parseInt(option.label.length + 1, 10) + "'><span class='" + option.ico + "'></span><span class='btn-text'>" + option.label + "</span></button>");
				if(option.alwaysEnable){
					$button.attr('alwaysEnable','alwaysEnable');
				}
                $optBar.append($button);
			 }
		},
		/*
		 * 濉厖琛ㄦ牸璁剧疆鏁版嵁淇℃伅(鐩墠涓昏鏄樉绀鸿鏁拌缃�
		 */
		_setSettingData : function($setting,index,settings){
			var pagination = this.options.pagination, _define = this._define, self = this;
			if(index >= 0){
				$button = $setting.find('.rowSelect');
				var tempOption = '', setting = settings[index], itemArray = setting.item;
				if(pagination && pagination.perPageRecord){
					var perPageRecord = pagination.perPageRecord;
				}else{
					var perPageRecord = setting.perPageRecord;
				}
				if(perPageRecord){
					var inarray = $.inArray(perPageRecord,itemArray);//鏌ョ湅褰撳墠姣忛〉鏄剧ず鐨勮鏁版槸鍚﹀湪鍐�
					if(inarray < 0){
						itemArray.push(perPageRecord);
					}
				}
				itemArray.sort(function(a,b){return a - b;});//鎺掑簭锛屼粠灏忓埌澶с�
				inarray = $.inArray(perPageRecord,itemArray);
				for (var j=0,k=itemArray.length; j < k; j++) {
					if(j == inarray){
						tempOption += '<option selected="selected">'+perPageRecord+'</option>';
					}else{
						tempOption += '<option>'+setting.item[j]+'</option>';
					}
					
				};
				$button.append(tempOption);
				
				$button.bind('change',function(){
					var perPageRecord = parseInt($(this).val(),10);
					var currentPage = self.$paginatObj.uedPagination('option','currentPage');//鑾峰彇褰撳墠椤电爜
					var newCurrentPage = Math.ceil(((currentPage-1) * pagination.perPageRecord + 1)/perPageRecord);
					//璁剧疆鍒嗛〉
					pagination.perPageRecord = perPageRecord;
					self.setPagination(pagination);
					setting.callback.call({},newCurrentPage, perPageRecord);//鎵ц琛屾暟鏀瑰彉鏃跺洖璋冦�
					//琛ㄦ牸楂樺害涓篴uto鏃堕渶瑕佽缃珮搴�
					if(self.options.height == "auto"){
						self.$domCache.$tableTbody.height(self.$domCache.$tableTbody.children().height());
					}
				});
			}
			if(_define.customIndex >= 0){//鏈夎〃鏍煎畾鍒�
				//鍒涘缓琛ㄦ牸瀹氬埗鑺傜偣
			var $customBuiltTable = $('<div class="custom-built-table-dialog"><div class="custom-built-table">'+
				'<div class="custom-built-table-tip ue-text-level3"><span class="uew-icon2 uew-icon2-tip"></span><label>灏忚创澹細</label>鐩存帴鐐归�鎮ㄦ兂瀹氬埗鐨勫垪锛屽啀娆＄偣鍑昏〃绀哄彇娑堥�鎷�/div>'+
				'<h6>'+
					'閫夋嫨鎴戣瀹氬埗鐨勫垪'+
					'<span class="ue-text-level3">(鍏�span class="impInfo"></span>鍒楋紝宸查�<span class="impInfo uew-dialog-selected">0</span>鍒楋紝鏈�匠鏄剧ず6-8鍒�</span>'+
					'<a href="javascript:;" class="ue-state-default defaultSequence">'+
						'<span class="uew-icon uew-icon-circle-arrow-west"></span>杩樺師鑷崇郴缁熼粯璁�'+
					'</a>'+
				'</h6></div></div>');
				this.$domCache.$customTable = $customBuiltTable;
				this._createBuiltCol($customBuiltTable);
				this._createBuiltColSelected($customBuiltTable);
			}
			
		},
		_createBuiltCol : function($customBuiltTable){
			var $customBuiltCol = $('<div class="built-table-col">'+
				'<div class="built-table-lshadow"></div>'+
				'<div class="built-table-tshadow"></div>'+
				'<ul class="uew-scroll-webkit"></ul>'+
			'</div>');
			$customBuiltCol.append($('<a href="javascript:;" class="__builtSwitch ue-state-default built-table-switchBtn">'+
					'鐐瑰嚮鍒囨崲鍒版帓搴忔ā寮�'+
				'</a>'
			));
			$customBuiltTable.find(".custom-built-table").append($customBuiltCol);
		},
		
        _createBuiltColSelected : function($customBuiltTable){
			 var $customBuiltColSelected = $('<div class="built-table-colSelected" style="display:none;">'+
				'<div class="built-table-lshadow"></div>'+
				'<div class="built-table-tshadow"></div>'+
				'<ul class="built-table-colBg"></ul>'+
			'</div>');
			var bgLi = [];
			for(var i = 1;i <= 40;i++){
				if(i < 10){
					i = "0" + i;
				}
				bgLi.push('<li>' + i + '</li>');
			}
			$customBuiltColSelected.find(".built-table-colBg").append(bgLi.join(''));
			$customBuiltColSelected.append($('<ul class="built-table-selected"></ul>'));
			$customBuiltColSelected.append($('<a href="javascript:;" class="ue-state-default built-table-switchBtn">'+
					'鐐瑰嚮鍒囨崲鍒伴�鎷╁垪妯″紡'+
				'</a>'));
			$customBuiltTable.find(".custom-built-table").append($customBuiltColSelected);
		},
		/*
		 * 鍒濆鍖栬〃鏍兼暟鎹�
		 * @param {Array} data_  琛ㄦ牸浣撴暟鎹�
		 * @param {Array} head_  琛ㄦ牸澶撮儴鏁版嵁
		 */
		setData : function(data_, head_){
			var options = this.options, $el = this.element, _define = this._define, data = [], head = [];
			$.extend(true, data, data_);
			options.tableBody = data;
			if(head_ && head_.length){//鏈夊ご閮ㄦ暟鎹�
				$.extend(true, head, head_);
				if(this._isType(head[0], "Object")){
					//璁＄畻琛ㄦ牸澶撮儴鍚勫垪瀹藉害
					_define.tableWidth = this._calculateWidth(head);//璁板綍琛ㄦ牸鐨勫疄闄呭搴�
					//鏇存柊琛ㄥご鏁版嵁
					options.tableHead = _define.tableHead = head;
					//濡傛灉鏈夎〃鏍煎畾鍒�
					if(_define.customIndex >= 0){
						//鑾峰彇闇�灞曠ず鐨勫垪
						this._getTableHead(options, _define.customIndex, _define.currentSequence);
						this._setCustomPanelData(head, _define.currentSequence);
					}
				}else if(this._isType(head[0], "Number")){
					_define.sequence = head;
					if(!options.settings[_define.customIndex].defaultSequence && options.tableHead){
						options.settings[_define.customIndex].defaultSequence = this._getAllSequence();
					}
					this._getTableHead(options,_define.customIndex,_define.sequence);//閲嶆柊璁＄畻
				}
				//缁樺埗琛ㄦ牸澶撮儴
				this._setTableHeadData($el,_define);
					
				options.widthResize && this._dragTable($el,options);
				
			}
			//鏍规嵁鎯呭喌锛屾帶鍒舵樉闅愩�
			this._controlShowOrHide($el,options);
			if(options.tableBody && options.tableBody.length){
				_define.operatorData = [];
				this._setTableBodyData($el,data);
				this._bindTableEvent();
				this._adjustTable($el, options);
			}else{
				var currentTableWidth = _define.tableWidth + _define.blankWidth + 6;
				this.$domCache.$tableScroll.show().children().width(currentTableWidth);
			}
			$el.find('.uew-table-thead').find('input[type=checkbox]').attr('checked',false);
		},
		_getTableHead : function(options,index,sequence){
			/**鏍规嵁tableHead鍜岃〃鏍煎畾鍒剁殑搴忓垪鏉ヨ幏鍙栬〃澶村唴瀹�*/
			var tempHead = [], tempWidth = 0, _define = this._define;
			for(var j = 0,k = sequence.length; j < k; j++){
				tempHead.push(options.tableHead[sequence[j]]);
				tempWidth += (options.tableHead[sequence[j]].width+1);
			}	
			_define.tableWidth = tempWidth;
			if(tempHead.length){
				_define.tableHead = tempHead;//瀹為檯闇�灞曠ず鐨勮〃鏍煎垪
			}
		},
		_calculateWidth : function(tableHead){
			//===============濡傛灉娌℃湁浼犻�width,涓烘瘡涓�垪璁剧疆榛樿瀹藉害涓�00=============
			var options = this.options;
			var tempTotalWidth = 0;
			if(options.headCount == 1){
				for (var i = 0,j = tableHead.length; i < j; i++) {
					var tempObj = tableHead[i];
					if (!tempObj.width && !tempObj.minWidth) {//澧炲姞瀵筸inWidth鏀寔 add 2013-5-27
						tableHead[i].width = 100;
					}else if(tempObj.minWidth){
						tableHead[i].width = tempObj.minWidth;
					}
					var tempdiv = $('<div></div>');//鏂板瑙ｅ喅澶翠负html鑺傜偣鏃禸ug
					tempdiv.html((tempObj.label));
					var text = tempdiv.text();
					if (tempObj.width < (text.length * 14 + 31)) {
						tableHead[i].width = text.length * 14 + 31;
					}
					tempTotalWidth += (tempObj.width+1);
				}
			}else{
				var length = 0, _define = this._define;//璁板綍鍙屽ご琛ㄦ牸瀹為檯灞曠ず鐨勫垪.
				_define.headData = [];
				for(var i = 0,j = tableHead.length; i < j; i++){
					var children = tableHead[i].children;
					var width = tableHead[i].width;
					var childTotalWidth = 0;
					if(children){
						for(var k = 0;k<children.length;k++){
							length++;
							var childWidth = children[k].width;
							if(!childWidth && !children[k].minWidth){//澧炲姞瀵筸inWidth鏀寔 add 2013-5-27
								childWidth = 100;	
							}else if(children[k].minWidth){
								childWidth = children[k].minWidth;
							}
							if (childWidth < children[k].label.length * 14 + 31) {
								childWidth = children[k].label.length * 14 + 31;
							}
							childTotalWidth += (parseInt(childWidth,10)+1);
							children[k].width = childWidth;
							_define.headData.push(children[k]);
						}
					}else{
						length++;
						if(tableHead[i].minWidth){
							tableHead[i].width	= tableHead[i].minWidth;
						}
						_define.headData.push(tableHead[i]);
					}
					
					width = width > childTotalWidth ? width : childTotalWidth;
					tableHead[i].width = width; 
					tempTotalWidth += width;
				}

				_define.headCountLength = length;
			}
			return tempTotalWidth;	
		},
		/*
		 * 濉厖瀹氬埗寮圭獥鐨勬暟鎹�
		 */
		_setCustomPanelData : function(tableHead,sequence){
			var tempLi = [], $customTable = this.$domCache.$customTable, self = this, options = this.options, $el = this.element;
			this._define.tempSequence = self._copyArray(sequence);
			for(var i = 0,j = tableHead.length;i < j;i++){
				var tempdiv = $('<div></div>');//鏂板瑙ｅ喅澶翠负html鑺傜偣鏃禸ug
				tempdiv.append(tableHead[i].label);
				var text = tempdiv.text();
				if($.inArray(i,sequence) >= 0){
					tempLi.push('<li class="ue-state-selected">' + text + '</li>');
				}else{
					tempLi.push('<li>' + text + '</li>');
				}
				
			}
			$customTable.find('.impInfo').eq(0).text(tableHead.length);
			$customTable.find('.uew-dialog-selected').text(sequence.length);
			$customTable.find('.built-table-col').find("ul").empty().append(tempLi.join(''));	
			this._initSequence();
			//缁戝畾鎭㈠榛樿浜嬩欢
			$customTable.find('.defaultSequence').click(function(){
				var _define = self._define, $selected = $customTable.find('.uew-dialog-selected');
				var sequence = _define.sequence = self._copyArray(options.settings[_define.customIndex].defaultSequence);
				_define.tempSequence = self._copyArray(_define.sequence);
				$customTable.find('.built-table-col').find('li').removeClass('ue-state-selected');
				for(var i = 0,k = sequence.length; i < k; i++){
					$customTable.find('.built-table-col').find('li').eq(sequence[i]).addClass('ue-state-selected');//閲嶆柊缁樺埗閫変腑鐨勫厓绱�
				}
				$selected.text(sequence.length);
				self._initSequence(sequence);
				
			});
			var $builtTableCol = $customTable.find(".built-table-col");
			var switchFlag = false;
			$customTable.find(".built-table-switchBtn").click(function(){
				if(switchFlag){
					$builtTableCol.show();
					$customTable.find(".built-table-colSelected").hide();
					switchFlag = false;
				}else{
					$builtTableCol.hide();
					$customTable.find(".built-table-colSelected").show();
					switchFlag = true;
				}
			});
			
			$customTable.find(".built-table-col").find("li").click(function(e){
				var sequence = self._define.sequence, $selected = $customTable.find('.uew-dialog-selected');
				if($(this).hasClass("ue-state-selected") && $builtTableCol.find('.ue-state-selected').size() > 1){//鑷冲皯瑕佷繚瀛樹竴涓�
					$(this).removeClass("ue-state-selected");
					
					$selected.text(parseInt($selected.text(),10)-1);
					//绉婚櫎
					self._define.tempSequence = self._copyArray(self._define.tempSequence.remove($(this).index()));
				}else if(!$(this).hasClass("ue-state-selected") && self._define.tempSequence.length < 40){
					$(this).addClass("ue-state-selected");
					
					$selected.text(parseInt($selected.text(),10)+1);
					//鏂板
					self._define.tempSequence.push($(this).index());
				}
				self._initSequence(self._define.tempSequence);
			});
			
			if(!this.$dialog){
				$("body").append($customTable);
				this.$dialog = $customTable.uedDialog({
					title : "琛ㄦ牸瀹氬埗", 
					width : 632,
					height : 470,
					modal : false,                  //鏄惁鏈夐伄缃�榛樿涓簍rue
					position:['center',$(window).scrollTop() + $(window).height()/2 - $customTable.height()/2-30],            	 //寮圭獥鍦ㄥ睆骞曚腑鐨勪綅缃紝榛樿涓哄眳涓�
					autoOpen:false,                 //榛樿寮圭獥鏄惁鎵撳紑锛岄粯璁や负false
					buttons : [{
						"label" : "纭畾",
						recommend : true,       //鎸夐挳鏄惁涓烘帹鑽愮偣鐨勬寜閽�
						callBack : function($dialog, $mask) {
						   if(self._define.currentSequence.toString() != self._define.tempSequence.toString()){//澧炲姞鍒ゆ柇瀹氬埗淇℃伅鏄惁鏀瑰彉
							 var currentPage = $(".uew-pagination",$el).uedPagination('option','currentPage');
							 self._define.currentSequence = self._copyArray(self._define.tempSequence);
							 options.settings[self._define.customIndex].callback(self._define.currentSequence,currentPage);
						   }
						   $customTable.uedDialog('close');
						}
					}, {
						"label" : "鍙栨秷",
						callBack : function($dialog, $mask) {
						   $customTable.uedDialog('close');
						}
					}]
				});
				
			}
			
		},
		_initSequence : function(sequence){
			var $el = this.element, options = this.options, self = this, tableHead = this._define.tableHead, sequence = sequence || this._define.currentSequence, $customTable = this.$domCache.$customTable;	
			var $builtTableColSelected = $customTable.find(".built-table-colSelected");
			var $builtTableSelected = $builtTableColSelected.children(".built-table-selected");
			$builtTableSelected.empty();
			var sequenceLi = [];
			for(var i = 0;i < sequence.length;i++){
				var tempdiv = $('<div></div>');//鏂板瑙ｅ喅澶翠负html鑺傜偣鏃禸ug
				tempdiv.html((options.tableHead[sequence[i]].label));
				var text = tempdiv.text();
				sequenceLi.push('<li position=' + i + ' sequence=' + sequence[i] + '>'+
					'<a href="javascript:;" title="' + text + '">'+
						'' + text + '<span class="ue-state-default">'+
							'<span class="uew-icon uew-icon-close"></span>'+
						'</span>'+
					'</a>'+
				'</li>');
			}
			$builtTableSelected.append(sequenceLi.join(''));
			//缁戝畾浜嬩欢
			$builtTableSelected.find("a").on("mousedown",downHandler);
			
			function downHandler(mde){
				mde.preventDefault();
				if($(mde.target).hasClass('ue-state-default') || $(mde.target).hasClass('uew-icon-close')){
					return false;
				}
				var $dragging = $(this);
				$dragging.addClass("ue-state-focus");
				$dragging.parent("li").css("position","relative").css("z-index","10");
				/**澧炲姞瀵笽E鐨勬敮鎸�*/
				$builtTableColSelected.bind("mousemove",function(mme){
					mme.preventDefault();
					$dragging.offset({
						left : mme.clientX - mde.offsetX,
						top : mme.clientY - mde.offsetY
					});						
				});
				$dragging.bind("mouseup",function(mue){
					$builtTableColSelected.unbind("mousemove");
					
					var relativeX = $dragging.offset().left - $builtTableColSelected.offset().left;
					var relativeY = $dragging.offset().top - $builtTableColSelected.offset().top;									
					
					var targetPosition = parseInt(relativeX / options.cellWidth,10) +  parseInt(relativeY / options.cellHeight,10) * 4;
					var maxPosition = $builtTableSelected.find('li').size()-1;
					targetPosition = targetPosition > maxPosition ? maxPosition : targetPosition;
					self._adjustAttrPosition($dragging.parent("li").attr("position"),targetPosition,$builtTableSelected);
					if($builtTableSelected.find('li').size() == 1){
						targetPosition = 0;
					}
					$dragging.parent("li").attr("position",targetPosition);
					self._adjustPosition(true);
					
					$dragging.css("left",0).css("top",0).unbind("mouseup").removeClass("ue-state-focus").parent("li").css("z-index","1");
					
					var adjustSequence = [];
					
					$builtTableSelected.find('li').each(function(i){
						$builtTableSelected.find('li').each(function(){
							if($(this).attr("position") == i){
								adjustSequence.push(parseInt($(this).attr("sequence")));
							}
						});
					})
					self._define.tempSequence = adjustSequence;
				});
			};
			
			self._adjustPosition(false);
			$builtTableSelected.off('click.uedGrid');
			$builtTableSelected.on('click.uedGrid','span',function(){//娣诲姞鎺掑簭鐣岄潰鍒犻櫎閫変腑鐨勯」浜嬩欢銆�
				var $li = $(this).parents('li'), sequence = self._define.tempSequence, $customBuiltCol = $customTable.find('.built-table-col');
				var index = $li.index();
				if($builtTableSelected.find('li').size() > 1){
					$li.remove();
					self._define.tempSequence = self._copyArray(sequence.remove(sequence[index]));
					self._initSequence(self._define.tempSequence);
					$customBuiltCol.find('li').eq(sequence[index]).removeClass('ue-state-selected');
					var $selected = self.$domCache.$customTable.find(".impInfo").eq(1);
					$selected.text(parseInt($selected.text(),10)-1);
				}
				return false;	
			});
		},
		/**鍒濆鍖栬〃鏍煎畾鍒跺脊绐�*/
		_initCustomPanel : function($customTable){
			var sequence = this._define.currentSequence;
			$customTable.find(".built-table-col").find("li").removeClass("ue-state-selected")
			for(var j = 0, sequceLength = sequence.length; j < sequceLength; j++){
				$customTable.find(".built-table-col").find("li").eq(sequence[j]).addClass("ue-state-selected");
			}
			
			this._initSequence(sequence);
		},
		_adjustPosition : function(isAnimation){
			var options = this.options, $customTable = this.$domCache.$customTable;
			options.eachWidth = 102;
			options.eachHeight = 26;
			options.cellWidth = 146;
			options.cellHeight = 35;
			var $builtTableColSelected = $customTable.find(".built-table-colSelected");
			$builtTableColSelected.children(".built-table-selected").children("li").each(function(i){
				var top = parseInt($(this).attr("position") / 4, 10);
				var left = parseInt($(this).attr("position") % 4, 10);
				if(isAnimation){
					$(this).animate({
						top : top * options.cellHeight,
						left : left * options.cellWidth
					},500).css("position" , "absolute");	
				}else{
					$(this).css({top : top * options.cellHeight,left : left * options.cellWidth,"position":"absolute"});
				}
				
			})
		},
		_adjustAttrPosition : function(startIndex,endIndex,$builtTableSelected){

			if(startIndex == 0 && $builtTableSelected.find('li').size() == 1){
				$builtTableSelected.find('li').attr('position',0);
				return;
			}
			var self = this;
			//路路琚嫋鎷藉浘鏍囩殑搴忓垪鍙�> 鐩爣鍥炬爣鐨勫簭鍒楀彿锛堝浘鏍囧悜鍓嶉潰绉诲姩锛�
			if(startIndex > endIndex){
				for(var i = startIndex - 1;i >= endIndex;i--){//寰幆姝よ寖鍥村唴鎵�湁鐨勫浘鏍�
					//路路浣跨洰鏍囧浘鏍囧悗闈㈢殑姣忎竴涓浘鏍囷紙闄ゅ幓琚嫋鎷藉浘鏍囷級鐨勫簭鍒楀彿閮藉姞1
					var $temp = self._getLiByPosition(i,$builtTableSelected);
					$temp.attr("position",i + 1);
				}
			}
			//路路琚嫋鎷藉浘鏍囩殑搴忓垪鍙�< 鐩爣鍥炬爣鐨勫簭鍒楀彿锛堝浘鏍囧悜鍚庨潰绉诲姩锛�
			else if(startIndex < endIndex){
				for(var i = startIndex;i <= endIndex;i++){//寰幆姝よ寖鍥村唴鎵�湁鐨勫浘鏍�
					//路路浣胯鎷栨嫿鍥炬爣鍚庨潰鐨勬瘡涓�釜鍥炬爣锛堝寘鎷洰鏍囧浘鏍囷級鐨勫簭鍒楀彿閮藉噺1
					self._getLiByPosition(i,$builtTableSelected).attr("position",i - 1);
				}
			}else{
				return;
			}
		},
		_getLiByPosition : function(position, $builtTableSelected){
			var $target;
			$builtTableSelected.find('li').each(function(){
				if($(this).attr("position") == position){
					$target = $(this);
				}
			});
			return $target;
		},
		/*
	     * 璁剧疆琛ㄦ牸澶撮儴鏁版嵁
		 */
		_setTableHeadData : function($el, _define){
			var options = this.options, tableHead = _define.tableHead;
			this.$minWidthTh = null;
			if(options.headCount == 1){
				var $tableHeadTr = $el.find('.__theadMain tr').empty(), $tableMainHead = $el.find('.__tbodyMain thead').empty().append("<tr></tr>").find('tr'),thArr = [];
				for(var i = 0,len = tableHead.length; i<len; i++){
					var $th = $('<th><div class="uew-table-th" style="width:' + (tableHead[i].width-30) + 'px"><span class="uew-table-thTitle">'+tableHead[i].label+'</span></div></th>');
					
					if(tableHead[i].sortable == "default"){
						$('<a href="javascript:;" class="uew-icon2 uew-icon2-sort"></a>').insertAfter($th.find('.uew-table-thTitle'));
					}else if(tableHead[i].sortable == "desc"){
						$('<a href="javascript:;" class="uew-icon2 uew-icon2-sort-desc"></a>').insertAfter($th.find('.uew-table-thTitle'));
					}else if(tableHead[i].sortable == "asc"){
						$('<a href="javascript:;" class="uew-icon2 uew-icon2-sort-asc"></a>').insertAfter($th.find('.uew-table-thTitle'));
					}
					if(options.widthResize){
						$th.children().append('<span class="uew-table-drag"></span>');
					}
					if(tableHead[i].name){
						$th.attr('name',tableHead[i].name);
					}
					if(tableHead[i].minWidth){
						$th.addClass('minWidth');

						this.$minWidthTh = $th;
						this.$minWidthTh.width = tableHead[i].width - 30;
					}
					$tableHeadTr.append($th);
					$tableMainHead.append($th.clone());//鎻掑叆鍒拌〃鏍间綋涓殑head
				}
				$tableHeadTr.append('<th class="uew-table-blank">&nbsp;</th>');
				$tableMainHead.append('<th class="uew-table-blank">&nbsp;</th>');//鎻掑叆鍒拌〃鏍间綋涓殑head
			}else if(options.headCount == 2){
				var $tableHead = $el.find('.__theadMain thead'),$tableMainHead = $el.find('.__tbodyMain thead').empty();
				$el.find('.__theadMain tr').empty();
				$el.addClass("uew-table-doubleTh");
				$tableHead.append('<tr class="uew-table-secondHd"></tr>');
				var indexCount = 0, $thObj1 = $tableHead.find('tr').eq(0), $thObj2 = $tableHead.find('tr').eq(1);
				for(var i = 0;i < tableHead.length;i++){
					if(tableHead[i].children){
						$thObj1.append('<th colspan="' + tableHead[i].children.length + '"><div class="uew-table-th"><span class="uew-table-thTitle">' + tableHead[i].label + '</span><a href="javascript:;"></a></div></th>');
						for(var j = 0;j < tableHead[i].children.length;j++){
							var childrenData = tableHead[i].children[j];
							$thObj2.append('<th indexCount="' + indexCount++ + '"><div class="uew-table-th"><span class="uew-table-thTitle">' + childrenData.label + '</span><a href="javascript:;"></a></div></th>');
							var $th = $thObj2.find('th:last');
							if(childrenData.sortable == "default"){
								$('<a href="javascript:;" class="uew-icon2 uew-icon2-sort"></a>').insertAfter($th.find('.uew-table-thTitle'));
							}else if(childrenData.sortable == "desc"){
								$('<a href="javascript:;" class="uew-icon2 uew-icon2-sort-desc"></a>').insertAfter($th.find('.uew-table-thTitle'));
							}else if(childrenData.sortable == "asc"){
								$('<a href="javascript:;" class="uew-icon2 uew-icon2-sort-asc"></a>').insertAfter($th.find('.uew-table-thTitle'));
							}
							if (childrenData.name) {
								$th.attr("name", childrenData.name).children().css('width',childrenData.width-30);
							}
							if(childrenData.minWidth){
								$th.addClass('minWidth');
								this.$minWidthTh = $th;
								this.$minWidthTh.width = childrenData.width-30;
							}
						}
					}else{
						$thObj1.append('<th rowspan="2" indexCount="' + indexCount++ + '"><div class="uew-table-th"><span class="uew-table-thTitle">' + tableHead[i].label + '</span><a href="javascript:;"></a></div></th>');
						var $th = $thObj1.find('th').eq(i);
						if (tableHead[i].name) {
							$th.attr("name", tableHead[i].name).children().css('width',tableHead[i].width-30);
						}
						if(tableHead[i].minWidth){
							$th.addClass('minWidth');
							this.$minWidthTh = $th;
							this.$minWidthTh.width = tableHead[i].minWidth-5;
						}
					}
				}  
				$thObj1.append('<th rowspan="2" class="uew-table-blank">&nbsp;</th>');
				$tableMainHead.append($thObj1.clone());//鎻掑叆鍒拌〃鏍间綋涓殑head  
				$tableMainHead.append($thObj2.clone());//鎻掑叆鍒拌〃鏍间綋涓殑head  
				
			}
		},
		/*
         * 璁剧疆琛ㄦ牸浣撴暟鎹�
		 */
		_setTableBodyData : function($el, tableBody, isNoEmpty){
			var _define = this._define,tableHead = this._define.tableHead, options = this.options;
			if(!isNoEmpty){
				var $tableMainData =  $el.find('.__tbodyMain .__data').empty();
			}else{
				var $tableMainData =  $el.find('.__tbodyMain .__data');
			}
			
			if(options.headCount == 2){
				tableHead = _define.headData;	
			}
			for(var i = 0,rowLen = tableBody.length;i < rowLen; i++){//琛岄亶鍘�
				var rowData = tableBody[i];//璁板綍姣忎竴琛岀殑鏁版嵁
				var $tr = $('<tr></tr>'),tdArr = [];	
				for(var j = 0, fieldLen = tableHead.length; j < fieldLen; j++){
					var tableHeadJ = tableHead[j];
					if(tableHead[j].minWidth){
						if(tableHeadJ.name){
							tdArr.push('<td minWidth="minWidth" name="'+ tableHeadJ.name +'"><div class="uew-table-td" style="width:'+ (tableHeadJ.width -16) +'px">'+ rowData[j] +'</div></td>');
						}else{
							tdArr.push('<td minWidth="minWidth"><div class="uew-table-td" style="width:'+ (tableHeadJ.width -17) +'px">'+ rowData[j] +'</div></td>');
						}
						
					}else{
						if(tableHeadJ.name){
							tdArr.push('<td name="'+ tableHeadJ.name +'"><div class="uew-table-td" style="width:'+ (tableHead[j].width -17) +'px">'+ rowData[j] +'</div></td>');
						}else{
							tdArr.push('<td><div class="uew-table-td" style="width:'+ (tableHead[j].width -17) +'px">'+ rowData[j] +'</div></td>');
						}
						
					}
					
				}
				tdArr.push('<td class="uew-table-blank"><div class="uew-table-td"></div></td>');
				$tr.append(tdArr.join(''));
				$tableMainData.append($tr);
			}
		
		
			if(options.checkbox){//濡傛灉鏈塩heckbox鍒欏垱寤篶heckbox鍖哄煙
				this._createTbodyFront($el, options, tableBody, isNoEmpty);
			}
			
			if(options.operator){
				this._createTableBodyFinal($el, options, tableBody, isNoEmpty);
			}
		},
		/*
		 * 鍒涘缓琛ㄦ牸棣栧垪鍥哄畾鍖哄煙锛坈heckbox鍖哄煙锛�
		 */
		_createTbodyFront : function($el, options, tableBody, isNoEmpty){
			var $tbodyFront = $el.find('.__tbodyFront'), isDisable = options.checkbox.disable;
			if(!isNoEmpty){
				var  $tbody = $tbodyFront.find('tbody').empty();
			}else{
				var $tbody = $tbodyFront.find('tbody');
			}
			var trArray = [];
			for(var i = 0, len = tableBody.length;i < len;i++){
				if(isDisable){
					trArray.push('<tr attr="38"><td class="uew-table-checkbox"><input type="checkbox" disabled="disabled"></td></tr>');
				}else{
					trArray.push('<tr attr="38"><td class="uew-table-checkbox"><input type="checkbox"></td></tr>');
				}
			}
			$tbody.append(trArray.join(''));
			if(!isNoEmpty){
				this._bindCheckboxEvent($el, $tbodyFront);
			}
		},
		/*
		 * 鍒涘缓琛ㄦ牸灏惧垪鍥哄畾鍖哄煙(operator鍖哄煙)
		 */
		_createTableBodyFinal : function($el, options, tableBody ,isNoEmpty){
			var $tbodyFinal = this.$domCache.$tbodyFinal, isPanel = options.operator.type == 'panel', _define = this._define;
			if(!isNoEmpty){
				var  $tbody = $tbodyFinal.find('tbody').empty();
			}else{
				var $tbody = $tbodyFinal.find('tbody');
			}
			var trArray = [];
			
			for(var i = 0, len = tableBody.length;i < len;i++){
				var optArray = tableBody[i][tableBody[i].length - 1];
				_define.operatorData.push(optArray);
				if(isPanel){//鎿嶄綔鏉挎儏鍐�
					if(this._isType(optArray,'Array')){
						trArray.push('<tr attr="38"><td class="uew-table-operation"><a href="javascript:;" class="ue-state-default __operatorPanelBtn" operindex="'+ i +'"><span class="uew-icon uew-icon-circle-triangle-s"></span></a></td></tr>');
						
					}else{
						trArray.push('<tr attr="38"><td class="uew-table-operation"><span></span></td></tr>');
					}
				}else{//闈炴搷浣滄澘鎯呭喌
					if(this._isType(optArray,'Array')){
						var optList = [];
						for(var j = 0,optLen = optArray.length;j < optLen; j++){
							if(optArray[j].disable){
								optList.push('<a href="javascript:;" class="ue-state-disable">'+ optArray[j].label +'</a>');
							}else{
								optList.push('<a href="javascript:;">'+ optArray[j].label +'</a>');
							}
						}
						trArray.push('<tr attr="38"><td class="uew-table-operation">'+ optList.join('') +'</td></tr>');
					}else{
						trArray.push('<tr attr="38"><td class="uew-table-operation"><span></span></td></tr>');
					}
				}
			}
			$tbody.append(trArray.join(''));
			this._createRightOperatorAndBindEvent(isPanel, $tbody, _define.operatorData);
		},
		/*
		 * 鐢熸垚鎿嶄綔鏉胯妭鐐瑰強缁戝畾浜嬩欢
		 */
		_createRightOperatorAndBindEvent : function(isPanel,$tbody,operatorData){
			var $el = this.element, options = this.options, self = this, $domCache = this.$domCache;
			if (isPanel) {
				var $operatorBtn = $tbody.find('.__operatorPanelBtn');
				var $operatorPanel = $('<div class="__operatorPanel"></div>');
				$domCache.$operatorPanel = $operatorPanel;
				$('body').append($operatorPanel);
				var operatorOptions = {
					data : [
						{id : 0,pid : -1},
						{id : 1,pid : 0,label : "缂栬緫"}
					],
					position : [12,12],
					opter : [$operatorBtn],
					close : function(){
						$operatorBtn.removeClass('ue-state-current');	
					},
					getObj : function(obj){
						obj.onclick($el, [parseInt(obj.index)]);
					}
				};
				$operatorPanel.uedOptPanel(operatorOptions);
				$operatorBtn.bind("click", function() {
					var operIndex = $(this).attr("operIndex");
					var operArr = operatorData[operIndex];
					var data = [
						{id : 0,pid : -1}
					]
					for(var i = 0;i < operArr.length;i++){
						if(!operArr[i]){continue;}
						var dataObj = {};
						dataObj.id = (i + 1);
						dataObj.pid = 0;
						if(operArr[i].icon){
							var labelHtml = '<span class="' + operArr[i].icon + '"></span>' + operArr[i].label;
						}else{
							var labelHtml = operArr[i].label;
						}
						dataObj.label = labelHtml;
						dataObj.index = operIndex;
						dataObj.onclick = operArr[i].onclick;
						data.push(dataObj);
					}
					$operatorBtn.removeClass('ue-state-current');
					$(this).addClass('ue-state-current');
					$operatorPanel.uedOptPanel("setData",data);
					//璁＄畻鎿嶄綔鏉跨殑浣嶇疆锛屼紭鍏堝悜涓嬶紝涓嬮潰绌洪棿涓嶅杞负鍚戜笂銆�
					if((($(window).height()+$(window).scrollTop())-$(this).offset().top-10) > $operatorPanel.outerHeight()){
						var tempTop = $(this).offset().top+16;
					}else{
						var tempTop = $(this).offset().top - $operatorPanel.outerHeight();
					}
					$operatorPanel.uedOptPanel("setPosition", ($(this).offset().left)-($operatorPanel.outerWidth()-45), tempTop);
					$operatorPanel.uedOptPanel("open");
				});
			}else{//闈為潰鏉�
				var $a = $tbody.find('a');
				$a.unbind('click');
				$a.bind('click',function(){
					if(!$(this).hasClass('__operatorPanelBtn')){
						var indexTr = $(this).parents('tr').index();
						var indexA = $(this).index();
						var bodyData = operatorData[indexTr];
						var funArray = bodyData[indexA];
						funArray.onclick($el,[parseInt(indexTr)]);
					}
				});
			}
		},
		_bindCheckboxEvent : function($el, $tbodyFront){
			var checkedLen = 0, $theadInput = $el.find('.uew-table-thead').find('input[type=checkbox]');
			$tbodyFront.click(function(e) {
                var $target = $(e.target),len = $tbodyFront.find('tbody').find('input[type=checkbox]').size();
				if($target.is('input')){
					
					if($target.attr('checked')){
						checkedLen++;
					}else{
						checkedLen--;
					}

					if(checkedLen == len){
						$theadInput.attr('checked',true);
					}else{
						$theadInput.attr('checked',false);
					}
				}
            });
			$theadInput.click(function(){//缁戝畾浜嬩欢锛屽叏閫夛紝鍏ㄩ儴涓嶉�浜嬩欢
				var $tbodyInput = $tbodyFront.find('tbody').find('input[type=checkbox]').not(':disabled');
				var len = $tbodyInput.size()
				if($(this).attr('checked')){
					$tbodyInput.attr('checked',true);
					checkedLen = len;
				}else{
					$tbodyInput.attr('checked',false);
					checkedLen = 0;
				}
			});	
			
		},
		/*
         * 缁戝畾琛ㄦ牸浜嬩欢
		 */
		_bindEvent : function($el, options){
			var self = this, $domCache = this.$domCache, $customTable = $domCache.$customTable;
			//琛ㄦ牸鎿嶄綔鏉′簨浠�
			$el.find(".uew-table-optBar").on("click.uedGrid",'button', function() {
				if (!$(this).hasClass("ue-state-disable")) {
					if ($(this).parent().hasClass("uew-table-optBar")) {
						options.options[$(this).index()].callback.call(null,$el, self.getCheckedIndex());
					} else {
						if(!$(this).hasClass('__customBtn')){
							options.settings[self._define.fullScreenIndex].callback.call();
						}else{
							$customTable.uedDialog("setPosition",'center',$(window).scrollTop() + window.innerHeight/2 - $customTable.height()/2-30);
							self._initCustomPanel($customTable);
							$customTable.uedDialog('open');
						}
					}
				}
			});

			//琛ㄦ牸澶磋窡鐫�粴鍔�
			$domCache.$tableScroll.bind("scroll.uedGrid",function() {
				$el.find(".uew-table-main table").css("margin-left", 0 - $(this).scrollLeft());
			});
			
			$el.find('.uew-table-tbody').bind('scroll.uedGrid',function(){
				if($domCache.$operatorPanel){
					$domCache.$operatorPanel.uedOptPanel('close');
				}	
			});
			
			this._uedResize(self._tableResize);
		},
		_bindTableEvent : function(){
			var $el = this.element, self = this, options = this.options;
			//鐐瑰嚮鎺掑簭杩斿洖index鍊�
			$el.find(".__theadMain").find(".uew-icon2").each(function(i) {
				$(this).unbind("click");
				$(this).bind("click", function() {
					if(self.isLoadding){
						return false;
					}
					$el.find(".__theadMain").find(".uew-icon2").not($(this)).removeAttr("class").addClass("uew-icon2 uew-icon2-sort");
					var tmpname = $(this).parent().parent("th").attr("name");
					if(!options.defaultSortType || options.defaultSortType == 'desc'){

						if($(this).hasClass("uew-icon2-sort-desc")){
							$(this).removeClass("uew-icon2-sort-desc").addClass("uew-icon2-sort-asc");
							self._trigger("sortCallBack", event, tmpname, (i + 1), "asc",$el);
						}else{
							$(this).removeClass("uew-icon2-sort-asc").addClass("uew-icon2-sort-desc");
							self._trigger("sortCallBack", event, tmpname, (i + 1), "desc",$el);
						}
					}else{
						
						if($(this).hasClass("uew-icon2-sort-asc")){
							$(this).removeClass("uew-icon2-sort-asc").addClass("uew-icon2-sort-desc");
							self._trigger("sortCallBack", event, tmpname, (i + 1), "desc",$el);
						}else{
							$(this).removeClass("uew-icon2-sort-desc").addClass("uew-icon2-sort-asc");
							self._trigger("sortCallBack", event, tmpname, (i + 1), "asc",$el);
						}
					}
					if(self.paginationObj){
						self.paginationObj.currentPage = 1;
						self.setPagination(self.paginationObj);
					}
				});
			});	
		},
		/*
 		 * 璋冩暣琛ㄦ牸瀹介珮绛�
		 */
		_adjustTable : function($el, options){
			$el.find(".__tablescroll").scrollLeft(0);
			$el.find(".uew-table-main table").css("margin-left", 0);
			this._adjustWidth($el);
			this._adjustHeight($el, options);
			this._adjustOperator($el, options);
		},
		/*
		 * 璋冩暣琛ㄦ牸瀹藉害
		 */
		_adjustWidth : function($el){
			var options = this.options, _define = this._define, $blankTh = $el.find('th.uew-table-blank'),$blankTd = $el.find('td.uew-table-blank'),$domCache = this.$domCache,$tableTbody = $domCache.$tableTbody, $tbodyFront = $domCache.$tbodyFront, $tbodyFinal = $domCache.$tbodyFinal;
						
			_define.currentTableWidth = _define.tableWidth + _define.blankWidth + 6;//璁板綍琛ㄦ牸鐨勫疄闄呭搴﹀嵆涓哄綋鍓嶅搴�
			var $tableMain = $el.find('.__tbodyMain');
			var tableMainWidth = $el.find('.uew-table-tbody').width();
			//鍒ゆ柇鏄惁鏈夊瀭鐩存粴鍔ㄦ潯
			if($tableTbody.height() < $tableTbody.children().height() && options.height != 'auto'){
				$el.addClass('uew-table-hasScroll');
			}else{
				$el.removeClass('uew-table-hasScroll');
			}
			
			if(!-[1,]){//IE瀹藉害澶勭悊娴佺▼
				
				if($el.hasClass('uew-table-hasScroll')){
					tableMainWidth -= 17;
				}
			}
			if(options.checkbox){
				tableMainWidth -= $tbodyFront.width();
			}
			if(options.operator){
				if(options.operator.width){
					tableMainWidth -= options.operator.width;
				}else{
					tableMainWidth -= $tbodyFinal.width();
				}
				
			}
			$tableMain.width(tableMainWidth);
			
			$blankTh.width(_define.blankWidth).attr('width',_define.blankWidth);
			$blankTd.width(_define.blankWidth);
			
			var tempWidth = tableMainWidth - _define.currentTableWidth;
			if(this.$minWidthTh){//濡傛灉鏈塵inWidth
				var $uewTableMinTh = $el.find('.minWidth').find('.uew-table-th'), reaWidth = $uewTableMinTh.width();
				if(tempWidth > 0){//鏃犳按骞虫粴鍔ㄦ潯,灏唗empWidth鐨勫�缁檓inWidth

					$uewTableMinTh .width( tempWidth + this.$minWidthTh.width );
					//鏇存柊褰撳墠琛ㄦ牸瀹為檯瀹藉害
					_define.currentTableWidth += tempWidth;
					var tempMinWidth = $el.find('.__theadMain').find('th.minWidth').children().width();
					$el.find('td[minWidth]').each(function(){
						$(this).children().width(tempMinWidth+14);
					});
					$domCache.$tableScroll.hide();//闅愯棌婊氬姩鏉�
					$domCache.$division.removeClass('uew-table-hScroll');
				}else{
					$uewTableMinTh.width(this.$minWidthTh.width);
					var tempMinWidth = $el.find('.__theadMain').find('th.minWidth').children().width();
					$el.find('td[minWidth]').each(function(){
						$(this).children().width(tempMinWidth+14);
					});
					$domCache.$tableScroll.show().children().width(_define.currentTableWidth);
					$domCache.$division.addClass('uew-table-hScroll');
				}
			}else{//鏃爉inWidth锛屾墍鏈夌殑澶氫綑瀹藉害閮界粰绌虹櫧鍒�
				if(tempWidth > 0){ //鏃犳按骞虫粴鍔ㄦ潯锛岀洿鎺ュ皢tempWidth鐨勫�缁欑┖鐧藉垪
					$blankTh.width(tempWidth + _define.blankWidth + 6);
					$blankTd.width(tempWidth + _define.blankWidth + 6);//瀹藉害涓鸿鍒跺搴﹀姞澶氫綑瀹藉害
					var blankWidthTemp = tempWidth + _define.blankWidth + 6
					$el.find('.uew-table-blank').attr('width', blankWidthTemp);
					$domCache.$tableScroll.hide();
					$domCache.$division.removeClass('uew-table-hScroll');
				}else{
					$domCache.$tableScroll.show().children().width(_define.currentTableWidth);
					$domCache.$division.addClass('uew-table-hScroll');
				}
			}
			_define.width = $el.width();
		},
		
		_adjustOperator : function($el, options){
			var $tableTbody = this.$domCache.$tableTbody;
			if(options.operator){//鍙湁褰撴搷浣滀负normal鐢熸晥
				var $tableScroll = this.$domCache.$tableScroll;
				if(options.operator.type == "normal"){
					//鏃犳粴鍔ㄦ潯
					$el.find(".__tbodyFinal,.__tbodyFinal table,.__theadFinal,.__theadFinal table").width(options.operator.width - 1).find(".uew-table-operation").width(options.operator.width - 6);
					$el.find(".uew-table-main").css("right",options.operator.width);
					$tableScroll.css("margin-right",options.operator.width);
					if($el.hasClass("uew-table-hasScroll") && options.height != 'auto'){
						var UA = navigator.userAgent.toLowerCase();
						if (/webkit/i.test(UA)){
							$el.find(".__theadFinal,.__theadFinal table").width(options.operator.width + 9);
							$el.find(".__theadMain").css("right",options.operator.width + 10);
							$el.find(".__tbodyMain").css("right",options.operator.width);
							$tableScroll.css("margin-right",options.operator.width + 10);
						}else{
							$el.find(".__theadFinal,.__theadFinal table").width(options.operator.width + 16);
							$el.find(".__theadMain").css("right",options.operator.width + 17);
							$el.find(".__tbodyMain").css("right",options.operator.width);
							$tableScroll.css("margin-right",options.operator.width + 17);
						}
					}
				}else{
					if(!-[1,] && $el.hasClass("uew-table-hasScroll")){
						$tableScroll.css("margin-right",69);
					}	
				}
				if(options.height == "auto"){
					if(!options.tableBody || options.tableBody.length == 0){
						$tableTbody.show().height(200);
					}else{
						$tableTbody.height($tableTbody.children().height());
					}
					$el.removeClass('uew-table-hasScroll');
				}else{
					$tableTbody.height(options.height);
				}
			}
		},
		
		/**
         * 鎺у埗琛ㄦ牸鍏冪礌鏄鹃殣
         * @param {Object} $panel
         * @param {Object} options
         */
		_controlShowOrHide : function($el,options){
			var $panel = $el.find(".__panel"),$domCache = this.$domCache;
			if(options.height == 'auto' && !(options.tableBody && options.tableBody.length)){//2013-6-25淇敼bug锛岃嚜閫傚簲楂樺害鏃跺彉涓烘棤鏁版嵁
				$domCache.$tableTbody.height(300);
			}
			
			if(!options.tableBody){//if tableBody涓簄ull
				if(!options.tableHead || !options.tableHead.length){ //鏃犺〃鏍煎ご鏃�
					$domCache.$tableNoData.hide();
					$el.children(".uew-table-optBar").find("button").addClass("ue-state-disable");
					$el.children(".uew-table-optBar").find("button[alwaysEnable]").removeClass("ue-state-disable");
					$domCache.$tableScroll.hide();
					$domCache.$tableLoading.hide();
					$el.find(".uew-pagination").hide();
					$el.children(".__panel").children("div:not(.uew-table-division)").hide();
					$domCache.$division.hide();
				}else{
					this._tableNoData($el, options, $domCache);
				}
				
			}else if(!options.tableBody.length){//if tableBody 涓篬]
				this._tableNoData($el, options, $domCache);
			}else{
				$domCache.$tableTbody.show().children(".uew-nodata-tip").hide();
				$el.children(".__panel").children(".uew-table-thead").show();
				$el.children(".uew-table-optBar").find("button").removeClass("ue-state-disable");
				$domCache.$tableScroll.show();
				$domCache.$tableLoading.hide();
				$el.find(".uew-pagination").show('visibility');
				$el.find(".uew-pagination").show();
				$el.find('.__tbodyMain').show();
				$el.find('.table-front-fixed').show();
				$el.find('.table-finale-fixed').show();
				if(options.pagination.totalRecord){
					$domCache.$division.show();
				}else{
					$domCache.$division.hide();	
				}
				this.isLoadding = false;
			}		
		},
		_tableNoData : function($el, options, $domCache){
			if(options.height == "auto"){
				$domCache.$tableNoData.show().css('margin-top',30);
			}else{
				$domCache.$tableNoData.show().css('margin-top',($domCache.$tableTbody.height()/2)-106);
			}
			$el.children(".uew-table-optBar").find("button:not([alwaysEnable])").addClass("ue-state-disable");
			$el.children(".uew-table-optBar").find("button[alwaysEnable]").removeClass("ue-state-disable");
			$el.children(".__panel").children("div:not(.uew-table-division)").show();
			/*$domCache.$tableScroll.hide();*///鏃犳暟鎹椂闇�婊氬姩鏉� 2013-6-7
			$domCache.$tableLoading.hide();
			$domCache.$tbodyFront && $domCache.$tbodyFront.hide();
			$domCache.$tbodyFinal && $domCache.$tbodyFinal.hide();
			if(this.$paginatObj){
				this.$paginatObj.hide('visibility');
			}
			//$el.find(".uew-pagination").hide();
			
			if(!options.tableHead || !options.tableHead.length){
				$el.find(".uew-table-thead").hide();
				$domCache.$tableNoData.hide()
			}else{
				$el.find(".uew-table-thead").show();
			}
			$el.children(".__panel").find('.__tbodyMain').hide();
			$domCache.$division.hide();
			$el.find('.uew-table-thead').children().show();
		},
		/*
		 * 璋冩暣琛ㄦ牸楂樺害
		 */
		_adjustHeight : function($el, options){
			var $domCache = this.$domCache, $tableTbody = $domCache.$tableTbody, $tablePanel = $domCache.$tablePanel;
			
			//濡傛灉琛ㄦ牸鏈夋搷浣滄垨鑰卌heckbox锛屽垯闇�璋冩暣楂樺害
			if(!options.nowrap){
				var $trArray = $el.find(".__tbodyMain").children("table").children("tbody").children("tr");
				if(options.checkbox){
					var $tbodyFront = this.$domCache.$tbodyFront;
					$tbodyFront.children().children("tbody").children("tr").each(function(i) {
						var height = $trArray.eq(i).height();
						if(height != $(this).attr('attr')){
							$(this).attr('attr',height);
							$(this).height(height);
						}
						
					});
				}
				if(options.operator){
					var $tbodyFinal = this.$domCache.$tbodyFinal;
					$tbodyFinal.children().children("tbody").children("tr").each(function(i) {
						var height = $trArray.eq(i).height();
						if(height != $(this).attr('attr')){
							$(this).attr('attr',height);
							$(this).height(height);
						}
						
					});
				}
			}
			if(options.height == "auto"){
				if(!options.tableBody || options.tableBody.length == 0){
					$tableTbody.show().height(200);
				}else{
					$tableTbody.height($tableTbody.children().height());
				}
				
			}else{
				$tableTbody.height(options.height);
			}
		},
		/*鑾峰彇鎵�湁鐨勫簭鍒椾俊鎭�/
		_getAllSequence : function(){
			var options = this.options, length = options.tableHead.length, allSequence = [];
			for(var i = 0;i<length;i++){
				allSequence.push(i);
			}
			return allSequence;
		},
		/*
         * 琛ㄦ牸鐨剅esize浜嬩欢
		 */
		_tableResize : function($el,self){
			var $domCache = self.$domCache, $operatorPanel = $domCache.$operatorPanel, options = self.options;
			if($operatorPanel){
				$operatorPanel.uedOptPanel('close');
			}
			$el.find(".__tablescroll").scrollLeft(0);
			$el.find(".uew-table-main table").css("margin-left", 0);
			
			self._adjustWidth($el);	
			if(!options.nowrap){
				self._adjustHeight($el,options);
			}else{
				//$domCache.$tablePanel.height($domCache.$tableTbody.height() + $domCache.$tableThead.height() + $domCache.$tableScroll.height());
			}
			self._adjustOperator($el,options);
		},
		/**缁戝畾琛ㄦ牸澶存嫋鍔ㄤ簨浠�*/
		_dragTable : function($el){
			var self = this, _define = this._define, $domCache = this.$domCache;
			//璁板綍姝ｅ湪鎷栨嫿鐨勫璞�
			var $dragging;
			//璁板綍寮�鎷栨嫿鏃剁殑鍧愭爣鍊�
			var startX;
			//璁板綍缁撴潫鎷栨嫿鏃剁殑鍧愭爣鍊�
			var endX;
			//榧犳爣鎸変笅浜嬩欢
			$el.find('.uew-table-drag').bind('mousedown',function(e){
				e.preventDefault();
				$dragging = $(this);
				//璁板綍鎷栨嫿鍓嶇殑鍧愭爣鍊�
				startX = $dragging.offset().left;
				//鎷栧姩寮�
				$(document).bind('mousemove',dragMove);
				function dragMove(e){
					e.preventDefault();
					//鏀瑰彉鎷栧姩鐨勪綅缃�
					$dragging.css('right',startX - e.clientX -1).addClass('uew-table-dragging');	
				}
				//鎷栧姩缁撴潫
				$(document).bind('mouseup',dragUp);
				
				function dragUp(e){
					$(document).unbind('mouseup',dragUp);
					$(document).unbind('mousemove',dragMove);
					$dragging.removeClass('uew-table-dragging');
					endX = $dragging.offset().left;
					var index = $dragging.parents('th').index();
					var isNoMinWidth = $el.find('th.minWidth').size() ? false : true;
					//鎷栧姩鐨勮窛绂�
					var distance = endX - startX;
					//瀛樺偍鐨勫搴︽敼鍙樺墠td鐨勫搴�
					var sourceWidth = $el.find(".__theadMain").children("table").children("thead").children("tr").children("th").eq(index).children(".uew-table-th").width();
					//瀛樺偍鐨勬嫋鎷藉悗鐨勫�
					var targetWidth = sourceWidth + distance;
					var minWidth = $el.find(".__theadMain").children("table").children("thead").children("tr").children("th").eq(index).children(".uew-table-th").children(".uew-table-thTitle").width();
					
					if (targetWidth < minWidth) {
						targetWidth = minWidth;
					}
					$el.find(".__tbodyMain").children("table").children("tbody").children("tr").each(function(){
						$(this).find('td').eq(index).children().width(targetWidth+14);	
					});
					var changeWidth;//璁板綍鏀瑰彉鐨勫搴�
					$el.find('thead').each(function(i){
						var $thDiv = $(this).find('th').eq(index).find('.uew-table-th');
						changeWidth = $thDiv.width();
						$thDiv.width(targetWidth);
						changeWidth = targetWidth - changeWidth;
					});
					//璋冩暣绌虹櫧鍒楃殑瀹藉害
					var blankWidth = $el.find('.__theadMain th.uew-table-blank').attr('width');
					if(blankWidth == undefined){
						blankWidth = $el.find('.__theadMain th.uew-table-blank').outerWidth();
					}
					
					_define.currentTableWidth += changeWidth;
					var tempBlankWidth = blankWidth - changeWidth;
					if( tempBlankWidth < 10){
						tempBlankWidth = 10;
					}
					$el.find('.uew-table-blank').width(tempBlankWidth);
					$el.find('.uew-table-blank').attr('width',tempBlankWidth);//淇濆瓨width锛岄槻姝㈣幏鍙栦笉鍑嗙‘
					//璁剧疆鎷栨嫿鏉＄殑鍧愭爣
					$dragging.css("right", -1);
					if(!$el.find(".__theadMain").children("table").children("thead").children("tr").children("th").eq(index).hasClass('minWidth')){
						_define.tableWidth += changeWidth;
					}
					//_define.tableWidth += changeWidth;
					//璁剧疆婊氬姩鏉�
					if(_define.currentTableWidth > $el.find('.__tbodyMain').width()){//鏈夋按骞虫粴鍔ㄦ潯
						
						$domCache.$tableScroll.show().children().width(_define.currentTableWidth);
						$domCache.$division.addClass('uew-table-hScroll');
					}else{
						$el.find('.__theadMain').children('table').css('margin-left',0);
						$el.find('.__tbodyMain').children('table').css('margin-left',0);
						$domCache.$tableScroll.hide().children().scrollLeft(0);
						$domCache.$division.removeClass('uew-table-hScroll');
					}
					//鎷栧姩缁撴潫鏃跺鏋滆〃鏍兼槸nowrap骞朵笖楂樺害涓篴uto鏃�
					if(!self.nowrap && self.options.height == "auto"){
						
						$domCache.$tableTbody.height($domCache.$tableTbody.children().height());
						
					}
					if(!self.nowrap && (self.options.checkbox || self.options.operator)){
						
						self._adjustHeight($el,self.options);
						//self._adjustWidth($el);
						if(!-[1,]){self._adjustOperator($el,self.options);}
					}else if(!self.nowrap){
						self._adjustHeight($el,self.options);
					}
					$domCache.$division.css('top','-1px');
				}
			});
		},
		_createPagination : function(pagination){
			var $paginatObj = this.$paginatObj;
			if(pagination && pagination.totalRecord){//鍒嗛〉淇℃伅瀛樺湪锛屽苟涓旀湁鎬婚〉鎵嶅垵濮嬪寲鍒嗛〉
				$paginatObj.uedPagination(pagination);
			}else if(pagination && pagination.isUncertain){
				$paginatObj.uedUncertainPagination(pagination);	
			}	
		},
		/*
		 * 澶嶅埗鏁扮粍
		 * @param {Array} arr 闇�澶嶅埗鐨勬暟缁�
		 * @return {Array} 杩斿洖澶嶅埗鐢熸垚鐨勬暟缁�
		 */
		_copyArray : function(arr){
			return arr.slice(0);
		},
		/*璁剧疆鍒嗛〉淇℃伅*/
		setPagination : function(obj){
           var $el=this.element, options = this.options, $domCache = this.$domCache, pagination = options.pagination;
		   $.extend(pagination,obj);
		   if(!obj){
		   		this.$paginatObj.empty();
				return;
		   }
		   this._createPagination(pagination);
		   if(pagination.totalRecord && options.tableBody && options.tableBody.length){
				$domCache.$division.show();
		   }else{
				$domCache.$division.hide();	
		   }
		   if(options.tableBody && options.tableBody.length){
		   		$el.find(".uew-pagination").show('visibility');
		   }
        },
		/**
		 * 澧炲姞addLoading鏍峰紡
		 **/
		addLoading : function(){
			var $el = this.element, options = this.options, $domCache = this.$domCache;
			if(options.height == 'auto' && ($domCache.$tableTbody.height() < 100)){
				$domCache.$tableTbody.height(300);
			}
			if(options.tableHead && options.tableHead.length){
				$el.find(".uew-table-thead").show();
			}else{
				$el.find(".uew-table-thead").hide();
			}
			$domCache.$tableTbody.show().find(".__tbodyMain").hide();
			$domCache.$tableNoData.hide();
			$domCache.$tableLoading.show().css('margin-top',($domCache.$tableTbody.height()/2)-94);
			$el.find('.table-front-fixed').hide();
			$el.find('.table-finale-fixed').hide();
			$domCache.$tableScroll.hide();
			$el.children(".uew-table-optBar").find("button").addClass("ue-state-disable");
			$el.find('.uew-pagination').hide();
			this.isLoadding = true;//璁板綍琛ㄦ牸鏄惁澶勪簬loadding涓�
		},
		/*
		 * 瀵瑰鎺ュ彛鏂规硶,璁剧疆琛ㄦ牸楂樺害锛屾敮鎸佸叿浣撴暟鍊煎拰auto銆�
		 */
		 setHeight : function(height_) {
            var $el = this.element, options = this.options;
			if(height_ != 'auto'){
				options.height = height_+5;//淇敼姝よ〃鏍奸珮搴�
			}else{
				options.height = 'auto';
			}
			
            
			this._adjustWidth($el,options); 
			this._adjustHeight($el,options);
			this._adjustOperator($el,options);
        },
		/*
		 * 瀵瑰鎺ュ彛鏂规硶锛岃幏鍙栬〃鏍肩殑鐩稿簲琛屽璞�
		 * @param {Array} indexArray 闇�鑾峰彇鐨勮搴忓垪
		 */
		getTableTrObj : function(indexArray){//搴熷純锛岃浣跨敤getTrs
			var $el = this.element, $trArray = $('.__tbodyMain',$el).find('table').children('tbody').children('tr'), trObj = [];
			if(!(indexArray && indexArray.length)){
				return $trArray;
			}
			for(var i = 0,len = indexArray.length;i < len; i++){
				trObj.push($trArray.eq(indexArray[i]));
			}
			return trObj;
		},
		getTrs : function(indexArray){
			return this.getTableTrObj(indexArray);
		},
		/*
		 * 瀵瑰鎺ュ彛鏂规硶锛岃幏鍙栬〃鏍肩殑鐩稿簲鐨勫崟鍏冩牸瀵硅薄
		 * @param {String} name 闇�鑾峰彇鐨勫崟鍏冩牸name.
		 * @param {Array} indexArray 闇�鑾峰彇鐨�
		 */
		getTableTdObj : function(name, indexArray){//搴熷純锛岃浣跨敤getTds
			var $el = this.element, $trArray = $('.__tbodyMain',$el).find('table').children('tbody').children('tr');
			var tdObj = [], len = indexArray && indexArray.length;
			if(indexArray){
				for(var i = 0;i < len; i++){
					tdObj.push($trArray.eq(indexArray[i]).find('td[name='+ name +']'));
				}
			}else{
				for(var i = 0;i < $trArray.size();i++){
					tdObj.push($($trArray[i]).find('td[name='+ name +']'));	
				}
			}
			return tdObj;
		},
		getTds : function(name, indexArray){
			return this.getTableTdObj(name, indexArray);
		},
		/*
		 *	閲嶆柊璁剧疆鍙充晶鎿嶄綔鏍忥紝鍙互璁剧疆鍏朵腑涓�釜锛屼篃鍙互璁剧疆鎵�湁銆�
		 *  @param {Array} operatorPanelData   闇�鏇存敼鐨勬暟缁�
		 *  @param {Array} index	闇�鏇存敼鐨勭储寮曘� 姝ゅ弬鏁颁负鍙�銆傛棤index鍒欐浛鎹㈡墍鏈�
		 *  @param {string} name	闇�淇敼鐨刵ame銆�姝ゅ弬鏁颁负鍙�銆�
		 */
		setOperatorData : function(operatorData, index, name){
			var options = this.options, $el = this.element, self = this, _define = this._define, isPanel = options.operator.type == 'panel';
			if(index){
				//鏀瑰彉涓巌ndex瀵瑰簲鐨勮鐨勬搷浣滄澘
				if(name){
					//鏀瑰彉涓庢煇琛屾垨鑰呮煇浜涜涓笌name瀵瑰簲鐨勬搷浣滄澘
					for(var i = 0, k = index.length; i < k;i++){//index閬嶅巻锛屾瘡涓�釜绱㈠紩杩涜鏇存敼.
						var indexI = index[i];
						var operatorDataTemp = _define.operatorData[indexI];
						
						for(var operTempIndex = 0, len = operatorDataTemp.length; operTempIndex < len; operTempIndex++){
							if(operatorDataTemp[operTempIndex].name == name){
								//鏁版嵁杩涜璧嬪�鏇挎崲銆�
								_define.operatorData[indexI][operTempIndex] = operatorData[0];//绗竴鏉℃暟鎹洿鎺ユ浛鎹箣銆�
								if(operatorData.length > 1){
									for(var dataIndex = 1, dataLen = operatorData.length; dataIndex < dataLen; dataIndex++){
										_define.operatorData[indexI].splice(operTempIndex + dataIndex -1,0,operatorData[dataIndex]);
									}
								}
								//琛ㄦ牸鐣岄潰鏀瑰彉閫昏緫銆�
								self._changeOperator(isPanel, _define.operatorData, indexI, operTempIndex);
								break;
							}
						}
					}
				}else{
					//鏃爊ame鍙傛暟锛屽垯鏀瑰彉涓巌ndex瀵瑰簲鐨勮鐨勬墍鏈夋搷浣滄澘銆�
					
					for(var i = 0, k = index.length; i < k;i++){//index閬嶅巻锛屾瘡涓�釜绱㈠紩杩涜鏇存敼.
						var indexI = index[i];
						var operatorDataTemp = _define.operatorData[indexI];
						
						//鏇挎崲鏀筰ndex瀵瑰簲鐨勬搷浣滄澘鎵�湁鏁版嵁銆�
						_define.operatorData[indexI] = operatorData;
						//琛ㄦ牸鐣岄潰鏀瑰彉閫昏緫
						self._changeOperator(isPanel, _define.operatorData, indexI);
					}
				}
			}else{
				//鏀瑰彉鎵�湁鐨勬搷浣滈潰鏉�
				_define.operatorData = operatorData;
				self._changeOperator(isPanel, _define.operatorData);
			}
			
		},
		/*
		 * 琛ㄦ牸鎿嶄綔鏍忕晫闈㈣缃�杈�鍐呴儴鏂规硶).
		 * @param (boolean) isPanel 鏄惁鏄搷浣滄澘
		 * @param (int) rowIndex  褰撳墠鎿嶄綔琛岀殑搴忓垪
		 * @param (int) operatorIndex 褰撳墠闇�鏀瑰彉鐨勬搷浣滄澘椤瑰簭鍒�
		 * @param (Array) newOperatorData鏇存柊鍚庣殑鎵�湁鎿嶄綔鏉挎暟鎹�
		 */
		_changeOperator : function(isPanel, newOperatorData, rowIndex, operatorIndex){
			var options = this.options, $el = this.element, self = this, $operatorPanel = this.$domCache.$operatorPanel;
			if(!rowIndex && rowIndex != 0){
					
				if(!newOperatorData || newOperatorData.length == 0){
					$el.find('.__tbodyFinal .__bodyfinal').find('tr').hide();
				}else{
					
					$el.find('.__tbodyFinal .__bodyfinal').find('tr').each(function(i,elemt){
						if(!newOperatorData[i] || newOperatorData[i].length == 0){
							$(this).find('a').hide();
						}else{
							if(!$(this).find('a').size() && isPanel){
								$(this).find('td').append('<a href="javascript:;" class="ue-state-default __operatorPanelBtn" operindex="'+i+'"><span class="uew-icon uew-icon-circle-triangle-s"></span></a>').find('span:not(.uew-icon)').remove();
								$operatorPanel.uedOptPanel('setOpter',[$el.find(".__operatorPanelBtn")]);
								$(this).find('a').show();
							}else if(!isPanel){
								var thA = '';
								for(var j = 0,k = newOperatorData[i].length; j<k; j++){
									thA += '<a href="javascript:;">'+newOperatorData[i][j].label+'</a>';
								}
								$(this).find('td').find('a').remove().end().append(thA).find('span:not(.uew-icon)').remove();
							}
						}	
					});
				}
				
				return;
			}
			
			var $operTr = $el.find('.__tbodyFinal .__bodyfinal').find('tr').eq(rowIndex), newOperatorData = newOperatorData[rowIndex];
			//鏄搷浣滄澘鐨勬儏鍐�
			if(isPanel){
				if(!newOperatorData || newOperatorData.length == 0){
					$operTr.find('a').hide();
				}else{
					if(!$operTr.find('a').size()){ //濡傛灉姝よ鍒濆鍖栧氨娌℃湁鐢熸垚姝よ妭鐐癸紝鍒欒繖閲屾彃鍏ヨ鑺傜偣銆�
						$operTr.find('td').append('<a href="javascript:;" class="ue-state-default __operatorPanelBtn" operindex="' + rowIndex + '"><span class="uew-icon uew-icon-circle-triangle-s"></span></a>').find('span:not(.uew-icon)').remove();
						//閲嶆柊璁剧疆鏄Е鍙戞搷浣滄澘瀵硅薄銆�
						$operatorPanel.uedOptPanel('setOpter',[$el.find(".__operatorPanelBtn")]);
					}
					$operTr.find('a').show();
				}
			}else{
				//type涓簄ormal鐨勬儏鍐�
				if(!newOperatorData || newOperatorData.length == 0){
					$operTr.find('a').hide();
				}else{
					var thA = '';
					for(var j = 0, k = newOperatorData.length; j < k; j++){
						if(!newOperatorData[j]){continue;}
						if(newOperatorData[j].disable){
							thA += '<a href="javascript:;" class="ue-state-disable">' + newOperatorData[j].label + '</a>';
						}else{
							thA += '<a href="javascript:;">' + newOperatorData[j].label + '</a>';
						}
						
					}
					$operTr.find('td').find('a').remove().end().append(thA).find('span:not(.uew-icon)').remove();
					$operTr.find('a').bind('click',function(){
						if(!$(this).hasClass('__operatorPanelBtn')){
							var indexTr = $(this).parents('tr').index();
							var indexA = $(this).index();
							var funArray = newOperatorData[indexA];
							funArray.onclick($el,[parseInt(indexTr)]);
						}
					});
				}
			}
		},
		/*
		 * @description 璁剧疆sequence鏂规硶
		 * @param (Array)currentSequence  褰撳墠鐨剆equence搴忓垪
		 * @param (Array)defaulatSequence 榛樿鐨剆equence搴忓垪
		 * @param (Function)fn 璁剧疆鎴愬姛sequence鎴愬姛鍚庣殑鍥炶皟鍑芥暟銆傞�甯稿湪杩欎釜鏃跺�鍘昏幏鍙栬〃鏍兼暟鎹潵杩涜璁剧疆琛ㄦ牸鏁版嵁.
		 */
		setSequence : function(currentSequence, defaultSequence, fn){
			var options = this.options, $el = this.element, self = this, _define = this._define;
			if(!currentSequence && !defaultSequence){
				return false;
			}else if(!currentSequence && defaultSequence){
				//璁剧疆榛樿鐨刣efaulatSequence
				options.settings[_define.customIndex].defaultSequence = defaultSequence;
				//璁剧疆褰撳墠sequence
				_define.currentSequence = this._copyArray(defaultSequence);
				if(fn){fn(defaultSequence);}
			}else if(currentSequence && defaultSequence){
				//璁剧疆榛樿鐨刣efaulatSequence
				options.settings[_define.customIndex].defaultSequence = defaultSequence;
				//璁剧疆褰撳墠sequence
				_define.currentSequence = currentSequence;
				if(fn){fn(currentSequence);}
			}else if(currentSequence && !defaultSequence){
				//璁剧疆榛樿鐨刣efaulatSequence
				options.settings[_define.customIndex].defaultSequence = defaultSequence;
				//璁剧疆褰撳墠sequence
				_define.currentSequence = currentSequence;
				if(fn){fn(currentSequence);}
			}
		},
		/*
		 * 鑾峰彇checkbox閫変腑鐨勫簭鍒椼�
		 */
		getCheckedIndex : function(){
			var $el = this.element, checkedIndex = [];
			$el.find('.__bodyfront').find('input[type=checkbox]').each(function(index,element){
				if($(this).attr('checked') == 'checked'){
					checkedIndex.push(index);
				}
			});
			return checkedIndex;
		},
		/*
		 * 璁剧疆琛ㄦ牸瀹藉害
		 */
		 setWidth : function(width){
		 	var $el = this.element, self = this;
			if(this._define.width == $el.width()){
				return;
			}
		 	this._tableResize($el,self);
		 },
		 
		/*
		 * 澧炲姞琛ㄦ牸鏁版嵁锛屽湪涓嶆竻闄ゅ凡瀛樺湪鏁版嵁鐨勬儏鍐典笅銆�
		 * param {Array} data 闇�娣诲姞鐨勬暟鎹�
		 */
		addData : function(data){
			var $el = this.element, options = this.options, _define = this._define;
			if(!data || !data.length){
				return false;
			}
			if(!_define.operatorData){
				_define.operatorData = [];
			}
			this._setTableBodyData($el, data, true);
			if(!options.tableBody || !options.tableBody.length){
				options.tableBody = this._copyArray(data);
				this._controlShowOrHide($el,options);
			}else{
			}
			//this._adjustTable($el, options);
			this._adjustHeight($el, options);
			this._adjustOperator($el, options);
		},
		/*
		 * 琛ㄦ牸缁勪欢涓撶敤resize鏂规硶.
		 */
		_uedResize : function(resizeHandle){
			var d = document.documentElement, $el = this.element, self = this, _define = self._define;
			var timer;//閬垮厤resize瑙﹀彂澶氭,褰卞搷鎬ц兘
			var width = d.clientWidth/*, height = d.clientHeight*/;
			$(window).on('resize.uedGrid',function(e){
				//琛ㄦ牸resize鍙猺esize鏄剧ず鐨勮〃鏍硷紝閬垮厤鍑虹幇涓㈠搴︾瓑闂銆傦紙琛ㄦ牸鎭㈠鏄剧ず鏃讹紝鍧囬渶瑕佹墜鍔ㄦ帀resize锛�
				var isHide = !$el.is(':visible'), isOutWindow = $el.hasClass('uew-outside-hidden') || !!$el.parents('.uew-outside-hidden').size();
				if(isHide || isOutWindow){
					return;
				}
				if((width != d.clientWidth || _define.width != $el.width()/* || !_define.stopResize || _define.width != $el.width()|| height != d.clientHeight*/)){
					width = d.clientWidth/*, height = d.clientHeight*/;
					if(timer){clearTimeout(timer);}
					timer = setTimeout(function(){
						resizeHandle($el,self);
					},10);	
				}
			});
			
		},
		stopResize : function(){
			//this._define.stopResize = true;
		},
		
		startResize : function(){
			//this._define.stopResize = false;
			this.resize();
		},
		resize : function(){
			var $el = this.element, isHide = !$el.is(':visible'), isOutWindow = $el.hasClass('uew-outside-hidden') || !!$el.parents('.uew-outside-hidden').size();
			if(isHide || isOutWindow){
				return;
			}
			this._tableResize(this.element, this);
		},
		hideTable : function(){
			this.element.css({'position':'relative','overflow':'hidden','height':0});
		},
		showTable : function(){
			this.element.css({'overflow':'visible','height':'auto'});
		},
		setCheckBoxUsable : function(flag, arrIndex){
			var $el = this.element, 
				hasIndex = arrIndex && arrIndex.length, 
				bodyInput = $el.find('.__tbodyFront').find('input[type=checkbox]'),
				theadInput = $el.find('.__theadFront').find('input[type=checkbox]');
			
			if(flag){
				if(hasIndex){
					for(var i = 0,len = hasIndex;i < len; i++){
						bodyInput.eq(arrIndex[i]).removeAttr('disabled');
					}
					if(bodyInput.size() == $el.find('.__tbodyFront').find('input').not(':disabled').size()){
						theadInput.eq(arrIndex[i]).removeAttr('disabled');
					}
				}else{
					bodyInput.removeAttr('disabled');
					theadInput.removeAttr('disabled');	
				}
				
			}else{
				if(hasIndex){
					for(var i = 0,len = hasIndex;i < len; i++){
						bodyInput.eq(arrIndex[i]).attr('disabled','disabled');
					}
					if(bodyInput.size() == $el.find('.__tbodyFront').find('input[disabled]').size()){
						theadInput.eq(arrIndex[i]).attr('disabled','disabled');
					}
				}else{
					bodyInput.attr('disabled','disabled');
					theadInput.attr('disabled','disabled');
				}
			}
		},
        _init : function() {
            var self = this, options = this.options, $el = this.element;
        },
        /*
		 * 绫诲瀷妫�祴
		 * @param {} variable 闇�妫�祴鐨勫�
		 * @param {String} type 鏄惁涓簍ype绫诲瀷
         */
		_isType : function(variable, type){
			return Object.prototype.toString.call(variable) == '[object '+type+']';
		}
    });
})(jQuery);
