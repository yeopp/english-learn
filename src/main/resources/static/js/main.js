
$.ajaxSetup({
    beforeSend: function (event, jqxhr) {
        console.log("ajax set up");
        if(jqxhr.type.toUpperCase() === 'POST'){
            event.setRequestHeader('X-CSRF-Token', document.querySelector("meta[name=_csrf]").getAttribute("value"));
        }
    }
});