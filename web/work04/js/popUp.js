function setPopUpStart(obj){
    if(obj.checked === true){
        var expireDate = new Date();
        expireDate.setDate(expireDate.getDate()+1);
        document.cookie = 'noShowPop=true;path=/;expires=' + expireDate.toDateString();
        window.close();
    }
}