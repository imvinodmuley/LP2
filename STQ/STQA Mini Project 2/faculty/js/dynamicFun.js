
function insertDivBooks(){

  var cnt = document.getElementById("cntBooks").value;
  var form = document.getElementById("multi-ip-books");

  for(var i = 0; i < cnt; i++){

    var frm = document.createElement("div");
    frm.setAttribute("class", "inner-multidiv");
    frm.className += " cssanimation";
    frm.className += " sequence";
    frm.className += " fadeInBottom";

    var author = document.createElement("input"); 
    var year = document.createElement("input"); 
    var details = document.createElement("input"); 
    

    author.setAttribute("type", "text");
    author.setAttribute("placeholder","Name of Author");
    author.setAttribute("name", "bauthor" + i);

    year.setAttribute("type", "text");
    year.setAttribute("placeholder", "Year");
    year.setAttribute("name", "byear" + i);

    details.setAttribute("type", "text");
    details.setAttribute("placeholder", "Book Details");
    details.setAttribute("name", "bdetails" + i);


    frm.appendChild(author);
    frm.appendChild(year);
    frm.appendChild(details);
    

    form.appendChild(frm);
    
  }
  document.getElementById("books-add-div").style.display = "none";
}

function insertDivQuali(){


  var cnt = document.getElementById("cntQuali").value;
  var form = document.getElementById("multi-ip-quali");

  for(var i = 0; i < cnt; i++){

    var frm = document.createElement("div");
    frm.setAttribute("class", "inner-multidiv");
    frm.className += " cssanimation";
    frm.className += " sequence";
    frm.className += " fadeInBottom";

    frm.setAttribute("id", "qualiDynamicDiv");


    var degree = document.createElement("select"); // title
    var specialization = document.createElement("input"); // AUthor
    var university = document.createElement("input"); // type
    var college = document.createElement("input"); // desc
    var yearpassing = document.createElement("input"); // year

    degree.setAttribute("name", "qdegree" + i);
    // Appending Options to degree
    var DegreeArray = ['PHD', 'ME/M.Tech', 'BE/B.Tech', 'Other'];
    for (var i1 = 0; i1 < DegreeArray.length; i1++) {
        var option = document.createElement("option");
        option.value = DegreeArray[i1];
        option.text = DegreeArray[i1];
        degree.appendChild(option);
    }

    specialization.setAttribute("type", "text");
    specialization.setAttribute("placeholder", "Specialization");
    specialization.setAttribute("name", "qspecialization" + i);

    university.setAttribute("type", "text");
    university.setAttribute("placeholder", "Name of university");
    university.setAttribute("name", "quniversity" + i);

    college.setAttribute("type", "text");
    college.setAttribute("placeholder", "Name of College");
    college.setAttribute("name", "qcollege" + i);

    yearpassing.setAttribute("type", "text");
    yearpassing.setAttribute("placeholder", "Year of Passing");
    yearpassing.setAttribute("name", "qyearpassing" + i);


    frm.appendChild(degree);
    frm.appendChild(specialization);
    frm.appendChild(university);
    frm.appendChild(college);
    frm.appendChild(yearpassing);
    
    form.appendChild(frm);
    
  }
  document.getElementById("quali-add-div").style.display = "none";
}


function insertDivjornals(){
  
  var cnt = document.getElementById("cntJornals").value;
  var form = document.getElementById("multi-ip-jornals");

  for(var i = 0; i < cnt; i++){

    var frm = document.createElement("div");
    frm.setAttribute("class", "inner-multidiv");
    frm.className += " cssanimation";
    frm.className += " sequence";
    frm.className += " fadeInBottom";

    var title = document.createElement("input"); // title
    var author = document.createElement("input"); // AUthor
    var type = document.createElement("input"); // type
    var desc = document.createElement("input"); // desc
    var year = document.createElement("input"); // year

    title.setAttribute("type", "text");
    title.setAttribute("placeholder","Title");
    title.setAttribute("name", "jtitle" + i);

    author.setAttribute("type", "text");
    author.setAttribute("placeholder", "Author");
    author.setAttribute("name", "jauthor" + i);

    type.setAttribute("type", "text");
    type.setAttribute("placeholder", "Type");
    type.setAttribute("name", "jtype" + i);

    desc.setAttribute("type", "text");
    desc.setAttribute("placeholder", "Description");
    desc.setAttribute("name", "jdesc" + i);

    year.setAttribute("type", "text");
    year.setAttribute("placeholder", "Year");
    year.setAttribute("name", "jyear" + i);


    frm.appendChild(title);
    frm.appendChild(author);
    frm.appendChild(type);
    frm.appendChild(desc);
    frm.appendChild(year);

    form.appendChild(frm);
    
  }
  document.getElementById("jornals-add-div").style.display = "none";
}

function insertDivPatents(){

  var cnt = document.getElementById("cntPatents").value;
  var form = document.getElementById("multi-ip-Patents");

  for(var i = 0; i < cnt; i++){

    var frm = document.createElement("div");
    frm.setAttribute("class", "inner-multidiv");
    frm.className += " cssanimation";
    frm.className += " sequence";
    frm.className += " fadeInBottom";
   
    var author = document.createElement("input"); // Author
    var desc = document.createElement("input"); // desc
    var year = document.createElement("input"); // year

    author.setAttribute("type", "text");
    author.setAttribute("placeholder", "Author");
    author.setAttribute("name", "pauthor" + i);

    desc.setAttribute("type", "text");
    desc.setAttribute("placeholder", "Type");
    desc.setAttribute("name", "pdesc" + i);

    year.setAttribute("type", "text");
    year.setAttribute("placeholder", "Year");
    year.setAttribute("name", "pyear" + i);
   
    frm.appendChild(author);
    frm.appendChild(desc);
    frm.appendChild(year);

    form.appendChild(frm);
    
  }
  document.getElementById("patent-add-div").style.display = "none";
}

function insertDivConferences(){

  var cnt = document.getElementById("cntConf").value;
  var form = document.getElementById("multi-ip-Conf");

  for(var i = 0; i < cnt; i++){

    var frm = document.createElement("div");
    frm.setAttribute("class", "inner-multidiv");
    frm.className += " cssanimation";
    frm.className += " sequence";
    frm.className += " fadeInBottom";
    
    var title = document.createElement("input"); // title
    var type = document.createElement("input"); // type
    var desc = document.createElement("input"); // desc
    var year = document.createElement("input"); // year

    title.setAttribute("type", "text");
    title.setAttribute("placeholder","Title");
    title.setAttribute("name", "ctitle" + i);

    type.setAttribute("type", "text");
    type.setAttribute("placeholder", "Type");
    type.setAttribute("name", "ctype" + i);

    desc.setAttribute("type", "text");
    desc.setAttribute("placeholder", "Description");
    desc.setAttribute("name", "cdesc" + i);

    year.setAttribute("type", "text");
    year.setAttribute("placeholder", "Year");
    year.setAttribute("name", "cyear" + i);


    frm.appendChild(title);
    frm.appendChild(type);
    frm.appendChild(desc);
    frm.appendChild(year);

    form.appendChild(frm);
  }
  document.getElementById("conf-add-div").style.display = "none";
}