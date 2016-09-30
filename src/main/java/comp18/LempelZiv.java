
package comp18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.ByteBuffer;
import java.util.List;
//import java.math.*;

public class LempelZiv {
	private String _inString, _middleString, _outString, _OriginalString;
	byte[] _byteMiddleString; 
	public List<String> dicIn = new ArrayList<String>();
	public List<String> dicOut = new ArrayList<String>();
	public LempelZiv()
	{
	}
	public LempelZiv(String inicial)
	{
		_inString = inicial;
		_OriginalString = inicial;
		makeDic();
		encode();
	}
	public void addFileToEncode(String filename) throws IOException {
	    try{
    		_inString = readFile("./src/data/"+filename);
		    _OriginalString = _inString;
    		makeDic();
    		encode();
    		}catch(IOException e){
            e.printStackTrace();
        }
	}
    String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
    public void toByte(){
        short a = Short.parseShort(_middleString, 2);
        ByteBuffer bytes = ByteBuffer.allocate(2).putShort(a);
        _byteMiddleString = bytes.array();
    }
    public void printBytes(){
        //System.out.println(_byteMiddleString);
        System.out.println( byteArrayToHex( _byteMiddleString ) );
    }
    public static String byteArrayToHex(byte[] a) {
       StringBuilder sb = new StringBuilder(a.length * 2);
       for(byte b: a)
          sb.append(String.format("%02x", b & 0xff));
       return sb.toString();
    }
	public String inputString()
	{
		return _OriginalString;
	}
	public String toEncodedString()
	{
		return _middleString;
	}
	/*
	public String toStringtoBeWritteninFile()
	{
		String result;
		while (_middleString.length() %8 != 0)
			_middleString =_middleString
			
		
	}
	*/
	
	public String toDecodedString()
	{
		return _outString;
	}
	public String addDir(){
	    String result ="";
	    for(int i=0;i<dicIn.size();i++){
	        result = result + dicIn.get(i);
	    }
	    return result;
	}
	private void encode()
	{
		//System.out.println("Comecando a encodar!");
		
		int j = 0;
		int k = 0;
		_middleString = addDir();
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
			
			//System.out.println("Sequencia ateh agora:" + _middleString);
			
			
			//printDicIn();
			
			
			if (dicIn.size() == 100)
			{
				makeDic();
				_middleString = _middleString + c;

				if (k < _inString.length())
					_inString = _inString.substring(k);
				else _inString = "";
				
				j = 0;
				k = 0;
				s = "";
				S = "";
				c = "";
				
				
				//System.out.println("_inString = " + _inString);
			}
			
			
		} 
		//System.out.println("k = " + k);

		_middleString = _middleString + _inString.charAt( _inString.length() - 1 );
		
		//System.out.println(_middleString);
		//printDic();
	}
	public String makeOutDic(String pre){
		dicOut.add("");
		boolean flagEnd = false;
		while(flagEnd==false){
		  if((pre.charAt(0)=='0'||pre.charAt(0)=='1')&&(pre.charAt(1)=='0'||pre.charAt(1)=='1')){
		     if(pre.charAt(2)=='0'||pre.charAt(2)=='1'){
		         flagEnd=true;
		     } else {
		         dicOut.add(""+pre.charAt(0));
		         dicOut.add(""+pre.charAt(1));
		         pre = pre.substring(2);
		     }
		  }else{
			    dicOut.add(""+pre.charAt(0));
			    pre = pre.substring(1);
		  }
		}
		return pre;
	}
	
	public void decode()
	{
	    
	    int e = 0;
	    String codedString = _middleString;
	    String actualString = "";
	    String currentString = "";
	    _outString = "";
	    boolean endFlag = false;
	    //boolean pegar_o_ultimo = true;
        codedString = makeOutDic(codedString);
        int i = dicOut.size();

	    while (codedString.length()>0 && !endFlag)
	    {
	        int ends = getB(i);
	        if(ends>codedString.length()-1)
	           ends = codedString.length()-1;
	        actualString = codedString.substring(0,ends);
	        codedString = codedString.substring(ends);
	        e = Integer.parseInt(actualString, 2);
	        if (e>0){
	            if (e < dicOut.size()){
    	        	_outString = _outString + dicOut.get(e);
    	        	if (!dicOut.contains(currentString + dicOut.get(e).charAt(0) )){
    	        		dicOut.add(currentString + dicOut.get(e).charAt(0) );
    	        	}
    	        	currentString = dicOut.get(e);
    	        }
    	        else {
    	        	dicOut.add(currentString + currentString.charAt(0));
    	        	currentString = currentString + currentString.charAt(0);
    	        	_outString = _outString + currentString;
    	        }  
	        }

            //Inicio duvida merge, isto fica?
	        
	        if (codedString.charAt(0) != '0' && codedString.charAt(0) != '1')
	        {
	        	_outString = _outString + codedString.charAt(0);
	        	codedString = codedString.substring(1);
	        	makeDic();
	        	dicOut=dicIn;
	        	actualString = "";
	        	currentString = "";
	        	i = dicOut.size();
	        	e = 0;

	        }
	        else i++;
	        // Fim duvida merge
	        if(codedString.substring(0).length() < getB(i+1)) 
	        	endFlag = true;
	        //i++;
	    }
	    _outString = _outString + codedString;
	}
	
	
	public String prettyBinary(int value,int chars)
	{
	    String result = Integer.toString(value,2);
	    while (result.length()<chars){
	       result = "0"+result;
        }
	    return result;
	}
	
	
	public int getB(int i)
	{
		int b = 1;
		while(Math.pow(2,(b))<i)
			b++;
		return b;
	}
	public void printDic()
	{
	    for (int i = 0; i < dicIn.size(); i++)
	    {
			System.out.println(i + " : " + dicIn.get(i));
		}
	}
	
	public void makeDic()
	{
		int i;
		dicIn = new ArrayList<String>();
		
		dicIn.add("");
		for (i = 0; i < _OriginalString.length(); i++)
		{
			if (  !dicIn.contains(""+_OriginalString.charAt(i)))
			{
			    dicIn.add("" + _OriginalString.charAt(i) );
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
	
	public void printDicIn()
	{
	    System.out.println("Dicionário de Entrada:");
		for (int i = 0; i < dicIn.size(); i++){
			System.out.println(i + " : " + dicIn.get(i));
		}
	}
	
	public boolean isAtDir(String S)
	{
		return dicIn.contains(S);
	}
}



