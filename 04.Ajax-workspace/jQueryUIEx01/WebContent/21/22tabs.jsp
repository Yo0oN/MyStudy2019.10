<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-size: 80%;
}

.ui-tabs {
	width: 600px;
}
</style>
<link rel="stylesheet" href="../css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var tabTitle = $('#tab_title'), tabContent = $('#tab_content'),
			tabTemplate = '<li><a href="\#{href}">\#{label}</a><span class="ui-icon ui-icon-close" role="presentation">Remove Tab</span></li>',
			tabCounter = 2;

		var tabs = $('#tabs').tabs();

		// tab 추가 버튼을 누르면 띄워지는 dialog창
		var dialog = $('#dialog').dialog({
			autoOpen : false,
			modal : true,
			buttons : {
				Add : function(){
					addTab();
					$(this).dialog('close');
				},
				Cancel : function() {
					$(this).dialog('close');
				}
			},
			// 창이 닫힐경우 form을 초기화시킨다.
			close : function() {
				form[0].reset();
			}
		});

		// 탭을 추가해주는 양식(dialog)에서 form태그를 찾은 후
		// 전송이 된다면 addTab함수를 실행하고, dialog를 닫는다.
		var form = dialog.find('form').on('submit', function(event) {
			addTab();
			dialog.dialog('close');
			event.preventDefault();
		})
		
		function addTab () {
			var label = tabTitle.val() || 'Tab ' + tabCounter,
				id = 'tabs-' + tabCounter,
				li = $(tabTemplate.replace( /#\{href\}/g, "\#" + id ).replace( /#\{label\}/g, label ) ),
				tabContentHtml = tabContent.val() || "Tab " + tabCounter + " content.";
	 		tabs.find('.ui-tabs-nav').append(li);
	 		tabs.append('<div id="' + id + '"><p>' + tabContentHtml + '</p></div>');
	 		tabs.tabs('refresh');
	 		tabCounter++;
		}

		// 추가버튼을 누르면 dialog 열기
		$('#add_tab').button().on('click', function(){
			dialog.dialog('open');
		});

		// Close icon: removing the tab on click
	    tabs.on( "click", "span.ui-icon-close", function() {
	      var panelId = $( this ).closest( "li" ).remove().attr( "aria-controls" );
	      $( "#" + panelId ).remove();
	      tabs.tabs( "refresh" );
	    });
	 
	    tabs.on( "keyup", function( event ) {
	      if ( event.altKey && event.keyCode === $.ui.keyCode.BACKSPACE ) {
	        var panelId = tabs.find( ".ui-tabs-active" ).remove().attr( "aria-controls" );
	        $( "#" + panelId ).remove();
	        tabs.tabs( "refresh" );
	      }
	    });
	});
</script>
</head>
<body>
	<!-- tab 추가 버튼을 누르면 생기는 dialog -->
	<div id="dialog" title="Tab data">
		<form>
			<fieldset class="ui-helper-reset">
				<label for="tab_title">Title</label>
				<input type="text"
					name="tab_title" id="tab_title" value="Tab Title"
					class="ui-widget-content ui-corner-all">
				<label for="tab_content">Content</label>
				<textarea name="tab_content" id="tab_content"
					class="ui-widget-content ui-corner-all">Tab content</textarea>
			</fieldset>
		</form>
	</div>
	<button id="add_tab">Add Tab</button>
	<div id="tabs">
		<ul>
			<!-- tab의 목록 부분. 링크를 이동하여
				목록을 누르면 해당 id를 찾아 해당 내용으로 간다. -->
			<li><a href="#tabs-1">Nunc tincidunt</a><span
				class="ui-icon ui-icon-close" role="presentation">Remove Tab</span></li>
			<li><a href="#tabs-2">Proin dolor</a><span
				class="ui-icon ui-icon-close" role="presentation">Remove Tab</span></li>
			<li><a href="#tabs-3">Aenean lacinia</a><span
				class="ui-icon ui-icon-close" role="presentation">Remove Tab</span></li>
		</ul>
		<div id="tabs-1">
			<!-- tab의 내용부분 -->
			<p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a,
				risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris.
				Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem.
				Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo.
				Vivamus sed magna quis ligula eleifend adipiscing. Duis orci.
				Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam
				molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut
				dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique
				tempus lectus.</p>
		</div>
		<div id="tabs-2">
			<p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus
				gravida ante, ut pharetra massa metus id nunc. Duis scelerisque
				molestie turpis. Sed fringilla, massa eget luctus malesuada, metus
				eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet
				fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam.
				Praesent in eros vestibulum mi adipiscing adipiscing. Morbi
				facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut
				posuere viverra nulla. Aliquam erat volutpat. Pellentesque
				convallis. Maecenas feugiat, tellus pellentesque pretium posuere,
				felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris
				consectetur tortor et purus.</p>
		</div>
		<div id="tabs-3">
			<p>Mauris eleifend est et turpis. Duis id erat. Suspendisse
				potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque
				rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante.
				Class aptent taciti sociosqu ad litora torquent per conubia nostra,
				per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim
				commodo pellentesque. Praesent eu risus hendrerit ligula tempus
				pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a,
				lacus.</p>
			<p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at,
				semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra
				justo vitae neque. Praesent blandit adipiscing velit. Suspendisse
				potenti. Donec mattis, pede vel pharetra blandit, magna ligula
				faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque.
				Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi
				lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean
				vehicula velit eu tellus interdum rutrum. Maecenas commodo.
				Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus
				hendrerit hendrerit.</p>
		</div>
	</div>
</body>
</html>