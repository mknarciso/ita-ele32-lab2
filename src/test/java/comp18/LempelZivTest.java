package comp18;

import static org.junit.Assert.*;

import java.io.IOException;
//import org.junit.Before;
import org.junit.Test;

public class LempelZivTest {
	LempelZiv first = new LempelZiv("abcbababcbcabac");
	LempelZiv second = new LempelZiv("Isto é um teste, muito legal este teste!");
	LempelZiv third = new LempelZiv("ababa");
	LempelZiv fourth = new LempelZiv("abababa");
	LempelZiv fifth = new LempelZiv("ababababa");
	LempelZiv sixth = new LempelZiv("abababababa");
	LempelZiv seventh = new LempelZiv("ababababababa");
	LempelZiv eighth = new LempelZiv("ababababababab");
	LempelZiv ninth = new LempelZiv("Qualquer whatever da COMP ITA!");
	LempelZiv tenth = new LempelZiv("Estamos usando o TDD para descobrir se este programa funciona.");
	LempelZiv eleventh = new LempelZiv ("Σημείωση: Το κείμενο έχει γραφεί σχεδόν χωρίς καθόλου τόνους, οπότε ο τονισμός είναι δικός μου. Αν θεωρείτε ότι η μουσικότητα του κειμένου έχει βλαφθεί, παρακαλώ τονίστε το αλλού.  Οι αριθμοί των γραμμών δεν είναι πάντοτε στη σωστή σειρά τους πχ. 409, 618, και μερικές φορές αναγράφονται 2 σε μια γραμμή π.χ. 89-91. Προφανώς ο μεταφραστής έχει ανακατατάξει τις γραμμές του πρωτοτύπου. Η Ραψωδία Ν (η μάχη στα πλοία) δεν έχει μεταφραστεί.");
	LempelZiv clean = new LempelZiv();

