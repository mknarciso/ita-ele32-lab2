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
	/*@Before
	public void Setup(){
		 first = new LempelZiv("abcbababcbcabac");
		 second = new LempelZiv("Isto é um teste, muito legal este teste!");
		 third = new LempelZiv("abababa");
	}*/
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
	    System.out.println(clean.toEncodedString());
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
    @Test
	public void TestDecoding() throws IOException{
	    try{ 
	    clean.addFileToDecode("testeOut.dat");
	    //clean.printBytes();
	    clean.fromByte();
	    System.out.println(clean.toEncodedString());
	    clean.decode();
	    assertEquals("Isto é um teste para abrir arquivos.\n\n\"Σημείωση: Το κείμενο έχει γραφεί σχεδόν χωρίς καθόλου τόνους, οπότε ο τονισμός είναι δικός μου. Αν θεωρείτε ότι η μουσικότητα του κειμένου έχει βλαφθεί, παρακαλώ τονίστε το αλλού.  Οι αριθμοί των γραμμών δεν είναι πάντοτε στη σωστή σειρά τους πχ. 409, 618, και μερικές φορές αναγράφονται 2 σε μια γραμμή π.χ. 89-91. Προφανώς ο μεταφραστής έχει ανακατατάξει τις γραμμές του πρωτοτύπου. Η Ραψωδία Ν (η μάχη στα πλοία) δεν έχει μεταφραστεί.\");\n",clean.toDecodedString());
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