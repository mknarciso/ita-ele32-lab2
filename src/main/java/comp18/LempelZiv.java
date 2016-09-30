package comp18;

import java.util.ArrayList;
import java.util.List;
//import java.math.*;

public class LempelZiv {
	private String _inString, _middleString, _outString;
	public List<String> dicIn = new ArrayList<String>();
	public List<String> dicOut = new ArrayList<String>();
	public LempelZiv(String inicial)
	{
		_inString = inicial;
		makeDic();
		encode();
	}
	public String toEncodedString()
	{
		return _middleString;
	}
	public String toDecodedString()
	{
		return _outString;
	}
	private void encode()
	{
		//System.out.println("Comecando a encodar!");
		
		int j = 0;
		int k = 0;
		_middleString = "";
		String s="", S="", c="";
		while (j<_inString.length())
		{
			k=j;
			S=c;
			while(isAtDir(S))
			{
				//&&k<_inString.length()){
			    //System.out.println("Is at dir: "+ S);
			    if (k < _inString.length())
			    	c = "" +_inString.charAt(k);
				s = S;
				S = S+c;
				k++;
			}
			j=k;
			dicIn.add(""+S);
			//System.out.println(_middleString +"  " +prettyBinary(dicIn.indexOf(s),getB(dicIn.size()-1)));
			if (k - 1 < _inString.length())
				_middleString = _middleString + prettyBinary(dicIn.indexOf(s),getB(dicIn.size()-1));
			else _middleString = _middleString + prettyBinary(dicIn.indexOf(s.substring(0, s.length() - 1)),getB(dicIn.size()-1));
			
		} 
		//System.out.println("k = " + k);
		
    	_middleString = _middleString + _inString.charAt( _inString.length() - 1 );
		
		//System.out.println(_middleString);
		//printDic();
	}
	public void decode()
	{
	    int i = dicOut.size();
	    int e = 0;
	    String codedString = _middleString;
	    String actualString = "";
	    String currentString = "";
	    _outString = "";
	    boolean endFlag = false;
	    
	    //boolean pegar_o_ultimo = true;
	    
	    while (codedString.length()>0 && !endFlag)
	    {
	        int ends = getB(i);
	        if(ends>codedString.length()-1)
	           ends = codedString.length()-1;
	        actualString = codedString.substring(0,ends);
	        codedString = codedString.substring(ends);
	        //System.out.println(actualString+":"+codedString);
	        //if(actualString!="")
	        e = Integer.parseInt(actualString, 2);
	        
	        //System.out.println("e = " + e + ", i = " + i);
	        //System.out.println("CodedString:" + codedString);
	        
	        if (e < dicOut.size())
	        {
	        	_outString = _outString + dicOut.get(e);
	        
	        	if (!dicOut.contains(currentString + dicOut.get(e).charAt(0)    ))
	        	{
	        		dicOut.add(currentString + dicOut.get(e).charAt(0) );
	        	}
	        	currentString = dicOut.get(e);
	        }
	        else
	        {
	        	//pegar_o_ultimo = false;
	        	dicOut.add(currentString + currentString.charAt(0));
	        	        	
	        	currentString = currentString + currentString.charAt(0);
	        	
	        	_outString = _outString + currentString;
	        	//System.out.println("Entrou no caso patológico!");
	        	
	        }  
	        
	        
	        
	        
	        if(codedString.substring(0).length() < getB(i+1)) 
	        	endFlag = true;
	        
	        //System.out.println("OutString:" + _outString);
	        
	        //printDicOut();
	        
	        //System.out.println("\n");
	        
	        i++;
	    }
	    
	    //if (pegar_o_ultimo)
	    _outString = _outString + codedString;
	    	
	    //printDic();
	
	}
	
	
	public String prettyBinary(int value,int chars){
	    String result = Integer.toString(value,2);
	    while (result.length()<chars){
	       result = "0"+result;
        }
	    return result;
	}
	
	
	public int getB(int i){
		int b = 1;
		while(Math.pow(2,(b))<i)
			b++;
		return b;
	}
	public void printDic(){
	    for (int i = 0; i < dicIn.size(); i++)
	{
			System.out.println(i + " : " + dicIn.get(i));
		}
	}
	
	public void makeDic()
	{
		int i;
		dicIn.add("");
		dicOut.add("");
		for (i = 0; i < _inString.length(); i++)
		{
			if (  !dicIn.contains(""+_inString.charAt(i)))
			{
			    dicIn.add("" + _inString.charAt(i) );
			    dicOut.add("" + _inString.charAt(i) );
			}
		}
	}
	
	public boolean isAtDirOut(String S)
	{
		return dicOut.contains(S);
	}
	public void printDicOut()
	{
	    System.out.println("Dicionário de Saída:");
		for (int i = 0; i < dicOut.size(); i++){
			System.out.println(i + " : " + dicOut.get(i));
		}
	}
	
	public boolean isAtDir(String S)
	{
		return dicIn.contains(S);
	}
}