function validate(){
    var frm = document.login;
    var user_id = frm.id.value;
    var user_password = frm.password.value;
    if(user_id.length === 0 || user_id === ''){
        alert('Id need');
        return;
    }else if(user_password.length === 0 || user_password === ''){
        alert('Pwd need');
        return;
    }else{
        frm.method = 'post';
        frm.action = '/login2';
        frm.submit();
    }
}