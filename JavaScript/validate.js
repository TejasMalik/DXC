function mydisp(action)
{
	if (action=="none") 
	{
		document.getElementById('cities').style.display = "block";
	} 
	else
	{
		document.getElementById('cities').style.display = "none";
	}

   var x =document.f1.state.options
   [document.f1.state.selectedIndex].text;	
	alert(x);


	var apCities = new Array("Hyderabad","Vizag","Vijayawada","A","B","P");
	var tnCities = new Array("Chennai","Banglore","Coimbatore","Nellore","Terunveli","Hosur");
	var knCities = new Array("Mysore","Mandia","Raichur","Hubli","Hasan","Bellary");
	var mnCities = new Array("Mumbai","Pune","Nagpur","Kurla","Thane","Bandra");
	var ksCities = new Array("Jammu","Kashmir","Udham","Vashno","A","B");
	var keralaCities = new Array("Kochi","Trnddrim","Palakkad","Kottayam","LuluMall","Wayanad");



	var y = document.f1.cities;

	if(x=="AndhraPradesh")
	{
		y.length = 0;
		for(i=0;i<apCities.length;i++)
		{
			option = new Option(apCities[i]);
			y.options[i] = option;
      		}
   	}
	if(x=="TamilNadu")
	{
		y.length = 0;
		for(i=0;i<tnCities.length;i++)
		{
			option = new Option(tnCities[i]);
			y.options[i] = option;
		}
   	}
	if(x=="Karnataka")
	{
		y.length = 0;
		for(i=0;i<knCities.length;i++)
		{
			option = new Option(knCities[i]);
			y.options[i] = option;
		}
   	}
	if(x=="Maharashtra")
	{
		y.length = 0;
		for(i=0;i<mnCities.length;i++)
		{
			option = new Option(mnCities[i]);
			y.options[i] = option;
		}
   	}
	if(x=="Kashmir")
	{
		y.length = 0;
		for(i=0;i<ksCities.length;i++)
		{
			a= new Option(ksCities[i]);
			y.options[i] = a;
		}
   	}
	if(x=="Kerala")
	{
		y.length = 0;
		for(i=0;i<keralaCities.length;i++)
		{
			a = new Option(keralaCities[i]);
			y.options[i] = a;
		}
   	}

}