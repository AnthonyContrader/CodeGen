 function FormatDate(){
    var i=0
    while(document.getElementById(i) != null){
      var temp = document.getElementById(i).value;
      var data = temp.substring(0, 10);
      var ora = temp.substring(11, 19);
      var date = data.split("-");
      var data=date[2]+"/"+date[1]+"/"+date[0];

      document.getElementById(i).value=data+" "+ora;
      i++;
    }
  }