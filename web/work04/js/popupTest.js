window.onload = pageLoad;
function pageLoad(){
    var noShowPop = getCookieValue();
    if(noShowPop !== 'true'){
        window.open('popUp.html', 'pop', 'width=400,height=500,history=no' +
            'resizable=no,status=no,scrollbars=yes,menubar=no');
    }
}
function getCookieValue(){
    var result = "false";
    if(document.cookie !== '') {
        var cookies = document.cookie.split(';');
        for (var i = 0; i < cookies.length; i++) {
            var element = cookies[i].split('=');
            var value = element[0];
            value = value.replace(/^\s*/, '');
            if(value === 'noShowPop'){
                result = element[i];
            }
        }
    }
    return result;
}
function deleteCookie(){
    document.cookie = 'noShowPop=' + 'false' + ';path=/; expires=-1';
}