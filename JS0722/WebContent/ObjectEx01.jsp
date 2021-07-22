<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객체</title>
<script type="text/javascript">
    var obj1 = {}
    var obj2 = {
    		"name" : "김머현",
    		"age"  : 26,
    		"gender" : true,
    		"view" : function() {
				return (this.name + "(" + this.age + "세, " + (this.gender?'남':'여')+")"); 
			}
    };
    document.write(typeof(obj1) + " : " + obj1 + "<br>");
    document.write(typeof(obj2) + " : " + obj2 + "<br>");
    document.write(obj2.name + "<br>");
    document.write(obj2["name"] + "<br>");
    document.write(obj2["age"] + "<br>");
    document.write(obj2.gender + "<br>");
    document.write(obj2.view() + "<br>");
    
    obj2.hobby = ["상","자","몽","쉘"];
    document.write(obj2.hobby + "<br>");
</script>
</head>
<body>

</body>
</html>