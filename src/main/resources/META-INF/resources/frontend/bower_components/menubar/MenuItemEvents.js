function onItemClick(menuElement, event) {
    var flowElement = menuElement.parentNode.host;
    flowElement.$server.onItemClick();
}




