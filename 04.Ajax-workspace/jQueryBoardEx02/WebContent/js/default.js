/**
 * 
 */
	var write_ok = function() {
		$.ajax({
			url:'./write_ok.json',
			data : {
				subject : $('#writeDialog #w_subject').val(),
				writer : $('#writeDialog #w_writer').val(),
				mail : $('#writeDialog #w_mail').val(),
				password : $('#writeDialog #w_password').val(),
				content : $('#writeDialog #w_content').val()
			},
			type:'get',
			dataType:'json',
			success:function(result){
				if (result.flag == 0) {
					alert('글쓰기에 성공하였습니다.');
					$('#writeDialog').dialog('close');
					readServer();
				} else {
					alert('글쓰기에 실패하였습니다.');
				}
			},
			error : function(){
				console.log('error');
			}
		})
	}
	var readModify = function(seq) {
		$.ajax({
			url:'./modify.json?seq=' + seq,
			type:'get',
			dataType:'json',
			success:function(result){
				if (result.flag == 0) {
					$('#modifyDialog #m_password').val('');
					$('#modifyDialog #m_subject').val(result.data.subject);
					$('#modifyDialog #m_writer').val(result.data.writer);
					$('#modifyDialog #m_mail').val(result.data.mail);
					$('#modifyDialog #m_content').val(result.data.content);
				} else {
					alert('error');
				}
			},
			error : function(){
				console.log('error');
			}
		})
	}
	var modify_ok = function(seq) {
		$.ajax({
			url:'./modify_ok.json',
			data : {
				seq : seq,
				subject : $('#modifyDialog #m_subject').val(),
				writer : $('#modifyDialog #m_writer').val(),
				mail : $('#modifyDialog #m_mail').val(),
				password : $('#modifyDialog #m_password').val(),
				content : $('#modifyDialog #m_content').val()
			},
			type:'get',
			dataType:'json',
			success:function(result){
				if (result.flag == 0) {
					alert('수정에 성공하였습니다.');
					$('#modifyDialog').dialog('close');
					readContent(seq, "0");
				} else if (result.flag == 1){
					alert('비밀번호를 확인해주세요.');
				} else {
					alert('수정에 실패하였습니다.');
				}
			},
			error : function(){
				console.log('error');
			}
		})
	}
	var readDelete = function(seq) {
		$.ajax({
			url:'./delete.json?seq=' + seq,
			type:'get',
			dataType:'json',
			success:function(result){
				if (result.flag == 0) {
					$('#deleteDialog #d_password').val('');
					$('#deleteDialog #d_subject').val(result.data.subject);
				} else {
					alert('error');
				}
			},
			error : function(){
				console.log('error');
			}
		})
	}
	var delete_ok = function(seq) {
		$.ajax({
			url:'./delete_ok.json',
			data : {
				seq : seq,
				password : $('#deleteDialog #d_password').val(),
			},
			type:'get',
			dataType:'json',
			success:function(result){
				if (result.flag == 0) {
					alert('삭제에 성공하였습니다.');
					$('#deleteDialog').dialog('close');
					readServer();
				} else if (result.flag == 1){
					alert('비밀번호를 확인해주세요.');
				} else {
					alert('삭제에 실패하였습니다.');
				}
			},
			error : function(){
				console.log('error');
			}
		})
	}