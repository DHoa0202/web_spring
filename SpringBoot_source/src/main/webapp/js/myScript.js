// Create element fade on the screen
const fade = document.createElement("div");
fade.setAttribute('class', "offcanvas-backdrop fade show");

// _______________________________________________
// Dropdown
function drdActive(p) {
    var element = p.getElementsByClassName("dropdown-menu")[0];
    var cls = element.getAttribute("class");
    setClass(element, cls);
}

// offcanvas 
function canvasActive(id) {
    var element = document.getElementById(id);
    var cls = element.getAttribute("class");
    setClass(element, cls);
    // Set style visibility = boolean ? hidden : visible;
    if (cls.search("show") > -1) {
        document.body.removeChild(fade)
        element.style.visibility = "hidden";
    } else {
        document.body.appendChild(fade);
        element.style.visibility = "visible";
    }
}

// Accordion
function acdActive(id) {
    var element = document.getElementById(id);
    var cls = element.getAttribute("class");
    setClass(element, cls);
}

/**
* <h3>show password form input</h3>
* @param id of input password => change type to password or text
*/
function showPass(id) {
	var newPass = document.querySelector(id);
	newPass.type = newPass.type=="text" ? "password" : "text";
}

/**
* <h3>show acctive</h3>
* @param p's param("this") of the class you want to active
* @param clearClasses're any named of the class to inactive
*/
function buttonActive(p, namedClasses){
    var all = document.querySelectorAll(namedClasses);
    for (let key in all) {
        if (Object.hasOwnProperty.call(all, key) ) {
            setClass(all[key], all[key] != p);
        }
    }

    function setClass(param, leave) {
        var txt = param.getAttribute("class");
        if(leave) txt = txt.replace(" active", '');
        else txt = txt.replace(" active", '')+" active";
        param.setAttribute("class", txt);
    }
}

function buttonClick(id, open) {
    var element = document.getElementById(id);
    if (open) {
        element.style.visibility = "visible";
        cls = element.getAttribute("class");
        element.setAttribute('class', (cls += " show"));
    } else {
        element.style.visibility = "hidden";
        element.getAttribute("class").replace(" show", "");
    }
}

/** _______________________________________________
 * @param e element
 * @param cls class
 *  */
function setClass(e, cls) {
    // e is element, cls is class's attribute
    // replace content of the class
    e.setAttribute("class",
        cls.search("show") > -1 ? cls.replace(" show", "") : (cls + " show")
    );
}