	@Test
	public void TestReadFile() throws IOException{
	    try{ 
	    clean.addFileToEncode("testeIn.txt");
	    //clean.decode();
	    assertEquals("Isto é um teste para abrir arquivos.\n\n\"Σημείωση: Το κείμενο έχει γραφεί σχεδόν χωρίς καθόλου τόνους, οπότε ο τονισμός είναι δικός μου. Αν θεωρείτε ότι η μουσικότητα του κειμένου έχει βλαφθεί, παρακαλώ τονίστε το αλλού.  Οι αριθμοί των γραμμών δεν είναι πάντοτε στη σωστή σειρά τους πχ. 409, 618, και μερικές φορές αναγράφονται 2 σε μια γραμμή π.χ. 89-91. Προφανώς ο μεταφραστής έχει ανακατατάξει τις γραμμές του πρωτοτύπου. Η Ραψωδία Ν (η μάχη στα πλοία) δεν έχει μεταφραστεί.\");\n",clean.inputString());
		}catch(IOException e){
            e.printStackTrace();
        }
	}
	@Test
	public void TestReadFileToEncode() throws IOException{
	    try{ 
	    clean.addFileToEncode("testeIn.txt");
	    //System.out.println("String padrao:");
	    //System.out.println(clean.toEncodedString());
	    clean.decode();
	    
	    assertEquals("Isto é um teste para abrir arquivos.\n\n\"Σημείωση: Το κείμενο έχει γραφεί σχεδόν χωρίς καθόλου τόνους, οπότε ο τονισμός είναι δικός μου. Αν θεωρείτε ότι η μουσικότητα του κειμένου έχει βλαφθεί, παρακαλώ τονίστε το αλλού.  Οι αριθμοί των γραμμών δεν είναι πάντοτε στη σωστή σειρά τους πχ. 409, 618, και μερικές φορές αναγράφονται 2 σε μια γραμμή π.χ. 89-91. Προφανώς ο μεταφραστής έχει ανακατατάξει τις γραμμές του πρωτοτύπου. Η Ραψωδία Ν (η μάχη στα πλοία) δεν έχει μεταφραστεί.\");\n",clean.toDecodedString());
		}catch(IOException e){
            e.printStackTrace();
        }
	}
	@Test
	public void TestReadFileToByte() throws IOException{
	    try{ 
	    clean.addFileToEncode("testeIn.txt");
	    clean.toByte();
	    //clean.printBytes();
	    clean.saveByteFile("testeOut.dat");
	    //assertEquals("Isto é um teste para abrir arquivos.\n\n\"Σημείωση: Το κείμενο έχει γραφεί σχεδόν χωρίς καθόλου τόνους, οπότε ο τονισμός είναι δικός μου. Αν θεωρείτε ότι η μουσικότητα του κειμένου έχει βλαφθεί, παρακαλώ τονίστε το αλλού.  Οι αριθμοί των γραμμών δεν είναι πάντοτε στη σωστή σειρά τους πχ. 409, 618, και μερικές φορές αναγράφονται 2 σε μια γραμμή π.χ. 89-91. Προφανώς ο μεταφραστής έχει ανακατατάξει τις γραμμές του πρωτοτύπου. Η Ραψωδία Ν (η μάχη στα πλοία) δεν έχει μεταφραστεί.\");\n",clean.toDecodedString());
		}catch(IOException e){
            e.printStackTrace();
        }
    }
	@Test
	public void TestReadFromByteFile() throws IOException{
	    try{ 
	    clean.addFileToDecode("testeOut.dat");
	    //clean.printBytes();
	    }catch(IOException e){
            e.printStackTrace();
        }
    }
   /* @Test
	public void TestDecodingMiddleString() throws IOException{
	    try{ 
	    clean.addFileToDecode("testeOut.dat");
	    //clean.printBytes();
	    clean.fromByte();
	    String out = clean.toEncodedString();
	    System.out.println(out);
	    //clean.decode();
	    assertEquals("Isto éumeparbiqv.\n\"Σημείωσ:Τοκνέχιγραφδόςθλυτ,πΑβώύΟάή4096182-ΠξΗΡψΝ();0000001000001000000110000100000010100001100000101000011100010000000101000001100010011001001000100100001010001010000101100011000001011000010100010110001101000110000011100001100101101100011000001111u0001110001000000001000000010001000100100100010010001001100101000010101001011000101110011000001100100110100010101001101100001010011100001110100001010011110101001110100100011111101101101000000100001ε0100010000010101000110100100010010101001100010111001100000001010011010010000100101110100111010100000111110000101010000100110010100100001100001010010000101001111001001010101010010100001010110011101υ0000101010110101010000011111001110101011000101001010111000001010011101010111101010000101101001011110100001001000001110100111110100010001101000101100101000010100100001010010111001100000111110100101ι000010101001110100010001111001010000101001000010100101100011101010110000100010000101011000000111110000101010101000101110011001010010000101110011000010110100101110000101010100001011010100100000101η0000101001011000111010101100001101001000100011110010100001011010010101010110101001010000101010110110010100000101001111000101110100010001011001000000011111101011001000000100001101100100001010110001λ0100101010011001010100010111001100001011100000101010111101001010100100010010100111100100101010101101100100000101010110100111010011111001100000110100101101001011110101110011101000010110101000101011ο0110011001000100001010000101011010001000100000101010010101001000100010010101000101100011101001100000001010101101001100100111110000101010001101001000100101001011000101100110010101100101001110010111ν0000101001011100110000011111010010101000100000101010111101101010011111010110100111010101101001011100001010011010010110100101011010110001100110101110110110101011000101110100010010010001101010000101τ0011101010110001010010000101010111101000010010001000010101101110111000011100101011100000101011101001110110111100101001100111100100101010001000001010010110001011101001000100010001111001000001001010φ001110101001000100000010100000010101001010011111010010101000110100100011010101001100011101001111101011010100101010001000001010111101000010100110100010111000010100101100100010010010100001011010000α0010110001011001101100000101010111100100010100001001000100001010111100011100101111100111001011101110011110111111010010000111010100110010010100111110110010010100100001010011101000010100101100010111τ0100101010011001001000100101001101001011010110110010100100001010100000010000100101110100010000010101001010011111010010100111100100101010110110110100110101100000010100110000101010110101000101001111γ0100100010010100101100010110010000001010010000101010110100111010101100000010101011110100100001100110011110101101011001101011111010000001000100001011000001000010110000100100101100001100110010100111ί0100101000010110001000000101100010100101010000101001011001101010100001100110100110100101101100100001011110101011001110100110000100101100011000001010100111001011100111110000101010000001000010010111ι000010100101100010111010110101001010100110010010001001010011010010101001011100110000010001001001110001101000111\n",out);
		}catch(IOException e){
            e.printStackTrace();
        }
    }*/
    @Test
	public void TestDecoding() throws IOException{
	    try{ 
	    clean.addFileToDecode("testeOut.dat");
	    //clean.printBytes();
	    clean.fromByte();
	    //System.out.println(clean.toEncodedString());
	    clean.decode();
	    assertEquals("Isto é um teste para abrir arquivos.\n\n\"Σημείωση: Το κείμενο έχει γραφεί σχεδόν χωρίς καθόλου τόνους, οπότε ο τονισμός είναι δικός μου. Αν θεωρείτε ότι η μουσικότητα του κειμένου έχει βλαφθεί, παρακαλώ τονίστε το αλλού.  Οι αριθμοί των γραμμών δεν είναι πάντοτε στη σωστή σειρά τους πχ. 409, 618, και μερικές φορές αναγράφονται 2 σε μια γραμμή π.χ. 89-91. Προφανώς ο μεταφραστής έχει ανακατατάξει τις γραμμές του πρωτοτύπου. Η Ραψωδία Ν (η μάχη στα πλοία) δεν έχει μεταφραστεί.\");\n",clean.toDecodedString());
		clean.decodeFile("testeOutput.txt");
		}catch(IOException e){
            e.printStackTrace();
        }
    }
	@Test
	public void EncryptTrial() {
	    //first.toByte();
	    //first.printBytes();
		assertEquals("abc010100110101000100011000111000c",first.toEncodedString());
		}
	@Test
	public void DecryptTrial() {
	    first.decode();
		assertEquals("abcbababcbcabac",first.toDecodedString());
	}
	@Test
	public void DecryptTrial2() {
	    second.decode();
	    //System.out.println(second.toEncodedString());
		assertEquals("Isto é um teste, muito legal este teste!",second.toDecodedString());
	}	
	@Test
	public void DecryptTrial3() {
	    third.decode();
		assertEquals("ababa",third.toDecodedString());
	}
	
