package comp18;

import java.util.ArrayList;
import java.util.List;
//import java.math.*;

public class LempelZiv {
	private String _inString, _middleString, _outString;
	public List<String> dicIn = new ArrayList<String>();
	public List<String> dicOut = new ArrayList<String>();
	public LempelZiv(String inicial){
		_inString = inicial;
		makeDic();
		encode();
	}
	public String toEncodedString(){
		return _middleString;
	}
	public String toDecodedString(){
		return _outString;
	}
	private void encode(){
		int j = 0;
		int k = 0;
		_middleString = "";
		String s="", S="", c="";
		while (j<_inString.length()){
			k=j;
			S=c;
			while(isAtDir(S)){//&&k<_inString.length()){
			    //System.out.println("Is at dir: "+ S);
				c = ""+_inString.charAt(k);
				s = S;
				S = S+c;
				k++;
			}
			j=k;
			dicIn.add(""+S);
			//System.out.println(_middleString +"  " +prettyBinary(dicIn.indexOf(s),getB(dicIn.size()-1)));
			_middleString = _middleString + prettyBinary(dicIn.indexOf(s),getB(dicIn.size()-1));



		} 
		//printDic();
		_middleString = _middleString + _inString.charAt(k-1);
		System.out.println(_middleString);
		//printDic();
	}
	public void decode(){
	    int i = dicOut.size();
	    int e = 0;
	    String codedString = _middleString;
	    String actualString = "";
	    _outString = "";
	    boolean endFlag = false;
	    while (codedString.length()>0 && !endFlag){
	        int ends = getB(i);
	        if(ends>codedString.length()-1)
	           ends = codedString.length()-1;
	        actualString = codedString.substring(0,ends);
	        codedString = codedString.substring(ends);
	        //System.out.println(actualString+":"+codedString);
	        //if(actualString!="")
	        e = Integer.parseInt(actualString, 2);
	        
            dicOut.add(dicOut.get(e));
            _outString = _outString + dicOut.get(e);
            //System.out.println(i+":"+dicOut.get(i)+":"+getB(i)+":"+e+":"+dicOut.get(i));
            if(e!=1){
                String aux = dicOut.get(i-1) + dicOut.get(e).charAt(0);
                //System.out.println(i-1+":"+ dicOut.get(i-1) +"+"+ dicOut.get(e).charAt(0) +"="+ aux);
                dicOut.set(i-1,aux);
            }
            if(codedString.substring(0).length() < getB(i+1)) 
                endFlag = true;
	        i++;
	    }
	    _outString = _outString + codedString;
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
		dicOut.add("");
		for (i = 0; i < _inString.length(); i++){
			if (  !dicIn.contains(""+_inString.charAt(i))){
			    dicIn.add("" + _inString.charAt(i) );
			    dicOut.add("" + _inString.charAt(i) );
			}
				
		}
	}
	
	public boolean isAtDirOut(String S){
		return dicOut.contains(S);
	}
	public void printDicOut(){
	    for (int i = 0; i < dicOut.size(); i++){
			System.out.println(i + " : " + dicOut.get(i));
		}
	}
	
	public boolean isAtDir(String S){
		return dicIn.contains(S);
	}
}



