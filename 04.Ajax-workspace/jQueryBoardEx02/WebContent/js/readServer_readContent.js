/**
 * 
 */
var readServer = function() {
		$.ajax({
			url:'./list.json',
			type:'get',
			dataType:'json',
			success:function(result){
				if (result.flag == 0) {
					var outHtml = '';
					$.each(result.data, function(index, item){
						outHtml += '<h3 idx="' + item.seq + '">' + item.seq + ') <span name=subject>' + item.subject + '</span> [' +  item.writer + '] (<span name=hit>' + item.hit + '</span>)' +  '</h3>';
						outHtml += '<div idx="' + item.seq + '">';
						outHtml += '<div>' + item.wdate + '</div>';
						outHtml += '<div name="subject' + item.seq + '">' + '</div>';
						outHtml += '<br />';
						outHtml += '<hr noshade="noshade" />';
						outHtml += '<div name="content' + item.seq + '">' + '</div>';
						outHtml += '<br />';
						outHtml += '<hr noshade="noshade" />';
						outHtml += '<br />';
						outHtml += '<div>';
						outHtml += '<button idx="' + item.seq + '" action="modify" class="action">수정</button>';
						outHtml += '<button idx="' + item.seq + '" action="delete" class="action">삭제</button>';
						outHtml += '</div>';
						outHtml += '</div>';
					});
					$('#accordion').empty();
					$('#accordion').append(outHtml);
					$( '#accordion' ).accordion({
						active : false,
						collapsible: true,
						heightStyle: 'content'
					});
					$( 'button.action' ).button();
					$('#accordion').accordion('refresh');
					
					$('h3').on('click', function() {
						// 눌린것의 값을 가져오고 
						var idx = $('h3[tabindex=0]').attr('idx');
						// $('div[class*=ui-accordion-content-active]').attr('idx') 이것도 눌린것
						// false면 열림 true면 닫힘
						var hidden = $('div[idx=' + idx + ']').attr('aria-hidden');
						
						if (hidden == 'false') {
							readContent(idx, "1");
						}
					});
				}
			},
			error : function(){
				console.log('error');
			}
		})
	};
	// 수정이 되었다면 modifyOk는 0이고, DAO에서 조회수를 올리지 않는다.
	// 수정이 아닌 글읽기를 통하여 들어왔다면 modifyOk는 1이고 조회수를 올린다.
	var readContent = function(seq, modifyOk) {
		$.ajax({
			url:'./view.json',
			data: {
				seq : seq,
				modifyOk : modifyOk
			},
			type:'get',
			dataType:'json',
			success:function(result){
				if (result.flag == 0) {
					// 리스트에 보이는 제목 변경
					$('h3[tabindex=0] span[name=subject]').empty();
					$('h3[tabindex=0] span[name=subject]').append(result.data.subject);
					// 내용에 보이는 제목 변경
					$('div[name=subject' + seq + ']').empty();
					$('div[name=subject' + seq + ']').append(result.data.subject);
					// 내용에 보이는 내용 변경
					$('div[name=content' + seq + ']').empty();
					$('div[name=content' + seq + ']').append(result.data.content);
					// 리스트에 보이는 조회수 변경
					$('h3[tabindex=0] span[name=hit]').empty();
					$('h3[tabindex=0] span[name=hit]').append(result.data.hit);
				}
			},
			error : function(){
				console.log('error');
			}
		})
	}