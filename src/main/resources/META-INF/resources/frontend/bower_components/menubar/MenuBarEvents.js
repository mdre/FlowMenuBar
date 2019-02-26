function onMenuBarClick(menuElement, event) {
    var rect = menuElement.getBoundingClientRect();
    console.log(rect.top, rect.right, rect.bottom, rect.left);

    var flowElement = menuElement.parentNode.host;
    flowElement.$server.onMenuBarClick(rect.bottom, rect.left);
}

