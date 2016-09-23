package comp18;

import java.util.ArrayList;
import java.util.List;
//import java.math.*;

public class LempelZiv {
	private String _inString, _middleString, _outString;
	public List<String> dicIn = new ArrayList<String>();
	public LempelZiv(String inicial){
		_inString = inicial;
		makeDic();
		encode();
	}
	public String toEncodedString(){
		return _middleString;
	}
	private void encode(){
		int j = 0;
		int k = 0;
		_middleString = "";
		String s="", S="", c="";
		while (j<_inString.length()){
			k=j;
			S=c;
			while(isAtDir(S)){
				c = ""+_inString.charAt(k);
				s = S;
				S = S+c;
				k++;
			}
			dicIn.add(""+S);
			j=k;
			_middleString = _middleString + prettyBinary(dicIn.indexOf(s),getB(dicIn.size()-1));

		} 
		_middleString = _middleString + _inString.charAt(k-1);
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
		while(Math.pow(2,(b))<i){b++;}
		return b;
	}
	public void printDic(){
	    for (int i = 0; i < dicIn.size(); i++){
			System.out.println(i + " : " + dicIn.get(i));
		}
	}
	
	public void makeDic(){
		int i;
		dicIn.add("");
		for (i = 0; i < _inString.length(); i++){
			if (  !dicIn.contains(""+_inString.charAt(i)))
				dicIn.add("" + _inString.charAt(i) );
		}
	}
	
	public boolean isAtDir(String S){
		return dicIn.contains(S);
	}
	
}


