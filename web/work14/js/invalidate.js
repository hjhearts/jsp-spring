function checkInvalidate(){
    var form = document.addForm;
    var id = form.id;
    var pwd = form.pwd;
    var re_pwd = form.re_pwd;
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
        form.submit();
    }
}