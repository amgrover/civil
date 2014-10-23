function tickPoint(count,number){
	var start=1;
	var finalOutput= "[";
	var div= Math.floor(number /count) ;
	while(start<=number){
		finalOutput+=start+",";
		start+=div;
	}
	var c=finalOutput.substring(0,number-3);
	c+="]";
	return eval(c);
	
}