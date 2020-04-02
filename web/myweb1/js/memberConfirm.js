var email = document.getElementById('email');
var alt = document.getElementById('alt');
email.addEventListener('keyup', function(e){
    if(chkEmail(email.value)){
        alt.hidden = true;
    }else{
        alt.hidden = false;
    }
});
function fn_memberConfirm(){
    var form = document.addFrm;
    var id = form.user_id;
    var pwd = form.password;
    var re_pwd = form.password_confirm;
    var name = form.name;
    var email = form.email;
    if(id.value === '' || id.value.length === 0){
        alert('Id is necessary');
    }else if(pwd.value === '' || pwd.value.length === 0){
        alert('Password is necessary');
    }else if(re_pwd.value === '' || re_pwd.value.length === 0){
        alert('Password-confirm is necessary');
    }else if(re_pwd.value !== pwd.value){
        alert('Password is not correct');
    }else if(name.value === '' || name.value.length === 0){
        alert('Name is necessary');
    }else if(email.value === '' || email.value.length === 0){
        alert('Email is necessary');
    }else{
        form.method = 'post';
        form.action = '/member2';
        form.submit();
    }
}
function chkEmail(str) {
    var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (regExp.test(str)) return true;
    else return false;
}