	@Test
	public void DecryptTrial4() {
	    fourth.decode();
		assertEquals("abababa",fourth.toDecodedString());
	}
	@Test
	public void DecryptTrial5() {
	    fifth.decode();
		assertEquals("ababababa",fifth.toDecodedString());
	}
	@Test
	public void DecryptTrial6() {
	    sixth.decode();
		assertEquals("abababababa",sixth.toDecodedString());
	}
	@Test
	public void DecryptTrial7() {
	    seventh.decode();
		assertEquals("ababababababa",seventh.toDecodedString());
	}
	
	@Test
	public void DecryptTrial8() {
	    eighth.decode();
		assertEquals("ababababababab",eighth.toDecodedString());
	}
	
	@Test
	public void DecryptTrial9() {
	    ninth.decode();
		assertEquals("Qualquer whatever da COMP ITA!",ninth.toDecodedString());
	}
	
	@Test
	public void DecryptTrial10() {
	    tenth.decode();
		assertEquals("Estamos usando o TDD para descobrir se este programa funciona.",tenth.toDecodedString());
	}
	@Test
	public void DecryptTrial11(){
	    eleventh.decode();
	    assertEquals("Σημείωση: Το κείμενο έχει γραφεί σχεδόν χωρίς καθόλου τόνους, οπότε ο τονισμός είναι δικός μου. Αν θεωρείτε ότι η μουσικότητα του κειμένου έχει βλαφθεί, παρακαλώ τονίστε το αλλού.  Οι αριθμοί των γραμμών δεν είναι πάντοτε στη σωστή σειρά τους πχ. 409, 618, και μερικές φορές αναγράφονται 2 σε μια γραμμή π.χ. 89-91. Προφανώς ο μεταφραστής έχει ανακατατάξει τις γραμμές του πρωτοτύπου. Η Ραψωδία Ν (η μάχη στα πλοία) δεν έχει μεταφραστεί.",eleventh.toDecodedString());
	
	}
	@Test
	public void TestGetB(){
		assertEquals(2,first.getB(3));
		assertEquals(2,first.getB(4));
		assertEquals(3,first.getB(5));
		assertEquals(3,first.getB(8));
		assertEquals(4,first.getB(9));
		assertEquals(8,first.getB(255));
		assertEquals(10,first.getB(1024));
	}
	@Test
	public void TestDir(){
		assertEquals(13,first.dicIn.size());
	}
	@Test
	public void isAtDir(){
		assertTrue(first.isAtDir("a"));
		assertTrue(first.isAtDir("b"));
		assertTrue(first.isAtDir("c"));
		assertFalse(first.isAtDir("d"));
	}
}